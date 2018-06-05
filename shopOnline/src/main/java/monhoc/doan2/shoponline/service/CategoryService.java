/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.service;

import monhoc.doan2.shoponline.DAO.CategoryDAO;
import java.util.ArrayList;
import monhoc.doan2.shoponline.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author NhutKha
 */
@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    //lấy danh sách tất cả danh mục sản phẩm
    @Transactional
    public ArrayList<Category> getAllCategory() {
        return categoryDAO.getAllcategory();
    }

    @Transactional
    public Category getCategoryrById(int categoryId) {
        return categoryDAO.getCategoryrById(categoryId);
    }
}
