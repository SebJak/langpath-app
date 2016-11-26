package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

/**
 * Created by root on 20.10.16.
 */
public class MongoDbModule extends AbstractModule{

    private final Datastore datastore;

    public MongoDbModule() {
        MongoClient client = new MongoClient();
        Morphia morphia = new Morphia();
        morphia.mapPackage("com.langpath.app.model.storage");
        datastore = morphia.createDatastore(client, "test");
    }

    @Override
    protected void configure() {

    }

    @Provides
    @Named("datastore")
    public Datastore getDatastore() {
        return datastore;
    }
}
