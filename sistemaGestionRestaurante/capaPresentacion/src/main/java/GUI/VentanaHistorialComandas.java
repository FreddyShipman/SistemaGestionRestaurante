package GUI;

import BO.ComandaBO;
import conexion.ConexionConJDBC;
import entidades.Comanda;
import enums.EstadoComanda;
import enums.TipoProducto;
import excepciones.NegocioException;
import interfaces.IComandaBO;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import manejadoresDeObjetoNegocio.ManejadorObjetosNegocio;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import conexion.ConexionConJDBC;
import java.io.InputStream;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author janot
 */
public class VentanaHistorialComandas extends javax.swing.JFrame {
    private boolean esAdmin = true;
    Control control = new Control();
    IComandaBO comandaBO;
    private List<Comanda> comandasCargadas = new ArrayList<>();
    
    /**
     * Creates new form VentanaHistorialComandas
     */
    public VentanaHistorialComandas() {
        comandaBO = ManejadorObjetosNegocio.crearComandaBO();
        initComponents();
        buscador();
        cargarDatosTabla();
        
        this.setLocationRelativeTo(null);
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
        jLabelRegresar = new javax.swing.JLabel();
        jLabelComandas = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelHistorialComandas = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelIconFiltro = new javax.swing.JLabel();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jLabelEstado1 = new javax.swing.JLabel();
        jLabelFechaHasta = new javax.swing.JLabel();
        jLabelIconPdf = new javax.swing.JLabel();
        jLabelFechaDesde = new javax.swing.JLabel();
        jLabelReporte = new javax.swing.JLabel();
        jLabelGenerar = new javax.swing.JLabel();
        datePickerFechaDesde = new com.github.lgooddatepicker.components.DatePicker();
        timePickerHoraDesde = new com.github.lgooddatepicker.components.TimePicker();
        datePickerFechaHasta = new com.github.lgooddatepicker.components.DatePicker();
        timePickerHoraHasta = new com.github.lgooddatepicker.components.TimePicker();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableComandas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelRegresar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/arrow-small-left.png"))); // NOI18N
        jLabelRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRegresarMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelComandas.setFont(new java.awt.Font("Product Sans Infanity", 1, 66)); // NOI18N
        jLabelComandas.setForeground(new java.awt.Color(0, 0, 0));
        jLabelComandas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelComandas.setText("Comandas");
        jPanel1.add(jLabelComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(69, 71, 75));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelHistorialComandas.setFont(new java.awt.Font("Product Sans Infanity", 1, 24)); // NOI18N
        jLabelHistorialComandas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelHistorialComandas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelHistorialComandas.setText("Historial de Comandas");
        jPanel2.add(jLabelHistorialComandas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 320, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 920, 40));

        jPanel3.setBackground(new java.awt.Color(217, 217, 217));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelIconFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/filter.png"))); // NOI18N
        jPanel3.add(jLabelIconFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new EstadoComanda[] { null, EstadoComanda.ABIERTA, EstadoComanda.ENTREGADA, EstadoComanda.CANCELADA}));
        jComboBoxEstado.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxEstadoItemStateChanged(evt);
            }
        });
        jPanel3.add(jComboBoxEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 80, 30));

        jLabelEstado1.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelEstado1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEstado1.setText("Estado:");
        jPanel3.add(jLabelEstado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabelFechaHasta.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelFechaHasta.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFechaHasta.setText("Fecha Hasta:");
        jPanel3.add(jLabelFechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, -1, 20));

        jLabelIconPdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file-pdf.png"))); // NOI18N
        jLabelIconPdf.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelIconPdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelIconPdfMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelIconPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, 40));

        jLabelFechaDesde.setFont(new java.awt.Font("Product Sans Infanity", 0, 18)); // NOI18N
        jLabelFechaDesde.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFechaDesde.setText("Fecha Desde:");
        jPanel3.add(jLabelFechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, -1, 20));

        jLabelReporte.setFont(new java.awt.Font("Product Sans Infanity", 1, 18)); // NOI18N
        jLabelReporte.setForeground(new java.awt.Color(0, 0, 0));
        jLabelReporte.setText("Reporte");
        jLabelReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelReporteMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 30, -1, 20));

        jLabelGenerar.setFont(new java.awt.Font("Product Sans Infanity", 1, 18)); // NOI18N
        jLabelGenerar.setForeground(new java.awt.Color(0, 0, 0));
        jLabelGenerar.setText("Generar");
        jLabelGenerar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelGenerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelGenerarMouseClicked(evt);
            }
        });
        jPanel3.add(jLabelGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, 20));

        datePickerFechaDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                datePickerFechaDesdeKeyTyped(evt);
            }
        });
        datePickerFechaDesde.addDateChangeListener(event -> {
            LocalDate nuevaFecha = event.getNewDate();
            if (nuevaFecha != null) {
                buscador();
                cargarDatosTabla();
                // Aquí hacés lo que quieras: actualizar filtros, cargar datos, etc.
            }
        });
        jPanel3.add(datePickerFechaDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, -1, -1));

        timePickerHoraDesde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timePickerHoraDesdeKeyTyped(evt);
            }
        });
        timePickerHoraDesde.addTimeChangeListener(event -> {
            LocalTime nuevaHora = event.getNewTime();
            if (nuevaHora != null) {
                buscador();
                cargarDatosTabla();

            }
        });
        jPanel3.add(timePickerHoraDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        datePickerFechaHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                datePickerFechaHastaKeyTyped(evt);
            }
        });
        datePickerFechaHasta.addDateChangeListener(event -> {
            LocalDate nuevaFecha = event.getNewDate();
            if (nuevaFecha != null) {
                buscador();
                cargarDatosTabla();

            }
        });
        jPanel3.add(datePickerFechaHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 40, -1, -1));

        timePickerHoraHasta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                timePickerHoraHastaKeyTyped(evt);
            }
        });
        timePickerHoraHasta.addTimeChangeListener(event -> {
            LocalTime nuevaHora = event.getNewTime();
            if (nuevaHora != null) {
                buscador();
                cargarDatosTabla();

            }
        });
        jPanel3.add(timePickerHoraHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 40, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 920, 70));

        jTableComandas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Folio", "Fecha", "Mesa", "Total", "Cliente", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTableComandas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 920, 370));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 920, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRegresarMouseClicked
        if (esAdmin) {
            control.mostrarPantallaMenuAdmin();
        }
        else{
            control.mostrarPantallaMenuMesero();
        }
        
        control.cerrarPantalla(this);
    }//GEN-LAST:event_jLabelRegresarMouseClicked

    private void jComboBoxEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxEstadoItemStateChanged
        buscador();
        cargarDatosTabla();
    }//GEN-LAST:event_jComboBoxEstadoItemStateChanged

    private void datePickerFechaDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerFechaDesdeKeyTyped

    }//GEN-LAST:event_datePickerFechaDesdeKeyTyped

    private void datePickerFechaHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_datePickerFechaHastaKeyTyped

    }//GEN-LAST:event_datePickerFechaHastaKeyTyped

    private void timePickerHoraDesdeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timePickerHoraDesdeKeyTyped

    }//GEN-LAST:event_timePickerHoraDesdeKeyTyped

    private void timePickerHoraHastaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timePickerHoraHastaKeyTyped

    }//GEN-LAST:event_timePickerHoraHastaKeyTyped

    private void jLabelIconPdfMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelIconPdfMouseClicked
        reportePDF();
    }//GEN-LAST:event_jLabelIconPdfMouseClicked

    private void jLabelGenerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelGenerarMouseClicked
        reportePDF();
    }//GEN-LAST:event_jLabelGenerarMouseClicked

    private void jLabelReporteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelReporteMouseClicked
        reportePDF();
    }//GEN-LAST:event_jLabelReporteMouseClicked

    
    
    public void cargarDatosTabla(){
        DefaultTableModel model = (DefaultTableModel) jTableComandas.getModel();
        model.setRowCount(0);
        
        for (Comanda comanda : comandasCargadas) {
            model.addRow(new Object[]{
                comanda.getId(),
                comanda.getFolio(),
                comanda.getFechaComanda(),
                comanda.getMesa(),
                comanda.getTotal(),
                comanda.getCliente(),
                comanda.getEstado()
            });
        }
        
        jTableComandas.setModel(model);
        jTableComandas.getColumnModel().getColumn(0).setMinWidth(0);
        jTableComandas.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableComandas.getColumnModel().getColumn(0).setWidth(0);
        
        
    }
    
    public void buscador(){
        Date fechaDesde = obtenerFechaDesde();
        Date fechaHasta = obtenerFechaHasta();
        
        EstadoComanda estado = obtenerEstado();
        
        try {
            comandasCargadas = comandaBO.buscadorComandas(estado, fechaDesde, fechaHasta);
        } catch (NegocioException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    public Date obtenerFechaDesde(){
        LocalDate fechaDesde = datePickerFechaDesde.getDate();
        LocalTime horaDesde = timePickerHoraDesde.getTime();
        
        if (horaDesde == null) {
            horaDesde = LocalTime.MIDNIGHT; // 00:00
        }
        
        LocalDateTime dateTimeDesde = null;
        if (fechaDesde != null) {
            dateTimeDesde = LocalDateTime.of(fechaDesde, horaDesde);
        }
        
        Date dateDesde = null;
        
        if (dateTimeDesde != null) {
            ZonedDateTime zdtDesde = dateTimeDesde.atZone(ZoneId.systemDefault());
            dateDesde = Date.from(zdtDesde.toInstant());
        }
        
        return dateDesde;
    }
    
    public Date obtenerFechaHasta(){
        LocalDate fechaHasta = datePickerFechaHasta.getDate();
        LocalTime horaHasta = timePickerHoraHasta.getTime();
        
        if (horaHasta == null) {
            horaHasta = LocalTime.MIDNIGHT; // 00:00
        }
        
        LocalDateTime dateTimeHasta = null;
        if (fechaHasta != null) {
            dateTimeHasta = LocalDateTime.of(fechaHasta, horaHasta);
        }
        
        Date dateHasta = null;
        
        if (dateTimeHasta != null) {
            ZonedDateTime zdtDesde = dateTimeHasta.atZone(ZoneId.systemDefault());
            dateHasta = Date.from(zdtDesde.toInstant());
        }
        
        return dateHasta;
    }
    
    public EstadoComanda obtenerEstado(){
        return (EstadoComanda) jComboBoxEstado.getSelectedItem();
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }
    
    
    public void reportePDF(){
        Connection conexion = null;
        try {
            conexion = ConexionConJDBC.obtenerConexion();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        Date fechaDesde = obtenerFechaDesde();
        Date fechaHasta = obtenerFechaHasta();    
        String estado = null;
        if(obtenerEstado() != null){
            estado = obtenerEstado().toString();
        }

        
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("Estado", estado);
        parametros.put("FechaDesde", fechaDesde);
        parametros.put("FechaHasta", fechaHasta);
        
        try {
            InputStream jasperStream = getClass().getClassLoader().getResourceAsStream("reportes/ReporteComandasConFiltro100.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperStream, parametros, conexion);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setVisible(true);

        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try {
            conexion.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaDesde;
    private com.github.lgooddatepicker.components.DatePicker datePickerFechaHasta;
    private javax.swing.JComboBox<EstadoComanda> jComboBoxEstado;
    private javax.swing.JLabel jLabelComandas;
    private javax.swing.JLabel jLabelEstado1;
    private javax.swing.JLabel jLabelFechaDesde;
    private javax.swing.JLabel jLabelFechaHasta;
    private javax.swing.JLabel jLabelGenerar;
    private javax.swing.JLabel jLabelHistorialComandas;
    private javax.swing.JLabel jLabelIconFiltro;
    private javax.swing.JLabel jLabelIconPdf;
    private javax.swing.JLabel jLabelRegresar;
    private javax.swing.JLabel jLabelReporte;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableComandas;
    private com.github.lgooddatepicker.components.TimePicker timePickerHoraDesde;
    private com.github.lgooddatepicker.components.TimePicker timePickerHoraHasta;
    // End of variables declaration//GEN-END:variables
}
