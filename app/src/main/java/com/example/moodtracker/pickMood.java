package com.example.moodtracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    //Variable
    String selectedEmoji;

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
            selectedEmoji = "happy";
            showToast("Great to hear that you had an amazing day xD");
            jumpToDiaryPage();
        });

        angryFace.setOnClickListener(v -> {
            selectedEmoji = "angry";
            showToast("Completely normal to feel angry sometimes!");
            jumpToDiaryPage();
        });

        anxiousFace.setOnClickListener(v -> {
            selectedEmoji = "anxious";
            showToast("Chill and Relax, My Friend :)");
            jumpToDiaryPage();
        });

        confuseFace.setOnClickListener(v -> {
            selectedEmoji = "confuse";
            showToast("Get some rest! Don't think too much!");
            jumpToDiaryPage();
        });

        mehFace.setOnClickListener(v -> {
            selectedEmoji = "meh";
            showToast("Do something that you enjoy the most :)");
            jumpToDiaryPage();
        });

        sadFace.setOnClickListener(v -> {
            selectedEmoji= "sad";
            showToast("Don't be sad. Express your feeling out!!!");
            jumpToDiaryPage();
        });

        speechlessFace.setOnClickListener(v -> {
            selectedEmoji = "speechless";
            showToast("Is something not going well?");
            jumpToDiaryPage();
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Jump to diaryPage
    private void jumpToDiaryPage() {
        Intent intent = new Intent(pickMood.this, diaryPage.class);
        intent.putExtra("selectedDate", getIntent().getStringExtra("selectedDate"));
        intent.putExtra("selectedEmoji", selectedEmoji);
        startActivity(intent);
    }
}