package com.hrd.androidhrd.mvp_demo.login.mvp;

import com.hrd.androidhrd.mvp_demo.entity.User;

public interface LoginMvp {
    interface View{
        void onShowLoading();
        void onHideLoading();
        void onFailLogin(String smg);
        void onLoginSuccess(User user);
        void onError(String error);
    }
    interface Presenter{
        void login(User user);
        void setView(View view);
    }
    interface Interactor{
        void authenticate(User user,InteratorResponse response);

        interface InteratorResponse{
            void onLoginSuccess(User user);
            void onFailLogin(String smg);
            void OnError(String error);
        }
    }
}
