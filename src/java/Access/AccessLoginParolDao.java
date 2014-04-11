/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Connection.Abstract;
import Dao.LoginParolDao;
import Objects.Doctor;
import Objects.LoginParol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class AccessLoginParolDao extends Abstract implements LoginParolDao {

    @Override
    public LoginParol SelectUser(String login, String parol) {
        try (Connection con = getConn()) {
            LoginParol loginparol = new LoginParol();
            PreparedStatement st = con.prepareStatement("select l.* ,d.*, p.name as pname , w.beginning_hour, w.ending_hour, w.worktime_name from ((LoginParol l" +
" inner join Doctor d on  l.id_user= d.id_doctor)" +
"inner join Policlinic p on p.id_policlinic = d.id_policlinic)" +
" inner join Worktime w on w.id_worktime=d.id_worktime  where l.login = ? and l.parol = ?");
            st.setString(1, login);
            st.setString(2, parol);
            ResultSet rs = st.executeQuery();
           
            while (rs.next()) {
                Doctor doctor = makeDoctor(rs,null,null);
                loginparol.setLogin(rs.getString("login"));
                loginparol.setParol(rs.getString("parol"));
                loginparol.setLevel(rs.getString("level"));
                loginparol.setDoctor(doctor);
            }
            return loginparol;
        } catch (SQLException ex) {
     
            return null;
        }
    }
    

}
