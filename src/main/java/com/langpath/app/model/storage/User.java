package com.langpath.app.model.storage;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Indexed;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by root on 20.10.16.
 */
@Entity("Users")
public class User extends BaseType{

    private String firstName;

    private String lastName;

    @Indexed
    private String email;

    private String password;

    private Set<ObjectId> wordGroupIds;

    public String getFirstName() {
        return firstName;
    }

    public Set<ObjectId> getWordGroupIds() {
        return wordGroupIds;
    }

    public void setWordGroupIds(Set<ObjectId> wordGroupIds) {
        this.wordGroupIds = wordGroupIds;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void addWordGroup(ObjectId id) {
        if(wordGroupIds == null) {
            wordGroupIds = new HashSet<>();
        }
        wordGroupIds.add(id);
    }
}
