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
    /**
     * Путь к папке с заголовочными jsp.
     */
    public static final String HEADERS = "/WEB-INF/headers";
    
    /**
     * Путь к папке со страницами, разграничивающими доступ.
     */
    public static final String SECURITY = "/WEB-INF/security";
    
    /**
     * Путь к странице, дающей доктору доступ.
     */
    public static final String ACCEPT_CLIENT = SECURITY + "/acceptDoctor.jsp";
    
  
   
    public static final String CHECK_ACCEPT = SECURITY + "/checkAccept.jsp";
    
    /**
     * Путь к заголовочной странице, используемой по умолчанию.
     */
    public static final String DEFAULT_HEADER = HEADERS + "/defaultHeader.jsp";
    
    
    /**
     * Путь к заголовочной странице для админа.
     */
    public static final String ADMIN_HEADER = HEADERS + "/adminHeader.jsp";
     public static final String DOCTOR_HEADER = HEADERS + "/headerDoc.jsp";
  
    /**
     * Путь странице автоматического выбора заголовка
     */
    public static final String CHOOSE_HEADER = HEADERS + "/chooseHeader.jsp";
    
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
