
package MODELO;

import java.util.Date;


public class Solicitud {
    private int idSolicitud;
    private int orden;
    private Date fecha;
    private Sorteo s;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Sorteo getS() {
        return s;
    }

    public void setS(Sorteo s) {
        this.s = s;
    }
    
}
