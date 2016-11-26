package com.langpath.app.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.query.RequestObjectId;
import com.langpath.app.model.response.LoggedUser;
import com.langpath.app.model.response.UserInfo;
import com.langpath.app.queries.QueryService;
import com.langpath.app.queries.user.LoginUserQuery;
import com.langpath.app.commands.user.RegisterUserCommand;
import com.langpath.app.model.storage.User;
import com.langpath.app.model.command.LoginCredential;
import com.langpath.app.utils.JsonUtil;
import org.apache.log4j.Logger;

import static com.langpath.app.utils.JsonUtil.*;
import static spark.Spark.post;

/**
 * Created by root on 21.10.16.
 */
public class UserResources {

    private static final String API_CONTEXT = "langpath"; //FIXME inject this value

    @Inject
    private Logger logger;

    @Inject
    @Named("loginQuery")
    private QueryService<LoginCredential, LoggedUser> loginQuery;

    @Inject
    @Named("registerUserCommand")
    private CommandService<User> registerCommand;


    @Inject
    @Named("userInfoQuery")
    private QueryService<RequestObjectId, UserInfo> userInfoQuery;

    private final ObjectMapper mapper = new ObjectMapper();


    public UserResources() {
        System.out.println("User resource");
        setEndpoints();
    }

    private void setEndpoints() {
        post(API_CONTEXT + "/query/login", "application/json", (request, response) -> {
            logger.info("Login user "+ request.toString());
            LoginCredential login = mapper.readValue(request.body(), LoginCredential.class);
            return loginQuery.query(login);
        }, json());

        post(API_CONTEXT + "/register", "application/json", (request, response) -> {
            User user = mapper.readValue(request.body(), User.class);
            response.status(registerCommand.command(user));
            return response;
        });

        post(API_CONTEXT + "/query/userInfo", "application/json", (request, response) -> {
            RequestObjectId id = mapper.readValue(request.body(), RequestObjectId.class);
            return userInfoQuery.query(id);
        }, json());

    }
}
