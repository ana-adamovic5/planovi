/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.nedeljniPlan;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
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
public class SOGetAllNedeljniPlanTest extends TestCase {

    SOGetAllNedeljniPlan soGetAllNedeljniPlan;
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
        soGetAllNedeljniPlan = new SOGetAllNedeljniPlan();
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
        soGetAllNedeljniPlan = null;
        nedeljniPlan = null;
        kategorijaCilja = null;
        cilj = null;
        korisnik = null;
        tipAktivnosti = null;
        aktivnost = null;
        dnevneAktivnosti = null;
    }

    @Test
    public void testGetAllNedeljniPlan() throws SQLException, Exception {
        nedeljniPlan.setNedeljniPlanID((long) 1);
        nedeljniPlan.setKorisnik(korisnik);
        nedeljniPlan.setDnevneAktivnosti(dnevneAktivnosti);
        nedeljniPlan.setDatumOd(new Date());
        nedeljniPlan.setDatumDo(new Date());
        nedeljniPlan.setCilj(cilj);

        soGetAllNedeljniPlan.execute(nedeljniPlan);
        ArrayList<NedeljniPlan> lista = soGetAllNedeljniPlan.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("nedeljniPlanovi.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije NedeljniPlan
        try {
            soGetAllNedeljniPlan.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa NedeljniPlan.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase NedeljniPlan!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new NedeljniPlan();

        soGetAllNedeljniPlan.validate(validanObjekat);

        assertTrue(validanObjekat instanceof NedeljniPlan);
    }

}
