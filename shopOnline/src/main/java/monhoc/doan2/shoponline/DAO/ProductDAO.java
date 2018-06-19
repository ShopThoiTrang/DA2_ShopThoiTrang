/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.DAO;

import java.util.ArrayList;
import java.util.List;
import monhoc.doan2.shoponline.model.Product;
import java.util.Locale;
import javax.transaction.Transactional;
import monhoc.doan2.shoponline.model.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author NhutKha
 */
//phương thức lấy sản phẩm dựa theo danh mục
@Repository
public class ProductDAO {

    @Autowired
    SessionFactory sessionfactory;

    public ArrayList<Product> getAllProductByCategory(long categoryID) {
        Session session = sessionfactory.getCurrentSession();
        Query query = session.createQuery("from Product where categoryID = :categoryID");
        query.setParameter("categoryID", categoryID);
        ArrayList<Product> list = (ArrayList<Product>) query.getResultList();
        return list;
    }

    public Product getProduct(int productID) {
        Product u = new Product();
        List<Product> lp = new ArrayList<Product>();
        try {
            Session session = sessionfactory.getCurrentSession();
            String querystring = "from Product where productID = :pid";
            Query query = session.createQuery(querystring);
            query.setParameter("pid", productID);
            u = (Product)query.uniqueResult();
            return u;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Product> getProductRandom() {
        Session session = sessionfactory.getCurrentSession();
        Query query = (Query) session.createQuery("from Product order by rand()");
        query.setMaxResults(7);
        ArrayList<Product> list = (ArrayList<Product>) query.getResultList();
        return list;
    }

    public boolean insertProduct(Product product) {
        try {
            Session session = sessionfactory.getCurrentSession();
            session.persist(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean ModifyProduct(Product product) {
        try {

            Session session = sessionfactory.getCurrentSession();
            session.update(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("false cai j đó");
            return false;
        }
    }
/*
    @Transactional
    public boolean updateProduct(Product product) {
        try {
            Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            //session.beginTransaction();
            //session.beginTransaction();
            //session.update(product);
            //session.getTransaction().commit();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("update product set productPrice = :stockName, productName = :productName,productImage = :productImage"
                    + " where productID = :productID");
            query.setDouble("stockName", product.getProductPrice());
            query.setInteger("productID", (int) product.getProductID());
            query.setString("productName", product.getProductName());
            query.setString("productImage", product.getProductImage());
            query.executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println("iiiiiiiiiiiiiiiiiiiiiiii");
            e.printStackTrace();
        }
        return false;
    }

    

    public Product getProductById(int productId) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        return (Product) session.get(Product.class, productId);
    }
*/
    public ArrayList<Product> getProductByName(String productName) {
        //
        Session session = sessionfactory.getCurrentSession();
        Query query;
        String string = new String(productName);        
        if(string.trim().equals("")){
            query = session.createQuery("from Product where productname = productName");
        }
        else{
            query = session.createQuery("from Product where productname = :productName");
            query.setParameter("productName", productName);
        }
        ArrayList<Product> list = (ArrayList<Product>) query.getResultList();
        return list;
    }

    @Transactional
    //@Modifying
    public boolean deleteProduct(int productId) {
        try {
            Session session = sessionfactory.getCurrentSession();
            Query query = (Query) session.createQuery("delete from Product where productID = '" + productId + "'");
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
