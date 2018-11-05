
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
import javax.swing.table.DefaultTableModel;

public class VistaProductos extends javax.swing.JInternalFrame
{
    private DefaultTableModel modeloProductos;    
    private ProductoData productoData;
    private CategoriaData categoriaData;
    
    private Conexion conexion;
    
    private ArrayList<Categoria> listaCategorias;
    private ArrayList<Producto> listaProductos;

    public VistaProductos() {
        initComponents();
        
        validarSoloNumeros(tbCodigo);
        validarSoloNumeros(tbCantidad);
        validarSoloLetras(tbNombre);

        
         try 
        {
            modeloProductos=new DefaultTableModel();
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            productoData = new ProductoData(conexion); 
            
             categoriaData = new CategoriaData(conexion);
             listaCategorias =(ArrayList)categoriaData.obtenerCategoriasDeProductos();
             
             cargarCategoriaComboBox();
             
             armaCabeceraTablaProducto();
             cargaDatosTablaProducto();
             
             tbId.setVisible(false);
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
        tbId = new javax.swing.JTextField();
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
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProducto = new javax.swing.JTable();
        cbDatos = new javax.swing.JComboBox<>();
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

        tbId.setBackground(new java.awt.Color(255, 204, 204));
        tbId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 30, 30));

        jLabel4.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel4.setText("INFORME DEL PRODUCTO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, 200, 50));

        jLabel5.setText("Categoria");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 70, 40));

        cbCategoria.setBackground(new java.awt.Color(255, 204, 255));
        cbCategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(cbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 150, 250, 30));

        jLabel6.setText("Codigo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 60, 40));

        tbCodigo.setBackground(new java.awt.Color(255, 204, 204));
        tbCodigo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, 250, 30));

        jLabel9.setText("Nombre");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 60, 40));

        tbNombre.setBackground(new java.awt.Color(255, 204, 204));
        tbNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 250, 30));

        jLabel10.setText("Cantidad");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 70, 50));

        tbCantidad.setBackground(new java.awt.Color(255, 204, 204));
        tbCantidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 250, 30));

        jLabel11.setText("Precio");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 70, 50));

        tbPrecio.setBackground(new java.awt.Color(255, 204, 204));
        tbPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 153, 153)));
        getContentPane().add(tbPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 250, 30));

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
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 100, 50));

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
        getContentPane().add(btnBorrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 120, 50));

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
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, 120, 50));

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
        getContentPane().add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 400, 100, 50));

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 190, 40));

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
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, -1, 50));

        tProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        tProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tProductoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tProducto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 560, -1, 110));

        cbDatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Nombre", "Cantidad", "Desactivado", "" }));
        cbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDatosActionPerformed(evt);
            }
        });
        getContentPane().add(cbDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, -1, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pinkmas claro_副本.jpg"))); // NOI18N
        jLabel7.setText("jLabel7");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -50, 650, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if(tbCodigo.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el codigo de la producto : ");
        }
        else if(tbNombre.getText().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Ingrese el nombre de la producto : ");
        }
        else if(tbCantidad.getText().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Ingrese el cantidad de la producto : ");
        }
        else if(tbPrecio.getText().isEmpty())
        {
             JOptionPane.showMessageDialog(null, "Ingrese el precio de la producto : ");
        }
        else
        {
            String seleccionado=cbCategoria.getSelectedItem().toString();
            Categoria categoria=categoriaData.buscarCategoriaNombre(seleccionado);
            int codigo=Integer.parseInt(tbCodigo.getText());
            String nombre=tbNombre.getText();
            int cantidad=Integer.parseInt(tbCantidad.getText());
            double precio=Double.parseDouble(tbPrecio.getText());
            boolean activo=true;

            Producto producto=new Producto(categoria,codigo,nombre,cantidad,precio,activo);
            productoData.guardarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto Guardado  ");
            tbId.setText(producto.getIdProducto()+"");
            
            limpiar();
            borraFilasTablaProducto();
            cargaDatosTablaProducto();
        }
        //        tbId.setText(producto.getIdProducto()+"");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
         if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la Producto : ");
        }
        else
        {
            int id=Integer.parseInt(tbId.getText());
            productoData.borrarProducto(id);
            JOptionPane.showMessageDialog(null, "Producto Eliminado  ");
            limpiar();
            borraFilasTablaProducto();
            cargaDatosTablaProducto();
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
         if (tbNombre.getText().isEmpty())//si la caja esta vacia va a salir un mensaje que falta el nombre
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la Producto : ");
        }
        else{

            int id=Integer.parseInt(tbId.getText());
            String seleccionado=cbCategoria.getSelectedItem().toString();
            Categoria categoria=categoriaData.buscarCategoriaNombre(seleccionado);
            int codigo=Integer.parseInt(tbCodigo.getText());
            String nombre=tbNombre.getText();
            int cantidad=Integer.parseInt(tbCantidad.getText());
            double precio=Double.parseDouble(tbPrecio.getText());
            boolean activo=true;

            Producto producto=new Producto(id,categoria,codigo,nombre,cantidad,precio,activo);
            productoData.actualizarProducto(producto);
            JOptionPane.showMessageDialog(null, "Producto Actualizado  ");
            limpiar();
            borraFilasTablaProducto();//limpia la tabla
            cargaDatosTablaProducto();//carga  la tabla categoria
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del Producto : ");
        }
      
        else
        {
            if (cbDatos.getSelectedItem()=="Categoria") 
            {
                borraFilasTablaProducto();
                cargaDatosTablaProductoporCategoria(tbBuscar.getText());
            }
            if (cbDatos.getSelectedItem()=="Nombre") 
            {
                borraFilasTablaProducto();
                cargaDatosTablaProductoxNombre(tbBuscar.getText());
            }
            if (cbDatos.getSelectedItem()=="Cantidad") 
            {
                borraFilasTablaProducto();
                cargaDatosTablaProductoxCantidad(Integer.parseInt(tbBuscar.getText()));
           }
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tProductoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tProductoMousePressed
        int filaseleccionada = tProducto.getSelectedRow();
        try
        {
            tbId.setText(tProducto.getValueAt(filaseleccionada, 0).toString());
            cbCategoria.addItem(tProducto.getValueAt(filaseleccionada, 1).toString()); // addItem?
            tbCodigo.setText(tProducto.getValueAt(filaseleccionada, 2).toString());
            tbNombre.setText(tProducto.getValueAt(filaseleccionada, 3).toString());
            tbCantidad.setText(tProducto.getValueAt(filaseleccionada, 4).toString());
            tbPrecio.setText(tProducto.getValueAt(filaseleccionada, 5).toString());
//            chActivo.setSelected(Boolean.parseBoolean(tProducto.getValueAt(filaseleccionada, 6).toString()) );
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }

    }//GEN-LAST:event_tProductoMousePressed

    private void cbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDatosActionPerformed
        if(cbDatos.getSelectedItem()=="Desactivado")
        {
            cargaDatosTablaProductoxDesactivado();
        }
    }//GEN-LAST:event_cbDatosActionPerformed
 public void cargarCategoriaComboBox(){
    
     for(Categoria item:listaCategorias)
     {
            cbCategoria.addItem(item.getNombre());
     }
 }
//  _____________________________________________________________________________________________________________________________________________  
//  ____________________________________________________Tabla Producto___________________________________________________________________________
// ______________________________________________________________________________________________________________________________________________

 //__________________________________________________________TABLA MESA_______________________________________________________________________________
   
 
    
    
      public void cargaDatosTablaProductoporCategoria(String Dato)////ESTE LISTA POR NOMBREEEEEEEEEEEE
      {   
            borraFilasTablaProducto();
            listaProductos=(ArrayList)productoData.obtenerProductosPorCategoria(Dato);         
            //Llenar filas
            for(Producto p:listaProductos)
            {
               modeloProductos.addRow(new Object[]{p.getIdProducto(),p.getCategoria().getIdCategoria(),p.getCodigo(),p.getNombre(),p.getCantidad(),p.getPrecio(),p.getActivo()});                 

            }     
      }
      public void cargaDatosTablaProductoxNombre(String Dato)////ESTE LISTA POR NOMBREEEEEEEEEEEE
        {   
            borraFilasTablaProducto();
            listaProductos=(ArrayList)productoData.obtenerProductosPorNombre(Dato);         
            //Llenar filas
            for(Producto p:listaProductos)
            {
               modeloProductos.addRow(new Object[]{p.getIdProducto(),p.getCategoria().getIdCategoria(),p.getCodigo(),p.getNombre(),p.getCantidad(),p.getPrecio(),p.getActivo()});                 
                 
            }     
        }
        public void cargaDatosTablaProductoxCantidad(int Dato) //ESTEEE LISTA POR NUMEROOOOOOOO
        {   
            borraFilasTablaProducto();
            listaProductos=(ArrayList)productoData.obtenerProductosPorCantidad(Dato);         
            //Llenar filas
            for(Producto p:listaProductos)
            {
               modeloProductos.addRow(new Object[]{p.getIdProducto(),p.getCategoria().getIdCategoria(),p.getCodigo(),p.getNombre(),p.getCantidad(),p.getPrecio(),p.getActivo()});                 
                 
            }     
        }
       public void cargaDatosTablaProductoxDesactivado() //ESTEEE LISTA POR DESACTIVADOS
        {   
            borraFilasTablaProducto();
            listaProductos=(ArrayList)productoData.obtenerProductosPorDesactivado();         
            //Llenar filas
            for(Producto p:listaProductos)
            {
               modeloProductos.addRow(new Object[]{p.getIdProducto(),p.getCategoria().getIdCategoria(),p.getCodigo(),p.getNombre(),p.getCantidad(),p.getPrecio(),p.getActivo()});                 
                 
            }     
        }
    
      
      
      
      
      
    public void cargaDatosTablaProducto(String Dato)
        {   
            borraFilasTablaProducto();
            listaProductos=(ArrayList)productoData.obtenerProductosPorNombre(Dato);         
            //Llenar filas
            for(Producto d:listaProductos)
            {
               modeloProductos.addRow(new Object[]{d.getIdProducto(),d.getCategoria().getIdCategoria(),d.getCodigo(),d.getNombre(),d.getCantidad(),d.getPrecio(),d.getActivo()});                 
            }       
        }
 
     public void cargaDatosTablaProducto()
        {   
            borraFilasTablaProducto();
            listaProductos=(ArrayList)productoData.obtenerProductos();         
            //Llenar filas
            for(Producto d:listaProductos)
            {
                modeloProductos.addRow(new Object[]{d.getIdProducto(),d.getCategoria().getIdCategoria(),d.getCodigo(),d.getNombre(),d.getCantidad(),d.getPrecio(),d.getActivo()});
                 
            }
             
        }

        public void borraFilasTablaProducto()
        {
            int a = modeloProductos.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloProductos.removeRow(i);
            }
        }
        public void armaCabeceraTablaProducto()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID:");
            columnas.add("CATEGORIA.");
            columnas.add("CODIGO");
            columnas.add("NOMBRE");
            columnas.add("CANTIDAD");
            columnas.add("PRECIO");
            columnas.add("ACTIVO");

            for(Object vp:columnas)
            {   
                modeloProductos.addColumn(vp);
            }
            tProducto.setModel(modeloProductos);
        }
     

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbCategoria;
    private javax.swing.JComboBox<String> cbDatos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tProducto;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbCantidad;
    private javax.swing.JTextField tbCodigo;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbPrecio;
    // End of variables declaration//GEN-END:variables
 public void limpiar()
    {
        tbCodigo.setText("");
        tbNombre.setText("");
        tbCantidad.setText("");
        tbPrecio.setText("");
        
    }
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
