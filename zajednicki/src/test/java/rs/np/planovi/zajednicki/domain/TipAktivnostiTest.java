/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author adamo
 */
public class TipAktivnostiTest extends TestCase {
   
    TipAktivnosti tipAktivnosti;
    
    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        tipAktivnosti=new TipAktivnosti();
    }
    
    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        tipAktivnosti=null;
    }

     @Test
    public void testTipAktivnosti() {
        long tipAktivnostiID = 1;
        String nazivTipaAktivnosti = "Opustajuca";

        TipAktivnosti ta=new TipAktivnosti(tipAktivnostiID, nazivTipaAktivnosti);
        
        assertEquals(tipAktivnostiID, (long) ta.getTipAktivnostiID());
        assertEquals(nazivTipaAktivnosti,ta.getNazivTipaAktivnosti());

    }
    
     @Test
    public void testSetTipAktivnostID() {
        long tipAktivnostID = 1;
        tipAktivnosti.setTipAktivnostiID(tipAktivnostID);

        assertEquals(tipAktivnostID, (long) tipAktivnosti.getTipAktivnostiID());
    }

    @ParameterizedTest
    @CsvSource({
        "0",
        "-1",
        "-55"
    })
    public void testSetTipAktivnostiIDNedozvoljeno(long id) {
        Exception e = assertThrows(IllegalArgumentException.class,
                () -> tipAktivnosti.setTipAktivnostiID(id));

        assertEquals("ID tipa aktivnosti ne sme biti manji od 1.", e.getMessage());
    }
    
    @Test
    public void testSetNazivTipaAktivnostiSveOk() {
        tipAktivnosti.setNazivTipaAktivnosti("Opustajuca");

        assertEquals("Opustajuca", tipAktivnosti.getNazivTipaAktivnosti());
    }

    @Test
    public void testSetNazivTipaAktivnostiNull() {
        Exception e = assertThrows(NullPointerException.class,
                () -> tipAktivnosti.setNazivTipaAktivnosti(null));

        assertEquals("Naziv tipa aktivnosti ne sme biti null.", e.getMessage());
    }
}
