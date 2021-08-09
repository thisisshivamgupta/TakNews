package com.thisisshivamgupta.taknews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import com.thisisshivamgupta.taknews.Models.NewsApiResponse;
import com.thisisshivamgupta.taknews.Models.NewsHeadlines;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SelectListener{

    RecyclerView recyclerView;
    CustomAdaptor adaptor;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog= new ProgressDialog(this);
        dialog.setTitle("Fetching Garam News..");
        dialog.show();

        RequestManager manager =new RequestManager(this);
        manager.getNewsHeadlines(listener,"general",null);





    }
    private final OnFetchDataListener<NewsApiResponse> listener= new OnFetchDataListener<NewsApiResponse>() {
        @Override
        public void onFetchData(List<NewsHeadlines> list, String message) {

            showNews(list);
            dialog.dismiss();

        }

        @Override
        public void onError(String message) {

        }
    };

    private void showNews(List<NewsHeadlines> list) {
        recyclerView= findViewById(R.id.recycler_main);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adaptor= new CustomAdaptor(this,list,this);
        recyclerView.setAdapter(adaptor);

    }

    @Override
    public void OnNewsCliked(NewsHeadlines headlines) {
        startActivity(new Intent(MainActivity.this,DetailsActivity.class)
        .putExtra("data", headlines));


    }
}