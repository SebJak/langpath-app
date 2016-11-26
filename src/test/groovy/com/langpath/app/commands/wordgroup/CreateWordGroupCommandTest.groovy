package com.langpath.app.commands.wordgroup

import com.google.inject.Inject
import com.google.inject.name.Named
import com.langpath.app.commands.CommandService
import com.langpath.app.model.storage.WordGroup
import com.langpath.app.model.storage.Language
import com.langpath.app.model.storage.User
import com.langpath.app.modules.AppModule
import org.bson.types.ObjectId
import org.mongodb.morphia.Datastore
import spock.guice.UseModules
import spock.lang.Specification

@UseModules([AppModule])
class CreateWordGroupCommandTest extends Specification {

    @Inject
    @Named("createWordGroupCommand")
    CommandService<WordGroup> wordGroupCommand;

    @Inject
    @Named("datastore")
    Datastore datastore;

    def "Should save new word group in database"() {
        given:
        ObjectId id = new ObjectId("580e4757112f5a14ff495aae")
        WordGroup wordGroup = new WordGroup()
        wordGroup.setName("Name")
        wordGroup.setDescription("Description")
        Language sourceLang = new Language()
        sourceLang.id = 1
        sourceLang.label = "English"
        Language targetLang = new Language()
        targetLang.id = 2
        targetLang.label = "German"
        wordGroup.setSourceLang(sourceLang)
        wordGroup.setTargetLang(targetLang)
        wordGroup.setUserId(id)
        when:
        wordGroupCommand.command(wordGroup)
        then:
        datastore.createQuery(WordGroup.class).filter("id", wordGroup.getId()).get() != null
        datastore.createQuery(User.class).filter("_id  eq", id).get().getWordGroupIds().contains(wordGroup.getId())
    }
}
