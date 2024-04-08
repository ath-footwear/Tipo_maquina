/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Modelo.Tmaquina;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GATEWAY1-
 */
public class sql_tmquina {

    public ArrayList<Tmaquina> get_allTmaquinas(Connection c, String name) {
        ArrayList<Tmaquina> arr = new ArrayList<>();
        try {
            PreparedStatement st;
            ResultSet rs;
            String sql = "select * from tipo_maquina"
                    + " where nombre_maquina like '%"+name+"%' and estatus='1'"
                    + "order by nombre_maquina";
            st = c.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                Tmaquina t = new Tmaquina();
                t.setId_Tmaquina(rs.getInt("id_tipomaquina"));
                t.setDescripcion(rs.getString("nombre_maquina"));
                t.setEstatus(rs.getString("estatus"));
                arr.add(t);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public boolean new_Tmaquina(Connection c, Tmaquina t) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "insert into tipo_maquina(nombre_maquina,estatus) "
                    + "values(?,?)";
            st = c.prepareStatement(sql);
            st.setString(1, t.getDescripcion());
            st.setString(2, "1");
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean update_Tmaquina(Connection c, Tmaquina t) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update tipo_maquina set nombre_maquina=? "
                    + "where id_tipomaquina=?";
            st = c.prepareStatement(sql);
            st.setString(1, t.getDescripcion());
            st.setInt(2, t.getId_Tmaquina());
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }

    public boolean baja_Tmaquina(Connection c, int id) {
        try {
            c.setAutoCommit(false);
            PreparedStatement st;
            String sql = "update tipo_maquina set estatus=? "
                    + "where id_tipomaquina=?";
            st = c.prepareStatement(sql);
            st.setString(1, "0");
            st.setInt(2, id);
            st.executeUpdate();
            c.commit();
            st.close();
            return true;
        } catch (SQLException ex) {
            try {
                c.rollback();
                Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(sql_tmquina.class.getName()).log(Level.SEVERE, null, ex1);
            }
            return false;
        }
    }
}
