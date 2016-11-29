package com.langpath.app.commands.user

import com.google.inject.Inject
import com.google.inject.name.Named
import com.langpath.app.commands.CommandService
import com.langpath.app.model.enums.Status
import com.langpath.app.model.storage.User
import com.langpath.app.modules.AppModule
import org.mongodb.morphia.Datastore
import spock.guice.UseModules
import spock.lang.Specification

import static com.langpath.app.model.enums.Status.ERROR

@UseModules([AppModule])
class RegisterUserCommandTest extends Specification {

    @Inject
    @Named("registerUserCommand")
    CommandService<User> registerUser;

    @Inject
    @Named("datastore")
    Datastore datastore;


    def "Should save the new user"() {
        given:
        User user = new User();
        user.setEmail("email@email.com_"+UUID.randomUUID().toString())
        user.setPassword("Password")
        user.setLastName("LastName")
        user.setFirstName("FirstName")
        when:
        registerUser.command(user)
        then:
        datastore.createQuery(User.class).filter("_id", user.getId()).countAll() == 1
    }

    def "Should not save user with empty email"() {
        given:
        User user = new User();
        user.setEmail("")
        user.setPassword("Password")
        user.setLastName("LastName")
        user.setFirstName("FirstName")
        when:
        registerUser.command(user)
        then:
        user.getId() == null
    }
    def "Should not save user with the same email"() {
        given:
        User user = new User();
        user.setEmail("email@email.com_")
        user.setPassword("Password")
        user.setLastName("LastName")
        user.setFirstName("FirstName")
        User user2 = new User();
        user2.setEmail("email@email.com_")
        user2.setPassword("Password")
        user2.setLastName("LastName")
        user2.setFirstName("FirstName")
        when:
        registerUser.command(user)
        registerUser.command(user2)
        then:
        datastore.createQuery(User.class).filter("_id", user2.getId()).countAll() == 0
    }

    def "Should not allow for register null user"() {
        when:
        User user = null
        then:
        ERROR.code == registerUser.command(user)
    }
}
