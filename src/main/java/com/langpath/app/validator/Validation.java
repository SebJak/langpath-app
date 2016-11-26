package com.langpath.app.validator;

/**
 * Created by root on 21.10.16.
 */
public interface Validation <T> {

    boolean validate(T input);
}
