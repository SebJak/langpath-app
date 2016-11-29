package com.langpath.app.repository;

import com.google.common.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.User;
import com.langpath.app.model.storage.WordGroup;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import java.lang.reflect.Type;

public abstract class AbstractDAO<T>{

    @Inject
    @Named("datastore")
    Datastore datastore;

    private Class<T> type;

    public void saveOne(T entity) {
        datastore.save(entity);
    }

    T findOne(Class classType, ObjectId id) {
        return (T) datastore.get(classType, id);
    }
}
