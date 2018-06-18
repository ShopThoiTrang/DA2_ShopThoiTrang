/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author NhutKha
 */
@Entity
@Table(name = "product")
public class Product implements Serializable{
 
    @Id
    @Column(name = "productID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    
    @Column(name = "productName")
    private String productName;
    
    @Column(name = "productImage")
    private String productImage;
    
    @Column(name = "productPrice")
    private double productPrice;
    
    @Column(name = "productDescription")
    private String productDescription;
    
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<InvoiceDetail> listinvoicedetail;
        
    @ManyToOne
    @JoinColumn(name = "categoryID")
    private Category category;
    
    public Product() {
        super();
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public List<InvoiceDetail> getListinvoicedetail() {
        return listinvoicedetail;
    }

    public void setListinvoicedetail(List<InvoiceDetail> listinvoicedetail) {
        this.listinvoicedetail = listinvoicedetail;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    
}
