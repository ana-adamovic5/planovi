/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so.nedeljniPlan;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import java.util.Date;
import rs.np.planovi.server.so.AbstractSO;

/**
 * Sistemska operacija koja menja nedeljni plan u bazi podataka.
 *
 * Nasledjuje klasu AbstractSO i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class SOUpdateNedeljniPlan extends AbstractSO {

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
        if (!(ado instanceof NedeljniPlan)) {
            throw new Exception("Prosledjeni objekat nije instanca klase NedeljniPlan!");
        }

        NedeljniPlan np = (NedeljniPlan) ado;

        if (!np.getDatumOd().after(new Date())) {
            throw new Exception("Datum od mora biti posle danasnjeg datuma!");
        }

        if (!np.getDatumOd().before(np.getDatumDo())) {
            throw new Exception("Datum od mora biti pre datum do!");
        }

        if (np.getDnevneAktivnosti().size() < 3) {
            throw new Exception("Nedeljni plan mora imati barem 3 dnevne aktivnosti!");
        }

    }

    @Override
    protected void execute(AbstractDomainObject ado) throws Exception {

        DBBroker.getInstance().update(ado);

        NedeljniPlan np = (NedeljniPlan) ado;
        DBBroker.getInstance().delete(np.getDnevneAktivnosti().get(0));

        for (DnevnaAktivnost dnevnaAktivnost : np.getDnevneAktivnosti()) {
            DBBroker.getInstance().insert(dnevnaAktivnost);
        }
        uspesno=true;
    }

}
