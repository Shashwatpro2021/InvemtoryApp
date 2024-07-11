package com.inventory.dao;

import java.sql.SQLException;

import com.inventory.model.Product;

//import com.inventory.model.Product;

public interface IProductDao {
	
	boolean registerProduct(Product product) throws SQLException;
	boolean searchProduct(String pname) throws SQLException;
	boolean deleteProduct(String pname) throws SQLException;

}
