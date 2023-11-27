/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.nedeljniPlan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
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
 * @author adamo
 */
public class SOUpdateNedeljniPlanTest extends TestCase {

    SOUpdateNedeljniPlan soUpdateNedeljniPlan;
    NedeljniPlan nedeljniPlan;
    Date datumOd = null;
    Date datumDo = null;
    Cilj cilj;
    ArrayList<DnevnaAktivnost> dnevneAktivnosti;
    KategorijaCilja kategorijaCilja;
    Korisnik korisnik;
    TipAktivnosti tipAktivnosti;
    Aktivnost aktivnost;

    @Override
    protected void setUp() throws Exception {
        soUpdateNedeljniPlan = new SOUpdateNedeljniPlan();
        String datumStr1 = "2023-12-04";
        String datumStr2 = "2023-12-10";
        kategorijaCilja = new KategorijaCilja((long) 1, "Licni razvoj");
        cilj = new Cilj((long) 1, "Licni razvoj", "Edukacije", kategorijaCilja);
        korisnik = new Korisnik((long) 1, "Mina", "Lazic", "mina", "mina123");
        aktivnost = new Aktivnost((long) 1, "Masaza", "Sportska masaza", tipAktivnosti);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            datumOd = sdf.parse(datumStr1);
            datumDo = sdf.parse(datumStr2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        nedeljniPlan = new NedeljniPlan((long) 1, datumOd, datumDo, cilj, korisnik, dnevneAktivnosti);
    }

    @Override
    protected void tearDown() throws Exception {
        soUpdateNedeljniPlan = null;
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
            soUpdateNedeljniPlan.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase NedeljniPlan!", e.getMessage());
        }
    }

    @Test
    public void testDodajManjeDnevnihAktivnosti() throws Exception {
        ArrayList<DnevnaAktivnost> da = new ArrayList<>();
        da.add(new DnevnaAktivnost(nedeljniPlan, 1, new Date(), "beleske1", aktivnost));
        nedeljniPlan.setDnevneAktivnosti(da);

        try {
            soUpdateNedeljniPlan.validate(nedeljniPlan);
        } catch (Exception e) {
            assertEquals("Nedeljni plan mora imati barem 3 dnevne aktivnosti!", e.getMessage());
        }
    }
}
