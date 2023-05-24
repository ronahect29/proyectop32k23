    package Seguridad.Modelo;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;

public class Conexion {


private static final String JDBC_URL = "jdbc:mysql://localhost/pruebaproyecto?useSSL=false&serverTimezone=UTC";    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "rosales2811";
    Connection conn = null;
   
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }
    
    public Conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
        }catch(SQLException | ClassNotFoundException e){
            System.out.println(e);
        }
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    public ResultSet consulta (String sql){
        ResultSet res = null;
        try {
            PreparedStatement pstm = conn.prepareStatement(sql);
            res = pstm.executeQuery();
        }catch (SQLException e){
            System.err.println("Error consulta :" + e.getMessage());
        }
        return res;
    }
    
    public DefaultComboBoxModel Obt_CodigoL(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_lineas");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("linCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    public DefaultComboBoxModel Obt_CodigoM(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_marcas");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("marCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    
    public DefaultComboBoxModel Obt_CodigoP(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_productos");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("proCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    public DefaultComboBoxModel Obt_CodigoB(){
        DefaultComboBoxModel ListaModelo = new DefaultComboBoxModel();
        ListaModelo.addElement("Codigo");
        
        ResultSet res = this.consulta("Select * from tbl_bodegas");
        
        try{
            while(res.next()){
                ListaModelo.addElement(res.getString("bodCodigo"));
            }
            res.close();
        }catch(SQLException ex){
            System.err.println(ex.getMessage());
        }
        return ListaModelo;
    }
    
}
