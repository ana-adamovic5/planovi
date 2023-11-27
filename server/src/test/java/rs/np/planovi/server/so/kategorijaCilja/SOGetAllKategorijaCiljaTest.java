/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.kategorijaCilja;

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
import rs.np.planovi.zajednicki.domain.KategorijaCilja;

/**
 *
 * @author Ana Adamovic
 */
public class SOGetAllKategorijaCiljaTest extends TestCase {

    SOGetAllKategorijaCilja soGetAllKategorijaCilja;
    KategorijaCilja kategorija;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soGetAllKategorijaCilja = new SOGetAllKategorijaCilja();
        kategorija = new KategorijaCilja();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soGetAllKategorijaCilja = null;
        kategorija = null;
    }

    @Test
    public void testGetAllKategorijaCilja() throws SQLException, Exception {
        kategorija.setNazivKategorije("Fitnes");

        soGetAllKategorijaCilja.execute(kategorija);
        ArrayList<KategorijaCilja> lista = soGetAllKategorijaCilja.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("kategorije.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije KategorijaCilja
        try {
            soGetAllKategorijaCilja.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa KategorijaCilja.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase KategorijaCilja!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new KategorijaCilja();

        soGetAllKategorijaCilja.validate(validanObjekat);

        assertTrue(validanObjekat instanceof KategorijaCilja);
    }
}
