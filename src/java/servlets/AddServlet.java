/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Access.*;
import Dao.DateDao;
import Dao.PatientDao;
import Objects.Patient;

import fabric.TableFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddServlet", loadOnStartup = 1, urlPatterns = {"/all/"})

public class AddServlet extends HttpServlet {

    private TableFactory factory = new AccessTableFactory();
    private PatientDao patientDao = factory.makePatient();
 
    private DateDao dateDao = factory.makeDate();

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

        StringBuilder builder = new StringBuilder();
        response.setCharacterEncoding("Cp1251");

        // Тут метод convert для исправления ошибок кодировки, написан ниже.
        PrintWriter out = response.getWriter();              // Получаем объект, при помощи которого можно печатать что-нибудь в браузер.

        List<Patient> patients = patientDao.getByDoctorId_Patient(7);
        builder.append("<table>");
        for (Patient patient : patients) {
            builder.append("<tr><td>").append(patient.getName()).append("</td>");
            builder.append("</tr>");

        }													 // преобразуется Jav-ой в сервлет, внутри которого примерно такой же код).
        builder.append("</  table>");

        out.print(builder);
//        visit_gridDao.fullfillVisit_grid();
//        dateDao.fullfillDate();
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
        processRequest(request, response);
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
        processRequest(request, response);
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
