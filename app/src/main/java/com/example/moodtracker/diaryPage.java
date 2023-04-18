package com.example.moodtracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class diaryPage extends AppCompatActivity {

    private EditText titleDiary;
    private EditText contentDiary;
    private Button saveAll;

    //Variable Date/Emoji
    private TextView tvDate;
    private TextView tvEmoji;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_page);

        titleDiary = findViewById(R.id.titleEditText);
        contentDiary = findViewById(R.id.contentEditText);

        saveAll = findViewById(R.id.saveButton);

        // Get selectedDate and selectedEmoji from previous
        String selectedDateDiary = getIntent().getStringExtra("selectedDate");
        tvDate = findViewById(R.id.textViewSelectedDate);
        tvDate.setText(selectedDateDiary);

        String selectedEmojiDiary = getIntent().getStringExtra("selectedEmoji");
        tvEmoji = findViewById(R.id.textViewSelectedEmoji);
        tvEmoji.setText(selectedEmojiDiary);

        saveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String title = titleDiary.getText().toString().trim();
//                String content = contentDiary.getText().toString().trim();
//
//                if (TextUtils.isEmpty(title)){
//                    Toast.makeText(diaryPage.this, "Please Enter Title!!!", Toast.LENGTH_SHORT).show();
//                } else if(TextUtils.isEmpty(content)){
//                    Toast.makeText(diaryPage.this, "Please Enter Content!!!", Toast.LENGTH_SHORT).show();
//                } else {
//
//                    String selectedDate = getIntent().getStringExtra("selectedDate");
//                    String selectedEmoji = getIntent().getStringExtra("selectedEmoji");
//
//                    MyDatabaseHelper myDB = new MyDatabaseHelper(diaryPage.this);
//                    myDB.addDiary(selectedDate, selectedEmoji, title, content);
//
//                    Intent intent = new Intent(diaryPage.this, mainPage.class);
//                    startActivity(intent);
//
//                    finish();

                String title = titleDiary.getText().toString();
                String content = contentDiary.getText().toString();

                if (TextUtils.isEmpty(title)){
                    Toast.makeText(diaryPage.this, "Please Enter Title!!!", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(content)){
                    Toast.makeText(diaryPage.this, "Please Enter Content!!!", Toast.LENGTH_SHORT).show();
                } else {

                    String selectedDate = getIntent().getStringExtra("selectedDate");
                    String selectedEmoji = getIntent().getStringExtra("selectedEmoji");

                    DiaryDBHelper dbHelper = new DiaryDBHelper(diaryPage.this);
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    ContentValues values = new ContentValues();

                    values.put(DiaryContract.DiaryEntry.COLUMN_SELECTED_DATE, selectedDate);
                    values.put(DiaryContract.DiaryEntry.COLUMN_SELECTED_EMOJI, selectedEmoji);
                    values.put(DiaryContract.DiaryEntry.COLUMN_TITLE, title);
                    values.put(DiaryContract.DiaryEntry.COLUMN_CONTENT, content);

                    long newRowId = db.insert(DiaryContract.DiaryEntry.TABLE_NAME, null, values);

                    if(newRowId != -1) {
                        Toast.makeText(diaryPage.this, "Saved! Live in the moment! \n My Friend xD", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(diaryPage.this, "Error Saving Data!", Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(diaryPage.this, mainPage.class);
                    startActivity(intent);

                    finish();
                }

            }
        });
    }
}
