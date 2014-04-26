package Access;

import Connection.Abstract;
import Objects.Patient;
import Dao.PatientDao;
import Objects.Dates;
import Objects.District;
import Objects.Doctor;
import Objects.House;
import Objects.Journal;
import Objects.Policlinic;
import Objects.Street;
import Objects.Ticket;
import Objects.Visit_time;

import filters.PatientFilter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author ASUS
 */
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
        
        try (Connection con = getConn()) {

            List<Patient> patients = new ArrayList<Patient>();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("select p.surname,p.name,p.patronymic, p.birthday, p.id_patient, p.policy from Patient p , House h, Doctor d, District dis, Docs_with_districts dd where p.id_house=h.id_house and dis.id_district=h.id_district and d.id_doctor=dd.id_doctor and dd.id_district=dis.id_district and d.id_doctor = " + doctorID + "");

            System.out.println("2");

            while (rs.next()) {

                Patient patient = new Patient();
                patient.setBirthday(rs.getDate("birthday"));
//                patient.setHouse(house);
                patient.setId_patient(rs.getInt("id_patient"));
                patient.setName(rs.getString("name"));
                patient.setPatronymic(rs.getString("patronymic"));
                patient.setPolicy(rs.getInt("policy"));
                patient.setSurname(rs.getString("surname"));
                patients.add(patient);
            }

            return patients;

        } catch (SQLException ex) {
            System.out.println("ohh");
            ex.printStackTrace();
            return null;
        }
    }

   

    @Override
    public Patient getByID(int id) {
        try (Connection con = getConn()) {
            final String SELECT = "SELECT p.surname, p.name, p.patronymic, p.birthday, p.id_patient, p.policy, s.id_street, s.name AS sname, dis.id_district, dis.district_name, poli.id_policlinic, poli.name AS pname, h.id_house, h.house_number, h.block FROM (((Patient  p inner join House  h on p.id_house=h.id_house) "
                    + "inner join  District  dis on dis.id_district = h.id_district)"
                    + "inner join  Policlinic  poli on poli.id_policlinic=dis.id_policlinic) "
                    + "inner join  Street  s on s.id_street=h.id_street "
                    + " WHERE p.id_patient = ?";
            PreparedStatement st = con.prepareStatement(SELECT);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            rs.next(); // Переход к первой строке результата запроса
            // Цикл не нужен, т.к. пациент только один
            District dis = new District();
            Street str = new Street();
            Policlinic poli = new Policlinic();
            House house = new House();
            Patient patient = makePatient(rs, house, dis, str, poli);

            return patient;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    // Это копия твоего метода getByDoctorId_Patient с небольшими изменениямиы. лучше потом изменить их.
    @Override
    public List<Patient> filterPatientsForDoctorByFIO(int doctorID, PatientFilter filter) {
        try (Connection con = getConn()) {
            List<Patient> patients = new ArrayList<Patient>();

            PreparedStatement st = con.prepareStatement("select p.surname,p.name,p.patronymic, p.birthday, p.id_patient, p.policy from Patient p , House h, Doctor d, District dis, Docs_with_districts dd where p.id_house=h.id_house and dis.id_district=h.id_district and d.id_doctor=dd.id_doctor and dd.id_district=dis.id_district and d.id_doctor =?"
                    + " AND p.name LIKE '%" + filter.getName().toLowerCase() + "%'"
                    + " AND p.surname LIKE '%" + filter.getSurname().toLowerCase() + "%'"
                    + " AND p.patronymic LIKE '%" + filter.getPatronymic().toLowerCase() + "%'"
                    + " AND p.policy LIKE '%" + filter.getPolicy().toLowerCase() + "%'"
            );
            st.setInt(1, doctorID);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Patient patientList = new Patient();
                patientList.setSurname(rs.getString("surname"));
                patientList.setName(rs.getString("name"));
                patientList.setPatronymic(rs.getString("patronymic"));
                patientList.setBirthday(rs.getDate("birthday"));
                patientList.setId_patient(rs.getInt("id_patient"));
                patientList.setPolicy(rs.getInt("policy"));
                patients.add(patientList);
            }
            
            return patients;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Journal> getPatientHistory(int id_patient) {
       try (Connection con = getConn()) {
            List<Journal> journal = new ArrayList<Journal>();

            PreparedStatement st = con.prepareStatement("SELECT d.surname, d.name, d.patronymic, d.profile, da.daten, ti.time, j.diagnosis\n" +
"FROM ((((Journal AS j "
                    + "INNER JOIN Ticket AS t ON j.id_ticket=t.id_ticket) "
                    + "INNER JOIN Visit_grid AS vg ON t.id_grid=vg.id_grid) "
                    + "INNER JOIN Visit_time AS ti ON vg.id_time=ti.id_time) "
                    + "INNER JOIN Doctor AS d ON d.id_doctor=t.id_doctor) "
                    + "INNER JOIN Dates AS da ON da.id_date=vg.id_date\n " +
"WHERE t.id_patient=?"
            );
            st.setInt(1,id_patient);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ticket ticket = new Ticket();
                Doctor doc = new Doctor();
                Visit_time time = new Visit_time();
                time.setTime(rs.getTime("time"));
                Dates d= new Dates();
                d.setDaten(rs.getDate("daten"));
                doc.setName(rs.getString("name"));
                doc.setSurname(rs.getString("surname"));
                doc.setPatronymic(rs.getString("patronymic"));
                doc.setProfile(rs.getString("profile"));
                ticket.setDoctor(doc);
                ticket.setTime(time);
                ticket.setD(d);                
                
                Journal jo = new Journal();

                jo.setDiagnosis(rs.getString("diagnosis"));
                jo.setTicket(ticket);
              
                journal.add(jo);
            }
            
            return journal;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } }

    @Override
    public List<Journal> getPatientHistoryForDoc(int id_patient, int id_doctor) {
       try (Connection con = getConn()) {
            List<Journal> journal = new ArrayList<Journal>();

            PreparedStatement st = con.prepareStatement("SELECT d.surname, d.name, d.patronymic, d.profile, da.daten, ti.time, j.diagnosis, j.med\n " +
"FROM ((((Journal AS j "
                    + "INNER JOIN Ticket AS t ON j.id_ticket=t.id_ticket) "
                    + "INNER JOIN Visit_grid AS vg ON t.id_grid=vg.id_grid) "
                    + "INNER JOIN Visit_time AS ti ON vg.id_time=ti.id_time) "
                    + "INNER JOIN Doctor AS d ON d.id_doctor=t.id_doctor) "
                    + "INNER JOIN Dates AS da ON da.id_date=vg.id_date\n " +
"WHERE t.id_patient=? and d.id_doctor=?  order by da.id_date desc"
            );
            st.setInt(1,id_patient);
            st.setInt(2,id_doctor);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Ticket ticket = new Ticket();
                Doctor doc = new Doctor();
                Visit_time time = new Visit_time();
                time.setTime(rs.getTime("time"));
                Dates d= new Dates();
                d.setDaten(rs.getDate("daten"));
                doc.setName(rs.getString("name"));
                doc.setSurname(rs.getString("surname"));
                doc.setPatronymic(rs.getString("patronymic"));
                doc.setProfile(rs.getString("profile"));
                ticket.setDoctor(doc);
                ticket.setTime(time);
                ticket.setD(d);                
                
                Journal jo = new Journal();
                jo.setMed(rs.getString("med"));
                jo.setDiagnosis(rs.getString("diagnosis"));
                jo.setTicket(ticket);
                System.out.println(ticket.getPrimary_diagnosis());
                journal.add(jo);
            }
            
            return journal;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Patient> getByDoctorIdDate_Patient(int doctorID, Date date) {
         try (Connection con = getConn()) {

            List<Patient> patients = new ArrayList<Patient>();
          

            PreparedStatement st = con.prepareStatement("SELECT p.surname, p.name,"
                    + " p.patronymic, p.birthday, p.id_patient, p.policy\n " +
"FROM Visit_time AS vt, Ticket AS t, Visit_grid AS vi, Dates AS da, Patient AS p, House AS h, "
                    + "Doctor AS d, District AS dis, Docs_with_districts AS dd\n " +
"WHERE  vt.id_time = vi.id_time and p.id_house=h.id_house and dis.id_district=h.id_district and "
                    + "d.id_doctor=dd.id_doctor and dd.id_district=dis.id_district"
                    + " and d.id_doctor = ? and t.id_patient = p.id_patient and "
                    + "vi.id_grid=t.id_grid and da.id_date = vi.id_date and "
                    + "da.daten= ? and (" +
"(select distinct   j.id_ticket from  Ticket AS t, Visit_grid AS vi, Dates AS da, Patient AS p, Journal AS j, House AS h, Doctor AS d, District AS dis, Docs_with_districts AS dd \n" +
"where p.id_house=h.id_house And dis.id_district=h.id_district And d.id_doctor=dd.id_doctor And dd.id_district=dis.id_district And d.id_doctor= ? And t.id_patient=p.id_patient And vi.id_grid=t.id_grid And da.id_date=vi.id_date And da.daten=? and j.id_ticket=t.id_ticket )<>t.id_ticket)  And t.id_doctor =? order by vt.id_time");

            st.setInt(1,doctorID);
            st.setDate(2,  new java.sql.Date(date.getTime()));
            st.setInt(3,doctorID);
            st.setDate(4,  new java.sql.Date(date.getTime()));
            st.setInt(5,doctorID);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {

                Patient patient = new Patient();
                patient.setBirthday(rs.getDate("birthday"));
//                patient.setHouse(house);
                patient.setId_patient(rs.getInt("id_patient"));
                patient.setName(rs.getString("name"));
                patient.setPatronymic(rs.getString("patronymic"));
                patient.setPolicy(rs.getInt("policy"));
                patient.setSurname(rs.getString("surname"));
                patients.add(patient);
            }

            return patients;

        } catch (SQLException ex) {
           
            ex.printStackTrace();
            return null;
        }   }
}
