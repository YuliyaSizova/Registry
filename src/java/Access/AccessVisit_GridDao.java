/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Connection.Abstract;
import Objects.Visit_grid;
import Dao.Visit_gridDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author ASUS
 */
public class AccessVisit_GridDao extends Abstract implements Visit_gridDao {

    @Override
    public void fullfillVisit_grid() {
        try (Connection con = getConn()) {
//            con.setAutoCommit(false);
            PreparedStatement st = con.prepareStatement(
               "INSERT INTO Visit_grid (id_time, id_date) "
                       + "SELECT Visit_time.id_time, Dates.id_date "
                       + "FROM Visit_time, Dates ");
            st.executeUpdate();
//           con.commit();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        /*INSERT INTO Т_ДатаПара ( К_День, К_Пара )
         SELECT Т_День.К_День, Т_Пара.К_Пара
         FROM Т_День, Т_Пара; */    }

}
