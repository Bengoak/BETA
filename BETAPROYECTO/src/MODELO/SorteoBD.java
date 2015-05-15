
package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class SorteoBD extends Conexion.ConexionOracle {
    private static Statement sentencia;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static ResultSet resultado;
    private static Sorteo sor;
    
    public static boolean alta(Sorteo sor){
    
        
        return true;
    }
}
