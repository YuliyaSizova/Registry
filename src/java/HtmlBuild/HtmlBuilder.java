/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HtmlBuild;

import Access.AccessTableFactory;
import Dao.HouseDao;
import Objects.House;
import fabric.TableFactory;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HtmlBuilder {

    public static String makeHouseSelect(int id_street) {
        TableFactory factory = new AccessTableFactory();
        HouseDao houseDao = factory.makeHouse();
        List<House> houses = houseDao.getAllHouses(id_street);
        StringBuilder result = new StringBuilder();

        result.append("<select name=\"house_type\">");

        for (House H : houses) {

            result.append("<option value =").
                    append(H.getId_house()).
                    append(">").
                    append(H.getHouse_number()).
                    append(" ").
                    append(H.getBlock()).
                    append("</option>");

        }
        result.append("</select>");
        return result.toString();
    }
}
