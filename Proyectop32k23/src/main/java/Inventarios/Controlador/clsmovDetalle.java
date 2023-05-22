/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daomovDetalle;

/**
 *
 * @author visitante
 */
public class clsmovDetalle {
    private int IdEncabezado;
    private int IdProducto;
    private int cantidadesDetalles;
    private int muestrasDetalles;
    private int trasladosDetalles;

    public int getIdEncabezado() {
        return IdEncabezado;
    }

    public void setIdEncabezado(int IdEncabezado) {
        this.IdEncabezado = IdEncabezado;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidadesDetalles() {
        return cantidadesDetalles;
    }

    public void setCantidadesDetalles(int cantidadesDetalles) {
        this.cantidadesDetalles = cantidadesDetalles;
    }

    public int getMuestrasDetalles() {
        return muestrasDetalles;
    }

    public void setMuestrasDetalles(int muestrasDetalles) {
        this.muestrasDetalles = muestrasDetalles;
    }

    public int getTrasladosDetalles() {
        return trasladosDetalles;
    }

    public void setTrasladosDetalles(int trasladosDetalles) {
        this.trasladosDetalles = trasladosDetalles;
    }

    public clsmovDetalle(int IdEncabezado, int IdProducto, int cantidadesDetalles, int muestrasDetalles, int trasladosDetalles) {
        this.IdEncabezado = IdEncabezado;
        this.IdProducto = IdProducto;
        this.cantidadesDetalles = cantidadesDetalles;
        this.muestrasDetalles = muestrasDetalles;
        this.trasladosDetalles = trasladosDetalles;
    }

    public clsmovDetalle(int IdEncabezado, int IdProducto, int cantidadesDetalles, int muestrasDetalles) {
        this.IdEncabezado = IdEncabezado;
        this.IdProducto = IdProducto;
        this.cantidadesDetalles = cantidadesDetalles;
        this.muestrasDetalles = muestrasDetalles;
    }

    public clsmovDetalle(int IdEncabezado, int IdProducto, int cantidadesDetalles) {
        this.IdEncabezado = IdEncabezado;
        this.IdProducto = IdProducto;
        this.cantidadesDetalles = cantidadesDetalles;
    }

    public clsmovDetalle(int IdEncabezado, int IdProducto) {
        this.IdEncabezado = IdEncabezado;
        this.IdProducto = IdProducto;
    }

    public clsmovDetalle(int IdEncabezado) {
        this.IdEncabezado = IdEncabezado;
    }

    public clsmovDetalle() {
    }


    //Metodos de acceso a la capa controlador
    /*public clsmovDetalle getBuscarInformacionDetallesPorNombre(clsmovDetalle detalles)
    {
        daomovDetalle daomovdetalle = new daomovDetalle();
        return daomovdetalle.consultaDetallesPorNombre(detalles);
    }*/
    public clsmovDetalle getBuscarInformacionDetallesPorId(clsmovDetalle detalles)
    {
        daomovDetalle daomovdetalle = new daomovDetalle();
        return daomovdetalle.consultaDetallesPorId(detalles);
    }
    public List<clsmovDetalle> getListadoDetalles()
    {
         daomovDetalle daomovdetalle = new daomovDetalle();
        List<clsmovDetalle> listadoDetalles = daomovdetalle.consultaDetalles();
        return listadoDetalles;
    }
    public int setBorrarDetalles(clsmovDetalle detalles)
    {
        daomovDetalle daomovdetalle = new daomovDetalle();
        return daomovdetalle.borrarDetalles(detalles);
    }
    public int setIngresarDetalles(clsmovDetalle detalles)
    {
        daomovDetalle daomovdetalle = new daomovDetalle();
        return daomovdetalle.ingresaDetalles (detalles);
    }              
    public int setModificarDetalles(clsmovDetalle detalles)
    {
        daomovDetalle daomovdetalle = new daomovDetalle();
        return daomovdetalle.actualizaDetalles(detalles);
    }

    public void add(List<clsmovDetalle> detalles) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

    
