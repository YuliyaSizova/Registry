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
public class Worktime {
    private int id_worktime;
    private String beginning_hour;
    private String ending_hour;

    /**
     * @return the id_worktime
     */
    public int getId_worktime() {
        return id_worktime;
    }

    /**
     * @param id_worktime the id_worktime to set
     */
    public void setId_worktime(int id_worktime) {
        this.id_worktime = id_worktime;
    }

    /**
     * @return the begining_hour
     */
    public String getBegining_hour() {
        return beginning_hour;
    }

    /**
     * @param begining_hour the begining_hour to set
     */
    public void setBegining_hour(String beginning_hour) {
        this.beginning_hour = beginning_hour;
    }

    /**
     * @return the ending_hour
     */
    public String getEnding_hour() {
        return ending_hour;
    }

    /**
     * @param ending_hour the ending_hour to set
     */
    public void setEnding_hour(String ending_hour) {
        this.ending_hour = ending_hour;
    }
}
