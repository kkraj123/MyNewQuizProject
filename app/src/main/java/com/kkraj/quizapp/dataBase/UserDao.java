package com.kkraj.quizapp.dataBase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.kkraj.quizapp.network.apiResponses.UserNameModel;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_name_table")
    LiveData<List<UserNameModel>> getAllUser();

    @Insert
    void insertUserData(UserNameModel userNameModel);


}
