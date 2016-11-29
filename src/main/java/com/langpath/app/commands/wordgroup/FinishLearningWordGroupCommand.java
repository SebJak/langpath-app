package com.langpath.app.commands.wordgroup;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.command.LearningReport;
import com.langpath.app.validator.Validation;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.Date;

import static com.langpath.app.model.enums.Status.ERROR;
import static com.langpath.app.model.enums.Status.OK;

public class FinishLearningWordGroupCommand implements CommandService<LearningReport> {

    @Inject
    @Named("finishLearningValidator")
    private Validation<LearningReport> validator;

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Override
    public int command(LearningReport input) {
        if(validator.validate(input)) {
            Query<WordGroup> wordGroup = datastore.createQuery(WordGroup.class).filter("_id", new ObjectId(input.getWordGroupId()));
            UpdateOperations<WordGroup> updateOperations = datastore.createUpdateOperations(WordGroup.class).inc("timeOfLearning", input.getTimeOfLearning()).set("lastActive", new Date()).inc("countOfRepetition");
            datastore.update(wordGroup, updateOperations);
            return OK.getCode();
        }
        return ERROR.getCode();
    }
}
