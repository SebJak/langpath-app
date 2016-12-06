package com.langpath.app.repository;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

public abstract class AbstractDAO<T>{

    @Inject
    @Named("datastore")
    Datastore datastore;

    public void saveOne(T entity) {
        datastore.save(entity);
    }

    T findOne(Class classType, ObjectId id) {
        return (T) datastore.get(classType, id);
    }
}
