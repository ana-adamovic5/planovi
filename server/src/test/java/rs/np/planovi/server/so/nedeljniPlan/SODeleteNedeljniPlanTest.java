/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package rs.np.planovi.server.so.nedeljniPlan;

import static junit.framework.Assert.assertEquals;
import junit.framework.TestCase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;

/**
 *
 * @author Ana Adamovic
 */
public class SODeleteNedeljniPlanTest extends TestCase {
    
    SODeleteNedeljniPlan soDeleteNedeljniPlan;
    
    @BeforeEach
    @Override
    protected void setUp() throws Exception {
        soDeleteNedeljniPlan=new SODeleteNedeljniPlan();
    }
    
    @AfterEach
    @Override
    protected void tearDown() throws Exception {
        soDeleteNedeljniPlan=null;
    }

     @Test
    public void testNevalidanObjekat() throws Exception {
        try {
            AbstractDomainObject nevalidan = new Aktivnost();
            soDeleteNedeljniPlan.validate(nevalidan);
        } catch (Exception e) {
            assertEquals("Prosledjeni objekat nije instanca klase NedeljniPlan!", e.getMessage());
        }
    }
}
