package com.practice.practiceapi.config;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.client.RestTemplate;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager) {
        return new TransactionTemplate(transactionManager);
    }

    @Bean
    public SessionFactory sessionFactory() {
        Configuration configuration = new Configuration.Builder()
                .uri("neo4j+s://bedcd9e5.databases.neo4j.io:7687") // Change to your Neo4j instance URI
                .credentials("neo4j", "G0NJr1Y0I6H-E4hsms7XrMMN8VRqRJiUdk7aslHv7Ow") // Change to your Neo4j instance
                                                                                     // credentials
                .build();

        return new SessionFactory(configuration, "com.practice.practiceapi"); // Change to your domain package
    }
}
