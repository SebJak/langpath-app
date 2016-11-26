package com.langpath.app.repository;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.User;
import org.mongodb.morphia.Datastore;

public abstract class AbstractDAO<T>{

    @Inject
    @Named("datastore")
    Datastore datastore;

    public void saveOne(T entity) {
        datastore.save(entity);
    }
}
