/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objects;

/**
 *
 * @author ASUS
 */
public class Ticket {
    private int id_ticket;
    private String primary_diagnosis;
    private Doctor doctor;
    private Patient patien;
    private int id_grid;
    private Dates d;
    private Visit_time time;
    

    /**
     * @return the id_ticket
     */
    public int getId_ticket() {
        return id_ticket;
    }

    /**
     * @param id_ticket the id_ticket to set
     */
    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    /**
     * @return the primary_diagnosis
     */
    public String getPrimary_diagnosis() {
        return primary_diagnosis;
    }

    /**
     * @param primary_diagnosis the primary_diagnosis to set
     */
    public void setPrimary_diagnosis(String primary_diagnosis) {
        this.primary_diagnosis = primary_diagnosis;
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
     * @return the patien
     */
    public Patient getPatien() {
        return patien;
    }

    /**
     * @param patien the patien to set
     */
    public void setPatien(Patient patien) {
        this.patien = patien;
    }

    /**
     * @return the id_visit_grid
     */
    public int getId_grid() {
        return id_grid;
    }

    /**
     * @param id_visit_grid the id_visit_grid to set
     */
    public void setId_grid(int id_grid) {
        this.id_grid = id_grid;
    }

    /**
     * @return the d
     */
    public Dates getD() {
        return d;
    }

    /**
     * @param d the d to set
     */
    public void setD(Dates d) {
        this.d = d;
    }

    /**
     * @return the time
     */
    public Visit_time getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Visit_time time) {
        this.time = time;
    }

   
}
