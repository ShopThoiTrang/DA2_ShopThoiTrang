/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.service;

import monhoc.doan2.shoponline.DAO.ProductDAO;
import java.util.ArrayList;
import monhoc.doan2.shoponline.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NhutKha
 */
@Service
public class ProductService {

    @Autowired
    ProductDAO productDAO;

    @Transactional
    //lấy danh sách sản phẩm dựa vào mã danh mục
    public ArrayList<Product> getAllProductByCategory(long categoryID) {
        return productDAO.getAllProductByCategory(categoryID);
    }

    @Transactional
    //lấy danh sách 7 sản phẩm ngẫu nhiên
    public ArrayList<Product> getProductRandom() {
        return productDAO.getProductRandom();
    }

    @Transactional
    public Product getProductByID(int productID) {
        return productDAO.getProductByID(productID);
    }
    @Transactional
    public ArrayList<Product> getProductByName(String productName) {
        return productDAO.getProductByName(productName);
    }
    @Transactional
    public boolean insertProduct(Product product) {
        return productDAO.insertProduct(product);
    }

    @Transactional
    public boolean ModifyProduct(Product product) {
        return productDAO.ModifyProduct(product);
    }

    @Transactional
    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }
    
}
