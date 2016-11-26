package com.langpath.app.validator.access;

public interface AccessCheck <T> {

    T checkAccessToData(T data);
}
