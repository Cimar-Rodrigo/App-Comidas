package com.example.carruseldeimagenes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class HistoricoActivity extends AppCompatActivity {

    private ListView lista;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);
        initComponents();
        mostrarHistoricos();


    }

    public void initComponents() {
        lista =  findViewById(R.id.listaH);
    }

    public void mostrarHistoricos(){
        // va a recibir la matriz de precios, cantidad de patos historicos, historicos
        int[] cantidadPlatos = MainActivity.historicos[0].getCantidadPlatosHistoricos();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);

        adapter.add("ID\t\t\t" + "Platos totales\t\t\t" + "Precio Total");

        for(int i = 0; i < MainActivity.contadorHistorico; i++){
            adapter.add((i+1) + "\t\t\t\t\t\t" + MainActivity.historicos[i].getPlatosTotales() + "\t\t\t\t\t\t\tBs. " + MainActivity.historicos[i].getPrecioTotal());
        }

        // for(int i = 0; i < cantidadPlatos.length; i++){

        //    System.out.println("Cantidad de platos: " + cantidadPlatos[i]);
        //}
        lista.setAdapter(adapter);
    }

    // cuando hago click en un item mostrar el detalle del historico
    public void mostrarDetalleHistorico(View v){
        // obtener el item seleccionado
        int item = lista.getSelectedItemPosition();
        // mostrar el detalle del historico
        System.out.println("Item seleccionado: " + item);
    }
    public void volver(View v){
        finish();
    }
}
