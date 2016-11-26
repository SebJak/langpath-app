package com.langpath.app.model.response;

import com.langpath.app.model.enums.Status;

public class CommandResponse {

    private Status status;

    public CommandResponse(Status status) {
        this.status = status;
    }

    public Status getStatus() {

        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
