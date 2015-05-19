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
 * @author 1gprog04
 */
public class TutorBD extends Conexion.ConexionOracle {
    
    public static void alta(Tutor t) {
        try {
            setCon();
            plantilla = "insert into tutor(dni,nombre,apellidoUno,apellidoDos) values(?,?,?,?)";
            scon = getCon().prepareStatement(plantilla);

            scon.setString(1, t.getDni());
            scon.setString(2, t.getNombre());
            scon.setString(3, t.getApellidoUno());
            scon.setString(4, t.getApellidoDos());
            scon.executeUpdate();
          
            System.out.println("\ntutor INSERTADO\n");
            scon.close();
            desconectar();
           
        } catch (Exception e) {
            System.out.printf(e.getMessage()+"TutorBD.alta");
    
        }
    }

    public static Tutor getByMyPk(Tutor t) {
        
        try {
           
           
            setCon();
            plantilla = "call DB.QTUTOR(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, t.getDni());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
          
            if (resultado.next()==true) {
            //el tutor existe
                t = new Tutor(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
               
            } else{
                t=new Tutor();
            }
            scon.close();
            desconectar();
           
        } catch (Exception e) {
            System.out.printf(e.getMessage()+"TutorBD.getByMyPK");
    }
      return t;
    }       
}