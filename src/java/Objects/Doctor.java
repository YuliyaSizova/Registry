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
public class Doctor {
    private int id_doctor;
    private String surname;
    private String name;
    private String patronymic;
    private String profile;
    private Policlinic policlinic;
    private int cabinet;
    private Date dbirthday;

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
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * @param patronymic the patronymic to set
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * @return the profile
     */
    public String getProfile() {
        return profile;
    }

    /**
     * @param profile the profile to set
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @return the id_policlinic
     */


    /**
     * @return the id_worktime
     */



    /**
     * @return the cabinet
     */
    public int getCabinet() {
        return cabinet;
    }

    /**
     * @param cabinet the cabinet to set
     */
    public void setCabinet(int cabinet) {
        this.cabinet = cabinet;
    }

    /**
     * @return the policlinic
     */
    public Policlinic getPoliclinic() {
        return policlinic;
    }

    /**
     * @param policlinic the policlinic to set
     */
    public void setPoliclinic(Policlinic policlinic) {
        this.policlinic = policlinic;
    }

    /**
     * @return the id_worktime
     */
 
    /**
     * @return the birthday
     */
    public Date getDbirthday() {
        return dbirthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setDbirthday(Date dbirthday) {
        this.dbirthday = dbirthday;
    }
    
}
