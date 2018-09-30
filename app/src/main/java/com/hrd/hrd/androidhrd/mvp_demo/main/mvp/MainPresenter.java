package com.hrd.androidhrd.mvp_demo.main.mvp;

import com.hrd.androidhrd.mvp_demo.entity.UrlResponse;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter  implements MainMvp.Presenter {

    MainInteractor interactor;
    MainMvp.View view;
    @Inject
    public MainPresenter(MainInteractor interactor){
        this.interactor=interactor;
    }

    @Override
    public void getUrls(int page) {
        if(view!=null)
            view.onShowLoading();
        interactor.getUrls(page, new MainMvp.Interactor.InteractorResponse(){
            @Override
            public void onSuccess(List<UrlResponse.Url> urls) {
                if(view!=null){
                    view.onSuccess(urls);
                    view.onHideLoading();
                }
            }
            @Override
            public void onError(String error) {
                if(view!=null){
                    view.onError(error);
                    view.onHideLoading();
                }
            }

        });
    }

    @Override
    public void setView(MainMvp.View view) {
        this.view=view;
    }
}
