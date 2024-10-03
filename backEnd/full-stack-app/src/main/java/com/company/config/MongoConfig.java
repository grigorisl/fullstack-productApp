package com.company.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;

@Configuration
public class MongoConfig {
	
	
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate((MongoClient) mongoClient(), "your_database_name");
    }

    public MongoClientFactoryBean mongoClient() {
        MongoClientFactoryBean mongoClient = new MongoClientFactoryBean();
        mongoClient.setHost("localhost"); // Your MongoDB host
        mongoClient.setPort(27017); // Your MongoDB port
        return mongoClient;
    }

}
