package com.example.androidhrd.mvp_demo.login.mvp;

import android.os.Handler;
import android.util.Log;

import com.example.androidhrd.mvp_demo.data.repo.Database;
import com.example.androidhrd.mvp_demo.data.repo.UserRepository;
import com.example.androidhrd.mvp_demo.entity.User;

public class Interactor implements LoginMvp.Interactor{
    //create Retrofit service
    // TODO: 29/09/2018
    private UserRepository userRepository;
    public Interactor(){
        userRepository= Database.getDatabase().getUserRepository();
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
