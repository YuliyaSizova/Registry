package Objects;

import java.util.Date;


public class Patient {
    
    private int id_patient;
    private int policy;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    private House house;

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
     * @return the policy
     */
    public int getPolicy() {
        return policy;
    }

    /**
     * @param policy the policy to set
     */
    public void setPolicy(int policy) {
        this.policy = policy;
    }

    /**
     * @return the surname
     */
    public String  getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String  surname) {
        this.surname = surname;
    }

    /**
     * @return the name
     */
    public String  getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String  name) {
        this.name = name;
    }

    /**
     * @return the patronymic
     */
    public String  getPatronymic() {
        return patronymic;
    }

    /**
     * @param patronymic the patronymic to set
     */
    public void setPatronymic(String  patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * @return the birthday
     */
    public Date  getBirthday() {
        return birthday;
    }

    /**
     * @param birthday the birthday to set
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the id_house
     */
   public int getId_house() {
        return house.getId_house();
    }

    /**
     * @param id_house the id_house to set
     */
    public void setId_house(int id_house) {
        if (house == null) {
            house = new House();
        }
        house.setId_house(id_house);
    }

    /**
     * @return the house
     */
    public House getHouse() {
        return house;
    }

    /**
     * @param house the house to set
     */
    public void setHouse(House house) {
        this.house = house;
    }

   
    
}
