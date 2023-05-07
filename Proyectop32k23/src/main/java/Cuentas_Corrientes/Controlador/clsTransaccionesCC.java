/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuentas_Corrientes.Controlador;
import Cuentas_Corrientes.Modelo.daoTransaccionesCC;
import java.util.List;
/**
 *
 * @author visitante
 */
 //Creado por Alan Abimael Galicia Ruano; 9959-21-3632

public class clsTransaccionesCC {
    private int CodigoT;
    private String NombreT;
    private String EstatusT;
    private String EfectoT;

    public int getCodigoT() {
        return CodigoT;
    }

    public void setCodigoT(int CodigoT) {
        this.CodigoT = CodigoT;
    }

    public String getNombreT() {
        return NombreT;
    }

    public void setNombreT(String NombreT) {
        this.NombreT = NombreT;
    }

    public String getEstatusT() {
        return EstatusT;
    }

    public void setEstatusT(String EstatusT) {
        this.EstatusT = EstatusT;
    }

    public String getEfectoT() {
        return EfectoT;
    }

    public void setEfectoT(String EfectoT) {
        this.EfectoT = EfectoT;
    }

    public clsTransaccionesCC(int CodigoT, String NombreT, String EstatusT, String EfectoT) {
        this.CodigoT = CodigoT;
        this.NombreT = NombreT;
        this.EstatusT = EstatusT;
        this.EfectoT = EfectoT;
    }

    public clsTransaccionesCC(int CodigoT, String NombreT, String EstatusT) {
        this.CodigoT = CodigoT;
        this.NombreT = NombreT;
        this.EstatusT = EstatusT;
    }

    public clsTransaccionesCC(int CodigoT, String NombreT) {
        this.CodigoT = CodigoT;
        this.NombreT = NombreT;
    }

    public clsTransaccionesCC(int CodigoT) {
        this.CodigoT = CodigoT;
    }

    public clsTransaccionesCC() {
    }
    
    @Override
    public String toString() {
        return "clsTransaccionesCC{" + "CodigoT=" + CodigoT + ", NombreT=" + NombreT + ", EstatusT=" + EstatusT + ", EfectoT=" + EfectoT +'}';
    }
    //Metodos de acceso a la capa controlador
    public clsTransaccionesCC getBuscarInformacionTrPorNombre(clsTransaccionesCC transaccion)
    {
        daoTransaccionesCC daoTransaccionesCC = new daoTransaccionesCC();
        return daoTransaccionesCC.consultaTrPorNombre(transaccion);
    }
    public clsTransaccionesCC getBuscarInformacionTrPorId(clsTransaccionesCC transaccion)
    {
        daoTransaccionesCC daoTransaccionesCC = new daoTransaccionesCC();
        return daoTransaccionesCC.consultaTrPorId(transaccion);
    }    
    public List<clsTransaccionesCC> getListadoT()
    {
        daoTransaccionesCC daoTransaccionesCC = new daoTransaccionesCC();
        List<clsTransaccionesCC> listadoTransacciones = daoTransaccionesCC.consultaT();
        return listadoTransacciones;
    }
    public int setBorrarT(clsTransaccionesCC transaccion)
    {
        daoTransaccionesCC daoTransaccionesCC = new daoTransaccionesCC();
        return daoTransaccionesCC.borrarT(transaccion);
    }          
    public int setIngresarT(clsTransaccionesCC transaccion)
    {
        daoTransaccionesCC daoTransaccionesCC = new daoTransaccionesCC();
        return daoTransaccionesCC.ingresaT(transaccion);
    }              
    public int setModificarT(clsTransaccionesCC transaccion)
    {
        daoTransaccionesCC daoTransaccionesCC = new daoTransaccionesCC();
        return daoTransaccionesCC.actualizaT(transaccion);
    }              
}