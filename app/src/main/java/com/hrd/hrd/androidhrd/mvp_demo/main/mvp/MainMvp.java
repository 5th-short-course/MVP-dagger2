package com.hrd.androidhrd.mvp_demo.main.mvp;

import com.hrd.androidhrd.mvp_demo.entity.UrlResponse;
import com.hrd.androidhrd.mvp_demo.login.mvp.LoginMvp;

import java.util.List;

public interface MainMvp {

    interface  View{
        void onSuccess(List<UrlResponse.Url> urls);
        void onShowLoading();
        void onHideLoading();
        void onError(String error);
    }
    interface Presenter{
        void getUrls(int page);
        void setView(View view);
    }
    interface Interactor{
        void getUrls(int page, MainMvp.Interactor.InteractorResponse response);

        interface InteractorResponse{
            void onSuccess(List<UrlResponse.Url> urls);
            void onError(String error);
        }
    }
}
