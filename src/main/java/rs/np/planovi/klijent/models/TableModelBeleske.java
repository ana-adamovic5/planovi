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
 *
 * @author adamo
 */
public class TableModelBeleske extends AbstractTableModel {

    private ArrayList<Beleska> lista;
    private String[] kolone = {"Naslov", "Sadrzaj"};
    private String parametar = "";

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

    public Beleska getSelectedBeleska(int row) {
        return lista.get(row);
    }

//    @Override
//    public void run() {
//        try {
//            while (!Thread.currentThread().isInterrupted()) {
//                Thread.sleep(10000);
//                refreshTable();
//            }
//        } catch (InterruptedException ex) {
//            Logger.getLogger(TableModelBeleske.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

//    public void setParametar(String parametar) {
//        this.parametar = parametar;
//        refreshTable();
//    }

    public void refreshTable() throws Exception {
        lista = ClientController.getInstance().getAllBeleska();
            
    }

}
