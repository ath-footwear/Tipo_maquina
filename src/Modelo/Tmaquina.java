/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author GATEWAY1-
 */
public class Tmaquina implements java.io.Serializable{
    private int id_Tmaquina;
    private String descripcion, estatus;

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getId_Tmaquina() {
        return id_Tmaquina;
    }

    public void setId_Tmaquina(int id_Tmaquina) {
        this.id_Tmaquina = id_Tmaquina;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
