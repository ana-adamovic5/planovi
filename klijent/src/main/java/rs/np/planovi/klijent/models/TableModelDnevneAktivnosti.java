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
 *
 * @author adamo
 */
public class TableModelDnevneAktivnosti extends AbstractTableModel {

    private ArrayList<DnevnaAktivnost> lista;
    private String[] kolone = {"Rb", "Aktivnost", "Datum aktivnosti", "Beleske"};
    private int rb = 0;

    public TableModelDnevneAktivnosti() {
        lista = new ArrayList<>();
    }

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

    public void dodajAktivnost(DnevnaAktivnost da) {
        rb = lista.size();
        da.setRb(++rb);
        lista.add(da);
        fireTableDataChanged();
    }

    public void obrisiAktivnost(int row) {
        lista.remove(row);

        rb = 0;
        for (DnevnaAktivnost dnevnaAktivnost : lista) {
            dnevnaAktivnost.setRb(++rb);
        }

        fireTableDataChanged();
    }

    public ArrayList<DnevnaAktivnost> getLista() {
        return lista;
    }

}
