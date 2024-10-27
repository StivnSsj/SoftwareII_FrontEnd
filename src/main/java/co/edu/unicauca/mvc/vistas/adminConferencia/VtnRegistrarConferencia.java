package co.edu.unicauca.mvc.vistas.adminConferencia;

import co.edu.unicauca.mvc.controladores.ConferenciaServices;
import co.edu.unicauca.mvc.modelos.Conferencia;
import co.edu.unicauca.mvc.utilidades.Utilidades;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase VtnRegistrarConferencia
 * 
 * Esta clase representa la ventana para registrar una nueva conferencia en la aplicación de gestión de conferencias.
 * Permite al administrador ingresar información sobre la conferencia, como el nombre, las fechas y la ubicación.
 * Se utiliza la librería Swing para la creación de la interfaz gráfica de usuario.
 */

public class VtnRegistrarConferencia extends javax.swing.JFrame {
    // Servicio para almacenar la conferencia
    private ConferenciaServices objServicioAlmacenamiento;
    // Ventana para listar conferencias, utilizada para actualizar la vista después del registro
    private VtnListarConferencias objVtnListarConferencias;
    
    /**
     * Constructor de la clase VtnRegistrarConferencia.
     * Inicializa los componentes gráficos y establece el servicio de almacenamiento y la ventana de listado.
     * 
     * @param objServicioAlmacenamiento Servicio de almacenamiento de conferencias.
     * @param vtnListarConferencias Ventana que lista las conferencias registradas.
     */
    
    public VtnRegistrarConferencia(ConferenciaServices objServicioAlmacenamiento,
        VtnListarConferencias vtnListarConferencias) {
        initComponents();
        this.objServicioAlmacenamiento = objServicioAlmacenamiento;
        this.objVtnListarConferencias = vtnListarConferencias;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInferior = new javax.swing.JPanel();
        jPanelSuperior = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jLabelCosto = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        txtUbicacion = new javax.swing.JTextField();
        jDateFechaInicio = new com.toedter.calendar.JDateChooser();
        jDateFechaFin = new com.toedter.calendar.JDateChooser();
        jButtonRegistrar = new javax.swing.JButton();

        jPanelInferior.setPreferredSize(new java.awt.Dimension(415, 30));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 415, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        jPanelSuperior.setPreferredSize(new java.awt.Dimension(415, 30));

        jLabelTitulo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Registrar conferencia");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabelTitulo)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jLabelNombre.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelNombre.setText("Nombre:");

        jLabelFechaInicio.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelFechaInicio.setText("Fecha Inicio:");

        jLabelFechaFin.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelFechaFin.setText("Fecha Fin:");

        jLabelCosto.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabelCosto.setText("Ubicacion:");

        jDateFechaInicio.setForeground(new java.awt.Color(255, 255, 255));

        jDateFechaFin.setForeground(new java.awt.Color(255, 255, 255));

        jButtonRegistrar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/disquete (1).png"))); // NOI18N
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                        .addComponent(jButtonRegistrar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelCosto)
                            .addComponent(jLabelFechaFin)
                            .addComponent(jLabelFechaInicio)
                            .addComponent(jLabelNombre))
                        .addGap(45, 45, 45)
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelNombre)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelFechaInicio)
                            .addComponent(jDateFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(jLabelFechaFin))
                    .addComponent(jDateFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCosto)
                    .addComponent(txtUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrar)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

     /**
     * Maneja el evento de acción del botón "Registrar".
     * Recupera los datos ingresados por el usuario, crea un objeto Conferencia
     * y lo almacena utilizando el servicio correspondiente. Muestra un mensaje de
     * éxito o error según el resultado de la operación.
     * 
     * @param evt Evento de acción que ocurre cuando se hace clic en el botón "Registrar".
     */
    
    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        String nombre, ubicacion;
        Date fechaInicio, fechaFin;
        boolean bandera;
        // Recuperar los datos ingresados por el usuario
        nombre = this.jTextFieldNombre.getText();
        fechaInicio = this.jDateFechaInicio.getDate();
        fechaFin = this.jDateFechaFin.getDate();
        ubicacion = this.txtUbicacion.getText();
        // Crear un nuevo objeto Conferencia
        Conferencia objConferencia = new Conferencia();
        objConferencia.setNombre(nombre);
        objConferencia.setFechaInicio(fechaInicio);
        objConferencia.setFechaFin(fechaFin);
        objConferencia.setUbicacion(ubicacion);

        //bandera = this.objServicioAlmacenamiento.almacenarConferencia(objConferencia);

//        if (bandera) {
//            Utilidades.mensajeExito("El registro de la conferencia fue exitoso", "Registro exitoso");
//            objVtnListarConferencias.llenarTabla();
//            dispose();
//        } else {
//            Utilidades.mensajeError("El registro de la conferencia no se realizo", "Error en el registro");
//        }


    }//GEN-LAST:event_jButtonRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonRegistrar;
    private com.toedter.calendar.JDateChooser jDateFechaFin;
    private com.toedter.calendar.JDateChooser jDateFechaInicio;
    private javax.swing.JLabel jLabelCosto;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField txtUbicacion;
    // End of variables declaration//GEN-END:variables
}