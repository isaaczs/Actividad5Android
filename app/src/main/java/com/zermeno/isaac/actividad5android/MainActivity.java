package com.zermeno.isaac.actividad5android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Usuario> listaUsuarios;
    RecyclerView recyclerUsuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        construirRecycler();

    }

    public void agregarUsuarios() {
        listaUsuarios.add(new Usuario("José Isaac","Zermeño Sanchez", "22",R.drawable.user));
        listaUsuarios.add(new Usuario("Josue", "Zermeño Sánchez", "34", R.drawable.user ));
        listaUsuarios.add(new Usuario("Keyla", "Zermeño Sánchez", "29", R.drawable.user ));
        listaUsuarios.add(new Usuario("Alan David", "Zermeño Sánchez", "16", R.drawable.user ));
    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.botonVistaLista: Utilidades.visualizacion=Utilidades.LIST;
                break;
            case R.id.botonVistaCuadricula: Utilidades.visualizacion=Utilidades.GRID;
                break;
        }
        construirRecycler();
    }

    public void construirRecycler() {
        listaUsuarios =new ArrayList<>();
        recyclerUsuarios = (RecyclerView) findViewById(R.id.RecyclerXML);

        if (Utilidades.visualizacion==Utilidades.LIST){
            recyclerUsuarios.setLayoutManager(new LinearLayoutManager(this));
        }else {
            recyclerUsuarios.setLayoutManager(new GridLayoutManager(this,3));
        }

        agregarUsuarios();

        AdaptadorUsuarios adapter=new AdaptadorUsuarios(listaUsuarios);

        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),
                        "Selección: "+ listaUsuarios.get
                                (recyclerUsuarios.getChildAdapterPosition(view))
                                .getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        recyclerUsuarios.setAdapter(adapter);
    }
}