/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoMovimientos;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsMovimientos {
    private int movCodigo;
    private String movDescripcion;
    private int movEfecto;
    private String movEstatus;

    public int getMovCodigo() {
        return movCodigo;
    }

    public void setMovCodigo(int movCodigo) {
        this.movCodigo = movCodigo;
    }

    public String getMovDescripcion() {
        return movDescripcion;
    }

    public void setMovDescripcion(String movDescripcion) {
        this.movDescripcion = movDescripcion;
    }

    public int getMovEfecto() {
        return movEfecto;
    }

    public void setMovEfecto(int movEfecto) {
        this.movEfecto = movEfecto;
    }

    public String getMovEstatus() {
        return movEstatus;
    }

    public void setMovEstatus(String movEstatus) {
        this.movEstatus = movEstatus;
    }

    public clsMovimientos(int movCodigo, String movDescripcion, int movEfecto, String movEstatus) {
        this.movCodigo = movCodigo;
        this.movDescripcion = movDescripcion;
        this.movEfecto = movEfecto;
        this.movEstatus = movEstatus;
    }

    public clsMovimientos(int movCodigo, String movDescripcion, int movEfecto) {
        this.movCodigo = movCodigo;
        this.movDescripcion = movDescripcion;
        this.movEfecto = movEfecto;
    }

    public clsMovimientos(int movCodigo, String movDescripcion) {
        this.movCodigo = movCodigo;
        this.movDescripcion = movDescripcion;
    }

    public clsMovimientos(int movCodigo) {
        this.movCodigo = movCodigo;
    }

    public clsMovimientos() {
    }   

    
    @Override
    public String toString() {
        return "clsMovimientos{" + "movCodigo=" + movCodigo + ",movDescripcion=" + movDescripcion + ", movEfecto=" + movEfecto + ",movEstatus=" + movEstatus + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsMovimientos getBuscarInformacionMovimientosporNombre(clsMovimientos mov)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.consultaMovimientosPorNombre(mov);
    }
    public clsMovimientos getBuscarInformacionMovimientoPorCodigo(clsMovimientos mov)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.consultaMovimientosPorcodigo(mov);
    }    
    public List<clsMovimientos> getListadoMovimientos()
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        List<clsMovimientos> listadomovimientos = daomovimientos.consultaMovimientos();
        return listadomovimientos;
    }
    public int setBorrarMovimientos(clsMovimientos mov)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.borrarMovimientos(mov);
    }          
    public int setIngresarMovimientos(clsMovimientos mov)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.ingresaMovimientos(mov);
    }              
    public int setModificarLineas(clsMovimientos mov)
    {
        daoMovimientos daomovimientos = new daoMovimientos();
        return daomovimientos.actualizaMovimientos(mov);
    }              

    public void add(clsMovimientos mov) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
