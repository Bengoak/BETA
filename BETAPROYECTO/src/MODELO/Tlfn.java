
package MODELO;

public class Tlfn {
    private String num;
    private Nen n;
     //PK idSolicitud, idNen

    public Tlfn(String num, Nen n) {
        this.num = num;
        this.n = n;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Nen getN() {
        return n;
    }

    public void setN(Nen n) {
        this.n = n;
    }
}
