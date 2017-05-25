package com.lavuelta.lavueltaapp.presentacion.actividades;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.entidades.Usuario;
import com.lavuelta.lavueltaapp.presentacion.actividades.presenters.IPerfilUsuarioPresenter;
import com.lavuelta.lavueltaapp.presentacion.actividades.presenters.PerfilUsuarioPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PerfilUsuarioActivity extends AppCompatActivity implements IPerfilUsuarioView {

    private IPerfilUsuarioPresenter perfilUsuarioPresenter;

    @BindView(R.id.txtNombres)
    EditText txtNombres;

    @BindView(R.id.txtDireccion)
    EditText txtDireccion;

    @BindView(R.id.txtCelular)
    EditText txtCelular;

    @BindView(R.id.txtEmail)
    TextView txtEmail;

    @BindView(R.id.progress)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_usuario);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.editar_perfil));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        perfilUsuarioPresenter = new PerfilUsuarioPresenter(this);

        perfilUsuarioPresenter.cargarUsuarioxID();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.guardar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.guardar) {
            guardarUsuario();
            finish();
        }

        if (id == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void guardarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(txtNombres.getText().toString());
        usuario.setDireccion(txtDireccion.getText().toString());
        usuario.setCelular(txtCelular.getText().toString());
        usuario.setEmail(txtEmail.getText().toString());

        perfilUsuarioPresenter.guardarUsuario(usuario);
    }

    @Override
    public void cargarUsuario(Usuario usuario) {
        txtNombres.setText(usuario.getNombre());
        txtDireccion.setText(usuario.getDireccion());
        txtCelular.setText(usuario.getCelular());
        txtEmail.setText(usuario.getEmail());
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

    }

    private void setInputs(boolean habilitar) {
        txtNombres.setEnabled(habilitar);
        txtDireccion.setEnabled(habilitar);
        txtEmail.setEnabled(habilitar);
    }
}
