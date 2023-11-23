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
 * Predstavlja aktivnost koju korisnik definise za sastavljanje svojih
 * planova. Aktivnost ima definisan identifikator, naziv, opis i tip.
 * 
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class Aktivnost extends AbstractDomainObject {

    /**
     * Identifikator aktivnosti kao ceo broj.
     */
    private Long aktivnostID;

    /**
     * Naziv aktivnosti kao string.
     */
    private String nazivAktivnosti;

    /**
     * Opis aktivnosti kao string.
     */
    private String opisAktivnosti;

    /**
     * Tip aktivnosti kao spoljni kljuc povezan sa klasom TipAktivnosti.
     */
    private TipAktivnosti tipAktivnosti;

    public Aktivnost(Long aktivnostID, String nazivAktivnosti, String opisAktivnosti, TipAktivnosti tipAktivnosti) {
        this.aktivnostID = aktivnostID;
        this.nazivAktivnosti = nazivAktivnosti;
        this.opisAktivnosti = opisAktivnosti;
        this.tipAktivnosti = tipAktivnosti;
    }

    /**
     * Bezparametarski konstruktor
     */
    public Aktivnost() {
    }

    @Override
    public String toString() {
        return nazivAktivnosti;
    }

    @Override
    public String nazivTabele() {
        return " Aktivnost ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return " JOIN TIPAKTIVNOSTI TA ON (A.TIPAKTIVNOSTIID = TA.TIPAKTIVNOSTIID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            TipAktivnosti ta = new TipAktivnosti(rs.getLong("TipAktivnostiID"),
                    rs.getString("NazivTipaAktivnosti"));

            Aktivnost a = new Aktivnost(rs.getLong("aktivnostID"),
                    rs.getString("nazivAktivnosti"), rs.getString("opisAktivnosti"), ta);

            lista.add(a);
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
        return " aktivnostID = " + aktivnostID;
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
     * Vraca identifikator aktivnosti.
     *
     * @return identifikator aktivnosti kao ceo broj
     */
    public Long getAktivnostID() {
        return aktivnostID;
    }

    /**
     * Postavlja vrednost identifikatora aktivnosti.
     *
     * @param aktivnostID identifikator aktivnosti kao ceo broj
     */
    public void setAktivnostID(Long aktivnostID) {
        this.aktivnostID = aktivnostID;
    }

    /**
     * Vraca naziv aktivnosti.
     *
     * @return naziv aktivnosti kao String
     */
    public String getNazivAktivnosti() {
        return nazivAktivnosti;
    }

    /**
     * Postavlja vrednost atributa naziv aktivnosti.
     *
     * @param nazivAktivnosti naziv aktivnosti kao String
     */
    public void setNazivAktivnosti(String nazivAktivnosti) {
        this.nazivAktivnosti = nazivAktivnosti;
    }

    /**
     * Vraca opis aktivnosti.
     *
     * @return opis aktivnosti kao String
     */
    public String getOpisAktivnosti() {
        return opisAktivnosti;
    }

    /**
     * Postavlja vrednost atributa opis aktivnosti.
     *
     * @param opisAktivnosti opis aktivnosti kao String
     */
    public void setOpisAktivnosti(String opisAktivnosti) {
        this.opisAktivnosti = opisAktivnosti;
    }

    /**
     * Vraca tip aktivnosti.
     *
     * @return tip aktivnosti kao objekat klase TipAktivnosti
     */
    public TipAktivnosti getTipAktivnosti() {
        return tipAktivnosti;
    }

    /**
     * Postavlja vrednost tipa aktivnosti.
     *
     * @param tipAktivnosti  tip aktivnosti kao objekat klase TipAktivnosti
     */
    public void setTipAktivnosti(TipAktivnosti tipAktivnosti) {
        this.tipAktivnosti = tipAktivnosti;
    }

}
