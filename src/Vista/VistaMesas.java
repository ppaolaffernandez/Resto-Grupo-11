
package Vista;

import Modelo.Conexion;
import Modelo.Mesa;
import Modelo.MesaData;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VistaMesas extends javax.swing.JInternalFrame {
private MesaData mesaData;
private Conexion conexion; 
    public VistaMesas() {
        initComponents();
        try 
        {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            mesaData = new MesaData(conexion);        
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
        jLabel2 = new javax.swing.JLabel();
        tbId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jsCantidad = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        chActivo = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(632, 481));
        setMinimumSize(new java.awt.Dimension(632, 481));
        setPreferredSize(new java.awt.Dimension(632, 481));
        getContentPane().setLayout(null);

        jLabel5.setBackground(new java.awt.Color(255, 204, 255));
        jLabel5.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/MEsas副本.png"))); // NOI18N
        jLabel5.setText("MESAS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(190, 0, 210, 70);

        jLabel2.setText("ID");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 100, 70, 30);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(180, 100, 200, 30);

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
        btnBuscar.setBounds(460, 90, 100, 50);

        jLabel3.setText("Capacidad de personas");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 160, 120, 50);

        jsCantidad.setModel(new javax.swing.SpinnerNumberModel(2, 2, 10, 2));
        getContentPane().add(jsCantidad);
        jsCantidad.setBounds(180, 170, 80, 30);

        jLabel4.setText("Activo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(40, 260, 60, 40);

        chActivo.setBackground(new java.awt.Color(255, 204, 204));
        getContentPane().add(chActivo);
        chActivo.setBounds(180, 260, 40, 40);

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
        btnGuardar.setBounds(30, 350, 90, 50);

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
        btnBorrar.setBounds(170, 350, 90, 50);

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
        btnActualizar.setBounds(320, 350, 100, 50);

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
        btnLimpiar.setBounds(470, 350, 90, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pinkmas claro_副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 620, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed

    }//GEN-LAST:event_tbIdActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        int id=Integer.parseInt(tbId.getText());

        Mesa mesa=mesaData.buscarMesa(id);
        if(mesa!=null){
            tbId.setText(mesa.getIdMesa()+"");
            jsCantidad.setValue(mesa.getCantidad());

            chActivo.setSelected(mesa.getActivo());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        int cantidad=Integer.parseInt(jsCantidad.getValue().toString());
        String estado="Libre";
        boolean activo=chActivo.isSelected();

        Mesa mesa=new Mesa(cantidad,estado,activo);
        mesaData.guardarMesa(mesa);

        tbId.setText(mesa.getIdMesa()+"");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(tbId.getText());
        mesaData.borrarMesa(id);
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (tbId.getText().isEmpty()){

            System.out.println("Error");
        }else{
            int id=Integer.parseInt(tbId.getText());
            int cantidad=Integer.parseInt(jsCantidad.getValue().toString());

            boolean activo=chActivo.isSelected();
            String estado="Libre";
            Mesa mesa=new Mesa(id,cantidad,estado,activo);
            mesaData.actualizarMesa(mesa);
            
        }
       
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        
            tbId.setText("");
            jsCantidad.getValue();
            chActivo.setSelected(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

       
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner jsCantidad;
    private javax.swing.JTextField tbId;
    // End of variables declaration//GEN-END:variables
}
