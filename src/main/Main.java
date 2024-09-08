            /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;


import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.Timer;
import modelos.Buscaminas;

import modelos.Casilla;

/**
 *
 * @author jfcs8
 */
public class Main extends javax.swing.JFrame {
    public static Casilla tablero[][];
    public static Buscaminas buscaminas;
    public static JFrame jf;
    public static JLabel jltim;
    public static JLabel jlban;
    public static boolean victoria;
    public static boolean primerMovimiento = true;
    private int tiempo = 0;
    private Timer timer;
    private ImageIcon bandera = new ImageIcon("src/icons/bandera-roja.png");
    private ImageIcon reloj = new ImageIcon("src/icons/plazo.png");
    
    public Main() {
        initComponents();
        generarTablero();
        fijarImagenes();
        setTitle("Buscaminas");
        panelTablero.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    private void generarTablero(){
        buscaminas = new Buscaminas();
        int filas = Buscaminas.FILAS;
        int columnas = Buscaminas.COLUMNAS;
        this.tablero = new Casilla[filas][columnas];
        for(int i = 0 ; i < filas ; i++){
            for (int j = 0 ; j < columnas ; j++){
                int tipoCasilla = pintarContenido(i,j); 
                this.tablero[i][j] = new Casilla(i,j,tipoCasilla);
                panelTablero.add(this.tablero[i][j]);
            }
        }  
        jf = this;
        jltim = textotiempo;
        jlban = textoBandera;
    }
     
    
    private int pintarContenido(int i, int j){
        if(buscaminas.getSolucion()[i][j] == -1) return -1;
        if(buscaminas.getSolucion()[i][j] == 1) return 1;
        if(buscaminas.getSolucion()[i][j] == 2) return 2;
        if(buscaminas.getSolucion()[i][j] == 3) return 3;
        if(buscaminas.getSolucion()[i][j] == 4) return 4;
        return 0;
    }

    
    private void fijarImagenes(){
    Icon iconoBandera = new ImageIcon(bandera.getImage().getScaledInstance(imagenBandera.getWidth(), 
                imagenBandera.getHeight(), Image.SCALE_DEFAULT));
    imagenBandera.setIcon(iconoBandera);
    imagenBandera.repaint();
    
    Icon iconoReloj = new ImageIcon(reloj.getImage().getScaledInstance(imagenTiempo.getWidth(), 
            imagenTiempo.getHeight(), Image.SCALE_DEFAULT));
    imagenTiempo.setIcon(iconoReloj);
    imagenTiempo.repaint();
    
    textoBandera.setText(String.valueOf(buscaminas.getMinasPuestas()));
    textoBandera.setFont(new Font("Tahoma", 1, 20));
    
    textotiempo.setFont(new Font("Tahoma", 1, 20));
    
    }
    
    private void temporizador(){
        timer = new Timer (1000, new ActionListener (){
            public void actionPerformed(ActionEvent a){
            tiempo++;
            textotiempo.setText(String.valueOf(tiempo));
            }
        });
        timer.start();
    }

    public JLabel getTextotiempo() {
        return textotiempo;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabecera = new javax.swing.JPanel();
        imagenBandera = new javax.swing.JLabel();
        imagenTiempo = new javax.swing.JLabel();
        textotiempo = new javax.swing.JLabel();
        textoBandera = new javax.swing.JLabel();
        panelTablero = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        imagenBandera.setText("jLabel2");

        imagenTiempo.setText("jLabel2");

        textotiempo.setText("0");

        textoBandera.setText("jLabel2");

        javax.swing.GroupLayout panelCabeceraLayout = new javax.swing.GroupLayout(panelCabecera);
        panelCabecera.setLayout(panelCabeceraLayout);
        panelCabeceraLayout.setHorizontalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabeceraLayout.createSequentialGroup()
                .addGap(342, 342, 342)
                .addComponent(imagenBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(textoBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(imagenTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textotiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelCabeceraLayout.setVerticalGroup(
            panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabeceraLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panelCabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(imagenBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(imagenTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textotiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBandera, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        panelTablero.setBackground(new java.awt.Color(255, 255, 255));
        panelTablero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelTablero.setLayout(new java.awt.GridLayout(20, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 1127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(panelCabecera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(panelCabecera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(panelTablero, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
    
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imagenBandera;
    private javax.swing.JLabel imagenTiempo;
    private javax.swing.JPanel panelCabecera;
    private javax.swing.JPanel panelTablero;
    private javax.swing.JLabel textoBandera;
    private javax.swing.JLabel textotiempo;
    // End of variables declaration//GEN-END:variables

class ImagenFondo extends JPanel{
    
}
}
