package com.example.offerwalltestapp.data;

import com.example.offerwalltestapp.model.content.ObjectModelId;
import com.example.offerwalltestapp.model.content.TypeModel;
import com.example.offerwalltestapp.network.ApiFactory;

import java.util.List;

import ru.arturvasilov.rxloader.RxUtils;
import rx.Observable;

public class DataRepository implements DataRepositoryView {

    @Override
    public Observable<List<ObjectModelId>> getTrending() {
        return ApiFactory.getRetrofitService()
                .getTrending()
                .flatMap(Observable::just)
                .compose(RxUtils.async());
    }

    @Override
    public Observable<TypeModel> getType(int id) {
        return ApiFactory.getRetrofitService()
                .getType(id)
                .flatMap(Observable::just)
                .compose(RxUtils.async());
    }
}
