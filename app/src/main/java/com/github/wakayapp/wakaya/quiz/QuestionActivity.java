package com.github.wakayapp.wakaya.quiz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.wakayapp.wakaya.R;

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MainActivityTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
    }
}
