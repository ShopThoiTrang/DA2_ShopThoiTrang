/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.service;

import java.util.Map;
import monhoc.doan2.shoponline.DAO.InvoiceDAO;
import monhoc.doan2.shoponline.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lsayh
 */
@Service
public class InvoiceService {
    @Autowired
    InvoiceDAO invoicedao;
    
    @Transactional
    public boolean addinvoice(Map<Product, Integer> cart) {
        return invoicedao.addinvoice(cart);
    }
}
