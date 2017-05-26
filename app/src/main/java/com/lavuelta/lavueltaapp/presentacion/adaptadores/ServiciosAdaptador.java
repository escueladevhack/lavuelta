package com.lavuelta.lavueltaapp.presentacion.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lavuelta.lavueltaapp.R;
import com.lavuelta.lavueltaapp.entidades.Servicio;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jggomez on 25-May-17.
 */

public class ServiciosAdaptador extends RecyclerView.Adapter<ServiciosAdaptador.ServicioViewHolder> {

    private List<Servicio> dataSet;

    public ServiciosAdaptador(List<Servicio> dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public ServicioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_servicio_list, parent, false);
        return new ServicioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ServicioViewHolder holder, int position) {
        holder.txtDireccionEnvio.setText(dataSet.get(position).getDireccionEnvio());
        holder.txtNombreEnvia.setText(dataSet.get(position).getNombreEnvia());
        holder.txtFechaServicio.setText("20/08/2017");
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ServicioViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txtDireccionEnvio)
        TextView txtDireccionEnvio;

        @BindView(R.id.txtNombreEnvia)
        TextView txtNombreEnvia;

        @BindView(R.id.txtFechaServicio)
        TextView txtFechaServicio;

        public ServicioViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }


}
