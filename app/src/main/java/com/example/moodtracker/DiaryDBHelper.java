package com.example.moodtracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DiaryDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "diary.db";
    private static final int DATABASE_VERSION = 1;

    public DiaryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create the diary table
        String SQL_CREATE_DIARY_TABLE = "CREATE TABLE " + DiaryContract.DiaryEntry.TABLE_NAME + " ("
                + DiaryContract.DiaryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DiaryContract.DiaryEntry.COLUMN_SELECTED_DATE + " TEXT NOT NULL, "
                + DiaryContract.DiaryEntry.COLUMN_SELECTED_EMOJI + " TEXT NOT NULL, "
                + DiaryContract.DiaryEntry.COLUMN_TITLE + " TEXT NOT NULL, "
                + DiaryContract.DiaryEntry.COLUMN_CONTENT + " TEXT NOT NULL);";
        db.execSQL(SQL_CREATE_DIARY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_DELETE_DIARY_TABLE = "DROP TABLE IF EXISTS " + DiaryContract.DiaryEntry.TABLE_NAME;
        db.execSQL(SQL_DELETE_DIARY_TABLE);
        onCreate(db);
    }
}
