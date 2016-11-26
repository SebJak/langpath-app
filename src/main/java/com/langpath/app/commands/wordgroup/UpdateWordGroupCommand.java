package com.langpath.app.commands.wordgroup;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.validator.Validation;
import org.mongodb.morphia.Datastore;

import  static com.langpath.app.model.enums.Status.*;


/**
 * Created by root on 21.10.16.
 */
public class UpdateWordGroupCommand implements CommandService<WordGroup> {

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Inject
    @Named("wordGroupValidator")
    private Validation<WordGroup> wordGroupValidator;

    @Override
    public int command(WordGroup wordGroup) {
        if(wordGroupValidator.validate(wordGroup)) {
            datastore.merge(wordGroup);
            return OK.getCode();
        }
        return ERROR.getCode();
    }
}
