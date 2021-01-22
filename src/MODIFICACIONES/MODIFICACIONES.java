/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODIFICACIONES;

import CAPTURA.FRAMES;
import MENU.MENU;
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
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\KCHAVIRA\\Documents\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
   conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Kaleb\\Documents\\GitHub\\WSPFRAMES\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
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
        this.tablabase.setModel(tabla);                     //Funcion que la tabla se acomoda en el modelo del frame
    }     
            
    public void cargarDatos() {                                                                                         //Funcion con la que se carga los datos en la tabla del frame
        String data[] = new String[8];                                                                                  //Variable que almacena los datos de la consulta
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO FROM Captura ORDER BY ID;";                  //Consulta sql de buscar datos
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
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BMenu = new javax.swing.JButton();
        BCapturar = new javax.swing.JButton();
        BModificar = new javax.swing.JButton();
        Btabla = new javax.swing.JButton();
        BEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablabase = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idtxt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        numeroserietxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        descripciontxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cantidadbultostxt = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cantidadtotaltxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fechatxt = new javax.swing.JTextField();
        horatxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        relojfecha = new rojeru_san.RSLabelFecha();
        relojhora = new rojeru_san.RSLabelHora();
        usuariocombobox = new javax.swing.JComboBox<>();
        BBuscar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BMenu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BMenu.setText("MENU");
        BMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BMenuActionPerformed(evt);
            }
        });

        BCapturar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BCapturar.setText("CAPTURAR");
        BCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCapturarActionPerformed(evt);
            }
        });

        BModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BModificar.setText("MODIFICAR");
        BModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BModificarActionPerformed(evt);
            }
        });

        Btabla.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Btabla.setText("TABLA");
        Btabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtablaActionPerformed(evt);
            }
        });

        BEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BEliminar.setText("ELIMINAR");
        BEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEliminarActionPerformed(evt);
            }
        });

        tablabase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablabase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablabaseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablabase);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel1.setText("ID:");

        idtxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                idtxtKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel2.setText("NUMERO S:");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel3.setText("DESCRIPCION:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel4.setText("CANTIDAD B:");

        cantidadbultostxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadbultostxtKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel5.setText("CANTIDAD T:");

        cantidadtotaltxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cantidadtotaltxtKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel6.setText("FECHA:");

        jLabel7.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel7.setText("HORA:");

        jLabel8.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel8.setText("USUARIO:");

        usuariocombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Moreno", "Leopoldo Campos", "Jose Batres", "Manuel Hernandez", "Kaleb Chavira" }));

        BBuscar1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        BBuscar1.setText("BUSCAR");
        BBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBuscar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Btabla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idtxt)
                            .addComponent(descripciontxt, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(numeroserietxt, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(cantidadbultostxt, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(cantidadtotaltxt, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(fechatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(horatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                            .addComponent(usuariocombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(34, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(relojfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(BModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(1, 1, 1)
                                .addComponent(relojhora, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BCapturar, BEliminar, BMenu, BModificar, Btabla});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(idtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(numeroserietxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Btabla, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(descripciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cantidadbultostxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cantidadtotaltxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(horatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fechatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(usuariocombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BCapturar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(relojhora, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                    .addComponent(relojfecha, javax.swing.GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                .addGap(4, 4, 4))
            .addComponent(jScrollPane1)
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BCapturar, BEliminar, BMenu, BModificar, Btabla});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BMenuActionPerformed
MENU ir = new MENU();
ir.setVisible(true);// TODO add your handling code here:
this.dispose();
    }//GEN-LAST:event_BMenuActionPerformed

    private void BtablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtablaActionPerformed
       String data[] = new String[8];                                                                                  //Variable que almacena los datos de la consulta
       String id = idtxt.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO FROM Captura ORDER BY ID;";                  //Consulta sql de buscar datos
        try {
            tabla.setRowCount(0);
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                idtxt.setText("");
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                numeroserietxt.setText("");
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                descripciontxt.setText("");
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                cantidadbultostxt.setText("");
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                cantidadtotaltxt.setText("");
                data[5] = resultado.getString("HORA");
                horatxt.setText("");
                data[6] = resultado.getString("FECHA");
                fechatxt.setText("");
                data[7] = resultado.getString("USUARIO");
                usuariocombobox.setSelectedItem("");
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }

    }//GEN-LAST:event_BtablaActionPerformed

    private void BCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCapturarActionPerformed
      String noparte = this.numeroserietxt.getText();                              //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.descripciontxt.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.cantidadbultostxt.getText();                      //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.cantidadtotaltxt.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    String hora = this.horatxt.getText();                                          //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = this.fechatxt.getText();                                        //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = usuariocombobox.getSelectedItem().toString();                   //Asiganacion a una variable String que obtiene el texto de un JText
  
    if(numeroserietxt.getText()==""){
    JOptionPane.showMessageDialog(null,"Numero de serie vacio...");
    }
     if(descripciontxt.getText()==""){
    JOptionPane.showMessageDialog(null,"Descripcion vacia...");
    }
      if(cantidadbultostxt.getText()==""){
    JOptionPane.showMessageDialog(null,"Cantidad de bultos vacia...");
    }
       if(cantidadtotaltxt.getText()==""){
    JOptionPane.showMessageDialog(null,"Cantidad Total Vacia...");
    }
        if(horatxt.getText()==""){
    JOptionPane.showMessageDialog(null,"Hora mal ingresada...");
    }
         if(fechatxt.getText()==""){
    JOptionPane.showMessageDialog(null,"Fecha mal ingresada...");
    }
    
    //Instruccion sql dentro de una variable String llamada SQL
    String SQL ="INSERT into Captura(HORA,FECHA,USUARIO,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL) values " + "('" + hora + "','" + fecha + "','" + clerk + "','" + noparte + "','" + descripcion + "','" + cantidadbultos + "','" + cantidadtotal + "')";
    try {
        sentencia.executeUpdate(SQL);                                                   //Se ejecuta el Query SQL en la base de datos
        JOptionPane.showMessageDialog(null,"CAPTURADO");                                //Mensaje al usuario
    } catch (SQLException ex) {                                                         //Excepcion en caso de que el query no funcione
        JOptionPane.showMessageDialog(null,"NO CAPTURADO");                             //Mensaje al usuario
        Logger.getLogger(FRAMES.class.getName()).log(Level.SEVERE, null, ex);           //Excepcion en caso de que el query no funcione
    }
    }//GEN-LAST:event_BCapturarActionPerformed

    private void BEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEliminarActionPerformed
    String id = idtxt.getText();
        try {
            String SQL ="DELETE * FROM Captura WHERE ID = '"+id+"'";
            sentencia.executeUpdate(SQL);
        tabla.setRowCount(0);
        cargarDatos();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_BEliminarActionPerformed

    private void BBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBuscar1ActionPerformed
       String data[] = new String[8];                                                                                  //Variable que almacena los datos de la consulta
       String id = idtxt.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,HORA,FECHA,USUARIO FROM Captura WHERE ID = '"+id+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                idtxt.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                numeroserietxt.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                descripciontxt.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                cantidadbultostxt.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                cantidadtotaltxt.setText(data[4]);
                data[5] = resultado.getString("HORA");
                horatxt.setText(data[5]);
                data[6] = resultado.getString("FECHA");
                fechatxt.setText(data[6]);
                data[7] = resultado.getString("USUARIO");
                usuariocombobox.setSelectedItem(data[7]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }

    }//GEN-LAST:event_BBuscar1ActionPerformed

    private void BModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BModificarActionPerformed
             String noparte = this.numeroserietxt.getText();                              //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.descripciontxt.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.cantidadbultostxt.getText();                      //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.cantidadtotaltxt.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    String hora = this.horatxt.getText();                                          //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = this.fechatxt.getText();                                        //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = usuariocombobox.getSelectedItem().toString();                   //Asiganacion a una variable String que obtiene el texto de un JText
    String id = idtxt.getText();
    
        try {
          String SqlUpdate = "UPDATE Captura set NUMERODEPARTE= '"+noparte+"', DESCRIPCION='"+descripcion+"', CANTIDADBULTOS='" + cantidadbultos+"', CANTIDADTOTAL='"+cantidadtotal+"', HORA='"+ hora+"', FECHA='" +fecha+"', USUARIO='"+clerk +"' WHERE ID = '"+id+"';";   
          sentencia.executeUpdate(SqlUpdate);
          tabla.setRowCount(0);
            BtablaActionPerformed(evt);
            JOptionPane.showMessageDialog(null,"SE HA MODIFICADO EL REGISTRO NO." + id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"no se modificaron los datos");
            System.out.println(""+ e);
        }
   
    }//GEN-LAST:event_BModificarActionPerformed

    private void tablabaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablabaseMouseClicked
      int seleccionar=tablabase.rowAtPoint(evt.getPoint());
      idtxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,0)));
      numeroserietxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,1)));
      descripciontxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,2)));
      cantidadbultostxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,3)));
      cantidadtotaltxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,4)));
      horatxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,5)));
      fechatxt.setText(String.valueOf(tablabase.getValueAt(seleccionar,6)));
      usuariocombobox.setSelectedItem(String.valueOf(tablabase.getValueAt(seleccionar,7)));
      
    }//GEN-LAST:event_tablabaseMouseClicked

    private void idtxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_idtxtKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_idtxtKeyTyped

    private void cantidadbultostxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadbultostxtKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_cantidadbultostxtKeyTyped

    private void cantidadtotaltxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cantidadtotaltxtKeyTyped
        char validar = evt.getKeyChar();
        
        if (Character.isLetter(validar)){
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_cantidadtotaltxtKeyTyped

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
    private javax.swing.JButton BBuscar1;
    private javax.swing.JButton BCapturar;
    private javax.swing.JButton BEliminar;
    private javax.swing.JButton BMenu;
    private javax.swing.JButton BModificar;
    private javax.swing.JButton Btabla;
    private javax.swing.JTextField cantidadbultostxt;
    private javax.swing.JTextField cantidadtotaltxt;
    private javax.swing.JTextField descripciontxt;
    private javax.swing.JTextField fechatxt;
    private javax.swing.JTextField horatxt;
    private javax.swing.JTextField idtxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField numeroserietxt;
    private rojeru_san.RSLabelFecha relojfecha;
    private rojeru_san.RSLabelHora relojhora;
    private javax.swing.JTable tablabase;
    private javax.swing.JComboBox<String> usuariocombobox;
    // End of variables declaration//GEN-END:variables
}
