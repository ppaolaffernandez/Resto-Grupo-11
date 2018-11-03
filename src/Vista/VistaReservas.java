
package Vista;

import Modelo.Cliente;
import Modelo.ClienteData;
import Modelo.Conexion;
import Modelo.Mesa;
import Modelo.MesaData;
import Modelo.Producto;
import Modelo.ProductoData;
import Modelo.Reserva;
import Modelo.ReservaData;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
   
 public class VistaReservas extends javax.swing.JInternalFrame
{
  private Conexion conexion;   
  private ReservaData reservaData;
  private ClienteData clienteData;
  private MesaData mesaData;
  private ArrayList<Reserva> listaReservas;
  private ArrayList<Cliente> listaClientes;
  private ArrayList<Producto>listaProductos;
  private ArrayList<Mesa>listaMesa;
  private DefaultTableModel modeloReserva;
  private DefaultTableModel modeloMesa;

    public VistaReservas() 
    {
        initComponents();
   
        try 
        {   
             
            modeloReserva=new DefaultTableModel();
            modeloMesa=new DefaultTableModel();
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            
            
            String horaActual = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
            ftbHora.setText(horaActual);
            reservaData = new ReservaData(conexion); 
            clienteData = new ClienteData(conexion);
            mesaData = new MesaData(conexion);
            
   
//_____________________________RESERVA TABLA_________________________________________________            
            armaCabeceraTablaReserva();
            cargaDatosTablaReserva();
//_____________________________MESA TABLA____________________________________________________
            armaCabeceraTablaMesa();
            cargaDatosTablaMesa();
            tbId.setVisible(false);//ocultamos la caja blanca(textfield)ID.
           
//            listaClientes =(ArrayList)clienteData.obtenerClientesDeReservas();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(VistaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
//_________________________________________________________________________________________________________________________________________________    
//_____________________________________________________________________TABLA RESERVA__________________________________________________________________
//_________________________________________________________________________________________________________________________________________________ 
         public void cargaDatosTablaReserva(String Dato)
        {   
            borraFilasTablaReserva();
            listaReservas=(ArrayList)reservaData.obtenerReservasPorNombre(Dato);         
            //Llenar filas
            for(Reserva r:listaReservas)
            {
                modeloReserva.addRow(new Object[]{r.getIdReserva(),r.getCliente().getNombre(),r.getMesa().getCantidad(),r.getHora(),r.getFecha()});                          
            }             
        }
        public void cargaDatosTablaReserva()
        {   
            borraFilasTablaReserva();
            listaReservas=(ArrayList)reservaData.obtenerReservas();         
            //Llenar filas
            for(Reserva r:listaReservas)
            {
                modeloReserva.addRow(new Object[]{r.getIdReserva(),r.getCliente().getNombre(),r.getMesa().getCantidad(),r.getHora(),r.getFecha()});                          
            }
             
        }
       public void borraFilasTablaReserva()
       {
            int a = modeloReserva.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloReserva.removeRow(i );
            }
      } 

       public void armaCabeceraTablaReserva()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID");
            columnas.add("CLIENTE");
            columnas.add("NOMBRE");
            columnas.add("MESA");
            columnas.add("HORA");
            columnas.add("FECHA");
        
                for(Object vp:columnas)
                {   
                    modeloReserva.addColumn(vp);
                }
                    tReserva.setModel(modeloReserva);
        }
//_____________________________________________________________________________________________________________________________________________
// __________________________________________________________TABLA MESA________________________________________________________________________      
//_____________________________________________________________________________________________________________________________________________       
    
public void cargaDatosTablaMesa(String Dato)
        {   
            borraFilasTablaMesa();
            listaMesa=(ArrayList)mesaData.obtenerMesasPorNombre(Dato);         
            //Llenar filas
            for(Mesa d:listaMesa)
            {
                modeloMesa.addRow(new Object[]{d.getIdMesa(),d.getNombre(),d.getCantidad(),d.getEstado()});
                 
            }
             
        }
    public void cargaDatosTablaMesa()
        {   
            borraFilasTablaMesa();
            listaMesa=(ArrayList)mesaData.obtenerMesas();         
            //Llenar filas
            for(Mesa d:listaMesa)
            {
                modeloMesa.addRow(new Object[]{d.getIdMesa(),d.getNombre(),d.getCantidad(),d.getEstado()});
                 
            }
             
        }

        public void borraFilasTablaMesa()
        {
            int a = modeloMesa.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloMesa.removeRow(i);
            }
        }
        public void armaCabeceraTablaMesa()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID:");
            columnas.add("NOMBRE.");
            columnas.add("CANTIDAD");
            columnas.add("ESTADO");
            

            for(Object vp:columnas)
            {   
                modeloMesa.addColumn(vp);
            }
            tMesa.setModel(modeloMesa);
        }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarDniCliente = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        cbFecha = new javax.swing.JTextField();
        btnBuscarFecha = new javax.swing.JButton();
        ftbHora = new javax.swing.JFormattedTextField();
        lblReserva = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tbId = new javax.swing.JTextField();
        tbDni = new javax.swing.JTextField();
        tbNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMesa = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tReserva = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setMaximumSize(new java.awt.Dimension(828, 650));
        setMinimumSize(new java.awt.Dimension(828, 650));
        setPreferredSize(new java.awt.Dimension(880, 650));
        getContentPane().setLayout(null);

        jLabel2.setText("Hora");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 50, 60, 20);

        jLabel4.setText("Fecha");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(530, 50, 60, 20);

        btnBuscarDniCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        btnBuscarDniCliente.setText("Buscar");
        btnBuscarDniCliente.setBorder(null);
        btnBuscarDniCliente.setBorderPainted(false);
        btnBuscarDniCliente.setContentAreaFilled(false);
        btnBuscarDniCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscarDniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarDniClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarDniCliente);
        btnBuscarDniCliente.setBounds(270, 90, 90, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("--RESERVA--");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(340, 0, 140, 30);
        getContentPane().add(jdcFecha);
        jdcFecha.setBounds(580, 50, 120, 30);

        cbFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbFechaActionPerformed(evt);
            }
        });
        getContentPane().add(cbFecha);
        cbFecha.setBounds(720, 40, 110, 60);

        btnBuscarFecha.setText("Buscar");
        btnBuscarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarFechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscarFecha);
        btnBuscarFecha.setBounds(660, 110, 90, 40);

        try {
            ftbHora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(ftbHora);
        ftbHora.setBounds(419, 100, 50, 40);

        lblReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        lblReserva.setText("jLabel1");
        lblReserva.setMaximumSize(new java.awt.Dimension(778, 639));
        lblReserva.setMinimumSize(new java.awt.Dimension(778, 639));
        lblReserva.setPreferredSize(new java.awt.Dimension(778, 639));
        getContentPane().add(lblReserva);
        lblReserva.setBounds(380, 0, 470, 170);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("--BUSCAR CLIENTE--");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(100, 50, 150, 17);

        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(320, 50, 30, 20);
        getContentPane().add(tbDni);
        tbDni.setBounds(130, 80, 130, 30);
        getContentPane().add(tbNombre);
        tbNombre.setBounds(140, 120, 120, 20);

        jLabel1.setText("DNI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 90, 18, 14);

        jLabel20.setText("Nombre");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(30, 120, 37, 14);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 40, 360, 170);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("--LISTADO DE MESA DISPONIBLE--");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 250, 250, 40);

        tMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tMesaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tMesa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 330, 310, 100);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 210, 330, 250);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RESERVARICONO ROSA_副本.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorder(null);
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar);
        btnGuardar.setBounds(460, 160, 120, 80);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dISPONIBLEROSA_副本.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setBorder(null);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar);
        btnActualizar.setBounds(590, 150, 140, 100);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("--LISTADO DE RESERVA--");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(490, 210, 190, 40);

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar);
        tbBuscar.setBounds(450, 270, 220, 30);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setToolTipText("");
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setContentAreaFilled(false);
        btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar.setName("btBuscar"); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(690, 260, 100, 60);

        tReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tReserva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tReservaMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tReserva);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(340, 320, 480, 100);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Listar Por Fecha", "Listar Por Dia", " " }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(350, 270, 80, 20);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar rosa_1.png"))); // NOI18N
        jButton10.setText("Borrar");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton10);
        jButton10.setBounds(730, 170, 120, 60);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sALIRROSA_副本.png"))); // NOI18N
        jButton11.setText("Salir");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11);
        jButton11.setBounds(720, 460, 120, 50);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(340, 210, 500, 250);

        jLabel15.setBackground(new java.awt.Color(255, 204, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 850, 620);

        jLabel18.setText("Mesa");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(10, 80, 60, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else //SI HAY ALGO BUSCA
        {
            borraFilasTablaReserva();
            cargaDatosTablaReserva(tbBuscar.getText());

        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tReservaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tReservaMousePressed
        int filaseleccionada = tReserva.getSelectedRow();
        try
        {
            tbId.setText(tReserva.getValueAt(filaseleccionada, 0).toString());
            
            ftbHora.setText(tReserva.getValueAt(filaseleccionada, 1).toString());
//            chActivo.setSelected(Boolean.parseBoolean(tReserva.getValueAt(filaseleccionada, 5).toString()) );
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }

    }//GEN-LAST:event_tReservaMousePressed

    private void tMesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMesaMousePressed
          int filaseleccionada = tMesa.getSelectedRow();
        
        try
        {
            
            tbId.setText(tMesa.getValueAt(filaseleccionada, 0).toString());
            
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }


    }//GEN-LAST:event_tMesaMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed


//       int filaSeleccionada = this.tReserva.getSelectedRow();
//
//        try
//        {
//
//            if(filaSeleccionada == -1)
//            {
//                JOptionPane.showMessageDialog(null, "Seleccione una mesa", "Error", JOptionPane.WARNING_MESSAGE);
//            }
//            else if(Integer.parseInt(sCantidad.getValue().toString())== 0)
//            {
//                JOptionPane.showMessageDialog(null, "Ingrese cliente", "Error", JOptionPane.WARNING_MESSAGE);
//            }
//            else
//            {
//                Reserva reserva = reservaData.buscarReserva(NuevoReserva);
//
//                int idProductoSeleccionado = Integer.parseInt(tProducto.getValueAt(filaSeleccionada, 0).toString());
//
//                Reserva reserva = reservaData.buscarReserva(idReservaSeleccionado);
//
//                if(reserva != null)
//                {
//                    int cantidad = parseInt(sCantidad.getValue().toString());
//
//                    double total = cantidad * producto.getPrecio();
//                    boolean activo = true;
//
//                    Detalle detalle = new Detalle(producto,pedido,cantidad,total,activo);
//                    detalleData.guardarDetalle(detalle);
//                    cargaDatosTablaDetalle(detalle.getPedido().getIdPedido());
//    private int idReserva=-1;
//    private Cliente cliente;
//    private Mesa mesa;
//    private String hora;
//    private Date fecha;   
//    private boolean activo;
//                }
//            }
//        }
//        catch (Exception e)
//        {
//            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
//        }
//                            
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarDniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarDniClienteActionPerformed
 
    

    }//GEN-LAST:event_btnBuscarDniClienteActionPerformed

    private void cbFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbFechaActionPerformed

    private void btnBuscarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarFechaActionPerformed
String dia = Integer.toString(jdcFecha.getCalendar().get(Calendar.DAY_OF_MONTH));
String mes = Integer.toString(jdcFecha.getCalendar().get(Calendar.MONTH) + 1);
String year = Integer.toString(jdcFecha.getCalendar().get(Calendar.YEAR));
String fecha = (year + "-" + mes+ "-" + dia);
cbFecha.setText(fecha);
    }//GEN-LAST:event_btnBuscarFechaActionPerformed
       public void limpiar()
       {}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscarDniCliente;
    private javax.swing.JButton btnBuscarFecha;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JTextField cbFecha;
    private javax.swing.JFormattedTextField ftbHora;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel lblReserva;
    private javax.swing.JTable tMesa;
    private javax.swing.JTable tReserva;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbDni;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables

   
}
