package com.nayidisha.slowglow.config;

import javax.inject.Inject;

import org.jasypt.digest.StandardStringDigester;
import org.jasypt.digest.config.EnvironmentStringDigesterConfig;
import org.jasypt.encryption.pbe.StandardPBEBigDecimalEncryptor;
import org.jasypt.encryption.pbe.StandardPBEBigIntegerEncryptor;
import org.jasypt.encryption.pbe.StandardPBEByteEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;
import org.jasypt.salt.RandomSaltGenerator;
import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class EncryptionConfig {

    @Inject
    private Environment environment;

    @Bean
    public StrongPasswordEncryptor strongPasswordEncryptor() {
        return new StrongPasswordEncryptor();
    }

    @Bean
    public RandomSaltGenerator randomSaltGenerator() {
        return new RandomSaltGenerator();
    }

    @Bean
    public StandardStringDigester standardStringDigester() {
        StandardStringDigester ssd = new StandardStringDigester();
        ssd.setConfig(environmentStringDigesterConfig());

        return ssd;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder pe = new PasswordEncoder();
        pe.setPasswordEncryptor(strongPasswordEncryptor());
        return pe;
    }

    @Bean
    public EnvironmentStringPBEConfig environmentStringPBEConfig() {
        EnvironmentStringPBEConfig config = new EnvironmentStringPBEConfig();
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setPasswordEnvName("PLATFORM_ENCRYPTION_PASSWORD");

        return config;
    }

    @Bean
    public EnvironmentStringDigesterConfig environmentStringDigesterConfig() {
        EnvironmentStringDigesterConfig esdc = new EnvironmentStringDigesterConfig();
        esdc.setAlgorithm("sha-1");
        esdc.setIterations(10000);
        esdc.setSaltGenerator(randomSaltGenerator());

        return esdc;
    }

    @Bean
    public StandardPBEStringEncryptor standardPBEStringEncryptor() {
        StandardPBEStringEncryptor sse = new StandardPBEStringEncryptor();
        sse.setConfig(environmentStringPBEConfig());

        return sse;
    }

    @Bean
    public StandardPBEByteEncryptor standardPBEByteEncryptor() {
        StandardPBEByteEncryptor sse = new StandardPBEByteEncryptor();
        sse.setConfig(environmentStringPBEConfig());
        sse.setSaltGenerator(randomSaltGenerator());
        sse.setKeyObtentionIterations(10000);

        return sse;
    }

    @Bean
    public StandardPBEBigDecimalEncryptor standardPBEBigDecimalEncryptor() {
        StandardPBEBigDecimalEncryptor sse = new StandardPBEBigDecimalEncryptor();
        sse.setConfig(environmentStringPBEConfig());

        return sse;
    }

    @Bean
    public StandardPBEBigIntegerEncryptor standardPBEBigIntegerEncryptor() {
        StandardPBEBigIntegerEncryptor sse = new StandardPBEBigIntegerEncryptor();
        sse.setConfig(environmentStringPBEConfig());

        return sse;
    }

}