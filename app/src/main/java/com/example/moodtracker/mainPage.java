package com.example.moodtracker;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

public class mainPage extends AppCompatActivity {

    //2)Calendar
    private Button addBtn;

    TextView tvMainPage;
    CalendarView cvMainPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);


        //2)Calendar
        addBtn = (Button) findViewById(R.id.addButton);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentAdd = new Intent(mainPage.this, pickMood.class);

                String selectedDate = tvMainPage.getText().toString();
                intentAdd.putExtra("selectedDate", selectedDate);

                startActivity(intentAdd);
            }
        });

        tvMainPage = findViewById(R.id.textViewDateMainPage);
        cvMainPage = findViewById(R.id.calendarView);

        cvMainPage.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String date = dayOfMonth+"/"+(month+1)+"/"+year;
                tvMainPage.setText(date);
            }
        });

        //BottomNavigation
        BottomNavigationView bottomView = findViewById(R.id.bottomNavigationView);

        bottomView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.quote:
                    Intent intentQuote = new Intent(mainPage.this, quotePage.class);
                    startActivity(intentQuote);
                    return true;
                /*case R.id.diaryRecyler:
                    Intent intentDiary = new Intent(mainPage.this, diaryRecyclerView.class);
                    startActivity(intentDiary);
                    return true;*/
                default:
                    return false;
            }
        });

    }



    //1) Setting
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();

        if (item_id == R.id.setting) {

            Intent intentSetting = new Intent(mainPage.this, Setting.class);
            startActivity(intentSetting);

            return true;
        }
        return false;
    }
}