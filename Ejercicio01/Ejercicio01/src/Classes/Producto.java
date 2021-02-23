/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author LuisD
 */
public class Producto {
    private int id;
    private String nombre;
    private String marca;
    private String tipo;
    private double precio;
    private int stock;
    
    public Producto(int id, String nombre, String marca, String tipo, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precio = precio;
        this.stock = stock;
    }
    
    
}
