/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.zajednicki.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Predstavlja nedeljni plan koji korisnik unosi, cita, menja i brise iz
 * sistema. Nedeljni plan ima definisan identifikator, datum pocetka i datum
 * zavrsetkaf, cilj, korisnika i listu dnevnih aktivnosti.
 *
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class NedeljniPlan extends AbstractDomainObject {

    /**
     * Identifikator nedelljnog plana kao ceo broj.
     */
    private Long nedeljniPlanID;

    /**
     * Datum pocetka nedeljnog plana kao objekat klase Date.
     */
    private Date datumOd;

    /**
     * Datum zavrsetka nedeljnog plana kao objekat klase Date.
     */
    private Date datumDo;

    /**
     * Cilj kao spoljni kljuc povezan sa klasom Cilj.
     */
    private Cilj cilj;

    /**
     * Korisnik kao spoljni kljuc povezan sa klasom Korisnik.
     */
    private Korisnik korisnik;

    /**
     * Lista dnevnih aktivnosti.
     *
     * Nedeljni plan mora da ima barem tri dnevne aktivnosti.
     */
    private ArrayList<DnevnaAktivnost> dnevneAktivnosti;

    /**
     * Parametarski konstruktor koji postavlja vrednosti za identifikator, datum
     * pocetka, datum zavrsetka, cilj, korisnika i listu dnevnih aktivnosti.
     *
     * @param nedeljniPlanID nova vrednost za identifikator nedeljnog plana
     * @param datumOd nova vrednost za datum pocetka nedeljnog plana
     * @param datumDo nova vrednost za datum zavrsetka nedeljnog plana
     * @param cilj nova vrednost za cilj nedeljnog plana
     * @param korisnik nova vrednost za korisnika nedeljnog plana
     * @param dnevneAktivnosti nova vrednost za listu dnevnih aktivnosti
     * nedeljnog plana
     */
    public NedeljniPlan(Long nedeljniPlanID, Date datumOd, Date datumDo, Cilj cilj, Korisnik korisnik, ArrayList<DnevnaAktivnost> dnevneAktivnosti) {
        this.nedeljniPlanID = nedeljniPlanID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.cilj = cilj;
        this.korisnik = korisnik;
        this.dnevneAktivnosti = dnevneAktivnosti;
    }

    /**
     * Bezparametarski konstruktor
     */
    public NedeljniPlan() {
    }

    @Override
    public String nazivTabele() {
        return " NedeljniPlan ";
    }

    @Override
    public String alijas() {
        return " np ";
    }

    @Override
    public String join() {
        return " JOIN CILJ C ON (C.CILJID = NP.CILJID) "
                + "JOIN KORISNIK K ON (K.KORISNIKID = NP.KORISNIKID) "
                + "JOIN KATEGORIJACILJA KC ON (C.KATEGORIJAID = KC.KATEGORIJAID)";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Korisnik k = new Korisnik(rs.getLong("KorisnikID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("Username"), rs.getString("Password"));

            KategorijaCilja kc = new KategorijaCilja(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));

            Cilj c = new Cilj(rs.getLong("CiljID"),
                    rs.getString("nazivCilja"), rs.getString("opisCilja"), kc);

            NedeljniPlan np = new NedeljniPlan(rs.getLong("nedeljniPlanID"),
                    rs.getDate("datumOd"), rs.getDate("datumDo"), c, k, null);

            lista.add(np);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (datumOd, datumDo, CiljID, KorisnikID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " nedeljniPlanID = " + nedeljniPlanID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new java.sql.Date(datumOd.getTime()) + "', "
                + "'" + new java.sql.Date(datumDo.getTime()) + "', "
                + cilj.getCiljID() + ", " + korisnik.getKorisnikID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return " DatumOd = '" + new java.sql.Date(datumOd.getTime()) + "', "
                + "DatumDo = '" + new java.sql.Date(datumDo.getTime()) + "', "
                + "CiljID = " + cilj.getCiljID();
    }

    @Override
    public String uslov() {
        return "";
    }

    /**
     * Vraca identifikator nedeljnog plana.
     *
     * @return identifikator nedeljnog plana kao ceo broj
     */
    public Long getNedeljniPlanID() {
        return nedeljniPlanID;
    }

    /**
     * Postavlja vrednost identifikatora nedeljnog plana.
     *
     * Identifikator mora biti veci od nule.
     *
     * @param nedeljniPlanID identifikator nedeljnog plana kao ceo broj
     * @throws IllegalArgumentException ako je ID manji od 1
     */
    public void setNedeljniPlanID(Long nedeljniPlanID) {
        if (nedeljniPlanID <= 0) {
            throw new IllegalArgumentException("ID ne sme biti nula ili manje.");
        }
        this.nedeljniPlanID = nedeljniPlanID;
    }

    /**
     * Vraca datum pocetka nedeljnog plana.
     *
     * @return datum pocetka nedeljnog plana kao objekat klase Date
     */
    public Date getDatumOd() {
        return datumOd;
    }

    /**
     * Postavlja vrednost datuma pocetka nedeljnog plana.
     *
     * Datum pocetka nedeljnog plana ne sme biti null.
     *
     * @param datumOd datum pocetka nedeljnog plana kao objekat klase Date
     * @throws NullPointerException ako je uneti datum pocetka nedeljnog plana
     * null
     */
    public void setDatumOd(Date datumOd) {
        if (datumOd == null) {
            throw new NullPointerException("Datum pocetka nedeljnog plana ne sme biti null.");
        }
        this.datumOd = datumOd;
    }

    /**
     * Vraca datum zavrsetka nedeljnog plana.
     *
     * @return datum zavrsetka nedeljnog plana kao objekat klase Date
     */
    public Date getDatumDo() {
        return datumDo;
    }

    /**
     * Postavlja vrednost datuma zavrsetka nedeljnog plana.
     *
     * Datum zavrsetka nedeljnog plana ne sme biti null.
     *
     * @param datumDo datum zavrsetka nedeljnog plana kao objekat klase Date
     * @throws NullPointerException ako je uneti datum zavrsetka nedeljnog plana
     * null
     */
    public void setDatumDo(Date datumDo) {
        if (datumDo == null) {
            throw new NullPointerException("Datum zavrsetka nedeljnog plana ne sme biti null.");
        }
        this.datumDo = datumDo;
    }

    /**
     * Vraca cilj nedeljnog plana.
     *
     * @return cilj nedeljnog plana kao objekat klase Cilj
     */
    public Cilj getCilj() {
        return cilj;
    }

    /**
     * Postavlja vrednost atributa cilj.
     *
     * Cilj nedeljnog plana ne sme biti null.
     *
     * @param cilj cilj kao objekat klase Cilj
     * @throws NullPointerException ako je uneti cilj nedeljnog plana null
     */
    public void setCilj(Cilj cilj) {
        if (cilj == null) {
            throw new NullPointerException("Cilj nedeljnog plana ne sme biti null.");
        }
        this.cilj = cilj;
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
     * Korisnik nedeljnog plana ne sme biti null.
     *
     * @param korisnik korisnik kao objekat klase Korisnik
     * @throws NullPointerException ako je uneti korisnik nedeljnog plana null
     */
    public void setKorisnik(Korisnik korisnik) {
        if (korisnik == null) {
            throw new NullPointerException("Korisnik nedeljnog plana ne sme biti null.");

        }
        this.korisnik = korisnik;
    }

    /**
     * Vraca listu dnevnih aktivnosti nedeljnog plana.
     *
     * @return lista dnevnih aktivnosti
     */
    public ArrayList<DnevnaAktivnost> getDnevneAktivnosti() {
        return dnevneAktivnosti;
    }

    /**
     * Postavlja listu dnevnih aktivnosti.
     *
     * Lista dnevnih aktivnosti ne sme biti null i mora imati minimum 3 dnevne
     * aktivnosti.
     *
     * @param dnevneAktivnosti lista sa dnevnim aktivnostima.
     */
    public void setDnevneAktivnosti(ArrayList<DnevnaAktivnost> dnevneAktivnosti) {
        if (dnevneAktivnosti == null) {
            throw new NullPointerException("Lista dnevnih aktivnosti ne sme biti null.");
        }
        if (dnevneAktivnosti.size() < 3) {
            throw new IllegalArgumentException("Lista mora imati minimum 3 dnevne aktivnosti.");
        }
        this.dnevneAktivnosti = dnevneAktivnosti;
    }

}
