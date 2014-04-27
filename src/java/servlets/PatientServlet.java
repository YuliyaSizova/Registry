/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;


import Dao.PatientDao;
import Objects.Journal;
import Objects.Patient;
import Objects.Ticket;
import Objects.User;
import fabric.DaoMaster;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "PatientServlet", loadOnStartup = 1, urlPatterns = {"/showPatient/",
    "/history/", "/visit/","/currentDay/","/addVisit/", "/editJournalForm/", "/updateJournal/","/showSickList/"})
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
            case "/visit/": {
                visitPatient(request, response);
                break;
            }
             case "/currentDay/": {
                currentDay(request, response);
                break;
            }
             
             case "/addVisit/": {
                addVisit(request, response);
                break;
            }
            case "/editJournalForm/": {
                editJournalForm(request, response);
                break;
            }
            case "/updateJournal/": {
                updateJournal(request, response);
                break;
            }
             case "/showSickList/": {
                showSickList(request, response);
                break;
            }
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

    private void historyPatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int patientID = Integer.parseInt(request.getParameter("patient_id"));
        List<Journal> jo = patientDao.getPatientHistory(patientID);
        Patient patient = patientDao.getByID(patientID);
        request.setAttribute("patient", patient);
        request.setAttribute("journal", jo);
        request.getRequestDispatcher("/Patient/patientHistory.jsp").forward(request, response);

    }

    private void visitPatient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user=(User) session.getAttribute("user");
        int doctorID = user.getDoctor().getId_doctor();
        int patientID = Integer.parseInt(request.getParameter("patient_id"));
        List<Journal> jo = patientDao.getPatientHistoryForDoc(patientID,doctorID);
        Patient patient = patientDao.getByID(patientID);
        Ticket ticket = patientDao.getTicket(doctorID, patientID);
        request.setAttribute("ticket", ticket);
        request.setAttribute("patient", patient);
        request.setAttribute("journal", jo);
        request.getRequestDispatcher("/Patient/patientVisit.jsp").forward(request, response);
    }

    private void currentDay(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {  
    HttpSession session = request.getSession();
    User user=(User) session.getAttribute("user");
    int doctorID = user.getDoctor().getId_doctor();
    
   

     List<Patient> patientList = patientDao.getByDoctorIdDate_Patient(doctorID, new java.util.Date());
        request.setAttribute("patientList", patientList);
         request.getRequestDispatcher("/Doctor/listPatient.jsp").forward(request, response);
    }


   private void addVisit(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        String med = request.getParameter("med");
        String blank = request.getParameter("blank");
        int id_ticket = Integer.parseInt(request.getParameter("id_ticket"));
        Journal jo = new Journal();
        jo.setMed(med);
        jo.setDiagnosis(blank);
        Ticket t = new Ticket();
        t.setId_ticket(id_ticket);
        jo.setTicket(t);
        patientDao.addJournal(jo);
          HttpSession session = request.getSession();
        User user=(User) session.getAttribute("user");
        int doctorID = user.getDoctor().getId_doctor();
        int patientID = Integer.parseInt(request.getParameter("patient_id"));
        List<Journal> j = patientDao.getPatientHistoryForDoc(patientID,doctorID);
        Patient patient = patientDao.getByID(patientID);
        Ticket ticket = patientDao.getTicket(doctorID, patientID);
        request.setAttribute("ticket", ticket);
        request.setAttribute("patient", patient);
        request.setAttribute("journal", j);
        request.getRequestDispatcher("/Patient/patientVisit.jsp").forward(request, response);

    }
    private void editJournalForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int Id_journal = Integer.parseInt(request.getParameter("Id_journal"));
        Journal journal = patientDao.getJournalByID(Id_journal);
        request.setAttribute("journalToUpdate", journal);
        int patientID = Integer.parseInt(request.getParameter("id_patient"));
        Patient patient = patientDao.getByID(patientID);
        request.setAttribute("patient", patient);
        request.getRequestDispatcher("/Patient/updateJournal.jsp").forward(request, response);
    }

    private void updateJournal(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        String diagnosis = request.getParameter("diagnosis");
        String med = request.getParameter("med");
        int idJournal = Integer.parseInt(request.getParameter("Id_journal"));
        Journal journal = new Journal();
        journal.setDiagnosis(diagnosis);
        journal.setMed(med);
        journal.setId_journal(idJournal);
        patientDao.updateJournal(journal);
        response.sendRedirect(request.getContextPath() + "/visit/?patient_id=" + request.getParameter("id_patient"));
    }

    private void showSickList(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
    
    }
}


 

