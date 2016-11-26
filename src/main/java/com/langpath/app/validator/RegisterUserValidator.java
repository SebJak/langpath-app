package com.langpath.app.validator;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.User;
import com.langpath.app.repository.api.UserRepository;
import org.apache.log4j.Logger;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

/**
 * Created by root on 21.10.16.
 */

public class RegisterUserValidator implements Validation<User> {

    @Inject
    private Logger logger;

    @Inject
    @Named("userRepository")
    private UserRepository userRepository;

    @Override
    public boolean validate(final User input) {
        logger.info("Validating the register user.");
        try {
            if (isNoneBlank(input.getEmail())) {
                return userRepository.findByEmail(input.getEmail()) == null;
            }
        }
        catch (Exception ex) {
            logger.error("During validation New user throw exception.", ex);
        }
        return false;
    }
}
