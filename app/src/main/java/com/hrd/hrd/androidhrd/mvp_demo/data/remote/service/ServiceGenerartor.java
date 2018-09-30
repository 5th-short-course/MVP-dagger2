package com.hrd.androidhrd.mvp_demo.data.remote.service;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerartor {
    static Retrofit.Builder builder = new Retrofit.Builder()
                        .baseUrl("http://110.74.194.125:15000")
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> service){
        return builder.build().create(service);
    }
}
