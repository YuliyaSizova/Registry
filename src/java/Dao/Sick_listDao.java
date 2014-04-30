/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;


import Objects.Sick_list;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface Sick_listDao {
   void addSick_list(Sick_list sick_list);
   List<Sick_list> getById_Sick_list(int id_patient);
   void updateSick_listDateEnd(Sick_list sick_list);
  
}
