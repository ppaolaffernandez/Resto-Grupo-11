
package Vista;

import Modelo.MeseroData;
import Modelo.Conexion;
import Modelo.Mesero;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VistaMeseros extends javax.swing.JInternalFrame {
private MeseroData meseroData;
private Conexion conexion;
private ArrayList<Mesero> listaMeseros;

private DefaultTableModel modeloMeseros;

    public VistaMeseros() 
    {
        initComponents();
//        setLocationRelativeTo(null); centra el from
        validarSoloNumeros(tbDni);
        validarSoloLetras(tbNombre);
        limitarCaracteres(tbDni,8);
        
        
        
        
         try 
        {
            modeloMeseros=new DefaultTableModel();
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            meseroData = new MeseroData(conexion);  
            
            armaCabeceraTablaMesero();
            cargaDatosTablaMesero();
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

        jLabel6 = new javax.swing.JLabel();
        tbId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tbDni = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        tbBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMesero = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        cbDatos = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(556, 560));
        setMinimumSize(new java.awt.Dimension(556, 560));
        setPreferredSize(new java.awt.Dimension(556, 560));
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mesero副本.png"))); // NOI18N
        jLabel6.setText("MESEROS");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        getContentPane().add(jLabel6);
        jLabel6.setBounds(190, -10, 110, 80);

        tbId.setAutoscrolls(false);
        tbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbIdActionPerformed(evt);
            }
        });
        getContentPane().add(tbId);
        tbId.setBounds(490, 10, 30, 30);

        jLabel3.setText("DNI");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 270, 60, 30);

        tbDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDniActionPerformed(evt);
            }
        });
        getContentPane().add(tbDni);
        tbDni.setBounds(150, 270, 260, 30);

        jLabel4.setText("NOMBRE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 320, 60, 30);

        tbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbNombreActionPerformed(evt);
            }
        });
        getContentPane().add(tbNombre);
        tbNombre.setBounds(150, 320, 260, 30);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Limpiarrosa_副本.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setBorder(null);
        btnLimpiar.setBorderPainted(false);
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(420, 400, 100, 50);

        tbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(tbBuscar);
        tbBuscar.setBounds(150, 70, 220, 30);

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
        btnBuscar.setBounds(410, 60, 100, 60);

        tMesero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tMesero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tMeseroMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tMesero);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 130, 480, 110);

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
        btnGuardar.setBounds(20, 400, 90, 40);

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
        btnActualizar.setBounds(150, 390, 110, 60);

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
        btnBorrar.setBounds(280, 390, 120, 60);

        cbDatos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dni", "Nombre", "Desactivado", " " }));
        cbDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDatosActionPerformed(evt);
            }
        });
        getContentPane().add(cbDatos);
        cbDatos.setBounds(60, 70, 70, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pinkmas claro_副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 540, 520);

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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        

            tbId.setText("");
            tbNombre.setText("");
            tbDni.setText("");
            
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       //para seleccionar por dni
        if(tbBuscar.getText().isEmpty())//SI NO HAY DATOS NO AGREGA
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del mesero : ");
        }
        else //SI HAY ALGO BUSCA
        {
             if (cbDatos.getSelectedItem()=="Nombre") 
             {
                //un solo = es asigancion, y dos == es comparar.
                borraFilasTablaMesero();
                cargaDatosTablaMeseroxNombre(tbBuscar.getText());
             }
             if (cbDatos.getSelectedItem()=="Dni") 
             {
                //un solo = es asigancion, y dos == es comparar.
                borraFilasTablaMesero();
                cargaDatosTablaMeseroxDni(Integer.parseInt(tbBuscar.getText()));
             }
        }
        

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tMeseroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMeseroMousePressed
        int filaseleccionada = tMesero.getSelectedRow();
        try
        {
            tbId.setText(tMesero.getValueAt(filaseleccionada, 0).toString());
            tbNombre.setText(tMesero.getValueAt(filaseleccionada, 1).toString());
            tbDni.setText(tMesero.getValueAt(filaseleccionada, 2).toString());
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Seleccione una fila : ");
        }

    }//GEN-LAST:event_tMeseroMousePressed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del mesero : ");
        }
        else if(tbDni.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el dni del mesero : ");
        }
        else
        {
            String nombre=tbNombre.getText();
            int dni=Integer.parseInt(tbDni.getText());
            boolean activo=true; //cuando guardo un mesero siempre tiene que estar activo .

            Mesero mesero=new Mesero(nombre,dni,activo);
            meseroData.guardarMesero(mesero);
            JOptionPane.showMessageDialog(null, "Mesero Guardado  ");

            tbId.setText(mesero.getIdMesero()+"");
            limpiar();
            borraFilasTablaMesero();
            cargaDatosTablaMesero();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if(tbNombre.getText().isEmpty())//si la caja esta vacia va a salir un mensaje que falta el nombre

        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del mesero : ");
        }
        else//si la caja tiene nombre entra y actualiza
        {

            int id=Integer.parseInt(tbId.getText());
            String nombre=tbNombre.getText();
            int dni=Integer.parseInt(tbDni.getText());
            boolean activo=true;//cuando seleciiona un mesero lo pones activo de vuelta...........¡¡¡¡¡¡¡¡¡¡¡

            Mesero mesero=new Mesero(id,nombre,dni,activo);
            meseroData.actualizarMesero(mesero);
            limpiar();//limpia los controles las cajas y los chechbox
            borraFilasTablaMesero();//limpia la tabla
            cargaDatosTablaMesero();//carga  la tabla categoria
        }

    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(tbNombre.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Ingrese el nombre del mesero : ");
        }
        else
        {
            int id=Integer.parseInt(tbId.getText());
            meseroData.borrarMesero(id);
            JOptionPane.showMessageDialog(null, "Mesero Eliminado  ");
            limpiar();
            borraFilasTablaMesero();
            cargaDatosTablaMesero();
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cbDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDatosActionPerformed
        if(cbDatos.getSelectedItem()=="Desactivado")
        {
            cargaDatosTablaMeseroxDesactivado();
        }
    }//GEN-LAST:event_cbDatosActionPerformed

//___________________________________________________________________________________________________________________________
//_______________________________________________________TABLA MESERO_____________________________________________________________
//___________________________________________________________________________________________________________________________   
 
    public void cargaDatosTablaMeseroxDni(int Dato) //ESTEEE LISTA POR NUMEROOOOOOOO
        {   
            borraFilasTablaMesero();
            listaMeseros=(ArrayList)meseroData.obtenerMeserosPorDni(Dato);         
            //Llenar filas
            for(Mesero m:listaMeseros)
            {
                modeloMeseros.addRow(new Object[]{m.getIdMesero(),m.getNombre(),m.getDni(),m.getActivo()});
                 
            }     
        }
    
    public void cargaDatosTablaMeseroxDesactivado() //ESTEEE LISTA POR DESACTIVADOS
        {   
            borraFilasTablaMesero();
            listaMeseros=(ArrayList)meseroData.obtenerMeserosPorDesactivado();         
            //Llenar filas
            for(Mesero m:listaMeseros)
            {
                modeloMeseros.addRow(new Object[]{m.getIdMesero(),m.getNombre(),m.getDni(),m.getActivo()});
                 
            }     
        }
    
    
    
      public void cargaDatosTablaMeseroxNombre(String Dato)////ESTE LISTA POR NOMBREEEEEEEEEEEE
        {   
            borraFilasTablaMesero();
            listaMeseros=(ArrayList)meseroData.obtenerMeserosPorNombre(Dato);         
            //Llenar filas
            for(Mesero m:listaMeseros)
            {
                modeloMeseros.addRow(new Object[]{m.getIdMesero(),m.getNombre(),m.getDni(),m.getActivo()});
                 
            }     
        }
    public void cargaDatosTablaMesero()  ///LISTA TODOS LOS ATRIBUTOSSSSSSSSSSSSS
        {   
            borraFilasTablaMesero();
            listaMeseros=(ArrayList)meseroData.obtenerMeseros();         
            //Llenar filas
            for(Mesero m:listaMeseros)
            {
                modeloMeseros.addRow(new Object[]{m.getIdMesero(),m.getNombre(),m.getDni(),m.getActivo()});
                 
            }
             
        }
    

        public void borraFilasTablaMesero()
        {
            int a = modeloMeseros.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloMeseros.removeRow(i);
            }
        }
        public void armaCabeceraTablaMesero()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID:");
            columnas.add("NOMBRE.");
            columnas.add("DNI");
            columnas.add("ACTIVO");

            for(Object vp:columnas)
            {   
                modeloMeseros.addColumn(vp);
            }
            tMesero.setModel(modeloMeseros);
            tMesero.getColumnModel().getColumn(0).setPreferredWidth(250);
            tMesero.getColumnModel().getColumn(1).setPreferredWidth(3500);
            tMesero.getColumnModel().getColumn(2).setPreferredWidth(1555);
            tMesero.getColumnModel().getColumn(3).setPreferredWidth(1000);
        }
     /*______________________________________________________________________________________________________
    ___________________________________  PARA LISTAR POR SUS ATRIBUTOS(DATOS)______________________________________________________________
    __________________________________________________________________________________________
    _________________________________________________________________________________*/
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cbDatos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tMesero;
    private javax.swing.JTextField tbBuscar;
    private javax.swing.JTextField tbDni;
    private javax.swing.JTextField tbId;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables
public void limpiar()
    {
        tbNombre.setText("");
        tbDni.setText("");
        
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