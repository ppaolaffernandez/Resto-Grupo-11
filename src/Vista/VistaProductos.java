
package Vista;

import Modelo.Categoria;
import Modelo.CategoriaData;
import Modelo.ProductoData;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Conexion;
import Modelo.Producto;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaProductos extends javax.swing.JInternalFrame {
private ProductoData productoData;
private CategoriaData categoriaData;
private Conexion conexion;
private ArrayList<Categoria> listaCategorias;  

    public VistaProductos() {
        initComponents();
        
        validarSoloNumeros(tbCodigo);
        validarSoloNumeros(tbCantidad);
        validarSoloLetras(tbNombre);

        
         try 
        {
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            productoData = new ProductoData(conexion); 
            
             categoriaData = new CategoriaData(conexion);
             listaCategorias =(ArrayList)categoriaData.obtenerCategoriasDeProductos();
             cargarCategoriaComboBox();
        }
        catch (ClassNotFoundException ex)
        {
            Logger.getLogger(VistaClientes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbCategoria = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        tbCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tbCantidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tbPrecio = new javax.swing.JTextField();
        Activo = new javax.swing.JLabel();
        chActivo = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jTextField3.setText("jTextField3");

        setMaximumSize(new java.awt.Dimension(661, 742));
        setMinimumSize(new java.awt.Dimension(661, 742));
        setPreferredSize(new java.awt.Dimension(661, 742));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PIZZA副本.png"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, -1, 80));

        jLabel8.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/hAMBURGUER副本.png"))); // NOI18N
        jLabel8.setText("PRODUCTO");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 160, 80));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
        jLabel1.setText("Buscar");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 70, 50));

        tbBuscar.setBackground(new java.awt.Color(255, 204, 204));
        tbBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 300, 30));

        jbBuscar.setBackground(new java.awt.Color(255, 153, 153));
        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.setContentAreaFilled(false);
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 100, 50));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel4.setText("INFORME DEL PRODUCTO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 200, 50));

        jLabel5.setText("Categoria");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 70, 40));

        cbCategoria.setBackground(new java.awt.Color(255, 204, 255));
        cbCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, 250, 30));

        jLabel6.setText("Codigo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 60, 40));

        tbCodigo.setBackground(new java.awt.Color(255, 204, 204));
        tbCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 250, 30));

        jLabel9.setText("Nombre");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 60, 40));

        tbNombre.setBackground(new java.awt.Color(255, 204, 204));
        tbNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 250, 30));

        jLabel10.setText("Cantidad");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 70, 50));

        tbCantidad.setBackground(new java.awt.Color(255, 204, 204));
        tbCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 250, 30));

        jLabel11.setText("Precio");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 410, 70, 50));

        tbPrecio.setBackground(new java.awt.Color(255, 204, 204));
        tbPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 420, 250, 30));

        Activo.setText("Activo");
        getContentPane().add(Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 60, 40));

        chActivo.setBackground(new java.awt.Color(255, 204, 204));
        chActivo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(chActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, 40, 30));

        btnGuardar.setBackground(new java.awt.Color(255, 153, 153));
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
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 100, 50));

        btnBorrar.setBackground(new java.awt.Color(255, 153, 153));
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
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
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 120, 50));

        btnActualizar.setBackground(new java.awt.Color(255, 153, 153));
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
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 120, 50));

        btnLimpiar.setBackground(new java.awt.Color(255, 153, 153));
        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiarrosa_副本.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimpiar.setMaximumSize(new java.awt.Dimension(631, 632));
        btnLimpiar.setMinimumSize(new java.awt.Dimension(631, 632));
        btnLimpiar.setPreferredSize(new java.awt.Dimension(631, 632));
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 540, 100, 50));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pinkmas claro_副本.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 700));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        int id=Integer.parseInt(tbBuscar.getText());

        Producto producto=productoData.buscarProducto(id);

        if(producto!=null){

            cbCategoria.setSelectedItem(producto.getCategoria().getNombre());
            tbCodigo.setText(producto.getCodigo()+"");
            tbNombre.setText(producto.getNombre());
            tbCantidad.setText(producto.getCantidad()+"");
            tbPrecio.setText(producto.getPrecio()+"");
            chActivo.setSelected(producto.getActivo());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String seleccionado=cbCategoria.getSelectedItem().toString();
        Categoria categoria=categoriaData.buscarCategoriaNombre(seleccionado);

        int codigo=Integer.parseInt(tbCodigo.getText());
        String nombre=tbNombre.getText();
        int cantidad=Integer.parseInt(tbCantidad.getText());
        double precio=Double.parseDouble(tbPrecio.getText());
        boolean activo=chActivo.isSelected();

        Producto producto=new Producto(categoria,codigo,nombre,cantidad,precio,activo);
        productoData.guardarProducto(producto);
        limpiar();

        //        tbId.setText(producto.getIdProducto()+"");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        // TODO add your handling code here:
        int id=Integer.parseInt(tbBuscar.getText());
        productoData.borrarProducto(id);
        limpiar();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        if (tbBuscar.getText().isEmpty()){
            System.out.println("Error");
        }else{

            int id=Integer.parseInt(tbBuscar.getText());
            System.out.println("Error");

            String seleccionado=cbCategoria.getSelectedItem().toString();
            Categoria categoria=categoriaData.buscarCategoriaNombre(seleccionado);

            //             System.out.println(categoria.getIdCategoria());
            //             System.out.println(categoria.getNombre());
            int codigo=Integer.parseInt(tbCodigo.getText());
            String nombre=tbNombre.getText();
            int cantidad=Integer.parseInt(tbCantidad.getText());
            double precio=Double.parseDouble(tbPrecio.getText());
            boolean activo=chActivo.isSelected();

            Producto producto=new Producto(id,categoria,codigo,nombre,cantidad,precio,activo);
            productoData.actualizarProducto(producto);
            limpiar();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed

        //            tbId.setText("");
        //cbProductoCategoria.setText("");
       
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed
 public void cargarCategoriaComboBox(){
    
     for(Categoria item:listaCategorias)
     {
            cbCategoria.addItem(item.getNombre());
    }
 }
     public void limpiar()
    {
        tbCodigo.setText("");
        tbNombre.setText("");
        tbCantidad.setText("");
        tbPrecio.setText("");
        chActivo.setSelected(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Activo;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextField tbCodigo;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbPrecio;
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
    campo.addKeyListener(new KeyAdapter(){
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
