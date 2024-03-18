package com.example.carruseldeimagenes;

public class Historico {
    private int[] preciosHistoricos;
    private String[] nombreHistoricos;
    private int[] cantidadPlatosHistoricos = new int[26];

    public Historico(int[] preciosHistoricos, String[] nombreHistoricos, int[] cantidadPlatosHistoricos) {
        this.preciosHistoricos = preciosHistoricos;
        this.nombreHistoricos = nombreHistoricos;

        for(int i = 0; i < cantidadPlatosHistoricos.length; i++){
            this.cantidadPlatosHistoricos[i] = cantidadPlatosHistoricos[i];
        }

    }

    public int getPrecioTotal(){
        int precioTotal = 0;
        for(int i = 0; i < cantidadPlatosHistoricos.length; i++){
            precioTotal += cantidadPlatosHistoricos[i] * preciosHistoricos[i];
        }
        return precioTotal;
    }

    public int getPlatosTotales(){
        int platosTotales = 0;
        for(int i = 0; i < cantidadPlatosHistoricos.length; i++){
            platosTotales += cantidadPlatosHistoricos[i];
        }
        return platosTotales;
    }

    public int[] getPreciosHistoricos() {
        return preciosHistoricos;
    }
    public int[] getCantidadPlatosHistoricos() {
        return cantidadPlatosHistoricos;
    }
}
