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
import Objects.Policlinic;
import Objects.Worktime;
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
            PreparedStatement st = con.prepareStatement("select l.* ,d.id_doctor, d.surname, d.name, d.patronymic, d.cabinet, d.id_policlinic,d.dbirthday,d.profile,  p.name as pname  from (LoginParol l\n"
                    + " inner join Doctor d on  l.id_user= d.id_doctor)\n"
                    + " inner join Policlinic p on p.id_policlinic = d.id_policlinic where l.login = ? and l.parol = ?");
            st.setString(1, login);
            st.setString(2, parol);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Policlinic poli = new Policlinic();

                Doctor doctor = makeDoctor(rs, poli);
                loginparol.setLogin(rs.getString("login"));
                loginparol.setParol(rs.getString("parol"));
                loginparol.setLevel(rs.getString("level"));
                loginparol.setDoctor(doctor);
            }
            return loginparol;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
