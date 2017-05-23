package com.lavuelta.lavueltaapp.presentacion.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.IRegistroPresenter;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.RegistroPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnRegistroInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFragment extends Fragment implements IRegistroFragmentView {

    private IRegistroPresenter registroPresenter;

    @BindView(R.id.txtNombreRegistro)
    EditText txtNombreRegistro;

    @BindView(R.id.txtEmailRegistro)
    EditText txtEmailRegistro;

    @BindView(R.id.txtPasswordRegistro)
    EditText txtPasswordRegistro;

    @BindView(R.id.progress)
    ProgressBar progress;

    private OnRegistroInteractionListener mListener;

    public RegistroFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RegistroFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroFragment newInstance() {
        RegistroFragment fragment = new RegistroFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registro, container, false);
        ButterKnife.bind(this, view);

        registroPresenter = new RegistroPresenter(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRegistroInteractionListener) {
            mListener = (OnRegistroInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRegistroInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void habilitarViews() {
        setViews(true);
    }

    @Override
    public void deshabilitarViews() {
        setViews(false);
    }

    @Override
    public void mostrarProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgress() {
        progress.setVisibility(View.GONE);
    }

    @OnClick(R.id.authLinkLogin)
    @Override
    public void goToLogin() {
        mListener.goToLogin();
    }

    @OnClick(R.id.btnCrearCuenta)
    @Override
    public void registrar() {
        registroPresenter.registrar(txtNombreRegistro.getText().toString(),
                txtEmailRegistro.getText().toString(),
                txtPasswordRegistro.getText().toString()
        );
    }

    @Override
    public void mostrarError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }

    private void setViews(boolean habilitado) {
        txtNombreRegistro.setEnabled(habilitado);
        txtEmailRegistro.setEnabled(habilitado);
        txtPasswordRegistro.setEnabled(habilitado);
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnRegistroInteractionListener {

        void goToLogin();

    }
}
