package com.zermeno.isaac.actividad5android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorUsuarios
        extends RecyclerView.Adapter<AdaptadorUsuarios.ViewHolderUsuarios>
        implements View.OnClickListener{

    ArrayList<Usuario> listaUsuarios;
    private View.OnClickListener listener;

    public AdaptadorUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public ViewHolderUsuarios onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout=0;
        if (Utilidades.visualizacion==Utilidades.LIST){
            layout=R.layout.item_lista;
        }else {
            layout=R.layout.item_cuadricula;
        }

        View view= LayoutInflater.from(parent.getContext()).inflate(layout,null,false);

        view.setOnClickListener(this);

        return new ViewHolderUsuarios(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderUsuarios holder, int position) {
        holder.etiNombre.setText(listaUsuarios.get(position).getNombre());

        if (Utilidades.visualizacion==Utilidades.LIST){
            holder.etiApellido.setText(listaUsuarios.get(position).getApellido());
            holder.etiEdad.setText(listaUsuarios.get(position).getEdad());
        }

        holder.foto.setImageResource(listaUsuarios.get(position).getFoto());
    }

    @Override
    public int getItemCount() {
        return listaUsuarios.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderUsuarios extends RecyclerView.ViewHolder {

        TextView etiNombre,etiApellido, etiEdad;
        ImageView foto;

        public ViewHolderUsuarios(View itemView) {
            super(itemView);
            etiNombre= (TextView) itemView.findViewById(R.id.nombreUsuario);
            if (Utilidades.visualizacion==Utilidades.LIST){
                etiApellido= (TextView) itemView.findViewById(R.id.apellidoUsuario);
                etiEdad = (TextView) itemView.findViewById(R.id.edadUsuario);
            }
            foto= (ImageView) itemView.findViewById(R.id.fotoUsuario);
        }
    }
}
