package com.hrd.androidhrd.mvp_demo.di.module;

import com.hrd.androidhrd.mvp_demo.data.repo.Database;
import com.hrd.androidhrd.mvp_demo.data.repo.UserRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    @Singleton
    public Database provideDatabase(){
        return Database.getDatabase();
    }

    @Provides
    @Singleton
    public UserRepository provideUserRepository(Database database){
        return database.getUserRepository();
    }
}
