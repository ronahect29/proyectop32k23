/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Meyglin del Rosario Rosales Ochoa 
// 9959 - 21 - 4490 

package Ventas.Controlador;
import java.util.List;
import Ventas.Modelo.daoVendedores;
import javax.swing.table.DefaultTableModel;
import Ventas.Modelo.daoCotizacion;
import java.util.ArrayList;
/**
 *
 * @author visitante
 */

public class clsCotizacion {
    
    
    public double obtenerPrecioProducto(int codigoProducto) {
    daoCotizacion dao = new daoCotizacion();
    return dao.obtenerPrecioProducto(codigoProducto);
} 
    public int verificarExistencias(int codigoProducto) {
    daoCotizacion dao = new daoCotizacion();
    return dao.verificarExistencias(codigoProducto);
}   
}
