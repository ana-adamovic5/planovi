/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.np.planovi.server.so.kategorijaCilja;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.KategorijaCilja;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija koja vraca listu svih kategorija ciljeva iz baze podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SOGetAllKategorijaCilja extends AbstractSO {

    /**
     * Lista kategorija ciljeva.
     */
    private ArrayList<KategorijaCilja> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof KategorijaCilja)) {
            throw new Exception("Prosledjeni objekat nije instanca klase KategorijaCilja!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> kategorijeCiljeva = DBBroker.getInstance().select(ado);
        lista = (ArrayList<KategorijaCilja>) (ArrayList<?>) kategorijeCiljeva;
    }

    /**
     * Vraca listu kategorija ciljeva.
     *
     * @return lista kategorija ciljeva
     */
    public ArrayList<KategorijaCilja> getLista() {
        return lista;
    }

}
