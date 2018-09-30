package com.hrd.androidhrd.mvp_demo.data.repo;

import com.hrd.androidhrd.mvp_demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    List<User> users;
    public UserRepository(){
        users=new ArrayList<>();
        users.add(new User("admin","admin"));
    }

    /*public User getUser(String name){

    }*/
    public User authenticate(User userForm) {
        User userResponse = null;
        for (User u : users) {
            if (userForm.getName().equals(u.getName()) &&
                    userForm.getPassword().equals(u.getPassword())) {

                userResponse = u;
                break;
            }else{
                userResponse=null;
                break;
            }
        }

        return userResponse;
    }
}
