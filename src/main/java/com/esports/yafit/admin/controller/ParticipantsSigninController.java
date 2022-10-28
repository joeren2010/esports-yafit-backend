package com.esports.yafit.admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esports.yafit.admin.dao.ParticipantsDao;
import com.esports.yafit.admin.dto.ResponseDto;
import com.esports.yafit.admin.model.Participants;
import com.google.gson.Gson;

@WebServlet("/participants-signin")
public class ParticipantsSigninController extends HttpServlet {
	// used by jvm to identify the state of an object
	private static final long serialVersionUID = 1L;
	
	// instantiate pojo object
	Participants participant = new Participants();
	
	// instantiate dao object
	ParticipantsDao participantDao = new ParticipantsDao();
	
	// create doPost method
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// add set-methods for mapping: use dao file as ref
		participant.setPartEmail(request.getParameter("partEmail"));
		participant.setPartPassword(request.getParameter("partPassword"));
		
		// instantiate response-dto object
		ResponseDto dto = new ResponseDto();
		
		//validate and save new sign-up 
		try {
			participantDao.login(participant);
			dto.setMessage("Participant sign-in successfully!");
		} 
		catch (Exception e) {
			dto.setMessage("Unable to sign-in Participant!");
			dto.setError(e.toString());
		}
		
		if(participant.getPartId() > 0) {
			dto.setData(participant);
			dto.setMessage("Participant sign-in successfully!");
		}
		else {
			dto.setMessage("Unable to sign-in Participant!");
			dto.setError("Participant does not exist");
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
