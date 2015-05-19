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
public class Direccion {
    private int idDireccion;
    private Calle Ca;
    private int  Nu;
    private String Escalera;
    private String Piso;
    private String Letra;
    private String mano;
    
    public Direccion() {
    }

    
    public Direccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }
  
    
        public Direccion( Calle Ca, int Nu, String Escalera, String Piso, String Letra, String mano) {
       
        this.Ca = Ca;
        this.Nu = Nu;
        this.Escalera = Escalera;
        this.Piso = Piso;
        this.Letra = Letra;
        this.mano = mano;
    }
    
    public Direccion(int idDireccion, Calle Ca, int Nu, String Escalera, String Piso, String Letra, String mano) {
        this.idDireccion = idDireccion;
        this.Ca = Ca;
        this.Nu = Nu;
        this.Escalera = Escalera;
        this.Piso = Piso;
        this.Letra = Letra;
        this.mano = mano;
    }

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Calle getCa() {
        return Ca;
    }

    public void setCa(Calle Ca) {
        this.Ca = Ca;
    }

    public int getNu() {
        return Nu;
    }

    public void setNu(int Nu) {
        this.Nu = Nu;
    }

    public String getEscalera() {
        return Escalera;
    }

    public void setEscalera(String Escalera) {
        this.Escalera = Escalera;
    }

    public String getPiso() {
        return Piso;
    }

    public void setPiso(String Piso) {
        this.Piso = Piso;
    }

    public String getLetra() {
        return Letra;
    }

    public void setLetra(String Letra) {
        this.Letra = Letra;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

 
 
    
}
