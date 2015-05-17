/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

/**
 *
 * @author newuser
 */
public class FechaNoValida extends Exception{
    private String mensaje;
    
    public FechaNoValida(String mensaje)
    {
        this.mensaje = mensaje;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
}
