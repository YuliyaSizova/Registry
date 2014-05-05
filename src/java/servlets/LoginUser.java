/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Access.AccessTableFactory;
import Connection.Abstract;
import Dao.UserDao;
import Dao.PatientDao;
import fabric.AnswerBean;
import Objects.User;
import fabric.DaoMaster;
import fabric.TableFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import security.SecurityBean;

/**
 *
 * @author ASUS
 */
@WebServlet(name = "LoginUser", urlPatterns = {"/LoginUser/", "/LogoutUser/"})
public class LoginUser extends HttpServlet {

    private UserDao userDao = DaoMaster.getUserDao();

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
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        switch (userPath) {
            case "/LogoutUser/": {
                logout(request, response);
                break;
            }
        }
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
        String userPath = request.getServletPath();
        switch (userPath) {
            case "/LoginUser/": {
                login(request, response);
                break;
            }
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

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userDao.getUser(username);
        if (user == null || !user.getParol().equals(password)) {
              AnswerBean answer = (AnswerBean) request.getSession().getAttribute("addAnswer");
             answer.setMessage("Неправильные логин и/или пароль. Попробуйте ещё раз.");
              response.sendRedirect(request.getContextPath());
            return;
            // выкинуть на страницу с ошибкой
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        Cookie cookie = new Cookie("password", user.getParol());
        cookie.setMaxAge(3600); // Set the maximum age to be an hour.
        response.addCookie(cookie);
        switch (user.getId_role()) {
            case SecurityBean.ADMIN: {
                // это админ
                break;
            }
            case SecurityBean.DOCTOR: {

                break;
            }

        }
        response.sendRedirect("/Registry/ShowPatientList/");
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("user", null);
        
        response.sendRedirect(request.getContextPath());
    }


}
