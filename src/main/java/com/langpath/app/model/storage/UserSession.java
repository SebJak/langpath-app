package com.langpath.app.model.storage;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;

import java.util.Date;

@Entity
public class UserSession extends BaseType {

    @Indexed
    private ObjectId userId;

    private String sessionToken;

    private Date accessTime;

    public UserSession(ObjectId userId, String sessionToken, Date accessTime) {
        this.userId = userId;
        this.sessionToken = sessionToken;
        this.accessTime = accessTime;
    }

    public Date getAccessTime() {

        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
