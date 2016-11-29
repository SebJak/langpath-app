package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import com.langpath.app.repository.UserRepositoryImpl;
import com.langpath.app.repository.WordGroupRepositoryImpl;
import com.langpath.app.repository.api.UserRepository;
import com.langpath.app.repository.api.WordGroupRepository;

public class RepositoryModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(UserRepository.class).annotatedWith(Names.named("userRepository")).to(UserRepositoryImpl.class);
        bind(WordGroupRepository.class).annotatedWith(Names.named("wordGroupRepository")).to(WordGroupRepositoryImpl.class);
    }
}
