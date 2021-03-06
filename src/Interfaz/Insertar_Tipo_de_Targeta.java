/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Logica.Controladora;
import Logica.Tipo_de_targetas;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Marquetti
 */
public class Insertar_Tipo_de_Targeta extends javax.swing.JDialog {

    private Controladora controladora;
    private ImageIcon icon;
    private int  id_imagen = 0;

    /**
     * Creates new form Insertar_Tipo_de_Targeta
     * @param controladora
     */
    public Insertar_Tipo_de_Targeta(Controladora controladora) throws IOException {
        
//        RandomAccessFile img = new RandomAccessFile("/Imagenes/Cuadro_imagen.png", "r");
//        byte[] imageData = new byte[(int)img.length()];
//        img.readFully(imageData);
//        icon = new ImageIcon(imageData);
        
        initComponents();
        this.controladora = controladora;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        nombreTxT = new javax.swing.JTextField();
        valorTxt = new javax.swing.JTextField();
        mnBOTON = new javax.swing.JRadioButton();
        cucBoton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        boton_img = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel2.setText("Nombre:");

        nombreTxT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTxTKeyTyped(evt);
            }
        });

        valorTxt.setEditable(false);
        valorTxt.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        valorTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                valorTxtKeyTyped(evt);
            }
        });

        mnBOTON.setText("MN");
        mnBOTON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnBOTONActionPerformed(evt);
            }
        });

        cucBoton.setText("CUC");
        cucBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cucBotonActionPerformed(evt);
            }
        });

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Valor en:");

        jButton1.setText("Insertar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        boton_img.setSelected(true);
        boton_img.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Cuadro_imagen.png"))); // NOI18N
        boton_img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_imgActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inserte la Imagen:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(valorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mnBOTON, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cucBoton))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(boton_img, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreTxT)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreTxT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(valorTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mnBOTON)
                            .addComponent(cucBoton))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(boton_img, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnBOTONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnBOTONActionPerformed
        if(mnBOTON.isSelected()){
            valorTxt.setEditable(true);
            valorTxt.setEnabled(true);
            cucBoton.setSelected(false);
        }
        else{
            mnBOTON.setSelected(true);
            Toolkit.getDefaultToolkit().beep();
        }

    }//GEN-LAST:event_mnBOTONActionPerformed

    private void cucBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cucBotonActionPerformed
        if(cucBoton.isSelected()){
            valorTxt.setEditable(true);
            valorTxt.setEnabled(true);
            mnBOTON.setSelected(false);
        }
        else{
            cucBoton.setSelected(true);
            Toolkit.getDefaultToolkit().beep();
        }
        
    }//GEN-LAST:event_cucBotonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombreTxTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTxTKeyTyped
        KeyEvent e = evt;
        if (!((e.getKeyChar() >= 'A' && e.getKeyChar() <= 'Z')
				|| (e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z'))
				&& e.getKeyChar() != ' ' && e.getKeyChar() != '\b'&&!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9')){
			e.consume();
                        Toolkit.getDefaultToolkit().beep();
        }

    }//GEN-LAST:event_nombreTxTKeyTyped

    private void boton_imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_imgActionPerformed
        JFileChooser a = new JFileChooser();
       if(a.showOpenDialog(this)== JFileChooser.APPROVE_OPTION)
       {
           try {
               RandomAccessFile img = new RandomAccessFile(a.getSelectedFile().getAbsolutePath(),"r");
               byte[] imageData = new byte[(int)img.length()];
               img.readFully(imageData);
               icon = new ImageIcon(imageData);               
               icon = new ImageIcon(icon.getImage().getScaledInstance(boton_img.getWidth()-boton_img.getWidth()/10, boton_img.getHeight()-boton_img.getHeight()/10, Image.SCALE_DEFAULT));
               boton_img.setIcon(icon);
               boton_img.setSelected(false);
               boton_img.setSelectedIcon(icon);
               id_imagen = controladora.subir_imagen(imageData);
           } catch (Exception ex) {
               Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
               boton_img.setSelected(true);
               JOptionPane.showMessageDialog(null, "Por favor introdusca una imagen valida.");
           }
       }
    }//GEN-LAST:event_boton_imgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Tipo_de_targetas tipo = null;
            float valor;
            boolean cuc;
            String nombre = nombreTxT.getText();
            int respuesta;
            if(!nombreTxT.getText().equalsIgnoreCase("")){
                if(!valorTxt.getText().equalsIgnoreCase("")){
                    if(mnBOTON.isSelected()){
                            if(id_imagen!=0){
                                try {
                                    valor = Float.valueOf(valorTxt.getText());
                                    cuc = false;
                                    tipo = new Tipo_de_targetas(0, nombre, id_imagen, valor, cuc);
                                    controladora.insertar_tipo_de_targeta(tipo);
                                    dispose();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Presentamos problemas para realizar tu solicitur, por favor reinicie la aplicacion e intentelo nuevamente.");
                                    Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            else{
                                respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar sin incertar la imagen?");
                                if(respuesta == JOptionPane.YES_OPTION){
                                    valor = Float.valueOf(valorTxt.getText());
                                    cuc = false;
                                    tipo = new Tipo_de_targetas(0, nombre, 0, valor, cuc);
                                    try {
                                        controladora.insertar_tipo_de_targeta(tipo);
                                        dispose();
                                    } catch (SQLException ex) {
                                        JOptionPane.showMessageDialog(null, "Presentamos problemas para realizar tu solicitur, por favor reinicie la aplicacion e intentelo nuevamente.");
                                        Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                                else
                                    JOptionPane.showMessageDialog(null, "Por favor introdusca la imagen.");
                            }
                    }
                        else{
                            if(id_imagen!=0){         
                            valor = Float.valueOf(valorTxt.getText());
                            cuc = true;
                            tipo = new Tipo_de_targetas(0, nombre, id_imagen, valor, cuc);
                            try {
                                controladora.insertar_tipo_de_targeta(tipo);
                                dispose();
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(null, "Presentamos problemas para realizar tu solicitur, por favor reinicie la aplicacion e intentelo nuevamente.");
                                Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        else{
                            respuesta = JOptionPane.showConfirmDialog(null, "¿Desea continuar sin incertar la imagen?");
                            if(respuesta == JOptionPane.YES_OPTION){
                                valor = Float.valueOf(valorTxt.getText());
                                cuc = true;
                                tipo = new Tipo_de_targetas(0, nombre, 0, valor, cuc);
                                try {
                                    controladora.insertar_tipo_de_targeta(tipo);
                                    dispose();
                                } catch (SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Presentamos problemas para realizar tu solicitur, por favor reinicie la aplicacion e intentelo nuevamente.");
                                    Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                
                            }
                            else
                                JOptionPane.showMessageDialog(null, "Por favor introdusca la imagen.");
                        }
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.");
                    }
                }
                else                    
                        JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos.");                 
                

            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void valorTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorTxtKeyTyped
        if(evt.getKeyChar() != '\b'&&!(evt.getKeyChar() >= '0' && evt.getKeyChar() <= '9')){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_valorTxtKeyTyped

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
            java.util.logging.Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Insertar_Tipo_de_Targeta dialog = new Insertar_Tipo_de_Targeta(new Controladora());
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Insertar_Tipo_de_Targeta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void funcion_insertar() throws SQLException{
        Tipo_de_targetas tipo = new Tipo_de_targetas();
        tipo.setId(1);
        tipo.setId_imagen(0);
        tipo.setNombre(nombreTxT.getText());
        tipo.setValor(Float.valueOf(valorTxt.getText()));
        if(cucBoton.isSelected()){
            tipo.setCuc(true);
        }else{
            tipo.setCuc(false);
        }
        controladora.insertar_tipo_de_targeta(tipo);
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_img;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JRadioButton cucBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton mnBOTON;
    private javax.swing.JTextField nombreTxT;
    private javax.swing.JTextField valorTxt;
    // End of variables declaration//GEN-END:variables
}
