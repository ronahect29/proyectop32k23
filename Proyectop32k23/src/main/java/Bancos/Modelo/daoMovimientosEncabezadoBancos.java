/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Modelo;

import Bancos.Controlador.clsMovimientosEncabezadoBancos;
import Seguridad.Modelo.Conexion;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author visitante
 */
public class daoMovimientosEncabezadoBancos {

    private static final String SQL_SELECT = "SELECT movId, codBanco, cueId, tipMovId, movFecha, cueEmId FROM tbl_movimientosEncabezadoBancos";
    private static final String SQL_INSERT = "INSERT INTO tbl_movimientosEncabezadoBancos(movId, codBanco, cueId, tipMovId, movFecha, cueEmId) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_movimientosEncabezadoBancos SET codBanco=?, cueId=?,  tipMovId=?, movFecha=?,  cueEmId=?  WHERE movId = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_movimientosEncabezadoBancos WHERE movId=?";
    private static final String SQL_SELECT_NOMBRE = "SELECT movId, cueId, tipMovId, movFecha, cueEmId  FROM tbl_movimientosEncabezadoBancos WHERE  codBanco = ?";
    private static final String SQL_SELECT_ID = "SELECT codBanco, cueId, tipMovId, movFecha, cueEmId  FROM tbl_movimientosEncabezadoBancos WHERE movId = ?";     


