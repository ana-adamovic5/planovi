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
 *
 * @author adamo
 */
public class SOLogin extends AbstractSO {
    
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

    public Korisnik getUlogovani() {
        return ulogovani;
    }
    
    

}
