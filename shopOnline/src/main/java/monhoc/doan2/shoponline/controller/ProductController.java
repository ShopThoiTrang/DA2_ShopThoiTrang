/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.controller;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import monhoc.doan2.shoponline.model.Category;
import monhoc.doan2.shoponline.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import monhoc.doan2.shoponline.service.CategoryService;
import monhoc.doan2.shoponline.service.ProductService;

/**
 *
 * @author NhutKha
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/list")
    public String getlistProductBycategory(ModelMap mm, @RequestParam long categoryID) {
        mm.put("listProduct", productService.getAllProductByCategory(categoryID));
        mm.put("listCategory", categoryService.getAllCategory());
        return "pages/product";
    }

    @RequestMapping(value = "/list1")
    public String index(ModelMap mm, @RequestParam long categoryId) {
        //mm.put("listBrand", brandService.getAllbrand());
        mm.put("listProduct", productService.getAllProductByCategory(categoryId));
        mm.put("listCategory", categoryService.getAllCategory());
        return "pages/product";
    }

    @RequestMapping(value = "/list2")
    public String index1(ModelMap mm, @RequestParam long brandId) {
        //mm.put("listBrand", brandService.getAllbrand());
        //mm.put("listProduct", productService.getAllProductByBrand(brandId));
        mm.put("listCategory", categoryService.getAllCategory());
        return "pages/product";
    }

    @RequestMapping(value = "/detail")
    public String index3(ModelMap mm, @RequestParam long productId) {
        //mm.put("listBrand", brandService.getAllbrand());
        mm.put("product", productService.getProductByID((int) productId));
        mm.put("listCategory", categoryService.getAllCategory());
        return "pages/detail";
    }
/*
    //trang sanpham.html với phương thức là post
    @RequestMapping(method = RequestMethod.POST)
    //@ModelAttribute: lấy gía trị từ form ra
    public String xulydangki(@ModelAttribute(value = "tenSPSearch") String sp,
            @ModelAttribute(value = "btnaction") String action,
            @ModelAttribute(value = "txtTenSPThem") String tspt,
            @ModelAttribute(value = "txtMaTGThem") String tgt,
            @ModelAttribute(value = "txtLoaiSPThem") String lspt,
            @ModelAttribute(value = "txtDonGiaThem") String dgt,
            @ModelAttribute(value = "txtMoTaThem") String mtt,
            @ModelAttribute(value = "txtMaSPSua") String msps,
            @ModelAttribute(value = "txtTenSPSua") String tsps,
            @ModelAttribute(value = "txtMaTGSua") String tgs,
            @ModelAttribute(value = "txtLoaiSPSua") String lsps,
            @ModelAttribute(value = "txtDonGiaSua") String dgs,
            @ModelAttribute(value = "txtAnh") String anh,
            @ModelAttribute(value = "txtClickAnh") String as,
            @ModelAttribute(value = "txtMoTaSua") String mts,
            @ModelAttribute(value = "txtMaSPXoa") String mspx,
            ModelMap mm,
            HttpServletRequest request,
            HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        mm.put("listProduct", productService.getProductByName(""));
        //mm.put("listBrand", brandService.getAllbrand());
        mm.put("listCategory", categoryService.getAllCategory());

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        //lấy ảnh được chọn để thêm
        MultipartFile multipartFile = multipartRequest.getFile("txtAnhThem");
        //lấy ảnh được chọn để sửa
        MultipartFile multipartFile2 = multipartRequest.getFile("txtAnhSua");

        String anhThem = "";
        //đưa 1 đối tượng vào form. addAttribute
        //	mm.put("dssp", sp1.laySPTheoTen(sp));	

        //nếu người dùng nhấp nút thêm trên trang sản phẩm
        if (action.equals("Thêm")) {
            try {

                //lấy ảnh được upload
                MultipartFile filea = multipartFile;

                InputStream inputStream = null;
                OutputStream outputStream = null;
                if (filea.getSize() > 0) {
                    inputStream = filea.getInputStream();
                    @SuppressWarnings("deprecation")
                    String path = request.getRealPath("/");
                    outputStream = new FileOutputStream(path + "\\images"
                            + filea.getOriginalFilename());
                    anhThem = ".\\images" + filea.getOriginalFilename();
                    int readBytes = 0;
                    byte[] buffer = new byte[8192];
                    while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
                        outputStream.write(buffer, 0, readBytes);
                    }
                    outputStream.close();
                    inputStream.close();
                }

                //tạo biến sản phẩm để thêm
                Product sanphamthem = new Product();
                sanphamthem.setProductName(tspt);

                //Brand brand = brandService.getBrandById(Long.parseLong(tgt));
                //sanphamthem.setBrand(brand);
                Category category = categoryService.getCategoryrById(Integer.parseInt(lspt));
                sanphamthem.setCategory(category);

                sanphamthem.setProductPrice(Double.parseDouble(dgt));

                sanphamthem.setProductDescription(mtt);
                sanphamthem.setProductImage1(anhThem);
                System.out.println("12");
                //nếu thêm thành công trả về trang sanpham
                if (productService.insertProduct(sanphamthem)) {
                    mm.put("dssp", productService.getProductByName(""));
                    return "pages/product";
                } //nếu thêm thất bại trả về trang lỗi
                else {
                    return "pages/404";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            ////nếu người dùng nhấp nút cập nhật trên form sửa sản phẩm
            if (action.equals("Cập nhật")) {
                //nếu như không sửa ảnh thì lưu lại ảnh cũ
                if (as.equals("False")) {
                    Product sanphamsua = new Product();

                    sanphamsua.setProductID(Integer.parseInt(msps));
                    sanphamsua.setProductName(tsps);
                    System.out.println("1");

                    //Brand brand = brandService.getBrandById(Integer.parseInt(tgs));
                    //sanphamsua.setBrand(brand);
                    System.out.println("2");

                    Category category = categoryService.getCategoryrById(Integer.parseInt(lsps));;
                    sanphamsua.setCategory(category);
                    System.out.println("3");

                    sanphamsua.setProductPrice(Double.parseDouble(dgs));

                    sanphamsua.setProductDescription(mts);
                    sanphamsua.setProductImage1(anh);
                    System.out.println("5");

                    //System.out.println("12");
                    if (productService.updateProduct(sanphamsua)) {
                        System.out.println("vô 1");
                        mm.put("dssp", productService.getProductRandom());
                        System.out.println("vô 2");
                        return "pages/adminCatagory";
                    } else {
                        System.out.println("lỗi 1");
                        return "pages/404";
                    }
                } //nếu có chọn ảnh khác khi sửa
                else {
                    String anhsua = "";
                    try {
                        System.out.println("vô rồi nè");
                        MultipartFile filea = multipartFile2;

                        InputStream inputStream = null;
                        OutputStream outputStream = null;
                        if (filea.getSize() > 0) {
                            inputStream = filea.getInputStream();
                            @SuppressWarnings("deprecation")
                            String path = request.getRealPath("/");
                            outputStream = new FileOutputStream(path + "\\images"
                                    + filea.getOriginalFilename());
                            anhsua = ".\\images" + filea.getOriginalFilename();
                            int readBytes = 0;
                            byte[] buffer = new byte[8192];
                            while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
                                outputStream.write(buffer, 0, readBytes);
                            }
                            outputStream.close();
                            inputStream.close();
                        }
                        Product sanphamsua = new Product();

                        sanphamsua.setProductID(Integer.parseInt(msps));
                        sanphamsua.setProductName(tsps);
                        System.out.println("1");

                        //Brand brand = brandService.getBrandById(Integer.parseInt(tgs));
                        //sanphamsua.setBrand(brand);
                        System.out.println("2");

                        Category category = categoryService.getCategoryrById(Integer.parseInt(lsps));;
                        sanphamsua.setCategory(category);
                        System.out.println("3");

                        sanphamsua.setProductPrice(Double.parseDouble(dgs));

                        sanphamsua.setProductDescription(mts);
                        sanphamsua.setProductImage1(anh);
                        System.out.println("5");

                        //System.out.println("12");
                        if (productService.updateProduct(sanphamsua)) {
                            System.out.println("vô 1");
                            mm.put("listProduct", productService.getProductRandom());
                            System.out.println("vô 2");
                            return "pages/adminCatagory";
                        } else {
                            System.out.println("lỗi 3");
                            return "pages/404";
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Lỗi 3");
                        return "pages/404";
                    }
                }
            } else //nếu người dùng nhấp xóa thêm form xóa sản phẩm
            if (action.equals("Xóa")) {
                if (productService.deleteProduct(Integer.parseInt(mspx))) {
                    mm.put("listProduct", productService.getProductRandom());
                    return "pages/adminCatagory";
                } else {
                    return "pages/404";
                }
            } //click nút search hoặc các trường hợp khác
            else {
                mm.put("listProduct", productService.getProductByName(sp));
            }
        }
        return "pages/adminCatagory";
    }
*/
}
