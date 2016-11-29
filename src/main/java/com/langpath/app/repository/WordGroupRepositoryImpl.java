package com.langpath.app.repository;

import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.repository.api.WordGroupRepository;
import org.bson.types.ObjectId;

public class WordGroupRepositoryImpl extends AbstractDAO<WordGroup> implements WordGroupRepository {

    @Override
    public WordGroup findOne(ObjectId id) {
        return findOne(WordGroup.class, id);
    }
}
