/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.dnevnaAktivnost;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 *
 * @author adamo
 */
public class SOGetAllDnevnaAktivnost extends AbstractSO {

    private ArrayList<DnevnaAktivnost> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof DnevnaAktivnost)) {
            throw new Exception("Prosledjeni objekat nije instanca klase DnevnaAktivnost!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> dnevneAktivnosti = DBBroker.getInstance().select(ado);
        lista = (ArrayList<DnevnaAktivnost>) (ArrayList<?>) dnevneAktivnosti;
    }

    public ArrayList<DnevnaAktivnost> getLista() {
        return lista;
    }

}
