package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.esports.yafit.admin.dao.AdminsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Admins;


@WebServlet("/admins-crud")
public class AdminsCrudController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Admins admin = new Admins();
	
	// instantiate dao object
	AdminsDao adminDao = new AdminsDao();
	
	// create doGet method
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// create id as a request parameter
		String id = request.getParameter("id");
		
		// map admins object list
		List<Admins> adminList = new ArrayList<Admins>();

		// add and validate list
		if (id != null) {
			Admins admin = adminDao.getOne(Long.parseLong(id));
			adminList.add(admin);
		} 
		else {
			adminList = adminDao.getAll();
		}
		
		// printing or displaying the response
		String jsonResponse = new Gson().toJson(adminList);	//convert java object to json string
		PrintWriter out = response.getWriter();  		//instantiate print-writer object called "out"
		response.setContentType("application/json");  	//sets the content type of the response sent to client
		response.setCharacterEncoding("UTF-8");  		//sets the character encoding of the response sent to client
		out.print(jsonResponse);  						//displays json string as text
		out.flush();  									//clears all elements from the print-writer stream 
	}
	
	
	// create doPut method
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and update info 
		try {
			// add set-methods for mapping: use dao file as ref
			admin.setAdminId(Integer.parseInt(request.getParameter("adminId")));
			admin.setAdminName(request.getParameter("adminName"));
			admin.setAdminEmail(request.getParameter("adminEmail"));
			admin.setAdminPassword(request.getParameter("adminPassword"));
			//admin.setLoginType(2);
			admin.setLoginType(Integer.parseInt(request.getParameter("loginType")));
			admin.setAddedOn(new Date());
			// update data
			adminDao.update(admin);
			dto.setMessage("Admin updated successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to update Admin!");
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
	
	
	// create doDelete method
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// create id as a request parameter
		String id = request.getParameter("id");
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and delete info 
		try {
			adminDao.delete(Integer.parseInt(id));
			dto.setMessage("Admin deleted successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to delete Admin!");
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
