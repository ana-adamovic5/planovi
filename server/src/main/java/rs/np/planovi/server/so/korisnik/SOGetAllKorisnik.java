/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.korisnik;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Korisnik;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija koja vraca listu svih korisnika iz baze podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SOGetAllKorisnik extends AbstractSO {

    /**
     * Lista korisnika.
     */
    private ArrayList<Korisnik> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        ArrayList<AbstractDomainObject> korisnici = DBBroker.getInstance().select(ado);
        lista = (ArrayList<Korisnik>) (ArrayList<?>) korisnici;
    }

    /**
     * Vraca listu korisnika.
     * 
     * @return lista korisnika
     */
    public ArrayList<Korisnik> getLista() {
        return lista;
    }

}
