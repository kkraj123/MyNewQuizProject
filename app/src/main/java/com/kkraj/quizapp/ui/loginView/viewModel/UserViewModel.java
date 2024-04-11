package com.kkraj.quizapp.ui.loginView.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kkraj.quizapp.network.apiResponses.UserNameModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class UserViewModel extends ViewModel {
    private final LoginUserRepository loginUserRepository;
    private final LiveData<List<UserNameModel>> allUsers;


    @Inject
    public UserViewModel(LoginUserRepository loginUserRepository){
        this.loginUserRepository = loginUserRepository;
        allUsers = loginUserRepository.getAllDatas();
    }
    public LiveData<List<UserNameModel>> getAllData() {
        return allUsers;
    }
    public void saveUser(UserNameModel entity) {
        loginUserRepository.saveUserInDb(entity);
    }
}
