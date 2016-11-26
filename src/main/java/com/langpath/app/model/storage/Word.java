package com.langpath.app.model.storage;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by root on 20.10.16.
 */
@Embedded
public class Word {

    private String value;

    private String meaning;

    private String valueExample;

    private String meaningExample;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    public String getValueExample() {
        return valueExample;
    }

    public void setValueExample(String valueExample) {
        this.valueExample = valueExample;
    }

    public String getMeaningExample() {
        return meaningExample;
    }

    public void setMeaningExample(String meaningExample) {
        this.meaningExample = meaningExample;
    }
}
