/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import Exceptions.*;

/**
 * Clase ValidarDni: Contiene la operacion necesaria para validar el DNI.
 * @author Proyecto
 */
public class ValidarDni {
    
    public static void main(String[] args) {       
        
    }
    
    /**
     * Hace la operacion necesaria para validar el DNI, reciviendo el DNI y devolviendo un boolean.
     * @param DniTutor es el DNI del tutor del formulario que se envia para validarlo.
     * @return retorna un boolean, ddependiendo de si el DNI es corecto o no.
     */
    public static boolean ValidarDni(String DniTutor) {
        
        char[] letras = new char[23];
        valoresletras(letras);
        
        
            try
            {
                String dni = DniTutor;
                dni = dni.toUpperCase();

                Pattern cadena = Pattern.compile("^[0-9]{8}[A-Z]{1}$");
                Matcher comprobar = cadena.matcher(dni);

                if(comprobar.matches())
                {
                    String numerostring = dni.substring(0,8);
                    int numeroint = Integer.parseInt(numerostring);
                    int posicionletra = numeroint % 23;
                    char letradni = dni.charAt(8);
                    if(letras[posicionletra] == letradni )
                    {
                        JOptionPane.showMessageDialog(null, "El DNI: " + dni + " es correcto.");
                        return true;
                        
                    }
                    else
                    {
                        throw new DniException();
                        
                    }
                    
                }
                else
                {
                    throw new FormatoException();                    
                }
            } 
            catch(FormatoException e){
               JOptionPane.showMessageDialog(null, "Sintaxis del DNI incorrecta");
               return false;
            }
            catch(DniException e){
               JOptionPane.showMessageDialog(null, "La letra del DNI no es correcta.");
               return false;
            }
            catch(Exception e){
               JOptionPane.showMessageDialog(null, "Problemas "+e.getClass() + " " + e.getMessage());
               return false;
            }
            finally{
                 //JOptionPane.showMessageDialog(null, "Ejercicio terminado");
            }
        
    }
    
    
    /**
     * Contiene el array con las letras para el DNI
     * @param letras recive el array para las letras.
     */
    public static void valoresletras(char[] letras){
        
        letras[0]='T';
        letras[1]='R';
        letras[2]='W';
        letras[3]='A';
        letras[4]='G';
        letras[5]='M';
        letras[6]='Y';
        letras[7]='F';
        letras[8]='P';
        letras[9]='D';
        letras[10]='X';
        letras[11]='B';
        letras[12]='N';
        letras[13]='J';
        letras[14]='Z';
        letras[15]='S';
        letras[16]='Q';
        letras[17]='V';
        letras[18]='H';
        letras[19]='L';
        letras[20]='C';
        letras[21]='K';
        letras[22]='E';
        
    }

    
    
    
}
