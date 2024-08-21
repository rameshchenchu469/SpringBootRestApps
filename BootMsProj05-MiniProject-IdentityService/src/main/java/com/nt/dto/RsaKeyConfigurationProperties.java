package com.nt.dto;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix="rsa")
public record RsaKeyConfigurationProperties(RSAPublicKey publicKey,RSAPrivateKey privateKey) {

}
