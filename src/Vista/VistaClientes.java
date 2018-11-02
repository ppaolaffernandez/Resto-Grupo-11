
package Vista;

import Modelo.Cliente;
import Modelo.ClienteData;
import Modelo.Conexion;
import Modelo.Mesa;
import Modelo.MesaData;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class VistaClientes extends javax.swing.JInternalFrame
{
private ClienteData clienteData;
private Conexion conexion;
private ArrayList<Cliente> listaClientes;
private DefaultTableModel modeloClientes;

    public VistaClientes() 
    {
        initComponents();
//      setLocationRelativeTo(null); // poner form al medio
        
        validarSoloNumeros(tbDni);
        validarSoloLetras(tbNombre);
        limitarCaracteres(tbDni,8);
        
        try 
        {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            clienteData = new ClienteData(conexion);

            modeloClientes=new DefaultTableModel();
            armaCabeceraTablaCliente();//pone los titulos de la tabla
            
           
            cargaDatosTablaCliente();
            tbId.setVisible(false);//ocultamos la caja blanca(textfield)ID.
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(VistaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCliente = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tbDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        chActivo = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        tbId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(543, 541));
        setMinimumSize(new java.awt.Dimension(543, 541));
        setPreferredSize(new java.awt.Dimension(543, 541));
        getContentPane().setLayout(null);

        jLabel7.setText("Nombre");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 330, 60, 30);

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar);
        tbBuscar.setBounds(130, 330, 220, 30);

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        btnBuscar1.setText("Buscar");
        btnBuscar1.setToolTipText("");
        btnBuscar1.setBorder(null);
        btnBuscar1.setBorderPainted(false);
        btnBuscar1.setContentAreaFilled(false);
        btnBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBuscar1.setName("btBuscar"); // NOI18N
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar1);
        btnBuscar1.setBounds(390, 310, 100, 60);

        tCliente.setModel(new javax.swing.table.DefaultTableModel(
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
        tCliente.setMaximumSize(new java.awt.Dimension(632, 663));
        tCliente.setMinimumSize(new java.awt.Dimension(632, 663));
        tCliente.setPreferredSize(new java.awt.Dimension(632, 663));
        tCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tClienteMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tCliente);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 380, 480, 100);

        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cLIENTES副本.png"))); // NOI18N
        jLabel5.setText("CLIENTES");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(160, 0, 220, 90);

        jLabel3.setText("DNI");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 110, 60, 30);

        tbDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDniActionPerformed(evt);
            }
        });
        getContentPane().add(tbDni);
        tbDni.setBounds(130, 110, 260, 30);

        jLabel4.setText("NOMBRE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 160, 60, 30);

        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tbNombre);
        tbNombre.setBounds(130, 160, 260, 30);

        jLabel6.setText("ACTIVO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 210, 60, 30);

        chActivo.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(chActivo);
        chActivo.setBounds(130, 210, 30, 30);

        btnGuardar.setBackground(new java.awt.Color(255, 204, 255));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
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
        btnGuardar.setBounds(20, 260, 110, 40);

        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar rosa_1.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setBorder(null);
        btnBorrar.setBorderPainted(false);
        btnBorrar.setContentAreaFilled(false);
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar);
        btnBorrar.setBounds(270, 250, 120, 60);

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar rosa_副本_1.png"))); // NOI18N
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
        btnActualizar.setBounds(160, 260, 100, 40);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiarrosa_副本.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(400, 260, 90, 40);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(490, 10, 40, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel8.setText("jLabel8");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(2, 0, 540, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void tbDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDniActionPerformed

    private void tbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

//AGREGE YO CLAUDIA PARA GUARDAR LOS CLIENTES
             if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente : ");
        }
             else  if(tbDni.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el dni del cliente : ");
        }     
        else
        {
            int dni=Integer.parseInt(tbDni.getText());
            String nombre=tbNombre.getText();
            boolean activo=chActivo.isSelected();

            Cliente cliente=new Cliente(dni,nombre,activo);
            clienteData.guardarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente agregado : ");
            tbId.setText(cliente.getIdCliente()+"");
            limpiar();
            borraFilasTablaCliente();
            cargaDatosTablaCliente();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente : ");
        }
        else
        {
        int id=Integer.parseInt(tbId.getText());
        clienteData.borrarCliente(id);
        JOptionPane.showMessageDialog(null, "Borrado");
        limpiar();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(tbNombre.getText().isEmpty())//AGREGE ACTUALIZAR PARA ACTUALIZAR CLIENTES
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente : ");
        }
        else if(tbDni.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el dni del cliente : ");
        }
        else
        {
            int id=Integer.parseInt(tbId.getText());
            int dni=Integer.parseInt(tbDni.getText());
            String nombre=tbNombre.getText();//Las cajas blancas siempre son string , si es numero convertir en integer si no, MO.
            boolean activo=chActivo.isSelected();
 
            
            Cliente cliente=new Cliente(id,dni,nombre,activo);
            clienteData.actualizarCliente(cliente);
            JOptionPane.showMessageDialog(null, "Cliente actualizado : ");
            tbId.setText(cliente.getIdCliente()+"");
            limpiar();
            borraFilasTablaCliente();
            cargaDatosTablaCliente();
            
            
//            Mesa mesa=new Mesa(id,nombre,cantidad,estado,activo);
//            mesaData.actualizarMesa(mesa);
//            limpiar();
//            borraFilasTablaMesa();
//            cargaDatosTablaMesa();
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        tbId.setText("");
        tbNombre.setText("");
        tbDni.setText("");
        chActivo.setSelected(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del cliente : ");
        }
        
        else //SI HAY ALGO BUSCA
        {
            borraFilasTablaCliente();
            cargaDatosTablaCliente(tbBuscar.getText());

        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void tClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tClienteMousePressed
        int filaseleccionada = tCliente.getSelectedRow();

        try
        {
            
            
            
            tbId.setText(tCliente.getValueAt(filaseleccionada, 0).toString());
            tbDni.setText(tCliente.getValueAt(filaseleccionada, 1).toString());
            tbNombre.setText(tCliente.getValueAt(filaseleccionada, 2).toString());
            chActivo.setSelected(Boolean.parseBoolean(tCliente.getValueAt(filaseleccionada, 3).toString()) );

        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }
    }//GEN-LAST:event_tClienteMousePressed
    public void limpiar()
    {
        tbId.setText("");
        tbNombre.setText("");
        tbDni.setText("");
        chActivo.setSelected(false);
    }
    public void cargaDatosTablaCliente(String Dato)
        {   
            borraFilasTablaCliente();
            listaClientes=(ArrayList)clienteData.obtenerClientesPorNombre(Dato);         
            //Llenar filas
            for(Cliente c:listaClientes)
            {
                modeloClientes.addRow(new Object[]{c.getIdCliente(),c.getDni() ,c.getNombre() ,c.getActivo()});
                 
            }
             
        }
    public void cargaDatosTablaCliente()
        {   
            borraFilasTablaCliente();
            listaClientes=(ArrayList)clienteData.obtenerClientes();         
            //Llenar filas
            for(Cliente c:listaClientes)
            {
                modeloClientes.addRow(new Object[]{c.getIdCliente() ,c.getDni() ,c.getNombre() ,c.getActivo()});
                 
            }
             
        }

        public void borraFilasTablaCliente()//lo hice sho claudia
        {
            int a = modeloClientes.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloClientes.removeRow(i);
            }
        }
        public void armaCabeceraTablaCliente()//TAMBIEN LO HICE CLAUDAOA
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID:");
            columnas.add("DNI");
            columnas.add("NOMBRE.");
            columnas.add("ACTIVO");

            for(Object vp:columnas)
            {   
                modeloClientes.addColumn(vp);
            }
            tCliente.setModel(modeloClientes);
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tCliente;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbDni;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables
public void validarSoloLetras(JTextField campo)
{
    campo.addKeyListener(new KeyAdapter(){
       public void keyTyped(KeyEvent e)
       { 
           char c= e.getKeyChar();
           if(Character.isDigit(c))
           {
               e.consume();
           }
       }
    });

}
public void validarSoloNumeros(JTextField campo)
{
    campo.addKeyListener(new KeyAdapter()
    {
       public void keyTyped(KeyEvent e)
       { 
           char c= e.getKeyChar();
           if(!Character.isDigit(c))
           {
               e.consume();
           }
       }
    });

}
public void limitarCaracteres(JTextField campo,int cantidad)
{
    campo.addKeyListener(new KeyAdapter(){
       public void keyTyped(KeyEvent e)
       { 
           char c= e.getKeyChar();
           int tamaño=campo.getText().length();
           if(tamaño>=cantidad)
           {
               e.consume();
           }
       }
    });

}




}
