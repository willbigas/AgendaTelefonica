/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.negocio;

import br.com.agendatelefonica.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class SessionFactory {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection(
                "jdbc:mysql://localhost/agendaTelefonicaProva", "root", "");
    }

    public static void fecharConexao(Connection conn, PreparedStatement ps,
            ResultSet rs) {
        try {
            conn.close();
            ps.close();
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar conexao " + ex.getMessage());
        }
    }
}
