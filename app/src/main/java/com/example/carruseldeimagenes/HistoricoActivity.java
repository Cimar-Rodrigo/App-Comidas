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
        int[] precios = getIntent().getIntArrayExtra("precios");
        for (int i = 0; i < precios.length; i++) {
            System.out.println(precios[i]);
        }


    }
    public void volver(View v){
        finish();
    }
}
