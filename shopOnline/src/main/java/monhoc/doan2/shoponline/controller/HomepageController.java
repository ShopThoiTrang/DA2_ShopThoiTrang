/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpExchange;
import monhoc.doan2.shoponline.model.Category;
import monhoc.doan2.shoponline.model.Product;
import monhoc.doan2.shoponline.model.User;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import monhoc.doan2.shoponline.service.CategoryService;
import monhoc.doan2.shoponline.service.ProductService;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import monhoc.doan2.shoponline.service.UserService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author NhutKha
 */
@Controller
public class HomepageController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/")
    public String index(ModelMap mm) {
        List<Category> categoriesList = categoryService.getAllCategory();
        for (Category ca : categoriesList) {
            System.out.println(ca.getCategoryName());
        }
        List<Product> ProductsList = productService.getProductRandom();
        mm.put("listCategory", categoriesList);
        mm.put("listProduct", ProductsList);
        return "pages/index";
    }

    @RequestMapping(value = "/contact-us")
    public String contact(ModelMap mm) {
        return "pages/contact-us";
    }

    @RequestMapping(value = "/exit")
    public String Exit(HttpSession session, HttpServletRequest request, ModelMap mm) {
        session = request.getSession();
        session.setAttribute("users", "");
        if(userService.logout())
            return "redirect:/";
        else return "redirect:/404";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String doLogin(ModelMap mm) {
        mm.put("userForm", new User());
        return "pages/account";
    }

    @RequestMapping(value = "/adminpage", method = RequestMethod.GET)
    public String adminproduct(ModelMap model, @RequestParam(value = "tenSPSearch", required=false) String tenSPSearch){
        if(tenSPSearch == null){
            model.addAttribute("listPD", productService.getProductByName(""));
        }else model.addAttribute("listPD", productService.getProductByName(tenSPSearch));
        model.addAttribute("listCate", categoryService.getAllCategory());
        return "pages/adminCatagory";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response,
            @ModelAttribute("userForm") User u, ModelMap mm, @RequestParam("action") String action) {
        if (action.equals("Login")) {
            User users = userService.login(u.getUserEmail(), u.getUserPass());
            if (users != null) {
                HttpSession session = request.getSession();
                session.setAttribute("users", users);
                session.setAttribute("login", "enable");
                if (users.isUserRole()) {
                    return "redirect:/adminpage";
                }
                // page user
                return "redirect:/";
            } else {
                // error pass or email
                mm.put("msg", "Incorrect email or password!");
                return "pages/404";
            }
        } else // register
        if (action.equals("Register")) {
            // check Email in database
            if (userService.checkMail(u.getUserEmail())) {
                HttpSession session = request.getSession();
                session.setAttribute("users", "Đã tồn tại user");
                session.setAttribute("login","disable");
                return "redirect:/404";
            } // add user
            else {
                if (u.getUserEmail().equals("") || u.getUserEmail().equals("")
                        || u.getUserPass().equals("")) {
                    return "pages/error";
                }
                User users = new User();
                users.setUserEmail(u.getUserEmail());
                users.setUserName(u.getUserName());
                users.setUserPass(u.getUserPass());
                users.setUserRole(false);
                userService.insertUser(users);
                return "redirect:/register";

            }

        }
        return "pages/error";
    }
    
    @RequestMapping(value = "/detail")
    public String getProductByID(ModelMap mm, @RequestParam("ID") int ID) {
        //mm.put("Product", productService.getProductByID(ID));
        mm.addAttribute("Product", productService.getProductByID(ID));
        return "pages/detail";
    }

    @RequestMapping(value = "/404")
    public String loi(ModelMap mm) {
        return "pages/404";
    }

    @RequestMapping(value = "/about")
    public String index7() {
        return "pages/about";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String Search(
            @RequestParam(value = "search") String se,
            @RequestParam(value = "tenSPSearch") String sp,
            ModelMap mm, HttpServletRequest request, HttpServletResponse response)
    {
        if (se.equals("search")) { 
            return "redirect:/adminpage?tenSPSearch="+sp;
        } else {
            return "pages/404";
        }
    }
    

    @RequestMapping(value = "/Deleteproduct", method = RequestMethod.POST)
    public String Delete(
            @ModelAttribute(value = "Delete") String dl,
            @ModelAttribute(value = "txtMaSPXoa") String mspx,
            ModelMap mm, HttpServletRequest request, HttpServletResponse response) {
        if (dl.equals("Delete")) {
            if (productService.deleteProduct(Integer.parseInt(mspx))) {
                return "redirect:/adminpage";
            } else {
                return "redirect:/404";
            }
        } else {
            return "pages/about";
        }
    }

    // giỏ hàng
    @RequestMapping(value = "/orderpage")
    public String OrderPage(ModelMap mm, HttpServletRequest request,
            HttpServletResponse response) {
        String itemID = request.getParameter("itemID");
        Integer productId = Integer.parseInt(itemID);
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<Product, Integer>());
        }
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        Product pd = productService.getProductByID(productId);
        Set<Product> key = cart.keySet();
        boolean ok = false;
        for (Product k : key) {
            if (k.getProductID() == pd.getProductID()) {
                int qty = cart.get(k);
                qty++;
                cart.put(k, qty);
                ok = true;
                break;
            }
        }
        if (ok == false) {
            cart.put(pd, 1);
        }
        request.getSession().setAttribute("cart", cart);
        return "pages/cart";
    }

    @RequestMapping(value = "/cartoder")
    public String OrderPage2(ModelMap mm, HttpServletRequest request,
            HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<Product, Integer>());
        }
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        request.getSession().setAttribute("cart", cart);
        return "pages/cart";
    }

    @RequestMapping(value = "/OrderPageCart")
    public String OrderPageCart(ModelMap mm, HttpServletRequest request,
            HttpServletResponse response) {
        String itemID = request.getParameter("itemID");
        Integer productId = Integer.parseInt(itemID);
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<Product, Integer>());
        }
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        Product pd = productService.getProductByID(productId);
        HashMap<Product, Integer> map = (HashMap<Product, Integer>) request.getSession().getAttribute("cart");
        if (map != null) {
            Set<Product> key = map.keySet();
            for (Product k : key) {
                if (k.getProductID() == pd.getProductID()) {
                    map.remove(k);
                    break;
                }
            }
        }
        //request.getSession().setAttribute("cart", cart);
        return "redirect:/cartoder";
    }

    @RequestMapping(value = "/addsub")
    public String addsub(ModelMap mm, HttpServletRequest request,
            HttpServletResponse response) {
        String itemID = request.getParameter("itemID");
        String add = request.getParameter("action2");
        //String sub=request.getParameter("sub");
        Integer productId = Integer.parseInt(itemID);
        HttpSession session = request.getSession();
        if (session.getAttribute("cart") == null) {
            session.setAttribute("cart", new HashMap<Product, Integer>());
        }
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        Product pd = productService.getProductByID(productId);
        Set<Product> key = cart.keySet();
        for (Product k : key) {
            if (k.getProductID() == pd.getProductID()) {
                int qty = cart.get(k);
                if (add.equals("+")) {
                    qty++;
                    cart.put(k, qty);
                    break;
                } else {
                    if (add.equals("-")) {
                        qty--;
                    }
                    cart.put(k, qty);
                    if (qty <= 0) {
                        cart.remove(k);
                    }
                }
            }
        }
        request.getSession().setAttribute("cart", cart);
        return "pages/cart";
    }

}
