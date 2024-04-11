package com.kkraj.quizapp.dataBase;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kkraj.quizapp.network.apiResponses.QuizQustionsModel;

import java.util.List;

@Dao
public interface QuizDao {
    @Query("SELECT * FROM questions")
    LiveData<List<QuizQustionsModel>> getAllQuestions();

    @Insert
    void insertData(QuizQustionsModel quizQustionsModel);

}
