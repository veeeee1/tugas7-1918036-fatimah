package com.example.tugas7_sqlite;

public class Handphone {
    private String _id, _merk, _tipe, _harga;
    public Handphone (String id, String merk, String tipe, String harga) {
        this._id = id;
        this._merk = merk;
        this._tipe = tipe;
        this._harga = harga;
    }
    public Handphone() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_merk() {
        return _merk;
    }
    public void set_merk(String _merk) {
        this._merk = _merk;
    }
    public String get_tipe() {
        return _tipe;
    }
    public void set_tipe(String _tipe) {
        this._tipe = _tipe;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
