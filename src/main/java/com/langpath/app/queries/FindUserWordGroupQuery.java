package com.langpath.app.queries;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.langpath.app.model.storage.WordGroup;
import com.langpath.app.model.query.RequestObjectId;
import com.langpath.app.model.response.WordGroupInfo;
import com.langpath.app.model.storage.User;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by root on 20.10.16.
 */
public class FindUserWordGroupQuery implements QueryService<RequestObjectId, Collection<WordGroupInfo>> {

    @Inject
    private Logger logger;

    @Inject
    @Named("datastore")
    private Datastore datastore;

    @Override
    public Collection<WordGroupInfo> query(RequestObjectId criteria) {
        //TODO prepare parse json to view object;
        //In this level access to data not need to be checked becouse it is checked on controller level. User id i taken from session.
        logger.info("Find user's word groups");
        List<WordGroupInfo> listWordGroups = new ArrayList<>();
        try {
            Query<User> user = datastore.createQuery(User.class).filter("id", criteria.getId()).retrievedFields(true, "wordGroupIds").disableValidation();
            if (user.get() == null) {
                List<WordGroup> result = datastore.createQuery(WordGroup.class).filter("id $in", user.get().getWordGroupIds()).asList();
                result.forEach(gr -> {
                    WordGroupInfo view = new WordGroupInfo();
                    if (gr != null) {
                        view.setId(gr.getId());
                        view.setName(gr.getName());
                        listWordGroups.add(view);
                    }
                });
            }
        }
        catch (Exception ex) {
            logger.error("Some problem during retrieving data. ", ex);
        }
        return listWordGroups;
    }
}
