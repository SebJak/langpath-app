package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.command.LearningReport;
import com.langpath.app.model.command.LoginCredential;
import com.langpath.app.model.storage.User;
import com.langpath.app.validator.*;

/**
 * Created by root on 22.10.16.
 */
public class ValidatorsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(new TypeLiteral<Validation<LoginCredential>>(){}).annotatedWith(Names.named("loginCredentialValidator")).to(LoginUserValidator.class);
        bind(new TypeLiteral<Validation<User>>(){}).annotatedWith(Names.named("registerUserValidator")).to(RegisterUserValidator.class);
        bind(new TypeLiteral<Validation<WordGroup>>(){}).annotatedWith(Names.named("wordGroupValidator")).to(WordGroupValidator.class);
        bind(new TypeLiteral<Validation<LearningReport>>(){}).annotatedWith(Names.named("finishLearningValidator")).to(FinishLearningValidator.class);
    }
}
