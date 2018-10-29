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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tMesero = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnPedido = new javax.swing.JButton();
        btnVerMesa = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 204, 204));
        setMaximumSize(new java.awt.Dimension(1300, 651));
        setMinimumSize(new java.awt.Dimension(1300, 651));
        setPreferredSize(new java.awt.Dimension(1300, 651));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("-INFORME DE CLIENTE-");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 0, 190, 30);

        jLabel7.setText("Dni");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(360, 30, 40, 50);

        tbDni.setBorder(null);
        getContentPane().add(tbDni);
        tbDni.setBounds(420, 40, 140, 30);

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
        jbBuscar.setBounds(590, 40, 90, 50);

        jLabel9.setText("Cliente");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(360, 80, 50, 40);

        tbNombre.setBorder(null);
        getContentPane().add(tbNombre);
        tbNombre.setBounds(420, 80, 140, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("-FECHA/HORA-");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(450, 120, 130, 40);

        jLabel13.setText("Hora");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(370, 150, 60, 50);
        getContentPane().add(tbHora);
        tbHora.setBounds(430, 160, 130, 30);

        jLabel8.setText("Fecha");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(370, 190, 70, 50);
        getContentPane().add(tbFecha);
        tbFecha.setBounds(430, 200, 130, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("-INFORME DE PRODUCTO-");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(810, 0, 190, 40);

        jLabel18.setText("Categoria");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(720, 40, 60, 50);

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
        jScrollPane1.setBounds(720, 90, 360, 90);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("-DETALLE-");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(860, 220, 80, 30);

        Cantidad.setText("Cantidad");
        getContentPane().add(Cantidad);
        Cantidad.setBounds(730, 260, 60, 30);

        sCantidad.setModel(new javax.swing.SpinnerNumberModel(1, 1, 100, 1));
        getContentPane().add(sCantidad);
        sCantidad.setBounds(800, 260, 80, 30);

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
        btnAgregar.setBounds(900, 240, 100, 70);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/RECHAZARROSA_副本.png"))); // NOI18N
        jButton2.setText("Quitar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButton2);
        jButton2.setBounds(1020, 250, 100, 50);

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
        jScrollPane5.setBounds(720, 300, 390, 90);

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
        pnlMesas.setBounds(10, 430, 650, 90);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("--MENÚ--");
        getContentPane().add(jLabel23);
        jLabel23.setBounds(860, 450, 90, 40);

        chPagado.setBackground(new java.awt.Color(255, 153, 255));
        chPagado.setText("Pagado");
        chPagado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chPagadoActionPerformed(evt);
            }
        });
        getContentPane().add(chPagado);
        chPagado.setBounds(760, 510, 80, 30);

        chCancelar.setBackground(new java.awt.Color(255, 153, 255));
        chCancelar.setText("Cancelar");
        chCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(chCancelar);
        chCancelar.setBounds(760, 550, 80, 30);

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
        btnGuardar.setBounds(910, 510, 110, 60);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
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
        tMesero.setSelectionBackground(new java.awt.Color(51, 0, 51));
        jScrollPane3.setViewportView(tMesero);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("-MESEROS-");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(2, 1, 330, 400);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(330, 0, 360, 120);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 359, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(330, 120, 360, 130);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 211, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(690, 0, 430, 200);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");

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

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("--NÚMERO DE MESAS--");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnVerMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 360, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVerMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(330, 250, 360, 150);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6);
        jPanel6.setBounds(690, 200, 430, 240);

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel7);
        jPanel7.setBounds(-10, 400, 700, 220);

        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 102, 255), java.awt.Color.pink));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/depositphotos_90571462-stock-photo-wooden-wall-texture-background-pink_1.jpg"))); // NOI18N
        jLabel17.setText("jLabel17");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 180, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel8);
        jPanel8.setBounds(690, 440, 430, 180);

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
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
