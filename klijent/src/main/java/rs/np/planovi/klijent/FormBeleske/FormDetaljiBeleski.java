/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package rs.np.planovi.klijent.FormBeleske;

import rs.np.planovi.klijent.FormCilj.FormDetaljiCilja;
import rs.np.planovi.klijent.controller.ClientController;
import rs.np.planovi.zajednicki.domain.Beleska;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 * Forma koja prikazuje detalje odabrane beleske.
 *
 * @author Ana Adamovic
 */
public class FormDetaljiBeleski extends javax.swing.JDialog {

    /**
     * Proslednjena beleska za detaljan prikaz.
     */
    private Beleska b;

    /**
     * Konstruktor koji kreira formu za detaljan prikaz beleske.
     *
     * @param parent forma koja poziva formu za detaljan prikaz beleske
     * @param modal true
     * @param b beleska za detaljan prikaz
     */
    public FormDetaljiBeleski(JDialog parent, boolean modal, Beleska b) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Detalji beleske");
        this.b = b;
        txtNaslov.setText(b.getNaslov());
        txtSadrzaj.setText(b.getSadrzaj());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txtNaslov = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtSadrzaj = new javax.swing.JTextArea();
        btnOtkazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnIzmeni = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Naslov:");

        txtNaslov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNaslovActionPerformed(evt);
            }
        });

        jLabel3.setText("Sadrzaj:");

        txtSadrzaj.setColumns(20);
        txtSadrzaj.setRows(5);
        jScrollPane1.setViewportView(txtSadrzaj);

        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnObrisi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnObrisi.setForeground(new java.awt.Color(255, 0, 51));
        btnObrisi.setText("Obrisi belesku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnIzmeni.setBackground(new java.awt.Color(255, 204, 205));
        btnIzmeni.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnIzmeni.setText("Izmeni belesku");
        btnIzmeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzmeniActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNaslov)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnIzmeni, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOtkazi)
                    .addComponent(btnObrisi)
                    .addComponent(btnIzmeni))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNaslovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNaslovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNaslovActionPerformed
    /**
     * Metoda koja se poziva klikom na dugme "Otkazi" koja vraca korisnika na
     * formu za pretragu beleski.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Otkazi"
     */
    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed
    /**
     * Metoda koja se pokrece klikom na dugme "Obrisi belesku" i brise prikazanu
     * belesku.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Obrisi belesku"
     */
    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        int result = JOptionPane.showConfirmDialog(this, "Da li ste sigurni da zelite da "
                + "obrisete ovu belesku?", "Konfirmacija", JOptionPane.YES_NO_OPTION);

        if (result == JOptionPane.NO_OPTION) {
            return;
        }

        if (result == JOptionPane.YES_OPTION) {
            try {
                ClientController.getInstance().deleteBeleska(b);
                FormPregledBeleski fp = (FormPregledBeleski) getParent();
                fp.refreshTable();
                JOptionPane.showMessageDialog(this, "Uspesno obrisana beleska.");
                this.dispose();
                fp.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ne mozete da obrisete ovu belesku ");
                Logger.getLogger(FormDetaljiCilja.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnObrisiActionPerformed
    /**
     * Metoda koja se pokrece klikom na dugme "Izmeni belesku" i menja prikazanu
     * belesku.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Izmeni belesku"
     */
    private void btnIzmeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzmeniActionPerformed

        if (txtNaslov.getText().isEmpty() || txtSadrzaj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sva polja moraju biti popunjena!");
            return;
        }

        String naslov = txtNaslov.getText();
        String sadrzaj = txtSadrzaj.getText();

        b.setNaslov(naslov);
        b.setSadrzaj(sadrzaj);

        try {
            ClientController.getInstance().updateBeleska(b);
            FormPregledBeleski fp = (FormPregledBeleski) getParent();
            fp.refreshTable();
            JOptionPane.showMessageDialog(this, "Uspesno izmenjena beleska.");
            this.dispose();
            fp.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
//            Logger.getLogger(FormDetaljiCilja.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIzmeniActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzmeni;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtNaslov;
    private javax.swing.JTextArea txtSadrzaj;
    // End of variables declaration//GEN-END:variables
}
