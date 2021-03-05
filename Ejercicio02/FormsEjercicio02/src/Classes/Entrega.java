/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.Date;


/**
 *
 * @author LuisD
 */
public class Entrega {
    private double ganancias;
    private String destino;
    private Date fecha;
    
    public Entrega(double pganancias, String pdestino, Date pfecha) {
        this.ganancias = pganancias;
        this.destino = pdestino;
        this.fecha = pfecha;
    }
    
    
    public String getDestino()                  {   return this.destino;    }
    public Date getFecha()                    {   return this.fecha;      }
    public double getGanancias()                {   return this.ganancias;   }
    
    
    
    public void setDestino(String pdestino)                     {   this.destino = pdestino;        }
    public void setFecha(Date pfecha)                         {   this.fecha = pfecha;            }
    public void setGanancias(double ppganancias)                {   this.ganancias = ppganancias;     }
    
}
