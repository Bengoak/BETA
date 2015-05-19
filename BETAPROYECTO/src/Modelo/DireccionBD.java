/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import static Conexion.ConexionOracle.desconectar;
import static Conexion.ConexionOracle.getCon;
import static Conexion.ConexionOracle.setCon;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Iñigo
 */
public class DireccionBD extends Conexion.ConexionOracle{

    public static Direccion getMeByPK(Direccion dir) {
        Direccion d=new Direccion();
        try{
        setCon();
            plantilla = "call DB.QDIRE(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setInt(1,dir.getIdDireccion());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            
            if(resultado.next()==true) {
                Calle c=new Calle(resultado.getInt(2));
                d =new Direccion(dir.getIdDireccion(),c,resultado.getInt(3),resultado.getString(4),resultado.getString(5),resultado.getString(6),resultado.getString(7));
                                               
                
            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
             System.out.printf(e.getMessage()+"Direccion.getMeByMyPk");
        }
    return d;
    }

    public static Direccion Alta(Direccion dir) {
           
        try{
            setCon();
            plantilla = "call DB.ALTADIR(?,?,?,?,?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setInt(1,dir.getCa().getIdTramo());
            scall.setInt(2,dir.getNu());
            scall.setString(3,dir.getEscalera());
            scall.setString(4, dir.getLetra());
            scall.setString(5,dir.getPiso());
            scall.setString(6, dir.getMano());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            
            if(resultado.next()==true) {
                
                dir.setIdDireccion(resultado.getInt(1));
            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
             System.out.printf(e.getMessage()+"Direccion.alta");
        }
    return dir;
    }
    
}
