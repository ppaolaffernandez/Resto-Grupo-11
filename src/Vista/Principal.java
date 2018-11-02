
package Vista;

import javax.swing.JFrame;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar3 = new javax.swing.JMenuBar();
        Categorias = new javax.swing.JMenu();
        jmiCategorias = new javax.swing.JMenuItem();
        Clientes = new javax.swing.JMenu();
        jmiClientes = new javax.swing.JMenuItem();
        mesas = new javax.swing.JMenu();
        jmiMesas = new javax.swing.JMenuItem();
        meseros = new javax.swing.JMenu();
        jmiMeseros = new javax.swing.JMenuItem();
        pedidos = new javax.swing.JMenu();
        jmiPedidos = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        productos = new javax.swing.JMenu();
        jmiProductos = new javax.swing.JMenuItem();
        reservas = new javax.swing.JMenu();
        jmiReservas = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(972, 546));
        setMinimumSize(new java.awt.Dimension(972, 546));

        escritorio.setBackground(new java.awt.Color(255, 204, 255));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        Categorias.setText("Categorias");

        jmiCategorias.setText("Formularios de Categorias");
        jmiCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCategoriasActionPerformed(evt);
            }
        });
        Categorias.add(jmiCategorias);

        jMenuBar3.add(Categorias);

        Clientes.setText("Clientes");

        jmiClientes.setText("Formularios de Clientes");
        jmiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiClientesActionPerformed(evt);
            }
        });
        Clientes.add(jmiClientes);

        jMenuBar3.add(Clientes);

        mesas.setText("Mesas");

        jmiMesas.setText("Formularios de mesas");
        jmiMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMesasActionPerformed(evt);
            }
        });
        mesas.add(jmiMesas);

        jMenuBar3.add(mesas);

        meseros.setText("Meseros");

        jmiMeseros.setText("Formularios de Meseros");
        jmiMeseros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiMeserosActionPerformed(evt);
            }
        });
        meseros.add(jmiMeseros);

        jMenuBar3.add(meseros);

        pedidos.setText("Pedidos");

        jmiPedidos.setText("Formularios de Pedidos");
        jmiPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPedidosActionPerformed(evt);
            }
        });
        pedidos.add(jmiPedidos);

        jMenuItem1.setText("Pedido2");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        pedidos.add(jMenuItem1);

        jMenuBar3.add(pedidos);

        productos.setText("Productos");

        jmiProductos.setText("Formularios de Productos");
        jmiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiProductosActionPerformed(evt);
            }
        });
        productos.add(jmiProductos);

        jMenuBar3.add(productos);

        reservas.setText("Reservas");

        jmiReservas.setText("Formularios de Reserva");
        jmiReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiReservasActionPerformed(evt);
            }
        });
        reservas.add(jmiReservas);

        jMenuBar3.add(reservas);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 972, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(escritorio))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCategoriasActionPerformed
       escritorio.removeAll();
        escritorio.repaint();
        VistaCategorias vc=new VistaCategorias();
        vc.setVisible(true);
        escritorio.add(vc);
        escritorio.moveToFront(vc);
        
        
        
    }//GEN-LAST:event_jmiCategoriasActionPerformed

    private void jmiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiClientesActionPerformed
        // TODO add your handling code here:
        escritorio.removeAll();
        escritorio.repaint();
        VistaClientes vc=new VistaClientes();
        vc.setVisible(true);
        escritorio.add(vc);
        escritorio.moveToFront(vc);
    }//GEN-LAST:event_jmiClientesActionPerformed

    private void jmiMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMesasActionPerformed
        // TODO add your handling code here:
         escritorio.removeAll();
        escritorio.repaint();
        VistaMesas vmesa=new VistaMesas();
        vmesa.setVisible(true);
        escritorio.add(vmesa);
        escritorio.moveToFront(vmesa);
    }//GEN-LAST:event_jmiMesasActionPerformed

    private void jmiMeserosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiMeserosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaMeseros vmeser=new VistaMeseros();
        vmeser.setVisible(true);
        escritorio.add(vmeser);
        escritorio.moveToFront(vmeser);
    }//GEN-LAST:event_jmiMeserosActionPerformed

    private void jmiPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPedidosActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
       VistaPedidos vp=new VistaPedidos();
        vp.setVisible(true);
        escritorio.add(vp);
        escritorio.moveToFront(vp);
    }//GEN-LAST:event_jmiPedidosActionPerformed

    private void jmiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiProductosActionPerformed
       escritorio.removeAll();
        escritorio.repaint();
        VistaProductos vp=new VistaProductos();
        vp.setVisible(true);
        escritorio.add(vp);
        escritorio.moveToFront(vp);
    }//GEN-LAST:event_jmiProductosActionPerformed

    private void jmiReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiReservasActionPerformed
        escritorio.removeAll();
        escritorio.repaint();
        VistaReservas vr=new VistaReservas();
        vr.setVisible(true);
        escritorio.add(vr);
        escritorio.moveToFront(vr);
    }//GEN-LAST:event_jmiReservasActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
         escritorio.removeAll();
        escritorio.repaint();
       VistaPedidos vp=new VistaPedidos();
        vp.setVisible(true);
        escritorio.add(vp);
        escritorio.moveToFront(vp);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Categorias;
    private javax.swing.JMenu Clientes;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jmiCategorias;
    private javax.swing.JMenuItem jmiClientes;
    private javax.swing.JMenuItem jmiMesas;
    private javax.swing.JMenuItem jmiMeseros;
    private javax.swing.JMenuItem jmiPedidos;
    private javax.swing.JMenuItem jmiProductos;
    private javax.swing.JMenuItem jmiReservas;
    private javax.swing.JMenu mesas;
    private javax.swing.JMenu meseros;
    private javax.swing.JMenu pedidos;
    private javax.swing.JMenu productos;
    private javax.swing.JMenu reservas;
    // End of variables declaration//GEN-END:variables
}
