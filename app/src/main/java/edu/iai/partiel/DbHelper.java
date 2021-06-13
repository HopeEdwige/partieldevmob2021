package edu.iai.partiel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;

    private final String SCORE_CREATE = "CREATE TABLE score(" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "score INT," +
            "date VARCHAR(40)" +
            ");";
    public DbHelper(@Nullable Context context) {
        super(context, "score_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SCORE_CREATE);
        this.database = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.database = db;
    }

    public SQLiteDatabase getDatabase() {
        return this.getWritableDatabase();
    }

    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }
}