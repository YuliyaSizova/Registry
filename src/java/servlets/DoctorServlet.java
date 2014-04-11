/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Access.AccessTableFactory;
import Dao.PatientDao;
import Objects.Patient;
import fabric.TableFactory;
import filters.PatientFilter;
import java.io.IOException;
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
@WebServlet(name = "DoctorServlet", loadOnStartup = 1, urlPatterns = {
    "/ShowPatientList/",
    "/ShowFilteredPatientList/"
})
public class DoctorServlet extends HttpServlet {

    private TableFactory factory = new AccessTableFactory();
    private PatientDao patientDao = factory.makePatient();

    protected void showPatientList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // doctor_id - имя текстового поля (см. index.jsp: <input type="text" name="doctor_id" value="" />)
        int doctorID = Integer.parseInt(request.getParameter("doctor_id")); // Тут бы хорошо проверку, но можно потом
        List<Patient> patientList = patientDao.getByDoctorId_Patient(doctorID);
        request.setAttribute("patientList", patientList);
        // Теперь так. Кладём список
        // в запрос, а не в сессию, 
        // как раньше (у тебя этого нет,
        // можешь посмотреть наши старые версии в МТС)
        // Умные люди пишут, что в сессию класть объекты плохо :)


        request.getRequestDispatcher("/Doctor/listPatient.jsp").forward(request, response);
        // А так происходит переадрессация на нужную страницу.
        // Запрос (в который мы положили список) отправится на неё.
        // Заметь, адрес в браузере не поменяется.
    }
    
    protected void showFilteredPatientList(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        int doctorID = Integer.parseInt(request.getParameter("doctor_id")); // Тут бы хорошо проверку, но можно потом
        PatientFilter filter = new PatientFilter();
        // Пока пусть будет так, остальное (фильтрация без учёта регистра, 
        // значения фильтрации в текстовых полях) смотри в нашем проекте.
        // Ну или потом вместе сделаем.
        // Фильрация без учёта регистра:
        // https://github.com/OlgaChichaeva/MTS/commit/634c416b5b7721a231fd0ed5ff89f9e9d6e27643
        // значения фильтрации в текстовых полях:
        // https://github.com/OlgaChichaeva/MTS/commit/e8f18482e82b90579917679efdbb2df4ccbce5f6
        filter.setName(request.getParameter("name"));
        filter.setSurname(request.getParameter("surname"));
        filter.setPatronymic(request.getParameter("patronymic"));
        List<Patient> patientList = patientDao.filterPatientsForDoctorByFIO(doctorID, filter);
        request.setAttribute("patientList", patientList);
        request.getRequestDispatcher("/Doctor/listPatient.jsp").forward(request, response);
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
            case "/ShowPatientList/": {
                showPatientList(request, response);
                break;
            }
            case "/ShowFilteredPatientList/": {
                showFilteredPatientList(request, response);
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
}
