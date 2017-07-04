package com.lavuelta.lavueltaapp.entidades;

import java.util.HashMap;

/**
 * Created by jggomez on 31-May-17.
 */

public class Servicios {

    HashMap<String, Servicio> lstServicios = new HashMap<>();

    public Servicios() {

    }

    public HashMap<String, Servicio> getLstServicios() {
        return lstServicios;
    }

    public void setLstServicios(HashMap<String, Servicio> lstServicios) {
        this.lstServicios = lstServicios;
    }
}
