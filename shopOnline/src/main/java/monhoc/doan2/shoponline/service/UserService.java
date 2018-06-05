/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.service;

import monhoc.doan2.shoponline.DAO.UserDAO;
import monhoc.doan2.shoponline.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NhutKha
 */
@Service
public class UserService {

    @Autowired
    UserDAO userDAO;
    
    @Transactional
    public User login(String userEmail, String userPass) {
        return userDAO.login(userEmail, userPass);
    }

    @Transactional
    public boolean checkLogin(String userName, String userPass) {
        return userDAO.checkLogin(userName, userPass);
    }

    @Transactional
    public void insertUser(User user) {
        userDAO.insertUser(user);
    }

    @Transactional
    public boolean checkMail(String userEmail) {
        return userDAO.checkEmail(userEmail);
    }
    
    @Transactional
    public boolean logout(){
        return userDAO.logout();
    }
    
    @Transactional
    public User getuserloggedin(){
        return userDAO.getuserloggedin();
    }
    
}
