/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import monhoc.doan2.shoponline.model.Invoice;
import monhoc.doan2.shoponline.model.Product;
import monhoc.doan2.shoponline.service.CategoryService;
import monhoc.doan2.shoponline.service.InvoiceService;
import monhoc.doan2.shoponline.service.ProductService;
import monhoc.doan2.shoponline.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author lsayh
 */
@Controller
public class editcontroller {

    @Autowired
    private ProductService productservice;
    @Autowired
    private CategoryService categoryservice;
    @Autowired
    private InvoiceService invoiceservice;

    @PostMapping("/themsanpham")
    public String themsanpham(Model model, @RequestParam("txtTenSPThem") String tensanpham,
            @RequestParam("txtLoaiSPThem") String loaisanpham, @RequestParam("txtDonGiaThem") String dongia,
            @RequestParam("txtMoTaThem") String mota, @RequestParam("txtAnhThem") MultipartFile fileupload,
            HttpServletRequest request) throws IOException {

        try {
            Product newproduct = new Product();
            if (!fileupload.isEmpty()) {
                newproduct.setProductImage(fileupload.getOriginalFilename());
            }
            newproduct.setCategory(categoryservice.getCategoryrById(Integer.parseInt(loaisanpham)));
            newproduct.setProductDescription(mota);
            newproduct.setProductName(tensanpham);
            newproduct.setProductPrice(Double.parseDouble(dongia));
            if (productservice.insertProduct(newproduct)) {
                System.out.println("success");
                if (!fileupload.isEmpty()) {
                    byte[] bytes = fileupload.getBytes();
                    String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/shop/";
                    File file = new File(path + fileupload.getOriginalFilename());
                    fileupload.transferTo(file);
                }
            } else {
                System.out.println("false");
            }
            return "redirect:/adminpage";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:/404";
        }
    }
    
    @PostMapping("/suasanpham")
    public String suasanpham(Model model, @RequestParam("txtMaSPSua") String MaSP, @RequestParam("txtTenSPSua") String tensanpham,
            @RequestParam("txtLoaiSPSua") String loaisanpham, @RequestParam("txtDonGiaSua") String dongia,
            @RequestParam("txtMoTaSua") String mota, @RequestParam("txtAnhSua") MultipartFile fileupload,
            HttpServletRequest request) throws IOException {
        
        try {
            System.out.println(MaSP);
            System.out.println(tensanpham);
            System.out.println(loaisanpham);
            System.out.println(dongia);
            System.out.println(mota);
            Product modifyproduct = productservice.getProductByID(Integer.parseInt(MaSP));
            if (!fileupload.isEmpty()) {
                modifyproduct.setProductImage(fileupload.getOriginalFilename());
            }
            modifyproduct.setCategory(categoryservice.getCategoryrById(Integer.parseInt(loaisanpham)));
            modifyproduct.setProductDescription(mota);
            modifyproduct.setProductName(tensanpham);
            modifyproduct.setProductPrice(Double.parseDouble(dongia));
            if (productservice.ModifyProduct(modifyproduct)) {
                System.out.println("success");
                if (!fileupload.isEmpty()) {
                    byte[] bytes = fileupload.getBytes();
                    String path = request.getSession().getServletContext().getRealPath("/") + "resources/images/shop/";
                    File file = new File(path + fileupload.getOriginalFilename());
                    fileupload.transferTo(file);
                }
            } else {
                System.out.println("false");
            }
            return "redirect:/adminpage";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:/404";
        }
    }
    
    @PostMapping("/thanhtoan")
    public @ResponseBody String thanhtoan(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<Product,Integer> cart = (Map<Product,Integer>) session.getAttribute("cart");
        if(cart != null){
            if(invoiceservice.addinvoice(cart))
                return "{\"result\":\"success\"}";
        }
        return "{\"result\":\"false\"}";
    }
}
