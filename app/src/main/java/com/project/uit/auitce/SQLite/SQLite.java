package com.project.uit.auitce.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static android.content.ContentValues.TAG;

/**
 * Created by leehoa on 12/1/16.
 */

public class SQLite extends SQLiteOpenHelper {

    public static final String TABLE_SETTINGS ="setting";
    public static final String TABLE_IMAGE ="images";
    public static final String KEY_ID ="_id";
    public static final String KEY_VALVES ="valves";
    public static final String KEY_ROWS="rows";
    public static final String KEY_IMAGES ="images";
    public static final String KEY_THREHOLD="threhold";
    public static final String KEY_IP ="ip";
    public static final String KEY_PORT ="port";
    public static final String KEY_PATH ="path";
    public static final String KEY_ID_IMANGE ="_id_image";

    public SQLite (Context context,String name, SQLiteDatabase.CursorFactory factory,int version){
        super(context,name,factory,version);
    }
    //Truy Van khong tra ket qua
    public void QueryData(String sql)
    {
        SQLiteDatabase database =getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor GetData(String sql){
        SQLiteDatabase database=getReadableDatabase();
        //database.close();
        return database.rawQuery(sql,null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CreateImageTable(db);
        CreateSettingsTable(db);
    }

    public void CreateSettingsTable(SQLiteDatabase db)
    {
        String CREATE_TABLE_SETTINGS="CREATE TABLE IF NOT EXISTS "+TABLE_SETTINGS+"("
                +KEY_ID+" INTEGER PRIMARY KEY,"
                +KEY_VALVES+" INTERGER,"
                +KEY_ROWS+" INTEGER,"
                +KEY_IMAGES+" INTEGER,"
                +KEY_THREHOLD+" INTEGER,"
                +KEY_IP+" TEXT,"
                +KEY_PORT+" INTEGER);";
        db.execSQL(CREATE_TABLE_SETTINGS);
        insertSettings(db);
    }

    public  void CreateImageTable(SQLiteDatabase db) {
        String CREATE_TABLE_IMAGE="CREATE TABLE IF NOT EXISTS "+TABLE_IMAGE+"("
                +KEY_ID_IMANGE+" INTEGER PRIMARY KEY,"
                +KEY_PATH+" TEXT);";
        db.execSQL(CREATE_TABLE_IMAGE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Thực hiện các thao tác chỉnh sửa cấu trúc bảng của DB
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_SETTINGS);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_IMAGE);
        onCreate(db);
    }
    //    //thêm bản ghi
    public void insertSettings(SQLiteDatabase db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, 0);
        contentValues.put(KEY_VALVES, 192);
        contentValues.put(KEY_ROWS, 150);
        contentValues.put(KEY_IMAGES, 2000);
        contentValues.put(KEY_THREHOLD, 128);
        contentValues.put(KEY_IP, "192.168.1.1");
        contentValues.put(KEY_PORT, 8888);
        db.insert(TABLE_SETTINGS, null, contentValues);

    }
    //Cập nhật bản ghi
    public boolean updateSettings(int valves,int rows,int images,int threhold,String ip, int port) {
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_VALVES, valves);
        contentValues.put(KEY_ROWS, rows);
        contentValues.put(KEY_IMAGES, images);
        contentValues.put(KEY_THREHOLD, threhold);
        contentValues.put(KEY_IP, ip);
        contentValues.put(KEY_PORT, port);
        try {
            db.update(TABLE_SETTINGS, contentValues, "_id = " + 0, null);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    //    //Tạo Bảng
    public boolean createTable(String stringCreateTable) {
        SQLiteDatabase db = this.getReadableDatabase();
        try {
            db.execSQL(stringCreateTable);
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    public void addImage(String path) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PATH, path);
        db.insert(TABLE_IMAGE, null, values);
        db.close();
    }
    public void deleteImage(String path) {
        Log.i(TAG, "MyDatabaseHelper.updateNote ... ");

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IMAGE, KEY_PATH + " = ?",
                new String[]{path});
        db.close();
    }

    public long CountImage() {
        SQLiteDatabase db = this.getReadableDatabase();
        long cnt  = DatabaseUtils.queryNumEntries(db, TABLE_IMAGE);
        Log.i("Data1",""+cnt);
        db.close();
        return cnt;
    }
}
