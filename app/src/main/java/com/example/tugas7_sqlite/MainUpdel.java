package com.example.tugas7_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Smerk, Stipe, Sharga;
    private EditText Emerk, Etipe, Eharga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Smerk = i.getStringExtra("Imerk");
        Stipe = i.getStringExtra("Itipe");
        Sharga = i.getStringExtra("Iharga");

        Emerk = (EditText) findViewById(R.id.updel_merk);
        Etipe = (EditText) findViewById(R.id.updel_tipe);
        Eharga = (EditText) findViewById(R.id.updel_Harga);
        Emerk.setText(Smerk);
        Etipe.setText(Stipe);
        Eharga.setText(Sharga);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Stipe = String.valueOf(Etipe.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Smerk.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama merk handphone",
                            Toast.LENGTH_SHORT).show();
                } else if (Stipe.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama tipe handphone",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")){
                    Eharga.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi harga handphone",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateHandphone(new Handphone(Sid, Smerk,
                            Stipe, Sharga));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteHandphone(new Handphone(Sid, Smerk, Stipe,
                        Sharga));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
