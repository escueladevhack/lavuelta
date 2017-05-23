package com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters;

import com.lavuelta.lavueltaapp.dominio.AutenticacionBP;
import com.lavuelta.lavueltaapp.dominio.IAutenticacionBP;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.ILoginFragmentView;

/**
 * Created by jggomez on 23-May-17.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginFragmentView view;

    public LoginPresenter(ILoginFragmentView view) {
        this.view = view;
    }

    @Override
    public void login(String email, String password) {
        try {

            IAutenticacionBP autenticacionBP = new AutenticacionBP();

            view.deshabilitarViews();
            view.mostrarProgress();

            autenticacionBP.loginUsuario(email, password, new ICallbackPresenter<Boolean>() {
                @Override
                public void respuesta(Boolean resp) {
                    view.habilitarViews();
                    view.ocultarProgress();
                    view.goToMain();
                }

                @Override
                public void error(Exception e) {
                    view.habilitarViews();
                    view.ocultarProgress();
                    view.mostrarError(e.getMessage());
                }
            });

        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }
}
