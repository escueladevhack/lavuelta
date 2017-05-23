package com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters;

import com.lavuelta.lavueltaapp.dominio.AutenticacionBP;
import com.lavuelta.lavueltaapp.dominio.IAutenticacionBP;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.IRecordarFragmentView;

/**
 * Created by jggomez on 23-May-17.
 */

public class RecordarPresenter implements IRecordarPresenter {

    private IRecordarFragmentView view;

    public RecordarPresenter(IRecordarFragmentView view) {
        this.view = view;
    }

    @Override
    public void recordarPassword(String email) {
        try {

            IAutenticacionBP autenticacionBP = new AutenticacionBP();

            view.deshabilitarViews();
            view.mostrarProgress();

            autenticacionBP.recordarUsuario(email, new ICallbackPresenter<Boolean>() {
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

        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }

    }
}
