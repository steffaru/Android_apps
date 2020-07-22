package com.example.tokengenerator;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tokengenerator.Entity.UserTokenNameContract.UserTokenNameEntry;


public class MyDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 3;
    public static final String DATABASE_NAME = "myDb.tkn";

    public MyDBHelper(Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase tkn) {
        tkn.execSQL("CREATE TABLE " + UserTokenNameEntry.USER_TOKEN_NAME + " (" +
                        UserTokenNameEntry.TOKEN_NAME + " TEXT PRIMARY KEY)"
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase tkn, int oldVersion, int newVersion) {
        tkn.execSQL("DROP TABLE IF EXISTS " + UserTokenNameEntry.USER_TOKEN_NAME);
        onCreate(tkn);
    }
}
