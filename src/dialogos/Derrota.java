/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package dialogos;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import main.Main;



/**
 *
 * @author jfcs8
 */
public class Derrota extends javax.swing.JDialog {

    /**
     * Creates new form FinJuego
     */
    public Derrota(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fijarImagen();
        this.setLocationRelativeTo(null);
        setVisible(true);
    }

    private void fijarImagen(){
        
        ImageIcon fondo = new ImageIcon("src/icons/gameOver.png");
        Icon icono = new ImageIcon(fondo.getImage().getScaledInstance(etiquetaImagen.getWidth(), 
                etiquetaImagen.getHeight(), Image.SCALE_DEFAULT));
        etiquetaImagen.setIcon(icono);
        etiquetaImagen.repaint();
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        etiquetaImagen = new javax.swing.JLabel();
        botonSalir = new javax.swing.JButton();
        botonReiniciar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        etiquetaImagen.setText("jLabel1");

        botonSalir.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        botonSalir.setText("Salir");
        botonSalir.setMaximumSize(new java.awt.Dimension(79, 29));
        botonSalir.setMinimumSize(new java.awt.Dimension(79, 29));
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonReiniciar1.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        botonReiniciar1.setText("Reiniciar");
        botonReiniciar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReiniciar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(botonReiniciar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(109, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonReiniciar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        dispose();
        Main.jf.dispose();
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonReiniciar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReiniciar1ActionPerformed
        dispose();
        Main.jf.dispose();
        Main n = new Main();
        n.setVisible(true);
        Main.primerMovimiento = true;
    }//GEN-LAST:event_botonReiniciar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonReiniciar1;
    private javax.swing.JButton botonSalir;
    private javax.swing.JLabel etiquetaImagen;
    // End of variables declaration//GEN-END:variables
}
