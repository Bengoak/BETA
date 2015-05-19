/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.util.Calendar;
/**
 *
 * @author Iñigo
 */
public class Nen extends Persona{
    
    private int numNen;
    private int sexo;
    private Calendar fecha;
    private int discapacidad;
    private String modelo;
    private Centro Centro;
    private Solicitud sol;
    private Tutor t;
    private Direccion Dir;
    public Nen(){
    };
    public Nen(Calendar fec){
    this.setFecha(fec);
    }
        public Nen(String nNen,String apeUno, String apeDos,int sex,  Calendar fec,int dis, String mod, Centro cent,Tutor tu,Direccion di,String dni){
        this.setNombre(nNen);
        this.setApellidoUno(apeUno);
        this.setApellidoDos(apeDos);
        //no num nen todavía trigger
        this.setSexo(sex);
        this.setFecha(fec);
        this.setDiscapacidad(dis);
        this.setModelo(mod);
        this.setCentro(cent);
        //this.setSol(s); trigger
        this.setT(tu);
        this.setCentro(cent);
        this.setDni(dni);
        }
    public Nen(String nNen,String apeUno, String apeDos,int nuNen,int sex,  Calendar fec,int dis, String mod, Centro cent, Solicitud s,Tutor tu,Direccion di,String dni){
        this.setNombre(nNen);
        this.setApellidoUno(apeUno);
        this.setApellidoDos(apeDos);
        this.setNumNen(nuNen);
        this.setSexo(sex);
        this.setFecha(fec);
        this.setDiscapacidad(dis);
        this.setModelo(mod);
        this.setCentro(cent);
        this.setSol(s);
        this.setT(tu);
        this.setCentro(cent);
        this.setDni(dni);
    }

    public Centro getCentro() {
        return Centro;
    }

    public void setCentro(Centro cent) {
        if(cent!=null){
        this.Centro = cent;
        }
    }

    public Direccion getDir() {
        return Dir;
    }

    public void setDir(Direccion dir) {
        if(dir!=null){
        this.Dir = dir;
        }
    }
    

    public void setNumNen(int nu) {
        if(nu!=0){
        this.numNen = nu;}
    }

    public int getNumNen() {
        return numNen;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sex) {
        
        this.sexo = sexo;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fec) {
        if(fec!=null){
        this.fecha = fec;
        }
    }

    public int getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(int discapacidad) {
        
        this.discapacidad = discapacidad;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String mod) {
        if(mod!=null){
        this.modelo = mod;
        }
        
    }

    public Solicitud getSol() {
        return sol;
    }

    public void setSol(Solicitud s) {
        if(s!=null){
        this.sol = s;
        }
    }

    public Tutor getT() {
        return t;
    }

    public void setT(Tutor tu) {
        if(tu!=null){
        this.t = tu;
        }
    }
}

