/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ACER-PC
 */
public class AccountDAO extends DBContext {

    public void createAccount(String mail, String name, String password, int roleId) {
        try {
            String sql = "INSERT INTO Account (mail, name, password, role) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mail);
            ps.setString(2, name);
            ps.setString(3, password);
            ps.setInt(4, roleId);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //Check mail

    public Account getByMail(String mail) {
        try {
            String sql = "SELECT * FROM Account WHERE mail = ? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mail);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account account = new Account(rs.getString("mail"), rs.getString("name"), rs.getString("password"), rs.getInt("role"),rs.getInt("id"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //Check mail and password
    public Account getByMailPassword(String mail, String password) {
        try {
            String sql = "SELECT * FROM Account WHERE mail= ? AND password= ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, mail);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Account account = new Account(rs.getString("mail"), rs.getString("name"), rs.getString("password"),rs.getInt("role"),rs.getInt("id"));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
