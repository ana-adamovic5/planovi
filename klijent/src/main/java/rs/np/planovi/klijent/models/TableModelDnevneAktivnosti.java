/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.models;

import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz dnevnih aktivnosti. Klasa nasledjuje apstraktnu klasu
 * AbstractTableModel i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class TableModelDnevneAktivnosti extends AbstractTableModel {

    /**
     * Lista dnevnih aktivnosti.
     */
    private ArrayList<DnevnaAktivnost> lista;
    
    /**
     * Nazivi kolona tabele kao niz Stringova.
     */
    private String[] kolone = {"Rb", "Aktivnost", "Datum aktivnosti", "Beleske"};
    
    /**
     * Redni broj dnevne aktivnosti kao ceo broj.
     */
    private int rb = 0;

    /**
     * Konstruktor koji inicijalizuje tabelu dnevnih aktivnosti i praznu listu.
     */
    public TableModelDnevneAktivnosti() {
        lista = new ArrayList<>();
    }

    /**
     * Konstruktor koji incijalizuje tabelu dnevnih aktivnosti prosledjenog nedeljnog plana.
     * 
     * @param np nedeljni plan na koji se odnose dnevne aktivnosti
     */
    public TableModelDnevneAktivnosti(NedeljniPlan np) {
        try {
            lista = ClientController.getInstance().getAllDnevnaAktivnost(np);
        } catch (Exception ex) {
            Logger.getLogger(TableModelDnevneAktivnosti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        DnevnaAktivnost da = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return da.getRb();
            case 1:
                return da.getAktivnost().getNazivAktivnosti();
            case 2:
                return sdf.format(da.getDatumAktivnosti());
            case 3:
                return da.getBeleske();

            default:
                return null;
        }
    }

    /**
     * Metoda koja dodaje dnevnu aktivnosti u tabelu i osvezava prikaz tabele.
     * 
     * @param da dnevna aktivnost koja se dodaje u tabelu
     */
    public void dodajAktivnost(DnevnaAktivnost da) {
        rb = lista.size();
        da.setRb(++rb);
        lista.add(da);
        fireTableDataChanged();
    }

    /**
     * Metoda koja brise izabranu dnevnu aktivnost iz tabele i osvezava prikaz.
     * 
     * @param row izabrani red za brisanje iz tabele
     */
    public void obrisiAktivnost(int row) {
        lista.remove(row);

        rb = 0;
        for (DnevnaAktivnost dnevnaAktivnost : lista) {
            dnevnaAktivnost.setRb(++rb);
        }

        fireTableDataChanged();
    }

    /**
     * Vraca listu dnevnih aktivnosti.
     * 
     * @return lista dnevnih aktivnosti
     */
    public ArrayList<DnevnaAktivnost> getLista() {
        return lista;
    }

}
