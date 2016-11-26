package com.langpath.app.repository

import com.google.inject.Inject
import com.google.inject.name.Named
import com.langpath.app.model.storage.User
import com.langpath.app.modules.AppModule
import com.langpath.app.repository.api.UserRepository
import spock.guice.UseModules
import spock.lang.Specification

@UseModules([AppModule])
class UserRepositoryTest extends Specification {

    @Inject
    @Named("userRepository")
    UserRepository userRepository;

    def "Should return user by inserted email value"() {
        when:
        User user = new User()
        user.setFirstName("First Name")
        user.setLastName("Last Name")
        user.setPassword("password")
        user.setEmail(UUID.randomUUID().toString()+"@email.com")
        userRepository.saveOne(user)
        then:
        userRepository.findByEmail(user.getEmail()) != null
    }

    def "Should not find user by email"() {
        when:
        User user = userRepository.findByEmail("someEmail@email.org")
        then:
        user == null
    }

}
