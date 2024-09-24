package com.appmobile.examenandroidtorrez.ui.cargar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.appmobile.examenandroidtorrez.MainActivity;
import com.appmobile.examenandroidtorrez.model.Auto;

public class CargarViewModel extends AndroidViewModel {

    private MutableLiveData<String> mErrorMsj;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getmErrorMsj(){
        if (mErrorMsj == null) {
            mErrorMsj = new MutableLiveData<>();
        }
        return mErrorMsj;
    }

    public boolean existePatente(String patenteIngresada) {
        for (Auto auto : MainActivity.autos) {
            if (auto.getPatente().equals(patenteIngresada)) {
                return true;
            }
        }
        return false;
    }


    public void validarAgregarAuto(String marcaIngresada, String modeloIngresado, String anioIngresado, String patenteIngresada,String combustibleIngresado, String precioIngresado) {
       //variable para parsear string a int
        int anio;

        if (patenteIngresada == null || patenteIngresada.trim().isEmpty()) {
            getmErrorMsj().setValue("Error: la patente no puede estar vacia.");
            return;
        }

        // Verificar si la patente ya existe
        if ( existePatente(patenteIngresada)) {
            getmErrorMsj().setValue("Error: la patente ya esta registrada.");
            return;
        }

        // Validación de campos
        if (marcaIngresada == null || marcaIngresada.trim().isEmpty()) {
            getmErrorMsj().setValue("Error: la marca no puede estar vacia.");
            return;
        }

        if (modeloIngresado == null || modeloIngresado.trim().isEmpty()) {
            getmErrorMsj().setValue("Error: el modelo no puede estar vacio.");
            return;
        }

        if (combustibleIngresado == null || combustibleIngresado.trim().isEmpty()) {
            getmErrorMsj().setValue("Error: el tipo de combustible no puede estar vacio.");
            return;
        }

        if (precioIngresado == null || precioIngresado.trim().isEmpty()) {
            getmErrorMsj().setValue("Error: el precio no puede estar vacio.");
            return;
        }
        if (anioIngresado == null || anioIngresado.trim().isEmpty()){
            getmErrorMsj().setValue("Error: el año del vehiculo es obligatorio.");
            return;
        }else{
            anio = Integer.parseInt(anioIngresado);
        }



        // Crear el objeto Auto
        Auto auto = new Auto(marcaIngresada, modeloIngresado, anio, patenteIngresada, combustibleIngresado, precioIngresado);

        MainActivity.autos.add(auto);
        getmErrorMsj().setValue("Auto agregado con exito.");
    }
}
