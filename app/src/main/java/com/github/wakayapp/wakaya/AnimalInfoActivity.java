package com.github.wakayapp.wakaya;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class AnimalInfoActivity extends AppCompatActivity {

    public static final String ANIMAL_ACTIVITY_ID = AnimalInfoActivity.class.getName();

    private static final int TURTLE_ID = R.layout.activity_turtle_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.MainActivityTheme);
        super.onCreate(savedInstanceState);

        final int activityId = getIntent().getIntExtra(ANIMAL_ACTIVITY_ID, Integer.MIN_VALUE);
        if (activityId == Integer.MIN_VALUE) {
            throw new RuntimeException("Invalid ID");
        }
        setContentView(activityId);
    }

    public void changeToMigrationMap(final View view) {
        final Intent intent = new Intent(this, MigrationMapActivity.class);
        intent.putExtra(MigrationMapActivity.MIGRATION_MAP_ACTIVITY_ID, TURTLE_ID);
        startActivity(intent);
    }

}
