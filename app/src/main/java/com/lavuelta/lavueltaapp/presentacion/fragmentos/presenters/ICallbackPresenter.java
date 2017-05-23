package com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters;

/**
 * Created by jggomez on 18-May-17.
 */

public interface ICallbackPresenter<T> {

    void respuesta(T resp);

    void error(Exception e);

}
