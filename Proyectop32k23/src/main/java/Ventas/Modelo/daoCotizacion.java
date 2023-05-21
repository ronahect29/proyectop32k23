/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//María José Véliz Ochoa 
//9959-21-5909
//daoVendedores

package Ventas.Modelo;
import Ventas.Controlador.clsCotizacion;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author maria
 */
public class daoCotizacion {
    
      public int verificarExistencias(int codigoProducto) {
        try {
            // Establecer la conexión a la base de datos
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC","UsuPrueba", "123456");

            // Verificar existencias del producto en la base de datos
            String consulta = "SELECT proExistencias FROM tbl_productos WHERE proCodigo = ?";
            PreparedStatement statement = conn.prepareStatement(consulta);
            statement.setInt(1, codigoProducto);
            ResultSet resultado = statement.executeQuery();
            resultado.next();
            return resultado.getInt("proExistencias");
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
  public double obtenerPrecioProducto(int codigoProducto) {
    double precio = 0.0;

    try {
        // Establecer la conexión a la base de datos
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC","UsuPrueba", "123456");

        // Preparar la consulta SQL para obtener el precio del producto
        String query = "SELECT proPrecios FROM tbl_productos WHERE proCodigo = ?";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setInt(1, codigoProducto);

        // Ejecutar la consulta
        ResultSet rs = stmt.executeQuery();

        // Verificar si se encontró el producto y obtener su precio
        if (rs.next()) {
            precio = rs.getDouble("proPrecios");
        }

        // Cerrar la conexión y liberar los recursos
        rs.close();
        stmt.close();
        conn.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return precio;
}
}
 
