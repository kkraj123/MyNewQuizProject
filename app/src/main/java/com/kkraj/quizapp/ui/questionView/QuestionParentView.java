package com.kkraj.quizapp.ui.questionView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.Gson;
import com.kkraj.quizapp.R;
import com.kkraj.quizapp.dataBase.QuizDao;
import com.kkraj.quizapp.databinding.ActivityQuestionParentViewBinding;
import com.kkraj.quizapp.network.apiResponses.QuizQustionResult;
import com.kkraj.quizapp.network.apiResponses.QuizQustionsModel;
import com.kkraj.quizapp.ui.questionView.adapter.QuestionsAdapter;
import com.kkraj.quizapp.ui.questionView.viewModel.QuizRepository;
import com.kkraj.quizapp.ui.questionView.viewModel.QuizViewModel;
import com.kkraj.quizapp.utils.Utility;

import java.util.List;

public class QuestionParentView extends AppCompatActivity {

    QuizViewModel quizViewModel;
    ActivityQuestionParentViewBinding binding;

   List<QuizQustionsModel> quizQuestionList;
  private boolean isNetworkConnected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuestionParentViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        isNetworkConnected = Utility.isNetworkConnected(this);

        quizViewModel = ViewModelProviders.of(this).get(QuizViewModel.class);
        if (isNetworkConnected){
            getAllQuizQuestions();
        }else {
            getDatabaseQuestionsList();
        }
        setTime();
    }

    private void getDatabaseQuestionsList() {
           quizViewModel.getMyAllQustions().observe(this, new Observer<List<QuizQustionsModel>>() {
               @Override
               public void onChanged(List<QuizQustionsModel> quizQustionsModels) {
                   quizQuestionList = quizQustionsModels;
                   for (int i = 0; i < quizQustionsModels.size(); i++){
                       configureViewpager(quizQuestionList.get(i).getGetQuizQustionResult());
                   }
               }
           });

    }

    private void getAllQuizQuestions() {
        quizViewModel.getQustionsModelLiveData().observe(this, quizQustionsModel -> {
            if (quizQustionsModel != null) {
                List<QuizQustionResult> quizQustionResultList = quizQustionsModel.getGetQuizQustionResult();
                configureViewpager(quizQustionResultList);

                /*binding.questionsTV.setText("Questions " + currentIndex++ +"/" + quizQustionsModels.size());
                progress = (int)((float)currentIndex/ quizQustionsModels.size() * 100 );
                binding.questionProgressIndicator.setProgressCompat(progress,true);
                setQuestionAndoptions(quizQustionsModels);
                Log.d("SecondScreen", "questionsListSize" + quizQustionsModels.size());
                Log.d("SecondScreen", "questionsLisResult" + new Gson().toJson(quizQustionsModel));*/
            }
        });
    }

    private void configureViewpager(List<QuizQustionResult> quizQustionResultList) {
        QuestionsAdapter questionsAdapter = new QuestionsAdapter(getSupportFragmentManager());
        for (QuizQustionResult quizQustionResult : quizQustionResultList) {
            questionsAdapter.addFragment(QuestionView.newInstance(quizQustionResult));
        }
        binding.viewpager.setAdapter(questionsAdapter);
        //binding.viewpager.setCurrentItem(0);

    }
    private void setTime() {
        new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Long seconds = millisUntilFinished / 1000;
                binding.timerTV.setText(seconds + " Sec");
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

}