package com.example.offerwalltestapp;

import androidx.annotation.NonNull;

import com.example.offerwalltestapp.model.content.ObjectModelId;
import com.example.offerwalltestapp.model.content.TypeModel;

import java.util.List;

public interface MainView {

    void typeModel(@NonNull TypeModel typeModel);
    void objectModelId(List<ObjectModelId> objectModelId);
    void handleError(Throwable throwable);

}
