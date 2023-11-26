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
 * @author Ana Adamovic
 */
public class AktivnostTest extends TestCase {

    Aktivnost aktivnost;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        aktivnost = new Aktivnost();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        aktivnost = null;
    }

    @Test
    public void testAktivnost() {
        long aktivnostID = 1;
        String nazivAktivnosti = "Masaza";
        String opisAktivnosti = "Sportska masaza";
        TipAktivnosti tipAktivnosti = new TipAktivnosti((long) 1, "Opustajuca");

        Aktivnost a = new Aktivnost(aktivnostID, nazivAktivnosti, opisAktivnosti, tipAktivnosti);

        assertEquals(aktivnostID, (long) a.getAktivnostID());
        assertEquals(nazivAktivnosti, a.getNazivAktivnosti());
        assertEquals(opisAktivnosti, a.getOpisAktivnosti());
        assertEquals(tipAktivnosti, a.getTipAktivnosti());
    }

    @Test
    public void testToString() {
        aktivnost.setNazivAktivnosti("Masaza");
        String s = aktivnost.toString();

        assertTrue(s.contains("Masaza"));
    }

    @Test
    public void testSetAktivnostID() {
        long aktivnostID = 1;
        aktivnost.setAktivnostID(aktivnostID);

        assertEquals(aktivnostID, (long) aktivnost.getAktivnostID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetAktivnostIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> aktivnost.setAktivnostID(id));

        assertEquals("ID aktivnosti ne sme biti nula ili manji.", e.getMessage());
    }

    @Test
    public void testSetNazivAktivnostiSveOk() {
        aktivnost.setNazivAktivnosti("Masaza");

        assertEquals("Masaza", aktivnost.getNazivAktivnosti());
    }

    @Test
    public void testSetNazivAktivnostiNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> aktivnost.setNazivAktivnosti(null));

        assertEquals("Naziv aktivnosti ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetOpisAktivnostiSveOk() {
        aktivnost.setOpisAktivnosti("Sportska masaza");

        assertEquals("Sportska masaza", aktivnost.getOpisAktivnosti());
    }

    @Test
    public void testSetOpisAktivnostiNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> aktivnost.setOpisAktivnosti(null));

        assertEquals("Opis aktivnosti ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetTipAktivnostiSveOk() {
        TipAktivnosti tipAktivnosti = new TipAktivnosti((long) 1, "Opustajuca");
        aktivnost.setTipAktivnosti(tipAktivnosti);

        assertEquals(tipAktivnosti, aktivnost.getTipAktivnosti());
    }

    @Test
    public void testSetTipAktivnostiNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> aktivnost.setTipAktivnosti(null));

        assertEquals("Tip aktivnosti ne sme biti null.", e.getMessage());
    }

}
