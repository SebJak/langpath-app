package com.langpath.app.model.storage;

import org.mongodb.morphia.annotations.Embedded;

/**
 * Created by root on 20.10.16.
 */
@Embedded
public class Language {

    private int id;

    private String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Language)) return false;

        Language language = (Language) o;

        if (getId() != language.getId()) return false;
        return getLabel() != null ? getLabel().equals(language.getLabel()) : language.getLabel() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getLabel() != null ? getLabel().hashCode() : 0);
        return result;
    }
}

