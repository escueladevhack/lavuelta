package com.lavuelta.lavueltaapp.utilidades;

/**
 * Created by jggomez on 25-May-17.
 */

public interface BaseView {

    void habilitarViews();

    void deshabilitarViews();

    void mostrarProgress();

    void ocultarProgress();

    void mostrarError(String error);

}
