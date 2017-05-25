package com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters;

import com.lavuelta.lavueltaapp.dominio.AutenticacionBP;
import com.lavuelta.lavueltaapp.dominio.IAutenticacionBP;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.ILoginFragmentView;
import com.lavuelta.lavueltaapp.utilidades.Cache;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

/**
 * Created by jggomez on 23-May-17.
 */

public class LoginPresenter implements ILoginPresenter {

    private ILoginFragmentView view;

    public LoginPresenter(ILoginFragmentView view) {
        this.view = view;
    }

    @Override
    public void login(final String email, String password) {
        try {

            IAutenticacionBP autenticacionBP = new AutenticacionBP();

            view.deshabilitarViews();
            view.mostrarProgress();

            autenticacionBP.loginUsuario(email, password, new ICallbackPresenter<String>() {
                @Override
                public void respuesta(String uid) {
                    view.habilitarViews();
                    view.ocultarProgress();
                    guardarDatosUsuario(uid, email);
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

    @Override
    public void guardarDatosUsuario(String uid, String email) {
        Cache.addValor(Constantes.KEY_UID_USUARIO, uid);
        Cache.addValor(Constantes.KEY_EMAIL_USUARIO, email);
    }

    @Override
    public void isLogin() {
        if (!Cache.getValor("UID").equals("")){
            view.goToMain();
        }
    }
}
