package com.github.wakayapp.wakaya.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.wakayapp.wakaya.AnimalInfoActivity;
import com.github.wakayapp.wakaya.MigrationMapActivity;
import com.github.wakayapp.wakaya.R;

public class DataPresentationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MainActivityTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_presentation);
    }

    public void changeToQuestion(final View view) {
        final Intent intent = new Intent(this, QuestionActivity.class);
        startActivity(intent);
    }

}
