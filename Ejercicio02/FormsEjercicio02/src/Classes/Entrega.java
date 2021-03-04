/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.Producto;
import Classes.Camionero;
import java.util.ArrayList;

/**
 *
 * @author LuisD
 */
public class Entrega {
    private double ganancias;
    private String destino;
    private String fecha;
    
    public Entrega(double pganancias, String pdestino, String pfecha) {
        this.ganancias = pganancias;
        this.destino = pdestino;
        this.fecha = pfecha;
    }
    
    
    public String getDestino()                  {   return this.destino;    }
    public String getFecha()                    {   return this.fecha;      }
    public double getGanancias()                {   return this.ganancias;   }
    
    
    
    public void setDestino(String pdestino)                     {   this.destino = pdestino;        }
    public void setFecha(String pfecha)                         {   this.fecha = pfecha;            }
    public void setGanancias(double ppganancias)                {   this.ganancias = ppganancias;     }
    
}
