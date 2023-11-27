/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.nedeljniPlan;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija koja brise nedeljni plan iz baze podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SODeleteNedeljniPlan extends AbstractSO {

    /**
     * Atribut kao pokazatelj uspesnosti operacije. Ako je uspesna ima vrednost
     * true, u suprotnom false.
     */
    private boolean uspesno = false;

    /**
     * Metoda pokazuje da li operacija uspesna.
     *
     * @return true ako je uspesna operacija, ili false ukoliko nije
     */
    public boolean isUspesno() {
        return uspesno;
    }

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof NedeljniPlan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase NedeljniPlan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
        uspesno=true;
    }

}
