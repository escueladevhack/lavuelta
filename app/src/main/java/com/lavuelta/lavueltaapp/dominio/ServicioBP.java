package com.lavuelta.lavueltaapp.dominio;

import com.google.firebase.database.FirebaseDatabase;
import com.lavuelta.lavueltaapp.BD.ServicioBD;
import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

/**
 * Created by jggomez on 25-May-17.
 */

public class ServicioBP implements IServicioBP {

    @Override
    public void guardar(Servicio servicio, String idUsuario) {
        try {

            FirebaseDatabase.getInstance().getReference(Constantes.PATH_SERVICIOS)
                    .child(idUsuario).push().setValue(servicio);

            ServicioBD servicioBD = new ServicioBD();
            servicioBD.setNombreEnvia(servicio.getNombreEnvia());
            servicioBD.setDireccionEnvia(servicio.getDireccionEnvio());
            servicioBD.save();

        } catch (Exception e) {
            throw e;
        }
    }

}
