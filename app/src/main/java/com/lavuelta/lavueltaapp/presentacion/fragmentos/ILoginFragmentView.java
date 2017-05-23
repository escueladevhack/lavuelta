package com.lavuelta.lavueltaapp.presentacion.fragmentos;

/**
 * Created by jggomez on 23-May-17.
 */

public interface ILoginFragmentView {

    void habilitarViews();

    void deshabilitarViews();

    void mostrarProgress();

    void ocultarProgress();

    void goToMain();

    void login();

    void mostrarError(String error);

}
