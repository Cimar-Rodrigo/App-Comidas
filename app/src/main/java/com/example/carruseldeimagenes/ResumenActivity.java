package com.example.carruseldeimagenes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class ResumenActivity extends AppCompatActivity {
    private ListView lista;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen);
        initComponents();
        mostrarResumen();

    }

    public void initComponents() {
        lista =  findViewById(R.id.lista);
    }


    public void mostrarResumen(){
        int[] precios = getIntent().getIntArrayExtra("precios");
        String[] nombre = getIntent().getStringArrayExtra("nombre");
        int[] cantidadPlatos = getIntent().getIntArrayExtra("cantidadPlatos");
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        adapter.add("Nombre\t\t\t" + "Cantidad\t\t\t" + "Precio\t\t\t\t" + "Total");
        for(int i = 0; i < cantidadPlatos.length; i++){
            if(cantidadPlatos[i] > 0){
                int precioTotal = cantidadPlatos[i] * precios[i];
                adapter.add(nombre[i] + "\t\t\t" + cantidadPlatos[i]  + "\t\t\t\t\t\t\t\tBs. " + precios[i] + "\t\t\t\t\tBs. " + precioTotal);
            }
        }
        lista.setAdapter(adapter);


    }

    public void volver(View v){
        finish();
    }

    public void finalizar(View v){
        // hacer un toast de gracias por la compra

        Toast.makeText(this, "Gracias por su compra", Toast.LENGTH_LONG).show();

        finish();
    }
}
