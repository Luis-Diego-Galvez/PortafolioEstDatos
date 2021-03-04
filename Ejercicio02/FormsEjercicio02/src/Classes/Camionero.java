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
public class Camionero {
    private String nombre;
    private double salario;
    private double gastos;
    
    public Camionero(String pnombre, double psalario, double pgastos) {
        this.nombre = pnombre;
        this.salario = psalario;
        this.gastos = pgastos;
    }
    
    public String getNombre()  {    return this.nombre;     }
    public double getSalario() {    return this.salario;    }
    public double getGastos()  {     return this.gastos;    }
    
    public void setNombre(String pnombre)   {        this.nombre = pnombre;     }
    public void setSalario(double psalario) {       this.salario = psalario;    }
    public void setGastos(double gasprecio) {       this.gastos = gasprecio;    }
}
