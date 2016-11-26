package com.langpath.app.model.storage;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

/**
 * Created by root on 20.10.16.
 */

public abstract class BaseType {
    @Id
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }


}
