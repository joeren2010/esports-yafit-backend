package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.BatchesDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Batches;
import com.google.gson.Gson;


@WebServlet("/batches-signup")
public class BatchesSignupController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Batches batch = new Batches();
	
	// instantiate dao object
	BatchesDao batchDao = new BatchesDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			// add set-methods for mapping: use dao file as ref
			batch.setBatchName(request.getParameter("batchName"));
			batch.setTrnrName(request.getParameter("trnrName"));
			batch.setTrnrId(Integer.parseInt(request.getParameter("trnrId")));
			batch.setPartName(request.getParameter("partName"));
			batch.setPartId(Integer.parseInt(request.getParameter("partId")));
			batch.setPartAge(Integer.parseInt(request.getParameter("partAge")));
			batch.setPartGender(request.getParameter("partGender"));
			batch.setPartActive(Integer.parseInt(request.getParameter("partActive")));
			batch.setAddedOn(new Date());
			// save data
			batchDao.save(batch);
			dto.setMessage("Batch created successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to create Batch!");
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
