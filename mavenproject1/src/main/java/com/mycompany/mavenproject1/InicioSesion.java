/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.mavenproject1;

import javax.swing.JOptionPane;

/**
 *
 * @author leonardo
 */
public class InicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form InicioSesion
     */
    public InicioSesion(){
        initComponents();
this.setLocationRelativeTo(null);
//jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Incio2.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelForm = new javax.swing.JPanel();
        lblIni = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtUUsuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnMinimize = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\Incio2.png")); // NOI18N
        panelFondo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 500));

        panelForm.setBackground(new java.awt.Color(246, 247, 249));
        panelForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIni.setFont(new java.awt.Font("Yu Gothic Light", 0, 36)); // NOI18N
        lblIni.setForeground(new java.awt.Color(0, 51, 102));
        lblIni.setText("Inicio de Sesion");
        panelForm.add(lblIni, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, -1, -1));

        txtPassword.setBackground(new java.awt.Color(246, 247, 249));
        txtPassword.setFont(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        txtPassword.setForeground(new java.awt.Color(0, 51, 102));
        txtPassword.setBorder(null);
        panelForm.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 280, 40));

        txtUUsuario.setBackground(new java.awt.Color(246, 247, 249));
        txtUUsuario.setFont(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        txtUUsuario.setForeground(new java.awt.Color(0, 51, 102));
        txtUUsuario.setToolTipText("Usuario");
        txtUUsuario.setBorder(null);
        panelForm.add(txtUUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 280, 40));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 102));
        panelForm.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 340, 280, 20));

        jSeparator2.setForeground(new java.awt.Color(0, 0, 102));
        panelForm.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 280, 20));

        jLabel4.setFont(new java.awt.Font("Yu Gothic Light", 0, 22)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 102));
        jLabel4.setText("Usuario");
        panelForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\Pass.png")); // NOI18N
        panelForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 40, 40));

        btnMinimize.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnMinimize.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\min.png")); // NOI18N
        btnMinimize.setToolTipText("Minimizar");
        btnMinimize.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimize.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMinimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizeMouseClicked(evt);
            }
        });
        panelForm.add(btnMinimize, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 40, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\Usuario.png")); // NOI18N
        panelForm.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 40, 40));

        btnCerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnCerrar.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\Cerrar.png")); // NOI18N
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        panelForm.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 40, 40));

        btnIngresar.setBackground(new java.awt.Color(255, 255, 255));
        btnIngresar.setFont(new java.awt.Font("Yu Gothic Light", 0, 18)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setIcon(new javax.swing.ImageIcon("B:\\Informatica empresarial\\Proyecto\\Image\\Acceder.png")); // NOI18N
        btnIngresar.setToolTipText("Acceder");
        btnIngresar.setBorder(null);
        btnIngresar.setBorderPainted(false);
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnIngresar.setFocusCycleRoot(true);
        btnIngresar.setFocusTraversalPolicyProvider(true);
        btnIngresar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIngresar.setName("Acceder"); // NOI18N
        btnIngresar.setOpaque(false);
        btnIngresar.setRequestFocusEnabled(false);
        btnIngresar.setSelected(true);
        btnIngresar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelForm.add(btnIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 160, 50));

        jLabel6.setFont(new java.awt.Font("Yu Gothic Light", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 102));
        jLabel6.setText("Contraseña");
        panelForm.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        panelFondo.add(panelForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 400, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizeMouseClicked
        this.setExtendedState(1);
    }//GEN-LAST:event_btnMinimizeMouseClicked

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
if(txtUUsuario.getText().isEmpty()&&txtPassword.getText().isEmpty()){
JOptionPane.showMessageDialog(null, "Llene los campos correspondientes","Vacio",JOptionPane.WARNING_MESSAGE);
}else{
if(txtUUsuario.getText().equals("prueba")&&txtPassword.getText().equals("proto")){
try{
Menu ini = new Menu();
ini.setVisible(true);
        this.dispose();
}catch(Exception e){

}

        
}       else {
JOptionPane.showMessageDialog(null, "El usuario y la contraseña no coinciden","Error",JOptionPane.ERROR_MESSAGE);
txtUUsuario.setText("");
txtPassword.setText("");
}
}

    }//GEN-LAST:event_btnIngresarActionPerformed

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
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

new InicioSesion().setVisible(true);

                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel btnMinimize;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblIni;
    private javax.swing.JPanel panelFondo;
    private javax.swing.JPanel panelForm;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUUsuario;
    // End of variables declaration//GEN-END:variables
}
