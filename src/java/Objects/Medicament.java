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
class Medicament {
    private int id_medicament;
    private String name;
    private String description;

    /**
     * @return the id_medicament
     */
    public int getId_medicament() {
        return id_medicament;
    }

    /**
     * @param id_medicament the id_medicament to set
     */
    public void setId_medicament(int id_medicament) {
        this.id_medicament = id_medicament;
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
