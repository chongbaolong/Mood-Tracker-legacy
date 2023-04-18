package com.example.moodtracker;

import android.provider.BaseColumns;

public class DiaryContract {

    private DiaryContract() {
        // Private constructor to prevent instantiation
    }

    public static class DiaryEntry implements BaseColumns {

        public static final String TABLE_NAME = "diary";
        public static final String COLUMN_SELECTED_DATE = "selected_date";
        public static final String COLUMN_SELECTED_EMOJI = "selected_emoji";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_CONTENT = "content";
    }
}
