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
    private int id_cultivo;
    private String tipo_cultivo;
    private double precio_lb;
    private double cant_lb;
    
    public Producto(int id, int id_cultivo, String tipo_cultivo, double precio_lb, double cant_lb) {
        this.id = id;
        this.id_cultivo = id_cultivo;
        this.tipo_cultivo = tipo_cultivo;
        this.precio_lb = precio_lb;
        this.cant_lb = cant_lb;
    }
            
}
