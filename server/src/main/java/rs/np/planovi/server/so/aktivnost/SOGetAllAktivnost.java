/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.aktivnost;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 *
 * @author adamo
 */
public class SOGetAllAktivnost extends AbstractSO {

    private ArrayList<Aktivnost> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Aktivnost)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Aktivnost!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> aktivnosti = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Aktivnost>) (ArrayList<?>) aktivnosti;
    }

    public ArrayList<Aktivnost> getLista() {
        return lista;
    }

}
