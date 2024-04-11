package com.kkraj.quizapp.dataBase;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kkraj.quizapp.network.apiResponses.QuizQustionResult;
import java.lang.reflect.Type;
import java.util.List;

public class QuizQustionResultConverter {
    @TypeConverter
    public static List<QuizQustionResult> fromString(String value) {
        Type listType = new TypeToken<List<QuizQustionResult>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromList(List<QuizQustionResult> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
