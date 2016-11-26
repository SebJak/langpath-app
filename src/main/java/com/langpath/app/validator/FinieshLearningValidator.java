package com.langpath.app.validator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.command.LearningReport;
import org.apache.commons.lang3.StringUtils;
import org.mongodb.morphia.Datastore;

public class FinieshLearningValidator implements Validation<LearningReport> {
    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Override
    public boolean validate(LearningReport input) {
        if(input.getTimeOfLearning()>0 && StringUtils.isNoneBlank(input.getWordGroupId())) {
            WordGroup wg = datastore.createQuery(WordGroup.class).filter("id ==", input.getWordGroupId()).get();
            if(wg!=null) {
                return true;
            }
        }
        return false;
    }
}
