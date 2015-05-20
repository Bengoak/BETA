/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Conexion.ConexionOracle;
import static Conexion.ConexionOracle.desconectar;
import static Conexion.ConexionOracle.getCon;
import static Conexion.ConexionOracle.setCon;
import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author 1gprog04
 */
public class ProvinciaBD extends ConexionOracle{
    public static ArrayList<Provincia> cogerProvincias() {
                ArrayList<Provincia> provs=new ArrayList();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QPROVINCIAS()";
            scall = getCon().prepareCall(plantilla);
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            while(resultado.next()==true) {
                Provincia p=new Provincia(resultado.getString(1),resultado.getString(2));
                provs.add(p);
            } 

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return provs;
}

    public static Provincia cogerProvincia(Provincia p) {
       
                Provincia prov=new Provincia();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QPROVINCIA()";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, p.getnProv());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            if(resultado.next()==true) {
                p=new Provincia(resultado.getString(1),resultado.getString(2));
                
            } 

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return prov;
    }
}
