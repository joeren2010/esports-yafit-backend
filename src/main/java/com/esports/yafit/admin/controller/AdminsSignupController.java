package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.AdminsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Admins;
import com.google.gson.Gson;


@WebServlet("/admins-signup")
public class AdminsSignupController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Admins admin = new Admins();
	
	// instantiate dao object
	AdminsDao adminDao = new AdminsDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// add set-methods for mapping: use dao file as ref
		admin.setAdminName(request.getParameter("adminName"));
		admin.setAdminEmail(request.getParameter("adminEmail"));
		admin.setAdminPassword(request.getParameter("adminPassword"));
		admin.setLoginType(1);
		admin.setAddedOn(new Date());
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			adminDao.save(admin);
			dto.setMessage("Admin user created successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to create Admin user!");
			dto.setError(e.toString());
		}
		
		// printing or displaying the response
		String jsonResponse = new Gson().toJson(dto);	//convert java object to json string
		PrintWriter out = response.getWriter();  		//instantiate print-writer object called "out"
		response.setContentType("application/json");  	//sets the content type of the response sent to client
		response.setCharacterEncoding("UTF-8");  		//sets the character encoding of the response sent to client
		out.print(jsonResponse);  						//displays json string as text
		out.flush();  									//clears all elements from the print-writer stream 
	}
}
