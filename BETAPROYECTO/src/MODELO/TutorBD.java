
package MODELO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TutorBD extends Conexion.ConexionOracle{
    private static Statement sentencia;
    private static PreparedStatement sentenciaCon;
    private static String plantilla;
    private static ResultSet resultado;
    private static Tutor t;
    
    public static boolean alta(Tutor t)
    {
        try{
            setCon();
            plantilla = "insert into TUTOR values(?,?,?,?)";
            sentenciaCon = getCon().prepareStatement(plantilla);
            sentenciaCon.setString(1,t.getDni());
            sentenciaCon.setString(2,t.getNombre());
            sentenciaCon.setString(2,t.getApellidoUno());
            sentenciaCon.setString(2,t.getApellidoDos());
            sentenciaCon.executeUpdate();
            sentenciaCon.close();
            desconectar();
            System.out.println("\nTUTOR INSERTADO\n");
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
