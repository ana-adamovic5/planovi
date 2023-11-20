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
 *
 * @author adamo
 */
public class Aktivnost extends AbstractDomainObject {
    
    private Long aktivnostID;
    private String nazivAktivnosti;
    private String opisAktivnosti;
    private TipAktivnosti tipAktivnosti;

    public Aktivnost(Long aktivnostID, String nazivAktivnosti, String opisAktivnosti, TipAktivnosti tipAktivnosti) {
        this.aktivnostID = aktivnostID;
        this.nazivAktivnosti = nazivAktivnosti;
        this.opisAktivnosti = opisAktivnosti;
        this.tipAktivnosti = tipAktivnosti;
    }

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

    public Long getAktivnostID() {
        return aktivnostID;
    }

    public void setAktivnostID(Long aktivnostID) {
        this.aktivnostID = aktivnostID;
    }

    public String getNazivAktivnosti() {
        return nazivAktivnosti;
    }

    public void setNazivAktivnosti(String nazivAktivnosti) {
        this.nazivAktivnosti = nazivAktivnosti;
    }

    public String getOpisAktivnosti() {
        return opisAktivnosti;
    }

    public void setOpisAktivnosti(String opisAktivnosti) {
        this.opisAktivnosti = opisAktivnosti;
    }

    public TipAktivnosti getTipAktivnosti() {
        return tipAktivnosti;
    }

    public void setTipAktivnosti(TipAktivnosti tipAktivnosti) {
        this.tipAktivnosti = tipAktivnosti;
    }
    
}
