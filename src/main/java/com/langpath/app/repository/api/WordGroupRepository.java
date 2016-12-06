package com.langpath.app.repository.api;

import com.langpath.app.model.storage.WordGroup;

import java.util.Date;

public interface WordGroupRepository extends Repository<WordGroup>{

    void finishLearningUpdate(final String idHex, final Long learningTime, final Date finishTime);

}
