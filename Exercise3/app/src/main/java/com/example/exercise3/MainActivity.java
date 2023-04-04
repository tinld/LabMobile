package com.example.exercise3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Date;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Button btn = findViewById(R.id.show_button);
        AlertDialog ad = new AlertDialog.Builder(this).create();
        setContentView(R.layout.activity_main);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date t = new Date();
                String message = "Thoi gian hien hanh" + t;
                ad.setMessage(message);
                ad.show();
            }
        });
    }
}