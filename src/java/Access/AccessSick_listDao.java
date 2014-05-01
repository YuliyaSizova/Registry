/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Objects.Sick_list;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import Connection.Abstract;

import Dao.Sick_listDao;
import Objects.Doctor;
import Objects.Patient;
import Objects.Policlinic;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class AccessSick_listDao extends Abstract implements Sick_listDao {
 @Override
    public void addSick_list(Sick_list sick_list) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("INSERT INTO Sick_list(id_doctor, id_patient,"
                    + " date_begin, date_end, diagnosis) VALUES(?,?,?,?,?)");
            ps.setInt(1, sick_list.getDoctor().getId_doctor());
            ps.setInt(2, sick_list.getPatient().getId_patient());
            ps.setDate(3, new java.sql.Date(sick_list.getDate_begin().getTime()));
            ps.setDate(4, new java.sql.Date(sick_list.getDate_end().getTime()));
            ps.setString(5, sick_list.getDiagnosis());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while adding sick list");
            ex.printStackTrace();
        }
    }
 @Override
    public void updateSick_listDateEnd(Sick_list sick_list) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("UPDATE Sick_list SET"
                    + " date_end=?"
                    + " WHERE id_sick_list=?");
           
            ps.setDate(1, new java.sql.Date(sick_list.getDate_end().getTime()));
            ps.setInt(2, sick_list.getId_sick_list());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error while updating sick list's date");
            ex.printStackTrace();
        }
    }

    @Override
    public List<Sick_list> getById_Sick_list(int id_patient) {
        try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("SELECT distinct s.id_sick_list, "
                    + "s.date_begin, s.date_end, s.diagnosis,s.id_patient, d.id_doctor, d.surname, "
                    + "d.name, d.patronymic, d.cabinet, d.id_policlinic, d.dbirthday, "
                    + "d.profile, p.name AS pname from (Sick_list s inner join Doctor d "
                    + "on s.id_doctor = d.id_doctor)inner join Policlinic p on d.id_policlinic = "
                    + "p.id_policlinic  where s.id_patient = ? order by s.date_end desc");

            ps.setInt(1, id_patient);
            ResultSet rs = ps.executeQuery();
            List<Sick_list> lis = new ArrayList<Sick_list>();
            while (rs.next()) {
                Patient p = new Patient();
                Sick_list l = new Sick_list();
                Policlinic poli = new Policlinic();
                Doctor doc = makeDoctor(rs, poli);
                p.setId_patient(rs.getInt("id_patient"));
                l.setDoctor(doc);
                l.setPatient(p);
                l.setId_sick_list(rs.getInt("id_sick_list"));
                l.setDate_begin(rs.getDate("date_begin"));
                l.setDate_end(rs.getDate("date_end"));
                l.setDiagnosis(rs.getString("diagnosis"));
                lis.add(l);
            }

            return lis;
        } catch (SQLException ex) {
            System.out.println("Error while updating sick list's date");
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public int openSick(int id_patient, Date date) {
         try (Connection con = getConn()) {
            PreparedStatement ps = con.prepareStatement("SELECT top 1 s.id_patient, "
                    + "s.date_end from Sick_list s where s.id_patient = ? and "
                    + "s.date_end > ? order by s.date_end desc;");
             
            ps.setInt(1, id_patient);
            ps.setDate(2, new java.sql.Date(date.getTime()));
            ResultSet rs = ps.executeQuery();
            rs.next();
            int id = rs.getInt("id_patient");
            return id;
        } catch (SQLException ex) {
            System.out.println("Error while updating sick list's date");
            ex.printStackTrace();
            return 0;
        }   
    }

}
