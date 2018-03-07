package com.local.agenda;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;

/**
 * Created by user on 07/03/2018.
 */

public class BuscarActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void buscar(View v){
        String email=((EditText)this.findViewById(R.id.edtEmailBusca)).getText().toString();
        //guardamos aquí el contacto recuperado
        Contacto c=null;
        //creamos GestionContacto y buscamos
        DBContactos gestion=new DBContactos(this);
        c=gestion.buscarPorEmail(email);
        mostrarDato(c);
        //cerramos la base de datos
        gestion.close();
    }
}
