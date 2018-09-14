package com.example.kson.wd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kson.wd.api.UserApi;
import com.example.kson.wd.common.Constants;
import com.example.kson.wd.entity.UploadEntity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    private String userName = "17601632567";
    private String pass = "uNzol1eD+fxXRt/ALcYcdw==";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     *
     * @param view
     */
    public void login(View view) {




    }

    public void upload(View view) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())//添加头部
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .build();

        UserApi userApi = retrofit.create(UserApi.class);
        HashMap<String,String> headers = new HashMap<>();
        headers.put("userId","");
        headers.put("sessionId","");
        HashMap<String,Object> params = new HashMap<>();
        params.put("file", new File(""));
        userApi.upload(headers,params).subscribe(new Consumer<UploadEntity>() {
            @Override
            public void accept(UploadEntity uploadEntity) throws Exception {

            }
        });

    }

    /**
     * 获取会员首页信息
     * @param view
     */
    public void getUserInfo(View view) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor())//添加头部
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(Constants.BASE_URL)
                .build();

        UserApi userApi = retrofit.create(UserApi.class);
        userApi.getUserInfo().enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println("resopnse:"+response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }
}
