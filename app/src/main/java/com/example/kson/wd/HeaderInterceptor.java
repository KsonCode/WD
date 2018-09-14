package com.example.kson.wd;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author:kson
 * E-mail:19655910@qq.com
 * Time:2018/09/14
 * Description:头部拦截器
 */
public class HeaderInterceptor implements Interceptor{
    /**
     * 拦截的方法：拦截的是请求和响应（应用拦截），以及请求过程（网络拦截器）
     * @param chain
     * @return
     * @throws IOException
     */
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request().newBuilder().addHeader("sessionId","1536895166820514")
                .addHeader("userId","514").build();
        return chain.proceed(request);//返回response
    }
}
