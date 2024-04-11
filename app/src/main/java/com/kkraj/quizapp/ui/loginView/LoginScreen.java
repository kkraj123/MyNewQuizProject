package com.kkraj.quizapp.ui.loginView;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kkraj.quizapp.R;
import com.kkraj.quizapp.databinding.FragmentFirstScreenBinding;
import com.kkraj.quizapp.network.apiResponses.UserNameModel;
import com.kkraj.quizapp.ui.loginView.viewModel.UserViewModel;
import com.kkraj.quizapp.ui.questionView.QuestionParentView;
import com.kkraj.quizapp.ui.questionView.QuestionView;


public class LoginScreen extends Fragment {
    private FragmentFirstScreenBinding binding;
    //private UserViewModel userViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFirstScreenBinding.inflate(inflater, container, false);

        binding.submitBtn.setOnClickListener(v -> {
            startActivity(new Intent(requireActivity(), QuestionParentView.class));

        });

        return binding.getRoot();
    }
}