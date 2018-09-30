package com.hrd.androidhrd.mvp_demo.di.module;

import com.hrd.androidhrd.mvp_demo.data.remote.service.ServiceGenerartor;
import com.hrd.androidhrd.mvp_demo.data.remote.service.UrlService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public UrlService provideUrlService(){
        return ServiceGenerartor.createService(UrlService.class);
    }
}
