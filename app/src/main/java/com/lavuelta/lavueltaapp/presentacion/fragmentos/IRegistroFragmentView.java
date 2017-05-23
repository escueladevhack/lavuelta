package com.lavuelta.lavueltaapp.presentacion.fragmentos;

/**
 * Created by jggomez on 18-May-17.
 */

public interface IRegistroFragmentView {

    void habilitarViews();

    void deshabilitarViews();

    void mostrarProgress();

    void ocultarProgress();

    void goToLogin();

    void registrar();

    void mostrarError(String error);

}
