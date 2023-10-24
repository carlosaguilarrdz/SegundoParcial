package com.example.segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class modificar extends AppCompatActivity {

    private EditText elid;
    private EditText titulo;
    private EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        Button btnModificarR= findViewById(R.id.btnModificarR);
        elid = findViewById(R.id.id);
        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);

        CRUDRecetas CRUD = new CRUDRecetas(this);

        btnModificarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer newid = Integer.valueOf(elid.getText().toString());
                String eltitulo  = titulo.getText().toString();
                String ladescripcion = descripcion.getText().toString();

                CRUD.actualizarReceta(newid, eltitulo, ladescripcion);

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);

                Toast.makeText(getApplicationContext(), "Modificacion con éxito", Toast.LENGTH_LONG).show();
            }
        });


    }
}