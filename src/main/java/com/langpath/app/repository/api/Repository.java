package com.langpath.app.repository.api;

import org.bson.types.ObjectId;

public interface Repository <T> {
    void saveOne(final T object);

    T findOne(final ObjectId id);
}
