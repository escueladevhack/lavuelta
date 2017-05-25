package com.lavuelta.lavueltaapp.presentacion.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lavuelta.lavueltaapp.presentacion.actividades.AutenticacionActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, AutenticacionActivity.class);
        startActivity(intent);
        finish();
    }
}
