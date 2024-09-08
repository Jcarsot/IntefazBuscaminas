
package modelos;

import dialogos.Derrota;
import dialogos.Victoria;
import dialogos.Victoria;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import main.Main;
import static main.Main.buscaminas;
import static main.Main.tablero;

public class Casilla extends JButton{
    private Timer timer;
    private int tiempo = 0;
    private int x;
    private int y;
    private int tipoCelda;
    private boolean vista;
    private boolean banderaPuesta = false;
    private int filas = Buscaminas.FILAS;
    private int columnas = Buscaminas.COLUMNAS;

    public Casilla(int x, int y, int tipoCelda) {
        this.x = x;
        this.y = y;
        this.tipoCelda = tipoCelda;
        this.vista = false;
        this.setMinimumSize(new Dimension(33,9));
        this.setBackground(new java.awt.Color(150,150,150));
        this.setFont(new java.awt.Font("Tahoma",1,12) );
        this.addActionListener(new java.awt.event.ActionListener(){
                    public void actionPerformed(java.awt.event.ActionEvent evt){
                        celdaActionperformed(evt);
                    }
                });
        
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton()== 3){
                   botonDerecho(x,y);
                   
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        this.addMouseListener(mouseListener);
    }
    
    
    private void celdaActionperformed(java.awt.event.ActionEvent evt){
        Casilla c = (Casilla)evt.getSource();
        int fila = c.x;
        int columna = c.y;
        
        
        
        if(Main.primerMovimiento == true && Main.buscaminas.getSolucion()[fila][columna] != Buscaminas.MINA){
            Main.jltim.setText("0");
            Main.primerMovimiento = false;
            timer = new Timer (1000, new ActionListener (){
                public void actionPerformed(ActionEvent a){
                tiempo++;
                Main.jltim.setText(String.valueOf(tiempo));
                    if(Main.buscaminas.isFinJuego()){
                        timer.stop();
                    }
                }
            });
        timer.start();
    }
        
        if(!Main.buscaminas.isFinJuego()){
            if(!vista){
                this.vista = true;
                this.setBackground(Color.white);


            switch(this.tipoCelda){
                case -1:
                    Main.buscaminas.setFinJuego(true);
                    for(int i = 0 ; i < filas ; i++){
                        for(int j = 0 ; j < columnas ; j++){
                            if(Main.buscaminas.getSolucion()[i][j] == Buscaminas.MINA){
                            Main.tablero[i][j].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bomba.png")));
                            Main.tablero[i][j].setBackground(Color.white);
                            }
                        }
                    }
                    Derrota d = new Derrota(Main.jf, true);
                    break;
                case 1:
                    this.setForeground(Color.blue);
                    this.setText("1");
                    break;
                case 2:
                    this.setForeground(Color.green);
                    this.setText("2");
                    break;
                case 3:
                    this.setForeground(Color.red);
                    this.setText("3");
                    break;
                case 4:
                    this.setForeground(Color.YELLOW);
                    this.setText("4");
                    break;
                case 0:
                    this.setText("");
                    movimientoCero(fila,columna);
                    break;    
                default:
                    System.out.println("Sin respuesta.");
                    break;
                }
           
            
            }
            
          
        } 
    }
    
    public void botonDerecho(int fila,int columna){
        if(!Main.tablero[fila][columna].isBanderaPuesta() && Main.buscaminas.getMinasPuestas() > 0){
            Main.buscaminas.setMinasPuestas(Main.buscaminas.getMinasPuestas() - 1); 
            Main.jlban.setText(String.valueOf(Main.buscaminas.getMinasPuestas()));
            Main.tablero[fila][columna].setBanderaPuesta(true);
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bandera.png")));
            this.vista = true;
        } else if (Main.tablero[fila][columna].isBanderaPuesta() && Main.buscaminas.getMinasPuestas() < Main.buscaminas.getMinaInicial()){
            Main.tablero[fila][columna].setIcon(null);
            Main.tablero[fila][columna].setBanderaPuesta(false);
            Main.buscaminas.setMinasPuestas(Main.buscaminas.getMinasPuestas() + 1); 
            Main.jlban.setText(String.valueOf(Main.buscaminas.getMinasPuestas()));
            Main.tablero[fila][columna].setBackground(new java.awt.Color(150,150,150));
            this.vista = false;
        }
        
        if(victoria()){
              System.out.println("Victoria");
              Main.buscaminas.setFinJuego(true);
              Victoria v = new Victoria(Main.jf, true);
          }  
    }
    
    public boolean victoria(){
        int contador = Main.buscaminas.getMinaInicial();
        boolean victoria = false;
        
        for(int i = 0 ; i < Main.tablero.length ; i++){
            for(int j = 0 ; j < Main.tablero.length ; j++){
                if (Main.tablero[i][j].isBanderaPuesta() && Main.buscaminas.getSolucion()[i][j] == Buscaminas.MINA){
                    contador--;
                }
            }
        }
        if(contador == 0) victoria = true;    
        return victoria;
    }
    
     private void movimientoCero(int fila , int columna){
       
        if((fila-1 >= 0 && fila-1 <= 19) && (columna-1 >= 0 && columna-1 <= 19)) {
            //posicion 1
            if (Main.buscaminas.getSolucion()[fila - 1][columna - 1] == Buscaminas.VACIO && !Main.tablero[fila - 1][columna - 1].isVista()) {
                mostrarCasillas(fila - 1, columna - 1);
                movimientoCero(fila - 1, columna - 1);
            } else {
                mostrarCasillas(fila - 1, columna - 1);
            }
        }

        if((fila-1 >= 0 && fila-1 <= 19) && (columna >= 0 && columna <= 19)) {
            //posicion 2
            if (Main.buscaminas.getSolucion()[fila - 1][columna] == Buscaminas.VACIO && !Main.tablero[fila - 1][columna].isVista()) {
              mostrarCasillas(fila - 1, columna);
              movimientoCero(fila - 1, columna);
            } else {
              mostrarCasillas(fila - 1, columna);
            }
        }

        if((fila-1 >= 0 && fila-1 <= 19) && (columna+1 >= 0 && columna+1 <= 19)) {
            //posicion 3
            if (Main.buscaminas.getSolucion()[fila - 1][columna + 1] == Buscaminas.VACIO && !Main.tablero[fila - 1][columna + 1].isVista()) {
              mostrarCasillas(fila - 1, columna + 1);
              movimientoCero(fila - 1, columna + 1);
            } else {
              mostrarCasillas(fila - 1, columna + 1);
            }
        }

        if((fila >= 0 && fila <= 19) && (columna-1 >= 0 && columna-1 <= 19)) {
            //posicion 4
            if (Main.buscaminas.getSolucion()[fila][columna - 1] == Buscaminas.VACIO && !Main.tablero[fila][columna - 1].isVista()) {
              mostrarCasillas(fila, columna - 1);
              movimientoCero(fila, columna - 1);
            } else {
              mostrarCasillas(fila, columna - 1);
            }
        }

        if((fila >= 0 && fila <= 19) && (columna+1 >= 0 && columna+1 <= 19)) {
            //posicion 6
            if (Main.buscaminas.getSolucion()[fila][columna + 1] == Buscaminas.VACIO && !Main.tablero[fila][columna + 1].isVista()) {
              mostrarCasillas(fila, columna + 1);
              movimientoCero(fila, columna + 1);
            } else {
              mostrarCasillas(fila, columna + 1);
            }
        }

        if((fila+1 >= 0 && fila+1 <= 19) && (columna-1 >= 0 && columna-1 <= 19)) {
            //posicion 7
            if (Main.buscaminas.getSolucion()[fila + 1][columna - 1] == Buscaminas.VACIO && !Main.tablero[fila + 1][columna - 1].isVista()) {
              mostrarCasillas(fila + 1, columna - 1);
              movimientoCero(fila + 1, columna - 1);
            } else {
              mostrarCasillas(fila + 1, columna - 1);
            }
        }

        if((fila+1 >= 0 && fila+1 <= 19) && (columna >= 0 && columna <= 19)) {
            //posicion 8
            if (Main.buscaminas.getSolucion()[fila + 1][columna] == Buscaminas.VACIO && !Main.tablero[fila + 1][columna].isVista()) {
              mostrarCasillas(fila + 1, columna);
              movimientoCero(fila + 1, columna);
            } else {
              mostrarCasillas(fila + 1, columna);
            }
        }

        if((fila+1 >= 0 && fila+1 <= 19) && (columna+1 >= 0 && columna+1 <= 19)) {
            //posicion 9
            if (Main.buscaminas.getSolucion()[fila + 1][columna + 1] == Buscaminas.VACIO && !Main.tablero[fila + 1][columna + 1].isVista()) {
              mostrarCasillas(fila + 1, columna + 1);
              movimientoCero(fila + 1, columna + 1);
            } else {
              mostrarCasillas(fila + 1, columna + 1);
            }
        }
    }
    
    
    private void mostrarCasillas(int fila, int columna){
        if(Main.tablero[fila][columna].getTipoCelda() == Buscaminas.VISTA_MARCAR_BANDERA){
            JOptionPane.showConfirmDialog(null, "Movimiento incorrecto. Primero debe levantar la bandera.");
            System.out.println("Movimiento incorrecto. Primero debe levantar la bandera.");
            return;
        }

        if(Main.buscaminas.getSolucion()[fila][columna] == Buscaminas.MINA){
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/bomba.png")));
            Main.buscaminas.setFinJuego(true);
            return;
        }

        if(Main.buscaminas.getSolucion()[fila][columna] == Buscaminas.VACIO){
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setText("");
            return;
        }
        if(Main.buscaminas.getSolucion()[fila][columna] == 1){
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setForeground(Color.blue);
            Main.tablero[fila][columna].setText("1");
            return;
        }
        if(Main.buscaminas.getSolucion()[fila][columna] == 2){
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setForeground(Color.green);
            Main.tablero[fila][columna].setText("2");
            return;
        }
        if(Main.buscaminas.getSolucion()[fila][columna] == 3){
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setForeground(Color.red);
            Main.tablero[fila][columna].setText("3");
            return;
        }
        if(Main.buscaminas.getSolucion()[fila][columna] == 4){
            Main.tablero[fila][columna].setVista(true);
            Main.tablero[fila][columna].setBackground(Color.white);
            Main.tablero[fila][columna].setForeground(Color.red);
            Main.tablero[fila][columna].setText("4");
            return;
        }
    }

    public int getTipoCelda() {
        return tipoCelda;
    }

    public void setTipoCelda(int tipoCelda) {
        this.tipoCelda = tipoCelda;
    }
    
    public boolean isVista() {
        return vista;
    }
    
    public void setVista(boolean b){
        this.vista = b;
    }

    public void setBanderaPuesta(boolean banderaPuesta) {
        this.banderaPuesta = banderaPuesta;
    }

    public boolean isBanderaPuesta() {
        return banderaPuesta;
    }
    
    

   
  
    
}
