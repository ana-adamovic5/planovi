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
 * Predstavlja dnevnu aktivnost koju korisnik definise za sastavljanje svojih planova.
 * Dnevna aktivnost ima definisan nedeljni plan kome pripada, redni broj, datum, beleske i aktivnost.
 * 
 * Nasledjuje klasu AbstractDomainObject i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class DnevnaAktivnost extends AbstractDomainObject {

    /**
     * Nedeljni plan kao primarni i spoljni kljuc povezan sa klasom NedeljniPlan.
     */
    private NedeljniPlan nedeljniPlan;
    
    /**
     * Redni broj dnevne aktivnosti kao ceo broj.
     */
    private int rb;
    
    /**
     * Datum aktivnosti kao objekat klase Date.
     */
    private Date datumAktivnosti;
    
    /**
     * Beleske dnevne aktivnosti kao String.
     */
    private String beleske;
    
    /**
     * Aktivnosti kao spoljni kljuc povezan sa klasom Aktivnost.
     */
    private Aktivnost aktivnost;

     /**
     * Parametarski konstruktor koji postavlja vrednosti za nedeljni plan, redni broj, datum aktivnosti,
     * beleske i aktivnost.
     * 
     * @param nedeljniPlan nova vrednost za nedeljni plan dnevne aktivnosti
     * @param rb nova vrednost za redni broj dnevne aktivnosti
     * @param datumAktivnosti nova vrednost za datum dnevne aktivnosti
     * @param beleske nova vrednost za beleske dnevne aktivnosti
     * @param aktivnost nova vrednost za dnevnu aktivnost
     */
    public DnevnaAktivnost(NedeljniPlan nedeljniPlan, int rb, Date datumAktivnosti, String beleske, Aktivnost aktivnost) {
        this.nedeljniPlan = nedeljniPlan;
        this.rb = rb;
        this.datumAktivnosti = datumAktivnosti;
        this.beleske = beleske;
        this.aktivnost = aktivnost;
    }

    /**
     * Bezparametarski konstruktor
     */
    public DnevnaAktivnost() {
    }

    @Override
    public String nazivTabele() {
        return " DnevnaAktivnost ";
    }

    @Override
    public String alijas() {
        return " da ";
    }

    @Override
    public String join() {
        return " JOIN AKTIVNOST A USING (AKTIVNOSTID) "
                + "JOIN TIPAKTIVNOSTI TA ON (A.TIPAKTIVNOSTIID = TA.TIPAKTIVNOSTIID) "
                + "JOIN NEDELJNIPLAN NP USING (NEDELJNIPLANID) "
                + "JOIN CILJ C ON (C.CILJID = NP.CILJID) "
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

            TipAktivnosti ta = new TipAktivnosti(rs.getLong("TipAktivnostiID"),
                    rs.getString("NazivTipaAktivnosti"));

            Aktivnost a = new Aktivnost(rs.getLong("aktivnostID"),
                    rs.getString("nazivAktivnosti"), rs.getString("opisAktivnosti"), ta);

            DnevnaAktivnost da = new DnevnaAktivnost(np,
                    rs.getInt("rb"), rs.getDate("datumAktivnosti"), rs.getString("beleske"), a);

            lista.add(da);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (nedeljniPlanID, rb, datumAktivnosti, beleske, aktivnostID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " nedeljniPlanID = " + nedeljniPlan.getNedeljniPlanID();
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + nedeljniPlan.getNedeljniPlanID() + ", " + rb + ", "
                + "'" + new java.sql.Date(datumAktivnosti.getTime()) + "', '" + beleske + "', "
                + aktivnost.getAktivnostID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

    @Override
    public String uslov() {
        return " WHERE NP.NEDELJNIPLANID = " + nedeljniPlan.getNedeljniPlanID()
                + " ORDER BY RB";
    }

    /**
     * Vraca redni broj dnevne aktivnosti.
     *
     * @return redni broj dnevne aktivnosti kao ceo broj
     */
    public int getRb() {
        return rb;
    }

    /**
     * Postavlja vrednost rednog broja dnevne aktivnosti.
     *
     * @param rb redni broj dnevne aktivnosti kao ceo broj
     */
    public void setRb(int rb) {
        this.rb = rb;
    }

    /**
     * Vraca datum dnevne aktivnosti.
     *
     * @return datum dnevne aktivnosti kao objekat klase Date
     */
    public Date getDatumAktivnosti() {
        return datumAktivnosti;
    }

    /**
     * Postavlja vrednost atributa datum dnevne aktivnosti.
     *
     * @param datumAktivnosti datum dnevne aktivnosti kao objekat klase Date
     */
    public void setDatumAktivnosti(Date datumAktivnosti) {
        this.datumAktivnosti = datumAktivnosti;
    }

    /**
     * Vraca beleske dnevne aktivnosti.
     *
     * @return beleske dnevne aktivnosti kao String
     */
    public String getBeleske() {
        return beleske;
    }

    /**
     * Postavlja vrednost atributa beleske.
     *
     * @param beleske beleske dnevne aktivnosti kao String
     */
    public void setBeleske(String beleske) {
        this.beleske = beleske;
    }

    /**
     * Vraca aktivnost.
     *
     * @return aktivnost kao objekat klase Aktivnost
     */
    public Aktivnost getAktivnost() {
        return aktivnost;
    }

    /**
     * Postavlja vrednost atributa aktivnost.
     *
     * @param aktivnost aktivnost kao objekat klase Aktivnost
     */
    public void setAktivnost(Aktivnost aktivnost) {
        this.aktivnost = aktivnost;
    }

    /**
     * Vraca nedeljni plaan.
     *
     * @return nedeljni plan kao objekat klase NedeljniPlan
     */
    public NedeljniPlan getNedeljniPlan() {
        return nedeljniPlan;
    }

    /**
     * Postavlja vrednost atributa nedeljni plan.
     *
     * @param nedeljniPlan nedeljni plan kao objekat klase Nedeljni plan
     */
    public void setNedeljniPlan(NedeljniPlan nedeljniPlan) {
        this.nedeljniPlan = nedeljniPlan;
    }

}
