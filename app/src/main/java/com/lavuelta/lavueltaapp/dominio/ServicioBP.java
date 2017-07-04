package com.lavuelta.lavueltaapp.dominio;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jggomez on 25-May-17.
 */

public class ServicioBP implements IServicioBP {

    @Override
    public void guardar(Servicio servicio, String idUsuario) {
        try {

            servicio.setEstadoServicio(Constantes.ESTADO_INICIAL);

            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date dateobj = new Date();
            servicio.setFechaServicio(dateFormat.format(dateobj));

            FirebaseDatabase.getInstance().getReference(Constantes.PATH_SERVICIOS)
                    .child(idUsuario).push().setValue(servicio);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void obtenerServiciosxUsuario(String uid, final ICallbackPresenter<List<Servicio>> callback) {
        try {


            FirebaseDatabase.getInstance().getReference(Constantes.PATH_SERVICIOS)
                    .child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    try {

                        List<Servicio> lstServicio = new ArrayList<Servicio>();

                        for (DataSnapshot messageSnapshot : dataSnapshot.getChildren()) {
                            lstServicio.add(messageSnapshot.getValue(Servicio.class));
                        }

                        callback.respuesta(lstServicio);

                    } catch (Exception e) {
                        Log.e("", e.getMessage());
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    callback.error(new Exception(databaseError.getMessage()));
                }
            });

        } catch (Exception e) {
            throw e;
        }
    }

}
