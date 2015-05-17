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
public  class Persona {
    protected String dni;
    protected String nombre;
    protected String apellidoUno;
    protected String apellidoDos;
    
    public String getDni() {
        return dni;
    }

    public void setDni(String d) {
        if(d!=null){
        this.dni = d;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        if(nom!=null){
        this.nombre = nom;
        }
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apeUno) {
        if(apeUno!=null){
        this.apellidoUno = apeUno;
        }
    }

    public String getApellidoDos() {
        
        return apellidoDos;
    }

    public void setApellidoDos(String apeDos) {
        if(apeDos!=null){
        this.apellidoDos = apeDos;
        }
    }
}
