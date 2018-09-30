package com.hrd.androidhrd.mvp_demo.main.mvp;

import android.util.Log;
import android.widget.Toast;

import com.hrd.androidhrd.mvp_demo.data.remote.service.UrlService;
import com.hrd.androidhrd.mvp_demo.entity.UrlResponse;
import com.hrd.androidhrd.mvp_demo.login.mvp.LoginMvp;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements MainMvp.Interactor {
    @Inject
    UrlService urlService;
    @Inject
    public MainInteractor(){}

    @Override
    public void getUrls(int page, MainMvp.Interactor.InteractorResponse interactorResponse) {
        ////retorfit
        /*Call<UrlResponse> call= urlService.getUrls(page);
        call.enqueue(new Callback<UrlResponse>() {
            @Override
            public void onResponse(Call<UrlResponse> call, Response<UrlResponse> response) {
                interactorResponse.onSuccess(response.body().getData());
            }

            @Override
            public void onFailure(Call<UrlResponse> call, Throwable t) {
                interactorResponse.onError(t.toString());
            }
        });*/

        Observable<UrlResponse> observable=urlService.getUrlsRx(page);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeWith(new DisposableObserver<UrlResponse>() {
                    @Override
                    public void onNext(UrlResponse urlResponse) {
                        interactorResponse.onSuccess(urlResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        interactorResponse.onError(e.toString());
                    }

                    @Override
                    public void onComplete() {
                        Log.e("Rx", "onComplete: " );
                    }
                });
        observable.unsubscribeOn(Schedulers.io());
    }
}
