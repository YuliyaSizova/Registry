package Access;

import Connection.Abstract;
import Objects.Patient;
import Dao.PatientDao;
import Objects.House;
import Objects.Visit_grid;
import filters.PatientFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

public class AccessPatientDao extends Abstract implements PatientDao {

    @Override
    public void addPatient(Patient patient) {
        try (Connection con = getConn()) {
            PreparedStatement st = con.prepareStatement("INSERT INTO Patient( policy,surname, name, patronymic, birthday, id_house) VALUES (?,?,?,?,?,?)");
            st.setLong(1, patient.getPolicy());
            st.setString(2, patient.getSurname());
            st.setString(3, patient.getName());
            st.setString(4, patient.getPatronymic());
            st.setDate(5, new java.sql.Date(patient.getBirthday().getTime())); 
            st.setInt(6, patient.getId_house());
            st.executeUpdate();
        } catch (SQLException ex) {

        }
    }

    @Override
    public void updatePatient(Patient patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletePatient(int id_patient) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //. Model-View-Controller (MVC)
    @Override
    public List<Patient> getByDoctorId_Patient(int doctorID) {
        System.out.println("0");
        try (Connection con = getConn()) {
            System.out.println("1");
            List<Patient> patients = new ArrayList<Patient>();
            Statement st = con.createStatement();
            System.out.println("2");
            ResultSet rs = st.executeQuery("select p.surname,p.name,p.patronymic, p.birthday, p.id_patient from Patient p , House h, Doctor d, District dis, Docs_with_districts dd where p.id_house=h.id_house and dis.id_district=h.id_district and d.id_doctor=dd.id_doctor and dd.id_district=dis.id_district and d.id_doctor = " + doctorID + "");

            System.out.println("2");

            while (rs.next()) {

                Patient patientList = new Patient();
                patientList.setSurname(rs.getString("surname"));
                patientList.setName(rs.getString("name"));
                patientList.setPatronymic(rs.getString("patronymic"));
                patientList.setBirthday(rs.getDate("birthday"));
                patientList.setId_patient(rs.getInt("id_patient"));
                patients.add(patientList);
            }
            rs.close();
            con.close();
            return patients;

        } catch (SQLException ex) {
            System.out.println("ohh");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient getByPolicy(int policy) {

        try (Connection con = getConn()) {
            PreparedStatement st = con.prepareStatement("select id_patient from Patient where policy=?");
            st.setInt(1, policy);
            ResultSet rs = st.executeQuery();
            Patient patient = new Patient();
            while (rs.next()) { // Заполняются только ID????
                patient.setId_patient(rs.getInt("id_patient"));
            }
            con.close();
            return patient;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Patient getByID(int id) {
        try (Connection con = getConn()) {
            final String SELECT = "SELECT p.*, h.id_street, h.id_district, h.house_number, h.block"
                    + " FROM Patient p"
                    + " INNER JOIN House h on p.id_house=h.id_house"
                    + " WHERE p.id_patient = ?";
            PreparedStatement st = con.prepareStatement(SELECT);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next(); // Переход к первой строке результата запроса
                       // Цикл не нужен, т.к. пациент только один
            House house = makeHouse(rs);
            Patient patient = makePatient(rs, house);
            return patient;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Это копия твоего метода getByDoctorId_Patient с небольшими изменениямиы. лучше потом изменить их.
    @Override
    public List<Patient> filterPatientsForDoctorByFIO(int doctorID, PatientFilter filter) {
        System.out.println("0");
        try (Connection con = getConn()) {
            System.out.println("1");
            List<Patient> patients = new ArrayList<Patient>();
            Statement st = con.createStatement();
            System.out.println("2");
            ResultSet rs = st.executeQuery("select p.surname,p.name,p.patronymic, p.birthday, p.id_patient from Patient p , House h, Doctor d, District dis, Docs_with_districts dd where p.id_house=h.id_house and dis.id_district=h.id_district and d.id_doctor=dd.id_doctor and dd.id_district=dis.id_district and d.id_doctor = " + doctorID + ""
                    + " AND p.name LIKE '%" + filter.getName() + "%'"
                    + " AND p.surname LIKE '%" + filter.getSurname() + "%'"
                    + " AND p.patronymic LIKE '%" + filter.getPatronymic()+ "%'");

            System.out.println("2");

            while (rs.next()) {

                Patient patientList = new Patient();
                patientList.setSurname(rs.getString("surname"));
                patientList.setName(rs.getString("name"));
                patientList.setPatronymic(rs.getString("patronymic"));
                patientList.setBirthday(rs.getDate("birthday"));
                patientList.setId_patient(rs.getInt("id_patient"));
                patients.add(patientList);
            }
            rs.close();
            con.close();
            return patients;

        } catch (SQLException ex) {
            System.out.println("ohh");
            ex.printStackTrace();
            return null;
        }
    }
}
