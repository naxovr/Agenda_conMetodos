package com.local.agenda.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.local.agenda.constantes.Constantes;

/**
 * Created by user on 05/03/2018.
 */

public class DatabaseContactos extends SQLiteOpenHelper {

    // TODO: Constantes para crear y eliminar tabla contactos
    private static final String CREATE_TABLE_CONTACTOS =
            "CREATE TABLE " + Constantes.CONTACTOS_TABLA +
                    " (" + Constantes.CAMPO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Constantes.CAMPO_NOMBRE + " TEXT NOT NULL, " +
                    Constantes.CAMPO_EMAIL + " TEXT NOT NULL, " +
                    Constantes.CAMPO_EDAD + " INTEGER NOT NULL)";

    private static final String DELETE_TABLE_CONTACTO =
            "DROP TABLE IF EXISTS " + Constantes.CONTACTOS_TABLA;

    // TODO: Constructor de nuestra clase para crear una referencia a nuestra db

    public DatabaseContactos(Context context){
        super(context, Constantes.DATABASE_NAME,null,Constantes.DATABASE_VERSION);
    }


    // TODO: El método onCreate se llama al crear la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Invocamos al método createTables
        createTables(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        // Eliminamos la tabla
        deleteTables(db);

        // y la volvemos a crear
        createTables(db);

    }

    // TODO: Usamos un metodo para crear nuestras tablas con el parametro db "SQLiteDatabase"
    private void createTables(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_CONTACTOS);
    }

    // TODO: Usamos este método para eliminar nuestras tablas.
    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DELETE_TABLE_CONTACTO);
    }

    }

