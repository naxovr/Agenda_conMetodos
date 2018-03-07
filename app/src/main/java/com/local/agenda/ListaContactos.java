package com.local.agenda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by user on 01/03/2018.
 */

public class ListaContactos extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState) {

        final ArrayList<Contacto> miagenda;
        ListView lstContactos;


        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_contactos);
        Intent intent=this.getIntent();
        //recupera la agenda
        
        miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda");
        //recupera ListView
        
        lstContactos=(ListView)this.findViewById(R.id.lstContactos);
        //crea ArrayAdapter y lo asigna a la lista

        ArrayAdapter<Contacto> arContactos=new ArrayAdapter<Contacto>(this,android.R.layout.simple_list_item_1,miagenda);
        //ArrayAdapter arContactos = new ArrayAdapter(this, android.R.layout.simple_list_item_1, miagenda);

        ArrayAdapter<String> lista = null;
        for(int i=0 ; i<arContactos.getCount() ; i++){
            lista.add(arContactos.getItem(i).getNombre());
        }

        Log.d("TAG", "Nombre: " + arContactos.getItem(0).getNombre());

        lstContactos.setAdapter(lista);


        //manejador de selección de elemento, que muestra
        //una alerta con todos los datos del contacto elegido
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contacto c=miagenda.get(position);
                String textoMensaje="Nombre: "+c.getNombre()+"\nEmail: "+c.getEmail()+"\nEdad: "+c.getEdad();
                Toast.makeText(ListaContactos.this,textoMensaje,Toast.LENGTH_LONG).show();
            }
        });
    }



}
