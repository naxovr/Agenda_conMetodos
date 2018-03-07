package com.local.agenda.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by user on 06/03/2018.
 */

public class Utilidades {

    /**
     * Muestra un toast con un mensaje para el usuario
     * @param context (Representa el contexto donde se
     *                 va a mostrar el mensaje
     * @param mensaje (Mensaje del usuario)
     */
    public void mostrarMensaje(Context context, String mensaje){
        Toast.makeText(context, mensaje, Toast.LENGTH_SHORT).show();
    }

}
