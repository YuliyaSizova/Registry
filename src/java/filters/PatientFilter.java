/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;


public class PatientFilter {
    private String id_patient = "";
    private String policy = "";
    private String surname = "";
    private String name = "";
    private String patronymic = "";
    private String birthday = "";
    private String house = "";

    /**
     * @return the id_patient
     */
    public String getId_patient() {
        return id_patient;
    }

    /**
     * @param id_patient the id_patient to set
     */
    public void setId_patient(String id_patient) {
        this.id_patient = id_patient;
    }

    /**
     * @return the policy
     */
    public String getPolicy() {
        return policy;
    }

    /**
     * @param policy the policy to set
     */
    public void setPolicy(String policy) {
        this.policy = policy;
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
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the house
     */
    public String getHouse() {
        return house;
    }

    /**
     * @param house the house to set
     */
    public void setHouse(String house) {
        this.house = house;
    }
}
