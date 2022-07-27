
package Formularios;

import dao.DaoProducto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelos.Producto;

public class AdministrarProductos extends javax.swing.JInternalFrame {

    private final String columns[] = {"Codigo", "Nombre" , "Referencia" , "Temperatura", "Valor Base"};
    private final DefaultTableModel miTablita = new DefaultTableModel(columns,0);
    
    // ==================== Constructor ========================================
    public AdministrarProductos() {
        initComponents();
        cargarDatosTabla();
    }
    
    // ============= Metodo para Limpioar cajas ================================
    private void limpiarCajas(){
        TextCodigoAdmin.setText("");
        TextNombreAdmin.setText("");
        TextRefAdmin.setText("");
        TextTempAdmin.setText("");
        TextValorlBaseAdmin.setText("");
    }
    
    // ============= Metodo para cargar Registros en Tabla  ====================
    private void cargarDatosTabla(){
        // definimos variables
        List<Producto> arregloProductos;
        DaoProducto objDaoProductos;
        
        // Creamoslos objetos
        objDaoProductos = new DaoProducto();
        // llamamos al metodo consultar
        arregloProductos = objDaoProductos.consultar();
        
        arregloProductos.forEach(producto -> {
           Object[] fila = new Object[5];
           fila[0] = producto.getCodProducto();
           fila[1] = producto.getNombre();
           fila[2] = producto.getId();
           fila[3] = producto.getTemperatura();
           fila[4] = producto.getValorBase();
           miTablita.addRow(fila);        
        });
        tablaProductosAdmin.setModel(miTablita);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextRefAdmin1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        PanelAdministrar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TextCodigoAdmin = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TextRefAdmin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TextValorlBaseAdmin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TextTempAdmin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        TextNombreAdmin = new javax.swing.JTextField();
        BtnActualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaProductosAdmin = new javax.swing.JTable();
        BtnEliminar = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel2.setText("CODIGO:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel4.setText("REFERENCIA");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(734, 441));

        PanelAdministrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel1.setText("CODIGO:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel3.setText("REFERENCIA:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel5.setText("VALOR BASE:");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel6.setText("TEMPERATURA");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 16)); // NOI18N
        jLabel7.setText("NOMBRE:");

        BtnActualizar.setText("ACTUALIZAR");

        tablaProductosAdmin.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaProductosAdmin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaProductosAdminMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaProductosAdmin);

        BtnEliminar.setText("ELIMINAR");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAdministrarLayout = new javax.swing.GroupLayout(PanelAdministrar);
        PanelAdministrar.setLayout(PanelAdministrarLayout);
        PanelAdministrarLayout.setHorizontalGroup(
            PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(PanelAdministrarLayout.createSequentialGroup()
                .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAdministrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelAdministrarLayout.createSequentialGroup()
                                .addComponent(TextCodigoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextRefAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TextNombreAdmin)))
                    .addGroup(PanelAdministrarLayout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(TextTempAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TextValorlBaseAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelAdministrarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PanelAdministrarLayout.setVerticalGroup(
            PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAdministrarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TextCodigoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TextRefAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TextValorlBaseAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(TextTempAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(TextNombreAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelAdministrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAdministrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAdministrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    // ============= Evento Click en una fila de la tabla  =====================
    
    private void tablaProductosAdminMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaProductosAdminMouseClicked
        
        // Obtengo el indice de la fila seleccionada por el Mouse
        Integer filaSeleccionada = tablaProductosAdmin.getSelectedRow();
        Long codProducto;
        String nombreProducto,referenciaProducto;
        Double tempProducto,valorBaseProducto;
        
        // Obtengo los valores con getValueAt Y LO seteo a Text field correspondiente
        codProducto = Long.parseLong(miTablita.getValueAt(filaSeleccionada, 0).toString());
        TextCodigoAdmin.setText(codProducto.toString());
        
        nombreProducto = miTablita.getValueAt(filaSeleccionada,1).toString();
        TextNombreAdmin.setText(nombreProducto);
        
        referenciaProducto = miTablita.getValueAt(filaSeleccionada,2).toString();
        TextRefAdmin.setText(referenciaProducto);
        
        tempProducto = Double.parseDouble(miTablita.getValueAt(filaSeleccionada, 3).toString());
        TextTempAdmin.setText(tempProducto.toString());
        
        valorBaseProducto = Double.parseDouble(miTablita.getValueAt(filaSeleccionada, 4).toString());
        TextValorlBaseAdmin.setText(valorBaseProducto.toString());
        
        
    }//GEN-LAST:event_tablaProductosAdminMouseClicked
    
    private void limpiarTabla(){
        for (int i = 0; i < tablaProductosAdmin.getRowCount(); i++) {
            miTablita.removeRow(i);
            i-=1;
        }
    }
    
    // ======================== EVvento Eliminar ===============================
    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // Definimos las variables
        Long codProducto;
        DaoProducto objDaoProducto;
        Producto objProducto;
        
        // Capturamos valores de las cajas
        codProducto = Long.parseLong(TextCodigoAdmin.getText());
        
        // Creacion de objetos
        objDaoProducto = new DaoProducto();
        objProducto = new Producto();
        
        objProducto.setCodProducto(codProducto);
        
        // LLamos el DAO Elimanr
        if (objDaoProducto.borrar(objProducto)) {
            JOptionPane.showMessageDialog(PanelAdministrar, "Registro Borrado Correctamente");
            limpiarTabla();
            cargarDatosTabla();
            limpiarCajas();
            
        } else {
            JOptionPane.showMessageDialog(PanelAdministrar, "Ocurrio un error");
        }
        
        
        
        
    }//GEN-LAST:event_BtnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JPanel PanelAdministrar;
    private javax.swing.JTextField TextCodigoAdmin;
    private javax.swing.JTextField TextNombreAdmin;
    private javax.swing.JTextField TextRefAdmin;
    private javax.swing.JTextField TextRefAdmin1;
    private javax.swing.JTextField TextTempAdmin;
    private javax.swing.JTextField TextValorlBaseAdmin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaProductosAdmin;
    // End of variables declaration//GEN-END:variables
}
