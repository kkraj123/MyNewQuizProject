package com.kkraj.quizapp.dataBase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.kkraj.quizapp.network.apiResponses.QuizQustionsModel;
import com.kkraj.quizapp.network.apiResponses.UserNameModel;

@Database(entities = {QuizQustionsModel.class,
        UserNameModel.class},
        version = 1,
        exportSchema = false)
@TypeConverters({QuizQustionResultConverter.class})
public abstract class QuizDatabase extends RoomDatabase {
    public static QuizDatabase instance;
    public abstract QuizDao quizDao();

    public abstract UserDao userDao();

    public static synchronized QuizDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),QuizDatabase.class, "QuizQuestions")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallBack)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallBack = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

        }
    };
}
