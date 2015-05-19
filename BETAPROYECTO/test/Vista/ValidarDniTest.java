
package Vista;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidarDniTest {
    
    public ValidarDniTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class ValidarDni.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        ValidarDni.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of ValidarDni method, of class ValidarDni. Prueba DNI valido
     */
    @Test
    public void testValidarDni() {
        System.out.println("ValidarDni");
        String DniTutor = "44347677C";
        //boolean expResult = true;
        boolean result = ValidarDni.ValidarDni(DniTutor);
        //assertEquals(expResult, result);
        assertTrue(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of ValidarDni2 method, of class ValidarDni. Prueba DNI falso
     */
    @Test
    public void testValidarDni2() {
        System.out.println("ValidarDni");
        String DniTutor = "12345678A";
        boolean expResult = false;
        boolean result = ValidarDni.ValidarDni(DniTutor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of valoresletras method, of class ValidarDni.
     */
    @Test
    public void testValoresletras() {
        System.out.println("valoresletras");
        char[] letras = new char[23];
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
        ValidarDni.valoresletras(letras);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
