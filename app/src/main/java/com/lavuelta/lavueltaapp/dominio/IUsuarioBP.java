package com.lavuelta.lavueltaapp.dominio;

import com.lavuelta.lavueltaapp.entidades.Usuario;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;

/**
 * Created by jggomez on 25-May-17.
 */

public interface IUsuarioBP {

    void guardar(Usuario usuario, String idUsuario);

    void consultarXIdentificador(String identificador, final ICallbackPresenter<Usuario> callback);
}
