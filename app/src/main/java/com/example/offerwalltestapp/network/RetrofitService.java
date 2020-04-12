package com.example.offerwalltestapp.network;

import com.example.offerwalltestapp.model.content.ObjectModelId;
import com.example.offerwalltestapp.model.content.TypeModel;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

import java.util.List;

public interface RetrofitService {

    @GET("trending")
    Observable<List<ObjectModelId>> getTrending();

    @GET("object/{id}")
    Observable<TypeModel> getType(@Path("id") int id);

}
