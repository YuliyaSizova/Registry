/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Access;

import Dao.DateDao;
import Dao.DoctorDao;
import Dao.HouseDao;
import Dao.UserDao;
import Dao.PatientDao;
import Dao.Sick_listDao;
import Dao.StreetDao;
import Dao.Visit_gridDao;
import Dao.WorktimeDao;
import fabric.TableFactory;

/**
 *
 * @author ASUS
 */
public class AccessTableFactory extends TableFactory {

    @Override
    public PatientDao makePatient() {
        return new AccessPatientDao();
    }

    @Override
    public DoctorDao makeDoctor() {
        return new AccessDoctorDao();
    }

    @Override
    public Sick_listDao makeSick_list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Visit_gridDao makeGrid() {
        return new AccessVisit_GridDao();
    }

    @Override
    public DateDao makeDate() {
        return new AccessDateDao();
    }

    @Override
    public StreetDao makeStreet() {
        return new AccessStreetDao();
    }

    @Override
    public HouseDao makeHouse() {
        return new AccessHouseDao();
    }

    @Override
    public UserDao makeUser() {
        return new AccessUserDao();
    }

    @Override
    public WorktimeDao makeWorktime() {
        return new AccessWorktimeDao();
    }
}
