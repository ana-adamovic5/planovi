/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Predstavlja kategoriju kojoj cilj pripada. Kategorija cilja ima definisan
 * identifikator i naziv.
 *
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class KategorijaCilja extends AbstractDomainObject {

    /**
     * Identifikator kategorije cilja kao ceo broj.
     */
    private Long kategorijaID;

    /**
     * Naziv kategorije cilja kao String.
     */
    private String nazivKategorije;

    /**
     * Bezparametarski konstruktor
     */
    public KategorijaCilja() {
    }

    /**
     * Parametarski konstruktor koji postavlja vrednosti za identifikator i
     * naziv kategorije cilja.
     *
     * @param kategorijaID nova vrednost za identifikator kategorije cilja
     * @param nazivKategorije nova vrednost za naziv kategorije cilja
     */
    public KategorijaCilja(Long kategorijaID, String nazivKategorije) {
        this.kategorijaID = kategorijaID;
        this.nazivKategorije = nazivKategorije;
    }

    /**
     * Vraca identifikator kategorije cilja.
     *
     * @return identifikator kategorije cilja kao ceo broj
     */
    public Long getKategorijaID() {
        return kategorijaID;
    }

    /**
     * Postavlja vrednost identifikatora kategorije cilja.
     *
     * Identifikator mora biti veci od nule.
     *
     * @param kategorijaID identifikator kategorije cilja kao ceo broj
     * @throws IllegalArgumentException ako se unese id koji je manji od 1
     */
    public void setKategorijaID(Long kategorijaID) {
        if (kategorijaID <= 0) {
            throw new IllegalArgumentException("ID kategorije cilja ne sme biti manji od 1.");
        }
        this.kategorijaID = kategorijaID;
    }

    /**
     * Vraca naziv kategorije cilja.
     *
     * @return naziv kategorije cilja kao String
     */
    public String getNazivKategorije() {
        return nazivKategorije;
    }

    /**
     * Postavlja vrednost atributa naziv kategorije cilja.
     *
     * Naziv kategorije cilja ne sme biti null.
     *
     * @param nazivKategorije naziv cilja kao String
     * @throws NullPointerException ako se unese naziv kategorije cilja koji je
     * null
     */
    public void setNazivKategorije(String nazivKategorije) {
        if (nazivKategorije == null) {
            throw new NullPointerException("Naziv kategorije cilja ne sme biti null.");
        }
        this.nazivKategorije = nazivKategorije;
    }

    @Override
    public String toString() {
        return nazivKategorije;
    }

    @Override
    public String nazivTabele() {
        return " KategorijaCilja ";
    }

    @Override
    public String alijas() {
        return " kc ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            KategorijaCilja kc = new KategorijaCilja(rs.getLong("KategorijaID"),
                    rs.getString("NazivKategorije"));

            lista.add(kc);
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
        return " KategorijaID = " + kategorijaID;
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
}
