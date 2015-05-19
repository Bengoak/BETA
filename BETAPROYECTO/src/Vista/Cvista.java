/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 * Clase Cvista: Es la clase controladora de las vistas.
 * @author Proyecto
 */
public class Cvista {
    
    private static Info info;
    private static Informacion informacion;
    private static Fase fase;
    private static Formulario formulario;
    private static Detalles detalles;
    private static Listado listado;
    private static Pvirgen panel;
    private static Participante participante;
    private static BusquedaIndividual busquedaindividual;
    private static Boolean validacion;
    private static SeleccionCalle seleccioncalle;
    private static SeleccionCentro seleccioncentro;
    
    
    private static int esfase = 0;
    
    
    
    /**
     * Muestra la Clase Info con el panel de Informacion.
     */
    public static void start (){
        info = new Info();
        info.setVisible(true);       
        panel = new Informacion();
        info.add(panel);
        info.pack();
        panel.setVisible(true);
    }

    /**
     * Se encarga de mostrar el panel que le pasemos con el switch.
     * @param i Recibe el parametro que puede ser un 0, 1, 2, 3, 4 y dependiendo de lo que sea, muestra un panel u otro.
     */
    public static void lanzar(int i) { 
        boolean x = true;
        if(panel != null){
            info.remove(panel);
        }
        
        switch (i){
            case 0:
                panel = new Informacion();
                break;
            case 1:
                panel = new Fase(esfase);
                break;
            case 2:
                panel = new Formulario();
                break;
            case 3:                
                busquedaindividual = new BusquedaIndividual();
                busquedaindividual.setVisible(true);
                x = false;                
                break;
            case 4:
                panel = new Listado();
                break;
            
        } 
        
        if(x){
        info.add(panel);
        info.pack();
        panel.setVisible(true);
        }
    }
    

    /**
     * Recibe un parametro y hace doClick en fase de Info.
     * @param i Recibe un parametro que se guarda en esfase.
     */
    public static void estadofase(int i) { 
        
        esfase = i; 
        Info.jmfase.doClick();
                
    }
    
    /**
     * Muestra la clase participante y le pasa el objeto con los participantes de la solicitud.
     * Falsta el ArrayList del parametro que recibe que contiene los participantes de la solicitud.
     */
    public static void guardar(/*ArrayList*/) {
        
        participante = new Participante(/*ArrayList*/);
        participante.setVisible(true);
        
    }
    
    /**
     * Cierra la clase participante.
     */
    public static void cerrarparticipante(){
        participante.dispose();
    }

    /**
     * Cierra la clase busquedaindividual.
     */
    public static void cerrarbusquedaIndividual(){
        busquedaindividual.dispose();
    }

/**
 * Muestra un mensage con la proteccion de datos.
 */
    public static void protecciondatos() {        
        JOptionPane.showMessageDialog(null, "Proteccion de datos.");
    }

    /**
     * Lama al metodo validardni para comprovar si el Dni es correcto y devuelve un boolean dependiendo de si esta bien o no.
     * @param DniTutor Recibe el DNI del tutor para pasarselo el metodo ValidarDni de la clase ValidarDni.
     * @return Devuelve un boolean dependiendo del DNI.
     */
    static boolean validardni(String DniTutor) {
        validacion = ValidarDni.ValidarDni(DniTutor);
        return validacion;        
    }
    
    /**
     * Muestra la clase seleccionarcalle y le pasa u ArrayList con las calles.
     * Falsta el ArrayList que recibe las calles, para pasarselo a la clase seleccionarcalle.
     */
    public static void calles(/*ArrayList*/){
        seleccioncalle = new SeleccionCalle(/*ArrayList*/);
        seleccioncalle.setVisible(true);
    }

    /**
     * Cierra la clase seleccionarcalle.
     */
    static void cerrarseleccioncalle() {
        seleccioncalle.dispose();
    }


    /**
     * Muestra la clase seleccionarcentro y le pasa u ArrayList con los centros.
     * Falsta el ArrayList que recibe con los centros, para pasarselo a la clase seleccionarcentro.
     */
    static void centros(/*ArrayList*/) {
        seleccioncentro = new SeleccionCentro(/*ArrayList*/);
        seleccioncentro.setVisible(true);
    }

    /**
     * Cierra la clase seleccionarcentro.
     */
    static void cerrarseleccioncentro() {
        seleccioncentro.dispose();
    }

    /**
     * Muestra el panel detalles y recibe un Objeto que pasa al al panel detalles.
     * Falta el ArrayList que recive con los detalles a mostrar en el panel detalles.
     */
    static void detalles(/*ArrayList*/) {
        panel = new Detalles(/*ArriList*/);
        info.add(panel);
        info.pack();
        panel.setVisible(true);
        
    }
    
    
}
