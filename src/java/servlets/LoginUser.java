/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Access.AccessTableFactory;
import Connection.Abstract;
import Dao.LoginParolDao;
import Dao.PatientDao;
import Objects.LoginParol;
import fabric.TableFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginUser", urlPatterns = {"/LoginUser/", "/LogoutUser/"})
public class LoginUser extends HttpServlet {

    private TableFactory factory = new AccessTableFactory();
    private LoginParolDao loginparolDao = factory.makeLoginParol();

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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        processRequest(request, response);
//    }
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
        String userPath = request.getServletPath();
        switch (userPath) {
            case "/LoginUser/": {
                loginUser(request, response);
                break;
            }
            case "/LogoutUser/": {
                logoutUser(request, response);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String registr = "registr";
        String doctor = "doctor";
        String admin = "administrator";
        LoginParol lp = loginparolDao.SelectUser(username, password);
        if (lp.getLogin() != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("user", lp);
            if (doctor.equals(lp.getLevel())) {
                Cookie cookie = new Cookie("password", lp.getParol());
                cookie.setMaxAge(3600); // Set the maximum age to be an hour.
                response.addCookie(cookie); 
                System.out.println(cookie.getComment());
                response.sendRedirect("/Registry/ShowPatientList/");

            } else {
                out.println("<h3>Incorrect login information.</h3>");
            }
        }

    }

    private void logoutUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", null);
        response.sendRedirect("/Registry/");
    }

}
