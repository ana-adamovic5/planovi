/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja belesku koju korisnik moze da unosi, cita, menja i brise iz sistema.
 * Beleska ima definisan identifikator, naslov, sadrzaj i korisnika.
 * 
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 * 
 * @author Ana Adamovic
 */
public class Beleska extends AbstractDomainObject{
    
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
            Korisnik k=new Korisnik(rs.getLong("KorisnikID"), rs.getString("Ime"), 
                    rs.getString("Prezime"), rs.getString("Username"),rs.getString("Password"));
            
            Beleska b=new Beleska(rs.getLong("BeleskaID"),rs.getString("Naslov"), rs.getString("Sadrzaj"), k );

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
        return "'" + naslov + "', '"+ sadrzaj + "', "+korisnik.getKorisnikID()+" ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " naslov = '" + naslov + "', sadrzaj = '"+sadrzaj+ "'";
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
     * @param beleskaID identifikator beleske kao ceo broj
     */
    public void setBeleskaID(Long beleskaID) {
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
     * @param sadrzaj sadrzaj beleske kao String
     */
    public void setSadrzaj(String sadrzaj) {
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
     * @param korisnik  korisnik kao objekat klase Korisnik
     */
    public void setKorisnik(Korisnik korisnik) {
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
     * @param naslov naslov beleske kao String
     */
    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
    
}
