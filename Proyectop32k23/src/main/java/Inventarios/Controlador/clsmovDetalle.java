/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoBodegas;

/**
 *
 * @author visitante
 */
public class clsmovDetalle {
    private int IdBodegas;
    private String NombreBodegas;
    private String DescripcionBodega;
    private String fIngresoBodega;
    private String fSalidaBodega;
    private String EstatusBodegas;

    public int getIdBodegas() {
        return IdBodegas;
    }

    public void setIdBodegas(int IdBodegas) {
        this.IdBodegas = IdBodegas;
    }

    public String getNombreBodegas() {
        return NombreBodegas;
    }

    public void setNombreBodegas(String NombreBodegas) {
        this.NombreBodegas = NombreBodegas;
    }

    public String getDescripcionBodega() {
        return DescripcionBodega;
    }

    public void setDescripcionBodega(String DescripcionBodega) {
        this.DescripcionBodega = DescripcionBodega;
    }

    public String getfIngresoBodega() {
        return fIngresoBodega;
    }

    public void setfIngresoBodega(String fIngresoBodega) {
        this.fIngresoBodega = fIngresoBodega;
    }

    public String getfSalidaBodega() {
        return fSalidaBodega;
    }

    public void setfSalidaBodega(String fSalidaBodega) {
        this.fSalidaBodega = fSalidaBodega;
    }

    public String getEstatusBodegas() {
        return EstatusBodegas;
    }

    public void setEstatusBodegas(String EstatusBodegas) {
        this.EstatusBodegas = EstatusBodegas;
    }

    public clsmovDetalle(int IdBodegas, String NombreBodegas, String DescripcionBodega, String fIngresoBodega, String fSalidaBodega) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
        this.fIngresoBodega = fIngresoBodega;
        this.fSalidaBodega = fSalidaBodega;
    }

    public clsmovDetalle(int IdBodegas, String NombreBodegas, String DescripcionBodega, String fIngresoBodega, String fSalidaBodega, String EstatusBodegas) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
        this.fIngresoBodega = fIngresoBodega;
        this.fSalidaBodega = fSalidaBodega;
        this.EstatusBodegas = EstatusBodegas;
    }

    public clsmovDetalle(int IdBodegas, String NombreBodegas, String DescripcionBodega, String fIngresoBodega) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
        this.fIngresoBodega = fIngresoBodega;
    }

    public clsmovDetalle(int IdBodegas, String NombreBodegas, String DescripcionBodega) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
        this.DescripcionBodega = DescripcionBodega;
    }

    public clsmovDetalle(int IdBodegas, String NombreBodegas) {
        this.IdBodegas = IdBodegas;
        this.NombreBodegas = NombreBodegas;
    }

    public clsmovDetalle(int IdBodegas) {
        this.IdBodegas = IdBodegas;
    }

    public clsmovDetalle() {
    }

    
    //Metodos de acceso a la capa controlador
    public clsmovDetalle getBuscarInformacionDetallesPorNombre(clsmovDetalle detalles)
    {
        daomovDetalle daomovdetalle = new daomovDetalle();
        return daomovdetalle.consultaDetallesPorNombre(detalles);
    }
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

    
