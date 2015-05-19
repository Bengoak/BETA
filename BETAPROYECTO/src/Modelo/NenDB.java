/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Iñigo
 */
public class NenDB extends Conexion.ConexionOracle {

    public static ArrayList<Nen> busquedaindividual(Nen n) {
                ArrayList<Nen> nens=new ArrayList();
                
                Centro c;
                Solicitud s;
                Tutor tu;
                Direccion dir;
                
        try {
           
            
            setCon();
            plantilla = "call DB.QNENBYDATE(?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, n.getT().getDni());
            java.sql.Date d = new java.sql.Date(n.getFecha().getTimeInMillis());
            scall.setDate(2,d);
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
           
            while(resultado.next()==true) {
                c=new Centro(resultado.getInt(10));
                s=new Solicitud(resultado.getInt(1));
                tu=new Tutor(resultado.getString(12));
                dir=new Direccion(resultado.getInt(13));
                n = new Nen(resultado.getString(4),
                        resultado.getString(5), 
                        resultado.getString(6),
                        resultado.getInt(2), 
                        resultado.getInt(7),
                        Convertidor.sqlDateToCalendar(resultado.getDate(8)),
                        resultado.getInt(9), 
                        resultado.getString(11), 
                        c, s,tu,dir,
                        resultado.getString(3));
               nens.add(n);
            } 

             scon.close();
            desconectar();
        } catch (Exception e) {
            System.out.printf(e.getMessage()+"NenDB.búsquedaindividual");
        }
    return nens;
    }

    public static ArrayList<Nen> getFriends(Nen n) {
                ArrayList<Nen> nens=new ArrayList();
                
                Centro c;
                Solicitud s;
                Tutor tu;
                Direccion dir;
                
        try {
           
            
            setCon();
            plantilla = "call DB.QFRIENDS(?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setInt(1, n.getSol().getIdSolicitud());
            scall.setInt(2, n.getNumNen());
           
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
          
            while(resultado.next()==true) {
                c=new Centro(resultado.getInt(10));
                s=new Solicitud(resultado.getInt(1));
                tu=new Tutor(resultado.getString(12));
                dir=new Direccion(resultado.getInt(13));
                n = new Nen(resultado.getString(4),
                        resultado.getString(5), 
                        resultado.getString(6),
                        resultado.getInt(2), 
                        resultado.getInt(7),
                        Convertidor.sqlDateToCalendar(resultado.getDate(8)),
                        resultado.getInt(9), 
                        resultado.getString(11), 
                        c, s,tu,dir,
                        resultado.getString(3));
               nens.add(n);
            } 

              scon.close();
            desconectar();
        } catch (Exception e) {
          System.out.printf(e.getMessage()+"NenDB.getFriends");
        }
    return nens;
    }

    public static Nen findMe(Nen n) {
                
        try {
            setCon();
            plantilla = "call DB.QNENBYDNI(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, n.getDni());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
          
            if (resultado.next()==true) {
//el tutor existe
                n = new Nen(resultado.getString(3));
               
            } else{
                n=new Nen();
            }
            scon.close();
            desconectar();
            
        } catch (Exception e) {
            System.out.printf(e.getMessage()+"TutorBD.getByMyPK");
        }
    return n;
    }

    public static Nen Alta(Nen n) {
                  
        try{
            setCon();
            plantilla = "call DB.ALTANEN(?,?,?,?,?,?,?,?,?,?,?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setInt(1,n.getNumNen());
            scall.setString(2,n.getDni());
            scall.setString(3,n.getNombre());
            scall.setString(4,n.getApellidoUno() );
            scall.setString(5,n.getApellidoDos());
            scall.setInt(6,n.getSexo());
            scall.setDate(7,Convertidor.calendarToSqlDate(n.getFecha()));
            scall.setInt(8,n.getDiscapacidad());
            scall.setInt(9,n.getCentro().getIdCentro());
            scall.setString(10,n.getModelo());
            scall.setString(11,n.getT().getDni());
            scall.setInt(12,n.getDir().getIdDireccion());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            
            if(resultado.next()==true) {
                Solicitud s=new Solicitud(resultado.getInt(1));
                n.setSol(s);
            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
             System.out.printf(e.getMessage()+"NenBD.alta");
        }
    return n;
    }
    }
    
    
    
    

