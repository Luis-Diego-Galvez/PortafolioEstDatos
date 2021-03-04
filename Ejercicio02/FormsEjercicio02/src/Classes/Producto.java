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
    
    private double precio;
    private double peso;
    
    public Producto(double pprecio, double ppeso) {
        this.precio = pprecio;
        this.peso = ppeso;
    }
    
    
    public double getPrecio()   {     return this.precio;     }
    public double getPeso()     {     return this.peso;       }
}
