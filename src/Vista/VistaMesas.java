
package Vista;

import Modelo.Categoria;
import Modelo.Conexion;
import Modelo.Mesa;
import Modelo.MesaData;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaMesas extends javax.swing.JInternalFrame {
private MesaData mesaData;
private Conexion conexion;
private ArrayList<Mesa> listaMesas;
private DefaultTableModel modeloMesas;

    public VistaMesas()
    {
        initComponents();
        
        try 
        {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            mesaData = new MesaData(conexion);
            modeloMesas=new DefaultTableModel();
            armaCabeceraTablaMesa();
           
            cargaDatosTablaMesa();
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

        jLabel5 = new javax.swing.JLabel();
        tbId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jsCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        tbNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMesa = new javax.swing.JTable();
        chActivo = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(634, 539));
        setMinimumSize(new java.awt.Dimension(634, 539));
        setPreferredSize(new java.awt.Dimension(634, 539));
        getContentPane().setLayout(null);

        jLabel5.setBackground(new java.awt.Color(255, 204, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MEsas副本.png"))); // NOI18N
        jLabel5.setText("MESAS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 0, 210, 70);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(590, 0, 30, 30);

        jLabel3.setText("Capacidad");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 110, 120, 50);

        jsCantidad.setModel(new javax.swing.SpinnerNumberModel(2, 2, 10, 2));
        getContentPane().add(jsCantidad);
        jsCantidad.setBounds(180, 120, 80, 30);

        jLabel4.setText("Activo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 170, 60, 40);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar rosa.png"))); // NOI18N
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
        btnGuardar.setBounds(30, 220, 90, 50);

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
        btnBorrar.setBounds(320, 220, 90, 50);

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
        btnActualizar.setBounds(170, 220, 100, 50);

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
        btnLimpiar.setBounds(470, 220, 90, 50);
        getContentPane().add(tbNombre);
        tbNombre.setBounds(180, 70, 210, 30);

        jLabel6.setText("Nombre");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 70, 80, 30);

        jLabel7.setText("Nombre");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(80, 330, 60, 30);

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar);
        tbBuscar.setBounds(160, 330, 220, 30);

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
        btnBuscar1.setBounds(420, 310, 100, 60);

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
        tMesa.setMaximumSize(new java.awt.Dimension(632, 663));
        tMesa.setMinimumSize(new java.awt.Dimension(632, 663));
        tMesa.setPreferredSize(new java.awt.Dimension(632, 663));
        tMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tMesaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tMesa);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 380, 480, 100);

        chActivo.setBackground(new java.awt.Color(255, 204, 255));
        chActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActivoActionPerformed(evt);
            }
        });
        getContentPane().add(chActivo);
        chActivo.setBounds(180, 170, 50, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pinkmas claro_副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed

    }//GEN-LAST:event_tbIdActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else
        {
            
            String nombre=tbNombre.getText();
            int cantidad=Integer.parseInt(jsCantidad.getValue().toString());
            String estado="Libre";
            boolean activo=chActivo.isSelected();

            Mesa mesa=new Mesa(nombre,cantidad,estado,activo);
            mesaData.guardarMesa(mesa);
            JOptionPane.showMessageDialog(null, "Mesa agregada : ");
            tbId.setText(mesa.getIdMesa()+"");
            limpiar();
            borraFilasTablaMesa();
            cargaDatosTablaMesa();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else
        {
            int id=Integer.parseInt(tbId.getText());
            mesaData.borrarMesa(id);
            limpiar();
            borraFilasTablaMesa();
            cargaDatosTablaMesa();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
      if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else
        {
            int id=Integer.parseInt(tbId.getText());
            String nombre=tbNombre.getText();//Las cajas blancas siempre son string , si es numero convertir en integer si no, MO.
            int cantidad=Integer.parseInt(jsCantidad.getValue().toString());

            boolean activo=chActivo.isSelected();
            String estado="Libre";
            Mesa mesa=new Mesa(id,nombre,cantidad,estado,activo);
            mesaData.actualizarMesa(mesa);
            limpiar();
            borraFilasTablaMesa();
            cargaDatosTablaMesa();
            
        }
       
    }//GEN-LAST:event_btnActualizarActionPerformed

        public void limpiar()
        {
                  
            tbId.setText("");
            tbNombre.setText("");
            jsCantidad.setValue(0);
            chActivo.setSelected(false);
        }
    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
            limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else //SI HAY ALGO BUSCA
        {
            borraFilasTablaMesa();
            cargaDatosTablaMesa(tbBuscar.getText());

        }

    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void tMesaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMesaMousePressed
        int filaseleccionada = tMesa.getSelectedRow();
        
        try
        {
            
            tbId.setText(tMesa.getValueAt(filaseleccionada, 0).toString());
            tbNombre.setText(tMesa.getValueAt(filaseleccionada, 1).toString());
            jsCantidad.setValue(tMesa.getValueAt(filaseleccionada, 2));
           
            chActivo.setSelected(Boolean.parseBoolean(tMesa.getValueAt(filaseleccionada, 4).toString()) );
        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }

    }//GEN-LAST:event_tMesaMousePressed

    private void chActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chActivoActionPerformed
public void cargaDatosTablaMesa(String Dato)
        {   
            borraFilasTablaMesa();
            listaMesas=(ArrayList)mesaData.obtenerMesasPorNombre(Dato);         
            //Llenar filas
            for(Mesa d:listaMesas)
            {
                modeloMesas.addRow(new Object[]{d.getIdMesa(),d.getNombre(),d.getCantidad(),d.getEstado(),d.getActivo()});
                 
            }
             
        }
    public void cargaDatosTablaMesa()
        {   
            borraFilasTablaMesa();
            listaMesas=(ArrayList)mesaData.obtenerMesas();         
            //Llenar filas
            for(Mesa d:listaMesas)
            {
                modeloMesas.addRow(new Object[]{d.getIdMesa(),d.getNombre(),d.getCantidad(),d.getEstado(),d.getActivo()});
                 
            }
             
        }

        public void borraFilasTablaMesa()
        {
            int a = modeloMesas.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloMesas.removeRow(i);
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
                modeloMesas.addColumn(vp);
            }
            tMesa.setModel(modeloMesas);
        }
       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jsCantidad;
    private javax.swing.JTable tMesa;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables
}
