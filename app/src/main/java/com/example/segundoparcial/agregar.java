package com.example.segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class agregar extends AppCompatActivity {

    private EditText titulo;
    private EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        Button btnAgregarR= findViewById(R.id.btnAgregarR);
        titulo = findViewById(R.id.titulo);
        descripcion = findViewById(R.id.descripcion);

        CRUDRecetas CRUD = new CRUDRecetas(this);

        btnAgregarR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String eltitulo  = titulo.getText().toString();
                String ladescripcion = descripcion.getText().toString();

                CRUD.insertarReceta(eltitulo, ladescripcion);

                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(main);

                Toast.makeText(getApplicationContext(), "Añadido con éxito", Toast.LENGTH_LONG).show();
            }
        });



    }
}