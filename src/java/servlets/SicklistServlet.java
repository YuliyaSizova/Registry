/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Objects.Doctor;
import Objects.Patient;
import Objects.Sick_list;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Access.AccessSick_listDao;
import java.util.List;

/**
 *
 * @author Ivan
 */
@WebServlet(name = "TestServlet", loadOnStartup = 1, urlPatterns = {"/showSickList","/addSickList", "/updateSickList"})
public class SicklistServlet extends HttpServlet {

    private final AccessSick_listDao sickListDao = new AccessSick_listDao();

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
        String userPath = request.getServletPath();
        switch (userPath) {
            case "/addSickList": {
                addSickList(request, response);
                break;
            }
            case "/updateSickList": {
                updateSickList(request, response);
                break;
            }
              case "/showSickList": {
                showSickList(request, response);
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

    private void addSickList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         INSERT INTO Sick_list(id_doctor, id_patient,"
         + " date_begin, date_end, diagnosis) VALUES(?,?,?,?,?)
         */
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);
        try {
            int idDoctor = Integer.parseInt(request.getParameter("id_doctor"));
            int idPatient = Integer.parseInt(request.getParameter("id_patient"));
            Date dateBegin = formatter.parse(request.getParameter("date_begin"));
            Date dateEnd = formatter.parse(request.getParameter("date_end"));
            String diagnosis = request.getParameter("diagnosis");
            
            Doctor doc = new Doctor();
            doc.setId_doctor(idDoctor);
            Patient pat = new Patient();
            pat.setId_patient(idPatient);
            
            Sick_list sickList = new Sick_list();
            sickList.setDate_begin(dateBegin);
            sickList.setDate_end(dateEnd);
            sickList.setDiagnosis(diagnosis);
            sickList.setDoctor(doc);
            sickList.setPatient(pat);
            sickListDao.addSick_list(sickList);
            request.getRequestDispatcher("/Patient/sickList.jsp").forward(request, response);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
    }

    private void updateSickList(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        /*
         * "UPDATE Sick_list SET"
                    + " date_end=?"
                    + " WHERE id_sick_list=?"
         */
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);
        try {
            int idSickList = Integer.parseInt(request.getParameter("id_sick_list"));
            Date dateEnd = formatter.parse(request.getParameter("date_end"));
            
            Sick_list sickList = new Sick_list();
            sickList.setDate_end(dateEnd);
            sickList.setId_sick_list(idSickList);
            sickListDao.updateSick_listDateEnd(sickList);
            request.getRequestDispatcher("/Patient/sickList.jsp").forward(request, response);
        } catch (ParseException e) {
            throw new ServletException(e);
        }
    }

    private void showSickList(HttpServletRequest request, HttpServletResponse response)  
            throws IOException, ServletException {     
        int id_p = Integer.parseInt(request.getParameter("id_patient"));
        int id_t = Integer.parseInt(request.getParameter("id_ticket"));
        List<Sick_list> l =sickListDao.getById_Sick_list(id_p);
         request.setAttribute("list", l);
        request.setAttribute("ticket", id_t);
        request.getRequestDispatcher("/Patient/sickList.jsp").forward(request, response);
        
               }
}
