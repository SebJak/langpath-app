package com.langpath.app.commands.wordgroup

import com.google.inject.Inject
import com.langpath.app.model.command.LearningReport
import com.langpath.app.model.storage.WordGroup
import com.langpath.app.modules.AppModule
import com.langpath.app.repository.WordGroupRepositoryImpl
import spock.guice.UseModules
import spock.lang.Specification

@UseModules([AppModule])
class FinishLearningWordGroupCommandTest extends Specification {

    @Inject
    FinishLearningWordGroupCommand finishLearningWordGroupCommand;

    @Inject
    WordGroupRepositoryImpl wordGroupRepository;

    def "Should increase number of repetition after finish learning"() {
        given:
        WordGroup wordGroup = new WordGroup()
        wordGroupRepository.saveOne(wordGroup)
        LearningReport lr = new LearningReport()
        lr.setTimeOfLearning(20)
        lr.setWordGroupId(wordGroup.getId().toString())
        lr.setWrongAnswers(5)
        when:
        finishLearningWordGroupCommand.command(lr)
        then:
        20l == wordGroupRepository.findOne(wordGroup.getId()).getTimeOfLearning()
    }
}
