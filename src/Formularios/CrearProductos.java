
package Formularios;

import dao.DaoProducto;
import javax.swing.JOptionPane;
import modelos.Producto;


public class CrearProductos extends javax.swing.JInternalFrame {

    
    public CrearProductos() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabProducto1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelCabProductoCrear = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelBodyProductoCrear = new javax.swing.JPanel();
        lblNombreProducto = new javax.swing.JLabel();
        lblNombreProducto1 = new javax.swing.JLabel();
        TextNombreProducto = new javax.swing.JTextField();
        TextTempProducto = new javax.swing.JTextField();
        lblNombreProducto2 = new javax.swing.JLabel();
        lblNombreProducto3 = new javax.swing.JLabel();
        TextCodigoProducto1 = new javax.swing.JTextField();
        TextValorBaseProducto = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnCrearProducto = new javax.swing.JButton();
        btnCancelarCrear = new javax.swing.JButton();

        panelCabProducto1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelCabProducto1Layout = new javax.swing.GroupLayout(panelCabProducto1);
        panelCabProducto1.setLayout(panelCabProducto1Layout);
        panelCabProducto1Layout.setHorizontalGroup(
            panelCabProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        panelCabProducto1Layout.setVerticalGroup(
            panelCabProducto1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 69, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setClosable(true);
        setPreferredSize(new java.awt.Dimension(734, 441));

        panelCabProductoCrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crear Producto");

        javax.swing.GroupLayout panelCabProductoCrearLayout = new javax.swing.GroupLayout(panelCabProductoCrear);
        panelCabProductoCrear.setLayout(panelCabProductoCrearLayout);
        panelCabProductoCrearLayout.setHorizontalGroup(
            panelCabProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabProductoCrearLayout.createSequentialGroup()
                .addContainerGap(196, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(176, 176, 176))
        );
        panelCabProductoCrearLayout.setVerticalGroup(
            panelCabProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabProductoCrearLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        panelBodyProductoCrear.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblNombreProducto.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblNombreProducto.setText("TEMPERATURA:");

        lblNombreProducto1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblNombreProducto1.setText("NOMBRE: ");

        TextNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNombreProductoActionPerformed(evt);
            }
        });

        TextTempProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextTempProductoActionPerformed(evt);
            }
        });

        lblNombreProducto2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblNombreProducto2.setText("REFERNCIA:");

        lblNombreProducto3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        lblNombreProducto3.setText("VALOR BASE:");

        TextCodigoProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextCodigoProducto1ActionPerformed(evt);
            }
        });

        TextValorBaseProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextValorBaseProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBodyProductoCrearLayout = new javax.swing.GroupLayout(panelBodyProductoCrear);
        panelBodyProductoCrear.setLayout(panelBodyProductoCrearLayout);
        panelBodyProductoCrearLayout.setHorizontalGroup(
            panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyProductoCrearLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBodyProductoCrearLayout.createSequentialGroup()
                        .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreProducto2)
                            .addComponent(lblNombreProducto1))
                        .addGap(39, 39, 39)
                        .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TextCodigoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelBodyProductoCrearLayout.createSequentialGroup()
                        .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreProducto)
                            .addComponent(lblNombreProducto3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextTempProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TextValorBaseProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBodyProductoCrearLayout.setVerticalGroup(
            panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBodyProductoCrearLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombreProducto1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreProducto2)
                    .addComponent(TextCodigoProducto1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreProducto)
                    .addComponent(TextTempProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelBodyProductoCrearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreProducto3)
                    .addComponent(TextValorBaseProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCrearProducto.setText("CREAR");
        btnCrearProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearProductoActionPerformed(evt);
            }
        });

        btnCancelarCrear.setText("CANCELAR");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCrearProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarCrear)
                .addGap(239, 239, 239))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearProducto)
                    .addComponent(btnCancelarCrear))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCabProductoCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panelBodyProductoCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCabProductoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBodyProductoCrear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarCajas(){
        TextCodigoProducto1.setText("");
        TextNombreProducto.setText("");
        TextTempProducto.setText("");
        TextValorBaseProducto.setText("");
        
        TextNombreProducto.requestFocus();
        
    }
    
    
    private void TextNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNombreProductoActionPerformed

    private void TextTempProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextTempProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextTempProductoActionPerformed

    private void TextCodigoProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextCodigoProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextCodigoProducto1ActionPerformed

    private void TextValorBaseProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextValorBaseProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextValorBaseProductoActionPerformed

    private void btnCrearProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearProductoActionPerformed
        // TODO add your handling code here:
        // Necesitamos recoger los datos - DEfinicion de variables
        String cajaNombre,cajaReferencia;
        Double cajaTemperatura, cajaValorBase;
        
        // Instanciamos los clases DAO y nuestro modelo Producto
        DaoProducto objDaoProducto;
        Producto objProducto;
        
        // Capturamos la informacion de las cajas
        cajaNombre = TextNombreProducto.getText();
        cajaReferencia = TextCodigoProducto1.getText();
        cajaTemperatura = Double.parseDouble(TextTempProducto.getText());
        cajaValorBase = Double.parseDouble(TextValorBaseProducto.getText());
        
        if (cajaNombre.isEmpty() || cajaReferencia.isEmpty() || cajaTemperatura == null || cajaValorBase == null) {
            JOptionPane.showMessageDialog(panelBodyProductoCrear, "Todos los valores son obligatorios");
        }else{
            // Creacion de objetos
            objDaoProducto = new DaoProducto();
            objProducto = new Producto();
            
            // Pasamos los atributos a Producto
            objProducto.setNombre(cajaNombre);
            objProducto.setId(cajaReferencia);
            objProducto.setTemperatura(cajaTemperatura);
            objProducto.setValorBase(cajaValorBase);
            
            if (objDaoProducto.agregar(objProducto)) { // Recordemos que agregar retorna un booleano si es TRUE se agrego correctamente
                JOptionPane.showMessageDialog(panelBodyProductoCrear, "Registro Agregado Correctamente");
                limpiarCajas();
            } else {
                JOptionPane.showMessageDialog(panelBodyProductoCrear, "Error: El registro no pudo ser Agregado");
                limpiarCajas();
            }
                   
        }
        
        
    }//GEN-LAST:event_btnCrearProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextCodigoProducto1;
    private javax.swing.JTextField TextNombreProducto;
    private javax.swing.JTextField TextTempProducto;
    private javax.swing.JTextField TextValorBaseProducto;
    private javax.swing.JButton btnCancelarCrear;
    private javax.swing.JButton btnCrearProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblNombreProducto1;
    private javax.swing.JLabel lblNombreProducto2;
    private javax.swing.JLabel lblNombreProducto3;
    private javax.swing.JPanel panelBodyProductoCrear;
    private javax.swing.JPanel panelCabProducto1;
    private javax.swing.JPanel panelCabProductoCrear;
    // End of variables declaration//GEN-END:variables
}
