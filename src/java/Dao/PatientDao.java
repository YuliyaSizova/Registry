
package Dao;

import Objects.Journal;
import Objects.Patient;
import Objects.Ticket;
import filters.PatientFilter;
import java.util.Date;
import java.util.List;


public interface PatientDao {
   void addPatient (Patient patient);
   void updatePatient (Patient patient);
   void deletePatient (int id_patient);
   List<Patient> getByDoctorId_Patient(int doctorID);
   List<Patient> getByDoctorIdDate_Patient(int doctorID, Date date);
   List<Journal> getPatientHistory(int id_patient);
   List<Journal> getPatientHistoryForDoc(int id_patient,int id_doctor);
   Patient getByID(int id);
   List<Patient> filterPatientsForDoctorByFIO(int doctorID, PatientFilter filter);
   void updateJournal(Journal journal);
   int getTicket (int doctor_id, int patient_id);
   Journal getJournalByID(int idJournal);
}