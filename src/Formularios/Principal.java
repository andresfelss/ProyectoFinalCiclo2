
package Formularios;

import javax.swing.JInternalFrame;


public class Principal extends javax.swing.JFrame {

    
    public Principal() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        ventanaPrincipal = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuArchivo = new javax.swing.JMenu();
        jMenuItemAcercaDe = new javax.swing.JMenuItem();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuProductos = new javax.swing.JMenu();
        jMenuItemCrearProd = new javax.swing.JMenuItem();
        jMenuItemListarProd = new javax.swing.JMenuItem();
        jMenuItemAdministraProd = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto");

        ventanaPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout ventanaPrincipalLayout = new javax.swing.GroupLayout(ventanaPrincipal);
        ventanaPrincipal.setLayout(ventanaPrincipalLayout);
        ventanaPrincipalLayout.setHorizontalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        ventanaPrincipalLayout.setVerticalGroup(
            ventanaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 437, Short.MAX_VALUE)
        );

        jMenuArchivo.setText("Archivo");
        jMenuArchivo.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jMenuItemAcercaDe.setText("Acerca de");
        jMenuItemAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAcercaDeActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemAcercaDe);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenuArchivo.add(jMenuItemSalir);

        jMenuBar1.add(jMenuArchivo);

        jMenuProductos.setText("Productos");
        jMenuProductos.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N

        jMenuItemCrearProd.setText("Crear");
        jMenuProductos.add(jMenuItemCrearProd);

        jMenuItemListarProd.setText("Listar");
        jMenuItemListarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemListarProdActionPerformed(evt);
            }
        });
        jMenuProductos.add(jMenuItemListarProd);

        jMenuItemAdministraProd.setText("Administrar");
        jMenuProductos.add(jMenuItemAdministraProd);

        jMenuBar1.add(jMenuProductos);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ventanaPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void agregarVentanaPanel(JInternalFrame ventana){
        if (ventanaPrincipal.getComponentCount()>0) {
            ventanaPrincipal.removeAll();  // Si tiene elementos el panel que los remueva
        }
        ventanaPrincipal.add(ventana);             
    }
    
    private void jMenuItemAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAcercaDeActionPerformed
        // TODO add your handling code here:
        AcercaDe ventanaAcercaDe;
        
        ventanaAcercaDe = new AcercaDe();
        
        agregarVentanaPanel(ventanaAcercaDe);
        ventanaAcercaDe.show();
    }//GEN-LAST:event_jMenuItemAcercaDeActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemListarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemListarProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItemListarProdActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenuArchivo;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAcercaDe;
    private javax.swing.JMenuItem jMenuItemAdministraProd;
    private javax.swing.JMenuItem jMenuItemCrearProd;
    private javax.swing.JMenuItem jMenuItemListarProd;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenu jMenuProductos;
    private javax.swing.JPanel ventanaPrincipal;
    // End of variables declaration//GEN-END:variables
}
