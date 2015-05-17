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
    private static Tutor t2;
    public static boolean alta(Tutor t) {
        try {
            setCon();
            plantilla = "insert into tutor(dni) values(?)";
            scon = getCon().prepareStatement(plantilla);

            scon.setString(1, t.getDni());
            scon.executeUpdate();
            scon.close();
            desconectar();
            System.out.println("\nSorteo INSERTADO\n");
            return true;
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            return false;
        }
    }

    public static Tutor buscar(Tutor t) {
        
        try {
           
            
            setCon();
            plantilla = "call DB.QTUTOR(?)";
            scall = getCon().prepareCall(plantilla);
            scall.setString(1, t.getDni());
            scall.registerOutParameter(1, OracleTypes.CURSOR);
            scall.execute();
            resultado= (ResultSet) scall.getObject(1);
            scon.close();
            desconectar();
            if (resultado.next()==true) {
//el tutor existe
                t2 = new Tutor(resultado.getString(1), resultado.getString(2), resultado.getString(3), resultado.getString(4));
               
            } else{
                t2=new Tutor();
            }

            
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    return t2;
    }}
        /*   try {
              
            
        
         Conexion.setCon();
         System.out.println("Consultando");
         Plantilla = confPlantilla( i);
         SPreparada = Conexion.getCon().prepareStatement(Plantilla);
         if (i == 1) {
         SPreparada.setString(1, a.getNombre());

         } else if (i == 2) {
         SPreparada.setString(1, a.getLugar());

         } else {
         SPreparada.setDate(1, calendarToSqlDate(a.getFecha()));
         }
            
         Resultado = SPreparada.executeQuery();
         acons = new ArrayList();
         while (Resultado.next()) {

         acon = new Acon(
                        
         Resultado.getInt(1),
         Resultado.getString(2),
         Resultado.getString(3),
         sqlDateToCalendar(Resultado.getDate(4)),
         sqlTimeToCalendar(Resultado.getTime(5)),
         sqlTimeToCalendar(Resultado.getTime(6)),
         Resultado.getInt(7)
         );
         acons.add(acon);
              
         }
         System.out.println("Consulta realizada");
         System.out.print(acons.size());
         SPreparada.close();
         Conexion.desconectar();
    
         } catch (Exception e) {
         System.out.println(e.getMessage() + "consultar"+a.getNombre());

         }
     
         return acons;
         }
         }
         }
*/


















                                   
