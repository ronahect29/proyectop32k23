/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

import  Seguridad.Modelo.*;
import  Inventarios.Controlador.clsMovimientos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMovimientos {

    private static final String SQL_SELECT = "SELECT movCodigo, movDescripcion, movEfecto,movEstatus FROM tbl_movimientos";
    private static final String SQL_INSERT = "INSERT INTO tbl_movimientos(movCodigo,movDescripcion,movEfecto, movEstatus) VALUES(?,?,?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movimientos SET movDescripcion=?, movEfecto=?,movEstatus=?  WHERE movCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movimientos WHERE movCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT movCodigo, movDescripcion, movEfecto,movEstatus FROM tbl_movimientos WHERE movDescripcion = ?";
    private static final String SQL_SELECT_ID = "SELECT movCodigo, movDescripcion, movEfecto,movEstatus FROM tbl_movimientos WHERE movCodigo = ?";    

    public List<clsMovimientos> consultaMovimientos() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsMovimientos> movimientos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("movCodigo");
                String nombre = rs.getString("movDescripcion");
                int precios= rs.getInt("movEfecto");
                String estatus = rs.getString("movEstatus");
               
                clsMovimientos nuevo = new clsMovimientos();
                nuevo.setMovCodigo(codigo);
                nuevo.setMovDescripcion(nombre);
                nuevo.setMovEfecto(precios);
                nuevo.setMovEstatus(estatus);
                nuevo.add(nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return movimientos;
    }

    public int ingresaMovimientos(clsMovimientos mov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, mov.getMovCodigo());
            stmt.setString(2, mov.getMovDescripcion());
            stmt.setInt(3, mov.getMovEfecto());
            stmt.setString(4, mov.getMovEstatus());

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

    public int actualizaMovimientos(clsMovimientos mov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setInt(1, mov.getMovCodigo());
            stmt.setString(2, mov.getMovDescripcion());
            stmt.setInt(3, mov.getMovEfecto());
            stmt.setString(4, mov.getMovEstatus());

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

    public int borrarMovimientos(clsMovimientos mov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, mov.getMovCodigo());
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

    public clsMovimientos  consultaMovimientosPorNombre(clsMovimientos mov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + mov);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setInt(1, mov.getMovCodigo());
            stmt.setString(2, mov.getMovDescripcion());
            stmt.setInt(3, mov.getMovEfecto());
            stmt.setString(4, mov.getMovEstatus());
            rs = stmt.executeQuery();
            while (rs.next()) {               
                
                
                int codigo = rs.getInt("movCodigo");
                String nombre = rs.getString("movDescripcion");
                int precios= rs.getInt("movEfecto");
                String estatus = rs.getString("movEstatus");

                //aplicacion = new clsAplicacion();
                mov.setMovCodigo(codigo);
                mov.setMovDescripcion(nombre);
                 mov.setMovEfecto(precios);
                mov.setMovEstatus(estatus);
                System.out.println(" registro consultado: " + mov);                
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
        return mov;
    }
    public clsMovimientos consultaMovimientosPorcodigo(clsMovimientos mov) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + mov);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, mov.getMovCodigo());
            stmt.setString(2, mov.getMovDescripcion());
            stmt.setInt(3, mov.getMovEfecto());
            stmt.setString(4, mov.getMovEstatus());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
               int codigo = rs.getInt("movCodigo");
                String nombre = rs.getString("movDescripcion");
                int precios= rs.getInt("movEfecto");
                String estatus = rs.getString("movEstatus");

                //aplicacion = new clsAplicacion();
                mov.setMovCodigo(codigo);
                mov.setMovDescripcion(nombre);
                 mov.setMovEfecto(precios);
                mov.setMovEstatus(estatus);
                System.out.println(" registro consultado: " + mov);                
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
        return mov;
    }    
}
