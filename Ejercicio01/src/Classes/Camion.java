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
public class Camion {
    
    private int id;
    private int id_producto;
    private String placa;
    private double peso_carga;
    private String destino;
    
    public Camion(int id, int id_producto, String placa, double peso_carga, String destino) {
        this.id = id;
        this.id_producto = id_producto;
        this.placa = placa;
        this.peso_carga = peso_carga;
        this.destino = destino;
    }
    
}
