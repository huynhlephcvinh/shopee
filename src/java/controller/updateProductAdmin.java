/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.ProductDAO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import model.Product;

/**
 *
 * @author ACER-PC
 */
@MultipartConfig
public class updateProductAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet updateProductAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updateProductAdmin at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO dao = new ProductDAO();
        Product product = dao.get(id);
        request.setAttribute("product", product);
        request.getRequestDispatcher("updateProductAdmin.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String priceOld = request.getParameter("priceOld");
        String priceNew = request.getParameter("priceNew");
        String brand = request.getParameter("brand");
        String origin = request.getParameter("origin");
        String sale = request.getParameter("sale");
        String description = request.getParameter("description");
        String onOffSale = request.getParameter("onOffSale");
        Part part = request.getPart("photo");
        String realPart = request.getServletContext().getRealPath("/img");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Paths.get(realPart))) {
            Files.createDirectory(Paths.get(realPart));
        }
        if (!filename.equals("")) {
            part.write(realPart + "/" + filename);
        }
        if (!filename.equals("")) {
            if (filename.length() > 149) {
                ProductDAO dao1 = new ProductDAO();
                Product product1 = dao1.get(id);
                request.setAttribute("product", product1);
                request.setAttribute("msg", "Enter img again!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
                dispatcher.forward(request, response);
                return;
            }
        }
        if ("".equals(name)) {
            ProductDAO dao1 = new ProductDAO();
            Product product1 = dao1.get(id);
            request.setAttribute("product", product1);
            request.setAttribute("msg", "Enter name again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
         if (name.length() > 150) {
            ProductDAO dao1 = new ProductDAO();
            Product product1 = dao1.get(id);
            request.setAttribute("product", product1);
            request.setAttribute("msg", "Enter name again! Toi da 150 ky tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return; 
         }
        if ("".equals(priceOld)) {
            ProductDAO dao2 = new ProductDAO();
            Product product2 = dao2.get(id);
            request.setAttribute("product", product2);
            request.setAttribute("msg", "Enter price again!");
            response.sendRedirect("addProductAdmin.jsp");
            return;
        }
        if ("".equals(priceNew)) {
            ProductDAO dao3 = new ProductDAO();
            Product product3 = dao3.get(id);
            request.setAttribute("product", product3);
            request.setAttribute("msg", "Enter price again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(brand)) {
            ProductDAO dao4 = new ProductDAO();
            Product product4 = dao4.get(id);
            request.setAttribute("product", product4);
            request.setAttribute("msg", "Enter brand again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (brand.length() > 45) {
          ProductDAO dao4 = new ProductDAO();
            Product product4 = dao4.get(id);
            request.setAttribute("product", product4);
            request.setAttribute("msg", "Enter brand again! Toi da 45 ky tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;  
        }
        if ("".equals(origin)) {
            ProductDAO dao5 = new ProductDAO();
            Product product5 = dao5.get(id);
            request.setAttribute("product", product5);
            request.setAttribute("msg", "Enter origin again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (origin.length() > 140) {
            ProductDAO dao5 = new ProductDAO();
            Product product5 = dao5.get(id);
            request.setAttribute("product", product5);
            request.setAttribute("msg", "Enter origin again! Toi da 140 ky tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(sale)) {
            ProductDAO dao6 = new ProductDAO();
            Product product6 = dao6.get(id);
            request.setAttribute("product", product6);
            request.setAttribute("msg", "Enter sale again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(description)) {
            ProductDAO dao7 = new ProductDAO();
            Product product7 = dao7.get(id);
            request.setAttribute("product", product7);
            request.setAttribute("msg", "Enter description again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (description.length() > 250) {
           ProductDAO dao7 = new ProductDAO();
            Product product7 = dao7.get(id);
            request.setAttribute("product", product7);
            request.setAttribute("msg", "Enter description again! Toi da 250 ky tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("updateProductAdmin.jsp");
            dispatcher.forward(request, response);
            return; 
        }
        BigDecimal priceOld1 = new BigDecimal(priceOld);
        BigDecimal priceNew1 = new BigDecimal(priceNew);
        ProductDAO dao8 = new ProductDAO();

        if (filename.equals("")) {
            dao8.updateVer2(id, name, priceOld1, priceNew1, brand, origin, Integer.parseInt(sale), description, Boolean.parseBoolean(onOffSale));
        } else {
            dao8.update(id, filename, name, priceOld1, priceNew1, brand, origin, Integer.parseInt(sale), description, Boolean.parseBoolean(onOffSale));
        }
        HttpSession session = request.getSession();
        session.setAttribute("msg", "Updated!");
        session.setAttribute("idProduct", id);
        response.sendRedirect("productAdmin");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
