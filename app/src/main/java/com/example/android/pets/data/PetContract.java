package com.example.android.pets.data;

import android.provider.BaseColumns;

public class PetContract {

    private PetContract(){}

    public final static class PetEntry implements BaseColumns {
        // SQL CREATE schema statement
        static final String SQL_CREATE_PETS_TABLE =
                "CREATE TABLE " + PetEntry.TABLE_NAME + " (" +
                        PetEntry._ID + PetDbHelper.INTEGER_TYPE + " PRIMARY KEY AUTOINCREMENT" + PetDbHelper.COMMA_SEPARATOR +
                        PetEntry.COLUMN_PET_NAME + PetDbHelper.TEXT_TYPE + PetDbHelper.NOT_NULL + PetDbHelper.COMMA_SEPARATOR +
                        PetEntry.COLUMN_PET_BREED + PetDbHelper.TEXT_TYPE + PetDbHelper.COMMA_SEPARATOR +
                        PetEntry.COLUMN_PET_GENDER + PetDbHelper.INTEGER_TYPE + PetDbHelper.NOT_NULL + PetDbHelper.COMMA_SEPARATOR +
                        PetEntry.COLUMN_PET_WEIGHT + PetDbHelper.INTEGER_TYPE + PetDbHelper.NOT_NULL + " DEFAULT 0" + ")";
        // SQL DELETE table statement
        static final String SQL_DELETE_PETS_TABLE =
                "DROP TABLE IF EXISTS " + PetEntry.TABLE_NAME;

        // Table name
        public final static String TABLE_NAME = "pets";

        // Column names
        public final static String _ID = BaseColumns._ID;
        public final static String COLUMN_PET_NAME = "name";
        public final static String COLUMN_PET_BREED = "breed";
        public final static String COLUMN_PET_GENDER = "gender";
        public final static String COLUMN_PET_WEIGHT = "weight";

        // Gender constants
        public final static int GENDER_UNKNOWN = 0;
        public final static int GENDER_MALE = 1;
        public final static int GENDER_FEMALE = 2;

    }
}
