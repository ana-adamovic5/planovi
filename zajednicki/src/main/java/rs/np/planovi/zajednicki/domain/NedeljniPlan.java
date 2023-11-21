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
 *
 * @author adamo
 */
public class NedeljniPlan extends AbstractDomainObject {

    private Long nedeljniPlanID;
    private Date datumOd;
    private Date datumDo;
    private Cilj cilj;
    private Korisnik korisnik;
    private ArrayList<DnevnaAktivnost> dnevneAktivnosti;

    public NedeljniPlan(Long nedeljniPlanID, Date datumOd, Date datumDo, Cilj cilj, Korisnik korisnik, ArrayList<DnevnaAktivnost> dnevneAktivnosti) {
        this.nedeljniPlanID = nedeljniPlanID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.cilj = cilj;
        this.korisnik = korisnik;
        this.dnevneAktivnosti = dnevneAktivnosti;
    }

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

            KategorijaCilja kc=new KategorijaCilja(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));
            
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

    public Long getNedeljniPlanID() {
        return nedeljniPlanID;
    }

    public void setNedeljniPlanID(Long nedeljniPlanID) {
        this.nedeljniPlanID = nedeljniPlanID;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Cilj getCilj() {
        return cilj;
    }

    public void setCilj(Cilj cilj) {
        this.cilj = cilj;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public ArrayList<DnevnaAktivnost> getDnevneAktivnosti() {
        return dnevneAktivnosti;
    }

    public void setDnevneAktivnosti(ArrayList<DnevnaAktivnost> dnevneAktivnosti) {
        this.dnevneAktivnosti = dnevneAktivnosti;
    }

}
