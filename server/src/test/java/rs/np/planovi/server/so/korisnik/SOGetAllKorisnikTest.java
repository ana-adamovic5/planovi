/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.korisnik;

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
import rs.np.planovi.zajednicki.domain.Korisnik;

/**
 *
 * @author Ana Adamovic
 */
public class SOGetAllKorisnikTest extends TestCase {

    SOGetAllKorisnik soGetAllKorisnik;
    Korisnik korisnik;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soGetAllKorisnik = new SOGetAllKorisnik();
        korisnik = new Korisnik();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soGetAllKorisnik = null;
        korisnik = null;
    }

    @Test
    public void testGetAllKorisnik() throws SQLException, Exception {
        korisnik.setIme("Ana");
        korisnik.setPrezime("Adamovic");
        korisnik.setUsername("ana");
        korisnik.setPassword("ana123");

        soGetAllKorisnik.execute(korisnik);
        ArrayList<Korisnik> lista = soGetAllKorisnik.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("korisnici.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije Korisnik
        try {
            soGetAllKorisnik.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Korisnik.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Korisnik!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new Korisnik();

        soGetAllKorisnik.validate(validanObjekat);

        assertTrue(validanObjekat instanceof Korisnik);
    }
}
