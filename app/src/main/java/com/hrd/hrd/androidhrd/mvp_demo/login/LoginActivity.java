package com.hrd.androidhrd.mvp_demo.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.hrd.androidhrd.mvp_demo.R;
import com.hrd.androidhrd.mvp_demo.data.repo.UserPreferences;
import com.hrd.androidhrd.mvp_demo.di.App;
import com.hrd.androidhrd.mvp_demo.entity.User;
import com.hrd.androidhrd.mvp_demo.login.mvp.LoginMvp;
import com.hrd.androidhrd.mvp_demo.login.mvp.Presenter;
import com.hrd.androidhrd.mvp_demo.main.MainActivity;

import javax.inject.Inject;

public class LoginActivity extends AppCompatActivity implements LoginMvp.View{
    EditText userName,password;
    Button btnLogin;
    ProgressBar progressBar;
    @Inject
    Presenter presenter;

    //user dagger dependency
    @Inject
    UserPreferences userPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //dagger injection
        ((App) getApplicationContext()).getApplicationComponent().inject(this);

        setContentView(R.layout.activity_login);
        userName=findViewById(R.id.userName);
        password=findViewById(R.id.password);
        btnLogin=findViewById(R.id.btnLogin);
        progressBar=findViewById(R.id.progressbar);

        //presenter=new Presenter();
        presenter.setView(this);

        btnLogin.setOnClickListener(v->{
            User user=new User(userName.getText().toString(),password.getText().toString());
            presenter.login(user);
        });

    }

    @Override
    public void onShowLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailLogin(String smg) {
        Toast.makeText(this, smg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginSuccess(User user) {
        userPreferences.add(this,user);
        startActivity(new Intent(this, MainActivity.class));
    }

    @Override
    public void onError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}
