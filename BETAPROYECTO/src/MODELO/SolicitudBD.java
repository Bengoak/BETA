
package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class SolicitudBD extends Conexion.ConexionOracle {
    private static Statement sentencia;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static ResultSet resultado;
    private static Solicitud sol;
    
    public static boolean alta(Sorteo sol){
    
        
        return true;
    }
}