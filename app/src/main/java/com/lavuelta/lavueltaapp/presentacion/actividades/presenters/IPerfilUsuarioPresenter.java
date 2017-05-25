package com.lavuelta.lavueltaapp.presentacion.actividades.presenters;

import com.lavuelta.lavueltaapp.entidades.Usuario;

/**
 * Created by jggomez on 25-May-17.
 */

public interface IPerfilUsuarioPresenter {

    void guardarUsuario(Usuario usuario);

    void cargarUsuarioxID();
}
