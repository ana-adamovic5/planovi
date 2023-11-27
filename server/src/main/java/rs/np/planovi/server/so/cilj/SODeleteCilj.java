/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.cilj;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija koja brise cilj iz baze podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SODeleteCilj extends AbstractSO {

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
        if (!(ado instanceof Cilj)) {
            throw new Exception("Prosledjeni objekat nije instanca klase Cilj!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {
        DBBroker.getInstance().delete(ado);
        uspesno=true;
    }

}
