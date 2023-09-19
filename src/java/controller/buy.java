/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AdminDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Cart;

/**
 *
 * @author ACER-PC
 */
public class buy extends HttpServlet {

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
            out.println("<title>Servlet buy</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet buy at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();

        BigDecimal total = (BigDecimal) session.getAttribute("total");
        BigDecimal priceShip = new BigDecimal("30.000");
        BigDecimal totalAndShip = total.add(priceShip);
        request.setAttribute("priceShip", priceShip);
        session.setAttribute("totalAndShip", totalAndShip);
        request.getRequestDispatcher("buy.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String fullname = request.getParameter("fullname");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String payment = request.getParameter("payment");
        if ("".equals(fullname)) {
            session.setAttribute("msg", "Enter name again!");
            response.sendRedirect("buy");
            return;
        }
        if (fullname.length() > 100) {
            session.setAttribute("msg", "Enter name again! Toi da 100 ki tu");
            response.sendRedirect("buy");
            return;
        }
        if ("".equals(address)) {
            session.setAttribute("msg", "Enter address again!");
            response.sendRedirect("buy");
            return;
        }
        if (address.length() > 200) {
            session.setAttribute("msg", "Enter address again! Toi da 200 ki tu");
            response.sendRedirect("buy");
            return;
        }
        if ("".equals(phone)) {
            session.setAttribute("msg", "Enter number phone again!");
            response.sendRedirect("buy");
            return;
        }
        if (!phone.matches("^[0-9]+$")) {
            session.setAttribute("msg", "Enter number phone again!");
            response.sendRedirect("buy");
            return;
        }
        if (phone.length() < 10 || phone.length() > 12) {
            session.setAttribute("msg", "Enter number phone again!");
            response.sendRedirect("buy");
            return;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        List<Cart> cartProduct = (List<Cart>) session.getAttribute("cartProduct");
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            AdminDAO dao = new AdminDAO();

            for (int i = 0; i < cartProduct.size(); i++) {
                dao.add(formatter.format(date), account.getMail(), fullname, address, phone, cartProduct.get(i).getId(), cartProduct.get(i).getName(), cartProduct.get(i).getQuantity(), cartProduct.get(i).getPriceNew(), payment, account.getId());
            }
            response.sendRedirect("thankyoupage");
        } else {
            response.sendRedirect("login");
        }
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
