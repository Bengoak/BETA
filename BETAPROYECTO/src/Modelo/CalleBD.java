/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Conexion.ConexionOracle;
import java.util.ArrayList;
import java.sql.ResultSet;
import BETAPROYECTO.*;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Iñigo
 */
public class CalleBD extends ConexionOracle {

    public static Calle buscarCalle(Calle c) {
                
        try {
           
            
            setCon();
            plantilla = "call DB.QCALLE(?,?,?,?,?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, c.getIdloc().getMu().getProv().getIdProv());
            scall.setString(2,c.getIdloc().getMu().getIdMu());
            scall.setString(3,c.getIdloc().getIdLoc());
            scall.setString(4,c.getCp());
            scall.setString(5,c.getVia().getIdVia());
            scall.setString(6,c.getnCalle());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
          
            if(resultado.next()==true) {
                c.setIdTramo(resultado.getInt(1));
                c.setnMinPar(resultado.getInt(9));
                c.setnMaxPar(resultado.getInt(10));
                c.setnMinImpar(resultado.getInt(11));
                c.setnMaxImpar(resultado.getInt(12));

            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
            System.out.printf(e.getMessage()+"CalleBD.buscarcalle");
        }
    return c;
    }
    /**
     * 
     * @param l Objeto Localidad
     * @param cp String con codigo postal
     * @return Lista de calles full
     */
    public static ArrayList<Calle> cogerCalles(Localidad l,String cp){
                  ArrayList<Calle> calles=new ArrayList();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QCALLES(?,?,?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, l.getMu().getProv().getIdProv());
            scall.setString(2, l.getMu().getIdMu());
            scall.setString(3, l.getIdLoc());
            scall.setString(4, cp);
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            if(resultado.next()==true) {
                
                Via v=new BETAPROYECTO.crearVia(resultado.getString(8));
                Calle c=new Calle(resultado.getInt(1),l,cp,resultado.getString(5),resultado.getString(7),v,resultado.getInt(9),resultado.getInt(10),resultado.getInt(11),resultado.getInt(12));   
                calles.add(c);
            } 
              scon.close();
            desconectar();
            
        } catch (Exception e) {
                System.out.printf(e.getMessage()+"CalleBD.buscarcalle");
        }
    return calles;
    }
    /**
     * 
     * @param calle con único atributo de idtramo(pk)
     * @return calle full
     */
    public static Calle getMeByPk(Calle calle){
            Calle c=new Calle();
        try{
        setCon();
            plantilla = "call DB.QCALLEBYPK(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setInt(1,calle.getIdTramo());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            
            if(resultado.next()==true) {
                Localidad l=new Localidad(resultado.getString(4));
                Via v=new Via(resultado.getString(8));
                c =new Calle(calle.idTramo,l,resultado.getString(6),resultado.getString(5),resultado.getString(7),v,resultado.getInt(9),resultado.getInt(10),resultado.getInt(11),resultado.getInt(12));
            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
              System.out.printf(e.getMessage()+"CalleBD.buscarcalle");
        }
    return c;
    
    
    }
    
}

  