package com.Susie.Lou.Creates.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private BigDecimal tax;
    private List<CartItem> items;

    public Cart(){
        this.items = new ArrayList<CartItem>();
        this.tax = new BigDecimal("0.00");
    }

    public Cart(List<CartItem> items)
    {
        this();
        this.items = items;
    }

    public CartItem[] getItems(){
        CartItem results[] = new CartItem[items.size()];
        return items.toArray(results);
    }

    public BigDecimal getTax(){
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getItemSubtotal(){
        BigDecimal subtotal = new BigDecimal("0.00");
        subtotal.setScale(2);
        for (CartItem item : items) {
            subtotal = subtotal.add(item.getProduct().getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return subtotal;
    }

    public BigDecimal getTotal(){
        return getItemSubtotal().add(tax);
    }

}
