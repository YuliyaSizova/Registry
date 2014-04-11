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
public class House {
    private int id_house;
    private int id_street;
    private int id_district;
    private int house_number;
    private String block = "";

    /**
     * @return the id_house
     */
    public int getId_house() {
        return id_house;
    }

    /**
     * @param id_house the id_house to set
     */
    public void setId_house(int id_house) {
        this.id_house = id_house;
    }

    /**
     * @return the id_street
     */
    public int getId_street() {
        return id_street;
    }

    /**
     * @param id_street the id_street to set
     */
    public void setId_street(int id_street) {
        this.id_street = id_street;
    }

    /**
     * @return the id_district
     */
    public int getId_district() {
        return id_district;
    }

    /**
     * @param id_district the id_district to set
     */
    public void setId_district(int id_district) {
        this.id_district = id_district;
    }

    /**
     * @return the house_number
     */
    public int getHouse_number() {
        return house_number;
    }

    /**
     * @param house_number the house_number to set
     */
    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    /**
     * @return the block
     */
    public String getBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
       public void setBlock(String block) {
        if (block == null) {
            this.block = "";
        } else {
            this.block = block;
        }
    }
}
