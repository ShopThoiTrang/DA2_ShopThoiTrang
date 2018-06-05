/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.DAO;

import java.util.ArrayList;
import javax.persistence.Query;
import monhoc.doan2.shoponline.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NhutKha
 */
@Repository
public class CategoryDAO {

    @Autowired
    SessionFactory sessionfactory;

    public ArrayList<Category> getAllcategory() {
        Session session = sessionfactory.getCurrentSession();
        Query query = (Query) session.createQuery("from Category");
        ArrayList<Category> list = (ArrayList<Category>) query.getResultList();
        return list;
    }

    public Category getCategoryrById(int categoryId) {
        Session session = sessionfactory.getCurrentSession();
        return (Category) session.get(Category.class, categoryId);
    }
}
