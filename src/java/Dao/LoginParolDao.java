/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Objects.LoginParol;

/**
 *
 * @author ASUS
 */
public interface LoginParolDao  {
    LoginParol SelectUser(String login, String parol);
}
