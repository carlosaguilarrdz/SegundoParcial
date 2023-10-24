package com.example.segundoparcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAgregarI= findViewById(R.id.btnAgregarI);
        Button btnModificarI= findViewById(R.id.btnModificarI);
        Button btnBorrarI= findViewById(R.id.btnBorrarI);

        CRUDRecetas CRUD = new CRUDRecetas(this);

        ArrayList<String> listaRecetitas = new ArrayList<String>();


        ListView listaRecetas=findViewById(R.id.listarecetas);
        Cursor informacion=CRUD.mostrarRecetas();

        while (informacion.moveToNext()){
            String titulo=informacion.getString(1);
            listaRecetitas.add(titulo);


        }
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listaRecetitas);
        listaRecetas.setAdapter(adaptador);

        btnAgregarI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent agregar = new Intent(getApplicationContext(), agregar.class);
                startActivity(agregar);
            }
        });

        btnModificarI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent modificar = new Intent(getApplicationContext(), modificar.class);
                startActivity(modificar);
            }
        });

        btnBorrarI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent borrar = new Intent(getApplicationContext(), borrar.class);
                startActivity(borrar);
            }
        });

    }
}