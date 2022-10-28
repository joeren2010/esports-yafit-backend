package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.TrainersDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Trainers;
import com.google.gson.Gson;


@WebServlet("/trainers-signup")
public class TrainersSignupController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Trainers trainer = new Trainers();
	
	// instantiate dao object
	TrainersDao trainerDao = new TrainersDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			// add set-methods for mapping: use dao file as ref
			trainer.setTrnrName(request.getParameter("trnrName"));
			trainer.setTrnrEmail(request.getParameter("trnrEmail"));
			trainer.setTrnrPassword(request.getParameter("trnrPassword"));
			trainer.setTrnrStreet(request.getParameter("trnrStreet"));
			trainer.setTrnrCity(request.getParameter("trnrCity"));
			trainer.setTrnrState(request.getParameter("trnrState"));
			trainer.setTrnrZipcode(Integer.parseInt(request.getParameter("trnrZipcode")));
			trainer.setTrnrAge(Integer.parseInt(request.getParameter("trnrAge")));
			trainer.setTrnrGender(request.getParameter("trnrGender"));
			trainer.setTrnrImage(request.getParameter("trnrImage"));
			trainer.setTrnrPhone(request.getParameter("trnrPhone"));
			trainer.setTrnrTitle(request.getParameter("trnrTitle"));
			trainer.setTrnrRating(Integer.parseInt(request.getParameter("trnrRating")));
			trainer.setTrnrActive(Integer.parseInt(request.getParameter("trnrActive")));
			trainer.setAddedOn(new Date());
			// save data
			trainerDao.save(trainer);
			dto.setMessage("Trainer created successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to create Trainer!");
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
