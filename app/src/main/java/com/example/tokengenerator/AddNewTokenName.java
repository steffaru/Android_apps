package com.example.tokengenerator;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tokengenerator.Entity.UserTokenNameContract;
import com.google.android.material.textfield.TextInputEditText;

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
        MyDBHelper myDBHelper = new MyDBHelper(getApplicationContext());

        if(value != "") {
            ContentValues row1 = new ContentValues();

            SQLiteDatabase myDatabase = myDBHelper.getWritableDatabase();

            row1.put(UserTokenNameContract.UserTokenNameEntry.TOKEN_NAME, value);
            myDatabase.insert(UserTokenNameContract.UserTokenNameEntry.USER_TOKEN_NAME, null, row1);

        }

    }

}