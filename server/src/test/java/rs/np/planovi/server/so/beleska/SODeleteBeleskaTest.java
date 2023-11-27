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
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Beleska;
import rs.np.planovi.zajednicki.domain.Korisnik;

/**
 *
 * @author Ana Adamovic
 */
public class SODeleteBeleskaTest extends TestCase {
    
    SODeleteBeleska soDeleteBeleska;
    Beleska beleska;
    Korisnik korisnik;
    
    @Override
    protected void setUp() throws Exception {
        soDeleteBeleska=new SODeleteBeleska();
        korisnik=new Korisnik((long)1, "Ana", "Adamovic", "ana", "ana123");
        beleska=new Beleska((long)6, "Nabavka", "hleb, jaja, mleko", korisnik);
    }
    
    @Override
    protected void tearDown() throws Exception {
        soDeleteBeleska=null;
        korisnik=null;
        beleska=null;
    }

    @Test
    public void testExecute() throws Exception {

        soDeleteBeleska.execute(beleska);
        assertTrue(soDeleteBeleska.isUspesno());
    }

    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soDeleteBeleska.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Beleska!", e.getMessage());
        }
    }
}
