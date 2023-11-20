/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author adamo
 */
public class Beleska extends AbstractDomainObject{
    
    private Long beleskaID;
    private String naslov;
    private String sadrzaj;
    private Korisnik korisnik;

// 
//    @Override
//    public String toString() {
//        return "";
//    }

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

    public Long getBeleskaID() {
        return beleskaID;
    }

    public void setBeleskaID(Long beleskaID) {
        this.beleskaID = beleskaID;
    }

    public String getSadrzaj() {
        return sadrzaj;
    }

    public void setSadrzaj(String sadrzaj) {
        this.sadrzaj = sadrzaj;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }
    
}
