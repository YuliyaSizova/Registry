/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabric;

import Access.AccessTableFactory;
import Dao.DoctorDao;
import Dao.HouseDao;
import Dao.PatientDao;
import Dao.PoliclinicDao;
import Dao.UserDao;
import Dao.WorktimeDao;
import Objects.Worktime;

/**
 *
 * @author ASUS
 */
public class DaoMaster {

    private final static TableFactory factory = new AccessTableFactory();
    private final static UserDao userDao = factory.makeUser();
    private final static DoctorDao doctorDao = factory.makeDoctor();
    private final static PatientDao patientDao = factory.makePatient();
    private final static HouseDao houseDao = factory.makeHouse();
    private final static WorktimeDao worktimeDao = factory.makeWorktime();
   

    public static UserDao getUserDao() {
        return userDao;
    }

    public static DoctorDao getDoctorDao() {
        return doctorDao;
    }

    public static PatientDao getPatientDao() {
        return patientDao;
    }

    public static WorktimeDao getWorktimeDao() {
        return worktimeDao;
    }

    public static HouseDao getHouseDao() {
        return houseDao;
    }
   
}
