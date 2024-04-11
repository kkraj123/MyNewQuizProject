package com.kkraj.quizapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kkraj.quizapp.R;
import com.kkraj.quizapp.databinding.FragmentThirdScreenBinding;


public class ThirdScreen extends Fragment {
    private FragmentThirdScreenBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentThirdScreenBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}