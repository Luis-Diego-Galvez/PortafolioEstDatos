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
public class Empleado {
    private int id;
    private String nombre;
    private double sueldo;
    private String cargo;
    private String tel;
    
    public Empleado(int id, String nombre, double sueldo, String cargo, String tel) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.tel = tel;
    }
    
}
