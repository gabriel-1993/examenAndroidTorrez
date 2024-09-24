package com.appmobile.examenandroidtorrez.ui.listar;


import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.appmobile.examenandroidtorrez.R;
import com.appmobile.examenandroidtorrez.databinding.FragmentListarBinding;
import com.appmobile.examenandroidtorrez.model.Auto;

import java.util.ArrayList;

public class ListarFragment extends Fragment {

    public static ListarFragment newInstance() {
        return new ListarFragment();
    }

    private ListarViewModel mViewModel;
    private FragmentListarBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        //   return inflater.inflate(R.layout.fragment_listar, container, false);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        binding = FragmentListarBinding.inflate(inflater, container, false);
        View root =binding.getRoot();

        mViewModel.getMlista().observe(getViewLifecycleOwner(), new Observer<ArrayList<Auto>>() {
            @Override
            public void onChanged(ArrayList<Auto> autos) {
                ListarAdapter adaptador = new ListarAdapter(autos, inflater);
                GridLayoutManager grilla = new GridLayoutManager(getContext(),1,GridLayoutManager.VERTICAL,false);

                binding.lista.setAdapter(adaptador);
                binding.lista.setLayoutManager(grilla);
            }
        });
        mViewModel.imprimirLista();
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ListarViewModel.class);
        // TODO: Use the ViewModel
    }
}