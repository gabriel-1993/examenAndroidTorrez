package com.appmobile.examenandroidtorrez.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appmobile.examenandroidtorrez.MainActivity;
import com.appmobile.examenandroidtorrez.R;
import com.appmobile.examenandroidtorrez.model.Auto;


import java.util.ArrayList;


public class ListarAdapter  extends RecyclerView.Adapter<ListarAdapter.ViewHolderListar>{

    private ArrayList<Auto> autos = MainActivity.autos;
    private LayoutInflater li;

    public ListarAdapter(ArrayList<Auto> autos, LayoutInflater li){
        this.autos = autos;
        this.li = li;
    }


    //Es el primer metodo que se va ejecutar y va capturar el  adapter cual es la vista/item asociada
    @NonNull
    @Override
    public ViewHolderListar onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //pasamos el item y el contenedor padre para mostrarla y false no hay otra vista asociada
        View view = li.inflate(R.layout.tarjeta, parent,false);
        //viewholder espera una vista
        return new ViewHolderListar(view);
    }

    //elemento que se ejecuta por cada elem de la lista y la setea en un nuevo item
    @Override
    public void onBindViewHolder(@NonNull ViewHolderListar holder, int position) {

        Auto auto = autos.get(position);

        //holder es la vista con la instancia de cada uno de sus componentes ya capturados para poder setearles su contenido string,foto,etc
         holder.tvMarca.setText(auto.getMarca());
        holder.tvModelo.setText(auto.getModelo());
        holder.tvAnio.setText(auto.getAnio()+"");
        holder.tvPatente.setText(auto.getPatente());
        holder.tvCombustible.setText(auto.getCombustible());
        holder.tvPrecio.setText(auto.getPrecio());
    }

    @Override
    public int getItemCount() {
        return autos.size();
    }

    //PUENTE ENTRE XML Y ADAPTAR
    public class ViewHolderListar extends RecyclerView.ViewHolder{

        TextView tvMarca, tvModelo, tvAnio, tvPatente, tvCombustible, tvPrecio;

        public ViewHolderListar(@NonNull View itemView) {
            super(itemView);
            tvMarca = itemView.findViewById(R.id.tvMarca);
            tvModelo = itemView.findViewById(R.id.tvModelo);
            tvAnio = itemView.findViewById(R.id.tvAnio);
            tvPatente = itemView.findViewById(R.id.tvPatente);
            tvCombustible = itemView.findViewById(R.id.tvCombustible);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}
