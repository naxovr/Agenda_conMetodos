package com.local.agenda.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.local.agenda.Contacto;
import com.local.agenda.constantes.Constantes;

public class UtilsContactos {

    //Atributos
    private SQLiteDatabase db = null;
    private DatabaseContactos dbhelper = null;

    //Contexto
    Context context;

    // TODO: Constructor de nuestra clase
    // para instanciar la clase DatabaseContactos
    // y usar los métodos para escribir en nuestra
    // base de datos
    public UtilsContactos(Context contexto){
        this.context=contexto;

        //crea una instancia del helper
        dbhelper = new DatabaseContactos(context);

        //crea un objeto SQLiteDatabase para operar
        //contra la base de datos
        db = dbhelper.getWritableDatabase();
    }

    // TODO: Cerramos la base de datos
    public void close(){
        dbhelper.close();
    }

    /**
     * Método que inserta un contacto en la
     * base de datos.
     *
     * @param c (El parametro c es un objeto de tipo Contacto)
     * @return (Devuelve una instruccion SQL que inserta el
     *          contacto)
     */
    public long insertarContacto(Contacto c ){

        // TODO: Usamos un objeto de tipo ContentValues
        // para guardar todas las "keys" de cada campo
        // de nuestro contacto e insertarlo en la tabla
        ContentValues initialValues=new ContentValues();
        initialValues.put("nombre", c.getNombre());
        initialValues.put("email", c.getEmail());
        initialValues.put("edad", c.getEdad());

        // Inserta el Contacto en la base de datos
        return db.insert(Constantes.CONTACTOS_TABLA,
                        null,
                        initialValues);

    }

    // TODO: Método para recuperar un contacto
    // devolviendo un resultado de query
    public Cursor recuperarContactos(){
        return db.query(Constantes.CONTACTOS_TABLA,
                new String[]{Constantes.CAMPO_ID,
                            Constantes.CAMPO_NOMBRE,
                            Constantes.CAMPO_EMAIL,
                            Constantes.CAMPO_EDAD},
                null,
                null,
                null,
                null,
                null);
    }

    /**
     *
     *
     * @param email
     * @return
     */
    public Contacto buscarPorEmail(String email){

        Contacto con=null;

        // Creamos un cursor para guardar una query
        // de seleccion y un criterio para el campo
        // email =?
        Cursor c=db.query(Constantes.CONTACTOS_TABLA,
                    new String[]{Constantes.CAMPO_ID,
                            Constantes.CAMPO_NOMBRE,
                            Constantes.CAMPO_EMAIL,
                            Constantes.CAMPO_EDAD},
                "email=?",
                new String[]{email},
                null,
                null,
                null);
        if(c.moveToNext()){
            con=new Contacto(c.getString(1),
                    c.getString(2),c.getInt(3));
        }
        return con;
    }






}
