/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author 1gprog04
 */

 


public class SorteoBD extends Conexion.ConexionOracle {
    
    
  /**
   * 
   * @param sor objeto sorteo con sólo valor en atributo fecha
   * salta el trigger y adjudica una pk incremental
   * @return 
   */  
    
    
    public static boolean alta(Sorteo sor){
            try{
            setCon();
            plantilla = "insert into sorteo(fecha) values(?)";
            scon = getCon().prepareStatement(plantilla);
            java.sql.Date sqlDate= new java.sql.Date(sor.getFecha().getTimeInMillis());
            scon.setDate(1,sqlDate);   
            scon.execute();
            
            scon.close();
            desconectar();
            System.out.println("\nSorteo INSERTADO\n");
            return true;
            }catch(Exception e){
            System.out.printf(e.getMessage());
            return false;
            }
    }
    /**
     *  
     * @return Último Objeto sorteo de la bd en version full 
     */

    public static Sorteo getLast() {
        Sorteo s=new Sorteo();
    
        try{
        
        setCon();
        plantilla="DB.QSORT";
        scall=getCon().prepareCall(plantilla);
        scall.registerOutParameter(1, OracleTypes.CURSOR);
        scall.execute();
        resultado= (ResultSet) scall.getObject(1);
        scon.close();
        desconectar();
        if(resultado.next()==true){
            s = new Sorteo( resultado.getInt(1),resultado.getInt(2), resultado.getInt(3), Convertidor.sqlDateToCalendar(resultado.getDate(4)));
        }
        }catch(Exception e){
        }
    return s;
    }
/**
     *  
     * ejecuta el procedimiento de sorteo
     */
    public static void executeSorteo() {
        try{       
        setCon();
        plantilla="DB.SORTEO";
        scall=getCon().prepareCall(plantilla);
        scall.execute();
        resultado= (ResultSet) scall.getObject(1);
        scon.close();
        desconectar();
        }catch(Exception e){
        }
    }
}

           
