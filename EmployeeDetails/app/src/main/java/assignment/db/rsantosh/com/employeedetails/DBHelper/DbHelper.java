package assignment.db.rsantosh.com.employeedetails.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.sql.Blob;
import java.util.ArrayList;

import assignment.db.rsantosh.com.employeedetails.Model.EmployeeDetails;

/**
 * Created by C S Ramachandran on 20-09-2016.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Employee";
    private static final int DB_VERSION = 1;
    private static final String EMP_ID = "id" ;
    private static final String EMP_NAME = "Name" ;
    private static final String EMP_AGE = "Age";
    private static final String EMP_PHOTO = "Photo" ;
    private String EMP_Table = "EmployeeDetails";

    SQLiteDatabase db;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String strCreateTable = "create table " + EMP_Table + "(" + EMP_ID + " integer primary key, " +
                "" + EMP_NAME + " text, " + EMP_AGE + " text" + EMP_PHOTO + " blob);";

        sqLiteDatabase.execSQL(strCreateTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insert(String name, String age, byte[] img){

        db = getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("EMP_NAME",name);
        values.put("EMP_AGE",age);
        values.put("EMP_PHOTO",img);

        db.insert(EMP_Table,null, values);
        db.close();

    }

    public ArrayList<EmployeeDetails> getAll(){

        ArrayList<EmployeeDetails> employeeDetails = new ArrayList<>();
        db = getReadableDatabase();
        String query = "Select * from " + EMP_Table;
        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){

            do {

                //int id = cursor.getInt(0);
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                byte[] photo = cursor.getBlob(3);

                EmployeeDetails employeeDetails1 = new EmployeeDetails(name,age,photo);
                employeeDetails.add(employeeDetails1);

            }while (cursor.moveToNext());

        }


        db.close();

        return employeeDetails;
    }


}
