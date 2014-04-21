/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Access.AccessTableFactory;
import Dao.PatientDao;
import Objects.Journal;
import Objects.Patient;
import fabric.DaoMaster;
import fabric.TableFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "PatientServlet", loadOnStartup = 1, urlPatterns = {"/showPatient/", 
    "/history/"})
public class PatientServlet extends HttpServlet {
    
    
    private PatientDao patientDao = DaoMaster.getPatientDao();

    // Всё аналогично методу из DoctorServlet
    protected void showPatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int patientID = Integer.parseInt(request.getParameter("patient_id"));
        Patient patient = patientDao.getByID(patientID);
        request.setAttribute("patient", patient);
        request.getRequestDispatcher("/Patient/showPatient.jsp").forward(request, response);
    }
    
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userPath = request.getServletPath();
        switch (userPath) {
            case "/showPatient/": {
                showPatient(request, response);
                break;
            }
             case "/history/": {
                historyPatient(request, response);
                break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

    private void historyPatient(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
       int patientID = Integer.parseInt(request.getParameter("patient_id"));
        List<Journal> jo = patientDao.getPatientHistory(patientID);
        request.setAttribute("journal", jo);
        request.getRequestDispatcher("/Patient/PatientHistory.jsp").forward(request, response);
   
    }
}
