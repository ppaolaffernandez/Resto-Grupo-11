
package Vista;

import Modelo.Cliente;
import Modelo.ClienteData;
import Modelo.Conexion;
import Modelo.Reserva;
import Modelo.ReservaData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
   
 public class VistaReservas extends javax.swing.JInternalFrame
{
  private Conexion conexion;   
  private ReservaData reservaData;
  private ClienteData clienteData;
  private ArrayList<Reserva> listaReservas;
  private ArrayList<Cliente> listaClientes;
  private DefaultTableModel modeloReserva;
  
    public VistaReservas() 
    {
        initComponents();
   
        try 
        {    
            modeloReserva=new DefaultTableModel();
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            
            reservaData = new ReservaData(conexion); 
            clienteData = new ClienteData(conexion);
            
            cargaDatosTablaReservas();
            armaCabeceraTablaReserva();
           
            listaClientes =(ArrayList)clienteData.obtenerClientesDeReservas();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(VistaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
//_______________________________Reserva Tabla___________________________________
        
        public void armaCabeceraTablaReserva()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID");
            columnas.add("Cliente");
            columnas.add("MESA");
            columnas.add("HORA");
            columnas.add("FECHA");
        
            for(Object vp:columnas)
            {   
                modeloReserva.addColumn(vp);
            }
            tReserva.setModel(modeloReserva);
        }
        public void cargaDatosTablaReservas()
        {
            borraFilasTablaReserva();
            String seleccionado=cbClientes.getSelectedItem().toString();
            Cliente cliente=clienteData.buscarClienteNombre(seleccionado);
            
            listaReservas =(ArrayList)reservaData.obtenerReservasXCliente(cliente.getIdCliente());
            
            for(Reserva r:listaReservas)//Llenar filas
            {     
                modeloReserva.addRow(new Object[]{r.getIdReserva(),r.getCliente().getNombre(),r.getMesa().getIdMesa(),r.getHora(),r.getFecha()});         
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cbClientes = new javax.swing.JComboBox<>();
        lblReserva = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tReserva = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        jButton4.setText("jButton4");

        setMaximumSize(new java.awt.Dimension(828, 650));
        setMinimumSize(new java.awt.Dimension(828, 650));
        setPreferredSize(new java.awt.Dimension(880, 650));
        getContentPane().setLayout(null);

        jLabel2.setText("Dia y Hora");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 60, 20);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(70, 50, 80, 30);

        jLabel4.setText("Ubicación");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(180, 60, 60, 20);
        getContentPane().add(jTextField3);
        jTextField3.setBounds(240, 50, 90, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        jButton1.setText("Buscar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton1);
        jButton1.setBounds(340, 40, 120, 50);

        jLabel3.setText("Comensales");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 110, 60, 30);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(70, 110, 79, 30);

        jLabel5.setText("Cliente");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(180, 120, 40, 14);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO VER_副本.png"))); // NOI18N
        jButton2.setText("Ver todas");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 100, 110, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("--RESERVA--");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(150, 0, 100, 30);

        cbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClientesActionPerformed(evt);
            }
        });
        getContentPane().add(cbClientes);
        cbClientes.setBounds(240, 110, 100, 20);

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
        jRadioButton4.setText("Telefono");
        getContentPane().add(jRadioButton4);
        jRadioButton4.setBounds(520, 100, 67, 23);

        jRadioButton5.setBackground(new java.awt.Color(255, 204, 204));
        jRadioButton5.setText("Nombre");
        getContentPane().add(jRadioButton5);
        jRadioButton5.setBounds(630, 100, 63, 23);

        jRadioButton6.setBackground(new java.awt.Color(255, 204, 204));
        jRadioButton6.setText("Direccion");
        getContentPane().add(jRadioButton6);
        jRadioButton6.setBounds(740, 100, 69, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(480, 0, 360, 170);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("--LISTADO DE MESA DISPONIBLE--");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 190, 250, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.setGridColor(new java.awt.Color(255, 204, 255));
        jTable1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 240, 320, 200);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel9.setText("jLabel9");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 180, 330, 280);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RESERVARICONO ROSA_副本.png"))); // NOI18N
        jButton5.setText("Reservar");
        jButton5.setBorder(null);
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton5);
        jButton5.setBounds(10, 480, 120, 80);

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

        tReserva.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tReserva.setForeground(new java.awt.Color(0, 153, 153));
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
        tReserva.setGridColor(new java.awt.Color(255, 204, 255));
        tReserva.setSelectionBackground(new java.awt.Color(255, 204, 255));
        tReserva.setSelectionForeground(new java.awt.Color(255, 204, 255));
        jScrollPane2.setViewportView(tReserva);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(350, 240, 480, 200);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(340, 180, 520, 280);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RECHAZARROSA_副本_2.png"))); // NOI18N
        jButton7.setText("Cancelar");
        jButton7.setBorder(null);
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton7);
        jButton7.setBounds(720, 480, 100, 60);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO VER_副本.png"))); // NOI18N
        jButton8.setText("Ver Reserva");
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton8);
        jButton8.setBounds(600, 480, 59, 60);

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiarrosa_副本.png"))); // NOI18N
        jButton9.setText("Limpiar");
        jButton9.setBorder(null);
        jButton9.setBorderPainted(false);
        jButton9.setContentAreaFilled(false);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton9);
        jButton9.setBounds(470, 480, 100, 60);

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar rosa_1.png"))); // NOI18N
        jButton10.setText("Borrar");
        jButton10.setBorder(null);
        jButton10.setBorderPainted(false);
        jButton10.setContentAreaFilled(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton10);
        jButton10.setBounds(350, 480, 120, 60);

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/sALIRROSA_副本.png"))); // NOI18N
        jButton11.setText("Salir");
        jButton11.setBorder(null);
        jButton11.setBorderPainted(false);
        jButton11.setContentAreaFilled(false);
        jButton11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton11);
        jButton11.setBounds(710, 560, 120, 50);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(340, 470, 510, 150);

        jLabel15.setBackground(new java.awt.Color(255, 204, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/2.jpg"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(0, 0, 850, 620);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClientesActionPerformed
                borraFilasTablaReserva();
                cargaDatosTablaReservas();
    }//GEN-LAST:event_cbClientesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblReserva;
    private javax.swing.JTable tReserva;
    // End of variables declaration//GEN-END:variables

   
}
