/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.nedeljniPlan;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija koja vraca listu svih nedeljnih planova iz baze podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SOGetAllNedeljniPlan extends AbstractSO {

    /**
     * Lista nedeljnih planova.
     */
    private ArrayList<NedeljniPlan> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof NedeljniPlan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase NedeljniPlan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> nedeljniPlanovi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<NedeljniPlan>) (ArrayList<?>) nedeljniPlanovi;
    }

    /**
     * Vraca listu nedeljnih planova.
     *
     * @return lista nedeljnih planova
     */
    public ArrayList<NedeljniPlan> getLista() {
        return lista;
    }

}
