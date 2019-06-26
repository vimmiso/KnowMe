package com.example.db_stud;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.FragmentActivity;

import java.lang.reflect.Array;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME1 = "student_table";
    public static final String COL1_1 = "ID";
    public static final String COL1_2 = "NAME";
    public static final String COL1_3 = "EMAIL";
    public static final String COL1_4 = "PASSWORD";
    public static final String COL1_5 = "BRANCH";
    public static final String COL1_6 = "ROLL";
    public static final String COL1_7 = "MOBILENUMBER";
    public static final String COL1_8 = "DATEOFBIRTH";
    public static final String COL1_9 = "GENDER";
    public static final String COL1_10 = "HOMEADDRESS";



    public static final String TABLE_NAME2 = "student_table2";
    public static final String COL2_1 = "ID";
    public static final String COL2_2 = "SCHOOL10";
    public static final String COL2_3 = "RESULT10";
    public static final String COL2_4 = "SCHOOL12";
    public static final String COL2_5 = "RESULT12";
    public static final String COL2_6 = "COMPETITIVE";

    public static final String TABLE_NAME3 = "student_table3";
    public static final String COL3_1 = "ID";
    public static final String COL3_2 = "ROLL";
    public static final String COL3_3 = "SKILLS";


    public DatabaseHelper(FragmentActivity context) {

        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 + "(ID TEXT PRIMARY KEY ,NAME TEXT,EMAIL TEXT, PASSWORD TEXT,BRANCH TEXT,ROLL TEXT,MOBILENUMBER TEXT,DATEOFBIRTH TEXT,GENDER TEXT,HOMEADDRESS TEXT)");
        db.execSQL("create table " + TABLE_NAME2 + "( ID TEXT PRIMARY KEY ,SCHOOL10 TEXT,RESULT10 TEXT, SCHOOL12 TEXT,RESULT12 TEXT,COMPETITIVE TEXT)");
        db.execSQL("create table " + TABLE_NAME3 + "( ID TEXT PRIMARY KEY ,ROLL TEXT,SKILLS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);


        onCreate(db);
    }

    public boolean insertData1(String name, String email,String password,String branch,String roll,String mobilenumber,String dateofbirth,String gender,String home){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_1,roll);
        contentValues.put(COL1_2,name);
        contentValues.put(COL1_3,email);
        contentValues.put(COL1_4,password);
        contentValues.put(COL1_5,branch);
        contentValues.put(COL1_6,roll);
        contentValues.put(COL1_7,mobilenumber);
        contentValues.put(COL1_8,dateofbirth);
        contentValues.put(COL1_9,gender);
        contentValues.put(COL1_10,home);

        long result = db.insert(TABLE_NAME1,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean checkUser(String username ,String password)
    {
        String[] columns = {COL1_1};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL1_3 + "=?" + " and " + COL1_4 + "=?";
        String[] selectionArgs = {username,password};
        Cursor cursor = db.query(TABLE_NAME1,columns,selection,selectionArgs,null,null,null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if(count>0){
            return true;
        }else{
            return false;
        }
    }

    public boolean insertData2(String roll,String school10, String result10,String school12,String result12,String competitive){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2_1,roll);
        contentValues.put(COL2_2,school10);
        contentValues.put(COL2_3,result10);
        contentValues.put(COL2_4,school12);
        contentValues.put(COL2_5,result12);
        contentValues.put(COL2_6,competitive);

        long result = db.insert(TABLE_NAME2,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }

    public boolean insertData3(String roll,String skills){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL3_1,roll);
        contentValues.put(COL3_2,roll);
        contentValues.put(COL3_3,skills);

        long result = db.insert(TABLE_NAME3,null,contentValues);
        if(result==-1)
            return false;
        else
            return true;
    }


    public Cursor getAllData1(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME1 ,null);
        return res;
    }

    public Cursor getAllData2(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2,null);
        return res;
    }

    public Cursor getAllData3(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME3,null);
        return res;
    }

    public Cursor getRoll(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select ID from "+TABLE_NAME1,null);
        return res;
    }

    public Cursor getAllData11(String roll){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME1 +" where ROLL="+roll+" ",null);
        return res;
    }

    public Cursor getAllData22(String roll){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME2+" where ID="+roll+" ",null);
        return res;
    }

    public Cursor getAllData33(String roll){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME3+" where ROLL="+roll+" ",null);
        return res;
    }


    public boolean updateData1(String name, String email,String password,String branch,String roll,String mobilenumber,String dateofbirth,String gender,String home){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_2,name);
        contentValues.put(COL1_3,email);
        contentValues.put(COL1_4,password);
        contentValues.put(COL1_5,branch);
//        contentValues.put(COL1_6,roll);
        contentValues.put(COL1_7,mobilenumber);
        contentValues.put(COL1_8,dateofbirth);
        contentValues.put(COL1_9,gender);
        contentValues.put(COL1_10,home);

        db.update(TABLE_NAME1,contentValues,"ID = ?",new String[]{roll});
        return true;
    }

    public boolean updateData2(String id,String school10,String result10,String school12,String result12,String competitive){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL2_1,id);
        contentValues.put(COL2_2,school10);
        contentValues.put(COL2_3,result10);
        contentValues.put(COL2_4,school12);
        contentValues.put(COL2_5,result12);
        contentValues.put(COL2_6,competitive);

        db.update(TABLE_NAME2,contentValues,"ID = ?",new String[]{id});
        return true;
    }

    public boolean updateData3(String roll, String skills){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
//        contentValues.put(COL1_2,roll);
        contentValues.put(COL3_3,skills);
        db.update(TABLE_NAME3,contentValues,"ID = ?",new String[]{roll});
        return true;
    }

    public Cursor getRow(String Roll,SQLiteDatabase sqLiteDatabase){
        String[] projections = {COL1_2,COL1_4,COL1_5,COL1_6,COL1_7,COL1_8,COL1_9,COL1_10};
        SQLiteDatabase db = getReadableDatabase();
        String selection = COL1_1 + "=?";
        String [] selectionArgs = {(Roll)};
        Cursor cursor = db.query(TABLE_NAME1,projections,selection,selectionArgs,null,null,null);
//        int count = cursor.getCount();
//        cursor.close();
//        db.close();
        return cursor;
    }


}
