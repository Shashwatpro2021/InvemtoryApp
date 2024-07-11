package com.inventory.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.inventory.model.Product;

//dao layer-- consisting of JDBC code
public class ProductDaoImpl implements IProductDao{
	

	@Override
	public boolean registerProduct(Product product)throws SQLException{
		System.out.println("called dao impl");
		
		Connection conn=null;
		Product p1=new Product();
		
		try {
			//loading and registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root");
			if(conn!=null) {
				//System.out.println("connection is established");
				String insertQuery="Insert into product(productname,category,price) values(?,?,?)";
				System.out.println("query executed");
				PreparedStatement psmt=conn.prepareStatement(insertQuery);
				psmt.setString(1, product.getPname());
				psmt.setString(2, product.getCat());
				psmt.setString(3, product.getPrice());
				int k=psmt.executeUpdate();
				System.out.println("executed query");
				if(k>0) {
					return true;
				}
			}
			
		}catch(Exception ex){
			ex.getStackTrace();
		}finally {
			if(conn!=null) {
				conn.close();
				System.out.println("connection is closed");
			}
			
		}
		
		return false;
	}

	@Override
	public boolean searchProduct(String pname) throws SQLException {
		Connection conn=null;
		Product p1=new Product();
		
		try {
			//loading and registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root");
			if(conn!=null) {
				//System.out.println("connection is established");
				String searchQuery="select * from product where pname=?";
				System.out.println("query executed");
				PreparedStatement psmt=conn.prepareStatement(searchQuery);
				psmt.setString(1, pname);
				System.out.println("executed query");
				ResultSet rs=psmt.executeQuery();
				while(rs.next()) {
					Product product=new Product();
					product.setPname(rs.getString("Pname"));
					product.setCat(rs.getString("Cat"));
					product.setPrice(rs.getString("Price"));
					
				}
			}
			
		}catch(Exception ex){
			ex.getStackTrace();
		}finally {
			if(conn!=null) {
				conn.close();
				System.out.println("connection is closed");
			}
			
		}
		return false;
	}

	@Override
	public boolean deleteProduct(String pname) throws SQLException {
		Connection conn=null;
		Product p1=new Product();
		
		try {
			//loading and registering the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","root");
			if(conn!=null) {
				//System.out.println("connection is established");
				String deleteQuery="delete * from product where pname=?";
				System.out.println("query executed");
				PreparedStatement psmt=conn.prepareStatement(deleteQuery);
				psmt.setString(1, pname);
				int k=psmt.executeUpdate();
				System.out.println("executed query");
				if(k>0) {
					return true;
				}
			}
			
		}catch(Exception ex){
			ex.getStackTrace();
		}finally {
			if(conn!=null) {
				conn.close();
				System.out.println("connection is closed");
			}
			
		}
		return false;
	}

}
