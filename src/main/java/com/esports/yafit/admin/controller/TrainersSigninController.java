package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.TrainersDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Trainers;
import com.google.gson.Gson;


@WebServlet("/trainers-signin")
public class TrainersSigninController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Trainers trainer = new Trainers();
	
	// instantiate dao object
	TrainersDao trainerDao = new TrainersDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// add set-methods for mapping: use dao file as ref
		trainer.setTrnrEmail(request.getParameter("trnrEmail"));
		trainer.setTrnrPassword(request.getParameter("trnrPassword"));
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			trainerDao.login(trainer);
			dto.setMessage("Trainer sign-in successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to sign-in Trainer!");
			dto.setError(e.toString());
		}
		
		if(trainer.getTrnrId() > 0) {
			dto.setData(trainer);
			dto.setMessage("Trainer sign-in successfully!");
		}
		else {
			dto.setMessage("Unable to sign-in Trainer!");
			dto.setError("Trainer does not exist");
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
