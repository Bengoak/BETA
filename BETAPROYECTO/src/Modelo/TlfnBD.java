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

/**
 *
 * @author Iñigo
 */
public class TlfnBD extends Conexion.ConexionOracle{
        public static ArrayList<Tlfn> getByNen(Nen n) {
        ArrayList<Tlfn>tlfns=new ArrayList();
    
        try{
        
        setCon();
        plantilla="DB.QTLFNGETBYNEN(?,?)";
        scall=getCon().prepareCall(plantilla);
        scall.setInt(1,n.getSol().getIdSolicitud());
        scall.setInt(2,n.getNumNen());
        scall.registerOutParameter(1, OracleTypes.CURSOR);
        scall.execute();
        resultado= (ResultSet) scall.getObject(1);
       
        while(resultado.next()==true){
            Tlfn t= new Tlfn( resultado.getString(3));
            tlfns.add(t);
        }
         scon.close();
        desconectar();
        }catch(Exception e){
            System.out.print(e.getMessage()+"TlfnBD.getByNen");
        }
    return tlfns;
    }

    public static void Alta(Nen n, Tlfn t) {
            try{
            setCon();
            plantilla = "insert into Tlfn (idSolicitud,idNen,num) values(?,?,?)";
            scon = getCon().prepareStatement(plantilla);
            
            scon.setInt(1,n.getSol().getIdSolicitud());   
            scon.setInt(2,n.getNumNen());  
            scon.setString(3,t.getNum());  
            scon.execute();
            
            scon.close();
            desconectar();
            System.out.println("\nTlfn INSERTADO\n");
            
            }catch(Exception e){
            System.out.printf(e.getMessage()+"TlfnBD.Alta");
      
            }
    }
}
