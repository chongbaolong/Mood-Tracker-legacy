package com.example.moodtracker;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class pickMood extends AppCompatActivity {

    //2)
    TextView tv;

    //Emoji Variable
    private ImageView happyFace;
    private ImageView angryFace;
    private ImageView anxiousFace;
    private ImageView confuseFace;
    private ImageView mehFace;
    private ImageView sadFace;
    private ImageView speechlessFace;

    //Show today Date
    //String selectedDate = getIntent().getStringExtra("selectedDate");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_mood);

        //backNavigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Show today Date
        String selectedDate = getIntent().getStringExtra("selectedDate");
        tv = findViewById(R.id.textViewDate);
        tv.setText(" "+selectedDate+".");

        //Click Emoji
        happyFace = findViewById(R.id.happyEmoji);
        angryFace = findViewById(R.id.angryEmoji);
        anxiousFace = findViewById(R.id.anxiousEmoji);
        confuseFace = findViewById(R.id.confuseEmoji);
        mehFace = findViewById(R.id.mehEmoji);
        sadFace = findViewById(R.id.sadEmoji);
        speechlessFace = findViewById(R.id.speechlessEmoji);

        happyFace.setOnClickListener(v -> {
            showToast("Great to hear that you had an amazing day xD");
            jumpToDiaryPage(selectedDate);
        });

        angryFace.setOnClickListener(v -> {
            showToast("Completely normal to feel angry sometimes!");
            jumpToDiaryPage(selectedDate);
        });

        anxiousFace.setOnClickListener(v -> {
            showToast("Chill and Relax, My Friend :)");
            jumpToDiaryPage(selectedDate);
        });

        confuseFace.setOnClickListener(v -> {
            showToast("Get some rest! Don't think too much!");
            jumpToDiaryPage(selectedDate);
        });

        mehFace.setOnClickListener(v -> {
            showToast("Do something that you enjoy the most :)");
            jumpToDiaryPage(selectedDate);
        });

        sadFace.setOnClickListener(v -> {
            showToast("Don't be sad. Express your feeling out!!!");
            jumpToDiaryPage(selectedDate);
        });

        speechlessFace.setOnClickListener(v -> {
            showToast("Is something not going well?");
            jumpToDiaryPage(selectedDate);
        });

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Jump to diaryPage
    private void jumpToDiaryPage(String selectedDate) {
        Intent intent = new Intent(pickMood.this, diaryPage.class);


        intent.putExtra("selectedDate", selectedDate);

        startActivity(intent);
    }

}