

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Objects.Doctor;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface DoctorDao {
   void addDoctor (Doctor doctor);
   void updateDoctor (Doctor doctor);
   void deleteDoctor (int id_doctor);
   Doctor getById_Doctor(int id_doctor);
   
   
}
