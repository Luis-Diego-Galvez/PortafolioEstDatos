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
public class Sucursal {
    private int id;
    private String locacion;
    private double ingreso;
    private double costo;
    private int cant_empleados;
    
    public Sucursal(int id, String locacion, double ingreso, double costo, int cantemp) {
        this.id = id;
        this.locacion = locacion;
        this.ingreso = ingreso;
        this.costo = costo;
        this.cant_empleados = cantemp;
    }
    
}
