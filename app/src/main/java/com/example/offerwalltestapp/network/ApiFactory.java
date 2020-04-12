package com.example.offerwalltestapp.network;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import androidx.annotation.NonNull;
import java.util.concurrent.TimeUnit;

import static com.example.offerwalltestapp.BuildConfig.API_ENDPOINT;

public final class ApiFactory {
    private static OkHttpClient sClient;
    private static RetrofitService sService;

    private static RetrofitService createService() {
        return new Retrofit.Builder()
                .baseUrl(API_ENDPOINT)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(RetrofitService.class);
    }

    @NonNull
    public static OkHttpClient getClient() {
        OkHttpClient client = sClient;
        if (client == null) {
            synchronized (ApiFactory.class) {
                client = sClient;
                if (client == null) {
                    client = sClient = buildClient();
                }
            }
        }
        return client;
    }

    public static RetrofitService getRetrofitService() {
        RetrofitService service = sService;
        if (service == null) {
            synchronized (ApiFactory.class) {
                service = sService;
                if (service == null) {
                    service = sService = createService();
                }
            }
        }
        return service;
    }
    @NonNull
    private static OkHttpClient buildClient() {
        return new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(ExceptionInterceptor.create())
                .addInterceptor(LoggingInterceptor.create())
                .build();
    }
}
