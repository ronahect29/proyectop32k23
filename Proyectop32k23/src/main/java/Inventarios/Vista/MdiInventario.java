/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Vista;

import Seguridad.Vista.*;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class MdiInventario extends javax.swing.JFrame {

    /**
     * Creates new form MdiGeneral
     */
    public MdiInventario() {
        initComponents();
        setLocationRelativeTo(null);
        this.setExtendedState(MdiInventario.MAXIMIZED_BOTH);
        this.setTitle("MDI Inventarios");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
  
        ImageIcon imagen = new ImageIcon(getClass().getResource("/Imagenes/SistemaInv.png"));
        Icon fondo = new ImageIcon(imagen.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
        lbl.setIcon(fondo);
        this.repaint();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lbl = new javax.swing.JLabel();
        mnuGeneral = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        mnuSalirSistema = new javax.swing.JCheckBoxMenuItem();
        mnuCatalogos = new javax.swing.JMenu();
        mnuCatalogosMantenimientos = new javax.swing.JMenu();
        mantenimientoLineas = new javax.swing.JMenuItem();
        mantenimientoMarcas = new javax.swing.JCheckBoxMenuItem();
        mantenimientoProductos = new javax.swing.JCheckBoxMenuItem();
        mantenimientoBodegas = new javax.swing.JCheckBoxMenuItem();
        mantenimientoExistencias = new javax.swing.JCheckBoxMenuItem();
        mantenimientoMovimientos = new javax.swing.JCheckBoxMenuItem();
        mnuProcesos = new javax.swing.JMenu();
        mnuConsultas = new javax.swing.JMenu();
        consultaBitacora = new javax.swing.JCheckBoxMenuItem();
        mnuReportes = new javax.swing.JMenu();
        mnuAyudas = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenuItem4.setText("jMenuItem4");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane1.setLayer(lbl, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mnuGeneral.setBackground(new java.awt.Color(153, 255, 153));

        mnuArchivo.setText("Archivo");
        mnuArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuArchivoActionPerformed(evt);
            }
        });

        mnuSalirSistema.setSelected(true);
        mnuSalirSistema.setText("Salir del Sistema");
        mnuSalirSistema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirSistemaActionPerformed(evt);
            }
        });
        mnuArchivo.add(mnuSalirSistema);

        mnuGeneral.add(mnuArchivo);

        mnuCatalogos.setText("Catalogos");

        mnuCatalogosMantenimientos.setText("Mantenimientos");
        mnuCatalogosMantenimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuCatalogosMantenimientosActionPerformed(evt);
            }
        });

        mantenimientoLineas.setText("Mantenimiento Lineas");
        mantenimientoLineas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoLineasActionPerformed(evt);
            }
        });
        mnuCatalogosMantenimientos.add(mantenimientoLineas);

        mantenimientoMarcas.setSelected(true);
        mantenimientoMarcas.setText("Mantenimiento Marcas");
        mantenimientoMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoMarcasActionPerformed(evt);
            }
        });
        mnuCatalogosMantenimientos.add(mantenimientoMarcas);

        mantenimientoProductos.setSelected(true);
        mantenimientoProductos.setText("Mantenimiento Productos");
        mantenimientoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoProductosActionPerformed(evt);
            }
        });
        mnuCatalogosMantenimientos.add(mantenimientoProductos);

        mantenimientoBodegas.setSelected(true);
        mantenimientoBodegas.setText("Mantenimiento Bodegas");
        mantenimientoBodegas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoBodegasActionPerformed(evt);
            }
        });
        mnuCatalogosMantenimientos.add(mantenimientoBodegas);

        mantenimientoExistencias.setSelected(true);
        mantenimientoExistencias.setText("Mantenimiento Existencias");
        mantenimientoExistencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoExistenciasActionPerformed(evt);
            }
        });
        mnuCatalogosMantenimientos.add(mantenimientoExistencias);

        mantenimientoMovimientos.setSelected(true);
        mantenimientoMovimientos.setText("Mantenimiento Movimientos");
        mantenimientoMovimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mantenimientoMovimientosActionPerformed(evt);
            }
        });
        mnuCatalogosMantenimientos.add(mantenimientoMovimientos);

        mnuCatalogos.add(mnuCatalogosMantenimientos);

        mnuGeneral.add(mnuCatalogos);

        mnuProcesos.setText("Procesos");
        mnuGeneral.add(mnuProcesos);

        mnuConsultas.setText("Consultas");
        mnuConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuConsultasActionPerformed(evt);
            }
        });

        consultaBitacora.setSelected(true);
        consultaBitacora.setText("Consulta de Bitacora");
        consultaBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultaBitacoraActionPerformed(evt);
            }
        });
        mnuConsultas.add(consultaBitacora);

        mnuGeneral.add(mnuConsultas);

        mnuReportes.setText("Reportes");
        mnuGeneral.add(mnuReportes);

        mnuAyudas.setText("Ayudas");
        mnuGeneral.add(mnuAyudas);

        setJMenuBar(mnuGeneral);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void mnuCatalogosMantenimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuCatalogosMantenimientosActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mnuCatalogosMantenimientosActionPerformed

    private void mantenimientoLineasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoLineasActionPerformed
        // TODO add your handling code here:
        frmLineas ventana = new frmLineas();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);
    }//GEN-LAST:event_mantenimientoLineasActionPerformed

    private void mnuArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuArchivoActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_mnuArchivoActionPerformed

    private void mnuSalirSistemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirSistemaActionPerformed
        // TODO add your handling code here:
                /*===== OPERACIÓN CERRAR SESIÓN ====
          Variable entera respuesta_cs*/

        int respuesta_cs = JOptionPane.showConfirmDialog(this, "¿Desea Cerrar Sesión?", "Cerrar Sesión",            JOptionPane.YES_NO_OPTION);

        if (respuesta_cs == 0) {
            this.dispose();
        }        
    }//GEN-LAST:event_mnuSalirSistemaActionPerformed

    private void mantenimientoMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoMarcasActionPerformed
        // TODO add your handling code here:
        frmMarcas ventana = new frmMarcas();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);
    }//GEN-LAST:event_mantenimientoMarcasActionPerformed

    private void mantenimientoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoProductosActionPerformed
        // TODO add your handling code here:
        frmProductos ventana = new frmProductos();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);   
    }//GEN-LAST:event_mantenimientoProductosActionPerformed

    private void mantenimientoBodegasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoBodegasActionPerformed
        // TODO add your handling code here:
        frmBodegas ventana = new frmBodegas();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);       
    }//GEN-LAST:event_mantenimientoBodegasActionPerformed

    private void mnuConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuConsultasActionPerformed
        // TODO add your handling code here:
         frmMantenimientoBitacora ventana = new frmMantenimientoBitacora();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);
    }//GEN-LAST:event_mnuConsultasActionPerformed

    private void consultaBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultaBitacoraActionPerformed
        // TODO add your handling code here:
         frmMantenimientoBitacora ventana = new frmMantenimientoBitacora();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);
    }//GEN-LAST:event_consultaBitacoraActionPerformed

    private void mantenimientoExistenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoExistenciasActionPerformed
        // TODO add your handling code here:
        frmExistencias ventana = new frmExistencias();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);
    }//GEN-LAST:event_mantenimientoExistenciasActionPerformed

    private void mantenimientoMovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mantenimientoMovimientosActionPerformed
        // TODO add your handling code here:
        frmMovimientos ventana = new frmMovimientos();
        jDesktopPane1.add(ventana);
        Dimension desktopSize = jDesktopPane1.getSize();
        Dimension FrameSize = ventana.getSize();
        ventana.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.             height) / 2);
    }//GEN-LAST:event_mantenimientoMovimientosActionPerformed

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
            java.util.logging.Logger.getLogger(MdiInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MdiInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MdiInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MdiInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MdiInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem consultaBitacora;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JLabel lbl;
    private javax.swing.JCheckBoxMenuItem mantenimientoBodegas;
    private javax.swing.JCheckBoxMenuItem mantenimientoExistencias;
    private javax.swing.JMenuItem mantenimientoLineas;
    private javax.swing.JCheckBoxMenuItem mantenimientoMarcas;
    private javax.swing.JCheckBoxMenuItem mantenimientoMovimientos;
    private javax.swing.JCheckBoxMenuItem mantenimientoProductos;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyudas;
    private javax.swing.JMenu mnuCatalogos;
    private javax.swing.JMenu mnuCatalogosMantenimientos;
    private javax.swing.JMenu mnuConsultas;
    private javax.swing.JMenuBar mnuGeneral;
    private javax.swing.JMenu mnuProcesos;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JCheckBoxMenuItem mnuSalirSistema;
    // End of variables declaration//GEN-END:variables
}
