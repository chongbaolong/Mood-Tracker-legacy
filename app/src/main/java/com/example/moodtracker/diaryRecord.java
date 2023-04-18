package com.example.moodtracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class diaryRecord extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_record);

        //back navigation
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView);

        //        DiaryDBHelper dbHelper = new DiaryDBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        String[] projection = {
//                DiaryContract.DiaryEntry.COLUMN_SELECTED_DATE,
//                DiaryContract.DiaryEntry.COLUMN_SELECTED_EMOJI,
//                DiaryContract.DiaryEntry.COLUMN_TITLE,
//                DiaryContract.DiaryEntry.COLUMN_CONTENT
//        };
//
//        String selectedDate = getIntent().getStringExtra("selectedDate");
//
//        String selection = DiaryContract.DiaryEntry.COLUMN_SELECTED_DATE + " = ?";
//        String[] selectionArgs = { selectedDate };
//
//        Cursor cursor = db.query(
//                DiaryContract.DiaryEntry.TABLE_NAME,
//                projection,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null
//        );
//
//        if (cursor.moveToFirst()) {
//            do {
//                String selectedEmoji = cursor.getString(cursor.getColumnIndexOrThrow(DiaryContract.DiaryEntry.COLUMN_SELECTED_EMOJI));
//                String title = cursor.getString(cursor.getColumnIndexOrThrow(DiaryContract.DiaryEntry.COLUMN_TITLE));
//                String content = cursor.getString(cursor.getColumnIndexOrThrow(DiaryContract.DiaryEntry.COLUMN_CONTENT));
//
//                // Update the TextView and ImageView with the retrieved data
//                TextView tvSelectedDate = findViewById(R.id.textViewSelectedDate);
//                tvSelectedDate.setText(selectedDate);
//
//                ImageView ivSelectedEmoji = findViewById(R.id.imageViewSelectedEmoji);
//                if ("happy".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.happy);
//                } else if ("sad".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.sad);
//                } else if ("angry".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.angry);
//                } else if ("confuse".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.confused);
//                } else if ("speechless".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.speechless);
//                } else if ("meh".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.meh);
//                } else if ("anxious".equals(selectedEmoji)){
//                    ivSelectedEmoji.setImageResource(R.drawable.anxious);
//                } else {
//                    ivSelectedEmoji.setImageResource(R.drawable.error);
//                }
//
//                TextView tvTitle = findViewById(R.id.textViewTitle);
//                tvTitle.setText(title);
//
//                TextView tvContent = findViewById(R.id.textViewContent);
//                tvContent.setText(content);
//
//            } while (cursor.moveToNext());
//        }
//
//        cursor.close();
//        db.close();

//        DiaryDBHelper dbHelper = new DiaryDBHelper(this);
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//
//        String[] projection = {
//                DiaryContract.DiaryEntry.COLUMN_SELECTED_DATE,
//                DiaryContract.DiaryEntry.COLUMN_SELECTED_EMOJI,
//                DiaryContract.DiaryEntry.COLUMN_TITLE,
//                DiaryContract.DiaryEntry.COLUMN_CONTENT
//        };
//
//        String selectedDate = getIntent().getStringExtra("selectedDate");
//
//        String selection = DiaryContract.DiaryEntry.COLUMN_SELECTED_DATE + " = ?";
//        String[] selectionArgs = { selectedDate };
//
//        Cursor cursor = db.query(
//                DiaryContract.DiaryEntry.TABLE_NAME,
//                projection,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null
//        );
//
//        if (cursor.moveToFirst()) {
//            String selectedEmoji = cursor.getString(cursor.getColumnIndexOrThrow(DiaryContract.DiaryEntry.COLUMN_SELECTED_EMOJI));
//            String title = cursor.getString(cursor.getColumnIndexOrThrow(DiaryContract.DiaryEntry.COLUMN_TITLE));
//            String content = cursor.getString(cursor.getColumnIndexOrThrow(DiaryContract.DiaryEntry.COLUMN_CONTENT));
//
//            // Update the TextView and ImageView with the retrieved data
//            TextView tvSelectedDate = findViewById(R.id.textViewSelectedDate);
//            tvSelectedDate.setText(selectedDate);
//
//            ImageView ivSelectedEmoji = findViewById(R.id.imageViewSelectedEmoji);
//            if ("happy".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.happy);
//            } else if ("sad".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.sad);
//            } else if ("angry".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.angry);
//            } else if ("confused".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.confused);
//            } else if ("speechless".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.speechless);
//            } else if ("meh".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.meh);
//            } else if ("anxious".equals(selectedEmoji)){
//                ivSelectedEmoji.setImageResource(R.drawable.anxious);
//            } else {
//                ivSelectedEmoji.setImageResource(R.drawable.error);
//            }
//
//            TextView tvTitle = findViewById(R.id.textViewTitle);
//            tvTitle.setText(title);
//
//            TextView tvContent = findViewById(R.id.textViewContent);
//            tvContent.setText(content);
//        }
//
//        cursor.close();
//        db.close();
    }
}