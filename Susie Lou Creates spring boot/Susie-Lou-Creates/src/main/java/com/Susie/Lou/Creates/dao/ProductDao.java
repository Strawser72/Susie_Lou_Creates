package com.Susie.Lou.Creates.dao;

import com.Susie.Lou.Creates.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    Product getProductById(int productId);
    List<Product> getProductByName(String name);
    List<Product> getProductByGenre(String genre);
    List<Product> getProductByTags(String tags);
    List<Product> getProductByUserId(int userId);

    List<Product> getProductByOptionalSKUAndORNAme(String SKU, String name, boolean wildCard);
}
