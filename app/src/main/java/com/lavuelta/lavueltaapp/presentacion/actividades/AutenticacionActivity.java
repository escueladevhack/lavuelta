package com.lavuelta.lavueltaapp.presentacion.actividades;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.RegistroFragment;

public class AutenticacionActivity extends AppCompatActivity implements
        RegistroFragment.OnRegistroInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacion);

        initFragment();
    }

    private void initFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameAutenticacion, RegistroFragment.newInstance());
        transaction.commit();
    }
}
