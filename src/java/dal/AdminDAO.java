/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;

/**
 *
 * @author ACER-PC
 */
public class AdminDAO extends DBContext {
    
    public void add(String date, String mail, String nameCustomer,String address,String phone,int idProduct,String nameProduct,int quantity,BigDecimal priceProduct,String payment,int idCustomer) {
        try {
            String sql = "INSERT INTO Admin (date,mail,nameCustomer,address,phone,idProduct,nameProduct,quantity,priceProduct,payment,idCustomer) VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, mail);
            ps.setString(3, nameCustomer);
            ps.setString(4, address);
            ps.setString(5, phone);
            ps.setInt(6, idProduct);
            ps.setString(7, nameProduct);
            ps.setInt(8, quantity);
            ps.setBigDecimal(9, priceProduct);
            ps.setString(10, payment);
            ps.setInt(11,idCustomer);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Admin> getAll() {
        try {
            String sql = "SELECT * FROM Admin";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Admin> list = new ArrayList<>();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setDate(rs.getString("date"));
                admin.setMail(rs.getString("mail"));
                admin.setNameCustomer(rs.getString("nameCustomer"));
                admin.setAddress(rs.getString("address"));
                admin.setPhone(rs.getString("phone"));
                admin.setIdProduct(rs.getInt("idProduct"));
                admin.setNameProduct(rs.getString("nameProduct"));
                admin.setQuantity(rs.getInt("quantity"));
                admin.setPriceProduct(rs.getBigDecimal("priceProduct"));
                admin.setPayment(rs.getString("payment"));
                admin.setIdCustomer(rs.getInt("idCustomer"));
                list.add(admin);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public void delete(int id) {
        try {
            String sql = "DELETE FROM Admin WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public ArrayList<Admin> userOrders(int id) {
        try {
            String sql = "SELECT * FROM Admin where idCustomer = ? order by id desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Admin> list = new ArrayList<>();
            while (rs.next()) {
                Admin admin = new Admin();
                admin.setId(rs.getInt("id"));
                admin.setDate(rs.getString("date"));
                admin.setMail(rs.getString("mail"));
                admin.setNameCustomer(rs.getString("nameCustomer"));
                admin.setAddress(rs.getString("address"));
                admin.setPhone(rs.getString("phone"));
                admin.setIdProduct(rs.getInt("idProduct"));
                admin.setNameProduct(rs.getString("nameProduct"));
                admin.setQuantity(rs.getInt("quantity"));
                admin.setPriceProduct(rs.getBigDecimal("priceProduct"));
                admin.setPayment(rs.getString("payment"));
                admin.setIdCustomer(rs.getInt("idCustomer"));
                list.add(admin);
            } 
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
     }
}
