package com.kkraj.quizapp.ui.loginView.viewModel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.kkraj.quizapp.dataBase.UserDao;
import com.kkraj.quizapp.network.apiResponses.UserNameModel;

import java.util.List;

import javax.inject.Inject;

public class LoginUserRepository {
    private final UserDao userDao;

    @Inject
    public LoginUserRepository(UserDao userDao){
        this.userDao = userDao;
    }

    public LiveData<List<UserNameModel>> getAllDatas() {
        return userDao.getAllUser();
    }

    public void saveUserInDb(UserNameModel userName) {
        new InsertAsyncTask(userDao).execute(userName);
    }

    private static class InsertAsyncTask extends AsyncTask<UserNameModel, Void, Void> {
        private final UserDao userDao;

        InsertAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(UserNameModel... entities) {
            userDao.insertUserData(entities[0]);
            return null;
        }
    }
}
