/*
Inicio del Codigo del Menu
 */
package Inicio;                                               //Clase perteneciente al Paquete Menu   

import Informacion.FRAMES;                                      //Importamos las librerias de obejetos de la clase Frames del paquete de Captura
import Inicio.LOGIN;                                         //Importamos las librerias de obejetos de la clase Login del paquete de Login
import Informacion.MODIFICACIONES;                       //Importamos las librerias de obejetos de la clase Modificaciones del paquete de Modificaciones

/**
 *
 * @author KCHAVIRA
 */
public class MENU extends javax.swing.JFrame {              //Clase publica llamada Menu

    /**
     * Creates new form MENU
     */
    public MENU() {                                         //Constructo de la clase Menu
        initComponents();                                   //Inicia los componentes de la interfaz grafica de la clase
        this.setLocationRelativeTo(null);                   //La interfaz grafica inicia en el punto central de la pantalla
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonCaptura = new javax.swing.JButton();
        BotonReportes = new javax.swing.JButton();
        BotonBusqueda = new javax.swing.JButton();
        BotonCerrarSesion = new javax.swing.JButton();
        BotonModificaciones = new javax.swing.JButton();
        DisplayHora = new rojeru_san.RSLabelHora();
        DisplayFecha = new rojeru_san.RSLabelFecha();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonCaptura.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonCaptura.setText("CAPTURA");
        BotonCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturaActionPerformed(evt);
            }
        });

        BotonReportes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonReportes.setText("REPORTES");

        BotonBusqueda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonBusqueda.setText("BUSQUEDA");

        BotonCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonCerrarSesion.setText("CERRAR SESION");
        BotonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarSesionActionPerformed(evt);
            }
        });

        BotonModificaciones.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonModificaciones.setText("MODIFICACIONES");
        BotonModificaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificacionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BotonCerrarSesion))
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BotonBusqueda)
                    .addComponent(BotonCaptura)
                    .addComponent(BotonReportes)
                    .addComponent(BotonModificaciones))
                .addContainerGap(213, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotonBusqueda, BotonCaptura, BotonCerrarSesion, BotonModificaciones, BotonReportes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonBusqueda)
                        .addGap(18, 18, 18)
                        .addComponent(BotonCaptura)
                        .addGap(18, 18, 18)
                        .addComponent(BotonReportes)
                        .addGap(18, 18, 18)
                        .addComponent(BotonModificaciones)
                        .addGap(51, 51, 51)
                        .addComponent(BotonCerrarSesion)))
                .addGap(3, 3, 3))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonBusqueda, BotonCaptura, BotonCerrarSesion, BotonModificaciones, BotonReportes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturaActionPerformed
FRAMES ir = new FRAMES();                   //Instanciamos un objeto ir de la clase Frames
ir.setVisible(true);                        //Usamos el objeto para que nos abra la siguiente clase
this.dispose();                             //Cerramos la clase y sus componenetes
    }//GEN-LAST:event_BotonCapturaActionPerformed

    private void BotonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarSesionActionPerformed
    LOGIN ir = new LOGIN();                 //Instanciamos un objeto ir de la clase Login
ir.setVisible(true);                        //Usamos el objeto para que nos abra la siguiente clase
this.dispose();                             //Cerramos la clase y sus componenetes
    }//GEN-LAST:event_BotonCerrarSesionActionPerformed

    private void BotonModificacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificacionesActionPerformed
MODIFICACIONES ir = new MODIFICACIONES();   //Instanciamos un objeto ir de la clase Modificaciones
ir.setVisible(true);                        //Usamos el objeto para que nos abra la siguiente clase
this.dispose();                             //Cerramos la clase y sus componenetes
    }//GEN-LAST:event_BotonModificacionesActionPerformed

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
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MENU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBusqueda;
    private javax.swing.JButton BotonCaptura;
    private javax.swing.JButton BotonCerrarSesion;
    private javax.swing.JButton BotonModificaciones;
    private javax.swing.JButton BotonReportes;
    private rojeru_san.RSLabelFecha DisplayFecha;
    private rojeru_san.RSLabelHora DisplayHora;
    // End of variables declaration//GEN-END:variables
}
/*
Fin del codigo de Menu
*/