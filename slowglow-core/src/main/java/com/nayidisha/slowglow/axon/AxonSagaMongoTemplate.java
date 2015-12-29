package com.nayidisha.slowglow.axon;

import org.axonframework.saga.repository.mongo.MongoTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.DBCollection;

public class AxonSagaMongoTemplate implements MongoTemplate {
    private static final String DEFAULT_SAGAS_COLLECTION_NAME = "sagas";
    private final String sagasCollectionName;

    private final MongoDbFactory mongoDbFactory;
    private final org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @Autowired
    public AxonSagaMongoTemplate(MongoDbFactory mongoDbFactory) {
        this.mongoDbFactory = mongoDbFactory;
        this.mongoTemplate = new org.springframework.data.mongodb.core.MongoTemplate(mongoDbFactory);

        this.sagasCollectionName = DEFAULT_SAGAS_COLLECTION_NAME;
    }

    @Override
    public DBCollection sagaCollection() {
        return mongoTemplate.getCollection(sagasCollectionName);
    }
}
