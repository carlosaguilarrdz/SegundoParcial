package com.example.segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class borrar extends AppCompatActivity {

    private EditText elid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar);

        Button btnBorrarR= findViewById(R.id.btnBorrarR);
        elid = findViewById(R.id.id);

        CRUDRecetas CRUD = new CRUDRecetas(this);

        btnBorrarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer newid = Integer.valueOf(elid.getText().toString());
                CRUD.eliminarReceta(newid);

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);

                Toast.makeText(getApplicationContext(), "Eliminación con éxito", Toast.LENGTH_LONG).show();
            }
        });
    }
}