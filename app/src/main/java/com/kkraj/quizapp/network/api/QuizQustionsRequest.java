package com.kkraj.quizapp.network.api;

import com.kkraj.quizapp.network.apiResponses.QuizQustionsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface QuizQustionsRequest {
    @GET("api.php")
    Call<QuizQustionsModel> getAllQuestions(@Query("amount")String amount, @Query("category")String category, @Query("difficulty")String difficulty, @Query("type")String type);
}
