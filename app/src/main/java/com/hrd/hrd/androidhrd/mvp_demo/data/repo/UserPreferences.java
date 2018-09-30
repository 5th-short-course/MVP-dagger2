package com.hrd.androidhrd.mvp_demo.data.repo;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.hrd.androidhrd.mvp_demo.entity.User;

import javax.inject.Inject;

public class UserPreferences {

   /* @Inject
    public UserPreferences(){}*/

   public void add(Context context, User user){
       SharedPreferences preferences=context.getSharedPreferences("user_preference",Context.MODE_PRIVATE);
       SharedPreferences.Editor editor= preferences.edit();
        editor.putString("name",user.getName());
        editor.putString("password",user.getPassword());
        editor.commit();
       Toast.makeText(context, "save user success", Toast.LENGTH_SHORT).show();
   }
}
