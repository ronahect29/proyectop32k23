    package Seguridad.Modelo;

import java.sql.*;
import javax.swing.DefaultComboBoxModel;

public class Conexion {

<<<<<<< HEAD

private static final String JDBC_URL = "jdbc:mysql://localhost/pruebaproyecto?useSSL=false&serverTimezone=UTC";    
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "rosales2811";
    Connection conn = null;
=======
private static final String JDBC_URL = "jdbc:mysql://localhost/proyectop312023?useSSL=false&serverTimezone=UTC";    
<<<<<<< HEAD
    private static final String JDBC_USER = "usuprueba";
    private static final String JDBC_PASS = "123456";
  
=======
    private static final String JDBC_USER = "UsuPrueba";
    private static final String JDBC_PASS = "123456";
>>>>>>> 0f6d78d91ba61839ab1dfd65f7d117e5d6db98d0
   
>>>>>>> 7583f9e4abeb4770049a3adf614c472969544871
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
