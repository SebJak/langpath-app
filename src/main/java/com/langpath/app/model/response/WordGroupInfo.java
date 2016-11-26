package com.langpath.app.model.response;

import org.bson.types.ObjectId;

/**
 * Created by root on 20.10.16.
 */
public class WordGroupInfo {

    private String name;

    private ObjectId id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
