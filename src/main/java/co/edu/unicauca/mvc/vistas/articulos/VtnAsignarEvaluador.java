package co.edu.unicauca.mvc.vistas.articulos;

import co.edu.unicauca.mvc.controladores.ArticuloServices;
import co.edu.unicauca.mvc.controladores.EvaluadorServicio;
import co.edu.unicauca.mvc.modelos.Evaluador;
import co.edu.unicauca.mvc.utilidades.Utilidades;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author SANTIAGO DORADO
 */

/**
 * Clase VtnAsignarEvaluador
 * 
 * Esta clase representa una ventana de la interfaz gráfica de usuario para asignar evaluadores a un artículo
 * en un sistema de gestión de conferencias.
 * 
 * Hereda de javax.swing.JFrame y utiliza los servicios de ArticuloServicio y EvaluadorServicio para manejar 
 * la lógica de negocio relacionada con los artículos y los evaluadores respectivamente.
 */

public class VtnAsignarEvaluador extends javax.swing.JFrame {

    private EvaluadorServicio objSEvaluador;
    private ArrayList<Evaluador> listEvaluadores;
    private ArticuloServices objSArticulo;
    private int idArticulo;
    private VtnListarArticulos objListarArticulo;

    /**
     * Constructor de la clase VtnAsignarEvaluador
     * 
     * @param objSArticulo Objeto del servicio de artículos para manejar la lógica relacionada con los artículos.
     * @param objSEvaluador Objeto del servicio de evaluadores para manejar la lógica relacionada con los evaluadores.
     * @param indice Índice del artículo al que se le asignarán evaluadores.
     */
    public VtnAsignarEvaluador(ArticuloServices objSArticulo, 
                                int idArticulo,
                                VtnListarArticulos objListarArticulo) {
        initComponents();
        this.objSArticulo = objSArticulo;
        this.idArticulo = idArticulo;
        this.objListarArticulo = objListarArticulo;
        //listEvaluadores = (ArrayList<Evaluador>) objSEvaluador.listarEvaluadores();
        llenarTabla();
    }
    /**
    * Obtiene la lista de evaluadores seleccionados en la tabla.
    * 
    * @param tabla JTable que contiene los evaluadores.
    * @return Lista de evaluadores seleccionados.
    */
    public ArrayList<Evaluador> obtenerSeleccionados(JTable tabla) {
        ArrayList<Evaluador> evaluadoresSeleccionados = new ArrayList<>();
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        // Recorrer las filas para verificar cuáles están seleccionadas
        for (int i = 0; i < model.getRowCount(); i++) {
            Object isSelected = (Boolean) model.getValueAt(i, 4);

            if (isSelected != null && (Boolean) isSelected) {
                Evaluador evaluador = listEvaluadores.get(i);
                evaluadoresSeleccionados.add(evaluador);
            }
        }
        return evaluadoresSeleccionados;
    }
     
    /**
     * Limpia la tabla de evaluadores.
     */

    public void limpiarTabla() {
        DefaultTableModel modelo = (DefaultTableModel) this.jTableEvaluadores.getModel();
        int filas = this.jTableEvaluadores.getRowCount();
        for (int i = 0; filas > i; i++) {
            modelo.removeRow(0);
        }
    }
    /**
     * Llena la tabla con la lista de evaluadores disponibles.
     */
    public void llenarTabla() {
        DefaultTableModel model = (DefaultTableModel) this.jTableEvaluadores.getModel();
        limpiarTabla();
        //ArrayList<Evaluador> listEvaluadores = (ArrayList<Evaluador>) this.objSEvaluador.listarEvaluadores();

        for (int i = 0; i < listEvaluadores.size(); i++) {
            Object[] fila = {
                listEvaluadores.get(i).getId(),
                listEvaluadores.get(i).getNombre(),
                listEvaluadores.get(i).getApellido(),
                listEvaluadores.get(i).getCorreo()
            };
            model.addRow(fila);
        }

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEvaluadores = new javax.swing.JTable();
        lblArticulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        btnAsignar = new javax.swing.JButton();
        jPanelInferior = new javax.swing.JPanel();

        jPanelSuperior.setPreferredSize(new java.awt.Dimension(205, 30));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel1.setText("Asignar evaluador");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(219, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(199, 199, 199))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel2.setText("Evaluadores");

        jTableEvaluadores.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableEvaluadores.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jTableEvaluadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "CORREO", "SELECCIONAR"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEvaluadores.setToolTipText("");
        jTableEvaluadores.setShowGrid(true);
        jTableEvaluadores.setSurrendersFocusOnKeystroke(true);
        jScrollPane2.setViewportView(jTableEvaluadores);

        lblArticulo.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        lblArticulo.setText("nombreArticulo");

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        jLabel3.setText("Articulo:");

        lblId.setText("id");

        btnAsignar.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        btnAsignar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/asignar.png"))); // NOI18N
        btnAsignar.setText("Asignar");
        btnAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAsignar)
                    .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelCentralLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblId))
                        .addGroup(jPanelCentralLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblArticulo))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArticulo)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAsignar)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        jPanelInferior.setPreferredSize(new java.awt.Dimension(531, 30));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Acción a realizar cuando se presiona el botón Asignar.
     * Verifica los evaluadores seleccionados y los asigna al artículo.
     * 
     * @param evt Evento de acción.
     */
    private void btnAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarActionPerformed
        boolean bandera;
        ArrayList<Evaluador> listEvaluadores = obtenerSeleccionados(jTableEvaluadores);
        
        bandera = this.objSArticulo.asignarEvaluador(this.idArticulo, listEvaluadores);
       
        if (bandera == true) {
            Utilidades.mensajeExito("Asignación exitosa", "Registro exitoso");
            objSArticulo.cambiarEstado(idArticulo, 1);
            objListarArticulo.llenarTabla();
            dispose();
        } else {
            Utilidades.mensajeError("Asignación no almacenada", "Error al almacenar el evaluador");
        }
    }//GEN-LAST:event_btnAsignarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEvaluadores;
    public javax.swing.JLabel lblArticulo;
    public javax.swing.JLabel lblId;
    // End of variables declaration//GEN-END:variables
}
