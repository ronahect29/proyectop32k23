/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Meyglin del Rosario Rosales Ochoa Carne: 9959-21-4490
package Ventas.Modelo;

import Ventas.Controlador.clsClientes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoClientes {


    private static final String SQL_SELECT = "SELECT clid, clnombre, clestatus FROM tbl_cliente";
    private static final String SQL_INSERT = "INSERT INTO tbl_cliente(clnombre, clestatus) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cliente SET clnombre=?, clestatus=? WHERE clid = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cliente WHERE clid=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT clid, clnombre, clestatus FROM tbl_cliente WHERE clnombre = ?";
    private static final String SQL_SELECT_ID = "SELECT clid, clnombre, clestatus FROM tbl_cliente WHERE clid = ?";    

    public List<clsClientes> consultaPerfil() {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        

        List<clsClientes> perfiles = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("clid");
                String nombre = rs.getString("clnombre");
                String estatus = rs.getString("clestatus");
                clsClientes perfil = new clsClientes();
                perfil.setIdPerfil(id);
                perfil.setNombrePerfil(nombre);
                perfil.setEstatusPerfil(estatus);
                perfiles.add(perfil);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return perfiles;
    }

    public int ingresaPerfil(clsClientes perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);

            stmt.setString(1, perfil.getNombrePerfil());
            stmt.setString(2, perfil.getEstatusPerfil());


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


    public int actualizaPerfil(clsClientes perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, perfil.getNombrePerfil());
            stmt.setString(2, perfil.getEstatusPerfil());
            stmt.setInt(3, perfil.getIdPerfil());


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


    public int borrarPerfil(clsClientes perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, perfil.getIdPerfil());

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


    public clsClientes consultaPerfilPorNombre(clsClientes perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + perfil);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, perfil.getIdPerfil());            
            stmt.setString(1, perfil.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clid");
                String nombre = rs.getString("clnombre");
                String estatus = rs.getString("clestatus");

                //perfil = new clsPerfil();
                perfil.setIdPerfil(id);
                perfil.setNombrePerfil(nombre);
                perfil.setEstatusPerfil(estatus);
                System.out.println(" registro consultado: " + perfil);                

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

        return perfil;
    }
    public clsClientes consultaPerfilPorId(clsClientes perfil) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();

            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + perfil);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, perfil.getIdPerfil());            
            //stmt.setString(1, perfil.getNombrePerfil());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("clid");
                String nombre = rs.getString("clnombre");
                String estatus = rs.getString("clestatus");

                //perfil = new clsPerfil();
                perfil.setIdPerfil(id);
                perfil.setNombrePerfil(nombre);
                perfil.setEstatusPerfil(estatus);
                System.out.println(" registro consultado: " + perfil);                

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

        return perfil;

    }    
}
