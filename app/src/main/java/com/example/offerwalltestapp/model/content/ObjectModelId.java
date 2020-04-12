package com.example.offerwalltestapp.model.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ObjectModelId  {
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("title")
    @Expose
    private String title;

    public ObjectModelId() {
    }

    public ObjectModelId(long id, String title) {
        super();
        this.id = id;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ObjectModelId withId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ObjectModelId withTitle(String title) {
        this.title = title;
        return this;
    }

}
