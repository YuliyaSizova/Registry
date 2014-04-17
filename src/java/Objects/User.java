/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import security.SecurityBean;

/**
 *
 * @author ASUS
 */
public class User {

    private String login;
    private String parol;
    private Role role;
    private Doctor doctor;

    public User() {
        setId_role(SecurityBean.NOT_LOGGED);
    }

    public int getId_role() {
        return role.getId_role();
    }

    public void setId_role(int id_role) {
        if (role == null) {
            role = new Role();
        }
        role.setId_role(id_role);
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the parol
     */
    public String getParol() {
        return parol;
    }

    /**
     * @param parol the parol to set
     */
    public void setParol(String parol) {
        this.parol = parol;
    }

    /**
     * @return the level
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param level the level to set
     */
    public void setRole(Role role) {
        this.role = role;
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

}
