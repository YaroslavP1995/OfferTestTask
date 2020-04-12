package com.example.offerwalltestapp.network;

import androidx.annotation.NonNull;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

import com.example.offerwalltestapp.BuildConfig;

import static okhttp3.logging.HttpLoggingInterceptor.Level;
public final class LoggingInterceptor implements Interceptor {
    private final Interceptor mLoggingInterceptor;

    private LoggingInterceptor() {
            mLoggingInterceptor = new HttpLoggingInterceptor()
                    .setLevel(BuildConfig.DEBUG ? Level.BODY : Level.NONE);
        }
    @NonNull
    public static Interceptor create() {
        return new LoggingInterceptor();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return mLoggingInterceptor.intercept(chain);
    }
}
