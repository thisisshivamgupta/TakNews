package com.thisisshivamgupta.taknews;

import com.thisisshivamgupta.taknews.Models.NewsHeadlines;

import java.util.List;

public interface OnFetchDataListener<NewsApiResponse> {

    void onFetchData(List<NewsHeadlines> list,String message);

    void onError(String message);

}
