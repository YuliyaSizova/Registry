/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Access;

import Connection.Abstract;
import Objects.Patient;
import Dao.PatientDao;
import Objects.Street;
import Dao.StreetDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccessStreetDao extends Abstract implements StreetDao{

    @Override
    public List<Street> getAllStreets() {
        try (Connection con = getConn()) {
            PreparedStatement st = con.prepareStatement("select name, id_street from Street");
            ResultSet rs = st.executeQuery();
            List<Street> streets = new ArrayList<Street>();
            while (rs.next()) {
                Street street = new Street();
                street.setName(rs.getString("name"));
                street.setId_street(rs.getInt("id_street"));
                streets.add(street);
            }
            con.close();
            return streets;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
}
