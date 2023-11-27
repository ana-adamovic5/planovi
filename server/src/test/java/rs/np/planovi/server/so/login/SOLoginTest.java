/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.login;

import java.sql.SQLException;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Korisnik;

/**
 *
 * @author Ana Adamovic
 */
public class SOLoginTest extends TestCase {

    SOLogin soLogin;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soLogin = new SOLogin();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soLogin = null;
    }

    @Test
    public void testUspesnaPrijava() throws SQLException, Exception {
        Korisnik validni = new Korisnik((long) 1, "Ana", "Adamovic", "ana", "ana123");

        soLogin.execute(validni);
        assertNotNull(soLogin.getUlogovani());

    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidan = new Beleska(); // Klasa koja nije Korisnik
        try {
            soLogin.validate(nevalidan);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Korisnik.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Korisnik!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validan = new Korisnik();

        soLogin.validate(validan);

        assertTrue(validan instanceof Korisnik);

    }

    @Test
    public void testNeuspesnaPrijava() {
        Korisnik pogresniPodaci = new Korisnik((long) 1, "Anja", "Peric", "ana", "123");

        try {
            soLogin.execute(pogresniPodaci);
            assertNull(soLogin.getUlogovani());
        } catch (Exception e) {
            assertEquals("Ne postoji korisnik sa tim kredencijalima.", e.getMessage());
        }
    }
}
