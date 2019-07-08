package com.blackwater.Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_sale")
public class ProductSale implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    @Id
    @ManyToOne
    @JoinColumn(name = "sale_id")
    private Sale sale;

    @Column(name = "amount")
    private int amount;

    @Column(name = "productPrice")
    private float productPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
}
