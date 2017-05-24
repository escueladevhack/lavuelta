package com.lavuelta.lavueltaapp.utilidades;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jggomez on 23-May-17.
 */

public class Cache {

    private static String nombreSharedPreferences = "lavuelta";
    private static SharedPreferences sharedPreferences;

    public static void init(Context context) {
        sharedPreferences = context.getSharedPreferences(nombreSharedPreferences,
                Context.MODE_PRIVATE);
    }

    public static void addValor(String llave, String valor) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(llave, valor);
        editor.apply();
    }

    public static String getValor(String llave) {
        return sharedPreferences.getString(llave, "");
    }

    public static void limpiar() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

}
