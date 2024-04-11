package com.kkraj.quizapp.ui.questionView;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.kkraj.quizapp.databinding.FragmentSecondScreenBinding;
import com.kkraj.quizapp.network.apiResponses.QuizQustionResult;

import java.util.ArrayList;
import java.util.List;

public class QuestionView extends Fragment {
    private FragmentSecondScreenBinding binding;
    private List<QuizQustionResult> quizQustionsModels = new ArrayList<>();
    private int currentIndex = 1;
    private int progress;


    public static QuestionView newInstance(QuizQustionResult quizQustionResult) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("quizQustionResult", quizQustionResult);
        QuestionView fragment = new QuestionView();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondScreenBinding.inflate(getLayoutInflater());
        //setTime();
        //listener();
        if(getArguments()!=null){
            QuizQustionResult quizQustionResult = (QuizQustionResult) getArguments().getSerializable("quizQustionResult");
            if(quizQustionResult!= null){
                setData(quizQustionResult);
            }
        }
        return binding.getRoot();
    }

    private void setData(QuizQustionResult quizQustionResult) {
        binding.radioBtnParentLayout.removeAllViews();
        binding.questionViewTV.setText(quizQustionResult.getQuestion());
        List<String> dataList = new ArrayList<>();
        dataList.add(quizQustionResult.getCorrectAnswer());

        for(String incorrectAnswer: quizQustionResult.getIncorrectAnswers()){{
            dataList.add(incorrectAnswer);
        }}

        //preparing radio buttons

        RadioGroup radioGroup = new RadioGroup(requireContext());
        radioGroup.setOrientation(RadioGroup.VERTICAL);

        for(String data: dataList){
            RadioButton radioButton = new RadioButton(requireContext());
            radioButton.setText(data);
            radioButton.setPadding(10,10,10,10);
            radioGroup.addView(radioButton);
        }
        binding.radioBtnParentLayout.addView(radioGroup);

    }

    private void listener() {
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


    private void setQuestionAndoptions(List<QuizQustionResult> quizQustionsModels) {
        binding.questionViewTV.setText(quizQustionsModels.get(currentIndex).getQuestion());

    }
}