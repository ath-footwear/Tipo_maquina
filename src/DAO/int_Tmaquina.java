/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Tmaquina;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author GATEWAY1-
 */
public interface int_Tmaquina {

    public ArrayList<Tmaquina> get_allTmaquinas(Connection c, String name);

    public boolean new_Tmaquina(Connection c, Tmaquina t);

    public boolean update_Tmaquina(Connection c, Tmaquina t);

    public boolean baja_Tmaquina(Connection c, int id);
}
