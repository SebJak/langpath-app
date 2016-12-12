package com.langpath.app.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource("app.properties").getFile());

            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            install(new MongoDbModule(properties.getProperty("mongo.host"), Integer.parseInt(properties.getProperty("mongo.port"))));
            install(new ValidatorsModule());
            install(new CommandsModule());
            install(new QueryServiceModule());
            install(new RepositoryModule());
        }
        catch (IOException e) {
            logger.error("Error during initialization, ", e);
        }
    }

    @Provides
    public Logger getLogger() {
        return logger;
    }
}
