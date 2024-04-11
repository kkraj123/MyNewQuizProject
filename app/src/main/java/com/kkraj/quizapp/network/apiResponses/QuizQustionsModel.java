package com.kkraj.quizapp.network.apiResponses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "questions")
public class QuizQustionsModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("response_code")
    @Expose
    private Integer responseCode;
    @SerializedName("results")
    @Expose
    private List<QuizQustionResult> getQuizQustionResult;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    public List<QuizQustionResult> getGetQuizQustionResult() {
        return getQuizQustionResult;
    }

    public void setGetQuizQustionResult(List<QuizQustionResult> getQuizQustionResult) {
        this.getQuizQustionResult = getQuizQustionResult;
    }
}