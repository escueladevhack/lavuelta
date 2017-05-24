package com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters;

/**
 * Created by jggomez on 23-May-17.
 */

public interface ILoginPresenter {

    void login(String email, String password);

    void guardarDatosUsuario(String uid, String email);

    void isLogin();

}
