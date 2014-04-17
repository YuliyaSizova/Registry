/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Objects.User;

/**
 *
 * @author ASUS
 */
public interface UserDao  {
    User getUser(String login);
}
