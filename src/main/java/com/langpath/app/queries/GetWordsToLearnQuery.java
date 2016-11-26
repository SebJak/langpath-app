package com.langpath.app.queries;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.query.RequestObjectId;
import com.langpath.app.model.response.wordGroup.WordGroupForLearn;
import com.langpath.app.model.storage.WordGroup;
import org.mongodb.morphia.Datastore;

public class GetWordsToLearnQuery implements QueryService<RequestObjectId, WordGroupForLearn> {

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Override
    public WordGroupForLearn query(RequestObjectId criteria) {
        WordGroup wordGroup = datastore.createQuery(WordGroup.class).filter("_id", criteria.getId()).get();
        WordGroupForLearn forLearn = new WordGroupForLearn();
        if(wordGroup!= null) {
            forLearn.setLastTraining(wordGroup.getLastActive());
            forLearn.setWordGroupName(wordGroup.getName());
            forLearn.setWords(wordGroup.getWords());
        }
        return forLearn;
    }
}
