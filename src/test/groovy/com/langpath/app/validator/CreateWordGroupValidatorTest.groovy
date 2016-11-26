package com.langpath.app.validator

import com.google.inject.Inject
import com.langpath.app.model.storage.WordGroup
import com.langpath.app.model.storage.Language
import com.langpath.app.modules.AppModule
import spock.guice.UseModules
import spock.lang.Specification

@UseModules([AppModule])
class CreateWordGroupValidatorTest extends Specification {

    @Inject
    WordGroupValidator validator;

    def "Should not all for empty object"() {
        when:
        WordGroup wordGroup = new WordGroup()
        then:
        !validator.validate(wordGroup)
    }

    def "Should not all for null object"() {
        when:
        WordGroup wordGroup = null
        then:
        !validator.validate(wordGroup)
    }

    def "Should not all for empty languages"() {
        when:
        WordGroup wordGroup = new WordGroup()
        wordGroup.setName("Name")
        wordGroup.setDescription("Description")
        Language sourceLang = new Language()
        Language targetLang = new Language()
        wordGroup.setSourceLang(sourceLang)
        wordGroup.setTargetLang(targetLang)
        then:
        !validator.validate(wordGroup)
    }

    def "Should not all for the same languages"() {
        when:
        WordGroup wordGroup = new WordGroup()
        wordGroup.setName("Name")
        wordGroup.setDescription("Description")
        Language sourceLang = new Language()
        sourceLang.id = 1
        sourceLang.label = "English"
        Language targetLang = new Language()
        targetLang.id = 1
        targetLang.label = "English"
        wordGroup.setSourceLang(sourceLang)
        wordGroup.setTargetLang(targetLang)
        then:
        !validator.validate(wordGroup)
    }

    def "Should allow for save"() {
        when:
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
        then:
        validator.validate(wordGroup)
    }
}
