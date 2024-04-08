/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Tmaquina;
import Persistencia.sql_tmquina;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public class dao_tmaquina implements int_Tmaquina {

    private sql_tmquina s;

    public dao_tmaquina() {
        this.s = new sql_tmquina();
    }

    /**
     * Obtiene todas las maquinas activas y las busca mediante la descripcion
     *
     * @param c Conexion cpt
     * @param name Descrpcion a buscar
     * @return Arraylist
     */
    @Override
    public ArrayList<Tmaquina> get_allTmaquinas(Connection c, String name) {
        return s.get_allTmaquinas(c, name);
    }

    /**
     * Inserta un nuevo registro de tipo Tmaquina en la bd
     *
     * @param c conexion cpt
     * @param t Objeto Tmaquina
     * @return boolean
     */
    @Override
    public boolean new_Tmaquina(Connection c, Tmaquina t) {
        return s.new_Tmaquina(c, t);
    }

    /**
     * Actualiza el nombre del tipo de maquina
     *
     * @param c conexion cpt
     * @param t Objeto tipo Tmaquina
     * @return boolean
     */
    @Override
    public boolean update_Tmaquina(Connection c, Tmaquina t) {
        return s.update_Tmaquina(c, t);
    }

    /**
     * Da de baja el tipo de maquina
     *
     * @param c conexion cpt
     * @param id Id de la maquina
     * @return boolean
     */
    @Override
    public boolean baja_Tmaquina(Connection c, int id) {
        return s.baja_Tmaquina(c, id);
    }

}
