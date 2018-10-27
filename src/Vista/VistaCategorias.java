package Vista;

import Modelo.Categoria;
import Modelo.CategoriaData;
import Modelo.Conexion;
import java.util.logging.Level;
import java.util.logging.Logger;


public class VistaCategorias extends javax.swing.JInternalFrame {
private CategoriaData categoriaData;
private Conexion conexion;
    
    public VistaCategorias()
    {
        initComponents();
        try 
        {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            categoriaData = new CategoriaData(conexion);        
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
        tbNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDescripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        chActivo = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        tbId = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        btnBorrar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(516, 472));
        setMinimumSize(new java.awt.Dimension(514, 529));
        setPreferredSize(new java.awt.Dimension(514, 529));
        getContentPane().setLayout(null);

        jLabel7.setText("NOMBRE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 140, 80, 30);

        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tbNombre);
        tbNombre.setBounds(130, 140, 220, 30);

        jLabel8.setText("DESCRIPCIÓN");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 210, 80, 30);

        tbDescripcion.setColumns(20);
        tbDescripcion.setRows(5);
        jScrollPane2.setViewportView(tbDescripcion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(130, 200, 220, 40);

        jLabel9.setText("ACTIVO");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 270, 80, 30);

        chActivo.setBackground(new java.awt.Color(255, 204, 255));
        getContentPane().add(chActivo);
        chActivo.setBounds(130, 280, 21, 21);

        jLabel10.setText("ID");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(40, 60, 50, 40);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(130, 70, 220, 30);

        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Foto/Buscarosa_副本.png"))); // NOI18N
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
        btnBuscar1.setBounds(360, 60, 100, 50);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("-CATEGORÍAS-");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 0, 140, 40);

        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Foto/Guardar rosa.png"))); // NOI18N
        btnGuardar1.setText("Guardar");
        btnGuardar1.setBorder(null);
        btnGuardar1.setBorderPainted(false);
        btnGuardar1.setContentAreaFilled(false);
        btnGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar1);
        btnGuardar1.setBounds(20, 360, 90, 40);

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Foto/borrar rosa.png"))); // NOI18N
        btnBorrar1.setText("Borrar");
        btnBorrar1.setBorder(null);
        btnBorrar1.setBorderPainted(false);
        btnBorrar1.setContentAreaFilled(false);
        btnBorrar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnBorrar1);
        btnBorrar1.setBounds(270, 340, 120, 80);

        btnActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Foto/Actualizar rosa_副本_1.png"))); // NOI18N
        btnActualizar1.setText("Actualizar");
        btnActualizar1.setBorder(null);
        btnActualizar1.setBorderPainted(false);
        btnActualizar1.setContentAreaFilled(false);
        btnActualizar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnActualizar1);
        btnActualizar1.setBounds(150, 350, 110, 60);

        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Foto/Limpiarrosa_副本.png"))); // NOI18N
        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.setBorder(null);
        btnLimpiar1.setBorderPainted(false);
        btnLimpiar1.setContentAreaFilled(false);
        btnLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar1);
        btnLimpiar1.setBounds(400, 350, 100, 60);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Foto/mas pequeño副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreActionPerformed

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

        int id=Integer.parseInt(tbId.getText());

        Categoria categoria=categoriaData.buscarCategoria(id);

        if(categoria!=null)
        {

            tbNombre.setText(categoria.getNombre());
            tbDescripcion.setText(categoria.getDescripcion());
            chActivo.setSelected(categoria.getActivo());
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed

        String nombre=tbNombre.getText();
        String descripcion=tbDescripcion.getText();
        boolean activo=chActivo.isSelected();

        Categoria categoria=new Categoria(nombre,descripcion,activo);
        categoriaData.guardarCategoria(categoria);    

        tbId.setText(categoria.getIdCategoria()+"");
        limpiar();
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(tbId.getText());
        categoriaData.borrarCategoria(id);
        limpiar();
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        // TODO add your handling code here:
       if (tbId.getText().isEmpty())
       {
            System.out.println("Error");
        }else
       {
           
            int id=Integer.parseInt(tbId.getText());
            String nombre=tbNombre.getText();
            String descripcion=tbDescripcion.getText();
            boolean activo=chActivo.isSelected();

            Categoria categoria=new Categoria(id,nombre,descripcion,activo);
            categoriaData.actualizarCategoria(categoria);
            limpiar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
           limpiar();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed
     public void limpiar()
    {
         tbNombre.setText("");
            tbDescripcion.setText("");
            chActivo.setSelected(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea tbDescripcion;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables
}
