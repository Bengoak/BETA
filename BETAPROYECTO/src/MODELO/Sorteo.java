
package MODELO;

import java.util.Date;

public class Sorteo {
    private int codSorteo;
    private int nSorteo;
    private int cadencia;
    private Date fecha;

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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
