package com.nayidisha.slowglow.config.mongo;

import java.net.UnknownHostException;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;

@Configuration
//@Profile("mongodb-local")
@PropertySource(value = "classpath:mongodb-local.properties")
public class MongoLocalConfig {

    @Inject
    private Environment environment;

    @Bean
    public Mongo mongo() throws UnknownHostException {
        // location of db
        ServerAddress sa = new ServerAddress(
                environment.getProperty("mongodb.host"),
                environment.getProperty("mongodb.port", Integer.class)
                );

        // set optional default parameters here
        MongoClientOptions.Builder builder = MongoClientOptions.builder();

        // none yet

        MongoClientOptions options = builder.build();

        return new MongoClient(sa, options);
    }

    //Resurrect when the dust clears :)
    //@Bean(name = "mongoDbFactory")
    public SimpleMongoDbFactory mongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(mongo(), environment.getProperty("mongodb.database"));
    }

    @Bean(name = "axonMongoDbFactory")
    public SimpleMongoDbFactory axonMongoDbFactory() throws Exception {
        return mongoDbFactory();
    }
}
