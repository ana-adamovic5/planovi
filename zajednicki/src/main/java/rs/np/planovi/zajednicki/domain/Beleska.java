/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja belesku koju korisnik moze da unosi, cita, menja i brise iz
 * sistema. Beleska ima definisan identifikator, naslov, sadrzaj i korisnika.
 *
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class Beleska extends AbstractDomainObject {

    /**
     * Identifikator beleske kao ceo broj.
     */
    private Long beleskaID;

    /**
     * Naslov beleske kao string.
     */
    private String naslov;

    /**
     * Sadrzaj beleske kao string.
     */
    private String sadrzaj;

    /**
     * Korisnik kao spoljni kljuc povezan sa klasom Korisnik.
     */
    private Korisnik korisnik;

    /**
     * Bezparametarski konstruktor
     */
    public Beleska() {
    }

    public Beleska(Long beleskaID, String naslov, String sadrzaj, Korisnik korisnik) {
        this.beleskaID = beleskaID;
        this.naslov = naslov;
        this.sadrzaj = sadrzaj;
        this.korisnik = korisnik;
    }

    @Override
    public String nazivTabele() {
        return " Beleska ";
    }

    @Override
    public String alijas() {
        return " b ";
    }

    @Override
    public String join() {
        return " JOIN KORISNIK K ON (B.KORISNIKID = K.KORISNIKID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Korisnik k = new Korisnik(rs.getLong("KorisnikID"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getString("Username"), rs.getString("Password"));

            Beleska b = new Beleska(rs.getLong("BeleskaID"), rs.getString("Naslov"), rs.getString("Sadrzaj"), k);

            lista.add(b);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (naslov, sadrzaj, korisnikid) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " BeleskaID = " + beleskaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + naslov + "', '" + sadrzaj + "', " + korisnik.getKorisnikID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " naslov = '" + naslov + "', sadrzaj = '" + sadrzaj + "'";
    }

    @Override
    public String uslov() {
        return "";
    }

    /**
     * Vraca identifikator beleske.
     *
     * @return identifikator beleske kao ceo broj
     */
    public Long getBeleskaID() {
        return beleskaID;
    }

    /**
     * Postavlja vrednost identifikatora beleske.
     *
     * Identifikator mora biti veci od nule.
     *
     * @param beleskaID identifikator beleske kao ceo broj
     * @throws IllegalArgumentException ako se unese ID manji od 1
     */
    public void setBeleskaID(Long beleskaID) {
        if (beleskaID <= 0) {
            throw new IllegalArgumentException("ID ne sme biti nula ili manji.");
        }
        this.beleskaID = beleskaID;
    }

    /**
     * Vraca sadrzaj beleske.
     *
     * @return sadrzaj beleske kao String
     */
    public String getSadrzaj() {
        return sadrzaj;
    }

    /**
     * Postavlja vrednost atributa sadrzaj.
     *
     * Sadrzaj beleske ne sme biti null.
     *
     * @param sadrzaj sadrzaj beleske kao String
     * @throws NullPointerException ako se unese sadrzaj beleske koji je null
     */
    public void setSadrzaj(String sadrzaj) {
        if (sadrzaj == null) {
            throw new NullPointerException("Sadrzaj beleske ne sme biti null.");
        }
        this.sadrzaj = sadrzaj;
    }

    /**
     * Vraca korisnika.
     *
     * @return korisnik kao objekat klase Korisnik
     */
    public Korisnik getKorisnik() {
        return korisnik;
    }

    /**
     * Postavlja vrednost atributa korisnik.
     *
     * Korisnik beleske ne sme biti null.
     *
     * @param korisnik korisnik kao objekat klase Korisnik
     * @throws NullPointerException ako je korisnik beleske null
     */
    public void setKorisnik(Korisnik korisnik) {
        if (korisnik == null) {
            throw new NullPointerException("Korisnik ne sme biti null.");
        }
        this.korisnik = korisnik;
    }

    /**
     * Vraca naslov beleske.
     *
     * @return naslov beleske kao String
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Postavlja vrednost atributa naslov.
     *
     * Naslov beleske ne sme biti null.
     *
     * @param naslov naslov beleske kao String
     * @throws NullPointerException ako je unet naslov beleske null
     */
    public void setNaslov(String naslov) {
        if (naslov == null) {
            throw new NullPointerException("Naslov beleske ne sme biti null");
        }
        this.naslov = naslov;
    }

}
