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
public class DnevnaAktivnost extends AbstractDomainObject {

    private NedeljniPlan nedeljniPlan;
    private int rb;
    private Date datumAktivnosti;
    private String beleske;
    private Aktivnost aktivnost;

    public DnevnaAktivnost(NedeljniPlan nedeljniPlan, int rb, Date datumAktivnosti, String beleske, Aktivnost aktivnost) {
        this.nedeljniPlan = nedeljniPlan;
        this.rb = rb;
        this.datumAktivnosti = datumAktivnosti;
        this.beleske = beleske;
        this.aktivnost = aktivnost;
    }

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
            KategorijaCilja kc=new KategorijaCilja(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));
            
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
        return " WHERE NP.NEDELJNIPLANID = " + nedeljniPlan.getNedeljniPlanID() + 
                " ORDER BY RB";
    }

    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public Date getDatumAktivnosti() {
        return datumAktivnosti;
    }

    public void setDatumAktivnosti(Date datumAktivnosti) {
        this.datumAktivnosti = datumAktivnosti;
    }

    public String getBeleske() {
        return beleske;
    }

    public void setBeleske(String beleske) {
        this.beleske = beleske;
    }

    public Aktivnost getAktivnost() {
        return aktivnost;
    }

    public void setAktivnost(Aktivnost aktivnost) {
        this.aktivnost = aktivnost;
    }

    public NedeljniPlan getNedeljniPlan() {
        return nedeljniPlan;
    }

    public void setNedeljniPlan(NedeljniPlan nedeljniPlan) {
        this.nedeljniPlan = nedeljniPlan;
    }

}
