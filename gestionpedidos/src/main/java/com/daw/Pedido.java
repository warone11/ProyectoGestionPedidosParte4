package com.daw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<Producto> productos;
    private Map<Integer,Integer> cantidades;
    public final static String PRODUCT_NULL_EXCEPTION_MESSAGE = "Producto no puede ser null";
    public final static String PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE = "La lista de productos no puede estar vacía";
    public Pedido(int idPedido, Cliente cliente){
        this.idPedido = idPedido;
        this.cliente = cliente;
        productos= new ArrayList<>();
        cantidades = new HashMap<>();
    }

    public int getIdPedido() {
        return this.idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Producto> getProductos() {
        return this.productos;
    }
    public Map<Integer, Integer> getCantidades() {
        return this.cantidades;
    }

    /**
     * Añade un producto al pedido
     * @param producto objeto de tipo Producto a añadir
     * @param cantidad cantidad de producto a añadir
     * @throws IllegalArgumentException si el producto es null, la cantidad es menor o igual a 0 o si un producto con el mismo id ya existe en el pedido
     * Si el producto ya existe en el pedido, se suma la cantidad al valor actual
     */
    public void addProducto(Producto producto, int cantidad)throws IllegalArgumentException{
        if(producto==null){
            throw new IllegalArgumentException(PRODUCT_NULL_EXCEPTION_MESSAGE);
        }
        if(cantidad<=0){
            throw new IllegalArgumentException(cantidad+" no es una cantidad válida, debe ser mayor que 0");
        }
        if(productos.contains(producto)){
            cantidades.put(producto.getId(),cantidades.get(producto.getId())+cantidad);
        }
        else{
            if(cantidades.containsKey(producto.getId())){
                throw new IllegalArgumentException("Colision de ids en el pedido");
            }
            else{
                productos.add(producto);
                cantidades.put(producto.getId(),cantidad);
            }
        }
    }
    /**
     * Elimina una cantidad de un producto del pedido
     * @param producto objeto de tipo Producto a eliminar
     * @param cantidad cantidad de producto a eliminar
     * @throws IllegalArgumentException si el producto es null, la cantidad es menor o igual a 0 o si el producto no existe en el pedido
     */
    public void quitarProducto(Producto producto, int cantidad) throws IllegalArgumentException{
        if(producto==null){
            throw new IllegalArgumentException(PRODUCT_NULL_EXCEPTION_MESSAGE);
        }
        if(cantidad<=0){
            throw new IllegalArgumentException(cantidad+" no es una cantidad válida, debe ser mayor que 0");
        }
        if(productos.contains(producto)){
            cantidades.put(producto.getId(),cantidades.get(producto.getId())-cantidad);
            if(cantidades.get(producto.getId())<=0){
                cantidades.remove(producto.getId());
                productos.remove(producto);
            }
        }
        else{
            throw new IllegalArgumentException("El producto no existe en el pedido");
        }
    }
    /**
     * Elimina un producto del pedido
     * @param producto objeto de tipo Producto a eliminar
     * @throws IllegalArgumentException si el producto es null o si el producto no existe en el pedido
     */
    public void quitarProducto(Producto producto){
        if(producto==null){
            throw new IllegalArgumentException(PRODUCT_NULL_EXCEPTION_MESSAGE);
        }
        if(productos.contains(producto)){
            cantidades.remove(producto.getId());
            productos.remove(producto);
        }
        else{
            throw new IllegalArgumentException("El producto no existe en el pedido");
        }
    }
    /**
     * Suma los precios de los productos del pedido
     * @return total del pedido
     * @throws IllegalArgumentException si el pedido no contiene productos
     */
    public double calcularTotal() throws IllegalArgumentException{
        if(productos.isEmpty()){
            throw new IllegalArgumentException(PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE);
        }
        double suma=0;
        
        for (Producto producto : productos) {
            
                suma+=producto.getPrecioBase()*cantidades.get(producto.getId());
            
        }

        return suma;
    }
    /**
     * Calcula el coste de envio del pedido
     * @param pais el pais al que se envia el pedido
     * @return coste de envio del pedido
     */
    public double calcularEnvio(String pais)throws IllegalArgumentException{
        if(productos.isEmpty()){
            throw new IllegalArgumentException(PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE);
        }
        double peso =0;
        for (Producto producto : productos) {
            if(producto instanceof ProductoFisico productoFisico){
                peso+=productoFisico.getPeso()*cantidades.get(producto.getId());
            }
        }
        return ProductoFisico.costeEnvio(peso,pais);
    }
    /**
     * Calcula el IVA del pedido
     * @param iva el IVA a aplicar
     * @return IVA del pedido
     */
    public double calcularIva(String iva) throws IllegalArgumentException{
        if(productos.isEmpty()){
            throw new IllegalArgumentException(PRODUCT_LIST_EMPTY_EXCEPTION_MESSAGE);
        }
        double suma=0;
        for (Producto producto : productos) {
            if(producto instanceof ProductoDigital productoDigital){
                suma+=productoDigital.aplicarIVA(iva)*cantidades.get(producto.getId());
            }
        }
        return suma;
    }



}
