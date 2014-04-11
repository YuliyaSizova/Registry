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
    private int id_doctor;
    private int id_patient;
    private long date;
    private String diagnosis;
    private Date time;

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
     * @return the id_doctor
     */
    public int getId_doctor() {
        return id_doctor;
    }

    /**
     * @param id_doctor the id_doctor to set
     */
    public void setId_doctor(int id_doctor) {
        this.id_doctor = id_doctor;
    }

    /**
     * @return the id_patient
     */
    public int getId_patient() {
        return id_patient;
    }

    /**
     * @param id_patient the id_patient to set
     */
    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
    }

    /**
     * @return the date
     */
    public long getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(long date) {
        this.date = date;
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
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }
}
