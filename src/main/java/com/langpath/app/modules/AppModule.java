package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.log4j.Logger;

/**
 * Created by root on 20.10.16.
 */
public class AppModule extends AbstractModule{

    private final Logger logger;

    public AppModule() {
        logger = Logger.getLogger("Langpath");
    }

    @Override
    protected void configure() {
        install(new MongoDbModule());
        install(new ValidatorsModule());
        install(new CommandsModule());
        install(new QueryServiceModule());
        install(new RepositoryModule());
    }

    @Provides
    public Logger getLogger() {
        return logger;
    }
}
