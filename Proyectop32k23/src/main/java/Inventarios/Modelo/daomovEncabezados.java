/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsmovEncabezados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daomovEncabezados {

    private static final String SQL_SELECT = "SELECT mEnCodigo, movCodigo, mEnfecha, mEnEstatus FROM tbl_movencabezado";
    private static final String SQL_INSERT = "INSERT INTO tbl_movencabezado(mEnCodigo, movCodigo, mEnfecha, mEnEstatus) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movencabezado SET movCodigo=?, mEnfecha=?, mEnEstatus=? WHERE mEnCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movencabezado WHERE mEnCodigo=?";
    //private static final String SQL_SELECT_NOMBRE = "SELECT bodCodigo, bodNombre, bodDescripcion, bodFechaIngreso, bodFechaSalida, bodEstatus FROM tbl_bodegas WHERE bodNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT mEnCodigo, movCodigo, mEnfecha, mEnEstatus FROM tbl_movencabezado WHERE mEnCodigo = ?";    

    public List<clsmovEncabezados> consultaMovimientos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsmovEncabezados> encabezados = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEn = rs.getInt("mEnCodigo");
                int idMov = rs.getInt("movCodigo");
                String fecha = rs.getString("mEnfecha");
                String estatus = rs.getString("mEnEstatus");
                
                clsmovEncabezados Encabezado = new clsmovEncabezados();
                Encabezado.setIdEncabezado(idEn);
                Encabezado.setIdMovimiento(idMov);
                Encabezado.setFechaMovimiento(fecha);
                Encabezado.setEstatusMovimiento(estatus);
                
                encabezados.add(Encabezado);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return encabezados;
    }

    public int ingresaMovimientos(clsmovEncabezados encabezados) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, encabezados.getIdMovimiento());
            stmt.setString(2, encabezados.getFechaMovimiento());
            stmt.setString(3, encabezados.getEstatusMovimiento());

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

    public int actualizaMovimientos(clsmovEncabezados movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, movimientos.getIdMovimiento());
            stmt.setString(2, movimientos.getFechaMovimiento());
            stmt.setString(3, movimientos.getEstatusMovimiento());
            stmt.setInt(4, movimientos.getIdEncabezado());

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

    public int borrarMovimientos(clsmovEncabezados movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, movimientos.getIdEncabezado());
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

    /*public clsmovEncabezados consultaMovimientosPorNombre(clsmovEncabezados movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodegas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, bodegas.getNombreBodegas());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bodCodigo");
                String nombre = rs.getString("bodNombre");
                String descripcion = rs.getString("bodDescripcion");
                String fIngreso = rs.getString("bodFechaIngreso");
                String fSalida = rs.getString("bodFechaSalida");
                String estatus = rs.getString("bodEstatus");

                //aplicacion = new clsAplicacion();
                bodegas.setIdBodegas(id);
                bodegas.setNombreBodegas(nombre);
                bodegas.setDescripcionBodega(descripcion);
                bodegas.setfIngresoBodega(fIngreso);
                bodegas.setfSalidaBodega(fSalida);
                bodegas.setEstatusBodegas(estatus);
                System.out.println(" registro consultado: " + bodegas);                
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
        return bodegas;
    }*/
    public clsmovEncabezados consultaMovimientosPorId(clsmovEncabezados movimientos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodegas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, movimientos.getIdEncabezado());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEn = rs.getInt("mEnCodigo");
                int idMov = rs.getInt("movCodigo");
                String fecha = rs.getString("mEnfecha");
                String estatus = rs.getString("mEnEstatus");

                //aplicacion = new clsAplicacion();
                movimientos.setIdEncabezado(idEn);
                movimientos.setIdMovimiento(idMov);
                movimientos.setFechaMovimiento(fecha);
                movimientos.setEstatusMovimiento(estatus);
                System.out.println(" registro consultado: " + movimientos);                
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
        return movimientos;
    }    
}
