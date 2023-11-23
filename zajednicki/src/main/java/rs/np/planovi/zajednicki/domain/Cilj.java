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
 * Predstavlja cilj koji korisnik moze da unosi, cita, menja i brise iz sistema.
 * Cilj ima definisan identifikator, naziv, opis i kategoriju.
 * 
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class Cilj extends AbstractDomainObject {

    /**
     * Identifikator cilja kao ceo broj.
     */
    private Long ciljID;

    /**
     * Naziv cilja kao string.
     */
    private String nazivCilja;

    /**
     * Opis cilja kao string.
     */
    private String opisCilja;

    /**
     * Kategorija cilja kao spoljni kljuc povezan sa klasom KategorijaCilja.
     */
    private KategorijaCilja kategorijaCilja;

    public Cilj(Long ciljID, String nazivCilja, String opisCilja, KategorijaCilja kategorijaCilja) {
        this.ciljID = ciljID;
        this.nazivCilja = nazivCilja;
        this.opisCilja = opisCilja;
        this.kategorijaCilja = kategorijaCilja;
    }

    /**
     * Bezparametarski konstruktor
     */
    public Cilj() {
    }

    @Override
    public String toString() {
        return nazivCilja;
    }

    @Override
    public String nazivTabele() {
        return " Cilj ";
    }

    @Override
    public String alijas() {
        return " c ";
    }

    @Override
    public String join() {
        return " JOIN KATEGORIJACILJA KC ON (C.KATEGORIJAID = KC.KATEGORIJAID) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            KategorijaCilja kc = new KategorijaCilja(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));

            Cilj c = new Cilj(rs.getLong("CiljID"),
                    rs.getString("nazivCilja"), rs.getString("opisCilja"), kc);

            lista.add(c);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nazivCilja, opisCilja, kategorijaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " CiljID = " + ciljID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivCilja + "', '" + opisCilja + "', '" + kategorijaCilja.getKategorijaID() + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " nazivCilja = '" + nazivCilja + "', opisCilja = '" + opisCilja + "', kategorijaID= '" + kategorijaCilja.getKategorijaID() + "'";
    }

    @Override
    public String uslov() {
        return "";
    }

    /**
     * Vraca identifikator cilja.
     *
     * @return identifikator cilja kao ceo broj
     */
    public Long getCiljID() {
        return ciljID;
    }

    /**
     * Postavlja vrednost identifikatora cilja.
     *
     * @param ciljID identifikator cilja kao ceo broj
     */
    public void setCiljID(Long ciljID) {
        this.ciljID = ciljID;
    }

    /**
     * Vraca naziv cilja.
     *
     * @return naziv cilja kao String
     */
    public String getNazivCilja() {
        return nazivCilja;
    }

    /**
     * Postavlja vrednost atributa naziv.
     *
     * @param nazivCilja naziv cilja kao String
     */
    public void setNazivCilja(String nazivCilja) {
        this.nazivCilja = nazivCilja;
    }

    /**
     * Vraca opis cilja.
     *
     * @return opis cilja kao String
     */
    public String getOpisCilja() {
        return opisCilja;
    }

    /**
     * Postavlja vrednost atributa opis.
     *
     * @param opisCilja opis cilja kao String
     */
    public void setOpisCilja(String opisCilja) {
        this.opisCilja = opisCilja;
    }

    /**
     * Vraca kategoriju cilja.
     *
     * @return kategorija cilja kao objekat klase KategorijaCilja
     */
    public KategorijaCilja getKategorijaCilja() {
        return kategorijaCilja;
    }

    /**
     * Postavlja vrednost atributa kategorija cilja.
     *
     * @param kategorijaCilja kategorija cilja kao objekat klase KategorijaCilja
     */
    public void setKategorijaCilja(KategorijaCilja kategorijaCilja) {
        this.kategorijaCilja = kategorijaCilja;
    }

}
