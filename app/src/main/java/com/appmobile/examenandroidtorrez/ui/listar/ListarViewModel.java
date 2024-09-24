package com.appmobile.examenandroidtorrez.ui.listar;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.appmobile.examenandroidtorrez.MainActivity;
import com.appmobile.examenandroidtorrez.model.Auto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListarViewModel extends AndroidViewModel {

    //mutable para el observer que captura las tareas para mostrarlas
    private MutableLiveData<ArrayList<Auto>> mLista;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<ArrayList<Auto>> getMlista(){
        if(mLista == null){
            mLista = new MutableLiveData<>();
        }
        return mLista;
    }

    public void imprimirLista() {
       // listar
        // Auto a1 = new Auto("Chevrolet", "CRUZE", 2012, "KJH 198", "Nafta", "10000000");
       // Auto a2 = new Auto("Fiat", "600", 1990, "ASD 113", "Nafta", "3000000");
       // Auto a3 = new Auto("Volkswagen", "GOL", 2004, "DFG 113", "Nafta", "6000000");
      //  MainActivity.autos.add(a1);
      //  MainActivity.autos.add(a2);
      //  MainActivity.autos.add(a3);

        // Ordenar la lista por precio de mayor a menor
        Collections.sort(MainActivity.autos, new Comparator<Auto>() {
            @Override
            public int compare(Auto auto1, Auto auto2) {
                // Eliminar las comas en el precio, convertir a Double y comparar
                Double precio1 = Double.parseDouble(auto1.getPrecio().replace(",", ""));
                Double precio2 = Double.parseDouble(auto2.getPrecio().replace(",", ""));
                // Comparar de mayor a menor
                return precio2.compareTo(precio1);
            }
        });

        // Establecer el valor para ser observado
        mLista.setValue(MainActivity.autos);
    }
}