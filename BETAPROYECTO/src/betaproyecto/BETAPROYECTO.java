/*
 * Proyecto primer curso DAW Egibide
 *@author Martin,Axier e Iñigo
 */
/**
 * Consideraciones previas:
 * 

/** Nomenclatura utilizada:
 * Los objetos denominados full contendrán valor en todos los atributos no nulos de la bd
 */ 

/** Navegabilidad:
 * La navegabilidad se ha minimizado en lo posible de tal forma que por ejemplo no hay necesidad de contemplar a
 * los municipios en los objetos provincia, sí en cambio al revés.
 */ 

/** Variables:
 * Se ha minimizado el uso de variables globales para encapsular lo más posible la informaición y evitar su corrupción. El uso de variables globales
 * especialmente en el controlador hubiese supuesto una mayor agilidad pero en este caso hemos decidido primar la seguridad por la información 
 * confidencial que la bd alberga
 * 
 */ 

/** Dirección:
 * 
 * El tramo de calle es único, no así el nombre de la calle. Y es que existen calles y sobre todo carreteras 
     * que discurren por múltiples municipios,localidades, poseen diferentes codigos postales y los números de portales 
     * varían siendo normalmente repetidos pero ocasionalmente complementarios. 
     * Ejemplos pruebas realizables != codigo postal para misma calle  
     *                                   Prov: Araba Municipio: Vitoria-Gasteiz Localidad: Vitoria-Gasteiz 01008 Beato Tomas de zumarraga 
     *                                   Prov: Araba Municipio: Vitoria-Gasteiz Localidad: Vitoria-Gasteiz 01009 Beato Tomas de zumarraga 
     *                              !=localidad para misma calle y cp
     *                                    Prov: Araba Municipio: Zigoitia Localidad: Gopegi 01138 Berrikazubi 
     *                                    Prov: Araba Municipio: Zigoitia Localidad: Ondategi 01138 Berrikazubi 
     *                              !=localidad y !=cp para misma calle
     *                                    Prov: Bizkaia Municipio: Getxo Localidad: Algorta    Los chopos 48991
     *                                    Prov: Bizkaia Municipio: Getxo Localidad: Algorta    Los chopos 48992
     *                                    Prov: Bizkaia Municipio: Getxo Localidad: Andra Mari Los chopos 48990
     *                                    Prov: Bizkaia Municipio: Getxo Localidad: Andra Mari Los chopos 48992
     * 
 */

/**Mejoras sugeridas y no acometidas por falta de tiempo:
 * 
 * Acometer una modificación de la bd para que las claves compuestas sean totalmente incrementales y se 
 * pueda acometer búsquedas con las pks. Recibiendo el index y el valor del combo obtendríamos la totalidad 
 * de la pk compuesta y de esta forma algunos de los métodos crear... no serían necesarios. En cualquier caso las 
 * búsquedas se realizan a través de valores únicos por lo que el funcionamiento del programa no se ve perjudicado. Hemos 
 * priorizado tener una base de datos completa pese a que ello nos obligue a codificar de más y a aumentar las interacciones con la bd;
 */
package betaproyecto;

import Vista.*;
import Modelo.*;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ButtonModel;
import Conexion.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
public class BETAPROYECTO {

    
    
    private static ArrayList<Nen>nens;
    public static void main(String[] args) {
       System.out.print("Prueba conexion");
        ConexionOracle.setCon();
        ConexionOracle.desconectar();
        Calendar c = Calendar.getInstance();
        System.out.print(c);
        Sorteo s= new Sorteo(c);
        SorteoBD.alta(s);
        Cvista.start(); 
    }


    
    /**
     * 
     * @return Provincias de la bd
     */
    public static ArrayList<Provincia> cogerProvincias() {
        return ProvinciaBD.cogerProvincias();
    }
    /**
     * @param nProv String con el nombre de la provincia.
     * @return Municipios de la bd que pertenezcan a la provincia 
     */
    public static ArrayList<Municipio> cogerMunicipios(String nProv) {
        Provincia p=crearProvincia(nProv);
        return MunicipioBD.cogerMunicipios(p);
    }
    /**
     * @param nProv String con el nombre de la provincia.
     * @param nMu String con el nombre de la provincia.
     * @return Localidades de la bd que pertenezcan al municipio
     */
    public static ArrayList<Localidad> cogerLocalidades(String nProv,String nMu) {
       Provincia p=crearProvincia(nProv);
       Municipio m=crearMunicipio(nMu,p);
       return LocalidadBD.cogerLocalidades(m);
    }
    /**
     * @param nProv String con el nombre de la provincia.
     * 
     * @param nMu String con el nombre de la provincia.
     * @param nLoc String con el nombre de localidad
     * @param cp String con el codigo postal
     * @return Calles de la bd que pertenezcan a la localidad y al cp
     */
    public static ArrayList<Calle> cogerCalles(String nProv,String nMu,String nLoc,String cp) {
       Provincia p=crearProvincia(nProv);
       Municipio m=crearMunicipio(nMu,p);
       Localidad l=crearLocalidad(nLoc,m);//el valor idLoc en la bd no es totalmente puro x lo k no puedo utilizar el index para crear obj loc
       return CalleBD.cogerCalles(l,cp);
    }
     /**
     * @param nProv String con el nombre de la provincia.
     * @param nMu String con el nombre de la provincia.
     * @param nLoc String con el nombre de localidad
     * @param cp String con el codigo postal
     * @param idVia String con la abreviatura del tipo de via
     * @param ncalle String con el nombre de calle
     * @return numeros de "portales" existentes del tramo de calle
     * obtenidos a través de dos bucles for consecutivos 
     * y ordenados con el  método sort de la clase java.util.Collections.
     
     */
    public static ArrayList<Integer> cogernumeros(String nProv,String nMu,String nLoc,String cp,String idVia,String ncalle) {
        Provincia p=crearProvincia(nProv);
        Municipio m=crearMunicipio(nMu,p);
        Localidad l=crearLocalidad(nLoc,m);
        Via v=crearVia(idVia);
        Calle c=crearCalle(l,cp,v,ncalle);
        ArrayList<Integer>numeros=new ArrayList();
        int x;
        for(x=c.getnMinPar();x<=c.getnMaxPar();x=x+2){
        numeros.add(x);
        }
        for(x=c.getnMinImpar();x<=c.getnMaxImpar();x=x+2){
        numeros.add(x);
        }
        Collections.sort(numeros);
        return numeros;
    }
      
 /**
     * @param l Objeto localidad full
     * @param cp String con codigo postal.
     * @param v Objeto via full
     * @param ncalle String con nombre de calle.
     * @return calle full
     */
    private static Calle crearCalle(Localidad l, String cp, Via v, String ncalle) {
       Calle c=new Calle(l,cp,v,ncalle);
       return CalleBD.buscarCalle(c);
    }
    /**
     * @param t1 String con telefono uno lleno o vacio
     * @param t2 String con telefono dos lleno o vacio
     * @param t3 String con telefono tres lleno o vacio
     * @param t4 String con telefono cuatro lleno o vacio
     * @return lista de telefonos con valor
     */
    private static ArrayList<Tlfn> crearTlfns(String t1,String t2, String t3, String t4) {
        ArrayList <Tlfn>ts=new ArrayList();
        if(t1.compareToIgnoreCase("")!=0){
        Tlfn t=new Tlfn(t1);
        ts.add(t);
        }
        if(t2.compareToIgnoreCase("")!=0){
        Tlfn t=new Tlfn(t2);
        ts.add(t);
        }
        if(t3.compareToIgnoreCase("")!=0){
        Tlfn t=new Tlfn(t3);
        ts.add(t);
        }
        if(t4.compareToIgnoreCase("")!=0){
        Tlfn t=new Tlfn(t4);
        ts.add(t);
        }
      return ts;
    }
    /**
     * @param nProv String con el nombre de la provincia
     * @return Objeto provincia full
     */
    private static Provincia crearProvincia(String nprov) {
        Provincia p=new Provincia(nprov);
        return ProvinciaBD.cogerProvincia(p);
    }
     /**
     * @param nmu String con el nombre del municipio
     * @param p Objeto Provincia full
     * @return Objeto municipio full
     */
    
    private static Municipio crearMunicipio(String nmu, Provincia p) {
        Municipio m=new Municipio(nmu,p);
        return MunicipioBD.cogerMunicipio(m);
    }
     /**
     * @param nloc String con el nombre de localidad
     * @param m Objeto Municipio full
     * @return Objeto Localidad full
     */
    private static Localidad crearLocalidad(String nLoc, Municipio m) {
        Localidad l=new Localidad(nLoc,m);
        return LocalidadBD.cogerLocalidad(l);
    }
    /**
     * @param idVia String la abreviatura del tipo de calle
     * @return Objeto Via full
     */
    private static Via crearVia(String idVia){
    Via v=new Via(idVia);
    return ViaBD.cogerVia(v);
    
    }
    
    public static ArrayList<Centro> cogercentros() {
        ArrayList<Centro>centros=new ArrayList();
        return centros;
    }
    public static ArrayList<Centro> cogercentroprovincia(String nprov) {
          ArrayList<Centro>centros=new ArrayList();
        return centros;
    }
    public static ArrayList<Centro> cogercentroprovincias(String nprov) {
          ArrayList<Centro>centros=new ArrayList();
        return centros;
    }
    /**
     * @param c Calendar fecha de nacimiento dl nen. Previamente se ha validado que su edad está en el rango
     * @param dnitutor String con el dni del tutor introducido, formato validado
     * @return Lista con Objetos Nen full, lista porque se contempla la posibilidad de que un tutor inscriba a más de un menor 
     * con la misma fecha de nacimiento ej:gemelos
     */
     public static ArrayList<Nen> busquedaindividual(Calendar c,String dnitutor) {
        ArrayList<Nen>nens=new ArrayList();
        Nen n=new Nen(c);
        Tutor t=new Tutor(dnitutor);
        n.setT(t);
        nens=NenDB.busquedaindividual(n);
        for(Nen ne : nens){
        Solicitud s=SolicitudBD.getByMyPk(ne.getSol());
        Sorteo so=SorteoBD.getLast();
        s.setS(so);
        Direccion d=DireccionBD.getByMyPK(ne.getDir());
        ne.setDir(d);
        Calle ca=CalleBD.getByMyPk(ne.getDir().getCa());
        d.setCa(ca);
        //Localidad l=LocalidadBD.getByMyPk(ne.getDir())
        ne.setT(TutorBD.getByMyPk(ne.getT()));
        //ne.setCentro();
        }
        
        return nens;
        
    }
     
    private static Tutor crearTutor(String dniTutor, String nombretutor, String primerapellidotutor, String segundoapellidotutor) {
    Tutor t=new Tutor(dniTutor,nombretutor,primerapellidotutor,segundoapellidotutor);
    //comprobamos de nuevo si esta guardado en bd en el caso de 
    //encontrarlo t2 tendrá toda la info sino estará vacio
    Tutor t2=TutorBD.getByMyPk(t);
    //si no se encuentra se guarda
    if(t2.getDni()==null){
    TutorBD.alta(t);
    }
    return t; 

}
    public static Tutor buscartutor(String dni) {
        Tutor t=new Tutor(dni);
        t=TutorBD.getByMyPk(t);
        System.out.print("");
        return t;
       
    }
    public static void finsolicitud() {
        ///volcamos el array de crios
        //borramos el array
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
    }
    
    public static void listado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
public static void guardar( String dniTutor, 
                            String nombretutor, 
                            String primerapellidotutor, 
                            String segundoapellidotutor, 
                            
                            String dninen, 
                            String nombrenen, 
                            String primerapellidonen, 
                            String segundoapellidonen, 
                            int sexo,
                            Calendar fecha,
                            
          //QUIERO STRING E INDEX de pro y mu y loc ...en formato String String.valueof(int)
                            String idprov,
                            String nprov, 
                            String idmu,
                            String nmu,
                            
                            String cp, 
                            String idLoc,
                            String nLoc,
           //QUIERO NOMBRE DE CALLE Y DE VIA MISMO STRING PERO SUBSTRING PARTIDO
                            String ncalle, 
                            String idVia,
                            int numero, 
                            String letra, 
                            String escalera,
                            String piso, 
                            String mano, 
                            
                            String telefono1,
                            String telefono2, 
                            String telefono3, 
                            String telefono4, 
                            int  idCentro, 
                            String nCentro, 
                            
                            String modelo, 
                            int discapacidad) {
//TUTOR
    //hombres 0 y mujeres 1
    //no deisc 0 sí 1
    //Creamos el tutor
   
     Tutor t=new Tutor(dniTutor,nombretutor,primerapellidotutor,segundoapellidotutor);
//DIRECCION
   
    Provincia p=crearProvincia(nprov);
    Municipio m=crearMunicipio(nmu,p);
    Localidad l=crearLocalidad(nLoc,m);
    Via v=crearVia(idVia);
    Calle c=crearCalle(l,cp,v,ncalle);//en la bd las calles no tienen codigo incremental puro así que las buscamos x nombre en vez de id
    Direccion d=new Direccion(c,numero,letra,escalera,piso,mano);
    ArrayList <Tlfn>ts=crearTlfns(telefono1,telefono2,telefono3,telefono4);
    Centro ce=new Centro(idCentro, nCentro);
    Nen n=new Nen(nombrenen,primerapellidonen,segundoapellidonen,sexo,fecha,discapacidad,modelo,ce,t,d,dninen);
// public Nen(String nNen,String apeUno, String apeDos,int sex,  Calendar fec,int dis, String mod, Centro cent,Tutor tu,Direccion di,String dni){            
    nens.add(n);  
    }
    
}
