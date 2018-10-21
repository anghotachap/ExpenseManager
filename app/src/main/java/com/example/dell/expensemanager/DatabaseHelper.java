package com.example.dell.expensemanager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "ExpenseManager.db";

    public static final String TABLE_NAME_0 = "users";
    public static final String KEY_ID = "id";
    public static final String KEY_USER_NAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String SQL_TABLE_USERS = " CREATE TABLE " + TABLE_NAME_0
            + " ( "
            + KEY_ID + " INTEGER PRIMARY KEY, "
            + KEY_USER_NAME + " TEXT, "
            + KEY_EMAIL + " TEXT, "
            + KEY_PASSWORD + " TEXT"
            + " ) ";
    public static final String TABLE_NAME_1 = "homeexp_table";
    public static final String TABLE_NAME_2 = "entexp_table";
    public static final String TABLE_NAME_3 = "clothsexp_table";
    public static final String TABLE_NAME_4 = "travelexp_table";
    public static final String TABLE_NAME_5 = "sportexp_table";
    public static final String COL_1 = "TID";
    public static final String COL_2 = "CDATE";
    public static final String COL_3 = "NOTE";
    public static final String COL_4 = "AMOUNT";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_TABLE_USERS);
        db.execSQL("create table " + TABLE_NAME_1 +" (TID INTEGER PRIMARY KEY AUTOINCREMENT,CDATE TEXT,NOTE TEXT,AMOUNT INTEGER)");
        db.execSQL("create table " + TABLE_NAME_2 +" (TID INTEGER PRIMARY KEY AUTOINCREMENT,CDATE TEXT,NOTE TEXT,AMOUNT INTEGER)");
        db.execSQL("create table " + TABLE_NAME_3 +" (TID INTEGER PRIMARY KEY AUTOINCREMENT,CDATE TEXT,NOTE TEXT,AMOUNT INTEGER)");
        db.execSQL("create table " + TABLE_NAME_4 +" (TID INTEGER PRIMARY KEY AUTOINCREMENT,CDATE TEXT,NOTE TEXT,AMOUNT INTEGER)");
        db.execSQL("create table " + TABLE_NAME_5 +" (TID INTEGER PRIMARY KEY AUTOINCREMENT,CDATE TEXT,NOTE TEXT,AMOUNT INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME_0);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_4);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME_5);
        onCreate(db);
    }

    public void addUser(User user) {


        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();


        values.put(KEY_USER_NAME, user.userName);


        values.put(KEY_EMAIL, user.email);


        values.put(KEY_PASSWORD, user.password);


        long todo_id = db.insert(TABLE_NAME_0, null, values);
    }

    public User Authenticate(User user) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME_0,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "=?",
                new String[]{user.email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {

            User user1 = new User(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));


            if (user.password.equalsIgnoreCase(user1.password)) {
                return user1;
            }
        }


        return null;
    }

    public boolean isEmailExists(String email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME_0,
                new String[]{KEY_ID, KEY_USER_NAME, KEY_EMAIL, KEY_PASSWORD},
                KEY_EMAIL + "=?",
                new String[]{email},
                null, null, null);

        if (cursor != null && cursor.moveToFirst() && cursor.getCount() > 0) {

            return true;
        }


        return false;
    }

    public boolean insertDataIntoHome(String date, String note, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,note);
        contentValues.put(COL_4,amount);
        long result = db.insert(TABLE_NAME_1,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataIntoEnt(String date, String note, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,note);
        contentValues.put(COL_4,amount);
        long result = db.insert(TABLE_NAME_2,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataIntoClo(String date, String note, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,note);
        contentValues.put(COL_4,amount);
        long result = db.insert(TABLE_NAME_3,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataIntoTravel(String date, String note, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,note);
        contentValues.put(COL_4,amount);
        long result = db.insert(TABLE_NAME_4,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    public boolean insertDataIntoSport(String date, String note, String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,note);
        contentValues.put(COL_4,amount);
        long result = db.insert(TABLE_NAME_5,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllHomeData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME_1,null);
        return res;

    }
    public Cursor getAllEntData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME_2,null);
        return res;

    }
    public Cursor getAllCloData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME_3,null);
        return res;

    }
    public Cursor getAllTravelData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME_4,null);
        return res;

    }
    public Cursor getAllSportData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME_5,null);
        return res;

    }

    public boolean updateData(String tid,String date,String note,String amount) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,tid);
        contentValues.put(COL_2,date);
        contentValues.put(COL_3,note);
        contentValues.put(COL_4,amount);
        db.update(TABLE_NAME_1, contentValues, "ID = ?",new String[] { tid });
        return true;
    }

    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME_1, "ID = ?",new String[] {id});
    }
}