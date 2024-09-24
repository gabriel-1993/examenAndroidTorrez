package com.appmobile.examenandroidtorrez.ui.cargar;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appmobile.examenandroidtorrez.databinding.FragmentCargarBinding;
import com.appmobile.examenandroidtorrez.model.Auto;

public class CargarFragment extends Fragment {

    private CargarViewModel mvC;
    private FragmentCargarBinding binding;

    public static CargarFragment newInstance() {
        return new CargarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentCargarBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Inicializar el ViewModel
        mvC = new ViewModelProvider(requireActivity()).get(CargarViewModel.class);

        // Configurar el listener del botón "Agregar"
        binding.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capturar los datos ingresados
                String marcaIngresada = binding.etMarca.getText().toString();
                String modeloIngresado = binding.etModelo.getText().toString();
                String anioIngresado = binding.etAnio.getText().toString();
                String patenteIngresada = binding.etPatente.getText().toString();
                String combustibleIngresado = binding.etCombustible.getText().toString();
                String precioIngresado = binding.etPrecio.getText().toString();

                mvC.validarAgregarAuto(marcaIngresada,modeloIngresado,anioIngresado,patenteIngresada,combustibleIngresado,precioIngresado);

            }
        });

        // Observador para mensajes de error o exito
        mvC.getmErrorMsj().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String msj) {
                binding.tvMsjError.setText(msj);

                // Limpiar los campos solo si el auto fue agregado con éxito
                if (msj.equals("Auto agregado con exito.")) {
                    limpiarCampos();
                }
            }
        });
    }

    private void limpiarCampos() {
        // Limpiar los campos de entrada
        binding.etMarca.setText("");
        binding.etModelo.setText("");
        binding.etAnio.setText("");
        binding.etPatente.setText("");
        binding.etCombustible.setText("");
        binding.etPrecio.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}