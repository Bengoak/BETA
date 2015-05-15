/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


/**
 *
 * @author 1gprog04
 */

 


public class SorteoBD extends Conexion.ConexionOracle {
    
    
    
    private static Sorteo sor;
    
    public static boolean alta(Sorteo sor){
            try{
            setCon();
            plantilla = "insert into sorteo(fecha) values(?)";
            scon = getCon().prepareStatement(plantilla);
            java.sql.Date sqlDate= new java.sql.Date(sor.getFecha().getTimeInMillis());
            scon.setDate(1,sqlDate);   
            scon.executeUpdate();
            scon.close();
            desconectar();
            System.out.println("\nSorteo INSERTADO\n");
            return true;
            }catch(Exception e){
            System.out.printf(e.getMessage());
            return false;
            }
    }
}
