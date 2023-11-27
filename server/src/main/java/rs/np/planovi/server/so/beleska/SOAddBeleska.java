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
 * Sistemska operacija koja dodaje novu belesku u bazu podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SOAddBeleska extends AbstractSO {

    /**
     * Atribut kao pokazatelj uspesnosti operacije. Ako je uspesna ima vrednost
     * true, u suprotnom false.
     */
    private boolean uspesno = false;

    /**
     * Metoda pokazuje da li operacija uspesna.
     *
     * @return true ako je uspesna operacija, ili false ukoliko nije
     */
    public boolean isUspesno() {
        return uspesno;
    }

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
        DBBroker.getInstance().insert(ado);
        uspesno = true;
    }

}
