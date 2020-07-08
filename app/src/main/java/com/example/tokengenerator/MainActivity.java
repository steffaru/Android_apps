package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tkg = (TextView) findViewById(R.id.text_view_id);
        String welcome = "Welcome to ";
        tkg.setText(welcome + getString(R.string.tkg));

        Button btn = (Button) findViewById(R.id.btnGen);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),GenerateToken.class);
                startActivityForResult(intent, 0);
            }
        });
        Button btn2 = (Button) findViewById(R.id.btnAdd);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(),AddNewTokenName.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}