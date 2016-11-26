package com.langpath.app.model.enums;

/**
 * Created by root on 21.10.16.
 */
public enum Status {

    OK(200),
    ERROR(500),
    UNAUTHORIZED(401),
    VALIDATION_ERROR(5); //todo CHANGE THE STATUS CODE

    private final int code;

    Status(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
