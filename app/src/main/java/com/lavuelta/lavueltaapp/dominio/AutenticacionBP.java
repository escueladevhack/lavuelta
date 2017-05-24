package com.lavuelta.lavueltaapp.dominio;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lavuelta.lavueltaapp.entidades.Usuario;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;

/**
 * Created by jggomez on 18-May-17.
 */

public class AutenticacionBP implements IAutenticacionBP {

    private final String refUsuarios = "usuarios";


    @Override
    public void registrarUsuario(final String nombre, final String email, String password,
                                 final ICallbackPresenter<Boolean> callback) {
        try {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {

                            Usuario usuario = new Usuario();
                            usuario.setEmail(email);
                            usuario.setNombre(nombre);

                            DatabaseReference reference =
                                    FirebaseDatabase.getInstance().getReference();

                            reference.child(refUsuarios).child(authResult.getUser().getUid()).setValue(usuario);

                            callback.respuesta(true);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            callback.error(e);
                        }
                    });

        } catch (Exception e) {
            callback.error(e);
        }
    }

    @Override
    public void loginUsuario(String email, String password, final ICallbackPresenter<String> callback) {
        try {

            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                    .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                        @Override
                        public void onSuccess(AuthResult authResult) {
                            callback.respuesta(authResult.getUser().getUid());
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            callback.error(e);
                        }
                    });

        } catch (Exception e) {
            callback.error(e);
        }
    }

    @Override
    public void recordarUsuario(String email, final ICallbackPresenter<Boolean> callback) {
        try {

            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            callback.respuesta(true);
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            callback.error(e);
                        }
                    });

        } catch (Exception e) {
            callback.error(e);
        }
    }
}
