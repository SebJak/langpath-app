package com.langpath.app.commands.user;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.enums.Status;
import com.langpath.app.model.storage.User;
import com.langpath.app.repository.api.UserRepository;
import com.langpath.app.validator.Validation;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;

import static com.langpath.app.model.enums.Status.ERROR;
import static com.langpath.app.model.enums.Status.OK;

/**
 * Created by root on 21.10.16.
 */
public class RegisterUserCommand implements CommandService<User> {

    @Inject
    private Logger logger;

    @Inject
    @Named("registerUserValidator")
    Validation<User> validator;

    @Inject
    @Named("userRepository")
    UserRepository userRepository;

    @Override
    public int command(User input) {
        logger.info("Register new user.");
        if (validator.validate(input)) {
                userRepository.saveOne(input);
            return OK.getCode();
        }
        return ERROR.getCode();
    }
}
