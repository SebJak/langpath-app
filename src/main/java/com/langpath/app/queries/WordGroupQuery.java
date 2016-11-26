package com.langpath.app.queries;

import org.bson.types.ObjectId;

public class WordGroupQuery {

    private ObjectId wordGroupId;

    public ObjectId getWordGroupId() {
        return wordGroupId;
    }

    public void setWordGroupId(ObjectId wordGroupId) {
        this.wordGroupId = wordGroupId;
    }
}
