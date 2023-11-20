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
public class TipAktivnosti extends AbstractDomainObject{
    
    private Long tipAktivnostiID;
    private String nazivTipaAktivnosti;

  
    public TipAktivnosti(Long tipAktivnostiID, String nazivTipaAktivnosti) {
        this.tipAktivnostiID = tipAktivnostiID;
        this.nazivTipaAktivnosti = nazivTipaAktivnosti;
    }

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

    public Long getTipAktivnostiID() {
        return tipAktivnostiID;
    }

    public void setTipAktivnostiID(Long tipAktivnostiID) {
        this.tipAktivnostiID = tipAktivnostiID;
    }

    public String getNazivTipaAktivnosti() {
        return nazivTipaAktivnosti;
    }

    public void setNazivTipaAktivnosti(String nazivTipaAktivnosti) {
        this.nazivTipaAktivnosti = nazivTipaAktivnosti;
    }
    
}
