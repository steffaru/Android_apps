package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.HashSet;
import java.util.Set;

public class AddNewTokenName extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_token_name);

        Button add = (Button) findViewById(R.id.btnAddNew);
        add.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextInputEditText tokenValue = (TextInputEditText) findViewById(R.id.tokenValue);
        String value = tokenValue.getText().toString();
        if(value != "") {
            SharedPreferences myPreferences
                    = PreferenceManager.getDefaultSharedPreferences(AddNewTokenName.this);
            SharedPreferences.Editor myEditor = myPreferences.edit();

            Set<String> setString = myPreferences.getStringSet("tokens", null);

            if(setString != null) {
                setString.add(value);
            } else {
                setString = new HashSet<String>();
                setString.add(value);
            }
            myEditor.putStringSet("tokens", setString);
            myEditor.commit();
            Toast.makeText(this, value, Toast.LENGTH_SHORT).show();
        }
    }
}