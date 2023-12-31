/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.np.planovi.klijent.FormCilj;

import rs.np.planovi.zajednicki.domain.Cilj;
import rs.np.planovi.klijent.forme.MainForm;
import rs.np.planovi.klijent.models.TableModelCiljevi;

/**
 * Forma za pretragu ciljeva.
 * 
 * @author Ana Adamovic
 */
public class FormPretragaCilja extends javax.swing.JDialog {
    
    /**
     * Konstruktor koji kreira formu za pretragu ciljeva.
     * 
     * @param parent forma koja poziva formu za pretragu ciljeva
     * @param modal true
     */
    public FormPretragaCilja(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        TableModelCiljevi model = new TableModelCiljevi();
        Thread th = new Thread(model);
        th.start();
        tblCiljevi.setModel(model);
        setTitle("Pretraga cilja");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCiljevi = new javax.swing.JTable();
        txtPretraga = new javax.swing.JTextField();
        btnDetalji = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Pretraga (naziv cilja):");

        tblCiljevi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblCiljevi);

        txtPretraga.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPretragaKeyReleased(evt);
            }
        });

        btnDetalji.setBackground(new java.awt.Color(255, 204, 204));
        btnDetalji.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnDetalji.setText("Detalji cilja");
        btnDetalji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetaljiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPretraga))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 805, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(309, 309, 309)
                                .addComponent(btnDetalji, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDetalji)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metoda koja se pokrece kada prestane kucanje tastaturom, preuzima unet
     * tekst za pretragu i osvezava tabelu ciljeva na osnovu pretrage.
     *
     * @param evt dogadjaj koji nastane kad prestane kucanje tastaturom
     */
    private void txtPretragaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPretragaKeyReleased
        String param = txtPretraga.getText();
        ((TableModelCiljevi) tblCiljevi.getModel()).setParametar(param);
    }//GEN-LAST:event_txtPretragaKeyReleased
    /**
     * Metoda koja se pokrece klikom na dugme "Detalji cilja" i koja
     * prikazuje izabrani cilj u novoj formi.
     *
     * @param evt dogadjaj pokrenut klikom na dugme "Detalji cilja"
     */
    private void btnDetaljiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetaljiActionPerformed

        int row = tblCiljevi.getSelectedRow();

        if (row >= 0) {
            Cilj c = ((TableModelCiljevi) tblCiljevi.getModel()).getSelectedCilj(row);
            new FormDetaljiCilja(this, rootPaneCheckingEnabled, c).setVisible(true);
        }

    }//GEN-LAST:event_btnDetaljiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalji;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCiljevi;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables
    /**
     * Metoda koja osvezava prikaz tabele ciljeva.
     */
    void refreshTable() {
        TableModelCiljevi tm = (TableModelCiljevi) tblCiljevi.getModel();
        tm.refreshTable();
    }
    
    /**
     * Metoda koja osvezava prikaz padajuce liste ciljeva na glavnoj klijentskoj formi nakon izmena.
     */
    void popuniCiljeve() {
        MainForm mf = (MainForm) getParent();
        mf.popuniCiljeve();
    }

}
