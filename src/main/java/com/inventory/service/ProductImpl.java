package com.inventory.service;
//business layer

import java.sql.SQLException;

import com.inventory.dao.IProductDao;
import com.inventory.dao.ProductDaoImpl;
import com.inventory.model.Product;

public class ProductImpl implements IProduct {
	
	
	@Override
	public boolean registerProduct(Product product) throws SQLException{
		
        IProductDao dao=new ProductDaoImpl();
		return dao.registerProduct(product);
	}

	@Override
	public boolean searchProduct(String pname) throws SQLException{
		IProductDao dao=new ProductDaoImpl();
		return dao.searchProduct(pname);
	}

	@Override
	public boolean deleteProduct(String pname) throws SQLException {
		IProductDao dao=new ProductDaoImpl();
		return dao.deleteProduct(pname);
	}
	
	
}



