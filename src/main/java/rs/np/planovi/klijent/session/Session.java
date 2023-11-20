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
 *
 * @author adamo
 */
public class Session {

    private static Session instance;
    private Socket socket;
    private Korisnik ulogovani;

    private Session() {
        try {
            socket = new Socket("localhost", 11111);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setUlogovani(Korisnik ulogovani) {
        this.ulogovani = ulogovani;
    }

    public Korisnik getUlogovani() {
        return ulogovani;
    }

}
