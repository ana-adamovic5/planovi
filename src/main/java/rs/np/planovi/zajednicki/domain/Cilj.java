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
public class Cilj extends AbstractDomainObject {
    
    private Long ciljID;
    private String nazivCilja;
    private String opisCilja;
    private KategorijaCilja kategorijaCilja;

    public Cilj(Long ciljID, String nazivCilja, String opisCilja, KategorijaCilja kategorijaCilja) {
        this.ciljID = ciljID;
        this.nazivCilja = nazivCilja;
        this.opisCilja = opisCilja;
        this.kategorijaCilja = kategorijaCilja;
    }

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
            KategorijaCilja kc=new KategorijaCilja(rs.getLong("KategorijaID"), rs.getString("NazivKategorije"));
            
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
        return " nazivCilja = '" + nazivCilja + "', opisCilja = '" + opisCilja + "', kategorijaID= '" + kategorijaCilja.getKategorijaID()+"'";
    }

    @Override
    public String uslov() {
        return "";
    }

    public Long getCiljID() {
        return ciljID;
    }

    public void setCiljID(Long ciljID) {
        this.ciljID = ciljID;
    }

    public String getNazivCilja() {
        return nazivCilja;
    }

    public void setNazivCilja(String nazivCilja) {
        this.nazivCilja = nazivCilja;
    }

    public String getOpisCilja() {
        return opisCilja;
    }

    public void setOpisCilja(String opisCilja) {
        this.opisCilja = opisCilja;
    }

    public KategorijaCilja getKategorijaCilja() {
        return kategorijaCilja;
    }

    public void setKategorijaCilja(KategorijaCilja kategorijaCilja) {
        this.kategorijaCilja = kategorijaCilja;
    }
    
    
}
