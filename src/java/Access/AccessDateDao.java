/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Connection.Abstract;
import Dao.DateDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

/**
 *
 * @author ASUS
 */
public class AccessDateDao extends Abstract implements DateDao {

    @Override
    public void fullfillDate() {
        try (Connection con = getConn()) {
            Calendar date = Calendar.getInstance();
            
            PreparedStatement st = con.prepareStatement("insert into Dates(daten) values(?)");
            st.setDate(1,new java.sql.Date(date.getTimeInMillis()));
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

}
