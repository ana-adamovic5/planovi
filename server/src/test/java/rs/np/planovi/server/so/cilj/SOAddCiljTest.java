/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.cilj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;

/**
 *
 * @author Ana Adamovic
 */
public class SOAddCiljTest extends TestCase {

    SOAddCilj soAddCilj;
    Cilj cilj;
    KategorijaCilja kategorija;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soAddCilj = new SOAddCilj();
        kategorija = new KategorijaCilja((long) 1, "Ishrana");
        cilj = new Cilj();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soAddCilj = null;
        kategorija = null;
        cilj = null;
    }

    @Test
    public void testExecute() throws Exception {
        cilj.setNazivCilja("Bolja ishrana");
        cilj.setOpisCilja("Vise povrca i voca");
        cilj.setKategorijaCilja(kategorija);

        soAddCilj.execute(cilj);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(cilj);

        try ( FileWriter writer = new FileWriter("noviCilj.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(soAddCilj.isUspesno());
    }

    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soAddCilj.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Cilj!", e.getMessage());
        }
    }

    @Test
    public void testDodajCiljDuplikatNaziv() throws Exception {
        Cilj duplikat = new Cilj();
        duplikat.setNazivCilja("Licni razvoj");
        duplikat.setOpisCilja("Edukacija");

        try {
            soAddCilj.validate(duplikat);
            fail("Izuzetak trebao biti bačen jer cilj sa istim nazivom već postoji u bazi.");
        } catch (Exception e) {
            assertEquals("Vec postoji cilj sa tim nazivom!", e.getMessage());
        }
    }

    @Test
    public void testDodajCiljDuplikatOpis() throws Exception {
        Cilj duplikat = new Cilj();
        duplikat.setNazivCilja("Razvoj");
        duplikat.setOpisCilja("Treninzi, knjige, edukacija");

        try {
            soAddCilj.validate(duplikat);
            fail("Izuzetak trebao biti bačen jer cilj sa istim opisom već postoji u bazi.");
        } catch (Exception e) {
            assertEquals("Vec postoji cilj sa tim opisom!", e.getMessage());
        }
    }
}
