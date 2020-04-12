package com.example.offerwalltestapp;

import com.example.offerwalltestapp.data.DataProviderRepository;

public class MainPresenter {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    public void getTrending() {
        DataProviderRepository.getDataRepositoryView()
                .getTrending()
                .subscribe(mainView::objectModelId,
                        throwable -> {mainView.handleError(throwable);});
    }
    public void getType(int id) {
        DataProviderRepository.getDataRepositoryView()
                .getType(id)
                .subscribe(mainView::typeModel,
                        throwable -> {mainView.handleError(throwable);});
    }
}
