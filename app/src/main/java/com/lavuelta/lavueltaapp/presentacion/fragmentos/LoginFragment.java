package com.lavuelta.lavueltaapp.presentacion.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.ILoginPresenter;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFragment.OnLoginInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment implements ILoginFragmentView {

    private OnLoginInteractionListener mListener;

    private ILoginPresenter loginPresenter;

    @BindView(R.id.txtEmailLogin)
    EditText txtEmailLogin;

    @BindView(R.id.txtPasswordLogin)
    EditText txtPasswordLogin;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.progress)
    ProgressBar progress;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
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
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginInteractionListener) {
            mListener = (OnLoginInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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

    @Override
    public void goToMain() {

    }

    @Override
    public void login() {
        loginPresenter.login(txtEmailLogin.getText().toString(), txtPasswordLogin.getText().toString());
    }

    @Override
    public void mostrarError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }

    private void setViews(boolean habilitado) {
        txtEmailLogin.setEnabled(habilitado);
        txtPasswordLogin.setEnabled(habilitado);
        btnLogin.setEnabled(habilitado);
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
    public interface OnLoginInteractionListener {
        // TODO: Update argument type and name
        //void onFragmentInteraction(Uri uri);
    }
}
