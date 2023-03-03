package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Kaik D' Andrade
 */
public class UsersTest {

    public UsersTest() {
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
     * Test of getName method, of class Users.
     */
    @Test
    public void testInvalidNameName() {
        System.out.println("invalidName");
        Users instance = new Users();
        instance.setName("    ");
        assertNull(instance.getName());

        instance.setName("  342/a wwfa  ");
        assertNull(instance.getName());

        instance.setName("   Kaik.2005% ");
        assertNull(instance.getName());
    }

    /**
     * Test of setName method, of class Users.
     */
    @Test
    public void testValidName() {
        System.out.println("validName");
        Users instance = new Users();
        String expResult = "Abacate";
        instance.setName("  Abacate   ");
        assertEquals(expResult, instance.getName());

        expResult = "Abacate Podre";
        instance.setName("      Abacate Podre        ");
        assertEquals(expResult, instance.getName());
    }

    /**
     * Test of getLogin method, of class Users.
     */
    @Test
    public void testInvalidLogin() {
        System.out.println("invalidLogin");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getLogin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLogin method, of class Users.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        String login = "";
        Users instance = new Users();
        instance.setLogin(login);
    }

    /**
     * Test of getPassword method, of class Users.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class Users.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Users instance = new Users();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
