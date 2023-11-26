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
public class CiljTest extends TestCase {

    Cilj cilj;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        cilj = new Cilj();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        cilj = null;
    }

    @Test
    public void testCilj() {
        long ciljID = 1;
        String naziv = "Licni razvoj";
        String opis = "Edukacije i knjige";
        KategorijaCilja kategorijaCilja = new KategorijaCilja((long) 1, "Licni razvoj");

        Cilj c = new Cilj(ciljID, naziv, opis, kategorijaCilja);

        assertEquals(ciljID, (long) c.getCiljID());
        assertEquals(naziv, c.getNazivCilja());
        assertEquals(opis, c.getOpisCilja());
        assertEquals(kategorijaCilja, c.getKategorijaCilja());

    }

    @Test
    public void testSetCiljID() {
        long ciljID = 1;
        cilj.setCiljID(ciljID);

        assertEquals(ciljID, (long) cilj.getCiljID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetCiljIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> cilj.setCiljID(id));

        assertEquals("ID ne sme biti nula ili manje.", e.getMessage());
    }

    @Test
    public void testSetNazivCilja() {
        cilj.setNazivCilja("Licni razvoj");

        assertEquals("Licni razvoj", cilj.getNazivCilja());
    }

    @Test
    public void testSetNazivCiljaNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> cilj.setNazivCilja(null));

        assertEquals("Naziv cilja ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetOpisCilja() {
        cilj.setOpisCilja("Edukacije i knjige");

        assertEquals("Edukacije i knjige", cilj.getOpisCilja());
    }

    @Test
    public void testSetOpisCiljaNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> cilj.setOpisCilja(null));

        assertEquals("Opis cilja ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetKategorijaCilja() {
        KategorijaCilja kategorijaCilja = new KategorijaCilja((long) 1, "Licni razvoj");
        cilj.setKategorijaCilja(kategorijaCilja);

        assertEquals(kategorijaCilja, cilj.getKategorijaCilja());
    }

    @Test
    public void testSetKategorijaCiljaNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> cilj.setKategorijaCilja(null));

        assertEquals("Kategorija cilja ne sme biti null.", e.getMessage());
    }

}
