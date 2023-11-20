/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.forme;

import rs.np.planovi.klijent.FormBeleske.FormNovaBeleska;
import rs.np.planovi.klijent.FormBeleske.FormPregledBeleski;
import rs.np.planovi.klijent.FormCilj.FormNoviCilj;
import rs.np.planovi.klijent.FormCilj.FormPretragaCilja;
import rs.np.planovi.klijent.FormNedeljniPlan.FormPretragaNedeljnogPlana;
import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.Aktivnost;
import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.zajednicki.domain.DnevnaAktivnost;
import rs.np.planovi.zajednicki.domain.Korisnik;
import rs.np.planovi.zajednicki.domain.NedeljniPlan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.np.planovi.klijent.models.TableModelDnevneAktivnosti;
import rs.np.planovi.klijent.session.Session;

/**
 *
 * @author adamo
 */
public class MainForm extends javax.swing.JFrame {

    Korisnik ulogovani;

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        setLocationRelativeTo(null);
        this.ulogovani = Session.getInstance().getUlogovani();
        lblUlogovani.setText("Ulogovani korisnik: " + ulogovani);
        setTitle("Klijentska forma");
        popuniCiljeve();
        popuniAktivnosti();
        tblAktivnosti.setModel(new TableModelDnevneAktivnosti());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        lblUlogovani = new javax.swing.JLabel();
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
        btnSacuvaj = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        miNoviCilj = new javax.swing.JMenuItem();
        miPretragaCilja = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        miPretragaNedeljnogPlana = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        miNovaBeleska = new javax.swing.JMenuItem();
        miPregledBeleski = new javax.swing.JMenuItem();
        jMenu8 = new javax.swing.JMenu();
        miOdjava = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar2.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar2.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblUlogovani.setBackground(new java.awt.Color(255, 153, 153));
        lblUlogovani.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUlogovani.setForeground(new java.awt.Color(255, 102, 102));
        lblUlogovani.setText("Ulogovani");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos nedeljnog plana"));

        jLabel1.setText("Datum od:");

        jLabel2.setText("Datum do:");

        jLabel3.setText("Cilj:");

        txtDatumOd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumOd.setText("17.07.2023");
        txtDatumOd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumOdActionPerformed(evt);
            }
        });

        txtDatumDo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumDo.setText("24.07.2023");

        cmbCilj.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Unos dnevnih aktivnosti"));

        jLabel4.setText("Aktivnost:");

        jLabel5.setText("Datum aktivnosti:");

        jLabel6.setText("Beleske:");

        cmbAktivnost.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtDatumAktivnosti.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd.MM.yyyy"))));
        txtDatumAktivnosti.setText("17.07.2023");
        txtDatumAktivnosti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDatumAktivnostiActionPerformed(evt);
            }
        });

        txtBeleske.setColumns(20);
        txtBeleske.setRows(5);
        txtBeleske.setText("Neke beleske.");
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
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75))
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

        btnSacuvaj.setBackground(new java.awt.Color(255, 204, 204));
        btnSacuvaj.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        btnSacuvaj.setText("Sacuvaj nedeljni plan");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDatumOd, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDatumDo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCilj, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(237, 237, 237))
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
                .addComponent(btnSacuvaj, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                .addContainerGap())
        );

        jMenu6.setBackground(new java.awt.Color(255, 204, 204));
        jMenu6.setText("Cilj");

        miNoviCilj.setText("Novi cilj");
        miNoviCilj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNoviCiljActionPerformed(evt);
            }
        });
        jMenu6.add(miNoviCilj);

        miPretragaCilja.setText("Pretraga cilja");
        miPretragaCilja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaCiljaActionPerformed(evt);
            }
        });
        jMenu6.add(miPretragaCilja);

        jMenuBar1.add(jMenu6);

        jMenu7.setText("Nedeljni plan");

        miPretragaNedeljnogPlana.setText("Pretraga nedeljnog plana");
        miPretragaNedeljnogPlana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPretragaNedeljnogPlanaActionPerformed(evt);
            }
        });
        jMenu7.add(miPretragaNedeljnogPlana);

        jMenuBar1.add(jMenu7);

        jMenu3.setText("Beleske");

        miNovaBeleska.setText("Nova beleska");
        miNovaBeleska.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovaBeleskaActionPerformed(evt);
            }
        });
        jMenu3.add(miNovaBeleska);

        miPregledBeleski.setText("Pregled beleski");
        miPregledBeleski.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miPregledBeleskiActionPerformed(evt);
            }
        });
        jMenu3.add(miPregledBeleski);

        jMenuBar1.add(jMenu3);

        jMenu8.setText("Odjava");

        miOdjava.setText("Odjavi se");
        miOdjava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOdjavaActionPerformed(evt);
            }
        });
        jMenu8.add(miOdjava);

        jMenuBar1.add(jMenu8);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUlogovani))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUlogovani)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miNoviCiljActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNoviCiljActionPerformed
        new FormNoviCilj(this, true).setVisible(true);
    }//GEN-LAST:event_miNoviCiljActionPerformed

    private void miPretragaCiljaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaCiljaActionPerformed
        new FormPretragaCilja(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaCiljaActionPerformed

    private void miPretragaNedeljnogPlanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPretragaNedeljnogPlanaActionPerformed
        new FormPretragaNedeljnogPlana(this, true).setVisible(true);
    }//GEN-LAST:event_miPretragaNedeljnogPlanaActionPerformed

    private void miOdjavaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOdjavaActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "se odjavite?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            new LoginForma().setVisible(true);
            Session.getInstance().setUlogovani(null);
            this.dispose();
        }
    }//GEN-LAST:event_miOdjavaActionPerformed

    private void txtDatumAktivnostiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumAktivnostiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumAktivnostiActionPerformed

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

            DnevnaAktivnost da = new DnevnaAktivnost(null, -1, datumAktivnosti, beleske, aktivnost);

            TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();
            tm.dodajAktivnost(da);

        } catch (Exception ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiAktivnostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiAktivnostActionPerformed

        int row = tblAktivnosti.getSelectedRow();

        if (row >= 0) {
            TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();
            tm.obrisiAktivnost(row);
        }

    }//GEN-LAST:event_btnObrisiAktivnostActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        try {
            if (txtDatumOd.getText().isEmpty() || txtDatumDo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Morate uneti datume!");
                return;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            Date datumOd = sdf.parse(txtDatumOd.getText());
            Date datumDo = sdf.parse(txtDatumDo.getText());
            Cilj cilj = (Cilj) cmbCilj.getSelectedItem();

            TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();

            NedeljniPlan np = new NedeljniPlan(null, datumOd, datumDo, cilj, ulogovani, tm.getLista());

            ClientController.getInstance().addNedeljniPlan(np);
            resetujFormu();
            JOptionPane.showMessageDialog(this, "Uspesno sacuvan plan!");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void txtDatumOdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDatumOdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDatumOdActionPerformed

    private void miNovaBeleskaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovaBeleskaActionPerformed
        new FormNovaBeleska(this, true).setVisible(true);

    }//GEN-LAST:event_miNovaBeleskaActionPerformed

    private void miPregledBeleskiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miPregledBeleskiActionPerformed
        new FormPregledBeleski(this, true).setVisible(true);
    }//GEN-LAST:event_miPregledBeleskiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisiAktivnost;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JComboBox cmbAktivnost;
    private javax.swing.JComboBox cmbCilj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUlogovani;
    private javax.swing.JMenuItem miNovaBeleska;
    private javax.swing.JMenuItem miNoviCilj;
    private javax.swing.JMenuItem miOdjava;
    private javax.swing.JMenuItem miPregledBeleski;
    private javax.swing.JMenuItem miPretragaCilja;
    private javax.swing.JMenuItem miPretragaNedeljnogPlana;
    private javax.swing.JTable tblAktivnosti;
    private javax.swing.JTextArea txtBeleske;
    private javax.swing.JFormattedTextField txtDatumAktivnosti;
    private javax.swing.JFormattedTextField txtDatumDo;
    private javax.swing.JFormattedTextField txtDatumOd;
    // End of variables declaration//GEN-END:variables

    public void popuniCiljeve() {
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

    private void resetujFormu() {
        txtDatumOd.setText("");
        txtDatumDo.setText("");
        txtBeleske.setText("");
        txtDatumAktivnosti.setText("");
        TableModelDnevneAktivnosti tm = (TableModelDnevneAktivnosti) tblAktivnosti.getModel();
        tm.getLista().clear();
        tm.fireTableDataChanged();
    }

}
