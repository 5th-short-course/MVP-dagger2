package com.example.androidhrd.mvp_demo.di.module;

import android.app.Application;
import android.content.Context;

import com.example.androidhrd.mvp_demo.data.repo.UserPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private Application application;
    public ApplicationModule(Application application){
        this.application=application;
    }

    @Provides
    @Singleton
    public Context provideContext(){
        return application;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return application;
    }

    @Provides
    public UserPreferences provideUserPreferences(){
        return new UserPreferences();
    }
}
