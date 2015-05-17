/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import javax.swing.JOptionPane;


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
    
    
    
    
    public static void start (){
        info = new Info();
        info.setVisible(true);        
    }

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
    
    
    public static void estadofase(int i) { 
        
        esfase = i; 
        Info.jmfase.doClick();
                
    }
    
    public static void guardar(/*Object*/) {
        
        participante = new Participante();
        participante.setVisible(true);
        
    }
    
    public static void cerrarparticipante(){
        participante.dispose();
    }
    
    public static void cerrarbusquedaIndividual(){
        busquedaindividual.dispose();
    }

    public static void protecciondatos() {        
        JOptionPane.showMessageDialog(null, "Proteccion de datos.");
    }

    static boolean validardni(String DniTutor) {
        validacion = ValidarDni.ValidarDni(DniTutor);
        return validacion;        
    }
    
    public static void calles(){
        seleccioncalle = new SeleccionCalle(/*Object*/);
        seleccioncalle.setVisible(true);
    }

    static void cerrarseleccioncalle() {
        seleccioncalle.dispose();
    }

    static void centros() {
        seleccioncentro = new SeleccionCentro(/*Object*/);
        seleccioncentro.setVisible(true);
    }

    static void cerrarseleccioncentro() {
        seleccioncentro.dispose();
    }

    static void detalles(/*Object*/) {
        panel = new Detalles(/*Object*/);
        info.add(panel);
        info.pack();
        panel.setVisible(true);
        
    }
    
    
}
