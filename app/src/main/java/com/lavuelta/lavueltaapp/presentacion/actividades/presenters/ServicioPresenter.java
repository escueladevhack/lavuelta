package com.lavuelta.lavueltaapp.presentacion.actividades.presenters;

import com.lavuelta.lavueltaapp.dominio.IServicioBP;
import com.lavuelta.lavueltaapp.dominio.ServicioBP;
import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.presentacion.actividades.IServicioView;
import com.lavuelta.lavueltaapp.utilidades.Cache;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

/**
 * Created by jggomez on 25-May-17.
 */

public class ServicioPresenter implements IServicioPresenter {

    private IServicioView view;

    public ServicioPresenter(IServicioView view) {
        this.view = view;
    }

    @Override
    public void guardarServicio(Servicio servicio) {
        try {

            view.deshabilitarViews();
            view.mostrarProgress();

            IServicioBP servicioBP = new ServicioBP();

            servicioBP.guardar(servicio, Cache.getValor(Constantes.KEY_UID_USUARIO));

            view.habilitarViews();
            view.ocultarProgress();

        } catch (Exception e) {
            view.habilitarViews();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }
    }

}
