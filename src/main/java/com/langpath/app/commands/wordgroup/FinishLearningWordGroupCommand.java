package com.langpath.app.commands.wordgroup;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.command.LearningReport;
import com.langpath.app.repository.api.Repository;
import com.langpath.app.repository.api.WordGroupRepository;
import com.langpath.app.validator.Validation;
import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import java.util.Date;
import java.util.Set;

import static com.langpath.app.model.enums.Status.ERROR;
import static com.langpath.app.model.enums.Status.OK;

public class FinishLearningWordGroupCommand implements CommandService<LearningReport> {

    @Inject
    @Named("finishLearningValidator")
    private Validation<LearningReport> validator;

    @Inject
    @Named("wordGroupRepository")
    private WordGroupRepository repository;

    @Override
    public int command(LearningReport input) {
        if(validator.validate(input)) {
            repository.finishLearningUpdate(input.getWordGroupId(), input.getTimeOfLearning(), new Date());
            return OK.getCode();
        }
        return ERROR.getCode();
    }
}
