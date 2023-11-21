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
public class SOGetAllBeleska extends AbstractSO {

    private ArrayList<Beleska> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Beleska)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Beleska!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> beleske = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Beleska>) (ArrayList<?>) beleske;
    }

    public ArrayList<Beleska> getLista() {
        return lista;
    }

}