/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

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
     * Parametarski konstruktor koji postavlja vrednosti za identifikator, ime,
     * prezime, username i password korisnika.
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
     * Identifikator mora biti veci od nule.
     *
     * @param korisnikID identifikator korisnika kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setKorisnikID(Long korisnikID) {
        if (korisnikID <= 0) {
            throw new IllegalArgumentException("ID korisnika ne sme biti nula ili manji");
        }

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
     * Username ne sme biti null niti prazan String.
     *
     * @param username username korisnika kao String
     * @throws NullPointerException ako se unese null vrednost za username
     * @throws IllegalArgumentException ako se unese prazan String kao username
     */
    public void setUsername(String username) {
        if (username == null) {
            throw new NullPointerException("Username ne sme biti null.");
        }

        if (username.isEmpty()) {
            throw new IllegalArgumentException("Username ne sme biti prazan String.");
        }

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
     * Password ne sme biti null niti prazan String.
     *
     * @param password password korisnika kao String
     * @throws NullPointerException ako se unese null vrednost za password
     * @throws IllegalArgumentException ako se unese prazan String za password
     */
    public void setPassword(String password) {
        if(password==null)
            throw new NullPointerException("Password ne sme biti null.");
        if(password.isEmpty())
            throw new IllegalArgumentException("Password ne sme biti prazan String.");
        
        this.password=password;
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
     * Ime korisnika ne sme biti null.
     *
     * @param ime ime korisnika kao String
     */
    public void setIme(String ime) {
        if(ime==null)
            throw new NullPointerException("Ime korisnika ne sme biti null.");
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
     * Prezime korisnika ne sme biti null.
     *
     * @param prezime prezime korisnika kao String
     */
    public void setPrezime(String prezime) {
        if(prezime==null)
            throw new NullPointerException("Prezime korisnika ne sme biti null.");
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

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Korisnik other = (Korisnik) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        return Objects.equals(this.prezime, other.prezime);
    }

}
