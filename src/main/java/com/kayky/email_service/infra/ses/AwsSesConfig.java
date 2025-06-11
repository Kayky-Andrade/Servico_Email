package com.kayky.email_service.infra.ses;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;

@Configuration
@EnableConfigurationProperties(AwsSesConfig.Properties.class)
public class AwsSesConfig {

    @Bean
    public AmazonSimpleEmailService amazonSimpleEmailService(Properties props){
        BasicAWSCredentials creds =
            new BasicAWSCredentials(props.getAccessKeyId(), props.getSecretKey());

        return AmazonSimpleEmailServiceClientBuilder.standard()
            // põe a região que vem do application.properties
            .withRegion(props.getRegion())
            // configura as credenciais que vêm do application.properties
            .withCredentials(new AWSStaticCredentialsProvider(creds))
            .build();
    }

    @ConfigurationProperties(prefix = "aws")
    public static class Properties {
        private String accessKeyId;
        private String secretKey;
        private String region;
        public String getAccessKeyId() {
            return accessKeyId;
        }
        public void setAccessKeyId(String accessKeyId) {
            this.accessKeyId = accessKeyId;
        }
        public String getSecretKey() {
            return secretKey;
        }
        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }
        public String getRegion() {
            return region;
        }
        public void setRegion(String region) {
            this.region = region;
        }

        
       
    }
}