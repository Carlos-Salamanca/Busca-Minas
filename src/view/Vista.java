package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author CARLOS SALAMANCA
 */
public class Vista extends javax.swing.JFrame {
    
    private JButton[][] matrizBotones;
    private String dificultad;
    private int filas;
    private int columnas;
    private int tamanioAux;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;

    /**
     * Creates new form Vista
     */
    public Vista() {
        this.dificultad = "Facil";
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();         
        initComponents();
        identificarDificultad(this.dificultad);
    }
    
    public void identificarDificultad(String dificultad){
        matriz.removeAll();
        matriz.add(btn1);
        matriz.add(btn2);
        matriz.add(btn3);
        btn1.setVisible(false);
        btn2.setVisible(false);
        btn3.setVisible(false);       
        
        if(dificultad.compareTo("Facil")==0){
            setSize(512, 676);
            matriz.repaint();
            filas = 10;
            columnas = 10;
            llenarMatrizBotones(10, 2, 46);
            tamanioAux = 46;
        }
        if(dificultad.compareTo("Normal")==0){
            setSize(512, 676);
            matriz.repaint();
            filas = 15;
            columnas = 15;
            llenarMatrizBotones(10, 2, 30);
            tamanioAux = 30;
        }
        if(dificultad.compareTo("Dificil")==0){
            setSize(628, 794);
            matriz.repaint();
            filas = 20;
            columnas = 20;
            llenarMatrizBotones(8, 1, 28);
            tamanioAux = 28;
        }
    }
    
    public void llenarMatrizBotones(int x, int y, int tamaño){
        matrizBotones = new JButton[filas][columnas];
        int aux1=x;
        for(int i =0; i < filas; i++){
            for(int j =0; j < columnas; j++){
                matrizBotones[i][j] = new JButton();
                matrizBotones[i][j].setBounds(x, y, tamaño, tamaño);
                
                ButtonController bt = new ButtonController();
                matrizBotones[i][j].addActionListener(bt);
                
                matriz.add(matrizBotones[i][j]);
                x+=tamaño+2;
            }
            x=aux1;
            y+=tamaño+2;
        }
    }

    private class ButtonController implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            limpiarSeleccion();
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    if(e.getSource().equals(matrizBotones[i][j])){
                        matrizBotones[i][j].setBackground(Color.blue);                        
                        if(i==filas-1 && j!=columnas-1){
                            mostrarMenu1(i, j);
                        }
                        if(i!=filas-1 && j==columnas-1){
                            mostrarMenu2(i, j);
                        }
                        if(i!=filas-1 && j!=columnas-1){
                            mostrarMenu3(i, j);
                        }
                        if(i==filas-1 && j==columnas-1){
                            mostrarMenu4(i, j);
                        }
                    }
                }
            }
        }
    }
    
    private void limpiarSeleccion(){
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizBotones[i][j].setBackground(null);
            }
        }
    }
    
    private void mostrarMenu1(int i, int j){
        if(this.dificultad.compareTo("Facil")==0){
            btn1.setBounds(matrizBotones[i][j].getX()+(tamanioAux*1)/4, matrizBotones[i][j].getY()-(tamanioAux*3)/4-2,(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()-(tamanioAux*3)/4-2,(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY(),(46*3)/4,(46*3)/4);
        }else{
            btn1.setBounds(matrizBotones[i][j].getX()-2, matrizBotones[i][j].getY()-(tamanioAux+6),(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()-(tamanioAux+6),(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()-2,(46*3)/4,(46*3)/4);
        }
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
    }
    
    private void mostrarMenu2(int i, int j){    
        if(this.dificultad.compareTo("Facil")==0){            
            btn1.setBounds(matrizBotones[i][j].getX()-(tamanioAux*3)/4-2, matrizBotones[i][j].getY()+(tamanioAux*1)/4,(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()-(tamanioAux*3)/4-2, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()+1, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
        }else{
            btn1.setBounds(matrizBotones[i][j].getX()-(tamanioAux+6), matrizBotones[i][j].getY()-2,(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()-(tamanioAux+6), matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()-2, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
        }     
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
    }

    private void mostrarMenu3(int i, int j){    
        if(this.dificultad.compareTo("Facil")==0){
            btn1.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()+(tamanioAux*1)/4,(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()+(tamanioAux*1)/4, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
        }else{
            btn1.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()-2,(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()+tamanioAux+2, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()-2, matrizBotones[i][j].getY()+tamanioAux+2,(46*3)/4,(46*3)/4);
        }
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
    }
    
    private void mostrarMenu4(int i, int j){    
        if(this.dificultad.compareTo("Facil")==0){
            btn1.setBounds(matrizBotones[i][j].getX(), matrizBotones[i][j].getY()-(tamanioAux*3)/4-2,(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()-(tamanioAux*3)/4-2, matrizBotones[i][j].getY()-(tamanioAux*3)/4-2,(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()-(tamanioAux*3)/4-2, matrizBotones[i][j].getY(),(46*3)/4,(46*3)/4);
        }else{
            btn1.setBounds(matrizBotones[i][j].getX(), matrizBotones[i][j].getY()-(tamanioAux+6),(46*3)/4,(46*3)/4);
            btn2.setBounds(matrizBotones[i][j].getX()-(tamanioAux+6), matrizBotones[i][j].getY()-(tamanioAux+6),(46*3)/4,(46*3)/4);
            btn3.setBounds(matrizBotones[i][j].getX()-(tamanioAux+6), matrizBotones[i][j].getY(),(46*3)/4,(46*3)/4);
        }
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Tablero = new javax.swing.JPanel();
        panelControl = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Tiempo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        matriz = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal", "Dificil" }));
        jComboBox1.setToolTipText("Selleccione una dificultad");
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel1.setText("Dificultad: ");

        jButton1.setText("Reiniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Tiempo.setText("Tiempo");
        Tiempo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setText("Banderas: ");

        javax.swing.GroupLayout panelControlLayout = new javax.swing.GroupLayout(panelControl);
        panelControl.setLayout(panelControlLayout);
        panelControlLayout.setHorizontalGroup(
            panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addComponent(Tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addGap(175, 175, 175))
                    .addGroup(panelControlLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelControlLayout.setVerticalGroup(
            panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelControlLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(Tiempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel2))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout matrizLayout = new javax.swing.GroupLayout(matriz);
        matriz.setLayout(matrizLayout);
        matrizLayout.setHorizontalGroup(
            matrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
        );
        matrizLayout.setVerticalGroup(
            matrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 501, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout TableroLayout = new javax.swing.GroupLayout(Tablero);
        Tablero.setLayout(TableroLayout);
        TableroLayout.setHorizontalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(matriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TableroLayout.setVerticalGroup(
            TableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TableroLayout.createSequentialGroup()
                .addComponent(panelControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matriz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tablero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (this.jComboBox1.getSelectedItem().equals("Facil")) {
            this.dificultad = "Facil";
            identificarDificultad(this.dificultad);
        }
        if (this.jComboBox1.getSelectedItem().equals("Normal")) {   
            this.dificultad = "Normal";
            identificarDificultad(this.dificultad);
        }
        if (this.jComboBox1.getSelectedItem().equals("Dificil")) {       
            this.dificultad = "Dificil";
            identificarDificultad(this.dificultad);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

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
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Tablero;
    private javax.swing.JLabel Tiempo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel matriz;
    private javax.swing.JPanel panelControl;
    // End of variables declaration//GEN-END:variables

    private void elseif() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
