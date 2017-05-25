package com.lavuelta.lavueltaapp.presentacion.actividades.presenters;

import com.lavuelta.lavueltaapp.dominio.IUsuarioBP;
import com.lavuelta.lavueltaapp.dominio.UsuarioBP;
import com.lavuelta.lavueltaapp.entidades.Usuario;
import com.lavuelta.lavueltaapp.presentacion.actividades.IPerfilUsuarioView;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;
import com.lavuelta.lavueltaapp.utilidades.Cache;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

/**
 * Created by jggomez on 25-May-17.
 */

public class PerfilUsuarioPresenter implements IPerfilUsuarioPresenter {

    private IPerfilUsuarioView view;

    public PerfilUsuarioPresenter(IPerfilUsuarioView view) {
        this.view = view;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        try {

            view.deshabilitarViews();
            view.mostrarProgress();

            IUsuarioBP usuarioBP = new UsuarioBP();
            usuarioBP.guardar(usuario, Cache.getValor(Constantes.KEY_UID_USUARIO));

            view.habilitarViews();
            view.ocultarProgress();

        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }
    }

    @Override
    public void cargarUsuarioxID() {

        try {

            view.deshabilitarViews();
            view.mostrarProgress();

            IUsuarioBP usuarioBP = new UsuarioBP();

            usuarioBP.consultarXIdentificador(Cache.getValor(Constantes.KEY_UID_USUARIO), new ICallbackPresenter<Usuario>() {
                @Override
                public void respuesta(Usuario resp) {
                    view.cargarUsuario(resp);
                    view.habilitarViews();
                    view.ocultarProgress();
                }

                @Override
                public void error(Exception e) {
                    view.mostrarError(e.getMessage());
                    view.habilitarViews();
                    view.ocultarProgress();
                }
            });


        } catch (Exception e) {
            view.mostrarError(e.getMessage());
        }

    }
}
