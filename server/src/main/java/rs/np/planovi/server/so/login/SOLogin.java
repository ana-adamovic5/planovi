/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.login;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Korisnik;
import java.util.ArrayList;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija za prijavljivanje korisnika na sistem.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SOLogin extends AbstractSO {

    /**
     * Korisnik koji se prijavljuje na sistem.
     */
    Korisnik ulogovani;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof Korisnik)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        Korisnik k = (Korisnik) ado;

        ArrayList<Korisnik> korisnici
                = (ArrayList<Korisnik>) (ArrayList<?>) DBBroker.getInstance().select(ado);

        for (Korisnik korisnik : korisnici) {
            if (korisnik.getUsername().equals(k.getUsername())
                    && korisnik.getPassword().equals(k.getPassword())) {
                ulogovani = korisnik;
                return;
            }
        }

        throw new Exception("Ne postoji korisnik sa tim kredencijalima.");

    }

    /**
     * Vraca prijavljenog korisnika.
     *
     * @return prijavljeni korisnik
     */
    public Korisnik getUlogovani() {
        return ulogovani;
    }

}
