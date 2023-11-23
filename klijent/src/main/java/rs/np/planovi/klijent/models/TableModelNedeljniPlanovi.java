/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.models;

import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 * Model tabele za prikaz nedeljnih planova. Klasa nasledjuje apstraktnu klasu
 * AbstractTableModel i implementira njene apstraktne metode.
 *
 * @author Ana Adamovic
 */
public class TableModelNedeljniPlanovi extends AbstractTableModel implements Runnable {

    /**
     * Lista nedeljnih planova.
     */
    private ArrayList<NedeljniPlan> lista;

    /**
     * Nazivi kolona tabele kao niz Stringova.
     */
    private String[] kolone = {"Korisnik", "Datum od", "Datum do", "Cilj"};

    /**
     * Parametar za pretragu nedeljnih planova u tableli.
     */
    private String parametar = "";

    /**
     * Konstruktor koji inicijalizuje model tabele nedeljnih planova. Popunjava
     * tabelu listom nedeljnih planova iz baze podataka.
     */
    public TableModelNedeljniPlanovi() {
        try {
            lista = ClientController.getInstance().getAllNedeljniPlan();
        } catch (Exception ex) {
            Logger.getLogger(TableModelNedeljniPlanovi.class.getName()).log(Level.SEVERE, null, ex);
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
        NedeljniPlan np = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        switch (column) {
            case 0:
                return np.getKorisnik();
            case 1:
                return sdf.format(np.getDatumOd());
            case 2:
                return sdf.format(np.getDatumDo());
            case 3:
                return np.getCilj();

            default:
                return null;
        }
    }

    /**
     * Metoda koja vraca nedeljni plan izabranog reda u tabeli.
     *
     * @param row izabran red tabele
     * @return nedeljni plan izabranog reda tabele
     */
    public NedeljniPlan getSelectedNedeljniPlan(int row) {
        return lista.get(row);
    }

    /**
     * Metoda koja pokrece nit i na svakih deset sekundi osvezava prikaz tabele.
     */
    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(10000);
                refreshTable();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelNedeljniPlanovi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metoda koja postavlja vrednost parametra za pretragu nedeljnih planova u
     * tabeli. Poziva metodu za osvezavanje tabele.
     *
     * @param parametar parametar za pretragu
     */
    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    /**
     * Metoda koja osvezava prikaz tabele nakon izmena.
     */
    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllNedeljniPlan();
            if (!parametar.equals("")) {
                ArrayList<NedeljniPlan> novaLista = new ArrayList<>();
                for (NedeljniPlan np : lista) {
                    if (np.getCilj().getNazivCilja().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(np);
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
