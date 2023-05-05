/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas.Controlador;
import java.util.List;
import Ventas.Modelo.daoClientes;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsClientes {
    private int IdPerfil;
    private String NombrePerfil;
    private String EstatusPerfil;

    public clsClientes() {
    }

    public clsClientes(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public clsClientes(String NombrePerfil, String EstatusPerfil) {
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public clsClientes(int IdPerfil, String NombrePerfil, String EstatusPerfil) {
        this.IdPerfil = IdPerfil;
        this.NombrePerfil = NombrePerfil;
        this.EstatusPerfil = EstatusPerfil;
    }

    public int getIdPerfil() {
        return IdPerfil;
    }

    public void setIdPerfil(int IdPerfil) {
        this.IdPerfil = IdPerfil;
    }

    public String getNombrePerfil() {
        return NombrePerfil;
    }

    public void setNombrePerfil(String NombrePerfil) {
        this.NombrePerfil = NombrePerfil;
    }

    public String getEstatusPerfil() {
        return EstatusPerfil;
    }

    public void setEstatusPerfil(String EstatusPerfil) {
        this.EstatusPerfil = EstatusPerfil;
    }

    
    @Override
    public String toString() {
        return "clsClientes{" + "IdCliente=" + IdPerfil + ", NombreCliente=" + NombrePerfil + ", EstatusCliente=" + EstatusPerfil + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsClientes getBuscarInformacionPerfilPorNombre(clsClientes perfil)
    {
        daoClientes daoperfil = new daoClientes();
        return daoperfil.consultaPerfilPorNombre(perfil);
    }
    public clsClientes getBuscarInformacionPerfilPorId(clsClientes perfil)
    {
        daoClientes daoperfil = new daoClientes();
        return daoperfil.consultaPerfilPorId(perfil);
    }    
    public List<clsClientes> getListadoPerfiles()
    {
        daoClientes daoperfil = new daoClientes();
        List<clsClientes> listadoPerfiles = daoperfil.consultaPerfil();
        return listadoPerfiles;
    }
    public int setBorrarPerfil(clsClientes perfil)
    {
        daoClientes daoperfil = new daoClientes();
        return daoperfil.borrarPerfil(perfil);
    }          
    public int setIngresarPerfil(clsClientes perfil)
    {
        daoClientes daoperfil = new daoClientes();
        return daoperfil.ingresaPerfil(perfil);
    }              
    public int setModificarPerfil(clsClientes perfil)
    {
        daoClientes daoperfil = new daoClientes();
        return daoperfil.actualizaPerfil(perfil);
    }              
}
