package com.example.moodtracker;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class diaryPage extends AppCompatActivity {

    private EditText titleDiary;
    private EditText contentDiary;
    private ConstraintLayout contentLayout;

    private Button saveAll;
    private Button loadAll;
    private Button deleteAll;

    private TextView tvDate;
    private TextView tvEmoji;
    private ImageView emojiImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_page);

        //back navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        titleDiary = findViewById(R.id.diaryTitleInputText);
        contentDiary = findViewById(R.id.diaryContentInputText);

        saveAll = findViewById(R.id.saveButton);
        loadAll = findViewById(R.id.loadButton);
        deleteAll = findViewById(R.id.deleteButton);

        // Get selectedDate and selectedEmoji from previous
        String selectedDateDiary = getIntent().getStringExtra("selectedDate");
        tvDate = findViewById(R.id.dateText);
        tvDate.setText(selectedDateDiary);

        String selectedEmojiDiary = getIntent().getStringExtra("selectedEmoji");
        tvEmoji = findViewById(R.id.moodSelectedText);
        tvEmoji.setText(selectedEmojiDiary + "~");

        emojiImage = findViewById(R.id.moodSelectedImage);

        byte[] byteArray = getIntent().getByteArrayExtra("emojiImage");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        emojiImage.setImageBitmap(bitmap);

        BottomNavigationView bottomView = findViewById(R.id.bottomNavigationView2);

        //contentLayout = findViewById(R.id.contentLayout);

        //bottom navigation for 1.Align button 2.Insert picture button 3.Emoji & Sticker button

        bottomView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                //case R.id.item1:
                //insert text
                //TextView inputText = new TextView(this);
                //inputText.setText("Hello, World!");

/*
                    // create a new AlertDialog builder
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    // set the title and message of the dialog
                    builder.setTitle("Enter Text");
                    builder.setMessage("Please enter some text:");

                    // create a new EditText view and set it as the dialog's view
                    final EditText input = new EditText(this);
                    builder.setView(input);

                    // set the positive button to save the entered text
                    builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (contentLayout.getChildCount() == 0) {
                                String enteredText = input.getText().toString();
                                inputText.setText(enteredText);
                            }
                        }
                    });

                    // set the negative button to cancel the dialog
                    builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    // show the dialog
                    AlertDialog dialog = builder.create();
                    dialog.show();*/



                //contentLayout.addView(inputText);
                // return true;

                case R.id.item1:
                    //insert picture
                    Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    return true;

                case R.id.item2:
                    //insert emoji & sticker
                    return true;

                default:
                    return false;
            }
        });

        DiaryDBHelper dbHelper = new DiaryDBHelper(diaryPage.this);

        saveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleDiary.getText().toString();
                String content = contentDiary.getText().toString();

                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(diaryPage.this, "Please enter title...", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(content)) {
                    Toast.makeText(diaryPage.this, "Please enter your story...", Toast.LENGTH_SHORT).show();
                } else {

                    // bitmap
                    // selectedEmojiDiary
                    // selectedDateDiary
                    String selectedDate = getIntent().getStringExtra("selectedDate");
                    String selectedEmoji = getIntent().getStringExtra("selectedEmoji");
                    String diaryTitle = ((TextInputEditText) findViewById(R.id.diaryTitleInputText)).getText().toString();
                    String diaryContent = ((TextInputEditText) findViewById(R.id.diaryContentInputText)).getText().toString();

                    SQLiteDatabase db = dbHelper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(Diary.DiaryEntry.COLUMN_SELECTED_DATE, selectedDate);
                    values.put(Diary.DiaryEntry.COLUMN_SELECTED_EMOJI, selectedEmoji);
                    values.put(Diary.DiaryEntry.COLUMN_TITLE, diaryTitle);
                    values.put(Diary.DiaryEntry.COLUMN_CONTENT, diaryContent);

                    long newRowId = db.insert(Diary.DiaryEntry.TABLE_NAME, null, values);

                    if (newRowId == -1) {
                        Toast.makeText(diaryPage.this, "Error: Failed to save data to database", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(diaryPage.this, "Saved! Live in the moment! \n My Friend!", Toast.LENGTH_SHORT).show();
                    }

                    /*Intent intent = new Intent(diaryPage.this, mainPage.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();*/
                }

            }
        });

        loadAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Define a projection that specifies which columns from the database
                // you will actually use after this query.
                String[] projection = {
                        Diary.DiaryEntry._ID,
                        Diary.DiaryEntry.COLUMN_TITLE,
                        Diary.DiaryEntry.COLUMN_CONTENT,
                        Diary.DiaryEntry.COLUMN_SELECTED_DATE,
                        Diary.DiaryEntry.COLUMN_SELECTED_EMOJI
                };

                // Filter results WHERE "title" = 'My Title'
                String selection = null;
                String[] selectionArgs = null;

                // How you want the results sorted in the resulting Cursor
                String sortOrder =
                        Diary.DiaryEntry.COLUMN_SELECTED_DATE + " DESC";

                List<Diary.DiaryEntry> entries = new ArrayList<>();

                try (SQLiteDatabase db = dbHelper.getReadableDatabase()) {
                    Cursor cursor = db.query(
                            Diary.DiaryEntry.TABLE_NAME,   // The table to query
                            projection,                                 // The columns to return
                            selection,                                  // The columns for the WHERE clause
                            selectionArgs,                              // The values for the WHERE clause
                            null,                                       // Don't group the rows
                            null,                                       // Don't filter by row groups
                            sortOrder                                   // The sort order
                    );

                    while (cursor.moveToNext()) {
                        int id = cursor.getInt(
                                cursor.getColumnIndexOrThrow(Diary.DiaryEntry._ID));
                        String dateStr = cursor.getString(
                                cursor.getColumnIndexOrThrow(Diary.DiaryEntry.COLUMN_SELECTED_DATE)); //2023/04/18
                        String emojiStr = cursor.getString(
                                cursor.getColumnIndexOrThrow(Diary.DiaryEntry.COLUMN_SELECTED_EMOJI));
                        String title = cursor.getString(
                                cursor.getColumnIndexOrThrow(Diary.DiaryEntry.COLUMN_TITLE));
                        String content = cursor.getString(
                                cursor.getColumnIndexOrThrow(Diary.DiaryEntry.COLUMN_CONTENT));
                        //DiaryEntry entry = new Diary(id, dateStr, emojiStr, title, content);
                        if(dateStr.equals(selectedDateDiary)){
                            titleDiary.setText(title);
                            contentDiary.setText(content);
                        }
                        //entries.add(entry);
                    }
                    cursor.close();
                } catch (SQLException e) {
                    // handle exception
                }

            }
        });

        deleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String selectedDate = getIntent().getStringExtra("selectedDate");

                SQLiteDatabase db = dbHelper.getWritableDatabase();

                String selection = Diary.DiaryEntry.COLUMN_SELECTED_DATE + " LIKE ?";
                String[] selectionArgs = { selectedDate };

                db.delete(Diary.DiaryEntry.TABLE_NAME, selection, selectionArgs);

            }
        });

    }

}