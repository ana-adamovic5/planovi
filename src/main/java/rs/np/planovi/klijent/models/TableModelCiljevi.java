/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.models;

import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.Cilj;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adamo
 */
public class TableModelCiljevi extends AbstractTableModel implements Runnable {

    private ArrayList<Cilj> lista;
    private String[] kolone = {"Naziv", "Opis", "Kategorija"};
    private String parametar = "";

    public TableModelCiljevi() {
        try {
            lista = ClientController.getInstance().getAllCilj();
        } catch (Exception ex) {
            Logger.getLogger(TableModelCiljevi.class.getName()).log(Level.SEVERE, null, ex);
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
        Cilj c = lista.get(row);

        switch (column) {
            case 0:
                return c.getNazivCilja();
            case 1:
                return c.getOpisCilja();
            case 2:
                return c.getKategorijaCilja();

            default:
                return null;
        }
    }

    public Cilj getSelectedCilj(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelCiljevi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllCilj();
            if (!parametar.equals("")) {
                ArrayList<Cilj> novaLista = new ArrayList<>();
                for (Cilj c : lista) {
                    if (c.getNazivCilja().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(c);
                    }
                }
                lista = novaLista;
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
