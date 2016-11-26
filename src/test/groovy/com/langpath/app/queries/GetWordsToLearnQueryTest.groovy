package com.langpath.app.queries

import com.google.inject.Inject
import com.google.inject.name.Named
import com.langpath.app.model.query.RequestObjectId
import com.langpath.app.model.response.wordGroup.WordGroupForLearn
import com.langpath.app.model.storage.Language
import com.langpath.app.model.storage.Word
import com.langpath.app.model.storage.WordGroup
import com.langpath.app.modules.AppModule
import org.apache.log4j.Logger
import org.mongodb.morphia.Datastore
import spock.guice.UseModules
import spock.lang.Specification

import static java.util.Arrays.asList

@UseModules(AppModule)
class GetWordsToLearnQueryTest extends Specification {

    private static final Logger logger = Logger.getLogger(GetWordsToLearnQueryTest.class)

    @Inject
    @Named("getWordsToLearnQuery")
    QueryService<RequestObjectId, WordGroupForLearn> getWordGroupForLearn;

    @Inject
    @Named("datastore")
    Datastore datastore

    WordGroup wordGroup

    void setup() {
        logger.info("Setup method")
        wordGroup = new WordGroup()
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
        Word word = new Word();
        word.setValue("Book")
        word.setMeaning("das Buch");
        wordGroup.setWords(asList(word));
        datastore.save(wordGroup)
        logger.info("Saved wordgroup with id: " +wordGroup.getId().toHexString())

    }

    def "Should return correct word group for learn"() {
        given:
        RequestObjectId requestObjectId = new RequestObjectId()
        requestObjectId.setId(wordGroup.getId())
        when:
        WordGroupForLearn learn = getWordGroupForLearn.query(requestObjectId)
        then:
        learn.wordGroupName == wordGroup.name
        learn.words.size() == 1;
        Word word = learn.words.get(0)
        word.value == "Book"
        word.meaning == "das Buch"

    }
}
