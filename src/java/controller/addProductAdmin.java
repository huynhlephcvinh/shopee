/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.CategoryDAO;
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
import java.util.ArrayList;
import model.Category;
import model.Product;

/**
 *
 * @author ACER-PC
 */
@MultipartConfig
public class addProductAdmin extends HttpServlet {

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
            out.println("<title>Servlet addProductAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addProductAdmin at " + request.getContextPath() + "</h1>");
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
        CategoryDAO dao = new CategoryDAO();
        ArrayList<Category> listCategory = dao.getAll();
        HttpSession session = request.getSession();
        session.setAttribute("listCategory", listCategory);

        request.getRequestDispatcher("addProductAdmin.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String priceOld = request.getParameter("priceOld");
        String priceNew = request.getParameter("priceNew");
        String brand = request.getParameter("brand");
        String origin = request.getParameter("origin");
        String sale = request.getParameter("sale");
        String description = request.getParameter("description");
        String onOffSale = request.getParameter("onOffSale");
        int category = Integer.parseInt(request.getParameter("category"));
        Part part = request.getPart("photo");
        String realPart = request.getServletContext().getRealPath("/img");
        String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
        if (!Files.exists(Paths.get(realPart))) {
            Files.createDirectory(Paths.get(realPart));
        }
        if (!filename.equals("")) {
            part.write(realPart + "/" + filename);
        }
        if ("".equals(filename)) {
            request.setAttribute("msg1", "Enter img again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (filename.length() > 149) {
            request.setAttribute("msg1", "Toi da 149 ki tu trong ten file anh");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(name)) {
            request.setAttribute("msg1", "Enter name again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (name.length() > 150) {
            request.setAttribute("msg1", "Enter name again! Toi da 150 ki tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(priceOld)) {
            request.setAttribute("msg1", "Enter price again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if ("".equals(priceNew)) {
            request.setAttribute("msg1", "Enter price again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(brand)) {
            request.setAttribute("msg1", "Enter brand again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (brand.length() > 45) {
            request.setAttribute("msg1", "Enter brand again! Toi da 45 ki tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(origin)) {
            request.setAttribute("msg1", "Enter origin again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (origin.length() > 140) {
            request.setAttribute("msg1", "Enter origin again! Toi da 140 ki tu");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(sale)) {
            request.setAttribute("msg1", "Enter sale again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if ("".equals(description)) {
            request.setAttribute("msg1", "Enter description again!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (description.length() > 250) {
            request.setAttribute("msg1", "Toi da 250 ki tu o phan mo ta");
            RequestDispatcher dispatcher = request.getRequestDispatcher("addProductAdmin.jsp");
            dispatcher.forward(request, response);
            return;
        }
        ProductDAO dao = new ProductDAO();
        BigDecimal priceOld1 = new BigDecimal(priceOld);
        BigDecimal priceNew1 = new BigDecimal(priceNew);
        dao.add(filename, name, priceOld1, priceNew1, brand, origin, Integer.parseInt(sale), description, Boolean.parseBoolean(onOffSale), category);
        Product product = dao.getProductNew();
        HttpSession session = request.getSession();
        session.setAttribute("msg", "New");
        session.setAttribute("idProduct", product.getId());
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
