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
public class Localidad {

    public Localidad(String idLoc) {
        this.idLoc = idLoc;
    }
    
    private String idLoc;
    private String nLoc;
    private Municipio Mu;
    
        public Localidad(){}
    
        public Localidad(String idLoc, String nLoc, Municipio Mu) {
        this.idLoc = idLoc;
        this.nLoc = nLoc;
        this.Mu = Mu;
    }
      public Localidad(String idLoc, Municipio Mu) {
        this.idLoc = idLoc;
        this.Mu = Mu;
    }

    
    public String getIdLoc() {
        return idLoc;
    }

    public void setIdLoc(String idLoc) {
        this.idLoc = idLoc;
    }

    public String getnLoc() {
        return nLoc;
    }

    public void setnLoc(String nLoc) {
        this.nLoc = nLoc;
    }

    public Municipio getMu() {
        return Mu;
    }

    public void setMu(Municipio Mu) {
        this.Mu = Mu;
    }




}
