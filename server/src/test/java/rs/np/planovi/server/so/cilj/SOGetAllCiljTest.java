/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.cilj;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
import rs.np.planovi.zajednicki.domain.KategorijaCilja;

/**
 *
 * @author Ana Adamovic
 */
public class SOGetAllCiljTest extends TestCase {

    SOGetAllCilj soGetAllCilj;
    KategorijaCilja kategorija;
    Cilj cilj;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soGetAllCilj = new SOGetAllCilj();
        kategorija = new KategorijaCilja((long) 1, "Licni razvoj");
        cilj = new Cilj();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soGetAllCilj = null;
        kategorija = null;
        cilj = null;
    }

    @Test
    public void testGetAllCilj() throws SQLException, Exception {
        cilj.setKategorijaCilja(kategorija);
        cilj.setNazivCilja("Edukacija");
        cilj.setOpisCilja("Konferencije i seminari na fakultetu.");

        soGetAllCilj.execute(cilj);
        ArrayList<Cilj> lista = soGetAllCilj.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("ciljevi.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije Cilj
        try {
            soGetAllCilj.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Cilj.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Cilj!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new Cilj();

        soGetAllCilj.validate(validanObjekat);

        assertTrue(validanObjekat instanceof Cilj);
    }
}
