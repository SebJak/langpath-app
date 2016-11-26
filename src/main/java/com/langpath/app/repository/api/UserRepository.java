package com.langpath.app.repository.api;

import com.langpath.app.model.storage.User;
import com.sun.istack.internal.NotNull;

public interface UserRepository {

    User findByEmail(@NotNull final String email);

    void saveOne(@NotNull final User user);
}
