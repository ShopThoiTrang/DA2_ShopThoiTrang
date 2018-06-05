/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monhoc.doan2.shoponline.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author lsayh
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceid;
            
    @ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceDetail> invoicedetail;
    
    @Column
    private int price;

    public Invoice() {
        super();
    }

    public int getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(int invoiceid) {
        this.invoiceid = invoiceid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<InvoiceDetail> getInvoicedetail() {
        return invoicedetail;
    }

    public void setInvoicedetail(List<InvoiceDetail> invoicedetail) {
        this.invoicedetail = invoicedetail;
    }
    
    
}
