/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.aktivnost;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.TipAktivnosti;

/**
 *
 * @author Ana Adamovic
 */
public class SOGetAllAktivnostTest extends TestCase {

    SOGetAllAktivnost soGetAllAktivnost;
    Aktivnost aktivnost;
    TipAktivnosti tipAktivnosti;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soGetAllAktivnost = new SOGetAllAktivnost();
        tipAktivnosti = new TipAktivnosti();
        aktivnost = new Aktivnost();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soGetAllAktivnost = null;
        tipAktivnosti = null;
        aktivnost = null;
    }

    @Test
    public void testGetAllAktivnost() throws SQLException, Exception {
        tipAktivnosti.setNazivTipaAktivnosti("Opustajuca");
        aktivnost.setNazivAktivnosti("Masaza");
        aktivnost.setOpisAktivnosti("Terapeutska masaza.");

        soGetAllAktivnost.execute(aktivnost);
        ArrayList<Aktivnost> lista = soGetAllAktivnost.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("aktivnosti.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Beleska(); // Klasa koja nije Aktivnost
        try {
            soGetAllAktivnost.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa Aktivnost.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Aktivnost!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new Aktivnost();

        soGetAllAktivnost.validate(validanObjekat);

        assertTrue(validanObjekat instanceof Aktivnost);
    }
}
