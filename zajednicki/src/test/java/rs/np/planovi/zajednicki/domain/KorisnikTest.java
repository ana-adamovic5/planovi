/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Ana Adamovic
 */
public class KorisnikTest extends TestCase {

    Korisnik korisnik;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        korisnik = new Korisnik();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        korisnik = null;
    }

    @Test
    public void testKorisnik() {
        long korisnikID = 1;
        String ime = "Ana";
        String prezime = "Adamovic";
        String username = "ana";
        String password = "ana123";

        Korisnik k = new Korisnik(korisnikID, ime, prezime, username, password);

        assertEquals(korisnikID, (long) k.getKorisnikID());
        assertEquals(ime, k.getIme());
        assertEquals(prezime, k.getPrezime());
        assertEquals(username, k.getUsername());
        assertEquals(password, k.getPassword());

    }

    @Test
    public void testSetKorisnikID() {
        long korisnikID = 1;
        korisnik.setKorisnikID(korisnikID);

        assertEquals(korisnikID, (long) korisnik.getKorisnikID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetKorisnikIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> korisnik.setKorisnikID(id));

        assertEquals("ID korisnika ne sme biti nula ili manji", e.getMessage());
    }

    @Test
    public void testSetUsernameSveOk() {
        korisnik.setUsername("nina");

        assertEquals("nina", korisnik.getUsername());
    }

    @Test
    public void testSetUsernameNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> korisnik.setUsername(null));

        assertEquals("Username ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetUsernamePrazanString() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> korisnik.setUsername(""));

        assertEquals("Username ne sme biti prazan String.", e.getMessage());
    }

    @Test
    public void testSetPasswordSveOk() {
        korisnik.setPassword("nina123");

        assertEquals("nina123", korisnik.getPassword());
    }

    @Test
    public void testSetPasswordNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> korisnik.setPassword(null));

        assertEquals("Password ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetPasswordPrazanString() {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> korisnik.setPassword(""));

        assertEquals("Password ne sme biti prazan String.", e.getMessage());
    }
    
    @Test
    public void testSetIme() {
        korisnik.setIme("Nina");

        assertEquals("Nina", korisnik.getIme());
    }
    
    @Test
    public void testSetImeNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> korisnik.setIme(null));

        assertEquals("Ime korisnika ne sme biti null.", e.getMessage());
    }
    
    @Test
    public void testSetPrezime() {
        korisnik.setPrezime("Peric");

        assertEquals("Peric", korisnik.getPrezime());
    }
    
    @Test
    public void testSetPrezimeNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> korisnik.setPrezime(null));

        assertEquals("Prezime korisnika ne sme biti null.", e.getMessage());
    }
    
}
