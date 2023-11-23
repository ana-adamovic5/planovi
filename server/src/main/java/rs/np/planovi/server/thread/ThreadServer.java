/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.server.thread;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Klasa koja predstavlja serversku nit i omogucava pokretanje servera i prihvatanje klijentskih konekcija.
 * 
 * Nasledjuje klasu Thread i implementira run() metodu.
 * 
 * @author Ana Adamovic
 */
public class ThreadServer extends Thread {

    /**
     * Instanca serverskog soketa za prihvatanje konekcije sa klijentom.
     */
    private ServerSocket serverSocket;

    /**
     * Konstruktor koji vrsi podizanje serverskog soketa i zauzimanje porta.
     */
    public ThreadServer() {
        try {
            serverSocket = new ServerSocket(11111);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda run() klase Thread koja se izvrsava prilikom pokretanja niti.
     * Vrsi pokretanje servera i prihvatanje klijentskih konekcija.
     */
    @Override
    public void run() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao!");
                ThreadClient th = new ThreadClient(socket);
                th.start();
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    /**
     * Vraca serverski soket.
     * 
     * @return serverski soket
     */
    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    /**
     * Postavlja vrednost serverskog soketa.
     * 
     * @param serverSocket serverski soket
     */
    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

}
