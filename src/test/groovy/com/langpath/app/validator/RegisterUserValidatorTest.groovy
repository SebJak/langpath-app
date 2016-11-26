package com.langpath.app.validator

import com.google.inject.Inject
import com.google.inject.name.Named
import com.langpath.app.model.storage.User
import com.langpath.app.modules.AppModule
import org.mongodb.morphia.Datastore
import spock.guice.UseModules
import spock.lang.Specification

/**
 * Created by root on 21.10.16.
 */
@UseModules([AppModule])
class RegisterUserValidatorTest extends Specification {

    @Inject
    RegisterUserValidator validator;

    @Inject
    @Named("datastore")
    Datastore datastore;

    def "Should validate duplicated email"() {
        given:
        User user = new User();
        user.setEmail("testemail@email.com")
        user.setFirstName("First Name")
        user.setLastName("Last Name")
        user.setPassword("password")

        when:
        datastore.save(user);

        then: 'Validate should return false because this email was saved above'
        !validator.validate(user)

    }
}
