package com.langpath.app.commands.wordgroup;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.command.LearningReport;
import com.langpath.app.validator.Validation;
import org.mongodb.morphia.Datastore;

import java.util.Date;

import static com.langpath.app.model.enums.Status.ERROR;
import static com.langpath.app.model.enums.Status.OK;

public class FinishLearnignWordGroupCommand implements CommandService<LearningReport> {

    @Inject
    @Named("finishLearningValidator")
    private Validation<LearningReport> validator;

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Override
    public int command(LearningReport input) {
        if(validator.validate(input)) {
            WordGroup wordGroup = datastore.createQuery(WordGroup.class).filter("id ==", input.getWordGroupId()).get();
            wordGroup.increaseCountOfRepetition(1);
            wordGroup.setLastActive(new Date());
            wordGroup.increaseTimeOfLearning(input.getTimeOfLearning());
            return OK.getCode();
        }
        return ERROR.getCode();
    }
}
