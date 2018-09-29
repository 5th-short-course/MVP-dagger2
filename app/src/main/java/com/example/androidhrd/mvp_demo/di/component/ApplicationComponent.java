package com.example.androidhrd.mvp_demo.di.component;

import com.example.androidhrd.mvp_demo.di.module.ApplicationModule;
import com.example.androidhrd.mvp_demo.login.LoginActivity;
import com.example.androidhrd.mvp_demo.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApplicationModule.class})
@Singleton
public interface ApplicationComponent {
    void inject(LoginActivity activity);
    void inject(MainActivity activity);
}
