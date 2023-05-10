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

    private static final String SQL_SELECT = "SELECT linCodigo, linNombre, linPrecios,linEstatus FROM tbl_Lineas";
    private static final String SQL_INSERT = "INSERT INTO tbl_Lineas(linNombre,linPrecios, linEstatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_Lineas SET linNombre=?, linPrecios=?,linEstatus=?  WHERE linCodigo = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_Lineas WHERE linCodigo=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT linCodigo, linNombre, linPrecios,linEstatus FROM tbl_Lineass WHERE movDescripcion = ?";
    private static final String SQL_SELECT_ID = "SELECT linCodigo, linNombre, linPrecios,linEstatus FROM tbl_Lineas WHERE linCodigo = ?";    

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
                int precios= rs.getInt("linPrecios");
                String estatus = rs.getString("linEstatus");
               
                clsLineas nuevo = new clsLineas();
                nuevo.setlinCodigo(codigo);
                nuevo.setlinNombre(nombre);
                nuevo.setlinPrecios(precios);
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

    public int ingresaLineas(clsLineas lin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, lin.getlinNombre());
            stmt.setString(2, lin.getLinEstatus());

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

    public int actualizaLineas(clsLineas lin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, lin.getlinNombre());
            stmt.setString(2, lin.getLinEstatus());
            stmt.setInt(3, lin.getlinCodigo());

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

    public int borrarLineas(clsLineas lin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, lin.getlinCodigo());
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

    public clsLineas  consultaLineasPorNombre(clsLineas lin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + lin);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, aplicacion.getIdAplicacion());            
            stmt.setString(1, lin.getlinNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {               
                
                
                int codigo = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                int precios= rs.getInt("linPrecios");
                String estatus = rs.getString("linEstatus");

                //aplicacion = new clsAplicacion();
                lin.setlinCodigo(codigo);
                lin.setlinNombre(nombre);
                lin.setlinPrecios(precios);
                lin.setLinEstatus(estatus);
                System.out.println(" registro consultado: " + lin);                
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
        return lin;
    }
    public clsLineas consultaLineasPorcodigo(clsLineas lin) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + lin);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setString(1, lin.getlinNombre());            
            //stmt.setString(1, aplicacion.getNombreAplicacion());
            rs = stmt.executeQuery();
            while (rs.next()) {
               int codigo = rs.getInt("linCodigo");
                String nombre = rs.getString("linNombre");
                int precios= rs.getInt("linPecios");
                String estatus = rs.getString("linEstatus");

                //aplicacion = new clsAplicacion();
                lin.setlinCodigo(codigo);
                lin.setlinNombre(nombre);
                lin.setlinPrecios(precios);
                lin.setLinEstatus(estatus);
                System.out.println(" registro consultado: " + lin);                
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
        return lin;
    }    
}
