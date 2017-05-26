package com.lavuelta.lavueltaapp.dominio;

import com.lavuelta.lavueltaapp.entidades.Servicio;

/**
 * Created by jggomez on 25-May-17.
 */

public interface IServicioBP {

    void guardar(Servicio servicio, String idUsuario);
}
