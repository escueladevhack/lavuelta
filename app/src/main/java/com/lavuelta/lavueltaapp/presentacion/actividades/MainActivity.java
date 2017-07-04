package com.lavuelta.lavueltaapp.presentacion.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.entidades.Servicio;
import com.lavuelta.lavueltaapp.presentacion.actividades.presenters.MainPresenter;
import com.lavuelta.lavueltaapp.presentacion.adaptadores.ServiciosAdaptador;
import com.lavuelta.lavueltaapp.utilidades.Cache;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IMainView {

    private ServiciosAdaptador adapter;
    private MainPresenter mainPresenter;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.rvServicios)
    RecyclerView rvServicios;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_white_36dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        initAdapter();
        initRecycler();

        mainPresenter = new MainPresenter(this);
        mainPresenter.obtenerServiciosxUsuario();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mainPresenter.obtenerServiciosxUsuario();
    }

    private void initRecycler() {
        rvServicios.setLayoutManager(new LinearLayoutManager(this));
        rvServicios.setAdapter(adapter);
    }

    private void initAdapter() {
        if (adapter == null) {
            adapter = new ServiciosAdaptador(new ArrayList<Servicio>());
        }
    }

    @Override
    public void cargarServicios(List<Servicio> lstServicios) {
        adapter.clearDataset();
        adapter.addDataset(lstServicios);
    }

    @OnClick(R.id.fabServicio)
    public void clickFabServicio() {
        Intent intent = new Intent(this, ServicioActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Cache.limpiar();
            Intent intent = new Intent(this, AutenticacionActivity.class);
            startActivity(intent);
            finish();
        }

        if (id == android.R.id.home) {
            drawer.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_addServicio) {
            // Handle the camera action
        } else if (id == R.id.nav_perfil) {
            Intent intent = new Intent(this, PerfilUsuarioActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contactar) {

        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void habilitarViews() {

    }

    @Override
    public void deshabilitarViews() {

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
}
