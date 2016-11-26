package com.langpath.app.model.response.wordGroup;

import com.langpath.app.model.storage.Word;

import java.util.Date;
import java.util.List;

public class WordGroupForLearn {

    private String wordGroupName;

    private Date lastTraining;

    private List<Word> words;

    public String getWordGroupName() {
        return wordGroupName;
    }

    public void setWordGroupName(String wordGroupName) {
        this.wordGroupName = wordGroupName;
    }

    public Date getLastTraining() {
        return lastTraining;
    }

    public void setLastTraining(Date lastTraining) {
        this.lastTraining = lastTraining;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
