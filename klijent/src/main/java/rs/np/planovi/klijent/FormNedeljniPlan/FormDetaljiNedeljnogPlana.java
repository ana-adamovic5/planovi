/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.FormNedeljniPlan;

import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import rs.np.planovi.klijent.forme.MainForm;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import rs.np.planovi.klijent.models.TableModelDnevneAktivnosti;

/**
 * Forma koja prikazuje detalje odabranog nedeljnog plana.
 *
 * @author Ana Adamovic
 */
public class FormDetaljiNedeljnogPlana extends javax.swing.JDialog {

    /**
     * Proslednjeni nedeljni plan za detaljan prikaz.
     */
    private NedeljniPlan np;

    /**
     * Konstruktor koji kreira formu za detaljan prikaz nedeljnog plana.
     *
     * @param parent forma koja poziva formu za detaljan prikaz nedeljnog plana
     * @param modal true
     * @param np nedeljni plan za detaljan prikaz
     */
    public FormDetaljiNedeljnogPlana(JDialog parent, boolean modal, NedeljniPlan np) {
        super(parent, modal);
        initComponents();
        this.np = np;
        setLocationRelativeTo(null);
        setTitle("Detalji nedeljnog plana");
        popuniCiljeve();
        popuniAktivnosti();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        txtDatumOd.setText(sdf.format(np.getDatumOd()));
        txtDatumDo.setText(sdf.format(np.getDatumDo()));
        tblAktivnosti.setModel(new TableModelDnevneAktivnosti(np));
        cmbCilj.setSelectedItem(np.getCilj());

        if (!np.getDatumOd().after(new Date())) {
            txtDatumOd.setEditable(false);
            txtDatumDo.setEditable(false);
            cmbAktivnost.setEnabled(false);
            cmbCilj.setEnabled(false);
            btnDodaj.setEnabled(false);
            btnObrisi.setEnabled(false);
            btnObrisiAktivnost.setEnabled(false);
            btnIzmeni.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Ne mozete menjati dnevni plan ciji je datum "
                    + "pocetka pre danasnjeg datuma!");
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtDatumOd = new javax.swing.JFormattedTextField();
        txtDatumDo = new javax.swing.JFormattedTextField();
        cmbCilj = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmbAktivnost = new javax.swing.JComboBox();
        txtDatumAktivnosti = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBeleske = new javax.swing.JTextArea();
        btnDodaj = new javax.swing.JButton();
        btnObrisiAktivnost = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblAktivnosti = new javax.swing.JTable();
        btnOtkazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos nedeljnog plana"));

        jLabel1.setText("Datum od:");

        jLabel2.setText("Datum do:");

        jLabel3.setText("Cilj:");

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        txtDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));

        cmbCilj.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos dnevnih aktivnosti"));

        jLabel4.setText("Aktivnost:");

        jLabel5.setText("Datum aktivnosti:");

        jLabel6.setText("Beleske:");

        cmbAktivnost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumAktivnosti.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumAktivnosti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumAktivnostiActionPerformed(evt);
            }
        });

        txtBeleske.setColumns(20);
        txtBeleske.setRows(5);
        jScrollPane1.setViewportView(txtBeleske);

        btnDodaj.setText("Dodaj aktivnost");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnObrisiAktivnost.setText("Obrisi aktivnost");
        btnObrisiAktivnost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiAktivnostActionPerformed(evt);
            }
        });

        tblAktivnosti.setBackground(new java.awt.Color(255, 204, 204));
        tblAktivnosti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblAktivnosti);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbAktivnost, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDatumAktivnosti)
                    .addComponent(jScrollPane1)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnDodaj, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122)
                .addComponent(btnObrisiAktivnost, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbAktivnost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDatumAktivnosti, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnObrisiAktivnost)
                    .addComponent(btnDodaj))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(255, 0, 51));
        btnObrisi.setText("Obrisi nedeljni plan");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setBackground(new java.awt.Color(255, 204, 204));
        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeni.setText("Izmeni nedeljni plan");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(159, 159, 159)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCilj, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDatumDo))
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(78, 78, 78)
                                .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDatumDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCilj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metoda koja se poziva klikom na dugme "Otkazi" koja vraca korisnika na
     * formu za pretragu nedeljnih planova.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Otkazi"
     */
    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed
    /**
     * Metoda koja se pokrece klikom na dugme "Obrisi nedeljni plan" i brise
     * prikazan nedeljni plan.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Obrisi nedeljni plan"
     */
    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed

        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "obrisete ovaj nedeljni plan?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteNedeljniPlan(np);
                FormPretragaNedeljnogPlana fp = (FormPretragaNedeljnogPlana) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, "Uspesno obrisan nedeljni plan.");
                this.dispose();
            } catch (Exception ex) {
                Logger.getLogger(FormDetaljiNedeljnogPlana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnObrisiActionPerformed
    /**
     * Metoda koja se pokrece klikom na dugme "Izmeni nedeljni plan" i menja
     * prikazan nedeljni plan.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Izmeni nedeljni plan"
     */
    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        if (txtDatumOd.getText().isEmpty() || txtDatumDo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Morate uneti datume!");
            return;
        }

        try {

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumOd = sdf.parse(txtDatumOd.getText());
            Date datumDo = sdf.parse(txtDatumDo.getText());
            Cilj cilj = (Cilj) cmbCilj.getSelectedItem();

            TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();

            np.setDatumOd(datumOd);
            np.setDatumDo(datumDo);
            np.setCilj(cilj);
            np.setDnevneAktivnosti(tm.getLista());

            ClientController.getInstance().updateNedeljniPlan(np);
            FormPretragaNedeljnogPlana fp = (FormPretragaNedeljnogPlana) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, "Uspesno izmenjen nedeljni plan.");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(FormDetaljiCilja.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnIzmeniActionPerformed

    private void txtDatumAktivnostiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumAktivnostiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumAktivnostiActionPerformed
    /**
     * Metoda koja se pokrece klikom na dugme "Dodaj aktivnost" koja dodaje
     * dnevnu aktivnost u tabelu. Preuzima podatke iz grafickih komponenti
     * forme, pravi novi objekat klase DnevnaAktivnost i dodaje u model tabele
     * dnevnih aktivnosti.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Dodaj aktivnost"
     */
    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed

        try {
            if (txtDatumAktivnosti.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti datum aktivnosti!");
                return;
            }

            Aktivnost aktivnost = (Aktivnost) cmbAktivnost.getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumAktivnosti = sdf.parse(txtDatumAktivnosti.getText());
            String beleske = txtBeleske.getText();

            DnevnaAktivnost da = new DnevnaAktivnost(np, -1, datumAktivnosti, beleske, aktivnost);

            TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();
            tm.dodajAktivnost(da);

        } catch (Exception ex) {
            Logger.getLogger(FormDetaljiNedeljnogPlana.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnDodajActionPerformed
    /**
     * Metoda koja se pokrece klikom na dugme "Obrisi aktivnost" koja brise
     * odabranu dnevnu aktivnost iz tabele.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Obrisi aktivnost"
     */
    private void btnObrisiAktivnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiAktivnostActionPerformed

        int row = tblAktivnosti.getSelectedRow();

        if (row >= 0) {
            TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();
            tm.obrisiAktivnost(row);
        }
    }//GEN-LAST:event_btnObrisiAktivnostActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiAktivnost;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JComboBox cmbAktivnost;
    private javax.swing.JComboBox cmbCilj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblAktivnosti;
    private javax.swing.JTextArea txtBeleske;
    private javax.swing.JFormattedTextField txtDatumAktivnosti;
    private javax.swing.JFormattedTextField txtDatumDo;
    private javax.swing.JFormattedTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables

    /**
     * Metoda koja popunjava padajucu listu sa svim ciljevima iz baze podataka.
     * Poziva sistemsku operaciju za vracanje liste ciljeva iz baze podataka.
     */
    private void popuniCiljeve() {
        try {
            ArrayList<Cilj> ciljevi = ClientController.getInstance().getAllCilj();

            cmbCilj.removeAllItems();

            for (Cilj cilj : ciljevi) {
                cmbCilj.addItem(cilj);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metoda koja popunjava padajucu listu sa svim aktivnostima iz baze
     * podataka. Poziva sistemsku operaciju za vracanje liste aktivnosti iz baze
     * podataka.
     */
    private void popuniAktivnosti() {
        try {
            ArrayList<Aktivnost> aktivnosti = ClientController.getInstance().getAllAktivnost();

            cmbAktivnost.removeAllItems();

            for (Aktivnost aktivnost : aktivnosti) {
                cmbAktivnost.addItem(aktivnost);
            }

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
