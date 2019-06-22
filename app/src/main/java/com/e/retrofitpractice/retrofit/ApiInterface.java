package com.e.retrofitpractice.retrofit;

import com.e.retrofitpractice.model.BestSelling;
import com.e.retrofitpractice.model.DataResponse;

import retrofit2.Call;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("grofer_api/list")
    Call<DataResponse>getBestSelling();


}
