package com.hrd.androidhrd.mvp_demo.di;

import android.app.Application;

import com.hrd.androidhrd.mvp_demo.di.component.ApplicationComponent;
import com.hrd.androidhrd.mvp_demo.di.component.DaggerApplicationComponent;
import com.hrd.androidhrd.mvp_demo.di.module.ApplicationModule;

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
