package com.kkraj.quizapp.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.kkraj.quizapp.databinding.ActivityMainBinding;

import com.kkraj.quizapp.R;
import com.kkraj.quizapp.ui.loginView.LoginScreen;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new LoginScreen())
                .commit();

    }

}