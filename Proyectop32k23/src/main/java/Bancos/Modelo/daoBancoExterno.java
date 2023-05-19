/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Modelo;

import Bancos.Controlador.clsBancoExterno;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoBancoExterno {

    private static final String SQL_SELECT = "SELECT codBanco, banNombre, banPais, tipModId FROM tbl_bancoExterno";
    private static final String SQL_INSERT = "INSERT INTO tbl_bancoExterno(codBanco, banNombre, banPais, tipModId) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_bancoExterno SET banNombre=?, banPais=?,  tipModId=?  WHERE codBanco = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_bancoExterno WHERE codBanco=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT codBanco, banNombre, banPais, tipModId  FROM tbl_bancoExterno WHERE banNombre = ?";
    private static final String SQL_SELECT_ID = "SELECT codBanco, banNombre, banPais, tipModId  FROM tbl_bancoExterno WHERE codBanco = ?";     



   public List<clsBancoExterno> consultaBanco() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<clsBancoExterno> bancos = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codBanco");
                String nombre = rs.getString("banNombre");
                String pais = rs.getString("banPais");
                int tipoMond = rs.getInt ("tipModId");
                clsBancoExterno banco = new clsBancoExterno();
                banco.setCodigoBanco(id);
                banco.setNombreBanco(nombre);
                banco.setPaisBanco(pais);
                banco.setTipoMonedaId(tipoMond);
                bancos.add(banco);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return bancos;
    }


     public int ingresarBancoExterno (clsBancoExterno banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, banco.getCodigoBanco());
            stmt.setString(2, banco.getNombreBanco());
            stmt.setString(3, banco.getPaisBanco());
            stmt.setInt(4, banco.getTipoMonedaId());
            
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

    public int actualizaBancoExterno (clsBancoExterno banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, banco.getNombreBanco());
            stmt.setString(2, banco.getPaisBanco());
            stmt.setInt(3, banco.getTipoMonedaId());
            stmt.setInt(4, banco.getCodigoBanco());
            
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

    public int borrarBancoExterno(clsBancoExterno banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, banco.getCodigoBanco());
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

    public clsBancoExterno consultaBancoPorNombre(clsBancoExterno banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_NOMBRE);
            //stmt.setInt(1, moneda.getIdMoneda());            
            stmt.setString(1, banco.getNombreBanco());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codBanco");
                String nombre = rs.getString("banNombre");
                String pais = rs.getString("banPais");
                int tipoMond = rs.getInt("tipModId");
                //moneda = new clsTipoMoneda();
                banco.setCodigoBanco(id);
                banco.setNombreBanco(nombre);
                banco.setPaisBanco(pais);
                banco.setTipoMonedaId(tipoMond);
                System.out.println(" registro consultado: " + banco);                
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
        return banco;
    }
    public clsBancoExterno consultaBancoPorId(clsBancoExterno banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_SELECT_NOMBRE + " objeto recibido: " + banco);
            stmt = conn.prepareStatement(SQL_SELECT_ID);
            stmt.setInt(1, banco.getCodigoBanco());            
            //stmt.setString(1, moneda.getTipMondNombre());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("codBanco");
                String nombre = rs.getString("banNombre");
                String pais = rs.getString("banPais");
                int tipoMond = rs.getInt("tipModId");
                //moneda = new clsTipoMoneda();
                banco.setCodigoBanco(id);
                banco.setNombreBanco(nombre);
                banco.setPaisBanco(pais);
                banco.setTipoMonedaId(tipoMond);
                System.out.println(" registro consultado: " + banco);                
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
        return banco;
    }    
}
