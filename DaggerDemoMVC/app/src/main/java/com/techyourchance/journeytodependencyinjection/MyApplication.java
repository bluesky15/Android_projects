package com.techyourchance.journeytodependencyinjection;

import android.app.Application;
import android.support.annotation.UiThread;

import com.techyourchance.journeytodependencyinjection.networking.StackoverflowApi;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionDetailsUseCase;
import com.techyourchance.journeytodependencyinjection.questions.FetchQuestionsListUseCase;

import java.util.Stack;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {

    private Retrofit mRetrofit;
    private StackoverflowApi mStackoverflowApi;

    @UiThread
    public Retrofit getRetrofit() {
        if (mRetrofit == null) {
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return mRetrofit;
    }

    @UiThread
    public StackoverflowApi getStackoverflowApi() {
        if (mStackoverflowApi == null) {
            mStackoverflowApi = getRetrofit().create(StackoverflowApi.class);
        }
        return mStackoverflowApi;
    }

    @UiThread
    public FetchQuestionsListUseCase getFetchQuestionsListUseCase() {
        return new FetchQuestionsListUseCase(getStackoverflowApi());
    }

    @UiThread
    public FetchQuestionDetailsUseCase getFetchQuestionDetailsUseCase() {
        return new FetchQuestionDetailsUseCase(getStackoverflowApi());
    }
}
