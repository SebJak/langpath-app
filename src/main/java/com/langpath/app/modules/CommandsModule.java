package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import com.langpath.app.commands.CommandService;
import com.langpath.app.commands.user.RegisterUserCommand;
import com.langpath.app.commands.wordgroup.CreateWordGroupCommand;
import com.langpath.app.commands.wordgroup.UpdateWordGroupCommand;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.storage.User;

public class CommandsModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(new TypeLiteral<CommandService<WordGroup>>(){}).annotatedWith(Names.named("createWordGroupCommand")).to(CreateWordGroupCommand.class);
        bind(new TypeLiteral<CommandService<User>>(){}).annotatedWith(Names.named("registerUserCommand")).to(RegisterUserCommand.class);
        bind(new TypeLiteral<CommandService<WordGroup>>(){}).annotatedWith(Names.named("updateWordGroupCommand")).to(UpdateWordGroupCommand.class);

    }
}
