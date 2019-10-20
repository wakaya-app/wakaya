package com.github.wakayapp.wakaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.wakayapp.wakaya.quiz.DataPresentationActivity;

public class MigrationMapActivity  extends AppCompatActivity {

    public static final String MIGRATION_MAP_ACTIVITY_ID = MigrationMapActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MainActivityTheme);
        super.onCreate(savedInstanceState);

        final int activityId = getIntent().getIntExtra(MIGRATION_MAP_ACTIVITY_ID, Integer.MIN_VALUE);
        if (activityId == Integer.MIN_VALUE) {
            throw new RuntimeException("Invalid ID");
        }
        setContentView(activityId);
    }

    public void changeToDataPresentation(final View view) {
        final Intent intent = new Intent(this, DataPresentationActivity.class);
        startActivity(intent);
    }
}
