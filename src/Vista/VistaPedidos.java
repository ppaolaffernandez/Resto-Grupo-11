package Vista;

import Modelo.Categoria;
import Modelo.CategoriaData;
import Modelo.Cliente;
import Modelo.ClienteData;
import Modelo.Conexion;
import Modelo.Detalle;
import Modelo.DetalleData;
import Modelo.Mesa;
import Modelo.MesaData;
import Modelo.Mesero;
import Modelo.MeseroData;
import Modelo.Pedido;
import Modelo.PedidoData;
import Modelo.Producto;
import Modelo.ProductoData;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static java.lang.Integer.parseInt;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class VistaPedidos extends javax.swing.JInternalFrame
{
    private Conexion conexion;
    private DefaultTableModel modeloMesero;
    private DefaultTableModel modeloProducto;
    private DefaultTableModel modeloDetalle;

    private ClienteData clienteData;
    private PedidoData pedidoData;
    private MeseroData meseroData;
    private MesaData mesaData;    
    private ProductoData productoData;
    private CategoriaData categoriaData;
    private DetalleData detalleData;

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Categoria> listaCategorias;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Pedido> listaPedidos;
    private ArrayList<Mesero> listaMeseros;
    private ArrayList<Mesa> listaMesas;
    private ArrayList<Detalle> listaDetalles;
    private List<JButton>botones;
    
    public VistaPedidos()
    {
        initComponents();
        
        validarSoloNumeros(tbDni);
        limitarCaracteres(tbDni,8);
        
         Date now = new Date(System.currentTimeMillis());
         SimpleDateFormat date =new SimpleDateFormat("yyyy-MM-dd");
         SimpleDateFormat hour=new SimpleDateFormat("HH:mm:ss");
            
        botones = new ArrayList<>();
        
        try 
        {  
            modeloMesero=new DefaultTableModel();
            modeloProducto=new DefaultTableModel();
            modeloDetalle=new DefaultTableModel();
            
            conexion = new Conexion("jdbc:mysql://localhost/resto", "root", "");
            
            meseroData = new MeseroData(conexion); 
            clienteData = new ClienteData(conexion);
            productoData = new ProductoData(conexion);
            pedidoData = new PedidoData(conexion);
            mesaData = new MesaData(conexion);
            categoriaData = new CategoriaData(conexion);
            detalleData=new DetalleData(conexion);
            
            listaCategorias =(ArrayList)categoriaData.obtenerCategoriasDeProductos();

            armaCabeceraTablaMesero();// sin combo box lo cargo a la tabla directo
            cargaDatosTablaMesero();
            CargarMesas();
            
            cargarCategoriaProductoComboBox();// con combo box lo cargo en el cb(cargarProducto)
            armaCabeceraTablaProducto();
            
//         Tabla Detalle
           armaCabeceraTablaDetalle();
           
           tbFecha.setText(date.format(now));
           tbHora.setText(hour.format(now));
            
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
        jLabel7 = new javax.swing.JLabel();
        tbDni = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tbHora = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tbFecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        cbCategorias = new javax.swing.JComboBox<>();
        lblIdMesa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tProducto = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        sCantidad = new javax.swing.JSpinner();
        btnAgregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tDetalle = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        tbTotal = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        pnlMesas = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        chPagado = new javax.swing.JCheckBox();
        chCancelar = new javax.swing.JCheckBox();
        btnGuardar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnPedido = new javax.swing.JButton();
        btnVerMesa = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tMesero = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setMaximumSize(new java.awt.Dimension(1076, 673));
        setMinimumSize(new java.awt.Dimension(1076, 673));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("-INFORME DE CLIENTE-");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 190, 30));

        jLabel7.setText("Dni");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 40, 50));

        tbDni.setBorder(null);
        getContentPane().add(tbDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 140, 30));

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscarosa_副本.png"))); // NOI18N
        jbBuscar.setText("Buscar");
        jbBuscar.setBorder(null);
        jbBuscar.setBorderPainted(false);
        jbBuscar.setContentAreaFilled(false);
        jbBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jbBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, 50));

        jLabel9.setText("Cliente");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 50, 40));

        tbNombre.setBorder(null);
        getContentPane().add(tbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 140, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("-FECHA/HORA-");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 130, 40));

        jLabel13.setText("Hora");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 60, 50));
        getContentPane().add(tbHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 130, 30));

        jLabel8.setText("Fecha");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 70, 50));
        getContentPane().add(tbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 130, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("-INFORME DE PRODUCTO-");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 190, 40));

        jLabel18.setText("Categoria");
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 60, 50));

        cbCategorias.setBackground(new java.awt.Color(255, 204, 255));
        cbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriasActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 150, 30));

        lblIdMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar_副本.png"))); // NOI18N
        lblIdMesa.setText("Mesa");
        getContentPane().add(lblIdMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 50, 80, 30));

        tProducto.setBackground(new java.awt.Color(255, 204, 255));
        tProducto.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
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
        tProducto.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tProducto);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 90, 360, 90));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("-DETALLE-");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 80, 30));

        Cantidad.setText("Cantidad");
        getContentPane().add(Cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 60, 30));

        sCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        getContentPane().add(sCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 260, 80, 30));

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar_副本.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 260, 80, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Aceptar_副本.png"))); // NOI18N
        jButton2.setText("Quitar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 260, 90, 30));

        tDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tDetalle.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(tDetalle);

        getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 390, 90));

        jLabel16.setText("Total");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 400, 60, 40));
        getContentPane().add(tbTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 400, 140, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("--NÚMERO DE MESAS--");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, 210, 40));

        pnlMesas.setBackground(new java.awt.Color(255, 204, 255));
        pnlMesas.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(pnlMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 650, 90));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("--MENÚ--");
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 450, 90, 40));

        chPagado.setText("Pagado");
        chPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chPagadoActionPerformed(evt);
            }
        });
        getContentPane().add(chPagado, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 510, 80, 30));

        chCancelar.setText("Cancelar");
        chCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(chCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 550, 80, 30));

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 510, 110, 60));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("--NÚMERO DE MESAS--");
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 170, 50));

        btnPedido.setText("Nuevo  Pedido");
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 300, 110, 40));

        btnVerMesa.setText("Ver Mesa");
        btnVerMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 110, 40));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(153, 0, 153), new java.awt.Color(153, 0, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 0, 204));
        jPanel1.setOpaque(false);

        tMesero.setBackground(new java.awt.Color(255, 204, 255));
        tMesero.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tMesero.setModel(new javax.swing.table.DefaultTableModel(
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
        tMesero.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(tMesero);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("-MESEROS-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 86, Short.MAX_VALUE)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 1, 330, 180));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        int dni=Integer.parseInt(tbDni.getText());

        Cliente cliente=clienteData.buscarClienteXDni(dni);
        
        if(cliente!=null)
        {
            tbNombre.setText(cliente.getNombre());
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void cbCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoriasActionPerformed
        borraFilasTablaProducto();
        cargaDatosTablaProductos();
    }//GEN-LAST:event_cbCategoriasActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // boton Agregarvproducto a detalle
        int filaSeleccionada = this.tProducto.getSelectedRow();

        try
        {

            if(filaSeleccionada == -1)
            {
                JOptionPane.showMessageDialog(null, "Seleccione un Producto", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else if(Integer.parseInt(sCantidad.getValue().toString())== 0)
            {
                JOptionPane.showMessageDialog(null, "Ingrese cantidad", "Error", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                Pedido pedido = pedidoData.buscarPedido(NuevoPedido);

                int idProductoSeleccionado = Integer.parseInt(tProducto.getValueAt(filaSeleccionada, 0).toString());

                Producto producto = productoData.buscarProducto(idProductoSeleccionado);

                if(producto != null)
                {
                    int cantidad = parseInt(sCantidad.getValue().toString());

                    double total = cantidad * producto.getPrecio();
                    boolean activo = true;

                    Detalle detalle = new Detalle(producto,pedido,cantidad,total,activo);
                    detalleData.guardarDetalle(detalle);
                    cargaDatosTablaDetalle(detalle.getPedido().getIdPedido());
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al leer datos de la tabla: " + e.getMessage(), "Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        if(chPagado.isSelected()==true)
        {
            JOptionPane.showMessageDialog(null, "Pagado" + JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error" + JOptionPane.ERROR_MESSAGE);
        }

        if(chCancelar.isSelected()==true)
        {
            JOptionPane.showMessageDialog(null, "Cancelar" + JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Error" + JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidoActionPerformed
        //        clikeo el mesero

        Date fecha = null;

        int filaSeleccionada = this.tMesero.getSelectedRow();

        Mesa mesap = mesaData.buscarMesa(idMesa);

        try{
            if(mesap==null)
            {
                JOptionPane.showMessageDialog(null, "Seleccionar Mesa" );
            }
            else if("Ocupado".equals(mesap.getEstado()))
            {
                JOptionPane.showMessageDialog(null, "Seleccione una mesa libre" );
            }
            else if("Reservado".equals(mesap.getEstado()))
            {
                JOptionPane.showMessageDialog(null, "Seleccione una mesa libre" );
            }
            else if(filaSeleccionada==-1)
            {
                JOptionPane.showMessageDialog(null, "Seleccione Mesero" );
            }
            else
            {
                mesap.setEstado("Ocupado");
                mesaData.actualizarMesa(mesap);
                int idMesero=Integer.parseInt(tMesero.getValueAt(filaSeleccionada, 0).toString());
                Mesero mesero = meseroData.buscarMesero(idMesero);
                fecha=Date.valueOf(tbFecha.getText());
                String hora=tbHora.getText();
                boolean activo=true;
                boolean pendiente=false;//pagado
                boolean entregado=true;

                Pedido pedido=new Pedido(mesero,mesap,fecha,hora,activo,pendiente,entregado);
                pedidoData.guardarPedido(pedido);
                JOptionPane.showMessageDialog(null, "Pedido Agregado" );
                NuevoPedido=pedido.getIdPedido();

                pnlMesas.removeAll();
                CargarMesas();
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al agregar en base de datos" );
        }
    }//GEN-LAST:event_btnPedidoActionPerformed

    private void btnVerMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerMesaActionPerformed
        // TODO add your handling code here:
        
        try{
            Pedido pedido = pedidoData.buscarPedidoMesa(idMesa);
            if(pedido == null)
            {
                JOptionPane.showMessageDialog(null, "Seleccionar Mesa" );
            }
            else if("Libre".equals(pedido.getMesa().getEstado()))
            {
                JOptionPane.showMessageDialog(null, "Seleccione una mesa ocupada" );
            }
            else if("Reservado".equals(pedido.getMesa().getEstado()))
            {
                JOptionPane.showMessageDialog(null, "Seleccione una mesa ocupada" );
            }
            else if(idMesa==0)
            {
                JOptionPane.showMessageDialog(null, "Seleccione una mesa" );
            }
            else
            {
                cargaDatosTablaDetalle(pedido.getIdPedido());
            }

        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error al agregar en base de datos" );
        }
    }//GEN-LAST:event_btnVerMesaActionPerformed
//..............................................................................JCheckBox..,.......................................................
    private void chPagadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chPagadoActionPerformed
       //pagado es pendiente
//q es isSelected si el JCheckBox chpagado esta seleccionado
        chPagado.setSelected(true);
    }//GEN-LAST:event_chPagadoActionPerformed

    private void chCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chCancelarActionPerformed
        chCancelar.setSelected(true);
        
    }//GEN-LAST:event_chCancelarActionPerformed

    int NuevoPedido=0;    
    int idMesa=0;
    public void CargarMesas()
    {       
        listaMesas=(ArrayList)mesaData.obtenerMesas();
         for (Mesa item : listaMesas)
         {
            JButton boton = new JButton(item.getIdMesa()+"");
            boton.setName(item.getIdMesa()+"");
            
            pnlMesas.add(boton);
            botones.add(boton);
            pnlMesas.updateUI();
            
            if("Libre".equals(item.getEstado()))
            {
                boton.setBackground(Color.GREEN);
            }
            else if("Ocupado".equals(item.getEstado()))
            {
                boton.setBackground(Color.red);
            }
            else
            {
                boton.setBackground(Color.YELLOW); 
            }
            boton.addActionListener(new ActionListener()
            {
                @Override
                
                public void actionPerformed(ActionEvent e)
                {
                    idMesa=Integer.parseInt(boton.getName());
                    lblIdMesa.setText(boton.getName());
                }
            }
            );
         }     
    } 

    public void armaCabeceraTablaMesero()
    {   
        //Titulos de Columnas   
        ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("ID");
        columnas.add("Nombre");
        
        for(Object x:columnas)
        {
             modeloMesero.addColumn(x);
        }
        tMesero.setModel(modeloMesero);
    }
    public void cargaDatosTablaMesero()
    {
        borraFilasTablaMesero();
        listaMeseros=(ArrayList)meseroData.obtenerMeseros();         
        //Llenar filas
        for(Mesero m:listaMeseros)
        {
           modeloMesero.addRow(new Object[]{m.getIdMesero(),m.getNombre()});
        }
    } 
    public void borraFilasTablaMesero()
    {
            int a =modeloMesero.getRowCount()-1;
            for(int i=a;i>=0;i--)
            {
                modeloMesero.removeRow(i );
            }
      }
//---------------------------PRODUCTO TABLA
      
      public void armaCabeceraTablaProducto()
      {  
        //Titulos de Columnas
        ArrayList<Object> columnas=new ArrayList<Object>();
        columnas.add("id");
        columnas.add("Nombre");
        columnas.add("Catidad");
        columnas.add("Precio");
        
        for(Object vp:columnas)
        {   
            modeloProducto.addColumn(vp);
        }
        tProducto.setModel(modeloProducto);
}
        public void cargaDatosTablaProductos()
        {
            borraFilasTablaProducto();
            String seleccionado=cbCategorias.getSelectedItem().toString();
            
            Categoria categoria=categoriaData.buscarCategoriaNombre(seleccionado);
            
            listaProductos =(ArrayList)productoData.obtenerProductosXCategoria(categoria.getIdCategoria());
            
            for(Producto p:listaProductos)//Llenar filas
            {     
                modeloProducto.addRow(new Object[]{p.getIdProducto(),p.getNombre(),p.getCantidad(),p.getPrecio()});         
            }
        }
        
       public void borraFilasTablaProducto()
       {
            int a = modeloProducto.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--){
                modeloProducto.removeRow(i );}
      }   
       //---------------------------DETALLE TABLA--------------------------------------------------
        public void armaCabeceraTablaDetalle()
        {  
            //Titulos de Columnas
            ArrayList<Object> columnas=new ArrayList<Object>();
            columnas.add("ID:");
            columnas.add("CANT.");
            columnas.add("DESCRIPCION");
            columnas.add("P.UNIT");
            columnas.add("IMPORTE");

            for(Object vp:columnas)
            {   
                modeloDetalle.addColumn(vp);
            }
            tDetalle.setModel(modeloDetalle);
        }
        //.............................................. cargar.............................................................
        public void cargaDatosTablaDetalle(int idPedido)
        {   double contador=0;
            borraFilasTablaDetalle();
            listaDetalles=(ArrayList)detalleData.obtenerDetalle(idPedido);         
            //Llenar filas
            for(Detalle d:listaDetalles)
            {
                modeloDetalle.addRow(new Object[]{d.getIdDetalle(),d.getCantidad(),d.getProducto().getNombre(),d.getProducto().getPrecio(),d.getTotal()});
                contador=contador+d.getTotal(); 
            }
             tbTotal.setText(contador+"");
        }

        public void borraFilasTablaDetalle()
        {
            int a = modeloDetalle.getRowCount()-1;
            System.out.println("Tabla "+a);
            for(int i=a;i>=0;i--)
            {
                modeloDetalle.removeRow(i);
            }
        }
        public void cargarCategoriaProductoComboBox()
    {
        for(Categoria item:listaCategorias)
        {
            cbCategorias.addItem(item.getNombre());
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cantidad;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnPedido;
    private javax.swing.JButton btnVerMesa;
    private javax.swing.JComboBox<String> cbCategorias;
    private javax.swing.JCheckBox chCancelar;
    private javax.swing.JCheckBox chPagado;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JLabel lblIdMesa;
    private javax.swing.JPanel pnlMesas;
    private javax.swing.JSpinner sCantidad;
    private javax.swing.JTable tDetalle;
    private javax.swing.JTable tMesero;
    private javax.swing.JTable tProducto;
    private javax.swing.JTextField tbDni;
    private javax.swing.JTextField tbFecha;
    private javax.swing.JTextField tbHora;
    private javax.swing.JTextField tbNombre;
    private javax.swing.JTextField tbTotal;
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
