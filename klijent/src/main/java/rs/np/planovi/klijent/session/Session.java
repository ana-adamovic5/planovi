/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.session;

import rs.np.planovi.zajednicki.domain.Korisnik;
import java.io.IOException;
import java.net.Socket;

/**
 * Klasa omogucava komunikaciju sa serverom putem soketa.
 * 
 * Implementira Singleton obrazac dizajna kako bi se obezbedila samo jedna instanca klase za celu aplikaciju.
 * 
 * @author Ana Adamovic
 */
public class Session {

    /**
     * Staticka instanca sesije.
     */
    private static Session instance;
    
    /**
     * Instanca soketa za komunikaciju.
     */
    private Socket socket;
    
    /**
     * Prijavljeni korisnisnik na sistem.
     */
    private Korisnik ulogovani;

     /**
     * Bezparametarski konstruktor klase.
     * Inicijalizuje socket i povezuje se sa serverom na zadatoj adresi i portu.
     * U slucaju da server nije pokrenut, prikazuje se odgovarajuca poruka korisniku.
     */
    private Session() {
        try {
            socket = new Socket("localhost", 11111);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Vraca staticku instancu sesije.
     * 
     * @return instanca sesije
     */
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    /**
     * Vraca soket za komunikaciju.
     * 
     * @return soket 
     */
    public Socket getSocket() {
        return socket;
    }

    /**
     * Postavlja prijavljenog korisnika.
     * 
     * @param ulogovani prijavljeni korisnik
     */
    public void setUlogovani(Korisnik ulogovani) {
        this.ulogovani = ulogovani;
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
