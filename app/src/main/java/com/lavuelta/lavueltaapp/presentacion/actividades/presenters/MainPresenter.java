package com.lavuelta.lavueltaapp.presentacion.actividades.presenters;

import com.lavuelta.lavueltaapp.dominio.IServicioBP;
import com.lavuelta.lavueltaapp.dominio.ServicioBP;
import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.presentacion.actividades.IMainView;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ICallbackPresenter;
import com.lavuelta.lavueltaapp.utilidades.Cache;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

import java.util.List;

/**
 * Created by jggomez on 31-May-17.
 */

public class MainPresenter implements IMainPresenter {

    private IMainView view;

    public MainPresenter(IMainView view) {
        this.view = view;
    }

    @Override
    public void obtenerServiciosxUsuario() {
        try {

            view.deshabilitarViews();
            view.mostrarProgress();

            IServicioBP servicioBP = new ServicioBP();

            servicioBP.obtenerServiciosxUsuario(Cache.getValor(Constantes.KEY_UID_USUARIO),
                    new ICallbackPresenter<List<Servicio>>() {
                        @Override
                        public void respuesta(List<Servicio> resp) {
                            view.habilitarViews();
                            view.ocultarProgress();
                            if (resp != null) {
                                view.cargarServicios(resp);
                            }
                        }

                        @Override
                        public void error(Exception e) {
                            view.habilitarViews();
                            view.ocultarProgress();
                            view.mostrarError(e.getMessage());
                        }
                    });

        } catch (Exception e) {
            view.habilitarViews();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }
    }
}
