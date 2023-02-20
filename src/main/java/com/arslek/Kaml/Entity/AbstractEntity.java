package com.arslek.Kaml.Entity;

public abstract class AbstractEntity <TYPE_ID> {

    private TYPE_ID id;

    public TYPE_ID getId() {
        return id;
    }

    public void setId(TYPE_ID id) {
        this.id = id;
    }
}
