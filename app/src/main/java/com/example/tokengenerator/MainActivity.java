package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tkg = (TextView) findViewById(R.id.text_view_id);
        String welcome = "Welcome to ";
        tkg.setText(welcome + getString(R.string.tkg));
    }
}