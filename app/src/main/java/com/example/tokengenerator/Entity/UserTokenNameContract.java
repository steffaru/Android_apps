package com.example.tokengenerator.Entity;

import android.provider.BaseColumns;

public final class UserTokenNameContract {
    private UserTokenNameContract(){}

    public class UserTokenNameEntry implements BaseColumns {

        public static final String USER_TOKEN_NAME = "USER_TOKEN_NAME";

        public static final String TOKEN_NAME = "TOKEN_NAME";

    }
}
