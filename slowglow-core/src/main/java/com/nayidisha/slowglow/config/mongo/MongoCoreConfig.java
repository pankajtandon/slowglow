package com.nayidisha.slowglow.config.mongo;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.nayidisha.slowglow.mongo.DateCreatorMongoEventListener;

@Configuration
@EnableMongoRepositories("com.nayidisha.slowglow")
public class MongoCoreConfig {

    @Inject
    private MongoDbFactory mongoDbFactory;

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoDbFactory);
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public DateCreatorMongoEventListener dateCreatorMongoEventListener() {
        return new DateCreatorMongoEventListener();
    }
}
