/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.so;

import rs.np.planovi.server.db.DBBroker;
import rs.np.planovi.zajednicki.domain.AbstractDomainObject;
import java.sql.SQLException;

/**
 * Apstraktna klasa u kojoj se nalaze apstraktne metode koje se implementiraju
 * razlicito za svaku sistemsku operaciju i commit,rollback i templateExecute
 * metode.
 *
 * @author Ana Adamovic
 */
public abstract class AbstractSO {

    /**
     * Validacija prosledjenog objekta.
     *
     * @param ado objekat validacije
     * @throws Exception ukoliko objekat nije instanca odgovarajuce klase ili
     * nisu zadovoljeni uslovi validacije
     */
    protected abstract void validate(AbstractDomainObject ado) throws Exception;

    /**
     * Izvrsenje sistemske operacije.
     *
     * @param ado objekat sistemske operacije
     * @throws SQLException ukoliko je neispravan sql upit
     */
    protected abstract void execute(AbstractDomainObject ado) throws Exception;

    /**
     * Metoda u kojoj se radi validacija, izvrsenje i potvrdjivanje, odnosno
     * ponistavanje efekata sistemske operacije. Predstavlja sablon izvrsenja
     * sistemske operacije.
     *
     * @param ado objekat sistemske operacije
     * @throws Exception ukoliko dodje do greske pri nekoj od metoda u okviru sablona
     */
    public void templateExecute(AbstractDomainObject ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    /**
     * Cuvanje izmena u bazi podataka.
     * 
     * @throws SQLException ukoliko je neispravan sql upit
     */
    public void commit() throws SQLException {
        DBBroker.getInstance().getConnection().commit();
    }

    /**
     * Ponistavanje izmena u bazi podataka.
     * 
     * @throws SQLException ukoliko je neispravan sql upit
     */
    public void rollback() throws SQLException {
        DBBroker.getInstance().getConnection().rollback();
    }
}
