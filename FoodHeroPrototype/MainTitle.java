package com.example.projectprototype;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Switch;

public class MainTitle extends AppCompatActivity implements View.OnClickListener {

    private Button newMeal;
    private Button history;
    private ProgressBar experienceBar;
    private int progress = 0;
    private Button credits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.title_main);


        newMeal = (Button) findViewById(R.id.newMealButton);
        history = (Button) findViewById(R.id.historyButton);
        credits = (Button) findViewById(R.id.creditsButton);
        experienceBar = (ProgressBar) findViewById(R.id.progressBar);

        newMeal.setOnClickListener(this);
        history.setOnClickListener(this);
        credits.setOnClickListener(this);

        experienceBar.setMax(100);

        //int xpAddition = getIntent().getIntExtra("progress", 0);
        //progress += xpAddition;
        //experienceBar.setProgress(progress * 5);

    }

    @Override
    public void onClick(View v) {

        Intent startNewMealIntent = new Intent(this, MealSelect.class);
        Intent startHistoryIntent = new Intent(this, HistoryScreen.class);
        Intent startCreditsIntent = new Intent(this, CreditsPage.class);

        switch(v.getId()){
            case R.id.newMealButton:
                this.startActivity(startNewMealIntent);
                break;
            case R.id.historyButton:
                this.startActivity(startHistoryIntent);
                break;
            case R.id.creditsButton:
                this.startActivity(startCreditsIntent);
        }
    }
}