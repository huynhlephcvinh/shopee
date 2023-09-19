/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.AccountDAO;
import dal.RoleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Account;
import model.Role;

/**
 *
 * @author ACER-PC
 */
public class register extends HttpServlet {

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
            out.println("<title>Servlet register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet register at " + request.getContextPath() + "</h1>");
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
        RoleDAO roleDAO = new RoleDAO();

        // Set address list to request
        ArrayList<Role> roleList = roleDAO.getAll();
        request.setAttribute("roleList", roleList);
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
        String mail = request.getParameter("mail");
        String name = request.getParameter("name");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        int roleId = Integer.parseInt(request.getParameter("role"));
        HttpSession session = request.getSession();

        if ("".equals(mail)) {
            session.setAttribute("msg", "You have not filled out the form!");
            response.sendRedirect("register");
            return;
        }
        if (!mail.matches("[A-Za-z0-9+_.-]+@(.+)$")) {
            session.setAttribute("msg", "Email form: __@gmail.com or ___@___");
            response.sendRedirect("register");
            return;
        }
        if (mail.length() > 90) {
            session.setAttribute("msg", "Enter mail again! Toi da 90 ki tu");
            response.sendRedirect("register");
            return;
        }
        if ("".equals(name)) {
            session.setAttribute("msg", "You have not filled out the form!");
            response.sendRedirect("register");
            return;
        }
        if (name.length() > 90) {
            session.setAttribute("msg", "Enter name again! Toi da 90 ki tu");
            response.sendRedirect("register");
            return;
        }
        if ("".equals(password1)) {
            session.setAttribute("msg", "You have not filled out the form!");
            response.sendRedirect("register");
            return;
        }
        if (password1.length() > 90) {
            session.setAttribute("msg", "Enter password again! Toi da 90 ki tu");
            response.sendRedirect("register");
            return;
        }
        if ("".equals(password2)) {
            session.setAttribute("msg", "You have not filled out the form!");
            response.sendRedirect("register");
            return;
        }
        if (password2.length() > 90) {
            session.setAttribute("msg", "Enter confirm password again! Toi da 90 ki tu");
            response.sendRedirect("register");
            return;
        }
        if (!password1.equals(password2)) {
            session.setAttribute("msg", "Cofirm password not common!");
            response.sendRedirect("register");
            return;
        }
        AccountDAO accountDAO = new AccountDAO();
        Account account1 = accountDAO.getByMail(mail);
        if (account1 == null) {
            // Add person to Database
            accountDAO.createAccount(mail, name, password1, roleId);

            response.sendRedirect("login");
        } else {
            session.setAttribute("msg", "Duplicate mail");
            response.sendRedirect("register");
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
