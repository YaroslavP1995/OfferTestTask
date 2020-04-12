package com.example.offerwalltestapp.data;

public class DataProviderRepository {

    private static DataRepositoryView dataRepositoryView;

    public static DataRepositoryView getDataRepositoryView() {
        if (dataRepositoryView == null) {
            dataRepositoryView = new DataRepository();
        }
        return dataRepositoryView;
    }
}
