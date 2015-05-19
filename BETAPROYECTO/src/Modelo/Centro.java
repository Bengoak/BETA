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
public class Centro {
     private String nCentro;
   private int  idCentro;
    public Centro(String nCentro) {
        this.nCentro = nCentro;
    }
  

    public Centro(int idCentro) {
        this.idCentro = idCentro;
    }

   
  

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public Centro(int idCentro, String nCentro) {
        this.idCentro = idCentro;
        this.nCentro = nCentro;
    }
  
    public String getnCentro() {
        return nCentro;
    }

    public void setnCentro(String nCentro) {
        this.nCentro = nCentro;
    }
   
   
}
