package Access;

import Connection.Abstract;
import Dao.DoctorDao;
import Objects.Doctor;
import Objects.Patient;
import Objects.Policlinic;
import Objects.Worktime;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class AccessDoctorDao extends Abstract implements DoctorDao {

    private static final String SelectAll = "SELECT d.*, p.name AS pname\n"
            + "FROM Doctor AS d INNER JOIN Policlinic AS p ON d.id_policlinic=p.id_policlinic";

    public void updateDoctor(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addDoctor(Doctor doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteDoctor(int id_doctor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Doctor getById_Doctor(int id_doctor) {
        try (Connection con = getConn()) {
            PreparedStatement st = con.prepareStatement(SelectAll + " where id_doctor=?");
            st.setInt(1, id_doctor);
            ResultSet rs = st.executeQuery();
            rs.next();
           
            Policlinic poli = new Policlinic();
            Doctor doctor = makeDoctor(rs, poli);

            return doctor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
