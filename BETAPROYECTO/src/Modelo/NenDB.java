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
            scon.close();
            desconectar();
            while(resultado.next()==true) {
                c=new Centro(resultado.getInt(10));
                s=new Solicitud(resultado.getInt(1));
                tu=new Tutor(resultado.getString(12));
                dir=new Direccion(13);
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

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return nens;
    }
    
    
    
}
