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
import java.util.Calendar;
public class Sorteo {
    
    private int codSorteo;
    private int nSorteo;
    private int cadencia;
    private Calendar fecha;
    public Sorteo(){
    }
    public Sorteo(Calendar f){
    this.fecha=f;
    }
    public int getCodSorteo() {
        return codSorteo;
    }

    public int getnSorteo() {
        return nSorteo;
    }

    public void setnSorteo(int nSorteo) {
        this.nSorteo = nSorteo;
    }

    public int getCadencia() {
        return cadencia;
    }

    public void setCadencia(int cadencia) {
        this.cadencia = cadencia;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar f) {
        this.fecha = fecha;
    }
}
