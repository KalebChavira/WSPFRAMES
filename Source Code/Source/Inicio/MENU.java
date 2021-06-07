/*
Inicio del Codigo del Menu
 */
package Inicio;                                               //Clase perteneciente al Paquete Menu   

import Informacion.Busquedas;
import Informacion.CAPTURA;                                      //Importamos las librerias de obejetos de la clase Frames del paquete de Captura
import Inicio.LOGIN;                                         //Importamos las librerias de obejetos de la clase Login del paquete de Login
import Informacion.MODIFICACIONES;                       //Importamos las librerias de obejetos de la clase Modificaciones del paquete de Modificaciones
import Informacion.REPORTES;
import Informacion.REPORTES;

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

        BotonReportes = new javax.swing.JButton();
        BotonBusqueda = new javax.swing.JButton();
        BotonCerrarSesion = new javax.swing.JButton();
        BotonModificaciones = new javax.swing.JButton();
        DisplayHora = new rojeru_san.RSLabelHora();
        DisplayFecha = new rojeru_san.RSLabelFecha();
        LabelTituloMenu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonReportes.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonReportes.setText("REPORTES");
        BotonReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonReportesActionPerformed(evt);
            }
        });

        BotonBusqueda.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonBusqueda.setText("BUSQUEDA");
        BotonBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBusquedaActionPerformed(evt);
            }
        });

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

        LabelTituloMenu.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        LabelTituloMenu.setText("MENU");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LabelTituloMenu)
                        .addGap(139, 139, 139))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BotonReportes)
                            .addComponent(BotonBusqueda)
                            .addComponent(BotonCerrarSesion)
                            .addComponent(BotonModificaciones))
                        .addGap(72, 72, 72))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotonBusqueda, BotonCerrarSesion, BotonModificaciones, BotonReportes});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelTituloMenu)
                .addGap(26, 26, 26)
                .addComponent(BotonBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotonReportes)
                .addGap(18, 18, 18)
                .addComponent(BotonModificaciones)
                .addGap(18, 18, 18)
                .addComponent(BotonCerrarSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonBusqueda, BotonCerrarSesion, BotonModificaciones, BotonReportes});

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void BotonBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBusquedaActionPerformed
Busquedas ir = new Busquedas();this.dispose();// TODO add your handling code here:
ir.setVisible(true);

    }//GEN-LAST:event_BotonBusquedaActionPerformed

    private void BotonReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonReportesActionPerformed
REPORTES ir = new REPORTES();
ir.setVisible(true);// TODO add your handling code here:
this.dispose();
    }//GEN-LAST:event_BotonReportesActionPerformed

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
    private javax.swing.JButton BotonCerrarSesion;
    private javax.swing.JButton BotonModificaciones;
    private javax.swing.JButton BotonReportes;
    private rojeru_san.RSLabelFecha DisplayFecha;
    private rojeru_san.RSLabelHora DisplayHora;
    private javax.swing.JLabel LabelTituloMenu;
    // End of variables declaration//GEN-END:variables
}
/*
Fin del codigo de Menu
*/