package com.local.agenda;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.local.agenda.model.UtilsContactos;
import com.local.agenda.utils.Utilidades;

import java.util.ArrayList;

/**
 * Created by user on 28/02/2018.
 */

public class AgregarActivity extends Activity implements View.OnClickListener{

    // Creamos referencia para usar los metodos
    // de la case Utilidades
    Utilidades u = new Utilidades();

    //Creo mi array de tipo Contacto llamado "miagenda"
    ArrayList<Contacto> miagenda;

    Button btnAgregar;
    Button btnSalir;

    EditText editTextNombre;
    EditText editTextEmail;
    EditText editTextEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_agregar);

        btnAgregar = findViewById(R.id.buttonAdd);
        btnAgregar.setOnClickListener(this);

        btnSalir = findViewById(R.id.buttonClose);
        btnSalir.setOnClickListener(this);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextEdad = findViewById(R.id.editTextEdad);


//        Intent intent=this.getIntent();
//        miagenda=(ArrayList<Contacto>)intent.getSerializableExtra("agenda");

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonAdd:
               // addContact();
                insertarContactoADB();
                break;
            case R.id.buttonClose:
                cerrarActivity();
                break;
        }
    }

    private void addContact() {



        // Variables para recoger valores
        String nombre = editTextNombre.getText().toString();
        String email = editTextEmail.getText().toString();
        int edad = Integer.parseInt(editTextEdad.getText().toString());

        //creamos objeto contacto
        Contacto c = new Contacto(nombre,email,edad);

        //lo añadimos a la colección
        miagenda.add(c);

        //pasamos la colección como resultado a la actividad principal
        //para que se mantengan los contactos añadidos
        Intent intent=new Intent();
        intent.putExtra("miagenda", miagenda);
        this.setResult(0, intent);

    }

    /**
     * Insertar un contacto en la db
     */
    public void insertarContactoADB(){



        // Compruebo valores en los campos
        // para que no estén vacios
        if(TextUtils.isEmpty(editTextNombre.getText()) || TextUtils.isEmpty(editTextEmail.getText()) ||
                TextUtils.isEmpty(editTextEdad.getText())){

            // Mostramos mensaje de error "Campos vacios"


            // Creamos un objeto de tipo Resources
            // para acceder a los String
            //Resources rs = getResources();


           // u.mostrarMensaje(this,rs.getString(R.string.campos_vacios));

        }
        else{
            String nombre = editTextNombre.getText().toString();
            String email = editTextEmail.getText().toString();
            int edad = Integer.parseInt(editTextEdad.getText().toString());

            //creamos objeto contacto
            Contacto c=new Contacto(nombre, email, edad);

            //creamos un DBContactos y añadimos
            //el nuevo contacto
            UtilsContactos gestion=new UtilsContactos(this);

            gestion.insertarContacto(c);
            //cerramos la base de datos
            gestion.close();
            //finalizamos la actividad
            this.finish();
        }


    }


    private void cerrarActivity(){
        //cerramos la actividad

        this.finish();
    }
}
