package com.langpath.app.validator;

import com.langpath.app.model.command.LoginCredential;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by root on 22.10.16.
 */
public class LoginUserValidator implements Validation<LoginCredential> {
    @Override
    public boolean validate(LoginCredential input) {

        return StringUtils.isNoneBlank(input.getEmail()) && StringUtils.isNoneBlank(input.getPassword());
    }
}
