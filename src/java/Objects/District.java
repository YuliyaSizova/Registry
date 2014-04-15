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
public class District {
    private int id_district;
    private Policlinic policlinic;
    private String district_name;

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
     * @return the district_name
     */
    public String getDistrict_name() {
        return district_name;
    }

    /**
     * @param district_name the district_name to set
     */
    public void setDistrict_name(String district_name) {
        this.district_name = district_name;
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
}
