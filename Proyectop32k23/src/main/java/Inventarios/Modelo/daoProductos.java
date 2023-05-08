/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

import Seguridad.Modelo.*;
import Inventarios.Controlador.clsProductos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoProductos {

    private static final String SQL_SELECT = "SELECT proCodigo, proNombre, proPrecios, linCodigo, MarCodigo, proEstatus, proExistencias FROM tbl_Productos";
    private static final String SQL_INSERT = "INSERT INTO tbl_Productos(proCodigo, proNombre, proExistencias, linCodigo, marCodigo, proEstatus, proPrecios) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Productos SET proNombre=?, proExistencias=?, linCodigo=?, marCodigo=?, proEstatus=?, proPrecios=? WHERE proCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Productos WHERE proCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT proCodigo, proNombre, proExistencias, linCodigo, marCodigo, proEstatus, proPrecios FROM tbl_Productos WHERE proNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT proCodigo, proNombre, proExistencias, linCodigo, marCodigo, proEstatus, preoPrecio FROM tbl_Productos WHERE proCodigo = ?";    

    public List<clsProductos> consultaProductos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsProductos> productos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("proCodigo");
                String nombre = rs.getString("proNombre");
                String existencia = rs.getString("proExistencias");
                String lid = rs.getString("linCodigo");
                String precio = ("proPrecios");
                String mar = rs.getString("marCodigo");
                String estatus = rs.getString("proEstatus");
                
                clsProductos Productos = new clsProductos();
                Productos.setIdProductos(id);
                Productos.setNombreProductos(nombre);
                Productos.setExistenciaProducto(existencia);
                Productos.setLineaCodigo(lid);
                Productos.setMarcaCodigo(mar);
                Productos.setPrecioProducto(precio);
                Productos.setEstatusProductos(estatus);
                
                productos.add(Productos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return productos;
    }

    public int ingresaProductos(clsProductos Productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, Productos.getIdProductos());
            stmt.setString(2, Productos.getNombreProductos());
            stmt.setString(3, Productos.getExistenciaProducto());
            stmt.setString(4, Productos.getLineaCodigo());
            stmt.setString(5, Productos.getMarcaCodigo());
            stmt.setString(6, Productos.getPrecioProducto());
            stmt.setString(7, Productos.getEstatusProducto());

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

    public int actualizaProductos(clsProductos Productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, Productos.getNombreProductos());
            stmt.setString(2, Productos.getExistenciaProducto());
            stmt.setString(3, Productos.getLineaCodigo());
            stmt.setString(4, Productos.getMarcaCodigo());
            stmt.setString(5, Productos.getPrecioProducto());
            stmt.setString(6, Productos.getEstatusProducto());
            stmt.setInt(7, Productos.getIdProductos());

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

    public int borrarProductos(clsProductos Productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, Productos.getIdProductos());
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

    public clsProductos consultaProductosPorNombre(clsProductos Productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Productos);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, Productos.getNombreProductos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("proCodigo");
                String nombre = rs.getString("proNombre");
                String existencia = rs.getString("proExistencias");
                String lind = rs.getString("linCodigo");
                String mar = rs.getString("marCodigo");
                String precio = rs.getString("proPrecios");
                String estatus = rs.getString("proEstatus");

                //aplicacion = new clsAplicacion();
                Productos.setIdProductos(id);
                Productos.setNombreProductos(nombre);
                Productos.setExistenciaProducto(existencia);
                Productos.setLineaCodigo(lind);
                Productos.setMarcaCodigo(mar);
                Productos.setPrecioProducto(precio);
                Productos.setEstatusProductos(estatus);
                System.out.println(" registro consultado: " + Productos);                
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
        return Productos;
    }
    public clsProductos consultaProductosPorId(clsProductos Productos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + Productos);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, Productos.getIdProductos());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("proCodigo");
                String nombre = rs.getString("proNombre");
                String existencia = rs.getString("proExistencias");
                String lind = rs.getString("linCodigo");
                String mar = rs.getString("marCodigo");
                String precio = rs.getString("proPrecios");
                String estatus = rs.getString("proEstatus");

                //aplicacion = new clsAplicacion();
                Productos.setIdProductos(id);
                Productos.setNombreProductos(nombre);
                Productos.setExistenciaProducto(existencia);
                Productos.setLineaCodigo(lind);
                Productos.setMarcaCodigo(mar);
                Productos.setPrecioProducto(precio);
                Productos.setEstatusProductos(estatus);
                System.out.println(" registro consultado: " + Productos);                
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
        return Productos;
    }    
}
