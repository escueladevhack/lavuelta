package com.lavuelta.lavueltaapp.presentacion.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.presentacion.actividades.presenters.IServicioPresenter;
import com.lavuelta.lavueltaapp.presentacion.actividades.presenters.ServicioPresenter;
import com.lavuelta.lavueltaapp.utilidades.Constantes;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ServicioActivity extends AppCompatActivity implements IServicioView {

    private final int REQUESTMAPS = 999999;
    private IServicioPresenter servicioPresenter;

    @BindView(R.id.btnMapa)
    ImageButton btnMapa;

    @BindView(R.id.txtDireccionEnvio)
    EditText txtDireccionEnvio;

    @BindView(R.id.txtNombreEnvia)
    EditText txtNombreEnvia;

    @BindView(R.id.txtDireccionDestino)
    EditText txtDireccionDestino;

    @BindView(R.id.txtNombreRecibe)
    EditText txtNombreRecibe;

    @BindView(R.id.txtDescServicio)
    EditText txtDescServicio;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        servicioPresenter = new ServicioPresenter(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.guardar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.guardar) {
            guardar();
            finish();
        }

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.btnMapa)
    public void clickMapa() {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivityForResult(intent, REQUESTMAPS);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUESTMAPS) {
            if (resultCode == RESULT_OK) {
                txtDireccionEnvio.setText(data.getStringExtra(Constantes.KEY_Direccion));
            }
        }
    }

    @Override
    public void guardar() {
        Servicio servicio = new Servicio();

        servicio.setDireccionDestino(txtDireccionDestino.getText().toString());
        servicio.setDireccionEnvio(txtDireccionEnvio.getText().toString());
        servicio.setNombreEnvia(txtNombreEnvia.getText().toString());
        servicio.setNombreRecibe(txtNombreRecibe.getText().toString());
        servicio.setDescServicio(txtDescServicio.getText().toString());

        servicioPresenter.guardarServicio(servicio);
    }

    @Override
    public void habilitarViews() {
        setInputs(true);
    }

    @Override
    public void deshabilitarViews() {
        setInputs(false);
    }

    @Override
    public void mostrarProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void mostrarError(String error) {
        Snackbar.make(findViewById(android.R.id.content),
                error, Snackbar.LENGTH_LONG).show();
    }

    private void setInputs(boolean habilitar) {
        txtDireccionEnvio.setEnabled(habilitar);
        txtDireccionDestino.setEnabled(habilitar);
        txtNombreRecibe.setEnabled(habilitar);
        txtNombreEnvia.setEnabled(habilitar);
        txtDescServicio.setEnabled(habilitar);
    }
}
