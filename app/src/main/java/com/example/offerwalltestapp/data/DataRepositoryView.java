package com.example.offerwalltestapp.data;

import com.example.offerwalltestapp.model.content.ObjectModelId;
import com.example.offerwalltestapp.model.content.TypeModel;

import java.util.List;

import rx.Observable;

public interface DataRepositoryView {
    Observable<List<ObjectModelId>> getTrending();
    Observable<TypeModel> getType(int id);
}
