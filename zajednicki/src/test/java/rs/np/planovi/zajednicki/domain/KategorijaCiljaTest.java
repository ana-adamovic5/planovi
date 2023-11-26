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
public class KategorijaCiljaTest extends TestCase {

    KategorijaCilja kategorijaCilja;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        kategorijaCilja = new KategorijaCilja();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        kategorijaCilja = null;
    }

    @Test
    public void testKategorijaCilja() {
        long kategorijaID = 1;
        String nazivKategorije = "Fitnes";

        KategorijaCilja kc = new KategorijaCilja(kategorijaID, nazivKategorije);

        assertEquals(kategorijaID, (long) kc.getKategorijaID());
        assertEquals(nazivKategorije, kc.getNazivKategorije());
    }

    @Test
    public void testToString() {
        kategorijaCilja.setNazivKategorije("Fitnes");
        String s = kategorijaCilja.toString();

        assertTrue(s.contains("Fitnes"));
    }

    @Test
    public void testSetKategorijaID() {
        long kategorijaID = 1;
        kategorijaCilja.setKategorijaID(kategorijaID);

        assertEquals(kategorijaID, (long) kategorijaCilja.getKategorijaID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetKategorijaIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> kategorijaCilja.setKategorijaID(id));

        assertEquals("ID kategorije cilja ne sme biti manji od 1.", e.getMessage());
    }

    @Test
    public void testSetNazivKategorijeSveOk() {
        kategorijaCilja.setNazivKategorije("Fitnes");

        assertEquals("Fitnes", kategorijaCilja.getNazivKategorije());
    }

    @Test
    public void testSetNazivKategorijeNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> kategorijaCilja.setNazivKategorije(null));

        assertEquals("Naziv kategorije cilja ne sme biti null.", e.getMessage());
    }
}
