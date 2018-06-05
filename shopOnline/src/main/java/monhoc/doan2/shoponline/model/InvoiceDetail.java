/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author lsayh
 */
@Entity
@Table(name = "invoicedetail")
public class InvoiceDetail implements Serializable{
    
    @Id
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
    
    @Id
    @ManyToOne
    @JoinColumn(name = "invoiceid")
    private Invoice invoice;
    
    
    @Column(name = "quantity")
    private int quantity;

    public InvoiceDetail() {
        super();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
    
}
