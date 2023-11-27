/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.nedeljniPlan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;
import rs.np.planovi.zajednicki.domain.Korisnik;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import rs.np.planovi.zajednicki.domain.TipAktivnosti;

/**
 *
 * @author Ana Adamovic
 */
public class SOAddNedeljniPlanTest extends TestCase {

    SOAddNedeljniPlan soAddNedeljniPlan;
    NedeljniPlan nedeljniPlan;
    KategorijaCilja kategorijaCilja;
    Cilj cilj;
    ArrayList<DnevnaAktivnost> dnevneAktivnosti;
    Korisnik korisnik;
    Aktivnost aktivnost;
    TipAktivnosti tipAktivnosti;
    Date datumOd = null;
    Date datumDo = null;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soAddNedeljniPlan = new SOAddNedeljniPlan();
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

        String datumStr1 = "2023-12-04";
        String datumStr2 = "2023-12-10";

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            datumOd = sdf.parse(datumStr1);
            datumDo = sdf.parse(datumStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soAddNedeljniPlan = null;
        nedeljniPlan = null;
        kategorijaCilja = null;
        cilj = null;
        korisnik = null;
        tipAktivnosti = null;
        aktivnost = null;
        dnevneAktivnosti = null;
    }

    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soAddNedeljniPlan.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase NedeljniPlan!", e.getMessage());
        }
    }
}
