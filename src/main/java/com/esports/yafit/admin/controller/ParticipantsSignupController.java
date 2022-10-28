package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.ParticipantsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Participants;
import com.google.gson.Gson;

@WebServlet("/participants-signup")
public class ParticipantsSignupController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Participants participant = new Participants();
	
	// instantiate dao object
	ParticipantsDao participantDao = new ParticipantsDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			// add set-methods for mapping: use dao file as ref
			participant.setPartName(request.getParameter("partName"));
			participant.setPartEmail(request.getParameter("partEmail"));
			participant.setPartPassword(request.getParameter("partPassword"));
			participant.setPartStreet(request.getParameter("partStreet"));
			participant.setPartCity(request.getParameter("partCity"));
			participant.setPartState(request.getParameter("partState"));
			participant.setPartCountry(request.getParameter("partCountry"));
			participant.setPartZipcode(Integer.parseInt(request.getParameter("partZipcode")));
			participant.setPartAge(Integer.parseInt(request.getParameter("partAge")));
			participant.setPartGender(request.getParameter("partGender"));
			participant.setPartImage(request.getParameter("partImage"));
			participant.setPartPhone(request.getParameter("partPhone"));
			participant.setEmergPhone(request.getParameter("emergPhone"));
			participant.setPartType(request.getParameter("partType"));
			participant.setPartActive(Integer.parseInt(request.getParameter("partActive")));
			participant.setAddedOn(new Date());
			// save data
			participantDao.save(participant);
			dto.setMessage("Participant created successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to create Participant!");
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
