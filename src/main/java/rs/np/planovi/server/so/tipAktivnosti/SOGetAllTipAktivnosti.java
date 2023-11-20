/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.tipAktivnosti;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.TipAktivnosti;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 *
 * @author adamo
 */
public class SOGetAllTipAktivnosti extends AbstractSO {

    private ArrayList<TipAktivnosti> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipAktivnosti)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> tipoviAktivnosti = DBBroker.getInstance().select(ado);
        lista = (ArrayList<TipAktivnosti>) (ArrayList<?>) tipoviAktivnosti;
    }

    public ArrayList<TipAktivnosti> getLista() {
        return lista;
    }

}
