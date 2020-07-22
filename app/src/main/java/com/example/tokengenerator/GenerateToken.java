package com.example.tokengenerator;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tokengenerator.Entity.UserTokenNameContract;gi

import java.security.SecureRandom;
import java.util.ArrayList;


public class GenerateToken extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_token);
        fillSpinner();
        Button btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(this);
    }

    private void fillSpinner() {
        MyDBHelper myDBHelper = new MyDBHelper(getApplicationContext());

        SQLiteDatabase myDatabaseRead = myDBHelper.getReadableDatabase();

        String[] columns = {UserTokenNameContract.UserTokenNameEntry.TOKEN_NAME};
        String[] args = {};

        Cursor cursor = myDatabaseRead.query(UserTokenNameContract.UserTokenNameEntry.USER_TOKEN_NAME, columns, "", args, "", "", "");
        ArrayList<String> names = new ArrayList<String>();
        int i = 0;
        while (cursor.moveToNext()){
            names.add(cursor.getString(0));
            i++;
        }
        Spinner spin = (Spinner) findViewById(R.id.spinner_token);
        spin.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,names));
        cursor.close();
    }

    public String generateToken() {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[48];

        random.nextBytes(bytes);
        String token = Base64.encodeToString(bytes,1);

        return token;
    }

    @Override
    public void onClick(View view) {
        String callTo = generateToken();
        final TextView tokenView = (TextView) findViewById(R.id.tokenView);
        String w = "Token Generado: \n";
        tokenView.setText(w + callTo);
    }
}