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
public class Provincia {
     
    private String idProv;
    private String nProv;
    
    public Provincia(String id,String n){
    this.idProv=id;
    this.nProv=n;
    }
       public Provincia(){

    }
     public Provincia(String n){
    
    this.nProv=n;
    }
    public String getIdProv() {
        return idProv;
    }

    public void setIdProv(String idProv) {
        this.idProv = idProv;
    }

    public String getnProv() {
        return nProv;
    }

    public void setnProv(String nProv) {
        this.nProv = nProv;
    }
   
}
