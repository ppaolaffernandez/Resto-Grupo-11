/*int para  enteros (no van con comas)
  String para letras 
  Double para decimeales(Numeros con coma)
  Date para fechas
  time para horas(pero juan lo usa como String porque es mas dificil usarlo)
*/

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
        tbId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar1 = new javax.swing.JButton();
        btnBorrar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        btnLimpiar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tCategoria = new javax.swing.JTable();
        tbBuscar = new javax.swing.JTextField();
        cbDatos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(516, 527));
        setMinimumSize(new java.awt.Dimension(516, 527));
        setPreferredSize(new java.awt.Dimension(516, 527));
        getContentPane().setLayout(null);

        jLabel7.setText("NOMBRE");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(30, 240, 80, 30);

        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tbNombre);
        tbNombre.setBounds(130, 240, 220, 30);

        jLabel8.setText("DESCRIPCIÓN");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(30, 280, 90, 30);

        tbDescripcion.setColumns(20);
        tbDescripcion.setRows(5);
        jScrollPane2.setViewportView(tbDescripcion);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(130, 290, 310, 90);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(470, 40, 10, 20);

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
        btnBuscar.setBounds(360, 40, 100, 60);

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
        btnGuardar1.setBounds(10, 420, 90, 40);

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
        btnBorrar1.setBounds(250, 410, 120, 60);

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
        btnActualizar1.setBounds(120, 410, 110, 60);

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
        btnLimpiar1.setBounds(380, 410, 100, 60);

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
        jScrollPane1.setBounds(10, 100, 480, 100);

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar);
        tbBuscar.setBounds(120, 50, 220, 30);

        cbDatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Desactivado" }));
        cbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDatosActionPerformed(evt);
            }
        });
        getContentPane().add(cbDatos);
        cbDatos.setBounds(20, 50, 90, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbNombreActionPerformed

    private void tbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbIdActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
//          int id=Integer.parseInt(tbId.getText());/*EL BOTON NO SIRVE SOLO LA CAJA DE TEXTOOO,PONER LA CAJA DE TEXTO NO EL 
//                BOTON BTNbUSCAR*/
//        Cliente cliente;
//    cliente = clienteData.buscarCliente(id);
//        if(cliente!=null)
//        {
//            tbId.setText(cliente.getIdCliente()+"");
//            tbDni.setText(cliente.getDni()+"");
//            tbNombre.setText(cliente.getNombre());
//            chActivo.setSelected(cliente.getActivo());//BUSCARRRRRRRRR EN EL CLIENTEEEEEEEEEEEE CMABIAR EL IS POR EL GET
//        }
      if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
      {
          JOptionPane.showMessageDialog(null, "Seleccione Fila : ");
      }
      else if (cbDatos.getSelectedItem()=="Nombre") 
      {
         
            //un solo = es asigancion, y dos == es comparar.
             borraFilasTablaCategoria();
             cargaDatosTablaCategoria(tbBuscar.getText());
        }//SI HAY ALGO BUSCA
    
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardar1ActionPerformed
//        //el guardar nunca tiene id porque es incrementa automaticamente
//        int dni=Integer.parseInt(tbDni.getText());
//
//        String nombre=tbNombre.getText();
//       
//        boolean activo=chActivo.isSelected();
//
//        Cliente cliente=new Cliente(dni,nombre,activo);
//        clienteData.guardarCliente(cliente);//VA SIN MAYUSCULAS(mesadata)
//        //el guardar Vista tiene id al ultimo,porque toda la informacion lo guarda en el id
        
        
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
         else if(tbDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese la descripcion de la categoria : ");
        }
        else
        {
            String nombre=tbNombre.getText();
            String descripcion=tbDescripcion.getText();
            boolean activo=true;
            Categoria categoria=new Categoria(nombre,descripcion,activo);
            categoriaData.guardarCategoria(categoria);    

            tbId.setText(categoria.getIdCategoria()+"");
            limpiar();
            borraFilasTablaCategoria();
            cargaDatosTablaCategoria();
        }
    }//GEN-LAST:event_btnGuardar1ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
//  int id=Integer.parseInt(tbId.getText());
//      clienteData.borrarCliente(id);
      
      
          if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
         else if(tbDescripcion.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese la descripcion de la categoria : ");
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
//if (tbId.getText()!=null)
//        {
//            int id=Integer.parseInt(tbId.getText());
//            int dni=Integer.parseInt(tbDni.getText());
//
//            String nombre=tbNombre.getText();
//
//            boolean activo=chActivo.isSelected();
//
//            Cliente cliente=new Cliente(id,dni,nombre,activo);//en el actualizar siempre en el consructor va id
//            clienteData.actualizarCliente(cliente);
//    }

        if(tbNombre.getText().isEmpty())//si la caja esta vacia va a salir un mensaje que falta el nombre
            
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre de la categoria : ");
        }
        else//si la caja tiene nombre entra y actualiza
        {
           
            int id=Integer.parseInt(tbId.getText());
            String nombre=tbNombre.getText();
            String descripcion=tbDescripcion.getText();
            boolean activo=true;

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
       int filaseleccionada = tCategoria.getSelectedRow();//*para SEELCCIONAR LA FILA DELA TABLA QUEDA EN AZUL
       try
       {
           tbId.setText(tCategoria.getValueAt(filaseleccionada, 0).toString());
           tbNombre.setText(tCategoria.getValueAt(filaseleccionada, 1).toString());
           tbDescripcion.setText(tCategoria.getValueAt(filaseleccionada, 2).toString());
       }
       catch(Exception e)
       {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
       }
            
    }//GEN-LAST:event_tCategoriaMousePressed

    private void cbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDatosActionPerformed
        if(cbDatos.getSelectedItem()=="Desactivado")
        {
            cargaDatosTablaCategoriaxDesactivado();//eSTE ES EK COMBOBON SOLO SALE DESACTIVO DEL COMBON DONDE (TIENE NOMBRE,DNI..ESTO SOLO VA EN EL GUARDAR.),
        }
    }//GEN-LAST:event_cbDatosActionPerformed
     public void limpiar()
    {
        tbNombre.setText("");
        tbDescripcion.setText("");
        //ESTE LO CREO SEPADO DEL BOTON LIMPIAR DSP LO PONGO EN TODOS LOS BOTONES 
    }  
     
//_____________________________TABLA CATEGORIA___________________________________________________________________________________________________
//__________________________________________________________________________________________________
//___________________________________________________________________________________________________________________________________________________
//____________________________________________________________________________________________________________________________________________________________________________________________________
//__________________________________________________________________________________________________
                     
                     
                     
                     
public void cargaDatosTablaCategoriaxDesactivado() //ESTEEE LISTA POR DESACTIVADOS
        {   
            borraFilasTablaCategoria();
            listaCategorias=(ArrayList)categoriaData.obtenerCategoriasPorDesactivado();         
            //Llenar filas
            for(Categoria c:listaCategorias)
            {
                modeloCategorias.addRow(new Object[]{c.getIdCategoria(),c.getNombre(),c.getDescripcion(),c.getActivo()});
                 
            }     
        }
    
    
    
      public void cargaDatosTablaMeseroxNombre(String Dato)////ESTE LISTA POR NOMBREEEEEEEEEEEE
        {   
            borraFilasTablaCategoria();
            listaCategorias=(ArrayList)categoriaData.obtenerCategoriasPorNombre(Dato);         
            //Llenar filas
            for(Categoria c:listaCategorias)
            {
                modeloCategorias.addRow(new Object[]{c.getIdCategoria(),c.getNombre(),c.getDescripcion(),c.getActivo()});
                 
            }     
        }     
    public void cargaDatosTablaCategoria(String Dato)
        {   
            borraFilasTablaCategoria();
            listaCategorias=(ArrayList)categoriaData.obtenerCategoriasPorNombre(Dato);         
            //Llenar filas
            for(Categoria d:listaCategorias)
            {
                modeloCategorias.addRow(new Object[]{d.getIdCategoria(),d.getNombre(),d.getDescripcion(),d.getActivo()});
                 
            }
             
        }
    public void cargaDatosTablaCategoria()
        {   
            borraFilasTablaCategoria();
            listaCategorias=(ArrayList)categoriaData.obtenerCategorias();         
            //Llenar filas
            for(Categoria d:listaCategorias)
            {
                modeloCategorias.addRow(new Object[]{d.getIdCategoria(),d.getNombre(),d.getDescripcion(),d.getActivo()});
                 
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
            columnas.add("ACTIVO");

            for(Object vp:columnas)
            {   
                modeloCategorias.addColumn(vp);
            }
            tCategoria.setModel(modeloCategorias);
            
            tCategoria.getColumnModel().getColumn(0).setPreferredWidth(250);
            tCategoria.getColumnModel().getColumn(1).setPreferredWidth(3500);
            tCategoria.getColumnModel().getColumn(2).setPreferredWidth(5555);
            tCategoria.getColumnModel().getColumn(3).setPreferredWidth(1000);

            
            
            
            }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar1;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JComboBox<String> cbDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
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





