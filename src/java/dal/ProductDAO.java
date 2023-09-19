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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Product;

/**
 *
 * @author ACER-PC
 */
public class ProductDAO extends DBContext {

    public ArrayList<Product> getAll() {

        try {
            String sql = "SELECT * FROM Product";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImg(rs.getString("img"));
                product.setName(rs.getString("name"));
                product.setPriceOld(rs.getBigDecimal("priceOld"));
                product.setPriceNew(rs.getBigDecimal("priceNew"));
                product.setSold(rs.getInt("sold"));
                product.setBrand(rs.getString("brand"));
                product.setOrigin(rs.getString("origin"));
                product.setSale(rs.getInt("sale"));
                product.setDescription(rs.getString("description"));
                product.setOnOffSale(rs.getBoolean("onOffSale"));
                product.setYeuThich(rs.getBoolean("YeuThich"));
                product.setCategory(rs.getInt("category"));
                list.add(product);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getAllDescId() {

        try {
            String sql = "SELECT * FROM Product order by id desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImg(rs.getString("img"));
                product.setName(rs.getString("name"));
                product.setPriceOld(rs.getBigDecimal("priceOld"));
                product.setPriceNew(rs.getBigDecimal("priceNew"));
                product.setSold(rs.getInt("sold"));
                product.setBrand(rs.getString("brand"));
                product.setOrigin(rs.getString("origin"));
                product.setSale(rs.getInt("sale"));
                product.setDescription(rs.getString("description"));
                product.setOnOffSale(rs.getBoolean("onOffSale"));
                product.setYeuThich(rs.getBoolean("YeuThich"));
                product.setCategory(rs.getInt("category"));
                list.add(product);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getAllDescSold() {

        try {
            String sql = "SELECT * FROM Product order by sold desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImg(rs.getString("img"));
                product.setName(rs.getString("name"));
                product.setPriceOld(rs.getBigDecimal("priceOld"));
                product.setPriceNew(rs.getBigDecimal("priceNew"));
                product.setSold(rs.getInt("sold"));
                product.setBrand(rs.getString("brand"));
                product.setOrigin(rs.getString("origin"));
                product.setSale(rs.getInt("sale"));
                product.setDescription(rs.getString("description"));
                product.setOnOffSale(rs.getBoolean("onOffSale"));
                product.setYeuThich(rs.getBoolean("YeuThich"));
                product.setCategory(rs.getInt("category"));
                list.add(product);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> getAllProductCategory(int idCategory) {

        try {
            String sql = "SELECT * from Product where category = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, idCategory);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImg(rs.getString("img"));
                product.setName(rs.getString("name"));
                product.setPriceOld(rs.getBigDecimal("priceOld"));
                product.setPriceNew(rs.getBigDecimal("priceNew"));
                product.setSold(rs.getInt("sold"));
                product.setBrand(rs.getString("brand"));
                product.setOrigin(rs.getString("origin"));
                product.setSale(rs.getInt("sale"));
                product.setDescription(rs.getString("description"));
                product.setOnOffSale(rs.getBoolean("onOffSale"));
                product.setYeuThich(rs.getBoolean("YeuThich"));
                product.setCategory(rs.getInt("category"));
                list.add(product);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> sortPriceLowToHigh() {
        try {
            String sql = "select * from Product ORDER BY priceNew ASC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImg(rs.getString("img"));
                product.setName(rs.getString("name"));
                product.setPriceOld(rs.getBigDecimal("priceOld"));
                product.setPriceNew(rs.getBigDecimal("priceNew"));
                product.setSold(rs.getInt("sold"));
                product.setBrand(rs.getString("brand"));
                product.setOrigin(rs.getString("origin"));
                product.setSale(rs.getInt("sale"));
                product.setDescription(rs.getString("description"));
                product.setOnOffSale(rs.getBoolean("onOffSale"));
                product.setYeuThich(rs.getBoolean("YeuThich"));
                product.setCategory(rs.getInt("category"));
                list.add(product);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Product> sortPriceHighToLow() {
        try {
            String sql = "select * from Product ORDER BY priceNew DESC";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setImg(rs.getString("img"));
                product.setName(rs.getString("name"));
                product.setPriceOld(rs.getBigDecimal("priceOld"));
                product.setPriceNew(rs.getBigDecimal("priceNew"));
                product.setSold(rs.getInt("sold"));
                product.setBrand(rs.getString("brand"));
                product.setOrigin(rs.getString("origin"));
                product.setSale(rs.getInt("sale"));
                product.setDescription(rs.getString("description"));
                product.setOnOffSale(rs.getBoolean("onOffSale"));
                product.setYeuThich(rs.getBoolean("YeuThich"));
                product.setCategory(rs.getInt("category"));
                list.add(product);
            }
            rs.close();
            ps.close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product get(int id) {
        try {
            String sql = "SELECT * FROM Product WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            rs.next();
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setImg(rs.getString("img"));
            product.setName(rs.getString("name"));
            product.setPriceOld(rs.getBigDecimal("priceOld"));
            product.setPriceNew(rs.getBigDecimal("priceNew"));
            product.setSold(rs.getInt("sold"));
            product.setBrand(rs.getString("brand"));
            product.setOrigin(rs.getString("origin"));
            product.setSale(rs.getInt("sale"));
            product.setDescription(rs.getString("description"));
            product.setOnOffSale(rs.getBoolean("onOffSale"));
            product.setYeuThich(rs.getBoolean("YeuThich"));
            product.setCategory(rs.getInt("category"));
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product getProductNew() {
        try {
            String sql = "SELECT TOP(1)* FROM Product order by id desc";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setImg(rs.getString("img"));
            product.setName(rs.getString("name"));
            product.setPriceOld(rs.getBigDecimal("priceOld"));
            product.setPriceNew(rs.getBigDecimal("priceNew"));
            product.setSold(rs.getInt("sold"));
            product.setBrand(rs.getString("brand"));
            product.setOrigin(rs.getString("origin"));
            product.setSale(rs.getInt("sale"));
            product.setDescription(rs.getString("description"));
            product.setOnOffSale(rs.getBoolean("onOffSale"));
            product.setYeuThich(rs.getBoolean("YeuThich"));
            product.setCategory(rs.getInt("category"));
            return product;
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM Product WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
        List<Cart> products = new ArrayList<Cart>();
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {

                    String sql = "select * from Product where id=? ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, item.getId());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setImg(rs.getString("img"));
                        row.setName(rs.getString("name"));
                        row.setBrand(rs.getString("brand"));
                        row.setPriceNew(rs.getBigDecimal("priceNew").multiply(BigDecimal.valueOf(item.getQuantity())));
                        row.setQuantity(item.getQuantity());
                        products.add(row);
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }

    public BigDecimal getTotalCartPrice(ArrayList<Cart> cartList) {
        BigDecimal sum = BigDecimal.valueOf(0);
        try {
            if (cartList.size() > 0) {
                for (Cart item : cartList) {

                    String sql = "select priceNew from Product where id=? ";
                    PreparedStatement ps = connection.prepareStatement(sql);
                    ps.setInt(1, item.getId());
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        sum = sum.add(rs.getBigDecimal("priceNew").multiply(BigDecimal.valueOf(item.getQuantity())));
                    }

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }

    public void add(String img, String name, BigDecimal priceOld, BigDecimal priceNew, String brand, String origin, int sale, String description, boolean onOffSale, int category) {
        try {
            int sold = 0;
            boolean yeuThich = false;
            String sql = "INSERT INTO Product (img,name,priceOld,priceNew,sold,brand,origin,sale,description,onOffSale,yeuThich,category) VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, img);
            ps.setString(2, name);
            ps.setBigDecimal(3, priceOld);
            ps.setBigDecimal(4, priceNew);
            ps.setInt(5, sold);
            ps.setString(6, brand);
            ps.setString(7, origin);
            ps.setInt(8, sale);
            ps.setString(9, description);
            ps.setBoolean(10, onOffSale);
            ps.setBoolean(11, yeuThich);
            ps.setInt(12,category);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(int id, String img, String name, BigDecimal priceOld, BigDecimal priceNew, String brand, String origin, int sale, String description, boolean onOffSale) {
        try {
            String sql = "UPDATE Product SET img = ?,name= ?,priceOld= ?,priceNew= ?,brand= ?,origin= ?,sale= ?,description= ?,onOffSale=? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, img);
            ps.setString(2, name);
            ps.setBigDecimal(3, priceOld);
            ps.setBigDecimal(4, priceNew);
            ps.setString(5, brand);
            ps.setString(6, origin);
            ps.setInt(7, sale);
            ps.setString(8, description);
            ps.setBoolean(9, onOffSale);
            ps.setInt(10, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateVer2(int id, String name, BigDecimal priceOld, BigDecimal priceNew, String brand, String origin, int sale, String description, boolean onOffSale) {
        try {
            String sql = "UPDATE Product SET name= ?,priceOld= ?,priceNew= ?,brand= ?,origin= ?,sale= ?,description= ?,onOffSale=? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setBigDecimal(2, priceOld);
            ps.setBigDecimal(3, priceNew);
            ps.setString(4, brand);
            ps.setString(5, origin);
            ps.setInt(6, sale);
            ps.setString(7, description);
            ps.setBoolean(8, onOffSale);
            ps.setInt(9, id);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
