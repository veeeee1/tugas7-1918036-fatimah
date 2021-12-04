package com.example.tugas7_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Emerk, Etipe, Eharga;
    private String Smerk, Stipe, Sharga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new MyDatabase(this);
        Emerk = (EditText) findViewById(R.id.create_merk);
        Etipe = (EditText) findViewById(R.id.create_tipe);
        Eharga = (EditText) findViewById(R.id.create_harga);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Smerk = String.valueOf(Emerk.getText());
                Stipe = String.valueOf(Etipe.getText());
                Sharga = String.valueOf(Eharga.getText());
                if (Smerk.equals("")){
                    Emerk.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi merk handphone",
                            Toast.LENGTH_SHORT).show();
                } else if (Stipe.equals("")){
                    Etipe.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi tipe handphone",
                            Toast.LENGTH_SHORT).show();
                } else if (Sharga.equals("")) {
                    Eharga.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi harga handphone",
                            Toast.LENGTH_SHORT).show();
                }else {
                    Emerk.setText("");
                    Etipe.setText("");
                    Eharga.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateHandphone (new Handphone(null, Smerk,
                            Stipe, Sharga));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

