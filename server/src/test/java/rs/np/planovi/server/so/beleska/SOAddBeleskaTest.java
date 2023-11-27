/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.beleska;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
public class SOAddBeleskaTest extends TestCase {

    SOAddBeleska soAddBeleska;
    Beleska beleska;
    Korisnik korisnik;

    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soAddBeleska = new SOAddBeleska();
        korisnik = new Korisnik((long) 1, "Marija", "Mikic", "maki", "maki123");
        beleska = new Beleska();
    }

    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soAddBeleska = null;
        beleska = null;
    }

    @Test
    public void testExecute() throws Exception {
        beleska.setKorisnik(korisnik);
        beleska.setNaslov("Obaveze za decembar");
        beleska.setSadrzaj("Zubar, ispit, polaganje voznje");

        soAddBeleska.execute(beleska);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonString = gson.toJson(beleska);

        try ( FileWriter writer = new FileWriter("novaBeleska.json")) {
            writer.write(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(soAddBeleska.isUspesno());
    }

    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soAddBeleska.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Beleska!", e.getMessage());
        }
    }

    @Test
    public void testDodajBeleskuDuplikat() throws Exception {
        Beleska duplikat = new Beleska();
        duplikat.setKorisnik(korisnik);
        duplikat.setNaslov("Nabavka");
        duplikat.setSadrzaj("Hleb, mleko, jaja");

        try {
            soAddBeleska.validate(duplikat);
            fail("Izuzetak trebao biti bačen jer beleska sa istim naslovom već postoji u bazi.");
        } catch (Exception e) {
            assertEquals("Vec postoji beleska sa tim naslovom!", e.getMessage());
        }
    }
}
