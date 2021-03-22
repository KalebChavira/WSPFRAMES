//Inicio de codigo

package Informacion;

import javax.swing.JOptionPane;                                                 //libreria para pantallas emergentes
import java.sql.Connection;                                                     //Libreria que hace la conexion a la Base de Datos
import java.sql.DriverManager;                                                  //Libreria que carga el driver que realiza la conexion a la Base de Datos
import java.sql.SQLException;                                                   //Libreria que hace las excepciones en los errores de SQL
import java.sql.Statement;                                                      //Libreria que carga el objeto que contiene los Strings SQL
import java.util.logging.Level;                                                 //Libreria para crear Excepciones en caso de que los Querys no funcionen
import java.util.logging.Logger;                                                //Libreria para crear Excepciones en caso de que los Querys no funcionen
import java.sql.ResultSet;                                                      //Libreria que implementa el objeto Resultset para cargar los SQL
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;                                     //Libreria que instancia un modelo de tabla
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import jxl.Workbook;
 import jxl.write.Label;
 import jxl.write.WritableSheet;
 import jxl.write.WritableWorkbook;





public class REPORTES extends JFrame {
    
    public REPORTES() {                                                                //Constructor de la clase
         initComponents();                                                       //Metodo para iniciar los componentes visuales de la interfaz grafica
        this.setLocationRelativeTo(null);                                       //Centrar el Frame
        conectarBaseDatos();                                                    //Metodo que realiza la conexion a la base de datos
        cargarTitulosColumas();
        cargarDatos();
        DefaultTableModel tabla = new DefaultTableModel();         //Crear la primera tabla default para poder meter datos
    }
       Connection conexion;                                                            //Objeto llamado conexion el cual conectara la base de datos
    Statement sentencia;                                                            //Objeto sentencia el cual mandara los strings de SQL a la base de datos
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };               //Crear la primera tabla default para poder meter datos
    
    
     public void conectarBaseDatos() {                                                                                   //Inicio del Metodo que conecta la aplicacion con la Base de Datos
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");                                                      //Linea que carga el driver
         //   JOptionPane.showMessageDialog(null, "El driver esta funcionando");                                        //Mensaje al usuario para verificacion
        } catch (ClassNotFoundException e) {                                                                            //Excepcion en caso de que el query no funcione                                                                     
            JOptionPane.showMessageDialog(null, "Error al cargar Dirver");                                              //Mensaje al usuario para verificacion
        }
        try {
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\KCHAVIRA\\Documents\\GitHub\\Wsp-Frames\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
 //  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Kaleb\\Documents\\GitHub\\WSPFRAMES\\BD\\CAPTURA.accdb");         //Objeto que busca la Base de Datos
 // JOptionPane.showMessageDialog(null, "Se encontro correctamente la Base de Datos");                                  //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                                      //Excepcion en caso de que el query no funcione
         //   JOptionPane.showMessageDialog(null, "Error en la dirección de la base de datos");                           //Mensaje al usuario para verificacion
        }
        try {
            sentencia = conexion.createStatement();                                                                     //Objeto que conecta la Base de Datos
   //         JOptionPane.showMessageDialog(null, "Conexion Exitosa");                                                  //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                                      //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al crear la conexión con la base de datos");                     //Mensaje al usuario para verificacion
        }
    }
       
    public void cargarTitulosColumas(){                     //Metodo para cargar los titulos personalizados a la tabla
        tabla.addColumn("ID REGISTRO");                     //Titulo 1 de la Tabla
        tabla.addColumn("NUMERO DE SERIE");                 //Titulo 2 de la Tabla
        tabla.addColumn("DESCRIPCION");                     //Titulo 3 de la Tabla
        tabla.addColumn("CANTIDAD BULTOS");                 //Titulo 4 de la Tabla
        tabla.addColumn("CANTIDAD TOTAL");                  //Titulo 5 de la Tabla
        tabla.addColumn("HORA");
        tabla.addColumn("FECHA");
        tabla.addColumn("USUARIO");
        tabla.addColumn("DESVIACION");
        this.TablaModelo.setModel(tabla);                     //Funcion que la tabla se acomoda en el modelo del frame
    }     
            
    public void cargarDatos() {                                                                                         //Funcion con la que se carga los datos en la tabla del frame
        String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO,DESVIACION FROM Captura ORDER BY ID;";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[5] = resultado.getString("HORA");
                data[6] = resultado.getString("FECHA");
                data[7] = resultado.getString("USUARIO");
                data[8] = resultado.getString("DESVIACION");
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }
    }
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollTabla = new javax.swing.JScrollPane();
        TablaModelo = new javax.swing.JTable();
        BotonGenerarReporte = new javax.swing.JButton();
        BotonMostrarTabla = new javax.swing.JButton();
        DisplayHora = new rojeru_san.RSLabelHora();
        DisplayFecha = new rojeru_san.RSLabelFecha();
        LabelFecha = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. de Parte", "Descripcion", "Cantidad", "Bultos", "Fecha", "Hora", "Usuario", "Desviacion"
            }
        ));
        ScrollTabla.setViewportView(TablaModelo);

        BotonGenerarReporte.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BotonGenerarReporte.setText("GENERAR REPORTE");
        BotonGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGenerarReporteActionPerformed(evt);
            }
        });

        BotonMostrarTabla.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        BotonMostrarTabla.setText("TABLA");
        BotonMostrarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarTablaActionPerformed(evt);
            }
        });

        LabelFecha.setText("Fecha:");

        jButton1.setText("Buscar Fecha");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotonGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelFecha)
                                .addGap(18, 18, 18)
                                .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(1042, 1042, 1042)
                    .addComponent(BotonMostrarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                    .addGap(20, 20, 20)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(BotonGenerarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFecha)
                            .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DisplayHora, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DisplayFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(BotonMostrarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(421, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGenerarReporteActionPerformed
if (tabla.getRowCount() > 0) {
 JFileChooser chooser = new JFileChooser();
 FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de excel", "xls");
 chooser.setFileFilter(filter);
 chooser.setDialogTitle("Guardar archivo");
 chooser.setAcceptAllFileFilterUsed(false);
 if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
 List tb = new ArrayList();
 List nom = new ArrayList();
 tb.add(tabla);
 nom.add("Compras por factura");
 String file = chooser.getSelectedFile().toString().concat(".xls");
 try {
     var e = new Exporter(new File(file), tb, nom);
 if (e.export()) {
 JOptionPane.showMessageDialog(null, "Los datos fueron exportados a excel en el directorio seleccionado", "Mensaje de Informacion", JOptionPane.INFORMATION_MESSAGE);
 }
 } catch (Exception e) {
 JOptionPane.showMessageDialog(null, "Hubo un error " + e.getMessage(), " Error", JOptionPane.ERROR_MESSAGE);
 }
 }
 }else{
 JOptionPane.showMessageDialog(this, "No hay datos para exportar","Mensaje de error",JOptionPane.ERROR_MESSAGE);
 }    
    }//GEN-LAST:event_BotonGenerarReporteActionPerformed

    private void BotonMostrarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMostrarTablaActionPerformed
    tabla.setRowCount(0);cargarDatos();
    }//GEN-LAST:event_BotonMostrarTablaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
  String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
       String fecha = TxtFecha.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO,DESVIACION FROM Captura WHERE FECHA = '"+fecha+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
               
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
           
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
              
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
       
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
               
                data[5] = resultado.getString("HORA");
                
                data[6] = resultado.getString("FECHA");
               
                data[7] = resultado.getString("USUARIO");
               
                data[8] = resultado.getString("DESVIACION");
              
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
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
            java.util.logging.Logger.getLogger(REPORTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REPORTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REPORTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REPORTES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REPORTES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGenerarReporte;
    private javax.swing.JButton BotonMostrarTabla;
    private rojeru_san.RSLabelFecha DisplayFecha;
    private rojeru_san.RSLabelHora DisplayHora;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JTable TablaModelo;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
