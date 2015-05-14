
package Conexion;

import oracle.jdbc.OracleTypes;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexionOracle {
    
    private static String url ="jdbc:oracle:thin:@server224:1521:orcl";
    private static String usuario ="daw12";
    private static String Contraseña ="daw12";
    private static Connection con = null;
    
    public static void setCon () {
        
        try{
            DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
            con = DriverManager.getConnection(url,usuario,Contraseña);
                                               // driver@machineName:port:SID ,  userid,  password
          
            System.out.println("Base de datos abierta");

        }catch(Exception e){
        System.out.println("Problemas con la conexión");
        }
    }
    public static Connection getCon () {
        return con;
    }
    
    
    public static void desconectar () {
        
        try{
            con.close();  
        }catch(Exception e){
        System.out.println("no se puede desconectar");
        }
    }
    public static void Consulta () {
        
        try{
            setCon();
            Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select nprov from provincias");
            while (rset.next()){
                 System.out.println (rset.getString(1)); 
            }
            stmt.close();
            System.out.println("\nCONSULTA CREADA\n");
            desconectar();
            
        }catch(Exception e){
        System.out.println("Problemas con la conexión");
        }
    }
}
