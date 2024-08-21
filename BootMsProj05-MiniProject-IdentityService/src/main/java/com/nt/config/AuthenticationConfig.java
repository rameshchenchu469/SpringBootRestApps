package com.nt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import com.nt.dto.RsaKeyConfigurationProperties;
import com.nt.service.CustomUserDetailsService;

@Configuration
//@EnableMethodSecurity
public class AuthenticationConfig {
	
	@Autowired
	private CustomUserDetailsService userDetailsService;
	
	@Autowired
	private RsaKeyConfigurationProperties rsaKeyConfigurationProperties;
	
	
    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public AuthenticationManager authenticationManager() {
		var authenticationProvider=new DaoAuthenticationProvider();
		 authenticationProvider.setUserDetailsService(userDetailsService);
		 authenticationProvider.setPasswordEncoder(passwordEncoder());
		 return new ProviderManager(authenticationProvider);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http,HandlerMappingIntrospector interceptor)throws Exception{
		return http
				.csrf(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(auth->{
					auth.requestMatchers("user/signup","user/login","test/welcome","test/test1").permitAll();
				    auth.anyRequest().authenticated();
				})
				.sessionManagement(s->s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.oauth2ResourceServer(ouath2->ouath2.jwt((jwt)->jwt.decoder(jwtDecoder())))
			    .userDetailsService(userDetailsService)
			    .httpBasic(Customizer.withDefaults())
			    .build();
				
	}
	@Bean
	public JwtDecoder jwtDecoder() {
		return NimbusJwtDecoder.withPublicKey(rsaKeyConfigurationProperties.publicKey()).build();
		 
	}

	    @Bean
	    public  JwtEncoder jwtEncoder(){
	        JWK jwk = new RSAKey.Builder((rsaKeyConfigurationProperties.publicKey()))
	                     .privateKey(rsaKeyConfigurationProperties.privateKey()).build();
	        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet((jwk)));
	        return new NimbusJwtEncoder(jwks);
	    }

	    @Bean
	    public JwtAuthenticationConverter jwtAuthenticationConverter(){
	        JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
	        grantedAuthoritiesConverter.setAuthorityPrefix("");

	        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
	        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
	        return jwtAuthenticationConverter;
	    }
}
