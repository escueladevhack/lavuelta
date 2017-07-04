package com.lavuelta.lavueltaapp.entidades;

import java.util.HashMap;

/**
 * Created by jggomez on 31-May-17.
 */

public class ServicioUsuario {

    HashMap<String, Servicios> lstServicios = new HashMap<>();

    public ServicioUsuario() {

    }

    public HashMap<String, Servicios> getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(HashMap<String, Servicios> lstServicios) {
        this.lstServicios = lstServicios;
    }
}
