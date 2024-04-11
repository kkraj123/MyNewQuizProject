package com.kkraj.quizapp.ui.questionView.viewModel;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.kkraj.quizapp.dataBase.QuizDao;
import com.kkraj.quizapp.dataBase.QuizDatabase;
import com.kkraj.quizapp.network.api.QuizQustionsRequest;
import com.kkraj.quizapp.network.api.RetrofitRequest;
import com.kkraj.quizapp.network.apiResponses.QuizQustionsModel;
import com.kkraj.quizapp.utils.ResponseState;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizRepository {
    private QuizQustionsRequest quizQustionsRequest;
    private QuizDao quizDao;
    private LiveData<List<QuizQustionsModel>> quizQustionsModel;

    public QuizRepository(Application application) {
        quizQustionsRequest = RetrofitRequest.getRetrofitInstance().create(QuizQustionsRequest.class);
        QuizDatabase quizDatabase = QuizDatabase.getInstance(application);
        quizDao = quizDatabase.quizDao();
        quizQustionsModel = quizDao.getAllQuestions();

    }
    public LiveData<List<QuizQustionsModel>> getAllAcounts(){
        return quizQustionsModel;
    }

    public void insertQuizQuestions(QuizQustionsModel quizQustionsModel) {
        new insertAsyncTask(quizDao).execute(quizQustionsModel);
    }

    public LiveData<QuizQustionsModel> getQuestions(String amount, String category, String difficulty, String type) {
        final MutableLiveData<QuizQustionsModel> allDatas = new MutableLiveData<>();
        quizQustionsRequest.getAllQuestions(amount, category, difficulty, type)
                .enqueue(new Callback<QuizQustionsModel>() {
                    @Override
                    public void onResponse(Call<QuizQustionsModel> call, Response<QuizQustionsModel> response) {
                        if (response.body() != null) {
                            allDatas.setValue(response.body());
                            insertQuizQuestions(response.body());
                        }

                    }

                    @Override
                    public void onFailure(Call<QuizQustionsModel> call, Throwable t) {
                        allDatas.setValue(null);
                    }
                });
        return allDatas;
    }

    private static class insertAsyncTask extends AsyncTask<QuizQustionsModel, Void, Void> {

        private QuizDao quizDao;

        insertAsyncTask(QuizDao quizDao) {
            this.quizDao = quizDao;
        }

        @Override
        protected Void doInBackground(final QuizQustionsModel... params) {
            quizDao.insertData(params[0]);
            return null;
        }
    }

}
