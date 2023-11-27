/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.beleska;

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
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Korisnik;

/**
 *
 * @author Ana Adamovic
 */
public class SOGetAllBeleskaTest extends TestCase {

    SOGetAllBeleska soGetAllBeleska;
    Korisnik korisnik;
    Beleska beleska;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soGetAllBeleska = new SOGetAllBeleska();
        korisnik = new Korisnik((long) 1, "Ana", "Adamovic", "ana", "ana123");
        beleska = new Beleska();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soGetAllBeleska = null;
        beleska = null;
        korisnik = null;
    }

    @Test
    public void testGetAllBeleska() throws SQLException, Exception {
        beleska.setKorisnik(korisnik);
        beleska.setNaslov("Nabavka");
        beleska.setSadrzaj("Hleb i mleko.");

        soGetAllBeleska.execute(beleska);
        ArrayList<Beleska> lista = soGetAllBeleska.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("beleske.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije Beleska
        try {
            soGetAllBeleska.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Beleska.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Beleska!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new Beleska();

        soGetAllBeleska.validate(validanObjekat);

        assertTrue(validanObjekat instanceof Beleska);
    }

}
