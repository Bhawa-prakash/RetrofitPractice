package com.e.retrofitpractice.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.e.retrofitpractice.R;
import com.e.retrofitpractice.adapter.DataAdapter;
import com.e.retrofitpractice.model.BestSelling;
import com.e.retrofitpractice.model.DataResponse;
import com.e.retrofitpractice.retrofit.ApiClient;
import com.e.retrofitpractice.retrofit.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
     List<BestSelling>bestSellingList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<DataResponse> call = apiService.getBestSelling();
        call.enqueue(new Callback<DataResponse>() {
            @Override
            public void onResponse(Call<DataResponse> call, Response<DataResponse> response) {

                List<BestSelling> bestSellingList = response.body().getBestSelling();
                recyclerView.setAdapter(new DataAdapter(bestSellingList, R.layout.recycler_item, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<DataResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "failure", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

