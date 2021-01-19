
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LOGIN;

import CAPTURA.CAPTURAOPERADOR;
import MENU.MENU;                                       //Importamos las propiedades de la clase FRAMES0 del paquete de CAPTURA
import java.sql.Connection;                                                     //Libreria que hace la conexion a la Base de Datos
import java.sql.DriverManager;                                                  //Libreria que carga el driver que realiza la conexion a la Base de Datos
import java.sql.SQLException;                                                   //Libreria que hace las excepciones en los errores de SQL
import java.sql.Statement;                                                      //Libreria que carga el objeto que contiene los Strings SQL
import java.sql.ResultSet;                                                      //Libreria que implementa el objeto Resultset para cargar los SQL
import javax.swing.JOptionPane;                         //libreria para pantallas emergentes

/**
 *
 * @author KCHAVIRA
 */
public class LOGIN extends javax.swing.JFrame {

    /**
     * Creates new form LOGIN
     */
    public LOGIN() {
        initComponents();                                                       //Metodo para iniciar los componentes visuales de la interfaz grafica
        this.setLocationRelativeTo(null);                                       //Centrar el Frame en medio de la pantalla
    }
    
    Connection conexion;                    //Objeto llamado conexion el cual conectara la base de datos
    Statement sentencia;                    //Objeto sentencia el cual mandara los strings de SQL a la base de datos
  /*  
   public void conectarBaseDatos() {   
     try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");                                                      //Linea que carga el driver
            JOptionPane.showMessageDialog(null, "El driver esta funcionando");                                          //Mensaje al usuario para verificacion
        } catch (ClassNotFoundException e) {                                                                            
            JOptionPane.showMessageDialog(null, "Error al cargar Dirver");                                              //Mensaje al usuario para verificacion
        }
        try {
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\KCHAVIRA\\Documents\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
  JOptionPane.showMessageDialog(null, "Se encontro correctamente la Base de Datos");                                    //Mensaje al usuario para verificacion
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en la dirección de la base de datos");                           //Mensaje al usuario para verificacion
        }
        try {
            sentencia = conexion.createStatement();                                                                     //Objeto que conecta la Base de Datos
            JOptionPane.showMessageDialog(null, "Conexion Exitosa");                                                    //Mensaje al usuario para verificacion
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear la conexión con la base de datos");                     //Mensaje al usuario para verificacion
        }
    }
    */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonCancelar = new javax.swing.JButton();
        BotonLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        rSLabelFecha1 = new rojeru_san.RSLabelFecha();
        rSLabelHora1 = new rojeru_san.RSLabelHora();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonCancelar.setText("CANCEL");
        BotonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCancelarActionPerformed(evt);
            }
        });

        BotonLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonLogin.setText("LOGIN");
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("PASSWORD:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSLabelHora1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rSLabelFecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(rSLabelHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSLabelFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLoginActionPerformed
                String x="ADMIN";                                                   //Se declara una variable String para validar la contrasena
                String y="";
            if (x.equals(txtpassword.getText().toString())) {                   //Sentencia que determina si la variable "x" es igual al cuadro de contrasena que esta ubicado en el frame
                  MENU ir = new MENU();                                         //Se crea un nuevo objeto de la clase menu
                  ir.setVisible(true);                                          //Con el objeto se hace visible la clase que contiene el Frame de menu
                  this.dispose();                                               //Cerrar esta clase
            }
            if (y.equals(txtpassword.getText().toString())){                    //Control de usuario a nivel operador, no entra en menu
                CAPTURAOPERADOR ir = new CAPTURAOPERADOR();                     //Creamos un objeto de la clase CapturaOperador para llamar a la clase
                ir.setVisible(true);                                            //Usamos el objeto para inicializar la clase
                this.dispose();                                                 //Cerramoes esta clase
            }
 
      
    }//GEN-LAST:event_BotonLoginActionPerformed

    private void BotonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCancelarActionPerformed
            this.dispose();                         //Cerrar esta clase
            JOptionPane.showMessageDialog(null,"See You Later..."); //Mensaje de despedida del cliente.
            System.exit(0);                 //Salida del programa
    }//GEN-LAST:event_BotonCancelarActionPerformed

   
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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCancelar;
    private javax.swing.JButton BotonLogin;
    private javax.swing.JLabel jLabel2;
    private rojeru_san.RSLabelFecha rSLabelFecha1;
    private rojeru_san.RSLabelHora rSLabelHora1;
    private javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
}
