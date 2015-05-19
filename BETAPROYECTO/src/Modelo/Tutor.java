/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author 1gprog04
 */
public class Tutor extends Persona{

    public Tutor(String dni, String nombre, String apellidoUno, String apellidoDos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
}
    public Tutor(){
    }
       public Tutor(String Dni){
           this.dni=Dni;
           
    }

}
