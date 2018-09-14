package com.example.kson.wd.api;

import com.example.kson.wd.entity.UploadEntity;
import com.example.kson.wd.entity.UserEntity;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/13
 * Description:
 */
public interface UserApi {
    /**
     * 上传头像
     * @return
     */
    @POST("movieApi/user/v1/verify/uploadHeadPic")
    @Multipart
    Observable<UploadEntity> upload(@HeaderMap HashMap<String,String> heads,@FieldMap HashMap<String,Object> params);
    /**
     * 登录
     * @return
     */
    @POST("movieApi/user/v1/login")
    @Multipart
    Observable<UserEntity> login();
    /**
     * 登录
     * @return
     */
    @GET("movieApi/user/v1/verify/findUserHomeInfo")
    Call<ResponseBody> getUserInfo();
}
