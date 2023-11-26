/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import java.util.ArrayList;
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
public class NedeljniPlanTest extends TestCase {

    NedeljniPlan nedeljniPlan;
    KategorijaCilja kategorijaCilja;
    Cilj cilj;
    ArrayList<DnevnaAktivnost> dnevneAktivnosti;
    Korisnik korisnik;
    Aktivnost aktivnost;
    TipAktivnosti tipAktivnosti;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        nedeljniPlan = new NedeljniPlan();
        kategorijaCilja = new KategorijaCilja((long) 1, "Licni razvoj");
        cilj = new Cilj((long) 1, "Licni razvoj", "Edukacije", kategorijaCilja);
        korisnik = new Korisnik((long) 1, "Mina", "Lazic", "mina", "mina123");
        tipAktivnosti = new TipAktivnosti((long) 1, "Opustajuca");
        aktivnost = new Aktivnost((long) 1, "Masaza", "Sportska masaza", tipAktivnosti);
        dnevneAktivnosti = new ArrayList<>();
        dnevneAktivnosti.add(new DnevnaAktivnost(nedeljniPlan, 1, new Date(), "beleske1", aktivnost));
        dnevneAktivnosti.add(new DnevnaAktivnost(nedeljniPlan, 2, new Date(), "beleske2", aktivnost));
        dnevneAktivnosti.add(new DnevnaAktivnost(nedeljniPlan, 3, new Date(), "beleske3", aktivnost));
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        nedeljniPlan = null;
        kategorijaCilja = null;
        cilj = null;
        korisnik = null;
        tipAktivnosti = null;
        aktivnost = null;
        dnevneAktivnosti = null;
    }

    @Test
    public void testNedeljniPlan() {
        long nedeljniPlanID = 1;
        Date datumOd = new Date();
        Date datumDo = new Date();

        NedeljniPlan np = new NedeljniPlan(nedeljniPlanID, datumOd, datumDo, cilj, korisnik, dnevneAktivnosti);

        assertEquals(nedeljniPlanID, (long) np.getNedeljniPlanID());
        assertEquals(datumOd, np.getDatumOd());
        assertEquals(datumDo, np.getDatumDo());
        assertEquals(cilj, np.getCilj());
        assertEquals(korisnik, np.getKorisnik());
        assertEquals(dnevneAktivnosti, np.getDnevneAktivnosti());

    }

    @Test
    public void testSetNedeljniPlanID() {
        long nedeljniPlanID = 1;
        nedeljniPlan.setNedeljniPlanID(nedeljniPlanID);

        assertEquals(nedeljniPlanID, (long) nedeljniPlan.getNedeljniPlanID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetNedeljniPlanIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> nedeljniPlan.setNedeljniPlanID(id));

        assertEquals("ID ne sme biti nula ili manje.", e.getMessage());
    }

    @Test
    public void testSetDatumOd() {
        nedeljniPlan.setDatumOd(new Date());

        assertEquals(new Date(), nedeljniPlan.getDatumOd());
    }

    @Test
    public void testSetDatumOdNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> nedeljniPlan.setDatumOd(null));

        assertEquals("Datum pocetka nedeljnog plana ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetDatumDo() {
        nedeljniPlan.setDatumDo(new Date());

        assertEquals(new Date(), nedeljniPlan.getDatumDo());
    }

    @Test
    public void testSetDatumDoNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> nedeljniPlan.setDatumDo(null));

        assertEquals("Datum zavrsetka nedeljnog plana ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetCilj() {
        nedeljniPlan.setCilj(cilj);

        assertEquals(cilj, nedeljniPlan.getCilj());
    }

    @Test
    public void testSetCiljNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> nedeljniPlan.setCilj(null));

        assertEquals("Cilj nedeljnog plana ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetKorisnik() {
        nedeljniPlan.setKorisnik(korisnik);

        assertEquals(korisnik, nedeljniPlan.getKorisnik());
    }

    @Test
    public void testSetKorisnikNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> nedeljniPlan.setKorisnik(null));

        assertEquals("Korisnik nedeljnog plana ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetDnevneAktivnosti() {
        nedeljniPlan.setDnevneAktivnosti(dnevneAktivnosti);

        assertEquals(dnevneAktivnosti, nedeljniPlan.getDnevneAktivnosti());
    }

    @Test
    public void testSetDnevneAktivnostiNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> nedeljniPlan.setDnevneAktivnosti(null));

        assertEquals("Lista dnevnih aktivnosti ne sme biti null.", e.getMessage());
    }

    @Test
    public void testSetDnevneAktivnostiManjeOd3() {
        ArrayList<DnevnaAktivnost> da = new ArrayList<>();
        da.add(new DnevnaAktivnost(nedeljniPlan, 1, new Date(), "beleske1", aktivnost));
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> nedeljniPlan.setDnevneAktivnosti(da));

        assertEquals("Lista mora imati minimum 3 dnevne aktivnosti.", e.getMessage());
    }
}
