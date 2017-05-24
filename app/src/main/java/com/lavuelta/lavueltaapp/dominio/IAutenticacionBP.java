package com.lavuelta.lavueltaapp.dominio;

import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;

/**
 * Created by jggomez on 18-May-17.
 */

public interface IAutenticacionBP {

    void registrarUsuario(String nombre, String email, String password, ICallbackPresenter<Boolean> callback);

    void loginUsuario(String email, String password, ICallbackPresenter<String> callback);

    void recordarUsuario(String email, ICallbackPresenter<Boolean> callback);
}
