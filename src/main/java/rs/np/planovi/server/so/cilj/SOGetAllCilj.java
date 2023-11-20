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
public class SOGetAllCilj extends AbstractSO {

    private ArrayList<Cilj> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Cilj)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Cilj!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> ciljevi = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Cilj>) (ArrayList<?>) ciljevi;
    }

    public ArrayList<Cilj> getLista() {
        return lista;
    }

}
