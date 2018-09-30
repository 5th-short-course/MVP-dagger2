package com.hrd.androidhrd.mvp_demo.data.remote.service;

import com.hrd.androidhrd.mvp_demo.entity.UrlResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UrlService {
    @GET("/api/v1/urls")
    Call<UrlResponse> getUrls(@Query("page") int page);

    //Rx
    @GET("/api/v1/urls")
    //for multi items are emitted
    Observable<UrlResponse> getUrlsRx(@Query("page") int page);

    //for multi items are emitted
    //Single<Response> getUrlsRx(@Query("page") int page);
}
