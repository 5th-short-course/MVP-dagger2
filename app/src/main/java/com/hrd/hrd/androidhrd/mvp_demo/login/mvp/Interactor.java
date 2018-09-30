package com.hrd.androidhrd.mvp_demo.login.mvp;

import android.os.Handler;
import android.util.Log;

import com.hrd.androidhrd.mvp_demo.data.repo.Database;
import com.hrd.androidhrd.mvp_demo.data.repo.UserRepository;
import com.hrd.androidhrd.mvp_demo.entity.User;

import javax.inject.Inject;

public class Interactor implements LoginMvp.Interactor{
    //create Retrofit service
    // TODO: 29/09/2018

    @Inject UserRepository userRepository;
    @Inject
    public Interactor(){
    }
    @Override
    public void authenticate(User user,InteratorResponse response) {
        new Handler().postDelayed(()->{
            User userResponse=userRepository.authenticate(user);
            Log.e("interactor", "authenticate: "+userResponse );
            if(userResponse==null){
                response.onFailLogin("wrong user and password.");
            }else if(userResponse.getName()!=null){
                response.onLoginSuccess(userResponse);
            }
            //no error

        },1000);


    }
}
