/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Conexion.ConexionOracle;
import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Iñigo
 */
public class ViaBD extends ConexionOracle{

    public static Via cogerVia(Via v) {
           Via vi=new Via();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QVIA(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, v.idVia);
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
           
            if(resultado.next()==true) {
                vi =new Via(resultado.getString(1),resultado.getString(2));
                
            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
            System.out.printf(e.getMessage()+"ViaBD"+"CogerVia");
        }
    return vi;
    }
    
}
