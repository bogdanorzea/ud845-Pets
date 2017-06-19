package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PetDbHelper extends SQLiteOpenHelper {
    // Name and version information about the database
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";

    // Data types
    public static final String TEXT_TYPE = " TEXT";
    public static final String INTEGER_TYPE = " INTEGER";
    public static final String COMMA_SEPARATOR = ",";
    public static final String NOT_NULL = " NOT NULL";

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PetContract.PetEntry.SQL_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PetContract.PetEntry.SQL_DELETE_PETS_TABLE);
        onCreate(db);
    }
}
