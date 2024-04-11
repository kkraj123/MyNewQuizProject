package com.kkraj.quizapp.ui.questionView.viewModel;

import android.app.Application;
import android.os.ParcelUuid;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.PopUpToBuilder;

import com.kkraj.quizapp.network.apiResponses.QuizQustionsModel;
import com.kkraj.quizapp.utils.ResponseState;

import java.util.List;

public class QuizViewModel extends AndroidViewModel {
    private QuizRepository quizRepository;
    private MutableLiveData<ResponseState> responseState = new MutableLiveData<>();
    private MutableLiveData<String> errorMessage = new MutableLiveData<>();

    private LiveData<QuizQustionsModel> qustionsModelLiveData;
    private LiveData<List<QuizQustionsModel>> quizQuestionModelList;

    public QuizViewModel(@NonNull Application application) {
        super(application);
        quizRepository = new QuizRepository(application);
        this.qustionsModelLiveData = quizRepository.getQuestions("10","18","medium","multiple");
        quizRepository = new QuizRepository(application);
        quizQuestionModelList = quizRepository.getAllAcounts();
    }


    public LiveData<List<QuizQustionsModel>> getMyAllQustions() { return quizQuestionModelList; }
    public void insert(QuizQustionsModel quizQustionsModelList) { quizRepository.insertQuizQuestions(quizQustionsModelList); }

    public LiveData<QuizQustionsModel> getQustionsModelLiveData(){
        return qustionsModelLiveData;
    }

}
