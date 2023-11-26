/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import java.util.Date;
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
public class DnevnaAktivnostTest extends TestCase {

    DnevnaAktivnost dnevnaAktivnost;
    NedeljniPlan nedeljniPlan;
    TipAktivnosti tipAktivnosti;
    Aktivnost aktivnost;
    Cilj cilj;
    Korisnik korisnik;
    KategorijaCilja kategorijaCilja;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        dnevnaAktivnost = new DnevnaAktivnost();
        aktivnost = new Aktivnost((long) 1, "Masaza", "Sportska masaza", tipAktivnosti);
        kategorijaCilja = new KategorijaCilja((long) 1, "Licni razvoj");
        cilj = new Cilj((long) 1, "Licni razvoj", "Edukacije", kategorijaCilja);
        korisnik = new Korisnik((long) 1, "Mina", "Lazic", "mina", "mina123");
        tipAktivnosti = new TipAktivnosti((long) 1, "Opustajuca");
        nedeljniPlan = new NedeljniPlan((long) 1, new Date(), new Date(), cilj, korisnik, null);
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        dnevnaAktivnost = null;
    }

    @Test
    public void testDnevnaAktivnost() {
        int rb = 1;
        Date datum = new Date();
        String beleske = "beleske";

        DnevnaAktivnost da = new DnevnaAktivnost(nedeljniPlan, rb, datum, beleske, aktivnost);

        assertEquals(nedeljniPlan, da.getNedeljniPlan());
        assertEquals(rb, da.getRb());
        assertEquals(datum, da.getDatumAktivnosti());
        assertEquals(beleske, da.getBeleske());
        assertEquals(aktivnost, da.getAktivnost());
    }
    
    @Test
    public void testSetRedniBroj() {
        dnevnaAktivnost.setRb(1);

        assertEquals(1, dnevnaAktivnost.getRb());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetNedeljniPlanIDNedozvoljeno(int id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> dnevnaAktivnost.setRb(id));

        assertEquals("Redni broj mora biti veci od nule.", e.getMessage());
    }

    
     @Test
    public void testSetNedeljniPlan() {
        dnevnaAktivnost.setNedeljniPlan(nedeljniPlan);

        assertEquals(nedeljniPlan, dnevnaAktivnost.getNedeljniPlan());
    }

    @Test
    public void testSetNedeljniPlanNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> dnevnaAktivnost.setNedeljniPlan(null));

        assertEquals("Nedeljni plan ne sme biti null.", e.getMessage());
    }
    
    @Test
    public void testSetDatum() {
        dnevnaAktivnost.setDatumAktivnosti(new Date());

        assertEquals(new Date(), dnevnaAktivnost.getDatumAktivnosti());
    }

    @Test
    public void testSetDatumNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> dnevnaAktivnost.setDatumAktivnosti(null));

        assertEquals("Datum aktivnosti ne sme biti null.", e.getMessage());
    }
    
     @Test
    public void testSetBeleske() {
        dnevnaAktivnost.setBeleske("beleske");

        assertEquals("beleske", dnevnaAktivnost.getBeleske());
    }

    @Test
    public void testSetBeleskeNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> dnevnaAktivnost.setBeleske(null));

        assertEquals("Beleske ne smeju biti null.", e.getMessage());
    }
    
     @Test
    public void testSetAktivnost() {
        dnevnaAktivnost.setAktivnost(aktivnost);

        assertEquals(aktivnost, dnevnaAktivnost.getAktivnost());
    }

    @Test
    public void testSetAktivnostNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> dnevnaAktivnost.setAktivnost(null));

        assertEquals("Aktivnost ne sme biti null.", e.getMessage());
    }
}
