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
public class Calle {
    int idTramo;
    Localidad idloc;
    String cp;
    String idCalle;
    String nCalle;
    Via via;
    int nMinPar;
    int nMaxPar;
    int nMinImpar;
    int nMaxImpar;
    
    public Calle(int idTramo) {
        this.idTramo = idTramo;
    }


    public Calle() {
    }
    
 
    
       public Calle(int idTramo, Localidad idloc, String cp, String idCalle, String nCalle, Via via, int nMinPar, int nMaxPar, int nMinImpar,int nMaxImpar) {
        this.idTramo = idTramo;
        this.idloc = idloc;
        this.cp = cp;
        this.idCalle = idCalle;
        this.nCalle = nCalle;
        this.via = via;
        this.nMinPar = nMinPar;
        this.nMaxPar = nMaxPar;
        this.nMinImpar = nMinImpar;
        this.nMaxImpar = nMaxImpar;
    }
       
    public Calle( Localidad idloc, String cp, Via via, String nCalle) {
      
        this.idloc = idloc;
        this.cp = cp;
        this.via = via;
        this.nCalle = nCalle;
    }

    public int getIdTramo() {
        return idTramo;
    }

    public void setIdTramo(int idTramo) {
        this.idTramo = idTramo;
    }


    

    public Localidad getIdloc() {
        return idloc;
    }

    public void setIdloc(Localidad idloc) {
        this.idloc = idloc;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getIdCalle() {
        return idCalle;
    }

    public void setIdCalle(String idCalle) {
        this.idCalle = idCalle;
    }

    public String getnCalle() {
        return nCalle;
    }

    public void setnCalle(String nCalle) {
        this.nCalle = nCalle;
    }

    public Via getVia() {
        return via;
    }

    public void setVia(Via via) {
        this.via = via;
    }

    public int getnMinPar() {
        return nMinPar;
    }

    public void setnMinPar(int nMinPar) {
        this.nMinPar = nMinPar;
    }

    public int getnMaxPar() {
        return nMaxPar;
    }

    public void setnMaxPar(int nMaxPar) {
        this.nMaxPar = nMaxPar;
    }

    public int getnMinImpar() {
        return nMinImpar;
    }

    public void setnMinImpar(int nMinImpar) {
        this.nMinImpar = nMinImpar;
    }

    public int getnMaxImpar() {
        return nMaxImpar;
    }

    public void setnMaxImpar(int nMaxImpar) {
        this.nMaxImpar = nMaxImpar;
    }
 
    
    
}
