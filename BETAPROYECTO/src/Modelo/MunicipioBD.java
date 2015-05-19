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
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import Conexion.ConexionOracle;
/**
 *
 * @author 1gprog04
 */
public class MunicipioBD extends ConexionOracle{
    public static ArrayList<Municipio> cogerMunicipios(Provincia p) {
                ArrayList<Municipio> muns=new ArrayList();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QMUNICIPIOS(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, p.getIdProv());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            while(resultado.next()==true) {
                Municipio m=new Municipio(resultado.getString(2),resultado.getString(3),p);
                muns.add(m);
            } 

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return muns;
}

    public static Municipio cogerMunicipio(Municipio m) {
        Municipio mu=new Municipio();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QMUNICIPIO(?,?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, m.getProv().getIdProv());
            scall.setString(2, m.getnMu());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            if(resultado.next()==true) {
                mu=new Municipio(resultado.getString(1),m.getnMu(),m.getProv());
                
            } 

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return mu;
    }
}
