/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fabric;

import Dao.DateDao;
import Dao.DoctorDao;
import Dao.HouseDao;
import Dao.UserDao;
import Dao.PatientDao;
import Dao.Sick_listDao;
import Dao.StreetDao;
import Dao.Visit_gridDao;
import Dao.WorktimeDao;

/**
 *
 * @author ASUS
 */
public abstract class TableFactory {

    public abstract PatientDao makePatient();

    public abstract DoctorDao makeDoctor();

    public abstract Sick_listDao makeSick_list();

    public abstract Visit_gridDao makeGrid();

    public abstract DateDao makeDate();

    public abstract StreetDao makeStreet();

    public abstract HouseDao makeHouse();

    public abstract UserDao makeUser();

    public abstract WorktimeDao makeWorktime();
}
