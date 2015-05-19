/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.logging.Logger;

/**
 *
 * @author Iñigo
 */
public class Municipio {

    public Municipio(String idMu) {
        this.idMu = idMu;
    }
    
    private String idMu;
    private String nMu;
    private Provincia Prov;
    
    public Municipio() {
    }

  
   
    
    public Municipio(String idMu, String nMu, Provincia Prov) {
        this.idMu = idMu;
        this.nMu = nMu;
        this.Prov = Prov;
    }
       public Municipio(String nMu, Provincia Prov) {
       
        this.nMu = nMu;
        this.Prov = Prov;
    }
      
    public String getIdMu() {
        return idMu;
    }

    public void setIdMu(String idMu) {
        this.idMu = idMu;
    }

    public String getnMu() {
        return nMu;
    }

    public void setnMu(String nMu) {
        this.nMu = nMu;
    }

    public Provincia getProv() {
        return Prov;
    }

    public void setProv(Provincia Prov) {
        this.Prov = Prov;
    }
  
}
