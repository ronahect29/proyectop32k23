/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seguridad.Controlador;
import java.util.List;
import Seguridad.Modelo.daoUsuario;
/**
 *
 * @author visitante
 */
public class clsUsuario {
    private int IdUsuario;
    private String NombreUsuario;
    private String ContrasenaUsuario;
    private long UltimaSesionUsuario;
    private String EstatusUsuario;
    private String NombreRealUsuario;
    private String CorreoUsuario;
    private String TelefonoUsuario;
    private String DireccionUsuario;

    public clsUsuario() {
    }

    public clsUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, long UltimaSesionUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, long UltimaSesionUsuario, String EstatusUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, long UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, long UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario, String CorreoUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
        this.CorreoUsuario = CorreoUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, long UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario, String CorreoUsuario, String TelefonoUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
    }

    public clsUsuario(int IdUsuario, String NombreUsuario, String ContrasenaUsuario, long UltimaSesionUsuario, String EstatusUsuario, String NombreRealUsuario, String CorreoUsuario, String TelefonoUsuario, String DireccionUsuario) {
        this.IdUsuario = IdUsuario;
        this.NombreUsuario = NombreUsuario;
        this.ContrasenaUsuario = ContrasenaUsuario;
        this.UltimaSesionUsuario = UltimaSesionUsuario;
        this.EstatusUsuario = EstatusUsuario;
        this.NombreRealUsuario = NombreRealUsuario;
        this.CorreoUsuario = CorreoUsuario;
        this.TelefonoUsuario = TelefonoUsuario;
        this.DireccionUsuario = DireccionUsuario;
    }
    
    @Override
    public String toString() {
        return "clsUsuario{" + "IdUsuario=" + IdUsuario + ", NombreUsuario=" + NombreUsuario + ", ContrasenaUsuario=" + ContrasenaUsuario + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsUsuario getBuscarInformacionUsuarioPorNombre(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.consultaUsuariosPorNombre(usuario);
    }
    public clsUsuario getBuscarInformacionUsuarioPorId(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.consultaUsuariosPorId(usuario);
    }    
    public List<clsUsuario> getListadoUsuarios()
    {
        daoUsuario daousuario = new daoUsuario();
        List<clsUsuario> listadoUsuarios = daousuario.consultaUsuarios();
        return listadoUsuarios;
    }
    public int setBorrarUsuario(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.borrarUsuarios(usuario);
    }          
    public int setIngresarUsuario(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.ingresaUsuarios(usuario);
    }              
    public int setModificarUsuario(clsUsuario usuario)
    {
        daoUsuario daousuario = new daoUsuario();
        return daousuario.actualizaUsuarios(usuario);
    }              
}
