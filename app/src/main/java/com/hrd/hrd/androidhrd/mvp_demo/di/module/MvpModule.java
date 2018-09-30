package com.hrd.androidhrd.mvp_demo.di.module;

import com.hrd.androidhrd.mvp_demo.login.mvp.Interactor;
import com.hrd.androidhrd.mvp_demo.login.mvp.Presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {

    @Provides
    @Singleton
    public Presenter providePresenter(Interactor interactor){
        return new Presenter(interactor);
    }


}
