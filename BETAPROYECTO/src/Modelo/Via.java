/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Iñigo
 */
public class Via {
    
    String idVia;
    String nVia;
    
    public Via() {
    }
    
    
    public Via(String idVia, String nVia) {
        this.idVia = idVia;
        this.nVia = nVia;
    }

    public Via(String idVia) {
        this.idVia = idVia;
    }
    
   
    public String getIdVia() {
        return idVia;
    }

    public void setIdVia(String idVia) {
        this.idVia = idVia;
    }

    public String getnVia() {
        return nVia;
    }

    public void setnVia(String nVia) {
        this.nVia = nVia;
    }

   
}
