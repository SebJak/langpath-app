package com.langpath.app.dao;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.WordGroup;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

/**
 * Created by root on 20.10.16.
 */
public class WordGroupDAO extends BasicDAO<WordGroup, ObjectId> {

    @Inject
    public WordGroupDAO(@Named("datastore") Datastore ds) {
        super(ds);
    }
}
