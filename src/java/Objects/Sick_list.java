/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Sick_list {
    private int id_sick_list;
    private Doctor doctor;
    private Patient patient;
    private Date date_begin;
    private Date date_end;
    private String diagnosis;
    

    /**
     * @return the id_sick_list
     */
    public int getId_sick_list() {
        return id_sick_list;
    }

    /**
     * @param id_sick_list the id_sick_list to set
     */
    public void setId_sick_list(int id_sick_list) {
        this.id_sick_list = id_sick_list;
    }

    
    /**
     * @return the diagnosis
     */
    public String getDiagnosis() {
        return diagnosis;
    }

    /**
     * @param diagnosis the diagnosis to set
     */
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    /**
     * @return the doctor
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * @param doctor the doctor to set
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * @return the patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * @param patient the patient to set
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * @return the date_begin
     */
    public Date getDate_begin() {
        return date_begin;
    }

    /**
     * @param date_begin the date_begin to set
     */
    public void setDate_begin(Date date_begin) {
        this.date_begin = date_begin;
    }

    /**
     * @return the date_end
     */
    public Date getDate_end() {
        return date_end;
    }

    /**
     * @param date_end the date_end to set
     */
    public void setDate_end(Date date_end) {
        this.date_end = date_end;
    }

    /**
     * @return the time
     */
 
}
