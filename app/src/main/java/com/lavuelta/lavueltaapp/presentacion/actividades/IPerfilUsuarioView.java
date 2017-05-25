package com.lavuelta.lavueltaapp.presentacion.actividades;

import com.lavuelta.lavueltaapp.entidades.Usuario;
import com.lavuelta.lavueltaapp.utilidades.BaseView;

/**
 * Created by jggomez on 25-May-17.
 */

public interface IPerfilUsuarioView extends BaseView {

    void guardarUsuario();

    void cargarUsuario(Usuario usuario);

}
