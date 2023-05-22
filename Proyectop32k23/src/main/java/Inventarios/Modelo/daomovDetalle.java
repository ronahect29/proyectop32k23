/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsmovDetalle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daomovDetalle {

    private static final String SQL_SELECT = "SELECT mEnCodigo, proCodigo, cantidades, muestras, traslados FROM tbl_movdetalles";
    private static final String SQL_INSERT = "INSERT INTO tbl_movdetalles(mEnCodigo, proCodigo, cantidades, muestras, traslados) VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movdetalles SET proCodigo=?, cantidades=?, muestras=?, traslados=? WHERE mEnCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movdetalles WHERE mEnCodigo=?";
    //private static final String SQL_SELECT_NOMBRE = "SELECT bodCodigo, bodNombre, bodDescripcion, bodFechaIngreso, bodFechaSalida, bodEstatus FROM tbl_bodegas WHERE bodNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT mEnCodigo, proCodigo, cantidades, muestras, traslados FROM tbl_movdetalles WHERE mEnCodigo = ?";    

    public List<clsmovDetalle> consultaDetalles() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsmovDetalle> detalles = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEn = rs.getInt("mEnCodigo");
                int idPro = rs.getInt("proCodigo");
                int cantidades = rs.getInt("cantidades");
                int muestras = rs.getInt("muestras");
                int traslados = rs.getInt("traslados");
                
                clsmovDetalle Detalles = new clsmovDetalle();
                Detalles.setIdEncabezado(idEn);
                Detalles.setIdProducto(idPro);
                Detalles.setCantidadesDetalles(cantidades);
                Detalles.setMuestrasDetalles(muestras);
                Detalles.setTrasladosDetalles(traslados);
                
                detalles.add(Detalles);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return detalles;
    }

    public int ingresaDetalles(clsmovDetalle detalles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, detalles.getIdProducto());
            stmt.setInt(2, detalles.getCantidadesDetalles());
            stmt.setInt(3, detalles.getMuestrasDetalles());
            stmt.setInt(4, detalles.getMuestrasDetalles());

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

    public int actualizaDetalles(clsmovDetalle detalles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setInt(1, detalles.getIdProducto());
            stmt.setInt(2, detalles.getCantidadesDetalles());
            stmt.setInt(3, detalles.getMuestrasDetalles());
            stmt.setInt(4, detalles.getTrasladosDetalles());
            stmt.setInt(5, detalles.getIdEncabezado());

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

    public int borrarDetalles(clsmovDetalle detalles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, detalles.getIdEncabezado());
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
    public clsmovDetalle consultaDetallesPorId(clsmovDetalle detalles) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            //System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + bodegas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, detalles.getIdEncabezado());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEn = rs.getInt("mEnCodigo");
                int idPro = rs.getInt("proCodigo");
                int cantidades = rs.getInt("cantidades");
                int muestras = rs.getInt("muestras");
                int traslados = rs.getInt("traslados");
                
                //aplicacion = new clsAplicacion();
                detalles.setIdEncabezado(idEn);
                detalles.setIdProducto(idPro);
                detalles.setCantidadesDetalles(cantidades);
                detalles.setMuestrasDetalles(muestras);
                detalles.setTrasladosDetalles(traslados);
                System.out.println(" registro consultado: " + detalles);                
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
        return detalles;
    }    
}
