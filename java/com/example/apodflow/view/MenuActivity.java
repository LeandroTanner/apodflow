package com.example.apodflow.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.apodflow.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void dateLayout(View view){
        Intent intent = new Intent(MenuActivity.this, DateActivity.class);
        startActivity(intent);
    }

    public void start_end_dateLayout(View view){
        Intent intent = new Intent(MenuActivity.this, Start_End_DateActivity.class);
        startActivity(intent);
    }

    public void countLayout(View view){
        Intent intent = new Intent(MenuActivity.this, CountActivity.class);
        startActivity(intent);
    }

}