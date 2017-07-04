package com.lavuelta.lavueltaapp.dominio;

import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;

import java.util.List;

/**
 * Created by jggomez on 25-May-17.
 */

public interface IServicioBP {

    void guardar(Servicio servicio, String idUsuario);

    void obtenerServiciosxUsuario(String uid, final ICallbackPresenter<List<Servicio>> callback);
}
