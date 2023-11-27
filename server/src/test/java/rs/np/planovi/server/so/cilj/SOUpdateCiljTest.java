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
import junit.framework.TestCase;
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;

/**
 *
 * @author adamo
 */
public class SOUpdateCiljTest extends TestCase {

    SOUpdateCilj soUpdateCilj;
    Cilj cilj;
    KategorijaCilja kategorija;

    @Override
    protected void setUp() throws Exception {
        soUpdateCilj = new SOUpdateCilj();
        kategorija = new KategorijaCilja((long) 1, "Licni razvoj");
        cilj = new Cilj((long) 1, "Razvoj", "Edukacija", kategorija);
    }

    @Override
    protected void tearDown() throws Exception {
        soUpdateCilj = null;
        kategorija = null;
        cilj = null;
    }

    @Test
    public void testExecute() throws Exception {

        soUpdateCilj.execute(cilj);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(cilj);

        try ( FileWriter writer = new FileWriter("izmenjenCilj.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(soUpdateCilj.isUspesno());
    }

    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soUpdateCilj.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Cilj!", e.getMessage());
        }
    }
}
