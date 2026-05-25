package com.daw;

public class Cliente {
    private int id;
    private String nombre;
    private int anyosAntiguedad;
    private boolean esVip;
    private String pais;
    public Cliente(int id, String nombre, int anyosAntiguedad, boolean esVip, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.anyosAntiguedad = anyosAntiguedad;
        this.esVip = esVip;
        this.pais = pais;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnyosAntiguedad() {
        return this.anyosAntiguedad;
    }

    public void setAnyosAntiguedad(int anyosAntiguedad) {
        this.anyosAntiguedad = anyosAntiguedad;
    }

    public boolean isEsVip() {
        return this.esVip;
    }


    public void setEsVip(boolean esVip) {
        this.esVip = esVip;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
    public double obtenerDescuento() {
        double descuento = 0;
        if(anyosAntiguedad > 5){
            descuento = 0.03;
        }
        if(esVip){
            descuento += 0.03;
        }
        return descuento;
    }
}
