package com.nt.dto;

import java.security.interfaces.RSAPublicKey;

import org.bouncycastle.asn1.pkcs.RSAPrivateKey;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="rsa")
public record RsaKeyConfigurationProperties(RSAPublicKey publicKey,RSAPrivateKey privateKey) {

}
