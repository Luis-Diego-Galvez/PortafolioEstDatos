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
public class Truck {
    private double peso;
    private double gas;
    private double vel;
    private double recorrido;
    private boolean enmov;
    
    public Truck() {   }
    public Truck(double peso, double gas, double vel, double recorrido, boolean enmov) {
        this.peso = peso;
        this.gas = gas;
        this.vel = vel;
        this.recorrido = recorrido;
        this.enmov = enmov;
    }
    
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return this.peso;
    }
    
    public void setGas(double gas) {
        this.gas = gas;
    }
    public double getGas() {
        return this.gas;
    }
    
    public void setVelocidad(double vel) {
        this.vel = vel;
    }
    public double getVelocidad() {
        return this.vel;
    }
    
    public void setRecorrido(double recorrido) {
        this.recorrido = recorrido;
    }
    public double getRecorrido() {
        return this.recorrido;
    }
    
    public void EnMovimiento() {
        this.enmov = true;
    }
    public void Frenar(double vel) {
        double velFreno = this.vel - vel;
        for (int i = 0; i < velFreno; i++) {
            try {
                double seg = 30/velFreno;
                Thread.sleep(Math.round(seg));
                this.vel -= 1; 
            } catch (Exception e) {
                this.vel -= 1;
            } 
        }
        
        if (this.vel <= 0) {
            enmov = false;
            this.vel = 0;
        }
        
    }
    public boolean getStatus() {
        return this.enmov;
    }
}
