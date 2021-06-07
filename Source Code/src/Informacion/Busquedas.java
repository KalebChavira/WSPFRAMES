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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KChavira
 */
public class Busquedas extends javax.swing.JFrame {

    /**
     * Creates new form Busquedas
     */
    public Busquedas() {
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
        tabla.addColumn("ID REGISTRO");                     //Titulo 1 de la Tabla
        tabla.addColumn("NUMERO DE SERIE");                 //Titulo 2 de la Tabla
        tabla.addColumn("DESCRIPCION");                     //Titulo 3 de la Tabla
        tabla.addColumn("CANTIDAD BULTOS");                 //Titulo 4 de la Tabla
        tabla.addColumn("CANTIDAD TOTAL");                  //Titulo 5 de la Tabla
        tabla.addColumn("USUARIO");
        tabla.addColumn("DESVIACION");
        tabla.addColumn("FECHA");
        tabla.addColumn("HORA");
        this.TablaModelo.setModel(tabla);                     //Funcion que la tabla se acomoda en el modelo del frame
    }     
            
    public void cargarDatos() {                                                                                         //Funcion con la que se carga los datos en la tabla del frame
        String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION,FECHA,HORA FROM Captura ORDER BY ID;";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[5] = resultado.getString("USUARIO");
                data[6] = resultado.getString("DESVIACION");
                data[7] = resultado.getString("FECHA");
                data[8] = resultado.getString("HORA");
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

        ScrollTabla = new javax.swing.JScrollPane();
        TablaModelo = new javax.swing.JTable();
        LabelNumeroDeParte = new javax.swing.JLabel();
        LabelDescripcion = new javax.swing.JLabel();
        LabelCantidad = new javax.swing.JLabel();
        LabelBultos = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        LabelDesviacion = new javax.swing.JLabel();
        LabelFechaInicial = new javax.swing.JLabel();
        LabelFechaFinal = new javax.swing.JLabel();
        TxtNumeroDeParte = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        TxtCantidad = new javax.swing.JTextField();
        TxtBultos = new javax.swing.JTextField();
        ComboboxUsuarios = new javax.swing.JComboBox<>();
        ScrollDesviacion = new javax.swing.JScrollPane();
        TxtDesviacion = new javax.swing.JTextArea();
        BotonBuscarNumerodeParte = new javax.swing.JButton();
        BotonBuscarDescripcion = new javax.swing.JButton();
        BotonBuscarCantidad = new javax.swing.JButton();
        BotonBuscarBultos = new javax.swing.JButton();
        BotonBuscarUsuario = new javax.swing.JButton();
        LabelId = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        BotonBuscarId = new javax.swing.JButton();
        BotonIrMenu = new javax.swing.JButton();
        TxtFechaInicial = new javax.swing.JTextField();
        TxtFechaFinal = new javax.swing.JTextField();
        BotonBuscarFechas = new javax.swing.JButton();
        LabelFechaEjemplo = new javax.swing.JLabel();
        LabelEjemplo = new javax.swing.JLabel();
        BotonMostrarTabla = new javax.swing.JButton();

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

        LabelNumeroDeParte.setText("No. de Parte:");

        LabelDescripcion.setText("Descripcion:");

        LabelCantidad.setText("Cantidad:");

        LabelBultos.setText("Bultos:");

        LabelUsuario.setText("Usuario:");

        LabelDesviacion.setText("Desviacion:");

        LabelFechaInicial.setText("Fecha Inicial:");

        LabelFechaFinal.setText("Fecha Final:");

        ComboboxUsuarios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Moreno", "Leopoldo Campos", "Jose Batres", "Manuel Hernandez", "Kaleb Chavira" }));

        TxtDesviacion.setColumns(20);
        TxtDesviacion.setRows(5);
        ScrollDesviacion.setViewportView(TxtDesviacion);

        BotonBuscarNumerodeParte.setText("Buscar");
        BotonBuscarNumerodeParte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarNumerodeParteActionPerformed(evt);
            }
        });

        BotonBuscarDescripcion.setText("Buscar");
        BotonBuscarDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarDescripcionActionPerformed(evt);
            }
        });

        BotonBuscarCantidad.setText("Buscar");
        BotonBuscarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarCantidadActionPerformed(evt);
            }
        });

        BotonBuscarBultos.setText("Buscar");
        BotonBuscarBultos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarBultosActionPerformed(evt);
            }
        });

        BotonBuscarUsuario.setText("Buscar");
        BotonBuscarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarUsuarioActionPerformed(evt);
            }
        });

        LabelId.setText("ID:");

        BotonBuscarId.setText("Buscar");
        BotonBuscarId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarIdActionPerformed(evt);
            }
        });

        BotonIrMenu.setText("MENU");
        BotonIrMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrMenuActionPerformed(evt);
            }
        });

        BotonBuscarFechas.setText("Buscar");
        BotonBuscarFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarFechasActionPerformed(evt);
            }
        });

        LabelFechaEjemplo.setText("dd/mm/aaaa");

        LabelEjemplo.setText("Ejemplo:");

        BotonMostrarTabla.setText("TABLA");
        BotonMostrarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonMostrarTablaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelDesviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelNumeroDeParte, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelId)
                                    .addComponent(BotonMostrarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ScrollDesviacion)
                                    .addComponent(TxtNumeroDeParte)
                                    .addComponent(TxtDescripcion)
                                    .addComponent(TxtCantidad)
                                    .addComponent(TxtBultos)
                                    .addComponent(ComboboxUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(TxtId))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonIrMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BotonBuscarNumerodeParte, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonBuscarDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonBuscarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonBuscarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonBuscarBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonBuscarId, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 8, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(LabelEjemplo)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(666, 666, 666)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LabelFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelFechaEjemplo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtFechaInicial, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                                    .addComponent(TxtFechaFinal))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonBuscarFechas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollTabla)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelId)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelNumeroDeParte, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtNumeroDeParte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarNumerodeParte))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarDescripcion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarCantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBultos, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtBultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarBultos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboboxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBuscarUsuario))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LabelDesviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonMostrarTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(ScrollDesviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BotonIrMenu)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFechaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtFechaFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(BotonBuscarFechas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelFechaEjemplo)
                    .addComponent(LabelEjemplo))
                .addGap(23, 23, 23))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LabelBultos, LabelDescripcion, LabelDesviacion, LabelFechaFinal, LabelNumeroDeParte, LabelUsuario});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBuscarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarCantidadActionPerformed
        String data[] = new String[7];                                                                                  //Variable que almacena los datos de la consulta
       String cantidad = TxtCantidad.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION FROM Captura WHERE CANTIDADTOTAL = '"+cantidad+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }    // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarCantidadActionPerformed

    private void BotonBuscarNumerodeParteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarNumerodeParteActionPerformed
  String data[] = new String[7];                                                                                  //Variable que almacena los datos de la consulta
       String numerodeparte = TxtNumeroDeParte.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION FROM Captura WHERE NUMERODEPARTE = '"+numerodeparte+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarNumerodeParteActionPerformed

    private void BotonBuscarIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarIdActionPerformed
 String data[] = new String[7];                                                                                  //Variable que almacena los datos de la consulta
       String id = TxtId.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION FROM Captura WHERE ID = '"+id+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }
    }//GEN-LAST:event_BotonBuscarIdActionPerformed

    private void BotonBuscarDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarDescripcionActionPerformed
 String data[] = new String[7];                                                                                  //Variable que almacena los datos de la consulta
       String descripcion = TxtDescripcion.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION FROM Captura WHERE DESCRIPCION = '"+descripcion+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }           // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarDescripcionActionPerformed

    private void BotonBuscarBultosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarBultosActionPerformed
         String data[] = new String[7];                                                                                  //Variable que almacena los datos de la consulta
       String bultos = TxtBultos.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION FROM Captura WHERE CANTIDADBULTOS= '"+bultos+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }      // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarBultosActionPerformed

    private void BotonBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarUsuarioActionPerformed
 String data[] = new String[7];                                                                                  //Variable que almacena los datos de la consulta
       String usuario = ComboboxUsuarios.getSelectedItem().toString();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION FROM Captura WHERE USUARIO = '"+usuario+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }              // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarUsuarioActionPerformed

    private void BotonIrMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrMenuActionPerformed
MENU ir = new MENU();
ir.setVisible(true);
this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_BotonIrMenuActionPerformed

    private void BotonBuscarFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarFechasActionPerformed
         String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
       String fechainicial = TxtFechaInicial.getText();
       String fechafinal = TxtFechaFinal.getText();
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,DESVIACION,FECHA,HORA FROM Captura WHERE FECHA Between '"+fechainicial+"' and '" + fechafinal+"' ;";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado
            tabla.setRowCount(0);
            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                TxtId.setText(data[0]);
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                TxtNumeroDeParte.setText(data[1]);
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                TxtDescripcion.setText(data[2]);
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                TxtBultos.setText(data[3]);
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                TxtCantidad.setText(data[4]);
                data[5] = resultado.getString("USUARIO");
                ComboboxUsuarios.setSelectedItem(data[5]);
                data[6] = resultado.getString("DESVIACION");
                TxtDesviacion.setText(data[6]);
                data[7] = resultado.getString("FECHA");
                data[8] = resultado.getString("HORA");
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }   // TODO add your handling code here:
    }//GEN-LAST:event_BotonBuscarFechasActionPerformed

    private void BotonMostrarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonMostrarTablaActionPerformed
tabla.setRowCount(0);cargarDatos();

    }//GEN-LAST:event_BotonMostrarTablaActionPerformed

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
            java.util.logging.Logger.getLogger(Busquedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Busquedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Busquedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Busquedas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Busquedas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscarBultos;
    private javax.swing.JButton BotonBuscarCantidad;
    private javax.swing.JButton BotonBuscarDescripcion;
    private javax.swing.JButton BotonBuscarFechas;
    private javax.swing.JButton BotonBuscarId;
    private javax.swing.JButton BotonBuscarNumerodeParte;
    private javax.swing.JButton BotonBuscarUsuario;
    private javax.swing.JButton BotonIrMenu;
    private javax.swing.JButton BotonMostrarTabla;
    private javax.swing.JComboBox<String> ComboboxUsuarios;
    private javax.swing.JLabel LabelBultos;
    private javax.swing.JLabel LabelCantidad;
    private javax.swing.JLabel LabelDescripcion;
    private javax.swing.JLabel LabelDesviacion;
    private javax.swing.JLabel LabelEjemplo;
    private javax.swing.JLabel LabelFechaEjemplo;
    private javax.swing.JLabel LabelFechaFinal;
    private javax.swing.JLabel LabelFechaInicial;
    private javax.swing.JLabel LabelId;
    private javax.swing.JLabel LabelNumeroDeParte;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JScrollPane ScrollDesviacion;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JTable TablaModelo;
    private javax.swing.JTextField TxtBultos;
    private javax.swing.JTextField TxtCantidad;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextArea TxtDesviacion;
    private javax.swing.JTextField TxtFechaFinal;
    private javax.swing.JTextField TxtFechaInicial;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtNumeroDeParte;
    // End of variables declaration//GEN-END:variables

    public void setVsible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
