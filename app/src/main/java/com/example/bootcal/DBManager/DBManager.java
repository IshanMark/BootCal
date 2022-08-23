package com.example.bootcal.DBManager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/**
 * <h3>DBManager</h3>
 * This is the DBManager Class that we use to
 * Save date to SQLite Database
 * View data in Database
 *
 * @author Ishan Mark
 * @version 1.0
 * Since 2022-08-23
 */

public class DBManager extends SQLiteOpenHelper {

    /**
     * Create Database
     */
    private static final String dbName ="dbContact";

    public DBManager(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    /**
     * Create Table in databse
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry = "create table tbl_contact (id integer primary key autoincrement , date text, event text,note text)";
        sqLiteDatabase.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String qry= "DROP TABLE IF EXISTS tbl_contact";
        sqLiteDatabase.execSQL(qry);
        onCreate(sqLiteDatabase);
    }


    /**
     * Insert data to Table
     */
    public String addRecord(String date, String event, String note){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("date",date);
        cv.put("event", event);
        cv.put("note",note);
        float res = db.insert("tbl_contact",null,cv);

        if(res == -1)
            return "Failed to Added";
        else
            return "Data Added Success";
    }

    /**
     * Read inserted all Data
     */
    public Cursor readAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String qry = "select * from tbl_contact order by id desc";
        Cursor cursor = db.rawQuery(qry,null);
        return cursor;

    }
}
