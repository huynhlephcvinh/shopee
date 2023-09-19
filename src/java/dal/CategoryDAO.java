/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author ACER-PC
 */
public class CategoryDAO extends DBContext {
     public ArrayList<Category> getAll() {
         try {
             String sql = "SELECT * FROM Category";
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             
             ArrayList<Category> list = new ArrayList<>();
             while(rs.next()) {
                 Category category = new Category(rs.getInt("id"), rs.getString("name"));
                 list.add(category);
             }
             rs.close();
             ps.close();
             return list;
         } catch (SQLException ex) {
             Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
     }
}
