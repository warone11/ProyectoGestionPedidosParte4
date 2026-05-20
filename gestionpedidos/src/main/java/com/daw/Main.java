package com.daw;

public class Main {
    public static void main(String[] args) {
        
        try {
            Producto producto2 = new Producto(2, "Coca Cola", -10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            ProductoDigital productoDigital= new ProductoDigital(2, "Coca Cola", -10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            ProductoFisico productoFisico = new ProductoFisico(2, "Coca Cola", -10, 10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        try {
            ProductoFisico productoFisico = new ProductoFisico(2, "Coca Cola", 10, -10);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        ProductoDigital productoDigital= new ProductoDigital(2, "SUPER MARIO", 100);
        try {
            productoDigital.aplicarIVA( "NO EXISTE");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(productoDigital.aplicarIVA( "GENERAL"));
        ProductoFisico productoFisico = new ProductoFisico(2, "Coca Cola", 10, 10);
        try {
            productoFisico.costeEnvio("");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(productoFisico.costeEnvio("PORTUGAL"));
    }
}
