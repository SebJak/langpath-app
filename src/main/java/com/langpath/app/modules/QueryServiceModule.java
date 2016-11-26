package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.langpath.app.model.command.LoginCredential;
import com.langpath.app.model.query.RequestObjectId;
import com.langpath.app.model.response.LoggedUser;
import com.langpath.app.model.response.UserInfo;
import com.langpath.app.model.response.WordGroupInfo;
import com.langpath.app.model.response.wordGroup.WordGroupForLearn;
import com.langpath.app.queries.FindUserWordGroupQuery;
import com.langpath.app.queries.GetWordsToLearnQuery;
import com.langpath.app.queries.QueryService;
import com.langpath.app.queries.user.LoginUserQuery;
import com.langpath.app.queries.user.UserInfoQuery;

import java.util.Collection;

public class QueryServiceModule extends AbstractModule{
    @Override
    protected void configure() {
        bind(new TypeLiteral<QueryService<RequestObjectId, Collection<WordGroupInfo>>>(){}).annotatedWith(Names.named("findUserWordGroupQuery")).to(FindUserWordGroupQuery.class);
        bind(new TypeLiteral<QueryService<LoginCredential, LoggedUser>>(){}).annotatedWith(Names.named("loginQuery")).to(LoginUserQuery.class);
        bind(new TypeLiteral<QueryService<RequestObjectId, UserInfo>>(){}).annotatedWith(Names.named("userInfoQuery")).to(UserInfoQuery.class);
        bind(new TypeLiteral<QueryService<RequestObjectId, WordGroupForLearn>>(){}).annotatedWith(Names.named("getWordsToLearnQuery")).to(GetWordsToLearnQuery.class);
    }
}
