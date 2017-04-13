package com.example.dell.seconddatabaseexample;


import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabasehelperMain extends SQLiteOpenHelper {
    public static String DATABASENAME = "alldatabase", PHPTABLE = "phptable",
            JAVATABLE = "javatable", ANDROIDTABLE = "androidtable",
            _colStudentid = "student", colStudentName = "studentname",
            colPaidAmount = "paidamount", colStudentId = "id";
    Context c;
    private ArrayList<ProductModule> list = new ArrayList<ProductModule>();
    private ArrayList<ProductModule> list2 = new ArrayList<ProductModule>();
    private ArrayList<ProductModule> list3 = new ArrayList<ProductModule>();


    public DatabasehelperMain(Context context) {
        super(context, DATABASENAME, null, 44);
        c = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        db.execSQL("CREATE TABLE IF NOT EXISTS phptable("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "student INTEGER, "
                + "studentname TEXT, " + "paidamount VARCHAR)");
        db.execSQL("CREATE TABLE IF NOT EXISTS javatable("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "student INTEGER, "
                + "studentname TEXT, " + "paidamount VARCHAR)");
        db.execSQL("CREATE TABLE IF NOT EXISTS androidtable("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT," + "student INTEGER, "
                + "studentname TEXT, " + "paidamount VARCHAR)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + PHPTABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + JAVATABLE);
        onCreate(db);
        db.execSQL("DROP TABLE IF EXISTS " + ANDROIDTABLE);
        onCreate(db);

    }

    public void addInformationphp(ProductModule pd) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv2 = new ContentValues();
        cv2.put("student", pd.pid);
        cv2.put("studentname", pd.pname);
        cv2.put("paidamount", pd.pamt);
        db.insert("PHPTABLE", null, cv2);

        db.close();

    }

    public ArrayList<ProductModule> getProductsphp() {
        /*
		 * get data from database through cursor and pass to class Php to
		 * ProductModule  chaiyeko and arraylist
		 */
        list.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from phptable", null);
        // Cursor cursor=db.rawQuery("Select student from mytable where id=1",null
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {

                    ProductModule item = new ProductModule();
                    item.pid = cursor.getString(cursor
                            .getColumnIndex("student"));
                    item.pname = cursor.getString(cursor
                            .getColumnIndex("studentname"));
                    item.pamt = cursor.getString(cursor
                            .getColumnIndex("paidamount"));
                    list.add(item);
                } while (cursor.moveToNext());
            }

        }
        cursor.close();
        db.close();
        return list;

    }

    public void UpdatePhp(ProductModule pp) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv3 = new ContentValues();
        cv3.put("studentname", pp.pname);
        cv3.put("paidamount", pp.pamt);
        db.update(PHPTABLE, cv3, "student=" + pp.pid, null);
        db.close();

    }

    public void RemovePhp(String id, Object name, Object amt) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from phptable where student = " + id);
            db.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    public void addInformationjava(ProductModule pd) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv2 = new ContentValues();
        cv2.put("student", pd.pid);
        cv2.put("studentname", pd.pname);
        cv2.put("paidamount", pd.pamt);
        db.insert("JAVATABLE", null, cv2);
        db.close();

    }

    public ArrayList<ProductModule> getProductsjava() {
		/*
		 * get data from database through cursor and pass to class Php to
		 * ProductModule and arraylist
		 */
        list2.clear();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from javatable", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {

                    ProductModule item = new ProductModule();
                    item.pid = cursor.getString(cursor
                            .getColumnIndex("student"));
                    item.pname = cursor.getString(cursor
                            .getColumnIndex("studentname"));
                    item.pamt = cursor.getString(cursor
                            .getColumnIndex("paidamount"));
                    list2.add(item);
                } while (cursor.moveToNext());
            }

        }
        cursor.close();
        db.close();
        return list2;

    }

    public void Updatejava(ProductModule pp) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv3 = new ContentValues();
        cv3.put("studentname", pp.pname);
        cv3.put("paidamount", pp.pamt);
        db.update(JAVATABLE, cv3, "student=" + pp.pid, null);
        db.close();

    }

    public void Removejava(String id) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from javatable where student = " + id);
            db.close();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }


    public void addInformationdroid(ProductModule pd) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("student", pd.pid);
        contentvalues.put("studentname", pd.pname);
        contentvalues.put("paidamount", pd.pamt);
        db.insert("ANDROIDTABLE", null, contentvalues);
        db.close();

    }

    public ArrayList<ProductModule> getProductsdroid() {
        // TODO Auto-generated method stub
        list3.clear();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from androidtable", null);
        if (cursor.getCount() != 0) {
            if (cursor.moveToFirst()) {
                do {
                    ProductModule item = new ProductModule();
                    item.pid = cursor.getString(cursor
                            .getColumnIndex("student"));
                    item.pname = cursor.getString(cursor
                            .getColumnIndex("studentname"));
                    item.pamt = cursor.getString(cursor
                            .getColumnIndex("paidamount"));
                    list3.add(item);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        db.close();
        return list3;
    }

    public void UpdateAndroid(ProductModule pp) {
        // TODO Auto-generated method stub
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv1 = new ContentValues();
        cv1.put("studentname", pp.pname);
        cv1.put("paidamount", pp.pamt);
        db.update(ANDROIDTABLE, cv1, "student=" + pp.pid, null);
        db.close();
    }

    public void RemoveAndroid(String id, Object name, Object amount) {
        // TODO Auto-generated method stub
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("delete from androidtable where student=" + id);
            db.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }


}