package com.example.offerwalltestapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.io.Serializable;

public class MainErrorModel extends IOException implements Serializable {

    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;

    public MainErrorModel(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
