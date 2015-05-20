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
 * @author Iñigo
 */
public class SolicitudBD extends Conexion.ConexionOracle{
/**
 * 
 * @param sol Objeto solicitud not full
 * @return Objeto solicitud full
 * 
 */
    public static Solicitud getByMyPk(Solicitud sol) {
        Solicitud s=new Solicitud();
                
        try {
           
            
            setCon();
            plantilla = "call DB.QSOL(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setInt(1, sol.getIdSolicitud());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
        
            if(resultado.next()==true) {
                Sorteo sort=new Sorteo(resultado.getInt(4));
                s=new Solicitud(sol.getIdSolicitud(),resultado.getInt(2),Convertidor.sqlDateToCalendar(resultado.getDate(3)),sort);
            } 
            scon.close();
            desconectar();
            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return s;
    }
}
