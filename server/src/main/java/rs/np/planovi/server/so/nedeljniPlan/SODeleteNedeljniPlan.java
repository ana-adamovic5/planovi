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
 *
 * @author adamo
 */
public class SODeleteNedeljniPlan extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof NedeljniPlan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase NedeljniPlan!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
    }

}
