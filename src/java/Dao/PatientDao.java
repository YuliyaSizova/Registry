
package Dao;

import Objects.Patient;
import filters.PatientFilter;
import java.util.List;


public interface PatientDao {
   void addPatient (Patient patient);
   void updatePatient (Patient patient);
   void deletePatient (int id_patient);
   List<Patient> getByDoctorId_Patient(int doctorID);
   Patient getByPolicy (int policy);
   Patient getByID(int id);
   List<Patient> filterPatientsForDoctorByFIO(int doctorID, PatientFilter filter);
}