package com.example.carruseldeimagenes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;
    private int imgs[] = {R.drawable.p01, R.drawable.p02, R.drawable.p03, R.drawable.p04, R.drawable.p05, R.drawable.p06, R.drawable.p07, R.drawable.p08, R.drawable.p09, R.drawable.p10, R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15, R.drawable.p16, R.drawable.p17, R.drawable.p18, R.drawable.p19, R.drawable.p20, R.drawable.p21, R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25, R.drawable.p26};
    private int precios[] = {17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42};
    private String[] nombre = {"Charque", "Papas a la huancaina", "Majadito", "Pique Macho", "Hamburguesa", "Silpancho", "Plato paceño", "Sajta", "Milanesa de pollo", "Ramen", "Pollo al horno", "Salchipapa", "Pulpo", "Chicharron", "Sopita de fideo", "Chicharron","Ispi", "Chairo", "Filete", "Aji de fideo", "Sushi", "Camarones", "Aji de racacha", "Asado", "Porcion de trucha dorada", "Silpancho"};
    private int[] cantidadPlatos = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private ImageView img;
    private TextView precio;
    private TextView nombrePlato;
    private Button btnRestar;
    private Button btnSumar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    public void initComponents() {
        img = (ImageView) findViewById(R.id.imgPlato);
        precio = (TextView) findViewById(R.id.txtPrecioPlato);
        nombrePlato = (TextView) findViewById(R.id.txtNombrePlato);
        btnRestar = (Button) findViewById(R.id.btnRestar);
        // desactivar el boton restar cuando la cantidad es 0
        verificar();
        btnSumar = (Button) findViewById(R.id.btnSumar);
    }

    public void verificar(){
        if(cantidadPlatos[contador] == 0){
            btnRestar.setEnabled(false);
        }else{
            btnRestar.setEnabled(true);
        }
    }
    public void atras(View view){
        contador--;

        if(contador < 0){
            contador = imgs.length - 1;
        }


        verificar();
        img.setImageResource(imgs[contador]);
        precio.setText("Bs. " + precios[contador]);
        nombrePlato.setText(nombre[contador]);
    }

    public void siguiente(View v){
        contador++;

        if(contador == imgs.length){
            contador = 0;
        }
        verificar();
        img.setImageResource(imgs[contador]);
        precio.setText("Bs. " + precios[contador]);
        nombrePlato.setText(nombre[contador]);
    }

    public void sumar(View v){
        cantidadPlatos[contador]++;
        verificar();
    }

    public void restar(View v){
        cantidadPlatos[contador]--;
        verificar();
    }

    public void verSiguiente(View v){
        Intent intent = new Intent(this, ResumenActivity.class);
        intent.putExtra("cantidadPlatos", cantidadPlatos);
        intent.putExtra("precios", precios);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
    }



}
