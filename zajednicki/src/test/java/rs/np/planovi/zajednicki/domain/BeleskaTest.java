/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author adamo
 */
public class BeleskaTest extends TestCase {

    Beleska beleska;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        beleska = new Beleska();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        beleska = null;
    }

    @Test
    public void testBeleska() {
        long beleskaID = 1;
        String naslov = "Nabavka";
        String sadrzaj = "hleb, mleko, jaja";
        Korisnik korisnik = new Korisnik((long) 1, "Pera", "Peric", "pera", "pera123");

        Beleska b = new Beleska(beleskaID, naslov, sadrzaj, korisnik);

        assertEquals(beleskaID, (long) b.getBeleskaID());
        assertEquals(naslov, b.getNaslov());
        assertEquals(sadrzaj, b.getSadrzaj());
        assertEquals(korisnik, b.getKorisnik());

    }

    @Test
    public void testSetBeleskaID() {
        long beleskaID = 1;
        beleska.setBeleskaID(beleskaID);

        assertEquals(beleskaID, (long) beleska.getBeleskaID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetBeleskaIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> beleska.setBeleskaID(id));

        assertEquals("ID ne sme biti nula ili manji.", e.getMessage());
    }

    @Test
    public void testSetSadrzaj() {
        beleska.setSadrzaj("hleb, mleko, jaja");

        assertEquals("hleb, mleko, jaja", beleska.getSadrzaj());
    }

    @Test
    public void testSetSadrzajNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> beleska.setSadrzaj(null));

        assertEquals("Sadrzaj beleske ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetNaslov() {
        beleska.setNaslov("Nabavka");

        assertEquals("Nabavka", beleska.getNaslov());
    }

    @Test
    public void testSetNaslovNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> beleska.setNaslov(null));

        assertEquals("Naslov beleske ne sme biti null", e.getMessage());
    }

    @Test
    public void testSetKorisnik() {
        Korisnik korisnik = new Korisnik((long) 1, "Pera", "Peric", "pera", "pera123");
        beleska.setKorisnik(korisnik);

        assertEquals(korisnik, beleska.getKorisnik());
    }

    @Test
    public void testSetKorisnikNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> beleska.setKorisnik(null));

        assertEquals("Korisnik ne sme biti null.", e.getMessage());
    }

}
