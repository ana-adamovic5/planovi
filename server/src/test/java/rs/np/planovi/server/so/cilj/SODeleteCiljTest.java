/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.cilj;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.np.planovi.server.so.cilj.SODeleteCilj;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;

/**
 *
 * @author Ana Adamovic
 */
public class SODeleteCiljTest extends TestCase {
    
    SODeleteCilj soDeleteCilj;
    Cilj cilj;
    KategorijaCilja kategorija;
    
    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soDeleteCilj=new SODeleteCilj();
        kategorija=new KategorijaCilja((long)1, "Licni razvoj");
        cilj=new Cilj((long)1, "Licni razvoj", "Treninzi, knjige, edukacija", kategorija);
    }
    
    @Override
    protected void tearDown() throws Exception {
        soDeleteCilj=null;
        cilj=null;
        kategorija=null;
    }

    @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soDeleteCilj.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase Cilj!", e.getMessage());
        }
    }
}
