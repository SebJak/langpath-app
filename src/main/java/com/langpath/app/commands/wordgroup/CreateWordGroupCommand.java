package com.langpath.app.commands.wordgroup;


import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.dao.WordGroupDAO;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.enums.Status;
import com.langpath.app.model.storage.User;
import com.langpath.app.validator.Validation;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;

import static com.langpath.app.model.enums.Status.*;
import static com.langpath.app.model.enums.Status.OK;
import static com.langpath.app.model.enums.Status.VALIDATION_ERROR;

/**
 * Created by root on 20.10.16.
 */
public class CreateWordGroupCommand implements CommandService<WordGroup> {

    @Inject
    private Logger logger;

    @Inject
    private WordGroupDAO wordGroupDAO;

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Inject
    @Named("wordGroupValidator")
    private Validation<WordGroup> createWordGroupValidator;

    @Override
    public int command(WordGroup input) {
        logger.info("Create word group command.");
        Status status = OK;
        if(createWordGroupValidator.validate(input)) {
            try {
                wordGroupDAO.save(input);
                User user = datastore.createQuery(User.class).filter("_id", input.getUserId()).get();
                user.addWordGroup(input.getId());
                datastore.merge(user);
            }
            catch (Exception ex) {
                logger.error("Some problem during saving the word group: " + input.toString()+ "\n", ex);
                status = ERROR;
            }
        }
        else {
            status = VALIDATION_ERROR;
        }
        return status.getCode();
    }
}
