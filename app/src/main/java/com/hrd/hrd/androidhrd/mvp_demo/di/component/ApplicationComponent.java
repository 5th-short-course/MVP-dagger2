package com.hrd.androidhrd.mvp_demo.di.component;

import com.hrd.androidhrd.mvp_demo.data.remote.service.UrlService;
import com.hrd.androidhrd.mvp_demo.di.module.ApplicationModule;
import com.hrd.androidhrd.mvp_demo.di.module.DataModule;
import com.hrd.androidhrd.mvp_demo.di.module.MvpModule;
import com.hrd.androidhrd.mvp_demo.di.module.NetworkModule;
import com.hrd.androidhrd.mvp_demo.login.LoginActivity;
import com.hrd.androidhrd.mvp_demo.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = {ApplicationModule.class,
        MvpModule.class,
        DataModule.class,
        NetworkModule.class})
@Singleton
public interface ApplicationComponent {
    void inject(LoginActivity activity);
    void inject(MainActivity activity);

    UrlService getUrlService();
}
