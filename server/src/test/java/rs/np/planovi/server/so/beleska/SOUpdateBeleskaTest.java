/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.beleska;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
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
 * @author adamo
 */
public class SOUpdateBeleskaTest extends TestCase {
    
    SOUpdateBeleska soUpdateBeleska;
    Beleska beleska;
    Korisnik korisnik;
    
    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soUpdateBeleska = new SOUpdateBeleska();
        korisnik = new Korisnik((long) 1, "Marija", "Mikic", "maki", "maki123");
        beleska = new Beleska((long)6, "Naslov", "hleb, jaja, mleko", korisnik);
    }
    
    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soUpdateBeleska=null;
        beleska=null;
        korisnik=null;
    }

    @Test
    public void testExecute() throws Exception {

        soUpdateBeleska.execute(beleska);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(beleska);

        try ( FileWriter writer = new FileWriter("izmenjenaBeleska.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(soUpdateBeleska.isUspesno());
    }
    
    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soUpdateBeleska.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Beleska!", e.getMessage());
        }
    }
}
