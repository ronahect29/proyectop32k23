/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Hecho por: Karla Sofia Góomez Tobar 9959-21-1896
package Bancos.Controlador;
import java.util.List;
import Bancos.Modelo.daoMovimientosEncabezadoBancos;
/**
 *
 * @author visitante
 */
public class clsMovimientosEncabezadoBancos {
    private int movId;
    private int codBanco;
    private int cueId;
    private int tipMovId;
    private String movFecha;
    private int cueEmId;

    public clsMovimientosEncabezadoBancos() {
    }

    public clsMovimientosEncabezadoBancos(int movId) {
        this.movId = movId;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco) {
        this.movId = movId;
        this.codBanco = codBanco;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId, int tipMovId) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
        this.tipMovId = tipMovId;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId, int tipMovId, String movFecha) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
        this.tipMovId = tipMovId;
        this.movFecha = movFecha;
    }

    public clsMovimientosEncabezadoBancos(int movId, int codBanco, int cueId, int tipMovId, String movFecha, int cueEmId) {
        this.movId = movId;
        this.codBanco = codBanco;
        this.cueId = cueId;
        this.tipMovId = tipMovId;
        this.movFecha = movFecha;
        this.cueEmId = cueEmId;
    }
