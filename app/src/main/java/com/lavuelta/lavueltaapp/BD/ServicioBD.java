package com.lavuelta.lavueltaapp.BD;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by jggomez on 25-May-17.
 */

@Table(database = LavueltaBD.class)
public class ServicioBD extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    String nombreEnvia;

    @Column
    String DireccionEnvia;

    public String getNombreEnvia() {
        return nombreEnvia;
    }

    public void setNombreEnvia(String nombreEnvia) {
        this.nombreEnvia = nombreEnvia;
    }

    public String getDireccionEnvia() {
        return DireccionEnvia;
    }

    public void setDireccionEnvia(String direccionEnvia) {
        DireccionEnvia = direccionEnvia;
    }
}
