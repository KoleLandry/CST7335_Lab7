package com.landrykole.testtoolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button that sends user to the Toolbar Page
        Button button = findViewById(R.id.button);
        button.setOnClickListener(v ->
                startActivity(new Intent(ProfileActivity.this, TestToolbar.class)));
    }
}