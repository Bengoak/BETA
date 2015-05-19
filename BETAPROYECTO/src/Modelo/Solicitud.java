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
public class Solicitud {
    private int idSolicitud;
    private int orden;
    private Calendar fecha;
    private Sorteo s;
    
    public Solicitud(int idSolicitud, int orden, Calendar fecha, Sorteo s) {
        this.idSolicitud = idSolicitud;
        this.orden = orden;
        this.fecha = fecha;
        this.s = s;
    }
  
    
    public Solicitud() {
    }
    

    public Solicitud(int id){
    this.idSolicitud=id;
    
    }
    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Sorteo getS() {
        return s;
    }

    public void setS(Sorteo s) {
        this.s = s;
    }
}
