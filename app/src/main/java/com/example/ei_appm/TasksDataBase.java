package com.example.ei_appm;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TasksDataBase extends SQLiteOpenHelper {

        private static final String TABLE_LIVRES = "table_tasks";
        private static final String COL_ID = "ID";
        private static final String COL_NAME = "NAME";

        private static final String CREATE_BDD = "CREATE TABLE " + TABLE_LIVRES + " (" +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT NOT NULL);";

        public TasksDataBase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super (context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_BDD);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE " + TABLE_LIVRES);
            onCreate(db);
        }
}