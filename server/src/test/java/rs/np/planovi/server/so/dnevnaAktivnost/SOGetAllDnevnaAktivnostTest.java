/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.dnevnaAktivnost;

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
public class SOGetAllDnevnaAktivnostTest extends TestCase {

    SOGetAllDnevnaAktivnost soGetAllDnevnaAktivnost;
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
        soGetAllDnevnaAktivnost = new SOGetAllDnevnaAktivnost();
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
        soGetAllDnevnaAktivnost = null;
        dnevnaAktivnost = null;
    }

    @Test
    public void testGetAllDnevnaAktivnost() throws SQLException, Exception {
        dnevnaAktivnost.setNedeljniPlan(nedeljniPlan);
        dnevnaAktivnost.setAktivnost(aktivnost);
        dnevnaAktivnost.setBeleske("beleske");
        dnevnaAktivnost.setDatumAktivnosti(new Date());
        dnevnaAktivnost.setRb(1);

        soGetAllDnevnaAktivnost.execute(dnevnaAktivnost);
        ArrayList<DnevnaAktivnost> lista = soGetAllDnevnaAktivnost.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("dnevneAktivnosti.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije DnevnaAktivnost
        try {
            soGetAllDnevnaAktivnost.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa DnevnaAktivnost.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase DnevnaAktivnost!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new DnevnaAktivnost();

        soGetAllDnevnaAktivnost.validate(validanObjekat);

        assertTrue(validanObjekat instanceof DnevnaAktivnost);
    }
}
