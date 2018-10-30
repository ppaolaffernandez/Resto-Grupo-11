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
import javax.swing.ButtonGroup;
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
        String Menu="";
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

        btrpConjunto = new javax.swing.ButtonGroup();
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
        btnGuardar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tMesero = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnPedido = new javax.swing.JButton();
        btnVerMesa = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        rbPagado = new javax.swing.JRadioButton();
        rbCancelado = new javax.swing.JRadioButton();
        rbAtendido = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1300, 651));
        setMinimumSize(new java.awt.Dimension(1300, 651));
        setPreferredSize(new java.awt.Dimension(1300, 651));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("-INFORME DE CLIENTE-");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 0, 190, 30);

        jLabel7.setText("Dni");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(340, 30, 40, 50);

        tbDni.setBorder(null);
        tbDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbDniActionPerformed(evt);
            }
        });
        getContentPane().add(tbDni);
        tbDni.setBounds(400, 40, 140, 30);

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
        getContentPane().add(jbBuscar);
        jbBuscar.setBounds(570, 40, 90, 50);

        jLabel9.setText("Cliente");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(340, 80, 50, 40);

        tbNombre.setBorder(null);
        getContentPane().add(tbNombre);
        tbNombre.setBounds(400, 80, 140, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("-FECHA/HORA-");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(420, 130, 130, 40);

        jLabel13.setText("Hora");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(360, 170, 60, 50);
        getContentPane().add(tbHora);
        tbHora.setBounds(430, 180, 130, 30);

        jLabel8.setText("Fecha");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(360, 210, 70, 50);
        getContentPane().add(tbFecha);
        tbFecha.setBounds(430, 220, 130, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("-INFORME DE PRODUCTO-");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(810, 0, 190, 40);

        jLabel18.setText("Categoria");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(730, 40, 60, 50);

        cbCategorias.setBackground(new java.awt.Color(255, 204, 255));
        cbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoriasActionPerformed(evt);
            }
        });
        getContentPane().add(cbCategorias);
        cbCategorias.setBounds(790, 50, 150, 30);

        lblIdMesa.setText("Mesa");
        getContentPane().add(lblIdMesa);
        lblIdMesa.setBounds(970, 50, 80, 30);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(730, 90, 360, 90);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("-DETALLE-");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(840, 210, 90, 30);

        Cantidad.setText("Cantidad");
        getContentPane().add(Cantidad);
        Cantidad.setBounds(710, 240, 70, 30);

        sCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        getContentPane().add(sCantidad);
        sCantidad.setBounds(780, 240, 90, 30);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ACEPTARROSA_副本.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setBorder(null);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setContentAreaFilled(false);
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(880, 220, 110, 70);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RECHAZARROSA_副本.png"))); // NOI18N
        jButton2.setText("Quitar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2);
        jButton2.setBounds(1000, 230, 110, 50);

        tDetalle.setBackground(new java.awt.Color(255, 204, 255));
        tDetalle.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 204, 255))); // NOI18N
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
        tDetalle.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane5.setViewportView(tDetalle);

        getContentPane().add(jScrollPane5);
        jScrollPane5.setBounds(720, 280, 390, 90);

        jLabel16.setText("Total");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(900, 400, 60, 40);
        getContentPane().add(tbTotal);
        tbTotal.setBounds(940, 400, 140, 30);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("--NÚMERO DE MESAS--");
        getContentPane().add(jLabel21);
        jLabel21.setBounds(260, 390, 210, 40);

        pnlMesas.setBackground(new java.awt.Color(255, 204, 255));
        pnlMesas.setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(pnlMesas);
        pnlMesas.setBounds(20, 430, 650, 160);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("--MENÚ--");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(820, 460, 90, 40);

        btnGuardar.setBackground(new java.awt.Color(255, 153, 255));
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
        btnGuardar.setBounds(960, 510, 110, 60);

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
        tMesero.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane3.setViewportView(tMesero);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 60, 306, 92);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("-MESEROS-");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(80, 0, 220, 40);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("--NÚMERO DE MESAS--");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(410, 270, 170, 50);

        btnPedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/aGREGARICONOROSA_副本.png"))); // NOI18N
        btnPedido.setText("Nuevo  Pedido");
        btnPedido.setBorder(null);
        btnPedido.setBorderPainted(false);
        btnPedido.setContentAreaFilled(false);
        btnPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnPedido);
        btnPedido.setBounds(330, 330, 140, 40);

        btnVerMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ICONO VER_副本.png"))); // NOI18N
        btnVerMesa.setText("Ver Mesa");
        btnVerMesa.setBorder(null);
        btnVerMesa.setBorderPainted(false);
        btnVerMesa.setContentAreaFilled(false);
        btnVerMesa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerMesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerMesa);
        btnVerMesa.setBounds(500, 330, 120, 40);

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel20.setText("jLabel20");
        getContentPane().add(jLabel20);
        jLabel20.setBounds(0, 0, 320, 390);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(330, 0, 350, 130);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 140, 350, 120);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(330, 270, 350, 120);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(690, 0, 430, 200);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(690, 210, 430, 240);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, 400, 680, 220);

        btrpConjunto.add(rbPagado);
        rbPagado.setText("Pagado");
        rbPagado.setToolTipText("esta es la opcion pagado Pagado");
        getContentPane().add(rbPagado);
        rbPagado.setBounds(780, 530, 90, 23);

        btrpConjunto.add(rbCancelado);
        rbCancelado.setText("Cancelar");
        getContentPane().add(rbCancelado);
        rbCancelado.setBounds(780, 560, 90, 23);

        btrpConjunto.add(rbAtendido);
        rbAtendido.setSelected(true);
        rbAtendido.setText("Atendido");
        rbAtendido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAtendidoActionPerformed(evt);
            }
        });
        getContentPane().add(rbAtendido);
        rbAtendido.setBounds(780, 500, 90, 23);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/mas pequeño副本.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(690, 460, 430, 160);

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
        //peniente=esta pagado ono
        //si lo entrego o lo cancelo el cliente
        if(rbAtendido.isSelected()==true)
        {
            
            VistaPedidos vp=new VistaPedidos();
            vp.setVisible(true);
            
        }
        if(rbPagado.isSelected()==true)
        {
            JOptionPane.showMessageDialog(null, "Pagado" + JOptionPane.INFORMATION_MESSAGE);
            Pedido pedido=pedidoData.buscarPedidoMesa(idMesa);
            pedido.setPendiente(true);
            pedidoData.actualizarPedido(pedido);
            
            Mesa mesa = mesaData.buscarMesa(pedido.getMesa().getIdMesa());
            mesa.setEstado("Libre");
            mesaData.actualizarMesa(mesa);
        }
        if(rbCancelado.isSelected()==true)
        {
            JOptionPane.showMessageDialog(null, "Cancelar" + JOptionPane.INFORMATION_MESSAGE);
            Pedido pedido=pedidoData.buscarPedidoMesa(idMesa);
            pedido.setEntregado(true);
            pedidoData.actualizarPedido(pedido);
            
            Mesa mesa = mesaData.buscarMesa(pedido.getMesa().getIdMesa());
            mesa.setEstado("Libre");
            mesaData.actualizarMesa(mesa);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

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
    
    int NuevoPedido=0;
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

    private void tbDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbDniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbDniActionPerformed

    private void rbAtendidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAtendidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbAtendidoActionPerformed

        
    int idMesa=0;
    public void CargarMesas()
    {       
        listaMesas=(ArrayList)mesaData.obtenerMesas();
         for (Mesa item : listaMesas)
         {
            JButton boton = new JButton(item.getNombre());
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
    private javax.swing.ButtonGroup btrpConjunto;
    private javax.swing.JComboBox<String> cbCategorias;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JLabel lblIdMesa;
    private javax.swing.JPanel pnlMesas;
    private javax.swing.JRadioButton rbAtendido;
    private javax.swing.JRadioButton rbCancelado;
    private javax.swing.JRadioButton rbPagado;
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
