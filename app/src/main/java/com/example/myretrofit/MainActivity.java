package com.example.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Retrofit mRetrofit;
    private RetrofitAPI mRetrofitAPI;
    private Call<List<Movie>> mCallMovieList;

    private Gson mGson;

    TextView tv;
    Button btn;

    //MovieListVO mMovieListVO;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRetrofitInit();
        Log.d("Test@@@@@@@@@22", "3");
        callMovieList();
        Log.d("Test@@@@@@@@@22", "6");

        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        Log.d("Test@@@@@@@@@22", "7");
        btn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View view){
                //Call<List<Movie>> getCall = mRetrofitAPI.getMovieList();
                //getCall.enqueue(new Callback<List<Movie>>() {}
                tv.setText(result);
            }
        });
    }

    private void setRetrofitInit() {

        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.androidhive.info")
                 .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("Test@@@@@@@@@22", "1");
        mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
        Log.d("Test@@@@@@@@@22", "2");
    }

    private void callMovieList() {
        Log.d("Test@@@@@@@@@22", "4");
        mCallMovieList = mRetrofitAPI.getMovieList();
        Log.d("TAG", result+"???");
        mCallMovieList.enqueue(mRetrofitCallback);
        Log.d("Test@@@@@@@@@22", "5");
    }

    private Callback<List<Movie>> mRetrofitCallback = new Callback<List<Movie>>() {
        @Override
        public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
            //result = response.body();
            //Log.d("TAG", result+"???");
            Log.d("Test@@@@@@@@@22", "8");
            List<Movie> mList = response.body();
            for( Movie item : mList){
                result += "title : " + item.getId() + " text: " + item.getName() + "\n";
            }
            tv.setText(result);

        }

        @Override
        public void onFailure(Call<List<Movie>> call, Throwable t) {
            Log.d("Test@@@@@@@@@22", "9"+t.getMessage());
            t.printStackTrace();
        }


    };

}