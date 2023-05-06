/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Modelo;

import  Seguridad.Modelo.*;
import  Inventarios.Controlador.clsLineas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoLineas {

    private static final String SQL_SELECT = "SELECT linCodigo, linNombre, linPrecios,linEstatus FROM tbl_lineas";
    private static final String SQL_INSERT = "INSERT INTO tbl_lineas(linNombre,linPrecios, linEstatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_lineas SET linNombre=?, linPrecios=?,linEstatus=?  WHERE linCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_lineas WHERE linCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT linCodigo, linNombre, linPrecios,linEstatus FROM tbl_lineas WHERE linNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT linCodigo, linNombre, linPrecios,linEstatus FROM tbl_lineas WHERE linCodigo = ?";    

    public List<clsLineas> consultaLineas() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsLineas> lineas = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                String precios= rs.getString("linPrecios");
                String estatus = rs.getString("linEstatus");
               
                clsLineas nuevo = new clsLineas();
                nuevo.setLinCodigo(codigo);
                nuevo.setLinNombre(nombre);
                 nuevo.setLinPrecios(precios);
                nuevo.setLinEstatus(estatus);
                nuevo.add(nuevo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return lineas;
    }

    public int ingresaLineas(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, lineas.getLinNombre());
            stmt.setString(2, lineas.getLinEstatus());

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

    public int actualizaLineas(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, lineas.getLinNombre());
            stmt.setString(2, lineas.getLinEstatus());
            stmt.setInt(3, lineas.getLinCodigo());

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

    public int borrarLineas(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, lineas.getLinCodigo());
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

    public clsLineas consultaLineasPorNombre(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + lineas);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, lineas.getLinNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                String precios = rs.getString("linPrecios");
                String estatus = rs.getString("linEstatus");

                //aplicacion = new clsAplicacion();
                lineas.setLinCodigo(codigo);
                lineas.setLinNombre(nombre);
                 lineas.setLinPrecios(precios);
                lineas.setLinEstatus(estatus);
                System.out.println(" registro consultado: " + lineas);                
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
        return lineas;
    }
    public clsLineas consultaLineasPorcodigo(clsLineas lineas) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + lineas);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, lineas.getLinCodigo());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                String precios = rs.getString("linPrecios");
                String estatus = rs.getString("linEstatus");

                //aplicacion = new clsAplicacion();
                lineas.setLinCodigo(codigo);
                lineas.setLinNombre(nombre);
                 lineas.setLinPrecios(precios);
                lineas.setLinEstatus(estatus);
                System.out.println(" registro consultado: " + lineas);                
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
        return lineas;
    }    
}
