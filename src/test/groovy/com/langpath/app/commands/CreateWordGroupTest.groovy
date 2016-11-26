package com.langpath.app.commands

import com.google.inject.Inject
import com.langpath.app.commands.wordgroup.CreateWordGroupCommand
import com.langpath.app.model.storage.WordGroup
import com.langpath.app.modules.AppModule
import spock.guice.UseModules
import spock.lang.Specification

/**
 * Created by root on 20.10.16.
 */
@UseModules([AppModule])
class CreateWordGroupTest extends Specification {

    @Inject
    CreateWordGroupCommand createWordGroup;

    def "Should save WordGroup"() {
        when:
        WordGroup wordGroup = buildWordGroup()
        createWordGroup.command(wordGroup)
        then:"The id should be not null after save object in database"
        wordGroup.getId() != null
    }

    WordGroup buildWordGroup() {
        def wordGroup = new WordGroup()
        wordGroup.setName("name")
        wordGroup.setDescription("Description")
        return wordGroup
    }
}
