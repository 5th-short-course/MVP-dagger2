package com.example.androidhrd.mvp_demo.di;

import android.app.Application;

import com.example.androidhrd.mvp_demo.di.component.ApplicationComponent;
import com.example.androidhrd.mvp_demo.di.component.DaggerApplicationComponent;
import com.example.androidhrd.mvp_demo.di.module.ApplicationModule;

public class App extends Application {

    ApplicationComponent applicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent= DaggerApplicationComponent.builder()
                            .applicationModule(new ApplicationModule(this))
                            .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
