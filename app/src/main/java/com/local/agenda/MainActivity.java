package com.local.agenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnAgregarContacto;
    Button btnVerLista;

    // Creamos arrayList de tipo Contacto llamado: "agenda"
    ArrayList<Contacto> agenda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAgregarContacto = findViewById(R.id.buttonAgregar);
        btnAgregarContacto.setOnClickListener(this);

        btnVerLista = findViewById(R.id.buttonVerListado);
        btnVerLista.setOnClickListener(this);


        //agenda=new ArrayList<Contacto>();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonAgregar:

                //Ejecuta metodo para abrir la activity "AgregarActivity"
                //abrirAgregrar();
                abrirParaInsertarEnDb();
            break;
            case R.id.buttonVerListado:
                abrirLista();
                break;
        }
    }

    // Abre la actividad Agregar Activity para poder insertar un registro de manera directa en la DBContactos
    public void abrirParaInsertarEnDb(){
        Intent intent = new Intent(this,AgregarActivity.class);
        startActivity(intent);
    }

    public void abrirAgregrar() {
        Intent intent = new Intent(this, AgregarActivity.class);
        intent.putExtra("agenda", agenda);


        for(Contacto contacto:agenda){
            if(contacto != null) {
                Log.d("TAG", "Nombre: " + contacto.getNombre());
            }else{
                Log.d("TAG", "agenda vacia o valores nulos");
            }
        }

        this.startActivityForResult(intent, 1);

    }

    public void abrirLista(){
        Intent intent = new Intent(this, ListaContactos.class);
        intent.putExtra("agenda", agenda);
        this.startActivity(intent);

    }

//    @Override
//    public void onActivityResult(int cod, int result, Intent data) {
//        agenda = (ArrayList<Contacto>) data.getSerializableExtra("miagenda");
//
//        for (Contacto c : agenda) {
//            if(c!=null){
//                Log.d("TAG", c.getNombre());
//            }
//        }
//
//    }
}