package com.langpath.app.repository.api;

import com.langpath.app.model.storage.User;
import com.sun.istack.internal.NotNull;

public interface UserRepository extends Repository<User> {

    User findByEmail(@NotNull final String email);

}
