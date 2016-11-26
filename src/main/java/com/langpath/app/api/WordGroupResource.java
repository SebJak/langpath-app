package com.langpath.app.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.commands.CommandService;
import com.langpath.app.model.response.wordGroup.WordGroupForLearn;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.query.RequestObjectId;
import com.langpath.app.model.response.WordGroupInfo;
import com.langpath.app.queries.QueryService;

import java.util.Collection;

import static com.langpath.app.utils.JsonUtil.*;
import static spark.Spark.post;

public class WordGroupResource {

    private static final String API_CONTEXT = "langpath"; //FIXME take from properties.

    @Inject
    @Named("createWordGroupCommand")
    private CommandService<WordGroup> createWordGroup;

    @Inject
    @Named("findUserWordGroupQuery")
    private QueryService<RequestObjectId, Collection<WordGroupInfo>> findWordGroupQuery;

    @Inject
    @Named("updateWordGroupCommand")
    private CommandService<WordGroup> updateWordGroup;

    @Inject
    @Named("getWordsToLearnQuery")
    private QueryService<RequestObjectId, WordGroupForLearn> getWordGroupForLearn;

    private final ObjectMapper mapper = new ObjectMapper();

    @Inject
    public WordGroupResource() {
        setupEndpoints();
    }

    private void setupEndpoints() {
        post(API_CONTEXT + "/command/createWordGroup", "application/json", (request, response) -> {
            WordGroup wg = mapper.readValue(request.body(), WordGroup.class);
            createWordGroup.command(wg); //TODO think about return the status 200, 500 etc.
            response.status(201);
            return response;
        });

        post(API_CONTEXT + "/query/getWordGroup", "application/json", (request, response) -> {
            RequestObjectId id = mapper.readValue(request.body(), RequestObjectId.class);
            return findWordGroupQuery.query(id);
        }, json());

        post(API_CONTEXT + "/command/updateWordGroup", "application/json", (request, response) -> {
            WordGroup wg = mapper.readValue(request.body(), WordGroup.class);
            response.status(updateWordGroup.command(wg));
            return response;
        });

        post(API_CONTEXT + "/query/getWordGroupForLearn", "application/json", (request, response) -> {
            RequestObjectId rq = mapper.readValue(request.body(), RequestObjectId.class);
            return getWordGroupForLearn.query(rq);
        }, json());
    }
}