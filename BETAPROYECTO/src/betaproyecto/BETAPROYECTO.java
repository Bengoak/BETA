/*
 * Proyecto primer curso DAW Egibide
 *@author Martin,Axier e Iñigo
 */
/**
 * Consideraciones previas:
 * 

/** Nomenclatura utilizada:
 * Los objetos denominados full contendrán valor en todos los atributos no nulos de la bd
 * 
 * El objeto niño se denomina nen por posibles problemas con la "ñ"
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
 * 
 * 
 * Mayor especificidad de excepciones lanzadas
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
     * COMPROBACIONES SIMULTÁNEAS A LA CUMPLIMENTACIÓN DEL FORMULARIO 
     */
    
   /**
     * @param dni String 
     * @return Objeto tutor, vacio en el caso de no existir( pk=null) o lleno 
     */
    public static Tutor buscartutor(String dni) {
        
        Tutor t=new Tutor(dni);
        try{
        t=TutorBD.getByMyPk(t);
        }catch(Exception e){
        System.out.print(e.getMessage()+"C.buscartutor" );
        
        }
        return t;
       
    }
     /**
     * MÉTODOS PARA LLENAR LOS COMBOS
     */
    
    /**
     * 
     * @return Provincias de la bd llamando a ProvinciaBD.cogerProvincias
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
      *COMPROBACIÓN DE CORRUPCIONES DE BASE DE DATOS TRAS PULSAR GUARDAR
     */
    
     /**
      *Comprobación duplicación dni niño
     * @param dni String dni
      * @return Objeto nen, vacio en el caso de no existir( pk=null) o lleno 
     */
        public static Nen buscarNen(String dni) {       
        Nen n=new Nen(dni);
        try{
        n=NenDB.findMe(n);
        }catch(Exception e){
        System.out.print(e.getMessage()+"C.buscarNen" );
        }
        return n;
       
    }
       /**
     * @param dniTutor String
     * @param nombretutor String
     * @param primerapellidotutor String
     * @param segundoapellidotutor String
     * @param dninen String
     * @param nombrenen String
     * @param primerapellidonen String
     * @param segundoapellidonen String
     * @param sexo Int (0 o 1)dependiendo de chico o chica     
     * @param fecha Calendar
     * @param idprov String
     * @param nprov String
     * @param nmu String
     * @param cp String
     * @param nLoc String
     * @param ncalle String
     * @param idVia String
     * @param numero Int validado el nº de portal existe en esa correlación de provincia,municipio,cp,localidad,calle 
     * @param letra String
     * @param escalera String
     * @param piso String
     * @param mano String
     * @param telefono1 String
     * @param telefono2 String
     * @param telefono3 String
     * @param telefono4 String
     * @param nCentro String
     * @param modelo String
     * @param discapacidad int 0 no discapacitado 1 sí
     * 
     * Creamos los objetos con los datos provenientes del fromulario. Dichos datos sonen su mayoría
     * las pk de objetos relacionados directa o indirectamente con nen. En algunos casos los datos son claves 
     * semi-únicas a través de la scuales llenamos los objetos tanto con las pk como con los demás atributos. Los métodos 
     * de llenado de dichas clases se denoominar "crear" y se aplican por ejemplo en el caso de localidad. Las claves
     * anteriormente denominadas semi-únicas lo son en compañía de otras claves las cuales se incluyen como argumento 
     * en los métodos "crear". Por ejemplo no existen dos localidades con el mismo nombre la combinación única de provincia,
     * municipio,cp como tampoco existen dos calles en la misma localidad mismo cp y mismo tipo de via (sí que hay en dicha combinación 
     * por ejemplo plaza alava y calle alava pero la inclusión de la vía discrima dicha duplicidad)
     * 
     * Todos los objetos finalmente accesibles desde el objeto central nen, se guardan en un arraylist de nen a la espera de recibir al orden 
     * para volcar en bd. En ese mometo y gracias a un trigger se genera la solicitud pieza clave en la aplicación
     * 
     * 
     * 
     */
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
                            String idprov,
                            String nprov, 
                            String nmu,
                            String cp, 
                            String nLoc,
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
                            String nCentro, 
                            String modelo, 
                            int discapacidad) {
//TUTOR

    Tutor t=new Tutor(dniTutor,nombretutor,primerapellidotutor,segundoapellidotutor);
//DIRECCION
   
    Provincia p=crearProvincia(nprov);
    Municipio m=crearMunicipio(nmu,p);
    Localidad l=crearLocalidad(nLoc,m);
    Via v=crearVia(idVia);
    Calle c=crearCalle(l,cp,v,ncalle);
    Direccion d=new Direccion(c,numero,letra,escalera,piso,mano);
    d.setCa(c);
//tlfns
    ArrayList <Tlfn>ts=crearTlfns(telefono1,telefono2,telefono3,telefono4);
    Centro ce=new Centro(nCentro);
    Nen n=new Nen(nombrenen,primerapellidonen,segundoapellidonen,sexo,fecha,discapacidad,modelo,ce,t,d,dninen);         
    nens.add(n);  
    }
     /**
      * Volcado del ArrayList objetos nen. Dichos objetos nen no cuentan todavía con la pk formada por 
      * el idsolicitud generado a partir de trigger y automaticamente incorporado a él y el numNen que es
      * el orden dentro de los inscritos que coincidirá con su posición en el presente ArrayList. Tampoco
      * cuenta aún con pk en este caso autoincremental y generada asímismo por trigger la dirección la cual
      * tras insertar y por tanto en su versión full se añadira al nen antes de darse se alta.
      * @return nensfull ArrayList de obj nen versión full para poder mostrar cualesquiera datos al terminar la solicitud 
      * incluídos los generados automáticamente por el motor de base de datos
     */
    public static ArrayList<Nen>  finsolicitud() {
        ArrayList<Nen> nensfull=new ArrayList();
        int x=1;
        for(Nen n:nens){
        //Alta de direccion recuperando versión full
        Direccion d=DireccionBD.Alta(n.getDir());
        //Incorporamos la dirección full al objeto nen
        n.setDir(d);
        //Incorporamos el orden de los inscritos por contador de ArrayList
        n.setNumNen(x);
        //Damos de alta nen y lo recuperamos en otro obj nen, nenfull
        Nen nenfull=NenDB.Alta(n);
        Solicitud s=nenfull.getSol();
        //Añadimos al objeto nen n la solicitud 
        n.setSol(s);
        //Guardamos el tutor comprobando previamente si ya estaba con el metodo altatutor de controlador
        altaTutor(n.getT());
           for(Tlfn t:n.getTlfns()){
           //guardamos cada telefono asociado al nen en una repetitiva pasándole al método de alta el obj nen puesto que forma parte de su pk
           TlfnBD.Alta(n,t);
           }
           nensfull.add(n);
           x++;
        }
        nens.clear();
        return nensfull;
    }
    
    /**
     * @param c Calendar fecha de nacimiento dl nen. Previamente se ha validado que su edad está en el rango
     * @param dnitutor String con el dni del tutor introducido, formato validado
     * @return Lista con Objetos Nen full,  ArrayList porque se contempla la posibilidad de que un tutor inscriba a más de un menor 
     * con la misma fecha de nacimiento ej:gemelos
     * Los nens se recuperan en un bucle y se navega por todas sus relaciones para disponer de ellas desde su objeto. Ello
     * se consigue con llamadas consecutivas a métodos pk que partiendo de nen escalan de uno en uno completando
     * los objetos con todos sus atributos
     */
     public static ArrayList<Nen> busquedaindividual(Calendar c,String dnitutor) {
        ArrayList<Nen>nens=new ArrayList();
        
        try{
        //CREAMOS EL NEN SOLO CON LA FECHA 
        Nen n=new Nen(c);
        Tutor t=new Tutor(dnitutor);
        //LE SUMAMOS EL TUTOR SOLO CON DNI
        n.setT(t);
        //CONSEGUIMOS LOS NENS CON TODOS LOS ATRIBUTOS QUE TIENEN EN LA BD
        //MUCHOS ATRIBUTOS PROPIOS OTROS FK FORANEAS
        //ES HORA DE BUSCAR LA PERSISTENCIA DE ESOS OBJETOS RELACIONADOS
        //DIRECTAMENTE O INDIRECTAMENTE CON LOS OBJETOS NEN  
        nens=NenDB.busquedaindividual(n);
        for(Nen ne : nens){
        //RECUPERAMOS SOLICITUD Y A TRAVËS DE ELLA SORTEO Y SE LA AÑADIMOS A CADA NIÑO
        Solicitud s=SolicitudBD.getMeByPk(ne.getSol());
        Sorteo so=SorteoBD.getLast();
        s.setS(so);
        ne.setSol(s);
        //RECUPERAMOS DIRECCIÖN Y A TRAVËS DE ELLA CALLE,LOCALIDAD,MUNICIPIO Y PROVINCIA
        Direccion d=DireccionBD.getMeByPK(ne.getDir());
        Calle ca=CalleBD.getMeByPk(d.getCa());
        Localidad l=LocalidadBD.getMeByPk(ca.getIdloc()); 
        Municipio m=MunicipioBD.getMeByPk(l.getMu());
        Provincia p=ProvinciaBD.getMeByPk(m.getProv());    
        m.setProv(p);
        l.setMu(m);
        ca.setIdloc(l);
        d.setCa(ca);
        ne.setDir(d);
        //RECUPERAMOS TUTOR
        ne.setT(TutorBD.getByMyPk(ne.getT()));
        //RECUPERAMOS CENTRO
        //RECUPERAMOS TLFNS
        ne.setTlfns(TlfnBD.getByNen(ne));
        //RECUPERAMOS COMPAÑEROS
        ne.setAmigos(NenDB.getFriends(ne));
        }
        }catch(Exception e){
        
        System.out.print(e.getMessage()+"Controlador.busquedaindividual" );
        }
        return nens;
        
    }
      /**
     * @param t obj de tipo tutor full
     * Comprobamos si existe el tutor y si no es así se inserta
     */
    private static void altaTutor(Tutor t) {
    //comprobamos de nuevo si esta guardado en bd en el caso de 
    //encontrarlo t2 tendrá toda la info sino estará vacio
    try{
    Tutor t2=TutorBD.getByMyPk(t);
    //si no se encuentra se guarda
    if(t2.getDni()==null){
    TutorBD.alta(t);
    }
    }catch(Exception e){
    System.out.print(e.getMessage()+"C.altatutor");
    }

}
     /**
     * PENDIENTE
     */
    public static void listado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
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
    
    }}