package com.langpath.app.validator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

/**
 * Created by root on 21.10.16.
 */

public class RegisterUserValidator implements Validation<User> {


    @Inject
    Logger logger;

    @Inject
    @Named("datastore")
    Datastore datastore;

    @Override
    public boolean validate(User input) {
        logger.info("Validating the register user.");
        try {
            if (isNoneBlank(input.getEmail())) {
                Query<User> userQuery = datastore.find(User.class, "email", input.getEmail());
                if (userQuery.get() == null) {
                    if (isNoneBlank(input.getPassword())) {
                        return true;
                    }
                }
            }
        }
        catch (Exception ex) {
            logger.error("During validation New user throw exception.");
        }
        return false;
    }
}
