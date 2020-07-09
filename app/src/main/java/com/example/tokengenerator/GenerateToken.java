package com.example.tokengenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import android.util.Base64;
import java.util.HashSet;
import java.util.Set;


public class GenerateToken extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate_token);
        Button btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnGenerate.setOnClickListener(this);
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