package com.langpath.app;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.langpath.app.api.UserResources;
import com.langpath.app.api.WordGroupResource;
import com.langpath.app.modules.AppModule;

import static spark.Spark.staticFileLocation;

/**
 * Created by root on 17.10.16.
 */


public class LangpathBootstrap {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
        staticFileLocation("/html/");
        UserResources userResources = injector.getInstance(UserResources.class);
        WordGroupResource wordGroupResource = injector.getInstance(WordGroupResource.class);
    }
}
