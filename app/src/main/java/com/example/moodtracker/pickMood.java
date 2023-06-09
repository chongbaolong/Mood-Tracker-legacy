package com.example.moodtracker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moodtracker.utils.Shared;

import java.io.ByteArrayOutputStream;

public class pickMood extends AppCompatActivity {

    //2)
    TextView tv;
    TextView tv2;
    TextView tv3;

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

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_mood);

        //backNavigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Shared.initialize(getBaseContext());

        mp = MediaPlayer.create(getApplicationContext(), R.raw.btn_sound);

        //Show today Date
        String selectedDate = getIntent().getStringExtra("selectedDate");
        tv = findViewById(R.id.textViewDate);
        tv.setText(" "+selectedDate+".");

        tv2 = findViewById(R.id.textView);
        tv3 = findViewById(R.id.textViewHello);

        tv.setTypeface(Shared.fontRegular);
        tv2.setTypeface(Shared.fontLight);
        tv3.setTypeface(Shared.fontLight);

        //Click Emoji
        happyFace = findViewById(R.id.happyEmoji);
        angryFace = findViewById(R.id.angryEmoji);
        anxiousFace = findViewById(R.id.anxiousEmoji);
        confuseFace = findViewById(R.id.confuseEmoji);
        mehFace = findViewById(R.id.mehEmoji);
        sadFace = findViewById(R.id.sadEmoji);
        speechlessFace = findViewById(R.id.speechlessEmoji);

        happyFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji = "happy";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) happyFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Great to hear that you had an amazing day xD");

            jumpToDiaryPage(byteArray);
        });

        angryFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji = "angry";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) angryFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Completely normal to feel angry sometimes!");

            jumpToDiaryPage(byteArray);
        });

        anxiousFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji = "anxious";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) anxiousFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Chill and Relax, My Friend :)");
            jumpToDiaryPage(byteArray);
        });

        confuseFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji = "confuse";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) confuseFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Get some rest! Don't think too much!");
            jumpToDiaryPage(byteArray);
        });

        mehFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji = "meh";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) mehFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Do something that you enjoy the most :)");
            jumpToDiaryPage(byteArray);
        });

        sadFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji= "sad";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) sadFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Don't be sad. Express your feeling out!!!");
            jumpToDiaryPage(byteArray);
        });

        speechlessFace.setOnClickListener(v -> {
            mp.start();
            selectedEmoji = "speechless";
            BitmapDrawable bitmapDrawable = (BitmapDrawable) speechlessFace.getDrawable();
            Bitmap bitmap = bitmapDrawable.getBitmap();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] byteArray = stream.toByteArray();

            showToast("Is something not going well?");
            jumpToDiaryPage(byteArray);
        });

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Jump to diaryPage
    private void jumpToDiaryPage(byte[] byteArray) {
        Intent intent = new Intent(pickMood.this, diaryPage.class);
        intent.putExtra("selectedDate", getIntent().getStringExtra("selectedDate"));
        intent.putExtra("selectedEmoji", selectedEmoji);
        intent.putExtra("emojiImage", byteArray);
        startActivity(intent);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

}