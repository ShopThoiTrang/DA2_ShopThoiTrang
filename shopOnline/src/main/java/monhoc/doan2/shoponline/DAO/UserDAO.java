/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.DAO;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import monhoc.doan2.shoponline.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NhutKha
 */
@Repository
public class UserDAO {

    @Autowired
    SessionFactory sessionfactory;

    User userloggedin = null;
    public void insertUser(User user) {
        try {
            Session session = sessionfactory.getCurrentSession();
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(int userID) {
        User u = null;
        try {
            Session session = sessionfactory.getCurrentSession();
            u = (User) session.createQuery("From User where"
                    + "userID'" + userID + "'").uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return u;
    }

    public boolean checkEmail(String email) {
        Session session = sessionfactory.getCurrentSession();
        try {
            Query query = session.createQuery("from User where userEmail = :userEmail");
            query.setParameter("userEmail", email);
            User user = (User) query.getSingleResult();
            return user != null;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    public boolean checkLogin(String userName, String userPass) {
        List<User> u = null;
        try {
            Session session = sessionfactory.getCurrentSession();
            u = session.createQuery("From users where userName='" + userName + "' and userPass='" + userPass + "'").getResultList();
            if (u.size() >= 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkMail(String userEmail) {
        List<User> u = null;
        try {
            Session session = sessionfactory.getCurrentSession();
            u = session.createQuery("From users where userEmail='" + userEmail + "'").getResultList();
            if (u.size() >= 1) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User login(String userEmail, String userPass) {
        try {
            Session session = sessionfactory.getCurrentSession();
            Query query = session.createQuery("from User where userEmail = :userEmail and userPass = :userPass");
            query.setParameter("userEmail", userEmail);
            query.setParameter("userPass", userPass);
            User user = (User) query.getSingleResult();
            userloggedin = user;
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean logout(){
        try{
            userloggedin = null;
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    
    public User getuserloggedin(){
        return userloggedin;
    }
}
