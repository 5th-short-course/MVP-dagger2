package com.hrd.androidhrd.mvp_demo.login.mvp;

import com.hrd.androidhrd.mvp_demo.entity.User;

public class Presenter implements LoginMvp.Presenter {
    //View object
    private LoginMvp.View view;
    //Interactor object
    LoginMvp.Interactor interactor;
    public Presenter(Interactor interactor){
        this.interactor=interactor;
        //interactor=new Interactor();
    }
    @Override
    public void setView(LoginMvp.View view) {
        this.view=view;
    }

    @Override
    public void login(User user) {
        //request to Interactor
        if(view!=null)
            view.onShowLoading();
        interactor.authenticate(user,response);
    }

    private LoginMvp.Interactor.InteratorResponse response=
            new LoginMvp.Interactor.InteratorResponse() {
                @Override
                public void onLoginSuccess(User user) {
                   if(view!=null){
                       view.onLoginSuccess(user);
                       view.onHideLoading();
                   }
                }

                @Override
                public void onFailLogin(String smg) {
                    if(view!=null){
                        view.onFailLogin(smg);
                        view.onHideLoading();
                    }
                }

                @Override
                public void OnError(String error) {
                    //no need to call
                }
            };
}
