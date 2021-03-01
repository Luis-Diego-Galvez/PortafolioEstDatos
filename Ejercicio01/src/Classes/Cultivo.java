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
public class Cultivo {
    
    private int id;
    private double metros_cuadrados;
    private String tipo_cultivo;
    private double cosechamensual_lb;
    
    public Cultivo(int id, double metros_cuadrados, String tipo_cultivo, double cosechamensual_lb) {
        this.id = id;
        this.metros_cuadrados = metros_cuadrados;
        this.tipo_cultivo = tipo_cultivo;
        this.cosechamensual_lb = cosechamensual_lb;
    }
    
}
