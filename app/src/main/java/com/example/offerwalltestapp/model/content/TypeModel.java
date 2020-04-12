package com.example.offerwalltestapp.model.content;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TypeModel implements Serializable {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("contents")
    @Expose
    private String contents;
    @SerializedName("url")
    @Expose
    private String url;

    public TypeModel(String type, String url, String contents) {
        super();
        this.type = type;
        this.url = url;
        this.contents = contents;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TypeModel withType(String type) {
        this.type = type;
        return this;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public TypeModel withContents(String contents) {
        this.contents = contents;
        return this;
    }


}
