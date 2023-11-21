/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.cilj;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Cilj;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 *
 * @author adamo
 */
public class SOUpdateCilj extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Cilj)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Cilj!");
        }

        Cilj c = (Cilj) ado;

        ArrayList<Cilj> ciljevi = (ArrayList<Cilj>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Cilj cilj : ciljevi) {
            if (!cilj.getCiljID().equals(c.getCiljID())) {
                if (cilj.getNazivCilja().equals(c.getNazivCilja())) {
                    throw new Exception("Vec postoji cilj sa tim nazivom!");
                }
                if (cilj.getOpisCilja().equals(c.getOpisCilja())) {
                    throw new Exception("Vec postoji cilj sa tim opisom!");
                }
            }
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
