package Access;

import Connection.Abstract;
import Dao.UserDao;
import Objects.Doctor;
import Objects.User;
import Objects.Policlinic;
import Objects.Role;
import Objects.Worktime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccessUserDao extends Abstract implements UserDao {

    @Override
    public User getUser(String login) {
        try (Connection con = getConn()) {
            User user = new User();
            PreparedStatement st = con.prepareStatement("select l.* , d.id_doctor, d.surname, d.name, d.patronymic, d.cabinet, d.id_policlinic,d.dbirthday,d.profile, r.id_role, r.roleName, p.name as pname "
                    + " from ((LoginParol l  inner join Doctor d on  l.id_user= d.id_doctor) "
                    + " inner join Policlinic p on p.id_policlinic = d.id_policlinic) "
                    + "inner join Role r on r.id_role = l.level  where l.login = ?");
            st.setString(1, login);
            ResultSet rs = st.executeQuery();

            rs.next();
            Policlinic poli = new Policlinic();

            Doctor doctor = makeDoctor(rs, poli);
            user.setLogin(rs.getString("login"));
            user.setParol(rs.getString("parol"));
            Role role = new Role();
            role.setId_role(rs.getInt("id_role"));
            role.setRoleName(rs.getString("roleName"));
            user.setRole(role);
            user.setDoctor(doctor);

            return user;
        } catch (SQLException ex) {
            ex.printStackTrace();

            return null;
        }
    }

}
