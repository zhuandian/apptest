package com.zhuandian.apptest.network;

import com.zhuandian.apptest.Entity;
import com.zhuandian.network.HttpEntity;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * desc:
 * author: xiedong
 * date: 3/1/21
 **/
public interface Api {
    @GET("/getAllInfoList")
    Observable<HttpEntity<List<Object>>> getAllInfoList();

    @POST("/insertAppInfo")
    Observable<HttpEntity<String>> insertAppInfo(@Body Entity entity);
}
