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
    private String worktime_name;
    private String kindofday;

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
    public String getBeginning_hour() {
        return beginning_hour;
    }

    /**
     * @param beginning_hour the begining_hour to set
     */
    public void setBeginning_hour(String beginning_hour) {
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

    /**
     * @return the worktime_name
     */
    public String getWorktime_name() {
        return worktime_name;
    }

    /**
     * @param worktime_name the worktime_name to set
     */
    public void setWorktime_name(String worktime_name) {
        this.worktime_name = worktime_name;
    }

    /**
     * @return the kindofday
     */
    public String getKindofday() {
        return kindofday;
    }

    /**
     * @param kindofday the kindofday to set
     */
    public void setKindofday(String kindofday) {
        this.kindofday = kindofday;
    }
}
