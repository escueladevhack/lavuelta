package com.lavuelta.lavueltaapp.presentacion.actividades;

import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.utilidades.BaseView;

import java.util.List;

/**
 * Created by jggomez on 31-May-17.
 */

public interface IMainView extends BaseView {

    void cargarServicios(List<Servicio> lstServicios);
}
