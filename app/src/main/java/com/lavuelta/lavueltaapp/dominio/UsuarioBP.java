package com.lavuelta.lavueltaapp.dominio;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lavuelta.lavueltaapp.entidades.Usuario;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

/**
 * Created by jggomez on 25-May-17.
 */

public class UsuarioBP implements IUsuarioBP {


    @Override
    public void guardar(Usuario usuario, String idUsuario) {
        try {

            FirebaseDatabase.getInstance().getReference(Constantes.PATH_USUARIOS)
                    .child(idUsuario).setValue(usuario);

        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void consultarXIdentificador(String idUsuario, final ICallbackPresenter<Usuario> callback) {
        try {

            FirebaseDatabase.getInstance().getReference(Constantes.PATH_USUARIOS)
                    .child(idUsuario).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Usuario usuario = dataSnapshot.getValue(Usuario.class);
                    callback.respuesta(usuario);
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
