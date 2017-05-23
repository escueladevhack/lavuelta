package com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters;

import com.lavuelta.lavueltaapp.dominio.AutenticacionBP;
import com.lavuelta.lavueltaapp.dominio.IAutenticacionBP;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.IRegistroFragmentView;

/**
 * Created by jggomez on 18-May-17.
 */

public class RegistroPresenter implements IRegistroPresenter {

    private IRegistroFragmentView view;

    public RegistroPresenter(IRegistroFragmentView view){
        this.view = view;
    }

    @Override
    public void registrar(String nombre, String email, String password) {
        try {

            IAutenticacionBP autenticacionBP = new AutenticacionBP();

            view.deshabilitarViews();
            view.mostrarProgress();

            autenticacionBP.registrarUsuario(nombre, email, password, new ICallbackPresenter<Boolean>() {
                @Override
                public void respuesta(Boolean resp) {
                    view.habilitarViews();
                    view.ocultarProgress();
                    view.goToLogin();
                }

                @Override
                public void error(Exception e) {
                    view.habilitarViews();
                    view.ocultarProgress();
                    view.mostrarError(e.getMessage());
                }
            });


        }catch (Exception e){

        }
    }


}
