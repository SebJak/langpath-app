package com.langpath.app.repository;

import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.repository.api.WordGroupRepository;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class WordGroupRepositoryImpl extends AbstractDAO<WordGroup> implements WordGroupRepository {

    @Override
    public WordGroup findOne(final ObjectId id) {
        return findOne(WordGroup.class, id);
    }

    private UpdateOperations<WordGroup> createIncreaseLearningTimeOperation(final Long value) {
        return datastore.createUpdateOperations(WordGroup.class).inc("timeOfLearning", value);
    }

    private UpdateOperations<WordGroup> createLastActiveOperation(final Date value) {
        return datastore.createUpdateOperations(WordGroup.class).set("lastActive", value);
    }

    private UpdateOperations<WordGroup> createIncreaseRepetitionOperation(final Long value) {
        return datastore.createUpdateOperations(WordGroup.class).inc("countOfRepetition", value);
    }


    @Override
    public void finishLearningUpdate(final String idHex, final Long learningTime, final Date finishTime) {
        Set<UpdateOperations<WordGroup>> operations = new HashSet<>();
        operations.add(createIncreaseLearningTimeOperation(learningTime));
        operations.add(createLastActiveOperation(finishTime));
        operations.add(createIncreaseRepetitionOperation(1l));
        runOperations(new ObjectId(idHex), operations);
    }

    private void runOperations(ObjectId id, Set<UpdateOperations<WordGroup>> operationsSet) {
        WordGroup entity = findOne(id);
        operationsSet.forEach(operation -> datastore.update(entity, operation));
    }
}
