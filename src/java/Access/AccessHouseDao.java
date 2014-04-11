/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Access;

import Connection.Abstract;
import Objects.House;
import Dao.HouseDao;
import Objects.Street;
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
public class AccessHouseDao extends  Abstract  implements HouseDao{

    @Override
    public List<House> getAllHouses(int id_street) {
 try (Connection con = getConn()) {
            PreparedStatement st = con.prepareStatement("select id_house,house_number, block from House where id_street = ?");
             st.setInt(1, id_street);
            ResultSet rs = st.executeQuery();
            List<House> houses = new ArrayList<House>();
            while (rs.next()) {
                House house = new House();
                house.setId_house(rs.getInt("id_house"));
                house.setHouse_number(rs.getInt("house_number"));
                house.setBlock(rs.getString("block"));
                houses.add(house);
            }
            con.close();
            return houses;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }    }
    
}
