package com.langpath.app.repository;

import com.langpath.app.model.storage.User;
import com.langpath.app.repository.api.UserRepository;
import com.sun.istack.internal.NotNull;
import org.mongodb.morphia.query.Query;

public class UserRepositoryImpl extends AbstractDAO<User> implements UserRepository {

    @Override
    public User findByEmail(@NotNull final String email) {
        Query<User> userQuery = datastore.find(User.class, "email", email);
        return userQuery.get();

    }

}
