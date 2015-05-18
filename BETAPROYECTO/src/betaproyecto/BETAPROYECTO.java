/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package betaproyecto;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonModel;
import Conexion.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class BETAPROYECTO {

    
    
    
    public static void main(String[] args) {
        System.out.print("Prueba conexion");
        ConexionOracle.setCon();
        ConexionOracle.desconectar();
        Calendar c = Calendar.getInstance();
        System.out.print(c);
        Sorteo s= new Sorteo(c);
        SorteoBD.alta(s);
        Cvista.start();
        
    }

    public static void listado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
public static void guardar( String dniTutor, 
                            String nombretutor, 
                            String primerapellidotutor, 
                            String segundoapellidotutor, 
                            
                            String dninen, 
                            String nombrenen, 
                            String primerapellidonen, 
                            String segundoapellidonen, 
                            int sexo,
                            Calendar fecha,
                            int provincia,
                            int municipio,
                            
                            String cp, 
                            int localidad,
                            String calle, 
                            int numero, 
                            String letra, 
                            String escalera,
                            String piso, 
                            String mano, 
                            
                            String telefono1,
                            String telefono2, 
                            String telefono3, 
                            String telefono4, 
                            
                            String centro, 
                            
                            String modelo, 
                            int discapacidad) {
        
    }
    
    public static Tutor buscartutor(String dni) {
        Tutor t=new Tutor(dni);
        t=TutorBD.buscar(t);
        System.out.print("");
        return t;
       
    }

    public static void finsolicitud() {
        ///volcamos el array de crios
        //borramos el array
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
    }

    public static void cogerprovincia() {
        
    }

    public static void cogermunicipio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void cogerlocalidad() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void cogercalle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void cogercentro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void centroalava() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void centrofueraalava() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void cogernumeros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static ArrayList<Nen> busquedaindividual(Calendar c,String dnitutor) {
        Nen n=new Nen(c);
        Tutor t=new Tutor(dnitutor);
        n.setT(t);
        return NenDB.busquedaindividual(n);
        
    }

    public static void cojercalle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
}
/*
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
    
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Date;


public class SorteoBD extends Conexion.ConexionOracle {
    private static Statement sentencia;
    private static String plantilla;
    private static ResultSet resultado;
    private static Sorteo sor;
    
    public static boolean alta(Sorteo sor){
            try{
            setCon();
            plantilla = "insert into sorteo values(?)";
            scon = getCon().prepareStatement(plantilla);
            java.sql.Date sqlDate= new java.sql.Date(sor.getFecha().getTimeInMillis());
            scon.setDate(1,sqlDate);   
            scon.executeUpdate();
            scon.close();
            desconectar();
            System.out.println("\nSorteo INSERTADO\n");
            return true;
            }catch(Exception e){
            System.out.printf(e.getMessage());
            return false;
            }
        
    }
}

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

package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class TlfnBD extends Conexion.ConexionOracle{
    private static Statement sentencia;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static ResultSet resultado;
    private static Tlfn tel;
}
package MODELO;


public class Tutor {
    private String dni;
    private String nombre;
    private String apellidoUno;
    private String apellidoDos;

    public Tutor(String dni, String nombre, String apellidoUno, String apellidoDos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidoUno = apellidoUno;
        this.apellidoDos = apellidoDos;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoUno() {
        return apellidoUno;
    }

    public void setApellidoUno(String apellidoUno) {
        this.apellidoUno = apellidoUno;
    }

    public String getApellidoDos() {
        return apellidoDos;
    }

    public void setApellidoDos(String apellidoDos) {
        this.apellidoDos = apellidoDos;
    }
}
package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TutorBD extends Conexion.ConexionOracle{
    private static Statement sentencia;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static ResultSet resultado;
    private static Tutor t;
    
    public static boolean alta(Tutor t)
    {
        try{
            setCon();
            plantilla = "insert into TUTOR values(?,?,?,?)";
            sentenciaCon = getCon().prepareStatement(plantilla);
            sentenciaCon.setString(1,t.getDni());
            sentenciaCon.setString(2,t.getNombre());
            sentenciaCon.setString(2,t.getApellidoUno());
            sentenciaCon.setString(2,t.getApellidoDos());
            sentenciaCon.executeUpdate();
            sentenciaCon.close();
            desconectar();
            System.out.println("\nTUTOR INSERTADO\n");
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
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

package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class SolicitudBD extends Conexion.ConexionOracle {
    private static Statement sentencia;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static ResultSet resultado;
    private static Solicitud sol;
    
    public static boolean alta(Sorteo sol){
    
        
        return true;
    }
}

package MODELO;

import java.util.Date;


public class Nen {
    private int numNen;
    private String dni;
    private String apellidoUno;
    private String apellidoDos;
    private int sexo;
    private Date fecha;
    private int discapacidad;
    private String modelo;
    //private Centro idCentro;
    private Solicitud sol;
    private Tutor t;
    //private Direccion idDir;
}
}*/