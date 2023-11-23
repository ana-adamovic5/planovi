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
 * Predstavlja tip aktivnosti. Tip aktivnosti ima definisan identifikator i naziv.
 * 
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 * 
 * @author Ana Adamovic
 */
public class TipAktivnosti extends AbstractDomainObject{
    
    /**
     * Identifikator tipa aktivnosti kao ceo broj.
     */
    private Long tipAktivnostiID;
    
    /**
     * Naziv tipa aktivnosti kao String.
     */
    private String nazivTipaAktivnosti;

    /**
     * Parametarski konstruktor koji postavlja vrednosti za identifikator i naziv tipa aktivnosti.
     * 
     * @param tipAktivnostiID  nova vrednost za identifikator tipa aktivnosti
     * @param nazivTipaAktivnosti  nova vrednost za naziv tipa aktivnosti
     */
    public TipAktivnosti(Long tipAktivnostiID, String nazivTipaAktivnosti) {
        this.tipAktivnostiID = tipAktivnostiID;
        this.nazivTipaAktivnosti = nazivTipaAktivnosti;
    }

    /**
     * Bezparametarski konstruktor
     */
    public TipAktivnosti() {
    }
    
    @Override
    public String toString() {
        return nazivTipaAktivnosti;
    }
    @Override
    public String nazivTabele() {
        return " TipAktivnosti ";
    }

    @Override
    public String alijas() {
        return " ta ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            TipAktivnosti ta = new TipAktivnosti(rs.getLong("TipAktivnostiID"),
                    rs.getString("NazivTipaAktivnosti"));

            lista.add(ta);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TipAktivnostiID = " + tipAktivnostiID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return "";
    }

     /**
     * Vraca identifikator tipa aktivnosti.
     *
     * @return identifikator tipa aktivnosti kao ceo broj
     */
    public Long getTipAktivnostiID() {
        return tipAktivnostiID;
    }

    /**
     * Postavlja vrednost identifikatora tipa aktivnosti.
     *
     * @param tipAktivnostiID identifikator tipa aktivnosti kao ceo broj
     */
    public void setTipAktivnostiID(Long tipAktivnostiID) {
        this.tipAktivnostiID = tipAktivnostiID;
    }

    /**
     * Vraca vrednost atributa naziv tip aktivnosti.
     *
     * @return naziv tipa aktivnosti kao String
     */
    public String getNazivTipaAktivnosti() {
        return nazivTipaAktivnosti;
    }

    /**
     * Postavlja vrednost atributa naziv tip aktivnosti.
     *
     * @param nazivTipaAktivnosti naziv tipa aktivnosti kao String
     */
    public void setNazivTipaAktivnosti(String nazivTipaAktivnosti) {
        this.nazivTipaAktivnosti = nazivTipaAktivnosti;
    }
    
}
