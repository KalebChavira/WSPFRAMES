//INICIO DEL CODIGO PARA LA CAPTURA DE FRAMES

package CAPTURA;                           //Paquete de Captura


import LOGIN.LOGIN;
import MENU.MENU;                                                               //Importamos la clase de MENU
import javax.swing.JOptionPane;                                                 //libreria para pantallas emergentes
import java.sql.Connection;                                                     //Libreria que hace la conexion a la Base de Datos
import java.sql.DriverManager;                                                  //Libreria que carga el driver que realiza la conexion a la Base de Datos
import java.sql.SQLException;                                                   //Libreria que hace las excepciones en los errores de SQL
import java.sql.Statement;                                                      //Libreria que carga el objeto que contiene los Strings SQL
import java.util.logging.Level;                                                 //Libreria para crear Excepciones en caso de que los Querys no funcionen
import java.util.logging.Logger;                                                //Libreria para crear Excepciones en caso de que los Querys no funcionen
import java.sql.ResultSet;                                                      //Libreria que implementa el objeto Resultset para cargar los SQL
import javax.swing.table.DefaultTableModel;                                     //Libreria que instancia un modelo de tabla

public class CAPTURAOPERADOR extends javax.swing.JFrame {                                //Inicio de la clase de pruebas para frames
    
public CAPTURAOPERADOR(){                                                                //Constructor de la clase
        initComponents();                                                       //Metodo para iniciar los componentes visuales de la interfaz grafica
        this.setLocationRelativeTo(null);                                       //Centrar el Frame
        conectarBaseDatos();                                                    //Metodo que realiza la conexion a la base de datos
        DefaultTableModel tabla = new DefaultTableModel();                      //Codigo que crea el modelo de la tabla
        cargarTitulosColumas();                                                 //Metodo iniciado para cargar titulos de las tablas en cada columna correspondiente
        cargarDatos();  
        VerTabla2();//Metodo que contiene un query SELECT para descargar todos los datos en la tabla de muestreo
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






    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelFechaBeanInfo1 = new rojeru_san.RSLabelFechaBeanInfo();
        usuriocombobox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        BotonCaptura = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nparte = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        cantidaddebultos = new javax.swing.JTextField();
        cantidadtotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablabase = new javax.swing.JTable();
        botondescarga = new javax.swing.JButton();
        botonirmenu = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        botonlimpiar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablabase2 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        BotonSegundaTabla = new javax.swing.JButton();
        total = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        relojhora = new rojeru_san.RSLabelHora();
        relojfecha = new rojeru_san.RSLabelFecha();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        usuriocombobox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Moreno", "Leopoldo Campos", "Jose Batres", "Manuel Hernandez", "Kaleb Chavira" }));

        jLabel1.setText("Usuario:");

        BotonCaptura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonCaptura.setText("Capturar");
        BotonCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturaActionPerformed(evt);
            }
        });

        jLabel2.setText("No. de Parte:");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Cantidad de Bultos:");

        jLabel5.setText("Cantidad Total:");

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
        jScrollPane1.setViewportView(tablabase);

        botondescarga.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botondescarga.setText("Descargar");
        botondescarga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botondescargaActionPerformed(evt);
            }
        });

        botonirmenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonirmenu.setText("LOGOUT");
        botonirmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonirmenuActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel6.setText("TIEMPO MUERTO EN FRAMES W.SILVER PRODUCTS");

        botonlimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        botonlimpiar.setText("LIMPIAR");

        tablabase2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablabase2);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel7.setText("MODULO DE CAPTURA DE FRAMES W.SILVER PRODUCTS");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAMBIO DE PONCHADOR", "CAMBIO DE NAVAJA", "CAMBIO DE SET-UP", "FALLA MECANICA", "FALLA ELECTRICA", "TIEMPO DE DESCANSO", "FALLA DE LUZ", "FALTA DE OPERADOR", "ENTRENAMIENTO DE OPERADOR", "PARO DE CALIDAD" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:00-8:00", "8:00-9:00", "9:00-10:00", "10:00-11:00", "11:00-12:00", "12:00-13:00", "13:00-14:00", "14:00-15:00", "15:00-16:00", "16:00-16:30", "16:00..." }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 Minuto", "2 Minutos", "5 Minutos", "10 Minutos", "15 Minutos", "20 Minutos", "30 Minutos", "45 Minutos", "50 Minutos", "1 Hora", "2 Horas", "3 Horas", "5 Horas", "1 Turno", "1 Dia", "2 Dias" }));

        BotonSegundaTabla.setText("VER");
        BotonSegundaTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSegundaTablaActionPerformed(evt);
            }
        });

        jLabel8.setText("Rango de Horario:");

        jLabel9.setText("Retardo:");

        jLabel10.setText("Conteo Diario:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(BotonCaptura, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(botondescarga, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(usuriocombobox, 0, 160, Short.MAX_VALUE)
                                        .addComponent(nparte)
                                        .addComponent(descripcion)
                                        .addComponent(cantidaddebultos)
                                        .addComponent(cantidadtotal)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(botonlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(botonirmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(relojhora, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(relojfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addGap(18, 18, 18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(48, 48, 48)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BotonSegundaTabla)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap())
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(jLabel7)
                    .addContainerGap(474, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {BotonCaptura, botonirmenu, botonlimpiar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuriocombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(nparte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cantidaddebultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cantidadtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BotonCaptura, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(botondescarga, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonirmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addComponent(BotonSegundaTabla)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(relojhora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(relojfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel7)
                    .addContainerGap(743, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonCaptura, botonirmenu, botonlimpiar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void conectarBaseDatos() {                                                                                   //Inicio del Metodo que conecta la aplicacion con la Base de Datos
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");                                                      //Linea que carga el driver
         //   JOptionPane.showMessageDialog(null, "El driver esta funcionando");                                        //Mensaje al usuario para verificacion
        } catch (ClassNotFoundException e) {                                                                            //Excepcion en caso de que el query no funcione                                                                     
            JOptionPane.showMessageDialog(null, "Error al cargar Dirver");                                              //Mensaje al usuario para verificacion
        }
        try {
 // conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\KCHAVIRA\\Documents\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Kaleb\\Documents\\GitHub\\WSPFRAMES\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
 // JOptionPane.showMessageDialog(null, "Se encontro correctamente la Base de Datos");                                  //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                                      //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error en la dirección de la base de datos");                           //Mensaje al usuario para verificacion
        }
        try {
            sentencia = conexion.createStatement();                                                                     //Objeto que conecta la Base de Datos
   //         JOptionPane.showMessageDialog(null, "Conexion Exitosa");                                                  //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                                      //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al crear la conexión con la base de datos");                     //Mensaje al usuario para verificacion
        }
    }
    
    public void cargarDatos() {                                                                                         //Funcion con la que se carga los datos en la tabla del frame
        String data[] = new String[5];                                                                                  //Variable que almacena los datos de la consulta
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL FROM Captura;";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }
    }
    
    public void cargarTitulosColumas(){                     //Metodo para cargar los titulos personalizados a la tabla
        tabla.addColumn("ID REGISTRO");                     //Titulo 1 de la Tabla
        tabla.addColumn("NUMERO DE SERIE");                 //Titulo 2 de la Tabla
        tabla.addColumn("DESCRIPCION");                     //Titulo 3 de la Tabla
        tabla.addColumn("CANTIDAD BULTOS");                 //Titulo 4 de la Tabla
        tabla.addColumn("CANTIDAD TOTAL");                  //Titulo 5 de la Tabla
        this.tablabase.setModel(tabla);                     //Funcion que la tabla se acomoda en el modelo del frame
    } 
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     try {
            sentencia.close();                                                                      //Objeto que cierra la conexion de la Base de Datos
            JOptionPane.showMessageDialog(null,"Base de Datos se esta cerradando");                 //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                  //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cerrar la base de datos" + e);            //Mensaje al usuario para verificacion
        }
    }//GEN-LAST:event_formWindowClosing

    private void BotonCapturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCapturaActionPerformed
    String hora = this.relojhora.getHora().toString();                          //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = this.relojfecha.getFecha().toString();                       //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = usuriocombobox.getSelectedItem().toString();                 //Asiganacion a una variable String que obtiene el texto de un JText
    String noparte = this.nparte.getText();                                     //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.descripcion.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.cantidaddebultos.getText();                    //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.cantidadtotal.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    
    //Instruccion sql dentro de una variable String llamada SQL
    String SQL ="insert into Captura(HORA,FECHA,USUARIO,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL) values " + "('" + hora + "','" + fecha + "','" + clerk + "','" + noparte + "','" + descripcion + "','" + cantidadbultos + "','" + cantidadtotal + "')";
    try {
        sentencia.executeUpdate(SQL);                                                   //Se ejecuta el Query SQL en la base de datos
        JOptionPane.showMessageDialog(null,"CAPTURADO");                                //Mensaje al usuario
    } catch (SQLException ex) {                                                         //Excepcion en caso de que el query no funcione
        JOptionPane.showMessageDialog(null,"NO CAPTURADO");                             //Mensaje al usuario
        Logger.getLogger(CAPTURAOPERADOR.class.getName()).log(Level.SEVERE, null, ex);           //Excepcion en caso de que el query no funcione
    }
    tabla.setRowCount(0);                                                               //Funcion para vaciar la tabla del Model
    cargarDatos();                                                                      //Llamada a la funcion de cargar datos a la tabla 
        
        
            
    
    }//GEN-LAST:event_BotonCapturaActionPerformed

    private void botondescargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botondescargaActionPerformed
   tabla.setRowCount(0);                                                               //Funcion para vaciar la tabla del Model
    cargarDatos();                                                                      //Llamada a la funcion de cargar datos a la tabla 
    }//GEN-LAST:event_botondescargaActionPerformed

    private void botonirmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonirmenuActionPerformed
LOGIN ir = new LOGIN();                   //Creamos un objeto perteneciente a la clase MENU
ir.setVisible(true);                    //Hacer Visible la clase Menu
this.dispose();                         //Cerrar este frame
    }//GEN-LAST:event_botonirmenuActionPerformed

    private void BotonSegundaTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSegundaTablaActionPerformed
   DatosTabla2(); // Visualizar las columnas y los datos de la segunda tabla.
    }//GEN-LAST:event_BotonSegundaTablaActionPerformed

    private void VerTabla2(){
          tabla2.addColumn("ID REGISTRO");                //Titulo 1 de la Tabla
        tabla2.addColumn("NUMERO DE SERIE");            //Titulo 1 de la Tabla
        tabla2.addColumn("DESCRIPCION");                //Titulo 1 de la Tabla
        tabla2.addColumn("CANTIDAD BULTOS");            //Titulo 1 de la Tabla
        tabla2.addColumn("CANTIDAD TOTAL");             //Titulo 1 de la Tabla
        this.tablabase2.setModel(tabla2);               //Funcion que la tabla se acomoda en el modelo del frame
    }
    
    private void DatosTabla2(){
         String data2[] = new String[5];                                                                                  //Variable que almacena los datos de la consulta
         String fecha = relojfecha.getFecha().toString();
         System.out.println(""+ fecha);
        String SQL2 = "SELECT ID, NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL FROM Captura WHERE FECHA= '"+fecha+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL2);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data2[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                data2[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                data2[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                data2[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                data2[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                int  conteo = Integer.parseInt(data2[4]);
                int conteototal =+ conteo;
                total.setText(""+conteototal);
            }
                
                tabla2.addRow(data2);                                         //Funcion que agrafar todos los valores del arreglo data a la tabla
              
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }
    }
    
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
            java.util.logging.Logger.getLogger(CAPTURAOPERADOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CAPTURAOPERADOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CAPTURAOPERADOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CAPTURAOPERADOR.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CAPTURAOPERADOR().setVisible(true);
            }
        });
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCaptura;
    private javax.swing.JButton BotonSegundaTabla;
    private javax.swing.JButton botondescarga;
    private javax.swing.JButton botonirmenu;
    private javax.swing.JButton botonlimpiar;
    private javax.swing.JTextField cantidaddebultos;
    private javax.swing.JTextField cantidadtotal;
    private javax.swing.JTextField descripcion;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField nparte;
    private rojeru_san.RSLabelFechaBeanInfo rSLabelFechaBeanInfo1;
    private rojeru_san.RSLabelFecha relojfecha;
    private rojeru_san.RSLabelHora relojhora;
    private javax.swing.JTable tablabase;
    private javax.swing.JTable tablabase2;
    private javax.swing.JLabel total;
    private javax.swing.JComboBox<String> usuriocombobox;
    // End of variables declaration//GEN-END:variables

        }
//Fin del codigo de desarrollo