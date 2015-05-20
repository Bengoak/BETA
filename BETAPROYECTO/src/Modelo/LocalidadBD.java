/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import Conexion.ConexionOracle;

import java.sql.ResultSet;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author 1gprog04
 */
public class LocalidadBD extends ConexionOracle{
    public static ArrayList<Localidad> cogerLocalidades(Municipio m) {
                ArrayList<Localidad> locs=new ArrayList();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QLOCALIDADES(?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, m.getProv().getIdProv());
            scall.setString(2, m.getIdMu());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            while(resultado.next()==true) {
                Localidad l=new Localidad(resultado.getString(3),resultado.getString(4),m);
                locs.add(l);
            } 

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return locs;
}
    public static Localidad cogerLocalidad(Localidad l) {
              Localidad lo=new Localidad();  
                
        try {
           
            
            setCon();
            plantilla = "call DB.QLOCALIDAD(?,?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, l.getMu().getProv().getIdProv());
            scall.setString(2, l.getMu().getIdMu());
            scall.setString(3, l.getnLoc());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            if(resultado.next()==true) {
                lo=new Localidad(resultado.getString(3),l.getnLoc(),l.getMu());   
            } 

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return lo;
    }

}
