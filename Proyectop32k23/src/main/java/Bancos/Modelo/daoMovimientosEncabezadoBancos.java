/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Modelo;

import Bancos.Controlador.clsMovimientosEncabezadoBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMovimientosEncabezadoBancos {

    private static final String SQL_SELECT = "SELECT movId, codBanco, cueId, tipMovId, movFecha, cueEmId FROM tbl_movimientosEncabezadoBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_movimientosEncabezadoBancos(movId, codBanco, cueId, tipMovId, movFecha, cueEmId) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movimientosEncabezadoBancos SET codBanco=?, cueId=?,  tipMovId=?, movFecha=?,  cueEmId=?  WHERE movId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movimientosEncabezadoBancos WHERE movId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT movId, cueId, tipMovId, movFecha, cueEmId  FROM tbl_movimientosEncabezadoBancos WHERE  codBanco = ?";
    private static final String SQL_SELECT_ID = "SELECT codBanco, cueId, tipMovId, movFecha, cueEmId  FROM tbl_movimientosEncabezadoBancos WHERE movId = ?";     



    public String fechaActual() {

        java.util.Date fecha = new java.util.Date();
        //SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
        SimpleDateFormat formatoFecha = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");

        return formatoFecha.format(fecha);

    }

   public List<clsMovimientosEncabezadoBancos> consultaMovimientosEncabezado() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMovimientosEncabezadoBancos> MovEncabezadoB = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("movId");
                int codigo = rs.getInt("codBanco");
                int idcuenta = rs.getInt("cueId");
                int idTipoMonv = rs.getInt("tipMovId");
                String fecha = rs.getString("movFecha");
                int idCuentaEm = rs.getInt("cueEmId");
                clsMovimientosEncabezadoBancos MovEncabezado = new clsMovimientosEncabezadoBancos();
                MovEncabezado.setMovId(id);
                MovEncabezado.setCodBanco(codigo);
                MovEncabezado.setCueId(idcuenta);
                MovEncabezado.setTipMovId(idTipoMonv);
                MovEncabezado.setMovFecha(fecha);
                MovEncabezado.setCueEmId(idCuentaEm);
                MovEncabezadoB.add(MovEncabezado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return MovEncabezadoB;
    }

