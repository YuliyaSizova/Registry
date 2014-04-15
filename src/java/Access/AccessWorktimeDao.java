/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Connection.Abstract;
import Dao.WorktimeDao;
import Objects.Worktime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccessWorktimeDao extends Abstract implements WorktimeDao {

    @Override
    public List<Worktime> getWorktime(int id_doctor) {
        try (Connection con = getConn()) {

            List<Worktime> wt = new ArrayList<Worktime>();
            PreparedStatement st = con.prepareStatement("SELECT w.id_worktime, w.beginning_hour, w.ending_hour, w.worktime_name, w.kindofday"
                    + " FROM Worktime w, Doctor  d, Docs_with_wt  dw "
                    + " WHERE dw.id_doctor=d.id_doctor and dw.id_worktime=w.id_worktime and d.id_doctor=?");
            st.setInt(1, id_doctor);
            ResultSet rs = st.executeQuery();           

            while (rs.next()) {

                Worktime wrt = new Worktime();
                wrt.setId_worktime(rs.getInt("id_worktime"));
                wrt.setBeginning_hour(rs.getString("beginning_hour"));
                wrt.setEnding_hour(rs.getString("ending_hour"));
                wrt.setWorktime_name(rs.getString("worktime_name"));
                wrt.setKindofday(rs.getString("kindofday"));
                wt.add(wrt);
            }
                       
            return wt;

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ffffffffffffffffffffff");
            return null;
        }
    }

}
