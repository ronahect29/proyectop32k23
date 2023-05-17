/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bancos.Modelo;

import Bancos.Controlador.clsCuentaEmpresa;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoCuentaEmpresa {

    private static final String SQL_SELECT = "SELECT cueEmId, cueNumeroEm, cueSaldoEm, tipoCuentaEm, cueEstatusEm, codBanco FROM tbl_cuentaempresabancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_cuentaempresabancos(cueEmId, cueNumeroEm, cueSaldoEm, tipoCuentaEm, cueEstatusEm, codBanco) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cuentaempresabancos SET cueNumero=?, cueSaldo=?, perId=?, cueTipoId=?, cueestatus=? WHERE cueEmId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cuentaempresabancos WHERE cueEmId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT cueEmId, cueNumeroEm, cueSaldoEm, tipoCuentaEm, cueEstatusEm, codBanco FROM tbl_cuentaempresabancos WHERE cueNumeroEm = ?";
    private static final String SQL_SELECT_ID = "SELECT cueEmId, cueNumeroEm, cueSaldoEm, tipoCuentaEm, cueEstatusEm, codBanco FROM tbl_cuentaempresabancos WHERE cueEmId = ?";
     

    public List<clsCuentaEmpresa> consultaCuentaEmpresas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsCuentaEmpresa> cuentas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueEmId");
                int cuentaN = rs.getInt("cueNumeroEm");
                double saldo = rs.getDouble("cueSaldoEm");
                String tipoC = rs.getString("tipoCuentaEm");
                String estatus = rs.getString("cueEstatusEm");
		        int codigo = rs.getInt("codBanco");
                clsCuentaEmpresa cuentaem = new clsCuentaEmpresa();
                cuentaem.setIdCuentaEm(id);
                cuentaem.setNumeroCuentaEm(cuentaN);
                cuentaem.setSaldoCuentaEm(saldo);
                cuentaem.setTipoCuentaEm(tipoC);
                cuentaem.setEstatusCuentaEm(estatus);
                cuentaem.setCodigoBanco(codigo);
                cuentas.add(cuentaem);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cuentas;
    }

    public int setIngresarCuentaEm(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, cuentaem.getIdCuentaEm());
            stmt.setInt(2, cuentaem.getNumeroCuentaEm());
            stmt.setDouble(3, cuentaem.getSaldoCuentaEm());
            stmt.setString(4, cuentaem.getTipoCuentaEm());
            stmt.setString(5, cuentaem.getEstatusCuentaEm());
            stmt.setInt(6, cuentaem.getCodigoBanco());
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int actualizaCuentaEm(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, cuentaem.getNumeroCuentaEm());
            stmt.setDouble(2, cuentaem.getSaldoCuentaEm());
            stmt.setString(3, cuentaem.getTipoCuentaEm());
	        stmt.setString(4, cuentaem.getEstatusCuentaEm());
            stmt.setInt(5, cuentaem.getCodigoBanco());
            stmt.setInt(6, cuentaem.getIdCuentaEm());
            
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int setBorrarCuentaEm(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cuentaem.getIdCuentaEm());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public clsCuentaEmpresa consultaNumeroCuentaEmpresa(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuentaem);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, usuario.getIdUsuario());            
            stmt.setInt(1, cuentaem.getNumeroCuentaEm());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueEmId");
                int numero = rs.getInt("cueNumeroEm");
                double saldo = rs.getDouble("cueSaldoEm");
                String tipoC = rs.getString("tipoCuentaEm");
                String estatus = rs.getString("cueEstatusEm");
                int codigo = rs.getInt("codBanco");
                //cuenta = new clsCuentaBancos();
                cuentaem.setIdCuentaEm(id);
                cuentaem.setNumeroCuentaEm(numero);
                cuentaem.setSaldoCuentaEm(saldo);
                cuentaem.setTipoCuentaEm(tipoC);
                cuentaem.setEstatusCuentaEm(estatus);
                cuentaem.setCodigoBanco(codigo);
                System.out.println(" registro consultado: " + cuentaem);                
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cuentaem;
    }
    public clsCuentaEmpresa consultaCuentaEmPorId(clsCuentaEmpresa cuentaem) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + cuentaem);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, cuentaem.getIdCuentaEm());            
            //stmt.setString(1, usuario.getNombreUsuario());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("cueEmId");
                int numero = rs.getInt("cueNumeroEm");
                double saldo = rs.getDouble("cueSaldoEm");
                String tipoC = rs.getString("tipoCuentaEm");
                String estatus = rs.getString("cueEstatusEm");
                int codigo = rs.getInt("codBanco");
                cuentaem.setIdCuentaEm(id);
                cuentaem.setNumeroCuentaEm(numero);
                cuentaem.setSaldoCuentaEm(saldo);
                cuentaem.setTipoCuentaEm(tipoC);
                cuentaem.setEstatusCuentaEm(estatus);
                cuentaem.setCodigoBanco(codigo);
                System.out.println(" registro consultado: " + cuentaem);      
            }
            //System.out.println("Registros buscado:" + persona);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        //return personas;  // Si se utiliza un ArrayList
        return cuentaem;
    }    
}
