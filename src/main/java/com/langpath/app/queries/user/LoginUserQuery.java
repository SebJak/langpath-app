package com.langpath.app.queries.user;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.command.LoginCredential;
import com.langpath.app.model.response.LoggedUser;
import com.langpath.app.model.storage.User;
import com.langpath.app.model.storage.UserSession;
import com.langpath.app.queries.QueryService;
import com.langpath.app.validator.Validation;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.Date;

/**
 * Created by root on 21.10.16.
 */
public class LoginUserQuery implements QueryService<LoginCredential, LoggedUser> {

    @Inject
    private Logger logger;

    @Inject
    @Named("loginCredentialValidator")
    private Validation<LoginCredential> loginCredentialValidator;

    @Inject @Named("datastore")
    private Datastore datastore;

    @Override
    public LoggedUser query(LoginCredential input) {
        logger.info("LoginUserQuery " + input.getEmail());
        LoggedUser loggedUser = new LoggedUser();
        if(loginCredentialValidator.validate(input)) {
            Query<User> userQuery = datastore.createQuery(User.class).filter("email", input.getEmail());
            if(userQuery.get() != null) {
                User user = userQuery.get();
                if(user.getPassword().equals(input.getPassword())) {
                    loggedUser.setFirstName(user.getFirstName());
                    loggedUser.setLastName(user.getLastName());
                    loggedUser.setId(user.getId());
                    loggedUser.setToken(generateToken(user.getId()));

                    UserSession session = new UserSession(user.getId(),loggedUser.getToken(),new Date());
                    datastore.save(session);
                }
            }
        }
        else{
            logger.warn("Input data not validated");
        }
        return loggedUser;
    }

    private String generateToken(ObjectId id) {
        return "generatedTokenForUser_"+id.toHexString();
    }
}
