//INICIO DEL CODIGO PARA LA CAPTURA DE CAPTURA

package Informacion;                           //Paquete de Captura


import Inicio.LOGIN;
import Inicio.MENU;                                                               //Importamos la clase de MENU
import javax.swing.JOptionPane;                                                 //libreria para pantallas emergentes
import java.sql.Connection;                                                     //Libreria que hace la conexion a la Base de Datos
import java.sql.DriverManager;                                                  //Libreria que carga el driver que realiza la conexion a la Base de Datos
import java.sql.SQLException;                                                   //Libreria que hace las excepciones en los errores de SQL
import java.sql.Statement;                                                      //Libreria que carga el objeto que contiene los Strings SQL
import java.util.logging.Level;                                                 //Libreria para crear Excepciones en caso de que los Querys no funcionen
import java.util.logging.Logger;                                                //Libreria para crear Excepciones en caso de que los Querys no funcionen
import java.sql.ResultSet;                                                      //Libreria que implementa el objeto Resultset para cargar los SQL
import javax.swing.table.DefaultTableModel;                                     //Libreria que instancia un modelo de tabla

public class CAPTURA extends javax.swing.JFrame {                                //Inicio de la clase de pruebas para frames
    
public CAPTURA(){                                                                //Constructor de la clase
        initComponents();                                                       //Metodo para iniciar los componentes visuales de la interfaz grafica
        this.setLocationRelativeTo(null);                                       //Centrar el Frame
        conectarBaseDatos();                                                    //Metodo que realiza la conexion a la base de datos
        DefaultTableModel tabla = new DefaultTableModel();                      //Codigo que crea el modelo de la tabla
        cargarTitulosColumas();                                                 //Metodo iniciado para cargar titulos de las tablas en cada columna correspondiente
        cargarDatos();  
     
    }
 int conteo;   
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

int conteodeproduccion;

  String fecha = JOptionPane.showInputDialog("Fecha de hoy");




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rSLabelFechaBeanInfo1 = new rojeru_san.RSLabelFechaBeanInfo();
        CombobpxUsuario = new javax.swing.JComboBox<>();
        BotonCaptura = new javax.swing.JButton();
        BotonIrMenu = new javax.swing.JButton();
        BotonLimpiar = new javax.swing.JButton();
        LabelTitulo = new javax.swing.JLabel();
        LabelNumeroSerie = new javax.swing.JLabel();
        LabelDescripcion = new javax.swing.JLabel();
        LabelBultos = new javax.swing.JLabel();
        LabelCantidadTotal = new javax.swing.JLabel();
        LabelUsuario = new javax.swing.JLabel();
        LabelDesviacion = new javax.swing.JLabel();
        TxtNumeroSerie = new javax.swing.JTextField();
        TxtDescripcion = new javax.swing.JTextField();
        TxtBultos = new javax.swing.JTextField();
        TxtCantidadTotal = new javax.swing.JTextField();
        ScrollTabla = new javax.swing.JScrollPane();
        TablaModelo = new javax.swing.JTable();
        ScrollDesviacion = new javax.swing.JScrollPane();
        TxtDesviacion = new javax.swing.JTextArea();
        DisplayHora = new rojeru_san.RSLabelHora();
        DisplayFecha = new rojeru_san.RSLabelFecha();
        LabelHora = new javax.swing.JLabel();
        LabelFecha = new javax.swing.JLabel();
        TxtFecha = new javax.swing.JTextField();
        TxtHora = new javax.swing.JTextField();
        LabelObjetivo = new javax.swing.JLabel();
        LabelCantidadObjetivo = new javax.swing.JLabel();
        LabelCantidadProducido = new javax.swing.JLabel();
        LabelProducido = new javax.swing.JLabel();
        BotonCaptura1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        CombobpxUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Juan Moreno", "Leopoldo Campos", "Jose Batres", "Manuel Hernandez", "Kaleb Chavira" }));

        BotonCaptura.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonCaptura.setText("Capturar");
        BotonCaptura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCapturaActionPerformed(evt);
            }
        });

        BotonIrMenu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonIrMenu.setText("Cerrar Sesion");
        BotonIrMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIrMenuActionPerformed(evt);
            }
        });

        BotonLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonLimpiar.setText("LIMPIAR");

        LabelTitulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        LabelTitulo.setText("MODULO DE CAPTURA DE FRAMES W.SILVER PRODUCTS");

        LabelNumeroSerie.setText("Numero S:");

        LabelDescripcion.setText("Descripcion:");

        LabelBultos.setText("Cantidad de Bultos:");

        LabelCantidadTotal.setText("Cantidad Total:");

        LabelUsuario.setText("Usuario:");

        LabelDesviacion.setText("Desviacion:");

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
        ScrollTabla.setViewportView(TablaModelo);

        TxtDesviacion.setColumns(20);
        TxtDesviacion.setRows(5);
        ScrollDesviacion.setViewportView(TxtDesviacion);

        LabelHora.setText("Hora:");

        LabelFecha.setText("Fecha:");

        LabelObjetivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelObjetivo.setText("Objetivo:");

        LabelCantidadObjetivo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelCantidadObjetivo.setText("2000 Frames");

        LabelCantidadProducido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelCantidadProducido.setText("Frames");

        LabelProducido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelProducido.setText("Producido:");

        BotonCaptura1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BotonCaptura1.setText("Tabla");
        BotonCaptura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCaptura1ActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
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
                .addContainerGap(52, Short.MAX_VALUE)
                .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelHora, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelCantidadTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDesviacion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelNumeroSerie, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelDescripcion, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LabelBultos, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollDesviacion)
                            .addComponent(TxtHora)
                            .addComponent(TxtFecha)
                            .addComponent(CombobpxUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TxtCantidadTotal)
                            .addComponent(TxtBultos)
                            .addComponent(TxtDescripcion)
                            .addComponent(TxtNumeroSerie)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelCantidadProducido)
                                    .addComponent(LabelCantidadObjetivo))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonCaptura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotonIrMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BotonCaptura1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelProducido)
                            .addComponent(LabelObjetivo))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(117, 117, 117)
                    .addComponent(LabelTitulo)
                    .addContainerGap(562, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelObjetivo)
                    .addComponent(LabelCantidadObjetivo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelProducido, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LabelCantidadProducido))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelNumeroSerie)
                                    .addComponent(TxtNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelDescripcion)
                                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelBultos)
                                    .addComponent(TxtBultos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LabelCantidadTotal)
                                    .addComponent(TxtCantidadTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CombobpxUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(LabelUsuario))
                                .addGap(18, 18, 18)
                                .addComponent(LabelFecha))
                            .addComponent(TxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LabelHora)
                            .addComponent(TxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ScrollDesviacion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDesviacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(BotonCaptura, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                                    .addComponent(BotonCaptura1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BotonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BotonIrMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(50, 50, 50))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ScrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DisplayHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DisplayFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(LabelTitulo)
                    .addContainerGap(699, Short.MAX_VALUE)))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonCaptura, BotonIrMenu, BotonLimpiar});

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
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\KCHAVIRA\\Documents\\GitHub\\Wsp-Frames\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
  conexion = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Kaleb\\Documents\\GitHub\\WSPFRAMES\\BD\\FRAMES.accdb");         //Objeto que busca la Base de Datos
 // JOptionPane.showMessageDialog(null, "Se encontro correctamente la Base de Datos");                                  //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                                      //Excepcion en caso de que el query no funcione
 //           JOptionPane.showMessageDialog(null, "Error en la dirección de la base de datos");                           //Mensaje al usuario para verificacion
        }
        try {
            sentencia = conexion.createStatement();                                                                     //Objeto que conecta la Base de Datos
   //         JOptionPane.showMessageDialog(null, "Conexion Exitosa");                                                  //Mensaje al usuario para verificacion
        } catch (SQLException e) {                                                                                      //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al crear la conexión con la base de datos");                     //Mensaje al usuario para verificacion
        }
    }
    
    public void cargarDatos() {                                                                                         //Funcion con la que se carga los datos en la tabla del frame
        String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
      
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,FECHA,HORA,DESVIACION FROM Captura WHERE FECHA ='" +fecha+"';";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[5] = resultado.getString("USUARIO");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[6] = resultado.getString("FECHA");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[7] = resultado.getString("HORA");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[8] = resultado.getString("DESVIACION");           //Variable del arreglo que recibira todas las cantidades totales del dia
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
        tabla.addColumn("USUARIO");
        tabla.addColumn("FECHA");
        tabla.addColumn("HORA");
        tabla.addColumn("DESVIACION");
        this.TablaModelo.setModel(tabla);                     //Funcion que la tabla se acomoda en el modelo del frame
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
    String hora = TxtHora.getText().toString();                         //Asiganacion a una variable String que obtiene el texto de un JText
    String fecha = TxtFecha.getText().toString();                       //Asiganacion a una variable String que obtiene el texto de un JText
    String clerk = CombobpxUsuario.getSelectedItem().toString();                 //Asiganacion a una variable String que obtiene el texto de un JText
    String noparte = this.TxtNumeroSerie.getText();                                     //Asiganacion a una variable String que obtiene el texto de un JText
    String descripcion = this.TxtDescripcion.getText();                            //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadbultos = this.TxtBultos.getText();                    //Asiganacion a una variable String que obtiene el texto de un JText
    String cantidadtotal = this.TxtCantidadTotal.getText();                        //Asiganacion a una variable String que obtiene el texto de un JText
    String desviacion = this.TxtDesviacion.getText();
    String usuario = CombobpxUsuario.getSelectedItem().toString();
    //Instruccion sql dentro de una variable String llamada SQL
    String SQL ="insert into Captura(NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,DESVIACION,USUARIO,HORA,FECHA) values " + "('" + noparte + "','" + descripcion + "','" + cantidadbultos + "','" + cantidadtotal + "','"+ desviacion +"','"+ usuario+"','"+hora+"','"+fecha+"')";
    try {
        System.out.println("Fecha "+fecha+" Hora " + hora);
        sentencia.executeUpdate(SQL);                                                   //Se ejecuta el Query SQL en la base de datos
        JOptionPane.showMessageDialog(null,"CAPTURADO");                                //Mensaje al usuario
    } catch (SQLException ex) {                                                         //Excepcion en caso de que el query no funcione
        JOptionPane.showMessageDialog(null,"NO CAPTURADO");                             //Mensaje al usuario
        Logger.getLogger(CAPTURA.class.getName()).log(Level.SEVERE, null, ex);           //Excepcion en caso de que el query no funcione
    }
    tabla.setRowCount(0);                                                               //Funcion para vaciar la tabla del Model
    cargarDatos();                                                                      //Llamada a la funcion de cargar datos a la tabla 
        
      int cambio = Integer.parseInt(cantidadtotal);
       conteo +=cambio;     
    
       LabelCantidadProducido.setText(conteo+ " Frames");
    }//GEN-LAST:event_BotonCapturaActionPerformed

    private void BotonIrMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIrMenuActionPerformed
LOGIN ir = new LOGIN();                   //Creamos un objeto perteneciente a la clase MENU
ir.setVisible(true);                    //Hacer Visible la clase Menu
this.dispose();                         //Cerrar este frame
    }//GEN-LAST:event_BotonIrMenuActionPerformed

    private void BotonCaptura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCaptura1ActionPerformed
String data[] = new String[9];                                                                                  //Variable que almacena los datos de la consulta
        String SQL = "SELECT ID,NUMERODEPARTE,DESCRIPCION,CANTIDADBULTOS,CANTIDADTOTAL,USUARIO,FECHA,HORA,DESVIACION FROM Captura;";                  //Consulta sql de buscar datos
        try {
            ResultSet resultado = sentencia.executeQuery(SQL);                                                          //Linea que ejecuta la consulta sql y almacena los datos en resultado

            while (resultado.next()) {                                    //Bucle que recorre la consulta obtenida
                data[0] = resultado.getString("ID");                      //Variable del arreglo que recibira todos los ID
                data[1] = resultado.getString("NUMERODEPARTE");           //Variable del arreglo que recibira todos los numeros de parte
                data[2] = resultado.getString("DESCRIPCION");             //Variable del arreglo que recibira todas las descriopciones
                data[3] = resultado.getString("CANTIDADBULTOS");          //Variable del arreglo que recibira todas las cantidades de bultos
                data[4] = resultado.getString("CANTIDADTOTAL");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[5] = resultado.getString("USUARIO");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[6] = resultado.getString("FECHA");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[7] = resultado.getString("HORA");           //Variable del arreglo que recibira todas las cantidades totales del dia
                data[8] = resultado.getString("DESVIACION");           //Variable del arreglo que recibira todas las cantidades totales del dia
                tabla.addRow(data);                                       //Funcion que agrafar todos los valores del arreglo data a la tabla
            }
        } catch (SQLException ex) {                                                             //Excepcion en caso de que el query no funcione
            JOptionPane.showMessageDialog(null, "Error al cargar los Datos\n");                 //Mensaje al usuario de verificacion de error
            System.out.println(ex+"");                                                          //Imprimir la excepcion
        }
            // TODO add your handling code here:
    }//GEN-LAST:event_BotonCaptura1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(CAPTURA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CAPTURA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CAPTURA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CAPTURA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CAPTURA().setVisible(true);
            }
        });
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonCaptura;
    private javax.swing.JButton BotonCaptura1;
    private javax.swing.JButton BotonIrMenu;
    private javax.swing.JButton BotonLimpiar;
    private javax.swing.JComboBox<String> CombobpxUsuario;
    private rojeru_san.RSLabelFecha DisplayFecha;
    private rojeru_san.RSLabelHora DisplayHora;
    private javax.swing.JLabel LabelBultos;
    private javax.swing.JLabel LabelCantidadObjetivo;
    private javax.swing.JLabel LabelCantidadProducido;
    private javax.swing.JLabel LabelCantidadTotal;
    private javax.swing.JLabel LabelDescripcion;
    private javax.swing.JLabel LabelDesviacion;
    private javax.swing.JLabel LabelFecha;
    private javax.swing.JLabel LabelHora;
    private javax.swing.JLabel LabelNumeroSerie;
    private javax.swing.JLabel LabelObjetivo;
    private javax.swing.JLabel LabelProducido;
    private javax.swing.JLabel LabelTitulo;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JScrollPane ScrollDesviacion;
    private javax.swing.JScrollPane ScrollTabla;
    private javax.swing.JTable TablaModelo;
    private javax.swing.JTextField TxtBultos;
    private javax.swing.JTextField TxtCantidadTotal;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextArea TxtDesviacion;
    private javax.swing.JTextField TxtFecha;
    private javax.swing.JTextField TxtHora;
    private javax.swing.JTextField TxtNumeroSerie;
    private javax.swing.JButton jButton1;
    private rojeru_san.RSLabelFechaBeanInfo rSLabelFechaBeanInfo1;
    // End of variables declaration//GEN-END:variables

        }
//Fin del codigo de desarrollo