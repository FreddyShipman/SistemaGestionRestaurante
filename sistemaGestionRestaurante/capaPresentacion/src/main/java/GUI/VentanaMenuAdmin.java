package GUI;

import BO.ProductoBO;
import excepciones.NegocioException;
import interfaces.IMesaBO;
import javax.swing.JOptionPane;
import manejadoresDeObjetoNegocio.ManejadorObjetosNegocio;

/**
 *
 * @author janot
 */
public class VentanaMenuAdmin extends javax.swing.JFrame {
    private IMesaBO mesaBO;
    private Control control = new Control();
    private final int CANTIDAD_MESAS_AGREGAR = 20;
    
    /**
     * Creates new form VentanaMenuAdmin
     */
    public VentanaMenuAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
        mesaBO = ManejadorObjetosNegocio.crearMesaBO();
        ocultarBtnInsertarMesas();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelRestaurante = new javax.swing.JLabel();
        jPanelComandas = new javax.swing.JPanel();
        jLabelIconComanda = new javax.swing.JLabel();
        jPanelProductos = new javax.swing.JPanel();
        jLabelIconProductos = new javax.swing.JLabel();
        jPanelIngredientes = new javax.swing.JPanel();
        jLabelIconIngredientes = new javax.swing.JLabel();
        JPanelClientes = new javax.swing.JPanel();
        jLabelIconClientes = new javax.swing.JLabel();
        jPanelNuevaComanda = new javax.swing.JPanel();
        jLabelIconNuevaComanda = new javax.swing.JLabel();
        jPanelComandasPendientes = new javax.swing.JPanel();
        jLabelIconComandasPendientes = new javax.swing.JLabel();
        jLabelNuevaComanda = new javax.swing.JLabel();
        jLabelComandas1 = new javax.swing.JLabel();
        jLabelProductos = new javax.swing.JLabel();
        jLabelIngredientes = new javax.swing.JLabel();
        jLabelClientes1 = new javax.swing.JLabel();
        jLabelNuevaComanda1 = new javax.swing.JLabel();
        jLabelRegresar = new javax.swing.JLabel();
        jPanelInsertarMesas = new GUI.PanelRound();
        jLabelInsertarMesas1 = new javax.swing.JLabel();
        jLabelInsertarMesas2 = new javax.swing.JLabel();
        jLabelInsertarMesas3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(920, 590));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRestaurante.setFont(new java.awt.Font("Product Sans Infanity", 0, 66)); // NOI18N
        jLabelRestaurante.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRestaurante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRestaurante.setText("Restaurante");
        jPanel1.add(jLabelRestaurante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 370, -1));

        jPanelComandas.setBackground(new java.awt.Color(217, 217, 217));
        jPanelComandas.setForeground(new java.awt.Color(217, 217, 217));

        jLabelIconComanda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/order-food-online.png"))); // NOI18N
        jLabelIconComanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconComandaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelComandasLayout = new javax.swing.GroupLayout(jPanelComandas);
        jPanelComandas.setLayout(jPanelComandasLayout);
        jPanelComandasLayout.setHorizontalGroup(
            jPanelComandasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComandasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelIconComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelComandasLayout.setVerticalGroup(
            jPanelComandasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelComandasLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelIconComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(jPanelComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 150, 140));

        jPanelProductos.setBackground(new java.awt.Color(217, 217, 217));
        jPanelProductos.setForeground(new java.awt.Color(217, 217, 217));

        jLabelIconProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/hamburger-soda.png"))); // NOI18N
        jLabelIconProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconProductosMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        jPanelIngredientes.setBackground(new java.awt.Color(217, 217, 217));
        jPanelIngredientes.setForeground(new java.awt.Color(217, 217, 217));

        jLabelIconIngredientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconIngredientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/recipe.png"))); // NOI18N
        jLabelIconIngredientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconIngredientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconIngredientesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelIngredientesLayout = new javax.swing.GroupLayout(jPanelIngredientes);
        jPanelIngredientes.setLayout(jPanelIngredientesLayout);
        jPanelIngredientesLayout.setHorizontalGroup(
            jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanelIngredientesLayout.setVerticalGroup(
            jPanelIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconIngredientes, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, -1));

        JPanelClientes.setBackground(new java.awt.Color(217, 217, 217));
        JPanelClientes.setForeground(new java.awt.Color(217, 217, 217));

        jLabelIconClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book-user.png"))); // NOI18N
        jLabelIconClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout JPanelClientesLayout = new javax.swing.GroupLayout(JPanelClientes);
        JPanelClientes.setLayout(JPanelClientesLayout);
        JPanelClientesLayout.setHorizontalGroup(
            JPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        JPanelClientesLayout.setVerticalGroup(
            JPanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel1.add(JPanelClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        jPanelNuevaComanda.setBackground(new java.awt.Color(217, 217, 217));
        jPanelNuevaComanda.setForeground(new java.awt.Color(217, 217, 217));

        jLabelIconNuevaComanda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconNuevaComanda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/square-plus.png"))); // NOI18N
        jLabelIconNuevaComanda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconNuevaComanda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconNuevaComandaMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevaComandaLayout = new javax.swing.GroupLayout(jPanelNuevaComanda);
        jPanelNuevaComanda.setLayout(jPanelNuevaComandaLayout);
        jPanelNuevaComandaLayout.setHorizontalGroup(
            jPanelNuevaComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconNuevaComanda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanelNuevaComandaLayout.setVerticalGroup(
            jPanelNuevaComandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconNuevaComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelNuevaComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 350, -1, -1));

        jPanelComandasPendientes.setBackground(new java.awt.Color(217, 217, 217));
        jPanelComandasPendientes.setForeground(new java.awt.Color(217, 217, 217));

        jLabelIconComandasPendientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIconComandasPendientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pending.png"))); // NOI18N
        jLabelIconComandasPendientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconComandasPendientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconComandasPendientesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelComandasPendientesLayout = new javax.swing.GroupLayout(jPanelComandasPendientes);
        jPanelComandasPendientes.setLayout(jPanelComandasPendientesLayout);
        jPanelComandasPendientesLayout.setHorizontalGroup(
            jPanelComandasPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconComandasPendientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
        jPanelComandasPendientesLayout.setVerticalGroup(
            jPanelComandasPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelIconComandasPendientes, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );

        jPanel1.add(jPanelComandasPendientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 350, -1, -1));

        jLabelNuevaComanda.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNuevaComanda.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelNuevaComanda.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNuevaComanda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNuevaComanda.setText("Comandas Pendientes");
        jPanel1.add(jLabelNuevaComanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 490, 150, 50));

        jLabelComandas1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelComandas1.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelComandas1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelComandas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelComandas1.setText("Comandas");
        jPanel1.add(jLabelComandas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 150, -1));

        jLabelProductos.setBackground(new java.awt.Color(0, 0, 0));
        jLabelProductos.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelProductos.setForeground(new java.awt.Color(0, 0, 0));
        jLabelProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProductos.setText("Productos");
        jPanel1.add(jLabelProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 150, 30));

        jLabelIngredientes.setBackground(new java.awt.Color(0, 0, 0));
        jLabelIngredientes.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelIngredientes.setForeground(new java.awt.Color(0, 0, 0));
        jLabelIngredientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelIngredientes.setText("Ingredientes");
        jPanel1.add(jLabelIngredientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 150, -1));

        jLabelClientes1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelClientes1.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelClientes1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelClientes1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelClientes1.setText("Clientes");
        jPanel1.add(jLabelClientes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 150, -1));

        jLabelNuevaComanda1.setBackground(new java.awt.Color(0, 0, 0));
        jLabelNuevaComanda1.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelNuevaComanda1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNuevaComanda1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNuevaComanda1.setText("Nueva Comanda");
        jPanel1.add(jLabelNuevaComanda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 490, 150, 50));

        jLabelRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanelInsertarMesas.setBackground(new java.awt.Color(44, 44, 44));
        jPanelInsertarMesas.setRoundBottomLeft(15);
        jPanelInsertarMesas.setRoundBottomRight(15);
        jPanelInsertarMesas.setRoundTopLeft(15);
        jPanelInsertarMesas.setRoundTopRight(15);
        jPanelInsertarMesas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelInsertarMesas1.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelInsertarMesas1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInsertarMesas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInsertarMesas1.setText("Insertar ");
        jLabelInsertarMesas1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInsertarMesas1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInsertarMesas1MouseClicked(evt);
            }
        });
        jPanelInsertarMesas.add(jLabelInsertarMesas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        jLabelInsertarMesas2.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelInsertarMesas2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInsertarMesas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInsertarMesas2.setText("20");
        jLabelInsertarMesas2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInsertarMesas2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInsertarMesas2MouseClicked(evt);
            }
        });
        jPanelInsertarMesas.add(jLabelInsertarMesas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 100, -1));

        jLabelInsertarMesas3.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelInsertarMesas3.setForeground(new java.awt.Color(255, 255, 255));
        jLabelInsertarMesas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelInsertarMesas3.setText("Mesas");
        jLabelInsertarMesas3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelInsertarMesas3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelInsertarMesas3MouseClicked(evt);
            }
        });
        jPanelInsertarMesas.add(jLabelInsertarMesas3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 100, 30));

        jPanel1.add(jPanelInsertarMesas, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 100, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 930, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseClicked
        control.mostrarPantallaEscogerRol();
        control.cerrarPantalla(this);
    }//GEN-LAST:event_jLabelRegresarMouseClicked

    private void jLabelIconComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconComandaMouseClicked
        control.mostrarPantallaHistorialComandas();
        control.cerrarPantalla(this);
    }//GEN-LAST:event_jLabelIconComandaMouseClicked

    private void jLabelIconProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconProductosMouseClicked
        control.mostrarPantallaProductos();
        control.cerrarPantalla(this);
    }//GEN-LAST:event_jLabelIconProductosMouseClicked

    private void jLabelIconNuevaComandaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconNuevaComandaMouseClicked
        control.mostrarPantallaComandaNueva(null, rootPaneCheckingEnabled);
    }//GEN-LAST:event_jLabelIconNuevaComandaMouseClicked

    private void jLabelInsertarMesas1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInsertarMesas1MouseClicked
        insertarMesas(CANTIDAD_MESAS_AGREGAR);
    }//GEN-LAST:event_jLabelInsertarMesas1MouseClicked

    private void jLabelInsertarMesas2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInsertarMesas2MouseClicked
        insertarMesas(CANTIDAD_MESAS_AGREGAR);
    }//GEN-LAST:event_jLabelInsertarMesas2MouseClicked

    private void jLabelInsertarMesas3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelInsertarMesas3MouseClicked
        insertarMesas(CANTIDAD_MESAS_AGREGAR);
    }//GEN-LAST:event_jLabelInsertarMesas3MouseClicked

    private void jLabelIconComandasPendientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconComandasPendientesMouseClicked
        control.mostrarPantallaComandasPendientes();
        control.cerrarPantalla(this);
    }//GEN-LAST:event_jLabelIconComandasPendientesMouseClicked

    private void jLabelIconIngredientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconIngredientesMouseClicked
        control.mostrarPantallaIngredientes();
        control.cerrarPantalla(this);
    }//GEN-LAST:event_jLabelIconIngredientesMouseClicked


    /* UTILS */
    
    public void ocultarBtnInsertarMesas(){
        if(mesasRegistradasEnBD() != 0){
            jPanel1.remove(jPanelInsertarMesas);
            jPanel1.repaint();
        }
    }
    
    public void insertarMesas(int cantidadMesas){
        try {
           if(mesaBO.agregarMesas(cantidadMesas)){
               JOptionPane.showMessageDialog(this, "Se han insertado " + cantidadMesas + " mesas");
               ocultarBtnInsertarMesas();
               
           }
        } catch (NegocioException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public int mesasRegistradasEnBD(){
        int size  = 0;
        try {
            size = mesaBO.consultarMesas().size();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        return size;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelClientes;
    private javax.swing.JLabel jLabelClientes1;
    private javax.swing.JLabel jLabelComandas1;
    private javax.swing.JLabel jLabelIconClientes;
    private javax.swing.JLabel jLabelIconComanda;
    private javax.swing.JLabel jLabelIconComandasPendientes;
    private javax.swing.JLabel jLabelIconIngredientes;
    private javax.swing.JLabel jLabelIconNuevaComanda;
    private javax.swing.JLabel jLabelIconProductos;
    private javax.swing.JLabel jLabelIngredientes;
    private javax.swing.JLabel jLabelInsertarMesas1;
    private javax.swing.JLabel jLabelInsertarMesas2;
    private javax.swing.JLabel jLabelInsertarMesas3;
    private javax.swing.JLabel jLabelNuevaComanda;
    private javax.swing.JLabel jLabelNuevaComanda1;
    private javax.swing.JLabel jLabelProductos;
    private javax.swing.JLabel jLabelRegresar;
    private javax.swing.JLabel jLabelRestaurante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelComandas;
    private javax.swing.JPanel jPanelComandasPendientes;
    private javax.swing.JPanel jPanelIngredientes;
    private GUI.PanelRound jPanelInsertarMesas;
    private javax.swing.JPanel jPanelNuevaComanda;
    private javax.swing.JPanel jPanelProductos;
    // End of variables declaration//GEN-END:variables
}
