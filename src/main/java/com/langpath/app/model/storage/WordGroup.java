package com.langpath.app.model.storage;

import com.langpath.app.model.storage.BaseType;
import com.langpath.app.model.storage.Language;
import com.langpath.app.model.storage.Word;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Transient;

import java.util.Date;
import java.util.List;

/**
 * Created by root on 20.10.16.
 */
@Entity("Wordgroups")
public class WordGroup extends BaseType {

    private String name;

    private String description;

    @Embedded
    List<Word> words;

    @Embedded
    private Language sourceLang;

    @Embedded
    private Language targetLang;

    private Date lastActive;

    private int countOfRepetition;

    private int countOfWords;

    private long timeOfLearning;

    @Transient
    public ObjectId userId;

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public long getTimeOfLearning() {
        return timeOfLearning;
    }

    public void setTimeOfLearning(long timeOfLearning) {
        this.timeOfLearning = timeOfLearning;
    }

    public Date getLastActive() {
        return lastActive;
    }

    public void setLastActive(Date lastActive) {
        this.lastActive = lastActive;
    }

    public int getCountOfRepetition() {
        return countOfRepetition;
    }

    public void setCountOfRepetition(int countOfRepetition) {
        this.countOfRepetition = countOfRepetition;
    }

    public int getCountOfWords() {
        return countOfWords;
    }

    public void setCountOfWords(int countOfWords) {
        this.countOfWords = countOfWords;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Language getSourceLang() {
        return sourceLang;
    }

    public void setSourceLang(Language sourceLang) {
        this.sourceLang = sourceLang;
    }

    public Language getTargetLang() {
        return targetLang;
    }

    public void setTargetLang(Language targetLang) {
        this.targetLang = targetLang;
    }

    public void increaseCountOfRepetition(int count) {
        this.countOfRepetition=+count;
    }

    public void increaseTimeOfLearning(long count) {
        this.timeOfLearning=+count;
    }
}
