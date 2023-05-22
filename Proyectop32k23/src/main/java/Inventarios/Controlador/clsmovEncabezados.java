/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daomovEncabezados;
import com.toedter.calendar.JDateChooser;
/**
 *
 * @author visitante
 */
public class clsmovEncabezados {
    private int idEncabezado;
    private int idMovimiento;
    private String fechaMovimiento;
    private String estatusMovimiento;

    public int getIdEncabezado() {
        return idEncabezado;
    }

    public void setIdEncabezado(int idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getEstatusMovimiento() {
        return estatusMovimiento;
    }

    public void setEstatusMovimiento(String estatusMovimiento) {
        this.estatusMovimiento = estatusMovimiento;
    }

    public clsmovEncabezados(int idEncabezado, int idMovimiento, String fechaMovimiento, String estatusMovimiento) {
        this.idEncabezado = idEncabezado;
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.estatusMovimiento = estatusMovimiento;
    }

    public clsmovEncabezados(int idEncabezado, int idMovimiento, String fechaMovimiento) {
        this.idEncabezado = idEncabezado;
        this.idMovimiento = idMovimiento;
        this.fechaMovimiento = fechaMovimiento;
    }

    public clsmovEncabezados(int idEncabezado, int idMovimiento) {
        this.idEncabezado = idEncabezado;
        this.idMovimiento = idMovimiento;
    }

    public clsmovEncabezados(int idEncabezado) {
        this.idEncabezado = idEncabezado;
    }

    public clsmovEncabezados() {
    }   

    
    //Metodos de acceso a la capa controlador
    public clsmovEncabezados getBuscarInformacionMovimientosPorNombre(clsmovEncabezados mov)
    {
        daomovEncabezados daomovencabezados = new daomovEncabezados();
        return daomovencabezados.consultaBodegasPorNombre(mov);
    }
    public clsmovEncabezados getBuscarInformacionMovimientosPorId(clsmovEncabezados mov)
    {
        daomovEncabezados daomovencabezados = new daomovEncabezados();
        return daomovencabezados.consultaMovimientosPorId(mov);
    }
    public List<clsmovEncabezados> getListadoMovimientos()
    {
        daomovEncabezados daomovencabezados = new daomovEncabezados();
        List<clsmovEncabezados> listadoMovimientos = daomovencabezados.consultaMovimientos();
        return listadoMovimientos;
    }
    public int setBorrarMovimientos(clsmovEncabezados mov)
    {
        daomovEncabezados daomovencabezados = new daomovEncabezados();
        return daomovencabezados.borrarMovimientos(mov);
    }
    public int setIngresarMovimientos(clsmovEncabezados mov)
    {
        daomovEncabezados daomovencabezados = new daomovEncabezados();
        return daomovencabezados.ingresaMovimientos(mov);
    }              
    public int setModificarMovimientos(clsmovEncabezados mov)
    {
        daomovEncabezados daomovencabezados = new daomovEncabezados();
        return daomovencabezados.actualizaMovimientos(mov);
    }

    public void add(List<clsmovEncabezados> mov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setgeinicial(JDateChooser finicial) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
