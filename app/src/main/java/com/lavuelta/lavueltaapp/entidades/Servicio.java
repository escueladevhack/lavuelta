package com.lavuelta.lavueltaapp.entidades;

/**
 * Created by jggomez on 25-May-17.
 */

public class Servicio {


    private String direccionEnvio;
    private String direccionDestino;
    private String nombreEnvia;
    private String nombreRecibe;
    private String descServicio;
    private String estadoServicio;
    private String fechaServicio;

    public Servicio() {

    }

    public String getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(String estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public String getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(String fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public String getNombreEnvia() {
        return nombreEnvia;
    }

    public void setNombreEnvia(String nombreEnvia) {
        this.nombreEnvia = nombreEnvia;
    }

    public String getNombreRecibe() {
        return nombreRecibe;
    }

    public void setNombreRecibe(String nombreRecibe) {
        this.nombreRecibe = nombreRecibe;
    }

    public String getDescServicio() {
        return descServicio;
    }

    public void setDescServicio(String descServicio) {
        this.descServicio = descServicio;
    }
}
