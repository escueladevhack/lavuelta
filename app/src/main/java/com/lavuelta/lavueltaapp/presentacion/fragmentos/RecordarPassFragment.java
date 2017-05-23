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
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.IRecordarPresenter;
import com.lavuelta.lavueltaapp.presentacion.fragmentos.presenters.RecordarPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RecordarPassFragment.OnRecordarPassInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RecordarPassFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecordarPassFragment extends Fragment implements IRecordarFragmentView {

    private OnRecordarPassInteractionListener mListener;

    private IRecordarPresenter recordarPresenter;

    @BindView(R.id.txtEmailRecordar)
    EditText txtEmailRecordar;

    @BindView(R.id.btnRecordarPass)
    Button btnRecordarPass;

    @BindView(R.id.progress)
    ProgressBar progress;

    public RecordarPassFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RecordarPassFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecordarPassFragment newInstance() {
        RecordarPassFragment fragment = new RecordarPassFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recordar_pass, container, false);
        ButterKnife.bind(this, view);

        recordarPresenter = new RecordarPresenter(this);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecordarPassInteractionListener) {
            mListener = (OnRecordarPassInteractionListener) context;
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
        setInputs(true);
    }

    @Override
    public void deshabilitarViews() {
        setInputs(false);
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

    @OnClick(R.id.btnRecordarPass)
    @Override
    public void recordarPassword() {

    }

    @Override
    public void mostrarError(String error) {
        Snackbar.make(getView(), error, Snackbar.LENGTH_LONG).show();
    }

    private void setInputs(boolean habilitar) {
        txtEmailRecordar.setEnabled(habilitar);
        btnRecordarPass.setEnabled(habilitar);
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
    public interface OnRecordarPassInteractionListener {
        void goToLogin();
    }
}
