package com.hrd.androidhrd.mvp_demo.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.hrd.androidhrd.mvp_demo.R;
import com.hrd.androidhrd.mvp_demo.di.App;
import com.hrd.androidhrd.mvp_demo.entity.UrlResponse;
import com.hrd.androidhrd.mvp_demo.main.adapter.UrlAdapter;
import com.hrd.androidhrd.mvp_demo.main.mvp.MainInteractor;
import com.hrd.androidhrd.mvp_demo.main.mvp.MainMvp;
import com.hrd.androidhrd.mvp_demo.main.mvp.MainPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainMvp.View{

    private RecyclerView rvUrl;
    private UrlAdapter adapter;
    private ProgressBar progressBar;
    private List<UrlResponse.Url> urlList =new ArrayList<>();

    @Inject
    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //config dagger2
        ((App) getApplicationContext()).getApplicationComponent().inject(this);
        setContentView(R.layout.activity_main);
        rvUrl=findViewById(R.id.rvUrl);
        progressBar =findViewById(R.id.progressbar);
        initUI();
        presenter.setView(this);

        //get all data from api
        presenter.getUrls(1);
    }

    private void initUI() {
        adapter=new UrlAdapter(urlList);
        rvUrl.setLayoutManager(new LinearLayoutManager(this));
        rvUrl.setAdapter(adapter);
    }

    private static final String TAG = "MainActivity";
    @Override
    public void onSuccess(List<UrlResponse.Url> urls) {
        Log.e(TAG, "onSuccess: "+urls);
        adapter.updateUrls(urls);
    }

    @Override
    public void onError(String error) {

    }
    
    @Override
    public void onShowLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        progressBar.setVisibility(View.GONE);
    }


}
