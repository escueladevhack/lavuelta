package com.lavuelta.lavueltaapp.presentacion.fragmentos;

/**
 * Created by jggomez on 23-May-17.
 */

public interface IRecordarFragmentView {

    void habilitarViews();

    void deshabilitarViews();

    void mostrarProgress();

    void ocultarProgress();

    void goToLogin();

    void recordarPassword();

    void mostrarError(String error);
}
