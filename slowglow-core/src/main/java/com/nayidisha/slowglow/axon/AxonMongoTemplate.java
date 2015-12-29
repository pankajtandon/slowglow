package com.nayidisha.slowglow.axon;

import javax.inject.Inject;

import org.axonframework.eventstore.mongo.MongoTemplate;
import org.springframework.data.mongodb.MongoDbFactory;

import com.mongodb.DBCollection;

public class AxonMongoTemplate implements MongoTemplate {
    private static final String DEFAULT_DOMAINEVENTS_COLLECTION = "domainevents";
    private static final String DEFAULT_SNAPSHOTEVENTS_COLLECTION = "snapshotevents";

    private final String domainEventsCollectionName;
    private final String snapshotEventsCollectionName;

    private final MongoDbFactory mongoDbFactory;
    private final org.springframework.data.mongodb.core.MongoTemplate mongoTemplate;

    @Inject
    public AxonMongoTemplate(MongoDbFactory mongoDbFactory) {
        this.mongoDbFactory = mongoDbFactory;
        this.mongoTemplate = new org.springframework.data.mongodb.core.MongoTemplate(mongoDbFactory);

        domainEventsCollectionName = DEFAULT_DOMAINEVENTS_COLLECTION;
        snapshotEventsCollectionName = DEFAULT_SNAPSHOTEVENTS_COLLECTION;
    }

    @Override
    public DBCollection domainEventCollection() {
        return mongoTemplate.getCollection(domainEventsCollectionName);
    }

    @Override
    public DBCollection snapshotEventCollection() {
        return mongoTemplate.getCollection(snapshotEventsCollectionName);
    }
}
