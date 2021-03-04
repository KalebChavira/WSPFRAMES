/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import Inicio.LOGIN;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KCHAVIRA
 */
public class CapturaOperador extends javax.swing.JFrame {

    /**
     * Creates new form CapturaOperador
     */
    public CapturaOperador() {
     initComponents();                                                       //Metodo para iniciar los componentes visuales de la interfaz grafica
        this.setLocationRelativeTo(null);                                       //Centrar el Frame
        conectarBaseDatos();                                                    //Metodo que realiza la conexion a la base de datos
        DefaultTableModel tabla = new DefaultTableModel();                      //Codigo que crea el modelo de la tabla
        cargarTitulosColumas();                                                 //Metodo iniciado para cargar titulos de las tablas en cada columna correspondiente
        cargarDatos();
        
    }
 Connection conexion;                                                            //Objeto llamado conexion el cual conectara la base de datos
    Statement sentencia;                                                            //Objeto sentencia el cual mandara los strings de SQL a la base de datos
    DefaultTableModel tabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };               //Crear la primera tabla default para poder meter datos
    DefaultTableModel tabla2 = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int Fila, int Colum) {
            return false;
        }
    };              //Crear la segunda tabla default para poder meter datos
        
    public void conectarBaseDatos() {                                                                                   //Inicio del Metodo que conecta la aplicacion con la Base de Datos
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");                                                      //Linea que carga el driver
         //   JOptionPane.showMessageDialog(null, "El driver esta funcionando");                                        //Mensaje al usuario para verificacion
        } catch (ClassNotFoundException e) {                                                                            //Excepcion en caso de que el query no funcione                                                                     
            JOptionPane.showMessageDialog(null, "Error al cargar Dirver");                                              //Mensaje al usuario para verificacion
        }
        try {
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\KCHAVIRA\\Documents\\GitHub\\Wsp-Frames\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
 //  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Kaleb\\Documents\\GitHub\\WSPFRAMES\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
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
        tabla.addColumn("ID REGISTRO");                    //Titulo 1 de la Tabla
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
        String fecha = this.DisplayFecha.get
        System.out.println("la fecha es: " + fecha);
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO,DESVIACION FROM Captura WHERE FECHA = '"+ fecha + "' ORDER BY ID;";                  //Consulta sql de buscar datos
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotonC = new javax.swing.JScrollPane();
        TablaModelo = new javax.swing.JTable();
        TxtNumeroSerie = new javax.swing.JTextField();
        LabelDescripcion = new javax.swing.JLabel();
        TxtDescrpcion = new javax.swing.JTextField();
        LabelCantidadBultos = new javax.swing.JLabel();
        TxtCantidadBultos = new javax.swing.JTextField();
        LabelCantidadTotal = new javax.swing.JLabel();
        TxtCantidadTotal = new javax.swing.JTextField();
        LabelUsuario = new javax.swing.JLabel();
        ComboBoxUsuario = new javax.swing.JComboBox<>();
        LabelDesviacion = new javax.swing.JLabel();
        ScrollTextDesviacion = new javax.swing.JScrollPane();
        TxtDesviacion = new javax.swing.JTextArea();
        LabelNumeroSerie = new javax.swing.JLabel();
        BotonCerrarSesion = new javax.swing.JButton();
        BotonCapturar = new javax.swing.JButton();
        LabelObjetivo = new javax.swing.JLabel();
        LabelProducido = new javax.swing.JLabel();
        LabelCantidadObjetivo = new javax.swing.JLabel();
        LabelConteoFrames = new javax.swing.JLabel();
        DisplayFecha = new rojeru_san.RSLabelFecha();
        DisplayHora = new rojeru_san.RSLabelHora();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(51, 51, 51));

        TablaModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "No. de Parte", "Descripcion", "Bultos", "Cantidad", "Hora", "Fecha", "Usuario", "Desviacion"
            }
        ));
        BotonC.setViewportView(TablaModelo);

        LabelDescripcion.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelDescripcion.setText("DESCRIPCION:");

        LabelCantidadBultos.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelCantidadBultos.setText("CANTIDAD B:");

        TxtCantidadBultos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCantidadBultosKeyTyped(evt);
            }
        });

        LabelCantidadTotal.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelCantidadTotal.setText("CANTIDAD T:");

        TxtCantidadTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtCantidadTotalKeyTyped(evt);
            }
        });

        LabelUsuario.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelUsuario.setText("USUARIO:");

        ComboBoxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Moreno", "Leopoldo Campos", "Jose Batres", "Manuel Hernandez", "Kaleb Chavira" }));

        LabelDesviacion.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelDesviacion.setText("DESVIACION:");

        TxtDesviacion.setColumns(20);
        TxtDesviacion.setRows(5);
        ScrollTextDesviacion.setViewportView(TxtDesviacion);

        LabelNumeroSerie.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelNumeroSerie.setText("NUMERO S:");

        BotonCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        BotonCerrarSesion.setText("Cerrar Sesion");
        BotonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCerrarSesionActionPerformed(evt);
            }
        });

        BotonCapturar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        BotonCapturar.setText("Capturar");
        BotonCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturarActionPerformed(evt);
            }
        });

        LabelObjetivo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LabelObjetivo.setText("Objetivo:");

        LabelProducido.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LabelProducido.setText("Produccido:");

        LabelCantidadObjetivo.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LabelCantidadObjetivo.setText("2000 Frames");

        LabelConteoFrames.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        LabelConteoFrames.setText("Frames");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BotonC, javax.swing.GroupLayout.PREFERRED_SIZE, 794, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelDescripcion)
                                    .addComponent(LabelNumeroSerie)
                                    .addComponent(LabelCantidadBultos)
                                    .addComponent(LabelCantidadTotal)
                                    .addComponent(LabelObjetivo)
                                    .addComponent(LabelProducido))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(LabelCantidadObjetivo)
                                            .addComponent(LabelConteoFrames)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(ComboBoxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ScrollTextDesviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(TxtDescrpcion, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                                .addComponent(TxtNumeroSerie)
                                                .addComponent(TxtCantidadBultos)
                                                .addComponent(TxtCantidadTotal))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(206, 206, 206)
                                .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(LabelUsuario)
                            .addComponent(LabelDesviacion))
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(BotonCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BotonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotonC)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelObjetivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelProducido))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelCantidadObjetivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelConteoFrames)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNumeroSerie)
                    .addComponent(TxtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDescripcion)
                    .addComponent(TxtDescrpcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCantidadBultos)
                    .addComponent(TxtCantidadBultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCantidadTotal)
                    .addComponent(TxtCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(LabelDesviacion))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ScrollTextDesviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtCantidadBultosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCantidadBultosKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TxtCantidadBultosKeyTyped

    private void TxtCantidadTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtCantidadTotalKeyTyped
        char validar = evt.getKeyChar();

        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TxtCantidadTotalKeyTyped

    private void BotonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCerrarSesionActionPerformed
LOGIN ir = new LOGIN();
ir.setVisible(true);
this.dispose();
    }//GEN-LAST:event_BotonCerrarSesionActionPerformed

    private void BotonCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturarActionPerformed
 String noparte = this.TxtNumeroSerie.getText();                              //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.TxtDescrpcion.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.TxtCantidadBultos.getText();                      //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.TxtCantidadTotal.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    String hora = DisplayHora.getHora().toString();                                          //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = DisplayFecha.getFecha().toString();                                        //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = ComboBoxUsuario.getSelectedItem().toString();                   //Asiganacion a una variable String que obtiene el texto de un JText
    String desviacion = TxtDesviacion.getText();
    
    
    //Instruccion sql dentro de una variable String llamada SQL
    String SQL ="INSERT into Captura(HORA,FECHA,USUARIO,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,DESVIACION) values " + "('" + hora + "','" + fecha + "','" + clerk + "','" + noparte + "','" + descripcion + "','" + cantidadbultos + "','" + cantidadtotal + "','" + desviacion + "')";
    try {
        sentencia.executeUpdate(SQL);                                                   //Se ejecuta el Query SQL en la base de datos
        JOptionPane.showMessageDialog(null,"CAPTURADO");                                //Mensaje al usuario
        tabla.setRowCount(0);
         cargarDatos();
    } catch (SQLException ex) {                                                         //Excepcion en caso de que el query no funcione
        JOptionPane.showMessageDialog(null,"NO CAPTURADO");                             //Mensaje al usuario
   
    }
    }//GEN-LAST:event_BotonCapturarActionPerformed

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
            java.util.logging.Logger.getLogger(CapturaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CapturaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CapturaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CapturaOperador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturaOperador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane BotonC;
    private javax.swing.JButton BotonCapturar;
    private javax.swing.JButton BotonCerrarSesion;
    private javax.swing.JComboBox<String> ComboBoxUsuario;
    private rojeru_san.RSLabelFecha DisplayFecha;
    private rojeru_san.RSLabelHora DisplayHora;
    private javax.swing.JLabel LabelCantidadBultos;
    private javax.swing.JLabel LabelCantidadObjetivo;
    private javax.swing.JLabel LabelCantidadTotal;
    private javax.swing.JLabel LabelConteoFrames;
    private javax.swing.JLabel LabelDescripcion;
    private javax.swing.JLabel LabelDesviacion;
    private javax.swing.JLabel LabelNumeroSerie;
    private javax.swing.JLabel LabelObjetivo;
    private javax.swing.JLabel LabelProducido;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JScrollPane ScrollTextDesviacion;
    private javax.swing.JTable TablaModelo;
    private javax.swing.JTextField TxtCantidadBultos;
    private javax.swing.JTextField TxtCantidadTotal;
    private javax.swing.JTextField TxtDescrpcion;
    private javax.swing.JTextArea TxtDesviacion;
    private javax.swing.JTextField TxtNumeroSerie;
    // End of variables declaration//GEN-END:variables
}
