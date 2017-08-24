package com.example.francisco.w4d3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.sql.SQLException;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "food";
    private static final String TABLE_NAME = "dishes";
    private static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME +
            " (_id INTEGER PRIMARY KEY, DISH_NAME TEXT, DISH_REGION, DISH_TYPE, DISH_URL TEXT , DISH_DESC TEXT )";

    private static final String SQL_DROP = "DROP TABLE IS EXISTS " + TABLE_NAME ;

    DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP);
        onCreate(db);
    }

    public Cursor getDishes(String id, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        SQLiteQueryBuilder sqliteQueryBuilder = new SQLiteQueryBuilder();
        sqliteQueryBuilder.setTables(TABLE_NAME);

        if(id != null) {
            sqliteQueryBuilder.appendWhere("_id" + " = " + id);
        }

        if(sortOrder == null || sortOrder == "") {
            sortOrder = "DISH_NAME";
        }
        Cursor cursor = sqliteQueryBuilder.query(getReadableDatabase(),
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder);
        return cursor;
    }

    public long addNewDish(ContentValues values) throws SQLException {
        long id = getWritableDatabase().insert(TABLE_NAME, "", values);
        if(id <=0 ) {
            throw new SQLException("Failed to add an dish");
        }

        return id;
    }

    public int deleteDish(String id) {
        if(id == null) {
            return getWritableDatabase().delete(TABLE_NAME, null , null);
        } else {
            return getWritableDatabase().delete(TABLE_NAME, "_id=?", new String[]{id});
        }
    }

    public int updateDish(String id, ContentValues values) {
        if(id == null) {
            return getWritableDatabase().update(TABLE_NAME, values, null, null);
        } else {
            return getWritableDatabase().update(TABLE_NAME, values, "_id=?", new String[]{id});
        }
    }
}