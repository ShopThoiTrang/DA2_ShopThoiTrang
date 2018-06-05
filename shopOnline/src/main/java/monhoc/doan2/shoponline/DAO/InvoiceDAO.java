/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.DAO;

import java.util.Map;
import monhoc.doan2.shoponline.model.Invoice;
import monhoc.doan2.shoponline.model.InvoiceDetail;
import monhoc.doan2.shoponline.model.Product;
import monhoc.doan2.shoponline.service.ProductService;
import monhoc.doan2.shoponline.service.UserService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lsayh
 */
@Repository
public class InvoiceDAO {

    @Autowired
    SessionFactory sessionfactory;

    @Autowired
    ProductService productservice;

    @Autowired
    private UserService userservice;

    public boolean addinvoice(Map<Product, Integer> cart) {
        try {
            Session session = sessionfactory.getCurrentSession();
            Invoice invoice = new Invoice();
            invoice.setUser(userservice.getuserloggedin());
            invoice.setPrice(10000);
            session.persist(invoice);
            for (Product k : cart.keySet()) {
                InvoiceDetail newdetail = new InvoiceDetail();
                newdetail.setInvoice(invoice);
                newdetail.setProduct(k);
                newdetail.setQuantity(cart.get(k));
                session.persist(newdetail);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
