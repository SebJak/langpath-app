package com.langpath.app.repository.api;

import com.langpath.app.model.storage.WordGroup;
import org.bson.types.ObjectId;

public interface WordGroupRepository {

    WordGroup findOne(ObjectId id);
}
