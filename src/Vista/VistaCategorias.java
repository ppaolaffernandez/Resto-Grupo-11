package Vista;

import Modelo.Categoria;
import Modelo.CategoriaData;
import Modelo.Conexion;
import Modelo.Detalle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class VistaCategorias extends javax.swing.JInternalFrame {
private CategoriaData categoriaData;
private Conexion conexion;
private ArrayList<Categoria> listaCategorias;
private DefaultTableModel modeloCategorias;


    
    public VistaCategorias()
    {
        initComponents();
        validarSoloLetras(tbNombre);
        validarSoloLetras(tbBuscar);
       
        try 
        {
            modeloCategorias=new DefaultTableModel();
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            
            categoriaData = new CategoriaData(conexion);  
            modeloCategorias=new DefaultTableModel();
            armaCabeceraTablaCategoria();
           
            cargaDatosTablaCategoria();
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
        tbNombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDescripcion = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        chActivo = new javax.swing.JCheckBox();
        tbId = new javax.swing.JTextField();
        btnBuscar1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        btnBorrar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCategoria = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tbBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(516, 527));
        setMinimumSize(new java.awt.Dimension(516, 527));
        setPreferredSize(new java.awt.Dimension(516, 527));
        getContentPane().setLayout(null);

        jLabel7.setText("NOMBRE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(40, 60, 80, 30);

        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tbNombre);
        tbNombre.setBounds(140, 60, 220, 30);

        jLabel8.setText("DESCRIPCIÓN");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(40, 100, 80, 30);

        tbDescripcion.setColumns(20);
        tbDescripcion.setRows(5);
        jScrollPane2.setViewportView(tbDescripcion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(140, 100, 220, 90);

        jLabel9.setText("ACTIVO");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(40, 200, 80, 30);

        chActivo.setBackground(new java.awt.Color(255, 204, 255));
        chActivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chActivoActionPerformed(evt);
            }
        });
        getContentPane().add(chActivo);
        chActivo.setBounds(140, 210, 21, 21);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(470, 40, 10, 20);

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
        btnBuscar1.setBounds(360, 330, 100, 60);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("-CATEGORÍAS-");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, 0, 140, 40);

        btnGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Guardar rosa.png"))); // NOI18N
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
        btnGuardar1.setBounds(30, 250, 90, 40);

        btnBorrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/borrar rosa_1.png"))); // NOI18N
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
        btnBorrar1.setBounds(270, 240, 120, 60);

        btnActualizar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Actualizar rosa_副本_1.png"))); // NOI18N
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
        btnActualizar1.setBounds(140, 240, 110, 60);

        btnLimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiarrosa_副本.png"))); // NOI18N
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
        btnLimpiar1.setBounds(390, 240, 100, 60);

        tCategoria.setModel(new javax.swing.table.DefaultTableModel(
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
        tCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tCategoriaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tCategoria);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 390, 480, 100);

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 340, 60, 30);

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar);
        tbBuscar.setBounds(120, 340, 220, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreActionPerformed

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed

      if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
      {
          JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
      }
      else //SI HAY ALGO BUSCA
      {
          borraFilasTablaCategoria();
          cargaDatosTablaCategoria(tbBuscar.getText());
          
      }
      
        
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else
        {
            String nombre=tbNombre.getText();
            String descripcion=tbDescripcion.getText();
            boolean activo=chActivo.isSelected();

            Categoria categoria=new Categoria(nombre,descripcion,activo);
            categoriaData.guardarCategoria(categoria);    

            tbId.setText(categoria.getIdCategoria()+"");
            limpiar();
            borraFilasTablaCategoria();
            cargaDatosTablaCategoria();
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else
        {
            int id=Integer.parseInt(tbId.getText());
            categoriaData.borrarCategoria(id);
            limpiar();
            borraFilasTablaCategoria();
            cargaDatosTablaCategoria();
        }
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        if(tbNombre.getText().isEmpty())//si la caja esta vacia va a salir un mensaje que falta el nombre
            
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else//si la caja tiene nombre entra y actualiza
        {
           
            int id=Integer.parseInt(tbId.getText());
            String nombre=tbNombre.getText();
            String descripcion=tbDescripcion.getText();
            boolean activo=chActivo.isSelected();

            Categoria categoria=new Categoria(id,nombre,descripcion,activo);
            categoriaData.actualizarCategoria(categoria);
            limpiar();//limpia los controles las cajas y los chechbox
            borraFilasTablaCategoria();//limpia la tabla
            cargaDatosTablaCategoria();//carga  la tabla categoria
        }
        
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
           limpiar();
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void tCategoriaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tCategoriaMousePressed
       int filaseleccionada = tCategoria.getSelectedRow();
       try
       {
           tbId.setText(tCategoria.getValueAt(filaseleccionada, 0).toString());
           tbNombre.setText(tCategoria.getValueAt(filaseleccionada, 1).toString());
           tbDescripcion.setText(tCategoria.getValueAt(filaseleccionada, 2).toString());
           chActivo.setSelected(Boolean.parseBoolean(tCategoria.getValueAt(filaseleccionada, 3).toString()) );
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
       }
            
    }//GEN-LAST:event_tCategoriaMousePressed

    private void chActivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chActivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chActivoActionPerformed
     public void limpiar()
    {
        tbNombre.setText("");
        tbDescripcion.setText("");
        chActivo.setSelected(false);
    }
    public void cargaDatosTablaCategoria(String Dato)
        {   
            borraFilasTablaCategoria();
            listaCategorias=(ArrayList)categoriaData.obtenerCategoriasPorNombre(Dato);         
            //Llenar filas
            for(Categoria d:listaCategorias)
            {
                modeloCategorias.addRow(new Object[]{d.getIdCategoria(),d.getNombre(),d.getDescripcion()});
                 
            }
             
        }
    public void cargaDatosTablaCategoria()
        {   
            borraFilasTablaCategoria();
            listaCategorias=(ArrayList)categoriaData.obtenerCategorias();         
            //Llenar filas
            for(Categoria d:listaCategorias)
            {
                modeloCategorias.addRow(new Object[]{d.getIdCategoria(),d.getNombre(),d.getDescripcion()});
                 
            }
             
        }

        public void borraFilasTablaCategoria()
        {
            int a = modeloCategorias.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloCategorias.removeRow(i);
            }
        }
        public void armaCabeceraTablaCategoria()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID:");
            columnas.add("NOMBRE.");
            columnas.add("DESCRIPCION");
            

            for(Object vp:columnas)
            {   
                modeloCategorias.addColumn(vp);
            }
            tCategoria.setModel(modeloCategorias);
            
            
            
            
           
            tCategoria.getColumnModel().getColumn(0).setPreferredWidth(10);
            tCategoria.getColumnModel().getColumn(1).setPreferredWidth(100);
            tCategoria.getColumnModel().getColumn(2).setPreferredWidth(250);


            
            
            
        }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JCheckBox chActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tCategoria;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextArea tbDescripcion;
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





