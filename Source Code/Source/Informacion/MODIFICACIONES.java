/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Informacion;

import Inicio.MENU;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KCHAVIRA
 */
public class MODIFICACIONES extends javax.swing.JFrame {

    /**
     * Creates new form MODIFICACIONES
     */
    public MODIFICACIONES() {                       //Constructor de la clase
       
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

        BotonMenu = new javax.swing.JButton();
        BotonCapturar = new javax.swing.JButton();
        BotonModificar = new javax.swing.JButton();
        BotonTabla = new javax.swing.JButton();
        BotonEliminar = new javax.swing.JButton();
        ScrollDeLaTabla = new javax.swing.JScrollPane();
        TablaModelo = new javax.swing.JTable();
        LabelID = new javax.swing.JLabel();
        TxtID = new javax.swing.JTextField();
        LabelNumeroSerie = new javax.swing.JLabel();
        TxtNumeroSerie = new javax.swing.JTextField();
        LabelDescripcion = new javax.swing.JLabel();
        TxtDescrpcion = new javax.swing.JTextField();
        LabelCantidadBultos = new javax.swing.JLabel();
        TxtCantidadBultos = new javax.swing.JTextField();
        LabelCantidadTotal = new javax.swing.JLabel();
        TxtCantidadTotal = new javax.swing.JTextField();
        LabelFecha = new javax.swing.JLabel();
        LabelHora = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        TxtHora = new javax.swing.JTextField();
        LabelUsuario = new javax.swing.JLabel();
        DisplayFecha = new rojeru_san.RSLabelFecha();
        DisplayHora = new rojeru_san.RSLabelHora();
        ComboBoxUsuario = new javax.swing.JComboBox<>();
        BotonBuscar = new javax.swing.JButton();
        LabelDesviacion = new javax.swing.JLabel();
        ScrollTextDesviacion = new javax.swing.JScrollPane();
        TxtDesviacion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BotonMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonMenu.setText("MENU");
        BotonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMenuActionPerformed(evt);
            }
        });

        BotonCapturar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonCapturar.setText("CAPTURAR");
        BotonCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturarActionPerformed(evt);
            }
        });

        BotonModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonModificar.setText("MODIFICAR");
        BotonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonModificarActionPerformed(evt);
            }
        });

        BotonTabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonTabla.setText("TABLA");
        BotonTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTablaActionPerformed(evt);
            }
        });

        BotonEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonEliminar.setText("ELIMINAR");
        BotonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonEliminarActionPerformed(evt);
            }
        });

        TablaModelo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TablaModelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaModeloMouseClicked(evt);
            }
        });
        ScrollDeLaTabla.setViewportView(TablaModelo);

        LabelID.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelID.setText("ID:");

        TxtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtIDKeyTyped(evt);
            }
        });

        LabelNumeroSerie.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelNumeroSerie.setText("NUMERO S:");

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

        LabelFecha.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelFecha.setText("FECHA:");

        LabelHora.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelHora.setText("HORA:");

        LabelUsuario.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelUsuario.setText("USUARIO:");

        ComboBoxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Moreno", "Leopoldo Campos", "Jose Batres", "Manuel Hernandez", "Kaleb Chavira" }));

        BotonBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BotonBuscar.setText("BUSCAR");
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        LabelDesviacion.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        LabelDesviacion.setText("DESVIACION:");

        TxtDesviacion.setColumns(20);
        TxtDesviacion.setRows(5);
        ScrollTextDesviacion.setViewportView(TxtDesviacion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollDeLaTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelID)
                            .addComponent(LabelUsuario)
                            .addComponent(LabelDescripcion)
                            .addComponent(LabelNumeroSerie)
                            .addComponent(LabelCantidadBultos)
                            .addComponent(LabelCantidadTotal)
                            .addComponent(LabelFecha)
                            .addComponent(LabelHora)
                            .addComponent(LabelDesviacion))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TxtID)
                            .addComponent(TxtDescrpcion, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(TxtNumeroSerie, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(TxtCantidadBultos, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(TxtCantidadTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(TxtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(TxtHora, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(ComboBoxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrollTextDesviacion))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)
                        .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotonCapturar, BotonEliminar, BotonMenu, BotonModificar, BotonTabla});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelID)
                    .addComponent(TxtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelHora)
                    .addComponent(TxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelFecha)
                    .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelDesviacion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ScrollTextDesviacion, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DisplayHora, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4))
            .addComponent(ScrollDeLaTabla)
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonCapturar, BotonEliminar, BotonMenu, BotonModificar, BotonTabla});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMenuActionPerformed
MENU ir = new MENU();
ir.setVisible(true);// TODO add your handling code here:
this.dispose();
    }//GEN-LAST:event_BotonMenuActionPerformed

    private void BotonTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTablaActionPerformed
       String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
       String id = TxtID.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO,DESVIACION FROM Captura ORDER BY ID;";                  //Consulta sql de buscar datos
        try {
            tabla.setRowCount(0);
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtID.setText("");
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroSerie.setText("");
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescrpcion.setText("");
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtCantidadBultos.setText("");
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidadTotal.setText("");
                data[5] = resultado.getString("HORA");
                TxtHora.setText("");
                data[6] = resultado.getString("FECHA");
                TxtFecha.setText("");
                data[7] = resultado.getString("USUARIO");
                ComboBoxUsuario.setSelectedItem("");
                data[8] = resultado.getString("DESVIACION");
                TxtDesviacion.setText("");
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }

    }//GEN-LAST:event_BotonTablaActionPerformed

    private void BotonCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturarActionPerformed
      String noparte = this.TxtNumeroSerie.getText();                              //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.TxtDescrpcion.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.TxtCantidadBultos.getText();                      //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.TxtCantidadTotal.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    String hora = this.TxtHora.getText();                                          //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = this.TxtFecha.getText();                                        //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = ComboBoxUsuario.getSelectedItem().toString();                   //Asiganacion a una variable String que obtiene el texto de un JText
    String desviacion = TxtDesviacion.getText();
    
    
    //Instruccion sql dentro de una variable String llamada SQL
    String SQL ="INSERT into Captura(HORA,FECHA,USUARIO,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,DESVIACION) values " + "('" + hora + "','" + fecha + "','" + clerk + "','" + noparte + "','" + descripcion + "','" + cantidadbultos + "','" + cantidadtotal + "','" + desviacion + "')";
    try {
        sentencia.executeUpdate(SQL);                                                   //Se ejecuta el Query SQL en la base de datos
        JOptionPane.showMessageDialog(null,"CAPTURADO");                                //Mensaje al usuario
        tabla.setRowCount(0);
            BotonTablaActionPerformed(evt);
    } catch (SQLException ex) {                                                         //Excepcion en caso de que el query no funcione
        JOptionPane.showMessageDialog(null,"NO CAPTURADO");                             //Mensaje al usuario
        Logger.getLogger(CAPTURA.class.getName()).log(Level.SEVERE, null, ex);           //Excepcion en caso de que el query no funcione
    }
    }//GEN-LAST:event_BotonCapturarActionPerformed

    
    
    private void BotonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonEliminarActionPerformed
    String id = TxtID.getText();
        try {
            String SQL ="DELETE * FROM Captura WHERE ID = '"+id+"'";
            sentencia.executeUpdate(SQL);
        tabla.setRowCount(0);
        cargarDatos();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_BotonEliminarActionPerformed

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
       String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
       String id = TxtID.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO,DESVIACION FROM Captura WHERE ID = '"+id+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtID.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroSerie.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescrpcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtCantidadBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidadTotal.setText(data[4]);
                data[5] = resultado.getString("HORA");
                TxtHora.setText(data[5]);
                data[6] = resultado.getString("FECHA");
                TxtFecha.setText(data[6]);
                data[7] = resultado.getString("USUARIO");
                ComboBoxUsuario.setSelectedItem(data[7]);
                data[8] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[8]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }

    }//GEN-LAST:event_BotonBuscarActionPerformed

    private void BotonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonModificarActionPerformed
             String noparte = this.TxtNumeroSerie.getText();                              //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.TxtDescrpcion.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.TxtCantidadBultos.getText();                      //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.TxtCantidadTotal.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    String hora = this.TxtHora.getText();                                          //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = this.TxtFecha.getText();                                        //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = ComboBoxUsuario.getSelectedItem().toString();                   //Asiganacion a una variable String que obtiene el texto de un JText
    String id = TxtID.getText();
    String desviacion =this.TxtDesviacion.getText().toString();
    
        try {
          String SqlUpdate = "UPDATE Captura set NUMERODEPARTE='"+noparte+"', DESCRIPCION='"+descripcion+"', CANTIDADBULTOS='" + cantidadbultos+"', CANTIDADTOTAL='"+cantidadtotal+"', HORA='"+ hora+"', FECHA='" +fecha+"', USUARIO='"+clerk +"', DESVIACION='"+ desviacion + "' WHERE ID= '"+ id +"'";   
          sentencia.executeUpdate(SqlUpdate);
          tabla.setRowCount(0);
            BotonTablaActionPerformed(evt);
            JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO NO." + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"no se modificaron los datos del ID= "+id );
            System.out.println(""+ e);
        }
   
    }//GEN-LAST:event_BotonModificarActionPerformed

    private void TablaModeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaModeloMouseClicked
      int seleccionar=TablaModelo.rowAtPoint(evt.getPoint());
      TxtID.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,0)));
      TxtNumeroSerie.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,1)));
      TxtDescrpcion.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,2)));
      TxtCantidadBultos.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,3)));
      TxtCantidadTotal.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,4)));
      TxtHora.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,5)));
      TxtFecha.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,6)));
      ComboBoxUsuario.setSelectedItem(String.valueOf(TablaModelo.getValueAt(seleccionar,7)));
      TxtDesviacion.setText(String.valueOf(TablaModelo.getValueAt(seleccionar,8)));
      
    }//GEN-LAST:event_TablaModeloMouseClicked

    private void TxtIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtIDKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_TxtIDKeyTyped

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
            java.util.logging.Logger.getLogger(MODIFICACIONES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MODIFICACIONES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MODIFICACIONES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MODIFICACIONES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MODIFICACIONES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JButton BotonCapturar;
    private javax.swing.JButton BotonEliminar;
    private javax.swing.JButton BotonMenu;
    private javax.swing.JButton BotonModificar;
    private javax.swing.JButton BotonTabla;
    private javax.swing.JComboBox<String> ComboBoxUsuario;
    private rojeru_san.RSLabelFecha DisplayFecha;
    private rojeru_san.RSLabelHora DisplayHora;
    private javax.swing.JLabel LabelCantidadBultos;
    private javax.swing.JLabel LabelCantidadTotal;
    private javax.swing.JLabel LabelDescripcion;
    private javax.swing.JLabel LabelDesviacion;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelHora;
    private javax.swing.JLabel LabelID;
    private javax.swing.JLabel LabelNumeroSerie;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JScrollPane ScrollDeLaTabla;
    private javax.swing.JScrollPane ScrollTextDesviacion;
    private javax.swing.JTable TablaModelo;
    private javax.swing.JTextField TxtCantidadBultos;
    private javax.swing.JTextField TxtCantidadTotal;
    private javax.swing.JTextField TxtDescrpcion;
    private javax.swing.JTextArea TxtDesviacion;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtHora;
    private javax.swing.JTextField TxtID;
    private javax.swing.JTextField TxtNumeroSerie;
    // End of variables declaration//GEN-END:variables
}
