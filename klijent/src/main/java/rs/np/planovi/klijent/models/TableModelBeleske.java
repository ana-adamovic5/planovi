/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.models;

import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.Beleska;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz beleski. Klasa nasledjuje apstraktnu klasu
 * AbstractTableModel i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class TableModelBeleske extends AbstractTableModel {

    /**
     * Lista beleski.
     */
    private ArrayList<Beleska> lista;
    
    /**
     * Nazivi kolona tabele kao niz Stringova.
     */
    private String[] kolone = {"Naslov", "Sadrzaj"};
    
    /**
     * Konstruktor koji inicijalizuje model tabele beleski.
     * Popunjava tabelu listom beleski iz baze podataka.
     */
    public TableModelBeleske() {
        try {
            lista = ClientController.getInstance().getAllBeleska();
        } catch (Exception ex) {
            Logger.getLogger(TableModelBeleske.class.getName()).log(Level.SEVERE, null, ex);
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
        Beleska b = lista.get(row);

        switch (column) {
            case 0:
                return b.getNaslov();
            case 1:
                return b.getSadrzaj();

            default:
                return null;
        }
    }

    /**
     * Metoda koja vraca belesku izabranog reda u tabeli.
     * @param row izabran red tabele
     * @return beleska izabranog reda tabele
     */
    public Beleska getSelectedBeleska(int row) {
        return lista.get(row);
    }

    /**
     * Metoda koja osvezava prikaz tabele nakon izmena.
     * 
     * @throws Exception izuzetak u slucaju da je lista prazna
     */
    public void refreshTable() throws Exception {
        lista = ClientController.getInstance().getAllBeleska();

    }

}
