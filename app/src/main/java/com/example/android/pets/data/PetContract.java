package com.example.android.pets.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class PetContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.pets";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_PETS = "pets";

    private PetContract() {
    }

    public final static class PetEntry implements BaseColumns {
        // URI to access pet data into the provider
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_PETS);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of pets.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single pet.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_PETS + "/#";

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

        public static boolean isValid(int gender) {
            return (gender == GENDER_FEMALE || gender == GENDER_MALE || gender == GENDER_UNKNOWN);
        }
    }
}
