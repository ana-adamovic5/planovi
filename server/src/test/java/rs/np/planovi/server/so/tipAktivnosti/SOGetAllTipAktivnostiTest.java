/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.tipAktivnosti;

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
import rs.np.planovi.zajednicki.domain.TipAktivnosti;

/**
 *
 * @author Ana Adamovic
 */
public class SOGetAllTipAktivnostiTest extends TestCase {

    SOGetAllTipAktivnosti soGetAllTipAktivnosti;
    TipAktivnosti tipAktivnosti;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soGetAllTipAktivnosti = new SOGetAllTipAktivnosti();
        tipAktivnosti = new TipAktivnosti();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soGetAllTipAktivnosti = null;
        tipAktivnosti = null;
    }

    @Test
    public void testGetAllTipAktivnosti() throws SQLException, Exception {
        tipAktivnosti.setNazivTipaAktivnosti("Opustajuca");

        soGetAllTipAktivnosti.execute(tipAktivnosti);
        ArrayList<TipAktivnosti> lista = soGetAllTipAktivnosti.getLista();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(lista);

        try ( FileWriter writer = new FileWriter("tipoviAktivnosti.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertNotNull(lista);
        assertTrue(!lista.isEmpty());
    }

    @Test
    public void testNevalidanObjekat() {
        AbstractDomainObject nevalidanObjekat = new Aktivnost(); // Klasa koja nije TipAktivnosti
        try {
            soGetAllTipAktivnosti.validate(nevalidanObjekat);
            fail("Izuzetak trebao biti bačen jer objekat nije tipa TipAktivnosti.");
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase TipAktivnosti!", e.getMessage());
        }
    }

    @Test
    public void testValidanObjekat() throws Exception {
        AbstractDomainObject validanObjekat = new TipAktivnosti();

        soGetAllTipAktivnosti.validate(validanObjekat);

        assertTrue(validanObjekat instanceof TipAktivnosti);
    }
}
