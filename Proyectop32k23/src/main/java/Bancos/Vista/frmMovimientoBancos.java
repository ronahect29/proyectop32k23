/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Vista;

import Bancos.Controlador.clsBancoExterno;
import Bancos.Controlador.clsMovimientoDetallesBancos;
import Bancos.Controlador.clsTipoMoneda;
import Bancos.Controlador.clsConceptosBancos;
import Bancos.Controlador.clsCuentaEmpresa;
import Bancos.Controlador.clsCuentasBancos;
import Bancos.Controlador.clsMovimientosEncabezadoBancos;
import Bancos.Controlador.clsTipoMovimientoBancos;
import Seguridad.Controlador.clsBitacora;
import Seguridad.Controlador.clsUsuarioConectado;
import java.awt.Component;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author visitante
 */
public class frmMovimientoBancos extends javax.swing.JInternalFrame {
int codigoAplicacion= 5002;

    public void llenadoDeCombos() {
        /*EmpleadoDAO empleadoDAO = new EmpleadoDAO();
        List<Empleado> empleados = empleadoDAO.select();
        cbox_empleado.addItem("Seleccione una opción");
        for (int i = 0; i < empleados.size(); i++) {
            cbox_empleado.addItem(empleados.get(i).getNombreEmpleado());
        } */
    }
public void llenadoDeCombo2() {
    clsTipoMoneda TM = new clsTipoMoneda();
    List<clsTipoMoneda> listaTipoMonedas = TM.getListadoMonedas();
    cbMovimientoMoneda.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    for (int i = 0; i < listaTipoMonedas.size(); i++) {
        cbMovimientoMoneda.addItem(String.valueOf(listaTipoMonedas.get(i).getTipModId()));
    }
}

public void llenadoDeCombo3() {
    clsConceptosBancos Concep = new clsConceptosBancos();
    List<clsConceptosBancos> listaConceptoss = Concep.getListadoConceptos();
    cbConcepto.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    for (int i = 0; i < listaConceptoss.size(); i++) {
        cbConcepto.addItem(String.valueOf(listaConceptoss.get(i).getIdConcepto()));
    }
}

public void llenadoDeCombo4() {
    clsMovimientosEncabezadoBancos movEncabezado = new clsMovimientosEncabezadoBancos();
    List<clsMovimientosEncabezadoBancos> listaMovEncabezado = movEncabezado.getListadoMovEncabezado();
    cbMovimientoEncabezado.setAlignmentX(Component.CENTER_ALIGNMENT);
   
    for (int i = 0; i < listaMovEncabezado.size(); i++) {
        cbMovimientoEncabezado.addItem(String.valueOf(listaMovEncabezado.get(i).getMovId()));
    }
}

public void llenadoDeComboA() {
        clsBancoExterno banco = new clsBancoExterno();
        List<clsBancoExterno> listadoBancosExternos = banco.getListadoBancosExternos();
        cbCodigo.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listadoBancosExternos.size(); i++) {
            cbCodigo.addItem(String.valueOf(listadoBancosExternos.get(i).getCodigoBanco()));
        }
    }
    public void llenadoDeComboB() {
        clsCuentasBancos cuentasB = new clsCuentasBancos();
        List<clsCuentasBancos> listaCuentasbancos = cuentasB.getListadoCuentas();
        cbIdCuenta.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listaCuentasbancos.size(); i++) {
            cbIdCuenta.addItem(String.valueOf(listaCuentasbancos.get(i).getIdCuenta()));
        }
    }
    public void llenadoDeComboC() {
        clsTipoMovimientoBancos TipoMB = new clsTipoMovimientoBancos();
        List<clsTipoMovimientoBancos> listaclsTipoMovimientoBancos = TipoMB.getListadoTipoMovimiento();
        cbTipMov.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listaclsTipoMovimientoBancos.size(); i++) {
            cbTipMov.addItem(String.valueOf(listaclsTipoMovimientoBancos.get(i).getTipoMovimientoId()));
        }
    }
    public void llenadoDeComboD() {
        clsCuentaEmpresa TipoMB = new clsCuentaEmpresa();
        List<clsCuentaEmpresa> listaclsCuentaEmpresa = TipoMB.getListadoCuentaEmpresas();
        cbIdCuenEm.setAlignmentX(Component.CENTER_ALIGNMENT);
        for (int i = 0; i < listaclsCuentaEmpresa.size(); i++) {
            cbIdCuenEm.addItem(String.valueOf(listaclsCuentaEmpresa.get(i).getIdCuentaEm()));
        }
    }


    public void llenadoDeTablas() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id Movimiento Detalles");
        modelo.addColumn("Id Movimiento Encabezado");
        modelo.addColumn("Costo");
        modelo.addColumn("Concepto");
        modelo.addColumn("Saldo");
        modelo.addColumn("Id Movimiento Moneda");
        clsMovimientoDetallesBancos tipou = new clsMovimientoDetallesBancos();
        //VendedorDAO vendedorDAO = new VendedorDAO();
        List<clsMovimientoDetallesBancos> listaTipoBancos = tipou.getListadoMovimiento();
        tablaUsuarios.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < listaTipoBancos .size(); i++) {
   dato[0] = Integer.toString(listaTipoBancos.get(i).getIdMovimientoDetalles());
        dato[1] = Integer.toString(listaTipoBancos.get(i).getIdMovimiento());
        dato[2] = Float.toString(listaTipoBancos.get(i).getMovimientoCosto());
        dato[3] = Integer.toString(listaTipoBancos.get(i).getIdConcepto());
        dato[4] = Float.toString(listaTipoBancos.get(i).getMovimientoSaldo());
        dato[5] = Integer.toString(listaTipoBancos.get(i).getIdTipoMovimiento());
            modelo.addRow(dato);
        }       
    }
    
        public void llenadoDeTablas2() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("codigo Bancario");
        modelo.addColumn("ID cuenta");
        modelo.addColumn("Tipo Movimiento");
        modelo.addColumn("Fecha");
        modelo.addColumn("ID cuenta empresa");

        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        //VendedorDAO vendedorDAO = new VendedorDAO();

        List<clsMovimientosEncabezadoBancos> listadoMovEncabezado = encabezado.getListadoMovEncabezado();
        tablaMovimientoEncavezado.setModel(modelo);
        String[] dato = new String[6];
        for (int i = 0; i < listadoMovEncabezado.size(); i++) {
            dato[0] = Integer.toString(listadoMovEncabezado.get(i).getMovId());
            dato[1] = Integer.toString(listadoMovEncabezado.get(i).getCodBanco());
            dato[2] = Integer.toString(listadoMovEncabezado.get(i).getCueId());
            dato[3] = Integer.toString(listadoMovEncabezado.get(i).getTipMovId());
            dato[4] = listadoMovEncabezado .get(i).getMovFecha();
            dato[5] = Integer.toString(listadoMovEncabezado.get(i).getCueEmId());
            modelo.addRow(dato);
        }       
    }


    public frmMovimientoBancos() {
        initComponents();
        llenadoDeTablas();
        llenadoDeCombos();
        llenadoDeCombo2();
        llenadoDeCombo3();
        llenadoDeCombo4();
        llenadoDeComboA();
        llenadoDeComboB();
        llenadoDeComboC();
        llenadoDeComboD();
        llenadoDeTablas2();
        
    }
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb2 = new javax.swing.JLabel();
        lbusu = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        label1 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        label3 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        txtCosto = new javax.swing.JTextField();
        label5 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        label4 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        label6 = new javax.swing.JLabel();
        txtIdMovDetalles = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        label7 = new javax.swing.JLabel();
        label8 = new javax.swing.JLabel();
        label9 = new javax.swing.JLabel();
        txtbuscado = new javax.swing.JTextField();
        cbMovimientoEncabezado = new javax.swing.JComboBox<>();
        cbConcepto = new javax.swing.JComboBox<>();
        cbMovimientoMoneda = new javax.swing.JComboBox<>();
        label13 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        label14 = new javax.swing.JLabel();
        cbCodigo = new javax.swing.JComboBox<>();
        label15 = new javax.swing.JLabel();
        label16 = new javax.swing.JLabel();
        cbTipMov = new javax.swing.JComboBox<>();
        cbIdCuenta = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        label17 = new javax.swing.JLabel();
        label18 = new javax.swing.JLabel();
        cbIdCuenEm = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaMovimientoEncavezado = new javax.swing.JTable();
        txtbuscadoE = new javax.swing.JTextField();
        btnLimpiar1 = new javax.swing.JButton();
        btnEliminar1 = new javax.swing.JButton();
        btnRegistrar1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        label10 = new javax.swing.JLabel();
        btnModificar1 = new javax.swing.JButton();
        btnActualizar1 = new javax.swing.JButton();
        label2 = new javax.swing.JLabel();

        lb2.setForeground(new java.awt.Color(204, 204, 204));
        lb2.setText(".");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Movimiento Bancarios");
        setVisible(true);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        label1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label1.setText("Movimiento Detalles");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        label3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label3.setText("Id Movimiento Encabezado");

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        tablaUsuarios.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Vendedor", "ID Empleado", "Correo", "Telefono", "Direccion", "Porcentaje", "Comision"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        txtCosto.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtCosto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtCosto.setOpaque(false);

        label5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label5.setText("Costo");

        lb.setForeground(new java.awt.Color(204, 204, 204));
        lb.setText(".");

        jButton2.setText("Ayuda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        label4.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label4.setText("ID a buscar");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label6.setText("Id Movimiento Detalles");

        txtIdMovDetalles.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtIdMovDetalles.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtIdMovDetalles.setOpaque(false);

        txtSaldo.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtSaldo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtSaldo.setOpaque(false);

        label7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label7.setText("Saldo");

        label8.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label8.setText("Id Concepto");

        label9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label9.setText("Id TIpo Movimento Moneda");

        label13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label13.setText("Codigo Bancario");

        txtid.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtid.setOpaque(false);
        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        label14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label14.setText("ID");

        cbCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCodigoActionPerformed(evt);
            }
        });

        label15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label15.setText("Tipo Movimiento");

        label16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label16.setText("ID Cuenta");

        txtFecha.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        txtFecha.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(204, 204, 204)));
        txtFecha.setOpaque(false);
        txtFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaActionPerformed(evt);
            }
        });

        label17.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label17.setText("ID cuenta de la empresa");

        label18.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label18.setText("Fecha");

        tablaMovimientoEncavezado.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        tablaMovimientoEncavezado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ", "Codigo Bancario", "ID Cuenta", "Tipo Movimiento", "Fecha", "ID cuenta empresa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaMovimientoEncavezado);

        btnLimpiar1.setText("Limpiar");
        btnLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar1ActionPerformed(evt);
            }
        });

        btnEliminar1.setText("Eliminar");
        btnEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminar1ActionPerformed(evt);
            }
        });

        btnRegistrar1.setText("Registrar");
        btnRegistrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar1ActionPerformed(evt);
            }
        });

        jButton3.setText("Ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        label10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label10.setText("ID a buscar");

        btnModificar1.setText("Modificar");
        btnModificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificar1ActionPerformed(evt);
            }
        });

        btnActualizar1.setText("Actualizar");
        btnActualizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizar1ActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        label2.setText("Movimiento Encabezado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(label7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label3)
                                    .addComponent(label9)
                                    .addComponent(label8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cbMovimientoEncabezado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbConcepto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbMovimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(123, 149, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label5)
                                    .addComponent(label6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdMovDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4)
                            .addGap(123, 123, 123)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(52, 52, 52)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(14, 14, 14)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label1)
                            .addComponent(btnActualizar))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addComponent(label16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(label15)
                                        .addComponent(label18))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbTipMov, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label17)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbIdCuenEm, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnRegistrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnModificar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtbuscadoE, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnActualizar1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label14)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label13)
                            .addComponent(cbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label16)
                                .addGap(17, 17, 17))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cbIdCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label15)
                            .addComponent(cbTipMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label18)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label17)
                            .addComponent(cbIdCuenEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnActualizar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb)
                        .addGap(7, 7, 7)
                        .addComponent(label1)
                        .addGap(4, 4, 4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar1)
                            .addComponent(btnModificar1)
                            .addComponent(btnEliminar1)
                            .addComponent(btnLimpiar1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(btnBuscar1)
                            .addComponent(label10)
                            .addComponent(txtbuscadoE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label6)
                            .addComponent(txtIdMovDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label5)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label7))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(label3)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(label8)
                                            .addComponent(cbConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cbMovimientoEncabezado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(label9))
                            .addComponent(cbMovimientoMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrar)
                            .addComponent(btnEliminar)
                            .addComponent(btnModificar))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnLimpiar)
                            .addComponent(jButton2))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(label4)
                            .addComponent(txtbuscado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizar)))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        banco.setIdMovimientoDetalles(Integer.parseInt(txtbuscado.getText()));
        registrosBorrados=banco.setBorrarMovimiento(banco);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
    banco.setIdMovimientoDetalles(Integer.parseInt(txtIdMovDetalles.getText()));
    banco.setIdMovimiento(Integer.parseInt(cbMovimientoEncabezado.getSelectedItem().toString()));
    banco.setMovimientoCosto(Float.parseFloat(txtCosto.getText()));
    banco.setIdConcepto(Integer.parseInt(cbConcepto.getSelectedItem().toString()));
    banco.setMovimientoSaldo(Float.parseFloat(txtSaldo.getText())); 
    banco.setIdTipoMovimiento(Integer.parseInt(cbMovimientoMoneda.getSelectedItem().toString()));
    banco.setIngresarMovimiento(banco);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        //aplicacion.setNombreAplicacion(txtbuscado.getText());        
        banco.setIdMovimientoDetalles(Integer.parseInt(txtbuscado.getText()));        
        banco = banco.getBuscarInformacionBancoPorTipoMovimiento(banco);
        System.out.println("Usuario retornado:" + banco); 
       txtIdMovDetalles.setText(Integer.toString(banco.getIdMovimientoDetalles()));
txtCosto.setText(Float.toString(banco.getMovimientoCosto()));
txtSaldo.setText(Float.toString(banco.getMovimientoSaldo()));
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "REA");
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
//        // TODO add your handling code here:
        clsMovimientoDetallesBancos banco = new clsMovimientoDetallesBancos();
        banco.setIdMovimientoDetalles(Integer.parseInt(txtbuscado.getText()));
        banco.setMovimientoCosto (Float.parseFloat(txtCosto.getText()));
        banco.setMovimientoSaldo(Float.parseFloat(txtSaldo.getText()));
        banco.setModificarMovimiento(banco);
        
        JOptionPane.showMessageDialog(null, "Registro Modificado\n", 
                    "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);  
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");
        llenadoDeTablas();
        limpiarTextos();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiarTextos();
        habilitarBotones();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed
    public void limpiarTextos()
    {
       
        txtCosto.setText("");
        txtIdMovDetalles.setText("");
        txtSaldo.setText("");
        
    }
    public void habilitarBotones()
    {
        btnRegistrar.setEnabled(true);
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }
    public void desHabilitarBotones()
    {
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
        btnEliminar.setEnabled(false);
    }    
    
    public void limpiarTextos2()
    {
        txtid.setText("");
        txtFecha.setText("");
        txtbuscadoE.setText("");
        cbCodigo.setSelectedIndex(0);
        cbIdCuenta.setSelectedIndex(0);
        cbTipMov.setSelectedIndex(0);
        cbIdCuenEm.setSelectedIndex(0);

    }
    public void habilitarBotones2()
    {
        btnRegistrar1.setEnabled(true);
        btnModificar1.setEnabled(true);
        btnEliminar1.setEnabled(true);
    }
    public void desHabilitarBotones2()
    {
        btnRegistrar1.setEnabled(false);
        btnModificar1.setEnabled(false);
        btnEliminar1.setEnabled(false);
    }    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                        .getRuntime()
                        .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaActionPerformed

    private void btnLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar1ActionPerformed
        limpiarTextos2();
        habilitarBotones2();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiar1ActionPerformed

    private void btnEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminar1ActionPerformed
        // TODO add your handling code here:
        int registrosBorrados=0;
        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        encabezado.setMovId(Integer.parseInt(txtbuscadoE.getText()));
        registrosBorrados=encabezado.setborrarMovimientosEncabezado(encabezado);
        JOptionPane.showMessageDialog(null, "Registro Borrado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas2();

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "DEL");

        limpiarTextos2();
    }//GEN-LAST:event_btnEliminar1ActionPerformed

    private void btnRegistrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar1ActionPerformed

        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        encabezado.setMovId(Integer.parseInt(txtid.getText()));
        encabezado.setMovFecha(txtFecha.getText());
        encabezado.setCodBanco(Integer.parseInt(cbCodigo.getSelectedItem().toString()));
        encabezado.setCueId(Integer.parseInt(cbIdCuenta.getSelectedItem().toString()));
        encabezado.setTipMovId(Integer.parseInt(cbTipMov.getSelectedItem().toString()));
        encabezado.setCueEmId(Integer.parseInt(cbIdCuenEm.getSelectedItem().toString()));

        

        encabezado.setingresaMovimientosEncabezado(encabezado);
        JOptionPane.showMessageDialog(null, "Registro Ingresado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "INS");
        llenadoDeTablas2();
        limpiarTextos2();

    }//GEN-LAST:event_btnRegistrar1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            if ((new File("src\\main\\java\\ayudas\\ProcesoMayor.chm")).exists()) {
                Process p = Runtime
                .getRuntime()
                .exec("rundll32 url.dll,FileProtocolHandler src\\main\\java\\ayudas\\ProcesoMayor.chm");
                p.waitFor();
            } else {
                System.out.println("La ayuda no Fue encontrada");
            }
            System.out.println("Correcto");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        //usuario.setNombreUsuario(txtbuscado.getText());
        encabezado.setMovId(Integer.parseInt(txtbuscadoE.getText()));
        encabezado = encabezado.getBuscarMovimientosEncabezadoPorId(encabezado);
        System.out.println("movDetalle retornado:" + encabezado);
        txtFecha.setText(encabezado.getMovFecha());


        int cogidoBanc = encabezado.getCodBanco();
        for (int i = 1; i < cbCodigo.getItemCount(); i++) {
            int item = Integer.parseInt(cbCodigo.getItemAt(i).toString());
            if (item == cogidoBanc) {
                cbCodigo.setSelectedIndex(i);
                break;
            }
        }
        
        int IdCuenta = encabezado.getCueId();
        for (int i = 1; i < cbIdCuenta.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdCuenta.getItemAt(i).toString());
            if (item == IdCuenta) {
                cbIdCuenta.setSelectedIndex(i);
                break;
            }
        }
        
        int TipMovID = encabezado.getTipMovId();
        for (int i = 1; i < cbTipMov.getItemCount(); i++) {
            int item = Integer.parseInt(cbTipMov.getItemAt(i).toString());
            if (item == TipMovID) {
                cbTipMov.setSelectedIndex(i);
                break;
            }
        }

        
        int CuentaEmID = encabezado.getCueEmId();
        for (int i = 1; i < cbIdCuenEm.getItemCount(); i++) {
            int item = Integer.parseInt(cbIdCuenEm.getItemAt(i).toString());
            if (item == CuentaEmID) {
                cbIdCuenEm.setSelectedIndex(i);
                break;
            }
        }
        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "QRY");
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnModificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificar1ActionPerformed
        //        // TODO add your handling code here:
        clsMovimientosEncabezadoBancos encabezado = new clsMovimientosEncabezadoBancos();
        encabezado.setMovId(Integer.parseInt(txtbuscadoE.getText()));
        encabezado.setMovFecha(txtFecha.getText());
        encabezado.setCodBanco(Integer.parseInt(cbCodigo.getSelectedItem().toString()));
        encabezado.setCueId(Integer.parseInt(cbIdCuenta.getSelectedItem().toString()));
        encabezado.setTipMovId(Integer.parseInt(cbTipMov.getSelectedItem().toString()));
        encabezado.setCueEmId(Integer.parseInt(cbIdCuenEm.getSelectedItem().toString()));

        

        encabezado.setModificarMovimientosEncabezado(encabezado);
        JOptionPane.showMessageDialog(null, "Registro Modificado\n",
            "Información del Sistema", JOptionPane.INFORMATION_MESSAGE);
        llenadoDeTablas2();

        int resultadoBitacora=0;
        clsBitacora bitacoraRegistro = new clsBitacora();
        resultadoBitacora = bitacoraRegistro.setIngresarBitacora(clsUsuarioConectado.getIdUsuario(), codigoAplicacion, "UPD");

        limpiarTextos2();
    }//GEN-LAST:event_btnModificar1ActionPerformed

    private void btnActualizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizar1ActionPerformed
        // TODO add your handling code here:
        llenadoDeTablas2();
    }//GEN-LAST:event_btnActualizar1ActionPerformed

    private void cbCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbCodigoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizar1;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminar1;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar1;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnModificar1;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegistrar1;
    private javax.swing.JComboBox<String> cbCodigo;
    private javax.swing.JComboBox<String> cbConcepto;
    private javax.swing.JComboBox<String> cbIdCuenEm;
    private javax.swing.JComboBox<String> cbIdCuenta;
    private javax.swing.JComboBox<String> cbMovimientoEncabezado;
    private javax.swing.JComboBox<String> cbMovimientoMoneda;
    private javax.swing.JComboBox<String> cbTipMov;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label10;
    private javax.swing.JLabel label13;
    private javax.swing.JLabel label14;
    private javax.swing.JLabel label15;
    private javax.swing.JLabel label16;
    private javax.swing.JLabel label17;
    private javax.swing.JLabel label18;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JLabel label5;
    private javax.swing.JLabel label6;
    private javax.swing.JLabel label7;
    private javax.swing.JLabel label8;
    private javax.swing.JLabel label9;
    private javax.swing.JLabel lb;
    private javax.swing.JLabel lb2;
    private javax.swing.JLabel lbusu;
    private javax.swing.JTable tablaMovimientoEncavezado;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtIdMovDetalles;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtbuscado;
    private javax.swing.JTextField txtbuscadoE;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
