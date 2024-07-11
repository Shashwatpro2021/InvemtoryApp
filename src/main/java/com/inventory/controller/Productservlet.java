package com.inventory.controller;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.inventory.model.Product;
import com.inventory.service.IProduct;
import com.inventory.service.ProductImpl;

/**
 * Servlet implementation class Productservlet
 */
public class Productservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Productservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String pid=request.getParameter("pid");
		String Productname=request.getParameter("pname");
		String Category=request.getParameter("cat");
		String Productprice=request.getParameter("price");
		
		//PrintWriter pw=response.getWriter();
		
		Product product=new Product(); //Created my model object
		product.setPname(Productname);
		product.setCat(Category);
		product.setPrice(Productprice);
		String pid = product.getPid();
		IProduct ProductService=new ProductImpl();
		try {
			if(ProductService.registerProduct(product)) {;
			//response.sendRedirect("final");
			RequestDispatcher rd=request.getRequestDispatcher("final");
			rd.forward(request, response);
			//request.setAttribute("pid",pid);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally{
			
		}
		
		
		try {
			ProductService.searchProduct(Productname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ProductService.deleteProduct(Productname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
