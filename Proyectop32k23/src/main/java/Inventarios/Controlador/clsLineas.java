/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventarios.Controlador;
import java.util.List;
import Inventarios.Modelo.daoLineas;
/**
 *
 * @author visitante
 */
 /*Creado por María José Véliz Ochoa 9959-21-5909 */

public class clsLineas {
    private int linCodigo;
    private String linNombre;
    private int linPrecios;
    private String linEstatus;

    public int getlinCodigo() {
        return linCodigo;
    }

    public void setlinCodigo(int linCodigo) {
        this.linCodigo = linCodigo;
    }

    public String getlinNombre() {
        return linNombre;
    }

    public void setlinNombre(String linNombre) {
        this.linNombre = linNombre;
    }

    public int getlinPrecios() {
        return linPrecios;
    }

    public void setlinPrecios(int linPrecios) {
        this.linPrecios = linPrecios;
    }

    public String getLinEstatus() {
        return linEstatus;
    }

    public void setLinEstatus(String linEstatus) {
        this.linEstatus = linEstatus;
    }

    public clsLineas(int linCodigo, String linNombre, int linPrecios, String linEstatus) {
        this.linCodigo = linCodigo;
        this.linNombre = linNombre;
        this.linPrecios = linPrecios;
        this.linEstatus = linEstatus;
    }

    public clsLineas(int linCodigo, String linNombre, int linPrecios) {
        this.linCodigo = linCodigo;
        this.linNombre = linNombre;
        this.linPrecios = linPrecios;
    }

    public clsLineas(int linCodigo, String linNombre) {
        this.linCodigo = linCodigo;
        this.linNombre = linNombre;
    }

    public clsLineas(int linCodigo) {
        this.linCodigo = linCodigo;
    }

    public clsLineas() {
    }   

    
    @Override
    public String toString() {
        return "clsLineas{" + "linCodigo=" + linCodigo + ",linNombre=" + linNombre + ", linPrecios=" + linPrecios + ",linEstatus=" + linEstatus + '}';
    }
    //Metodos de acceso a la capa controlador
    public clsLineas getBuscarInformacionLineasporNombre(clsLineas lin)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.consultaLineasPorNombre(lin);
    }
    public clsLineas getBuscarInformacionLineasPorCodigo(clsLineas lin)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.consultaLineasPorcodigo(lin);
    }    
    public List<clsLineas> getListadoLineas()
    {
        daoLineas daolineas = new daoLineas();
        List<clsLineas> listadoLineas = daolineas.consultaLineas();
        return listadoLineas;
    }
    public int setBorrarLineas(clsLineas lin)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.borrarLineas(lin);
    }          
    public int setIngresarLineas(clsLineas lin)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.ingresaLineas(lin);
    }              
    public int setModificarLineas(clsLineas lin)
    {
        daoLineas daolineas = new daoLineas();
        return daolineas.actualizaLineas(lin);
    }              

    public void add(clsLineas lin) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
