/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

/**
 *
 * @author ASUS
 */
import Objects.Doctor;
import Objects.House;
import Objects.Patient;
import Objects.Policlinic;
import Objects.Worktime;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public abstract class Abstract {

    private final static String db;
    private final static Properties conI = new Properties();

    static {    // Статический блок инициализации.

        File file = new File("Регистратура.mdb");
        try {
            System.out.println("Afqk ceoofo" + file.getCanonicalPath());
        } catch (IOException ex) {
            Logger.getLogger(Abstract.class.getName()).log(Level.SEVERE, null, ex);
        }
        String path = "C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Регистратура\\Регистратура.mdb";
        System.out.println(path);
        db = "JDBC:ODBC:Driver=Microsoft Access Driver (*.mdb); DBQ=" + path;
        conI.put("charSet", "Cp1251");
    }

    protected Connection getConn() throws SQLException {
        return DriverManager.getConnection(db, conI);
    }

    protected Policlinic makePoliclinic(ResultSet rs) throws SQLException {
        Policlinic policlinic = new Policlinic();
        policlinic.setId_policlinic(rs.getInt("id_policlinic"));
        policlinic.setName(rs.getString("pname"));
        return policlinic;
    }

    protected House makeHouse(ResultSet rs) throws SQLException {
        House house = new House();
        house.setBlock(rs.getString("block"));
        house.setHouse_number(rs.getInt("house_number"));
        house.setId_district(rs.getInt("id_district"));
        house.setId_street(rs.getInt("id_street"));
        house.setId_house(rs.getInt("id_house"));
        return house;
    }

    protected Patient makePatient(ResultSet rs, House house) throws SQLException {
        Patient patient = new Patient();
        patient.setBirthday(rs.getDate("birthday"));
        patient.setHouse(house);
        patient.setId_patient(rs.getInt("id_patient"));
        patient.setName(rs.getString("name"));
        patient.setPatronymic(rs.getString("patronymic"));
        patient.setPolicy(rs.getInt("policy"));
        patient.setSurname(rs.getString("surname"));
        return patient;
    }

    protected Doctor makeDoctor(ResultSet rs, Policlinic policlinic, Worktime worktime) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setId_doctor(rs.getInt("id_doctor"));
        doctor.setName(rs.getString("name"));
        doctor.setSurname(rs.getString("surname"));
        doctor.setPatronymic(rs.getString("patronymic"));
        doctor.setProfile(rs.getString("profile"));
        doctor.setCabinet(rs.getInt("cabinet"));
        doctor.setPoliclinic(policlinic);
        doctor.setWorktime(worktime);
        return doctor;
    }
}
