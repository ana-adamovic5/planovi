/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja korisnika sistema koji se prijavljuje na sistem i pravi nedeljne
 * planove za definisane ciljeve. Korisnik ima definisan identifikator, ime,
 * prezime, korisnicko ime i sifru.
 * 
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class Korisnik extends AbstractDomainObject {

    /**
     * Identifikator korisnika kao ceo broj.
     */
    private Long korisnikID;

    /**
     * Ime korisnika kao String.
     */
    private String ime;

    /**
     * Prezime korisnika kao String.
     */
    private String prezime;

    /**
     * Username korisnika kao String.
     */
    private String username;

    /**
     * Password korisnika kao Stirng.
     */
    private String password;

    /**
     * Bezparametarski konstruktor
     */
    public Korisnik() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za identifikator, ime, prezime, username i password korisnika.
     * 
     * @param korisnikID nova vrednost za identifikator korisnika
     * @param ime nova vrednost za ime korisnika
     * @param prezime nova vrednost za prezime korisnika
     * @param username nova vrednost za username korisnika
     * @param password nova vrednost za password korisnika
     */
    public Korisnik(Long korisnikID, String ime, String prezime, String username, String password) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }

    /**
     * Vraca identifikator korisnika.
     *
     * @return identifikator korisnika kao ceo broj
     */
    public Long getKorisnikID() {
        return korisnikID;
    }

    /**
     * Postavlja vrednost identifikatora korisnika.
     *
     * @param korisnikID identifikator korisnika kao ceo broj
     */
    public void setKorisnikID(Long korisnikID) {
        this.korisnikID = korisnikID;
    }

    /**
     * Vraca vrednost atributa username.
     *
     * @return username korisnika kao String
     */
    public String getUsername() {
        return username;
    }

    /**
     * Postavlja vrednost atributa username korisnika.
     *
     * @param username username korisnika kao String
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Vraca vrednost atributa password.
     *
     * @return password korisnika kao String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Postavlja vrednost atributa password korisnika.
     *
     * @param password password korisnika kao String
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Vraca vrednost atributa ime.
     *
     * @return ime korisnika kao String
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja vrednost atributa ime korisnika.
     *
     * @param ime ime korisnika kao String
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca vrednost atributa prezime.
     *
     * @return prezime korisnika kao String
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja vrednost atributa prezime korisnika.
     *
     * @param prezime prezime korisnika kao String
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return " korisnik ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Korisnik k = new Korisnik(rs.getLong("KorisnikID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            lista.add(k);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, Username, Password) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " korisnikID = " + korisnikID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + username + "', '" + password + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', "
                + "Username = '" + username + "', Password = '" + password + "' ";
    }

    @Override
    public String uslov() {
        return "";
    }

}
