/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forme;

import domen.Ljubimac;
import domen.OpstiDomenskiObjekat;
import domen.Vlasnik;
import domen.Vrsta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import komunikacija.Komunikacija;
import konstante.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author X
 */
public class DodajLjubimca extends javax.swing.JFrame {

    /**
     * Creates new form DodajLjubimca
     */
    public DodajLjubimca() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Salon za sisanje pasa");
        popuniKomboVrste();
        popuniKomboVlasnika();
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
        cbDa = new javax.swing.JCheckBox();
        cbNe = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        btnDodajVlasnika = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIme = new javax.swing.JTextField();
        cmbVrsta = new javax.swing.JComboBox();
        cmbVlasnik = new javax.swing.JComboBox();
        btnSacuvajLjubimca = new javax.swing.JButton();
        btnOtkazi = new javax.swing.JButton();
        btnAzurirajVlasnike = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos ljubimca", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Da li ste prvi put kod nas?");

        cbDa.setText("Da");
        cbDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDaActionPerformed(evt);
            }
        });

        cbNe.setText("Ne");
        cbNe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNeActionPerformed(evt);
            }
        });

        btnDodajVlasnika.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDodajVlasnika.setForeground(new java.awt.Color(204, 0, 0));
        btnDodajVlasnika.setText("Dodaj vlasnika");
        btnDodajVlasnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajVlasnikaActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Dodaj ljubimca"));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Ime:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("Vrsta:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Vlasnik:");

        cmbVrsta.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbVlasnik.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSacuvajLjubimca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSacuvajLjubimca.setForeground(new java.awt.Color(204, 0, 0));
        btnSacuvajLjubimca.setText("Sacuvaj ljubimca");
        btnSacuvajLjubimca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajLjubimcaActionPerformed(evt);
            }
        });

        btnOtkazi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnOtkazi.setForeground(new java.awt.Color(204, 0, 0));
        btnOtkazi.setText("Otkazi");
        btnOtkazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOtkaziActionPerformed(evt);
            }
        });

        btnAzurirajVlasnike.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAzurirajVlasnike.setForeground(new java.awt.Color(204, 0, 0));
        btnAzurirajVlasnike.setText("Azuriraj vlasnike");
        btnAzurirajVlasnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAzurirajVlasnikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIme)
                            .addComponent(cmbVrsta, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbVlasnik, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnSacuvajLjubimca)
                        .addGap(18, 18, 18)
                        .addComponent(btnOtkazi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAzurirajVlasnike, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbVrsta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbVlasnik, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvajLjubimca)
                    .addComponent(btnOtkazi)
                    .addComponent(btnAzurirajVlasnike))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(cbDa)
                        .addGap(18, 18, 18)
                        .addComponent(cbNe)
                        .addGap(30, 30, 30)
                        .addComponent(btnDodajVlasnika)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbDa)
                    .addComponent(cbNe)
                    .addComponent(btnDodajVlasnika))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOtkaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOtkaziActionPerformed
        dispose();
    }//GEN-LAST:event_btnOtkaziActionPerformed

    private void cbDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDaActionPerformed
        if(cbDa.isSelected()){
            cbNe.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Morate prvo uneti podatke o vlasniku.\nUkoliko se radi o psu lutalici, niste u obavezi da to uradite.");
        }
    }//GEN-LAST:event_cbDaActionPerformed

    private void cbNeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNeActionPerformed
        if(cbNe.isSelected()){
            cbDa.setEnabled(false);
            btnDodajVlasnika.setEnabled(false);
        }
    }//GEN-LAST:event_cbNeActionPerformed

    private void btnDodajVlasnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajVlasnikaActionPerformed
        DodajVlasnika dv = new DodajVlasnika();
        dv.setVisible(true);
    }//GEN-LAST:event_btnDodajVlasnikaActionPerformed

    private void btnAzurirajVlasnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAzurirajVlasnikeActionPerformed
        popuniKomboVlasnika();
        JOptionPane.showMessageDialog(this, "Vlasnici su uspesno azurirani.");
    }//GEN-LAST:event_btnAzurirajVlasnikeActionPerformed

    private void btnSacuvajLjubimcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajLjubimcaActionPerformed
        try {
            validacija();
            String ime = txtIme.getText();
            Vrsta vrsta = (Vrsta) cmbVrsta.getSelectedItem();
            Vlasnik vlasnik = (Vlasnik) cmbVlasnik.getSelectedItem();
            
            Ljubimac lj = new Ljubimac();
            lj.setIme(ime);
            lj.setVrsta(vrsta);
            lj.setVlasnik(vlasnik);
            
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.DODAJ_LJUBIMCA);
            kz.setParametar(lj);
            
            Komunikacija.getInstance().posaljiZahtev(kz);
            ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
            
            Ljubimac ljubimac = (Ljubimac) so.getOdgovor();
            if(ljubimac != null){
                JOptionPane.showMessageDialog(this, "Ljubimac uspesno ubacen u sistem.");
                srediFormu();
            }else{
                JOptionPane.showMessageDialog(this, "Ljubimac nije ubacen! Pokusajte ponovo. ");
                srediFormu();
            }
            
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSacuvajLjubimcaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DodajLjubimca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DodajLjubimca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DodajLjubimca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DodajLjubimca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DodajLjubimca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAzurirajVlasnike;
    private javax.swing.JButton btnDodajVlasnika;
    private javax.swing.JButton btnOtkazi;
    private javax.swing.JButton btnSacuvajLjubimca;
    private javax.swing.JCheckBox cbDa;
    private javax.swing.JCheckBox cbNe;
    private javax.swing.JComboBox cmbVlasnik;
    private javax.swing.JComboBox cmbVrsta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtIme;
    // End of variables declaration//GEN-END:variables

    private void popuniKomboVrste() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_VRSTE);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        List<OpstiDomenskiObjekat> listaVrsta = (List<OpstiDomenskiObjekat>) so.getOdgovor();
        cmbVrsta.removeAllItems();
        for (OpstiDomenskiObjekat vrsta : listaVrsta) {
            cmbVrsta.addItem(vrsta);
        }
    }

    private void popuniKomboVlasnika() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.VRATI_VLASNIKE);
        Komunikacija.getInstance().posaljiZahtev(kz);
        ServerskiOdgovor so = Komunikacija.getInstance().primiOdgovor();
        List<OpstiDomenskiObjekat> listaVlasnika = (List<OpstiDomenskiObjekat>) so.getOdgovor();
        cmbVlasnik.removeAllItems();
        for (OpstiDomenskiObjekat vlasnik : listaVlasnika) {
            cmbVlasnik.addItem(vlasnik);
        }
    }

    private void validacija() throws Exception {
        String greska = "";
        if(txtIme.getText().isEmpty()){
            greska += "Morate uneti ime ljubimca. Pokusajte ponovo. \n";
        }
        if(!greska.isEmpty()){
            throw new Exception(greska);
        }
    }

    private void srediFormu() {
        txtIme.setText("");
    }
}
