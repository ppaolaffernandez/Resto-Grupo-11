
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
                modeloMesa.addRow(new Object[]{d.getIdMesa(),d.getNombre(),d.getCantidad(),d.getEstado(),d.getActivo()});
                 
            }
             
        }
    public void cargaDatosTablaMesa()
        {   
            borraFilasTablaMesa();
            listaMesa=(ArrayList)mesaData.obtenerMesas();         
            //Llenar filas
            for(Mesa d:listaMesa)
            {
                modeloMesa.addRow(new Object[]{d.getIdMesa(),d.getNombre(),d.getCantidad(),d.getEstado(),d.getActivo()});
                 
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
            columnas.add("ACTIVO");

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
        tbHora = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tbCliente = new javax.swing.JTextField();
        chActivo = new javax.swing.JCheckBox();
        jLabel17 = new javax.swing.JLabel();
        tbCantidad = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lblReserva = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        tbId = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMesa = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tReserva = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setMaximumSize(new java.awt.Dimension(828, 650));
        setMinimumSize(new java.awt.Dimension(828, 650));
        setPreferredSize(new java.awt.Dimension(880, 650));
        getContentPane().setLayout(null);

        jLabel2.setText("Hora");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 60, 20);
        getContentPane().add(tbHora);
        tbHora.setBounds(70, 50, 80, 30);

        jLabel4.setText("Fecha");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(200, 50, 60, 20);
        getContentPane().add(tbFecha);
        tbFecha.setBounds(250, 50, 90, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 40, 120, 50);

        jLabel3.setText("Activo");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(190, 130, 60, 30);
        getContentPane().add(tbNombre);
        tbNombre.setBounds(70, 90, 79, 30);

        jLabel5.setText("Cliente");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 100, 40, 14);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO VER_副本.png"))); // NOI18N
        jButton2.setText("Ver todas");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 100, 110, 45);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("--RESERVA--");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 0, 100, 30);
        getContentPane().add(tbCliente);
        tbCliente.setBounds(250, 90, 90, 30);

        chActivo.setBackground(new java.awt.Color(255, 204, 255));
        chActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActivoActionPerformed(evt);
            }
        });
        getContentPane().add(chActivo);
        chActivo.setBounds(270, 140, 21, 21);

        jLabel17.setText("Cantidad");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(10, 130, 60, 30);
        getContentPane().add(tbCantidad);
        tbCantidad.setBounds(70, 130, 80, 30);

        jTextField2.setText("jTextField1");
        getContentPane().add(jTextField2);
        jTextField2.setBounds(70, 140, 59, 20);

        jLabel19.setText("Mesa");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(10, 80, 60, 30);

        lblReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        lblReserva.setText("jLabel1");
        lblReserva.setMaximumSize(new java.awt.Dimension(778, 639));
        lblReserva.setMinimumSize(new java.awt.Dimension(778, 639));
        lblReserva.setPreferredSize(new java.awt.Dimension(778, 639));
        getContentPane().add(lblReserva);
        lblReserva.setBounds(0, 0, 470, 170);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("--BUSCAR CLIENTE--");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(580, 10, 150, 17);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jButton3);
        jButton3.setBounds(600, 50, 140, 20);

        jRadioButton4.setBackground(new java.awt.Color(255, 204, 204));
        jRadioButton4.setText("Fecha");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(520, 100, 55, 23);

        jRadioButton5.setBackground(new java.awt.Color(255, 204, 204));
        jRadioButton5.setText("Nombre");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(630, 100, 63, 23);

        jRadioButton6.setBackground(new java.awt.Color(255, 204, 204));
        jRadioButton6.setText("Dni");
        getContentPane().add(jRadioButton6);
        jRadioButton6.setBounds(740, 100, 41, 23);

        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(799, 10, 30, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(480, 0, 360, 170);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("--LISTADO DE MESA DISPONIBLE--");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 190, 250, 40);

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
        jScrollPane1.setBounds(10, 320, 310, 100);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 180, 330, 280);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RESERVARICONO ROSA_副本.png"))); // NOI18N
        btnGuardar.setText("Reservar");
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
        btnGuardar.setBounds(10, 480, 120, 80);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/dISPONIBLEROSA_副本.png"))); // NOI18N
        jButton6.setText("Disponible");
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(170, 470, 140, 100);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 470, 330, 150);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("--LISTADO DE RESERVA--");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(490, 190, 190, 40);

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

        jLabel16.setText("Nombre");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(370, 270, 60, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(340, 180, 500, 280);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RECHAZARROSA_副本_2.png"))); // NOI18N
        jButton7.setText("Cancelar");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton7);
        jButton7.setBounds(720, 470, 100, 60);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO VER_副本.png"))); // NOI18N
        jButton8.setText("Ver Reserva");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton8);
        jButton8.setBounds(600, 470, 109, 60);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiarrosa_副本.png"))); // NOI18N
        jButton9.setText("Limpiar");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton9);
        jButton9.setBounds(470, 460, 100, 60);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar rosa_1.png"))); // NOI18N
        jButton10.setText("Borrar");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton10);
        jButton10.setBounds(350, 460, 120, 60);

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
        jButton11.setBounds(720, 530, 120, 50);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(340, 470, 510, 150);

        jLabel15.setBackground(new java.awt.Color(255, 204, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 850, 620);

        jLabel18.setText("Mesa");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(10, 80, 60, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            tbCliente.setText(tReserva.getValueAt(filaseleccionada, 1).toString());
            tbNombre.setText(tReserva.getValueAt(filaseleccionada, 2).toString());
            tbHora.setText(tReserva.getValueAt(filaseleccionada, 3).toString());
            tbFecha.setText(tReserva.getValueAt(filaseleccionada, 4).toString());
            chActivo.setSelected(Boolean.parseBoolean(tReserva.getValueAt(filaseleccionada, 5).toString()) );
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }

    }//GEN-LAST:event_tReservaMousePressed

    private void chActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chActivoActionPerformed

    private void tMesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMesaMousePressed
          int filaseleccionada = tMesa.getSelectedRow();
        
        try
        {
            
            tbId.setText(tMesa.getValueAt(filaseleccionada, 0).toString());
            tbNombre.setText(tMesa.getValueAt(filaseleccionada, 1).toString());
            tbCantidad.setText(tMesa.getValueAt(filaseleccionada, 2).toString());
            chActivo.setSelected(Boolean.parseBoolean(tMesa.getValueAt(filaseleccionada, 4).toString()) );
        
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
       public void limpiar()
    {
        tbNombre.setText("");
//        tbDescripcion.setText("");
        chActivo.setSelected(false);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblReserva;
    private javax.swing.JTable tMesa;
    private javax.swing.JTable tReserva;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextField tbCliente;
    private javax.swing.JTextField tbFecha;
    private javax.swing.JTextField tbHora;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables

   
}
