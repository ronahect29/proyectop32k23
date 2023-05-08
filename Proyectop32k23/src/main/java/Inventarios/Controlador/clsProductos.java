/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import Inventarios.Modelo.daoBodegas;
import java.util.List;
import Inventarios.Modelo.daoProductos;
/**
 *
 * @author visitante
 */
public class clsProductos {
    private int IdProductos;
    private String NombreProductos;
    private String ExistenciaProducto;
    private String LinId;
    private String MarId;
    private String PrecioProductos;
    private String EstatusProductos;

    public int getIdProductos() {
        return IdProductos;
    }

    public void setIdProductos(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public String getNombreProductos() {
        return NombreProductos;
    }

    public void setNombreProductos(String NombreProductos) {
        this.NombreProductos = NombreProductos;
    }

    public String getExistenciaProducto() {
        return ExistenciaProducto;
    }

    public void setExistenciaProducto(String ExistenciaProducto) {
        this.ExistenciaProducto = ExistenciaProducto;
    }
    
    public String getLineaCodigo() {
        return LinId;
    }

    public void setLineaCodigo(String Linid) {
        this.LinId = Linid;
    }
    public String getMarcaCodigo() {
        return MarId;
    }

    public void setMarcaCodigo(String Marid) {
        this.MarId = Marid;
    }

    public String getPrecioProducto() {
        return PrecioProductos;
    }

    public void setPrecioProducto(String PrecioProducto) {
        this.PrecioProductos = PrecioProducto;
    }

    public String getEstatusProducto() {
        return EstatusProductos;
    }

    public void setEstatusProductos(String EstatusProductos) {
        this.EstatusProductos = EstatusProductos;
    }

    public clsProductos(int IdProducto, String Linid, String Marid, String NombreProducto, String ExistenciaProducto, String PrecioProducto, String EstatusProducto) {
        this.IdProductos = IdProducto;
        this.LinId = Linid;
        this.MarId = Marid;
        this.NombreProductos = NombreProducto;
        this.ExistenciaProducto = ExistenciaProducto;
        this.PrecioProductos = PrecioProducto;
        this.EstatusProductos = EstatusProducto;
    }

    public clsProductos(int IdProductos, String NombreProductos, String ExistenciaProducto, String PrecioProducto, String EstatusProducto, String Codigo) {
        this.IdProductos = IdProductos;
        this.NombreProductos = NombreProductos;
        this.ExistenciaProducto = ExistenciaProducto;
        this.PrecioProductos = PrecioProducto;
        this.EstatusProductos = EstatusProducto;
    }

    public clsProductos(int IdProductos, String NombreProductos, String ExistenciaProducto, String PrecioProductos) {
        this.IdProductos = IdProductos;
        this.NombreProductos = NombreProductos;
        this.ExistenciaProducto = ExistenciaProducto;
        this.PrecioProductos = PrecioProductos;
    }

    public clsProductos(int IdProductos, String NombreProductos, String ExistenciaProducto) {
        this.IdProductos = IdProductos;
        this.NombreProductos = NombreProductos;
        this.ExistenciaProducto = ExistenciaProducto;
    }

    public clsProductos(int IdProductos, String NombreProductos) {
        this.IdProductos = IdProductos;
        this.NombreProductos = NombreProductos;
    }

    public clsProductos(int IdProductos) {
        this.IdProductos = IdProductos;
    }

    public clsProductos() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsProductos getBuscarInformacionBodegasPorNombre(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.consultaProductosPorNombre(Productos);
    }
    public clsProductos getBuscarInformacionProductosPorId(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.consultaProductosPorId(Productos);
    }
    public List<clsProductos> getListadoProductos()
    {
        daoProductos daoproductos = new daoProductos();
        List<clsProductos> listadoProductos = daoproductos.consultaProductos();
        return listadoProductos;
    }
    public int setBorrarProductos(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.borrarProductos(Productos);
    }
    public int setIngresarProductos(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.ingresaProductos(Productos);
    }              
    public int setModificarProductos(clsProductos Productos)
    {
        daoProductos daoproductos = new daoProductos();
        return daoproductos.actualizaProductos(Productos);
    }

    public void add(List<clsBodegas> Bodegas) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
