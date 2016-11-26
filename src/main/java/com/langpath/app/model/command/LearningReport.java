package com.langpath.app.model.command;

public class LearningReport {

    private String wordGroupId;

    private int wrongAnswers;

    private long timeOfLearning;

    public String getWordGroupId() {
        return wordGroupId;
    }

    public void setWordGroupId(String wordGroupId) {
        this.wordGroupId = wordGroupId;
    }

    public int getWrongAnswers() {
        return wrongAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public long getTimeOfLearning() {
        return timeOfLearning;
    }

    public void setTimeOfLearning(long timeOfLearning) {
        this.timeOfLearning = timeOfLearning;
    }
}
