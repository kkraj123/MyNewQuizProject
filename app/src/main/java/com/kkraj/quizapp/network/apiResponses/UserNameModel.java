package com.kkraj.quizapp.network.apiResponses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_name_table")
public class UserNameModel {
    @PrimaryKey(autoGenerate = true)
    private int id;
    String userName;

    public UserNameModel(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
