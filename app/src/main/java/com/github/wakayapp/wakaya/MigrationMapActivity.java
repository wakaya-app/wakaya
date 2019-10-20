package com.github.wakayapp.wakaya;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

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

}
