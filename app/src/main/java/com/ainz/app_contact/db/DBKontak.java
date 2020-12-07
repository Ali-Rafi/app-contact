package com.ainz.app_contact.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ainz.app_contact.models.Kontak;

import java.util.ArrayList;
import java.util.List;

public class DBKontak extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME  = "db_kontak";
    private static final String TABLE   = "kontak";

    public DBKontak(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATED_TABLE = "CREATE TABLE kontak (" +
                "id_kontak INTEGER PRIMARY KEY, type varchar(25), " +
                "nama varchar(150), " +
                "no_telp varchar(100), "+
                "email varchar(100) )";
        db.execSQL(CREATED_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // Insert Data
    public void onInsertKontak(Kontak mdKontak){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put("id_kontak", mdKontak.getId_kontak());
        value.put("nama", mdKontak.getNama());
        value.put("no_telp", mdKontak.getNo_telp());
        value.put("email", mdKontak.getEmail());

        // do insert
        db.insert( TABLE, null, value );
    }

    // Tampil Data
    public List<Kontak> getAllKontak(){

        List<Kontak> dataModelList = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if ( cursor.moveToFirst() ) {

            do {
                Kontak mdKontak = new Kontak(null, null, null, null);
                mdKontak.setId_kontak(cursor.getString(0));
                mdKontak.setNama(cursor.getString(1));
                mdKontak.setNo_telp(cursor.getString(2));
                mdKontak.setEmail(cursor.getString(3));

                dataModelList.add(mdKontak);
            } while ( cursor.moveToNext() );
        }

        db.close();
        return dataModelList;
    }


    // Delete Data
    public void deleteKontak(String id_kontak) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE,"id_kontak = " + id_kontak, null);
        db.close();
    }

    // Update Data
    public int updateKontak(Kontak mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nama", mdNotif.getNama());
        values.put("no_telp", mdNotif.getNo_telp());
        values.put("email", mdNotif.getEmail());

        return db.update(TABLE, values, "id_kontak = " + String.valueOf(mdNotif.getId_kontak()), null );
    }


}
