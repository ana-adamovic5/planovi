/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.beleska;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Beleska;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 *
 * @author adamo
 */
public class SOUpdateBeleska extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Beleska)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Beleska!");
        }

        Beleska b = (Beleska) ado;

        ArrayList<Beleska> beleske = (ArrayList<Beleska>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Beleska beleska : beleske) {
            if (beleska.getNaslov().equals(b.getNaslov())) {
                throw new Exception("Vec postoji beleska sa tim naslovom!");
            }
            
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().update(ado);
    }

}
