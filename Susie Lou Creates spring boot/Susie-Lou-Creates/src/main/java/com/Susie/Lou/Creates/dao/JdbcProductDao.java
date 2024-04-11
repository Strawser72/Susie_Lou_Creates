package com.Susie.Lou.Creates.dao;

import com.Susie.Lou.Creates.exception.DaoException;
import com.Susie.Lou.Creates.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private final JdbcTemplate jdbcTemplate;
    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product ORDER BY genre ASC";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while(results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        }catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) {
        Product product = null;
        String sql = "SELECT * FROM product WHERE product_id =?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productId);
            while (results.next()) {
                return mapRowToProduct(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return product;
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE name LIKE? ORDER BY genre ASC";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        }catch(CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductByGenre(String genre) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE genre =? ORDER BY genre ASC";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, genre);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductByTags(String tags) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE tags LIKE? ORDER BY genre ASC";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, "%" + tags + "%");
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductByUserId(int userId) {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM product WHERE user_id =? ORDER BY genre ASC";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            while (results.next()) {
                Product product = mapRowToProduct(results);
                products.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return products;
    }

    @Override
    public List<Product> getProductByOptionalSKUAndORNAme(String SKU, String name, boolean wildCard) {
        List<Product> list = new ArrayList<>();
        if (wildCard) {
            name = "%" + (name == null ? "" : name) + "%";
        }
            boolean checkSku = SKU != null && SKU.trim().length() > 0;

            String sql = "SELECT * FROM product WHERE name ILIKE ? " + (checkSku ? " AND SKU ILIKE? " : "") + " ORDER BY genre ASC";
        try {
            SqlRowSet results;
            if(checkSku){
                results = jdbcTemplate.queryForRowSet(sql, name, SKU);
            }else {
                results = jdbcTemplate.queryForRowSet(sql, name);
            }
            while (results.next()) {
                Product product = mapRowToProduct(results);
                list.add(product);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return list;
    }

    private Product mapRowToProduct(SqlRowSet results) {
        Product product = new Product();
        product.setProductId(results.getInt("product_id"));
        product.setName(results.getString("name"));
        product.setPrice(results.getBigDecimal("price"));
        product.setSKU(results.getString("SKU"));
        product.setGenre(results.getString("genre"));
        product.setQuantity(results.getInt("quantity"));
        product.setDescription(results.getString("description"));
        product.setImageName(results.getString("image name"));
        product.setTags(results.getString("tags"));
        return product;
    }
}
