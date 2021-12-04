package com.example.tugas7_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_konter";
    private static final String tb_hp = "tb_hp";
    private static final String tb_hp_id = "id";
    private static final String tb_hp_merk = "merk";
    private static final String tb_hp_tipe = "tipe";
    private static final String tb_hp_harga = "harga";
    private static final String CREATE_TABLE_HP = "CREATE TABLE " + tb_hp + "("
            + tb_hp_id + " INTEGER PRIMARY KEY ,"
            + tb_hp_merk + " TEXT,"
            + tb_hp_tipe + " TEXT,"
            + tb_hp_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_HP);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateHandphone (Handphone mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_hp_id, mdNotif.get_id());
        values.put(tb_hp_merk, mdNotif.get_merk());
        values.put(tb_hp_tipe, mdNotif.get_tipe());
        values.put(tb_hp_harga, mdNotif.get_harga());
        db.insert(tb_hp, null, values);
        db.close();
    }
    public List<Handphone> ReadHandphone() {
        List<Handphone> judulModelList = new ArrayList<Handphone>();
        String selectQuery = "SELECT * FROM " + tb_hp;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Handphone mdKontak = new Handphone();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_merk(cursor.getString(1));
                mdKontak.set_tipe(cursor.getString(2));
                mdKontak.set_harga(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateHandphone (Handphone mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_hp_merk, mdNotif.get_merk());
        values.put(tb_hp_tipe, mdNotif.get_tipe());
        values.put(tb_hp_harga, mdNotif.get_harga());
        return db.update(tb_hp, values, tb_hp_id + " = ?",
        new String[] {
                String.valueOf(mdNotif.get_id())});
    }
    public void DeleteHandphone (Handphone mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_hp, tb_hp_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}